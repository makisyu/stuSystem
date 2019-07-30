package com.msr.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.msr.entity.Authority;
import com.msr.entity.Menu;
import com.msr.entity.Role;
import com.msr.entity.User;
import com.msr.service.AuthorityService;
import com.msr.service.LogService;
import com.msr.service.MenuService;
import com.msr.service.RoleService;
import com.msr.service.UserService;
import com.msr.util.ClientIpUtil;
import com.msr.util.CpachaUtil;
import com.msr.util.MenuUtil;
import com.msr.util.StringUtil;

/**
 * 系统操作类控制器
 *
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private LogService logService;
	
	/**
	 * 系统登录后的主页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView model,HttpServletRequest request){
		List<Menu> userMenus = (List<Menu>)request.getSession().getAttribute("userMenus");
		model.addObject("topMenuList", MenuUtil.getAllTopMenu(userMenus));
		model.addObject("secondMenuList", MenuUtil.getAllSecondMenu(userMenus));
		model.setViewName("system/index");
		return model;//WEB-INF/views/+system/index+.jsp = WEB-INF/views/system/index.jsp
	}
	
	/**
	 * 系统登录后的欢迎页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView welcome(ModelAndView model,HttpServletRequest request){

		User user = (User)request.getSession().getAttribute("admin");
		
		if(user.getRoleId() == 3) {
			//学生
			return new ModelAndView("redirect:/admin/attendance/sign");
		}
			//非学生
			model.setViewName("system/welcome");
			return model;
	}
	/**
	 * 登陆页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView model,HttpServletRequest request){
		model.setViewName("system/login");
		return model;
	}
	
	/**
	 * 跳转到mac页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/mac",method=RequestMethod.GET)
	public ModelAndView mac(ModelAndView model,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("admin");
		
		if(user.getRoleId()!=3) {
			model.setViewName("system/index");
			return model;
		}
		model.setViewName("system/mac");
		return model;
	}
	
	/**
	 * 处理mac
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/mac",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getMac(HttpServletRequest request,String macCode){
		Map<String, String> ret = new HashMap<String, String>();
		
		User user = (User)request.getSession().getAttribute("admin");
		if(!macCode.equals(ClientIpUtil.getMACAddress(request.getRemoteAddr()))) {
			ret.put("type", "warning");
			ret.put("msg", "输入的MAC地址有误！！！");
			return ret;
		}
		
		user.setMacCode(macCode);
		
		if(userService.saveMac(user)<0) {
			ret.put("type", "error");
			ret.put("msg", "NO");
			return ret;
		}
		
		ret.put("type", "success");
		ret.put("msg", "OK");
		return ret;
	}
	
	
	/**
	 * 登录表单提交处理控制器
	 * @param user
	 * @param cpacha
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginAct(User user,String cpacha,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		if(user == null){
			ret.put("type", "error");
			ret.put("msg", "请填写用户信息！");
			return ret;
		}
		/*if(StringUtils.isEmpty(cpacha)){
			ret.put("type", "error");
			ret.put("msg", "请填写验证码！");
			return ret;
		}*/
		if(StringUtils.isEmpty(user.getUsername())){
			ret.put("type", "error");
			ret.put("msg", "请填写用户名！");
			return ret;
		}
		if(StringUtils.isEmpty(user.getPassword())){
			ret.put("type", "error");
			ret.put("msg", "请填写密码！");
			return ret;
		}
		/*Object loginCpacha = request.getSession().getAttribute("loginCpacha");
		if(loginCpacha == null){
			ret.put("type", "error");
			ret.put("msg", "会话超时，请刷新页面！");
			return ret;
		}
		if(!cpacha.toUpperCase().equals(loginCpacha.toString().toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "验证码错误！");
			logService.add("用户名为"+user.getUsername()+"的用户登录时输入验证码错误!");
			return ret;
		}*/
		User findByUsername = userService.findByUsername(user.getUsername());
		if(findByUsername == null){
			ret.put("type", "error");
			ret.put("msg", "该用户名不存在！");
			logService.add("登录时，用户名为"+user.getUsername()+"的用户不存在!");
			return ret;
		}
		if(!user.getPassword().equals(findByUsername.getPassword())){
			ret.put("type", "error");
			ret.put("msg", "密码错误！");
			logService.add("用户名为"+user.getUsername()+"的用户登录时输入密码错误!");
			return ret;
		}
		
		
		//说明用户名密码及验证码都正确
		//此时需要查询用户的角色权限
		Role role = roleService.find(findByUsername.getRoleId());
		List<Authority> authorityList = authorityService.findListByRoleId(role.getId());//根据角色获取权限列表
		String menuIds = "";
		for(Authority authority:authorityList){
			menuIds += authority.getMenuId() + ",";
		}
		if(!StringUtils.isEmpty(menuIds)){
			menuIds = menuIds.substring(0,menuIds.length()-1);
		}
		List<Menu> userMenus = menuService.findListByIds(menuIds);
		//把角色信息、菜单信息放到session中
		request.getSession().setAttribute("admin", findByUsername);
		request.getSession().setAttribute("role", role);
		request.getSession().setAttribute("userMenus", userMenus);
		ret.put("type", "success");
		ret.put("msg", "登录成功！");
		logService.add("用户名为{"+user.getUsername()+"}，角色为{"+role.getName()+"}的用户登录成功!");
		
		/*if(findByUsername.getLoginCode() == 0){//用户首次登录
			ret.put("loginCode", "warning");
			return ret;
		}
		
		if(findByUsername.getRoleId()==3) {//如果是学生，则需要验证MAC值
			if(StringUtil.isEmpty(findByUsername.getMacCode())){//MAC未激活
				ret.put("macCode", "warning");
				return ret;
			}else {
				//用户已激活，获取mac值
				String userMacCode = ClientIpUtil.getMACAddress(request.getRemoteAddr());
				String regMacCode = findByUsername.getMacCode();
				if(!userMacCode.equals(regMacCode)) {
					ret.put("eqMac", "warning");
				}
			}
		}*/
		return ret;
	}
	
	/**
	 * 后台退出注销功能
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("admin", null);
		session.setAttribute("role", null);
		request.getSession().setAttribute("userMenus", null);
		return "redirect:login";
	}
	
	/**
	 * 修改密码页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/edit_password",method=RequestMethod.GET)
	public ModelAndView editPassword(ModelAndView model){
		model.setViewName("system/edit_password");
		return model;
	}
	
	@RequestMapping(value="/edit_password",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> editPasswordAct(String newpassword,String oldpassword,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(newpassword)){
			ret.put("type", "error");
			ret.put("msg", "请填写新密码！");
			return ret;
		}
		User user = (User)request.getSession().getAttribute("admin");
		if(!user.getPassword().equals(oldpassword)){
			ret.put("type", "error");
			ret.put("msg", "原密码错误！");
			return ret;
		}
		user.setPassword(newpassword);
		user.setLoginCode(1);
		if(userService.editPassword(user) <= 0){
			ret.put("type", "error");
			ret.put("msg", "密码修改失败，请联系管理员！");
			return ret;
		}
		if(StringUtil.isEmpty(user.getMacCode())){
			ret.put("mac", "warning");
		}
		
		
		ret.put("type", "success");
		ret.put("msg", "密码修改成功！");
		logService.add("用户名为{"+user.getUsername()+"}，的用户成功修改密码!");
		return ret;
	} 
	
	/**
	 * 本系统所有的验证码均采用此方法
	 * @param vcodeLen
	 * @param width
	 * @param height
	 * @param cpachaType:用来区别验证码的类型，传入字符串
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/get_cpacha",method=RequestMethod.GET)
	public void generateCpacha(
			@RequestParam(name="vl",required=false,defaultValue="4") Integer vcodeLen,
			@RequestParam(name="w",required=false,defaultValue="100") Integer width,
			@RequestParam(name="h",required=false,defaultValue="30") Integer height,
			@RequestParam(name="type",required=true,defaultValue="loginCpacha") String cpachaType,
			HttpServletRequest request,
			HttpServletResponse response){
		CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen, width, height);
		String generatorVCode = cpachaUtil.generatorVCode();
		request.getSession().setAttribute(cpachaType, generatorVCode);
		BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
		try {
			ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.msr.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.msr.util.StringUtil;

/**
 * 
 */

public class DateConverter implements Converter<String, Date> {
	@Override
	public Date convert(String source) {
		if(StringUtil.isEmpty(source)) {
			return null;
		}
		
		// 实现将字符串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}

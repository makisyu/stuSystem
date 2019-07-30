package util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * java获取mac和机器码，注册码的实现
 * 
 */
public class AuthorizationUtils {
	public static void main(String[] args) throws UnknownHostException, SocketException {
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println("亲测有效" + what("192.168.11.55"));
	}

	public static String what(String ip) throws SocketException, UnknownHostException {
		NetworkInterface ne = NetworkInterface.getByInetAddress(InetAddress.getByName("192.168.11.96"));
		byte[] mac = ne.getHardwareAddress();
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			// 字节转换为整数
			int temp = mac[i] & 0xff;
			String str = Integer.toHexString(temp);
			System.out.println("每8位:" + str);
			if (str.length() == 1) {
				sb.append("0" + str);
			} else {
				sb.append(str);
			}
		}
		return sb.toString().toUpperCase();
	}
}
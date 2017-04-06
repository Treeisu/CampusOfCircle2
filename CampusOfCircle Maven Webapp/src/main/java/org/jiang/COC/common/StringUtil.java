package org.jiang.COC.common;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.DigestUtils;

public class StringUtil {
	
	
	public static boolean isNum(String string){
		Pattern pattern = Pattern.compile("[1-9]{1}\\d*");
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}
	/**
	 * 获取字符串的MD5
	 * @param str
	 * @param slat
	 * @return
	 */
	public static String getMd5(String str, String slat) {
		String base = str + "/" + slat;

		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
	
	/**
	 * 生成指定位数的随机数
	 * @param len
	 * @return
	 */
	public static String getRandom(long len) {

		int ans = 0;
		while(Math.log10(ans) + 1 < len) {
			ans = (int) (Math.random() * Math.pow(10, len));
		}
		return Integer.toString(ans);
	}
	
}

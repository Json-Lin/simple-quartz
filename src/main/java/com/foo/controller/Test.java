package com.foo.controller;

/**
 * <p>Description: </p>
 * @author JiaSonglin
 * @version V1.0,2017年1月10日 下午5:09:01
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<5;i++){
			sb.append("qwe"+"、");
		}
		String str = sb.substring(0, sb.length()-1);
		System.out.println(sb.toString());
		System.out.println(str);
	}

}

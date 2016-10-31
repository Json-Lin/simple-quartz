package com.foo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author JiaSonglin
 * @version 1.0 2016-9-30
 */
public class FileUtils {
	
	public static void write(List<String> writeList,File to) throws IOException{
		FileWriter fw = new FileWriter(to);
		StringBuffer sb = new StringBuffer();
		String lineSeparator = java.security.AccessController.doPrivileged(
	            new sun.security.action.GetPropertyAction("line.separator"));
		for(String str : writeList){
			sb.append(str+lineSeparator);
		}
		fw.write(sb.toString());
		fw.flush();
		fw.close();
	}
	
	public static void write(List<String> writeList,String filePath){
		File to = new File(filePath);
		write(writeList,filePath);
	}

	
	public static void main(String[] args) throws IOException {
		String readText = "c:/21.txt";
		String writeText = "";
		FileReader reader = new FileReader(readText);
		BufferedReader rb = new BufferedReader(reader);
		String line = "";
		int[] sub = new int[200];
		int times = 0;
		BigDecimal orders = BigDecimal.ZERO;
		while(null!=(line=rb.readLine())){
			String[] split = line.split(",");
			BigDecimal time = new BigDecimal(split[0]);
			BigDecimal order = new BigDecimal(split[1]);
			BigDecimal pv = order.divide(time,10, BigDecimal.ROUND_HALF_UP);
			pv = pv.multiply(new BigDecimal("1000"));
			orders = orders.add(pv);
			times++;
		}
		System.out.println(orders.divide(new BigDecimal(times+""),6, BigDecimal.ROUND_HALF_UP));
	}
}

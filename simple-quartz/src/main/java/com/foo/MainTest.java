package com.foo;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @author JiaSonglin
 * @version 1.0 2016-8-10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainStart.class)
public class MainTest {

	@Autowired
	ApplicationContext applicationContext;
	
	
	@Test
	public void testHelloWorld(){
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		JSONObject json = new JSONObject();
		json.putAll(map);
		String ret = "foo"+"("+json.toString()+")";
		System.out.println(ret);
	}
}

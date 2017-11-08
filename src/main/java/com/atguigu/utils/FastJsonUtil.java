package com.atguigu.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FastJsonUtil {

	/**
	 * 任意对象转json字符串
	 */
	public static String object_to_json(Object object) {
		return JSON.toJSONString(object);
	}
	
	/**
	 * json字符串转普通java对象
	 */
	public static <T> T json_to_object(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
	
	/**
	 * json字符串转List对象
	 */
	public static <T> List<T> json_to_list(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}

}

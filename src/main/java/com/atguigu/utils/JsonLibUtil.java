package com.atguigu.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonLibUtil {

	/**
	 * 普通对象转json字符串
	 */
	public static String object_to_json(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}
	
	/**
	 * list对象转json字符串
	 */
	public static String list_to_json(Object list) {
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}

	/**
	 * json字符串转普通java对象
	 */
	public static <T> T json_to_object(String json, Class<T> clazz) {
		JSONObject fromObject = JSONObject.fromObject(json);
		return (T) JSONObject.toBean(fromObject, clazz);
	}
	
	/**
	 * json字符串转List对象
	 */
	public static <T> List<T> json_to_list(String json, Class<T> clazz) {
		JSONArray fromObject = JSONArray.fromObject(json);
		return (List<T>) JSONArray.toCollection(fromObject, clazz);
	}

}

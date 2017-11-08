package com.atguigu.utils;

import java.util.List;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	/**
	 * 任意对象转json字符串
	 */
	public static String object_to_json(Object object){
		Gson gson = new Gson();
		return gson.toJson(object);
	}
	
	/**
	 * json字符串转普通java对象
	 */
	public static <T> T json_to_object(String json, Class<T> clazz){
		Gson gson = new Gson();
		T object = gson.fromJson(json, clazz);
		return object;
	}
	
	/**
	 * json字符串转List对象
	 */
	public static <T> List<T> json_to_list(String json){
		Gson gson = new Gson();
		TypeToken<List<T>> type = new TypeToken<List<T>>(){};
		List<T> list = (List<T>)gson.fromJson(json, type.getType());
		return list;
	}
}

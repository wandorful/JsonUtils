package com.atguigu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.utils.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtilTest {

	T_MALL_SHOPPINGCAR cart = new T_MALL_SHOPPINGCAR();
	List<T_MALL_SHOPPINGCAR> cartList = new ArrayList<T_MALL_SHOPPINGCAR>();
	Map<String, T_MALL_SHOPPINGCAR> cartMap = new HashMap<String, T_MALL_SHOPPINGCAR>();

	@Before
	public void before() {

		cart.setSku_mch("商品名称");
		cart.setSku_jg(1000);
		cart.setTjshl(10);
		for (int i = 1; i <= 3; i++) {
			T_MALL_SHOPPINGCAR t_MALL_SHOPPINGCAR = new T_MALL_SHOPPINGCAR();
			t_MALL_SHOPPINGCAR.setSku_mch("商品" + i);
			t_MALL_SHOPPINGCAR.setSku_jg(i * 1000);
			t_MALL_SHOPPINGCAR.setTjshl(i);
			cartList.add(t_MALL_SHOPPINGCAR);
			cartMap.put("cart" + i, t_MALL_SHOPPINGCAR);
		}
	}

	@Test
	public void testObject() {
		String object_to_json = GsonUtil.object_to_json(cart);
		Gson gson = new Gson();
		T_MALL_SHOPPINGCAR fromJson = gson.fromJson(object_to_json, T_MALL_SHOPPINGCAR.class);
		System.out.println(fromJson);
	}

	@Test
	public void testList() {
		String object_to_json = GsonUtil.object_to_json(cartList);
		Gson gson = new Gson();
		TypeToken<List<T_MALL_SHOPPINGCAR>> type = new TypeToken<List<T_MALL_SHOPPINGCAR>>(){};
		List<T_MALL_SHOPPINGCAR> fromJson = gson.fromJson(object_to_json, type.getType());
		System.out.println(fromJson);
		List<Object> json_to_list = GsonUtil.json_to_list(object_to_json);
		System.out.println(json_to_list);
	}
	
	@Test
	public void testMap() {
		String object_to_json = GsonUtil.object_to_json(cartMap);
		Gson gson = new Gson();
		TypeToken<Map<String, T_MALL_SHOPPINGCAR>> type = new TypeToken<Map<String, T_MALL_SHOPPINGCAR>>(){};
		Map<String, T_MALL_SHOPPINGCAR> fromJson = gson.fromJson(object_to_json, type.getType());
		System.out.println(fromJson);
	}

}

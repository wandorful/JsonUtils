package com.atguigu.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.utils.JsonLibUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonLibUtilTest {

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
		String object_to_json = JsonLibUtil.object_to_json(cart);
		System.out.println(object_to_json);
		T_MALL_SHOPPINGCAR json_to_object = JsonLibUtil.json_to_object(object_to_json, T_MALL_SHOPPINGCAR.class);
		System.out.println(json_to_object);
		
	}

	@Test
	public void testList() {
		JSONArray fromObject = JSONArray.fromObject(cartList);
		String string = fromObject.toString();
		System.out.println(string);
		List<T_MALL_SHOPPINGCAR> collection = (List<T_MALL_SHOPPINGCAR>) JSONArray.toCollection(fromObject, T_MALL_SHOPPINGCAR.class);
		System.out.println(collection);
	}
	
	@Test
	public void testMap() {
		String cartMapJson = JsonLibUtil.object_to_json(cartMap);
		System.out.println(cartMapJson);
		
		Map map = (Map)JsonLibUtil.json_to_object(cartMapJson, Map.class);
		System.out.println(map.get("cart1"));
	}
	
}

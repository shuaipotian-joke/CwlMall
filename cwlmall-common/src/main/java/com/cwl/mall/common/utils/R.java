package com.cwl.mall.common.utils;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cwl.mall.common.constant.DateConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class R<T> extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	private T data;

	public R() {
		put("code", 0);
	}

	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static R error(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		R r = new R();
		r.put("msg", "success");
		return r;
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}


	public Integer getCode() {
		return (Integer) this.get("code");
	}

	public R setData(Object data) {
		return put("data", data);
	}

	public T getData(){
		return data;
	}

	/**
	 * 解析数据
	 * 1.@ResponseBody返回类型被封装成了Json格式
	 * 2.feign接收参数时也会封装成json格式，data对象也被解析成json格式的数据（[集合对象]或{map对象}）
	 * 3.将data转成json字符串格式，然后再解析成对象
	 */
	public <T> T getData(TypeReference<T> type) {
		Object data = get("data");
		String jsonString = JSONObject.toJSONStringWithDateFormat(data, DateConstant.DATE_FORMAT);
		return JSONObject.parseObject(jsonString, type);
	}

	/**
	 * 解析数据
	 */
	public <T> T getData(String key, TypeReference<T> type) {
		Object data = get(key);
		String jsonString = JSONObject.toJSONStringWithDateFormat(data, DateConstant.DATE_FORMAT);
		return JSONObject.parseObject(jsonString, type);
	}

}

package com.common;

import java.io.Serializable;

public class Result implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Result() {

	}

	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(int code, String msg, Object data) {
		this(code, msg);
		this.data = data;
	}
	
	public static Result success() {
		return new Result(200, "OK");
	}

	public static Result success(Object obj) {
		return new Result(200, "OK", obj);
	}

	public static Result failure(String message) {
		return new Result(500, message);
	}

	@Override
	public String toString() {
		return "{\"code\": " + code + ", \"msg\": " + "\"" + msg + "\"" + ", \"data\": " + data + "}";
	}
	
	

}

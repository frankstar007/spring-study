package com.frankstar.spring.boot.action.response;

import java.io.Serializable;

/**
 * @Author :  frankstar
 * @AddTime :  2019/9/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  spring-study
 * @Desc :
 */
public class CommonResponse<T> implements Serializable {

	private static final long serialVersionUID = 5635324580008068560L;

	private int code;
	
	private String message;
	
	private T data;

	public CommonResponse(int code, T data, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public static <T> CommonResponse<T> buildSuccessResponse(T data) {
		return new CommonResponse(200, data, "success");
	}

	public static <T> CommonResponse<T> buildSuccessResponse(T data, String message) {
		return new CommonResponse(200, data, message);
	}

	public static <T> CommonResponse<T> buildFailResponse(String message) {
		return new CommonResponse(400, (Object)null, message);
	}

	public static <T> CommonResponse<T> buildFailResponse(int code, String message) {
		return new CommonResponse(code, (Object)null, message);
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public T getData() {
		return this.data;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "CommonResponse(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
	}
}

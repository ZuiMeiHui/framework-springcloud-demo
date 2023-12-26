package com.zuimeihui.demo.service.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * @author :fql
 * @date : 2023/5/4 10:29
 * @description:
 */
public enum HttpUtil {
	INSTANCE;

	/**
	 * 发送HTTP请求超时时间,单位:ms
	 */
	private final Integer connTimeOut = 60_000;
	/**
	 * 请求超时,单位:ms
	 */
	private final Integer reqTimeOut = 60_000;
	/**
	 * 响应传输数据超时,单位:ms
	 */
	private final Integer resTimeOut = 60_000;

	/**
	 * 发送httpPost请求(带参数)
	 * 
	 * @param url    post请求的地址
	 * @param header
	 * @param body
	 * @return 字符串结果
	 */
	public String sendPost(String url, Map<String, String> header, Map<String, String> body) {
		HttpPost httpPost = new HttpPost(url);
		// 设置请求头
		if (header != null && !header.isEmpty()) {
			for (Map.Entry<String, String> entry : header.entrySet()) {
				httpPost.setHeader(entry.getKey().toLowerCase(), entry.getValue());
			}
		}
		// 设置请求体
		if (body != null && !body.isEmpty()) {
			List<NameValuePair> formParams = new ArrayList<>();
			for (Map.Entry<String, String> entry : body.entrySet()) {
				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, StandardCharsets.UTF_8);
			httpPost.setEntity(entity);
		}
		// 统一使用短连接
		httpPost.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
		// 设置超时时间,防止连接卡住导致程序运行异常
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connTimeOut)
				.setConnectionRequestTimeout(reqTimeOut).setSocketTimeout(resTimeOut).build();
		httpPost.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result;
		try {
			response = httpClient.execute(httpPost);
			result = response == null ? null : EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			throw new RuntimeException("send sendPost exception!", e);
		} finally {
			closeConnect(response, httpClient);
		}
		return result;
	}

	/**
	 * 概述：发送post请求(content)
	 * 
	 * @param request 请求内容
	 * @param url     请求地址
	 * @return byte[]
	 * @throws Exception
	 */
	public byte[] sendPostReq(String url, Map<String, String> header, String request) {
		HttpPost httpPost = new HttpPost(url);
		if (header != null && !header.isEmpty()) {
			for (Map.Entry<String, String> entry : header.entrySet()) {
				httpPost.setHeader(entry.getKey(), entry.getValue());
			}
		}
		StringEntity stringEntity = new StringEntity(request, StandardCharsets.UTF_8);
		httpPost.setEntity(stringEntity);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connTimeOut)
				.setConnectionRequestTimeout(reqTimeOut).setSocketTimeout(resTimeOut).build();
		httpPost.setConfig(requestConfig);
		return execute(httpPost);
	}

	/**
	 * 概述：发送get请求
	 * 
	 * @param url 请求地址
	 * @return byte[]
	 * @throws Exception
	 */
	public String sendGet(String url, Map<String, String> header) {
		HttpGet httpGet = new HttpGet(url);
		if (header != null && !header.isEmpty()) {
			for (Map.Entry<String, String> entry : header.entrySet()) {
				httpGet.setHeader(entry.getKey(), entry.getValue());
			}
		}
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connTimeOut)
				.setConnectionRequestTimeout(reqTimeOut).setSocketTimeout(resTimeOut).build();
		httpGet.setConfig(requestConfig);
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		} catch (Exception e) {
			throw new RuntimeException("send get request exception!", e);
		} finally {
			closeConnect(response, httpClient);
		}
	}

	/**
	 * 概述：发送http请求
	 * 
	 * @param request
	 * @return byte[]
	 * @throws Exception
	 */
	private byte[] execute(HttpUriRequest request) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toByteArray(entity);
		} catch (Exception e) {
			throw new RuntimeException("send post request exception!", e);
		} finally {
			closeConnect(response, httpClient);
		}
	}

	/**
	 * 关闭链接
	 * 
	 * @param response   响应
	 * @param httpClient 客户端
	 */
	private void closeConnect(CloseableHttpResponse response, CloseableHttpClient httpClient) {
		// 关闭响应链接
		HttpClientUtils.closeQuietly(response);
		// 关闭请求链接
		HttpClientUtils.closeQuietly(httpClient);
	}
}

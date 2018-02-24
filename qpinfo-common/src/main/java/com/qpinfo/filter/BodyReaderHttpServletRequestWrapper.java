package com.qpinfo.filter;

import com.alibaba.fastjson.JSONObject;
import com.qpinfo.constants.Constants;
import com.qpinfo.utils.DES3Util;
import com.qpinfo.utils.HttpHelper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/**
 * Created with antnest-platform
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private final byte[] body;

	@SuppressWarnings("deprecation")
	public BodyReaderHttpServletRequestWrapper(HttpServletRequest request, HttpServletResponse response) throws IOException {
		super(request);
		JSONObject object = null;
		String str = "";
		String sign = request.getHeader("sign") ;
		try {
			String in = HttpHelper.getBodyString(request);
			if (StringUtils.isBlank(in)) {
				HttpHelper.getFailData(response, "参数不能为空");
				throw new RuntimeException("参数不能为空");
			}
			if (in.indexOf("%") != -1) {
				str = DES3Util.decryptMode(URLDecoder.decode(in), Constants.DES_PRIVATE_ENCRYPT_KEY);
			} else {
				str = DES3Util.decryptMode(in, Constants.DES_PRIVATE_ENCRYPT_KEY);
			}

			object = JSONObject.parseObject(str);
			if (!object.containsKey("token")) {
				HttpHelper.getFailData(response, "请求参数非法!");
				throw new RuntimeException("请求参数非法!");
			}
		} catch (Exception e) {
			HttpHelper.getFailData(response, "请求参数非法!");
			throw new RuntimeException("请求参数非法!");
		}
		try {
			if (!DES3Util.checkSign(str, sign)) {
				HttpHelper.getFailData(response, "数据签名非法!");
				throw new RuntimeException("数据签名非法!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		body = str.getBytes(Charset.forName("UTF-8"));
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {

		final ByteArrayInputStream bais = new ByteArrayInputStream(body);

		return new ServletInputStream() {

			@Override
			public int read() throws IOException {
				return bais.read();
			}
			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener arg0) {
				
			}
		};
	}

}
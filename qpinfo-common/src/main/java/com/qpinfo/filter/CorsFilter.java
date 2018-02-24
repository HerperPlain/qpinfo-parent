package com.qpinfo.filter;

import com.qpinfo.utils.Detect;
import com.qpinfo.utils.HttpHelper;
import com.qpinfo.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 黄朴（Herper.Plain）
 * @date 2018/2/7 下午8:34
 * @company 默云网络科技有限公司
 */
@Component
public class CorsFilter  implements Filter {
    private Logger logger = LoggerFactory.getLogger(CorsFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("*********************************过滤器开始处理请求**************************");
        logger.info("============ set character encoding utf-8 ===========");
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //传文件的时候不加密
        //multipart/form-data
        String enctype = servletRequest.getContentType();
        logger.info("CorsFilter request before enctype ={}",enctype);
        //请求链接地址
        String requestURI = httpServletRequest.getRequestURI();
        logger.info("CorsFilter request before uri ={}",requestURI);
        //origin主要是用来说明最初POST请求是从哪里发起的
        String originHeader = httpServletRequest.getHeader("Origin");
        logger.info("CorsFilter request before originHeader ={}",originHeader);
        if ("false".equalsIgnoreCase(PropertiesUtil.get("isEncrypt",false))) {
            logger.info("===============  请求接口不使用加密  ===========");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", originHeader);
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST");
            // 跨域访问设置
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
            httpServletResponse.setHeader("XDomainRequestAllowed", originHeader);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else if (Detect.notEmpty(originHeader) && Detect.notEmpty(requestURI) && requestURI.contains("/h5/")) {
            logger.info("===============处理h5页面跨域访问问题===========");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", originHeader);
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST");
            // 跨域访问设置
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
            httpServletResponse.setHeader("XDomainRequestAllowed", originHeader);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else{
            if ((Detect.notEmpty(enctype) && (enctype.contains("multipart/form-data"))
                    || requestURI.contains("/h5/")
                    || requestURI.contains("/extra/"))){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                // 防止流读取一次后就没有了, 所以需要将流继续写出去
                ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest, httpServletResponse);
				String body = HttpHelper.getBodyString(requestWrapper);
				logger.info("request body 【{}】",body);
                filterChain.doFilter(requestWrapper, servletResponse);
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}

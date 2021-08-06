package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();  		// 클라이언트 IP 주소
		String uri = req.getRequestURI();		   		// 컨텍스트 경로 + 서블릿 경로
		String url = req.getRequestURL().toString();    // 프로토콜 + 도메인 + 포트번호 + 컨텍스트 경로 + 서블릿 경로
		String queryString = req.getQueryString();		// 쿼리스트링
		
		String referer = req.getHeader("referer");		// 이전 페이지 url (이전 경로)
		String agent = req.getHeader("User-Agent");		// 사용자 정보
		
		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : " + remoteAddr + "\n")
		  .append("* uri : " + uri + "\n")
		  .append("* url : " + url + "\n")
		  .append("* queryString : " + queryString + "\n")
		  .append("* referer : " + referer + "\n")
		  .append("* agent : " + agent);
		
		logger.info("LOG FILTER\n" + sb);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
	}

}

package microservices.api;

import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class LogRequest extends ZuulFilter {

	private Logger log = LoggerFactory.getLogger(LogRequest.class);

	@Override
	public Object run() {
		 RequestContext ctx = RequestContext.getCurrentContext();
	     StringBuffer info = new StringBuffer();
	     info.append("\nNEW REQUEST\n");

	     info.append(String.format("Server: %s. Method: %s. Path: %s \n",
	    		 ctx.getRequest().getServerName(),
	    		 ctx.getRequest().getMethod(),
	    		 ctx.getRequest().getRequestURI()));

	     info.append("HEADERS\n");
	     Enumeration<String> headerNames = ctx.getRequest().getHeaderNames();
	     while (headerNames.hasMoreElements()) {
	    	 String header = headerNames.nextElement();
	    	 info.append(String.format("%s = %s \n",
	    			 header,
	    			 ctx.getRequest().getHeader(header)));
	     }

	     log.info(info.toString());
	     return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER;
	}

	@Override
	public String filterType() {
		return "pre";
	}
}
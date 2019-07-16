package com.itmuch.cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.itmuch.cloud.gateway.zuul.filter.MyPreRequestLogFilter;
import com.itmuch.cloud.gateway.zuul.filter.MyRouteFilter;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication_2 
{
	
	@Bean
	public MyPreRequestLogFilter myPreRequestFilter() {
		return new MyPreRequestLogFilter();
	}
	
	@Bean
	public MyRouteFilter myRouteFilter() {
		return new MyRouteFilter();
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulApplication_2.class, args);
    }

	/**
	 * 低版本直接启动即可使用 http://ip:port/hystrix.stream 查看监控信息 
	 * 高版本需要添加本方法方可使用 http://ip:port/hystix.stream 查看监控信息
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}

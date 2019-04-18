package com.reven.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.ssi.SSIServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName:  WebConfiguration   
 * @Description: web配置 相当于web.xml
 * @author huangruiwen
 * @date   2019年4月9日
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

//    /**
//     * @Title: ssiFilter
//     * @Description:  
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean ssiFilter() {
//        FilterRegistrationBean fitler = new FilterRegistrationBean();
//        SSIFilter ssiFilter = new SSIFilter();
//        fitler.setFilter(ssiFilter);
//        fitler.setEnabled(true);
//        fitler.addUrlPatterns("*.shtml");
//        Map<String, String> initParameters=new HashMap<>();
//        initParameters.put("outputEncoding", "UTF-8");
//        initParameters.put("inputEncoding", "UTF-8");
//        fitler.setInitParameters(initParameters);
//        fitler.setOrder(3);
//        return fitler;
//    }

    /**   
     * @Title: servletRegistrationBean   
     * @Description: 启用SSI   
     * @return      
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean();
        servlet.setServlet(new SSIServlet());
        List<String> urlMpping = new ArrayList<>(1);
        urlMpping.add("*.shtml");
        servlet.setUrlMappings(urlMpping);
        servlet.addInitParameter("outputEncoding", "UTF-8");
        servlet.addInitParameter("inputEncoding", "UTF-8");
        return servlet;
    }

}

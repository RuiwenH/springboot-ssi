# springboot开启内置tomcat的SSI服务
 
## 演示地址
* http://localhost:8082/ssi/page/index.shtml

## 核心配置:
 
```
@Bean
public ServletRegistrationBean servletRegistrationBean() {
    ServletRegistrationBean servlet=new ServletRegistrationBean();
    servlet.setServlet(new SSIServlet());
    List<String> urlMpping=new ArrayList<>(1);
    urlMpping.add("*.shtml");
    servlet.setUrlMappings(urlMpping);
    servlet.addInitParameter("outputEncoding", "UTF-8");
    servlet.addInitParameter("inputEncoding", "UTF-8");
    return servlet;
}
```

## 关键点
* 1、shtml页面要放在webapp下
* 2、打jar包时，spring-boot-maven-plugin 使用1.4.2.RELEASE版本
* 3、打jar包时，页面要copy到META-INF/resources目录下

## 其他
* Filter的方式配置失败——不知道怎么增加配置 <mime-type> 导致访问shtml文件变成下载，
可能的解决办法：定制 EmbeddedServletContainerCustomizer 增加mimeMappings

## 参考文章
* Tomcat之——SSI的配置https://blog.csdn.net/l1028386804/article/details/53526786
* Tomcat官方文档 http://tomcat.apache.org/tomcat-8.0-doc/ssi-howto.html
* mime-mapping的作用及配置 https://blog.csdn.net/white__cat/article/details/61024471
* https://stackoverflow.com/questions/27667485/how-to-set-recognized-content-mime-types-for-spring-boot-mvc-resources
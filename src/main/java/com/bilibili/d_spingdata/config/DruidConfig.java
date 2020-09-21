package com.bilibili.d_spingdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Author:BYDylan
 * Date:2020/7/2
 * Description:
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //    后台监控功能:相当于web.xml
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//        帐号密码
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername", "root");
        map.put("loginPassword", "By921644606");
//        允许谁可以访问,为空则为所有
//        map.put("allow", "");
//        禁止谁访问
//        map.put("asdasd", "192.168.1.1");
        bean.setInitParameters(map);
        return bean;
    }

//    @Bean
//    public FilterRegistrationBean webStatFilter() {
//        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
//        bean.setFilter(new WebStatFilter());
////        可以过滤哪些请求
//        HashMap<String, String> map = new HashMap<>();
//        map.put("exclusions", "*.js,*.css,/druid/*");
//        bean.setInitParameters(map);
//        return bean;
//    }
}

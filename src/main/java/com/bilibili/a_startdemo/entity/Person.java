package com.bilibili.a_startdemo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 配置文件导入方法
 * 1.ConfigurationProperties,ConfigurationPropertiesScan,两者需结合使用
 * 2.PropertySource,@Value,获取指定配置文件中的注解
 * 3.@Value获取主配置文件的注解
 * 4.spring配置文件写好后在主类加上,@ImportResource(locations ={"classpath:bean.xml"} ),否则无法识别
 * 可以通过@Autowired ApplicationContext ioc.contaionsBean("beanid") 验证
 * 5.spring 推荐使用配置类,beanid 默认为方法名首字母小写
 *
 * @ Configuration
 * public class MyConfiguration {
 * @ Bean
 * public UserService userService_ioc(){
 * return new UserServiceImpl();
 * }
 * }
 * 6.随机数,在配置中随意位置加上 ${rand.*}
 */
@Component
//@PropertySource(value = {"classpath:person.properties"},encoding = "UTF-8",name = "person.properties")
@ConfigurationProperties(prefix = "person")
@ConfigurationPropertiesScan
public class Person {
    //        @Value("${person.lastName}")
    private String lastName;
    //    @Value("${person.age}")
    private Integer age;
    //    @Value("${person.boss}")
    private Boolean boss;
    //    @Value("${person.birth}")
    private Date birth;
    //    @Value("${person.maps}")
    private Map<String, Object> maps;
    //    @Value("${person.lists}")
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}

//ConfigurationProperties,ConfigurationPropertiesScan要一起使用

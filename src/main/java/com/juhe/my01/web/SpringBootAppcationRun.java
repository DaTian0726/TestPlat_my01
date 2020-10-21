package com.juhe.my01.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * ClassName: SpringBootAppcation
 * Description:
 * date: 2020/8/27 13:49
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class SpringBootAppcationRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppcationRun.class,args);
    }
}

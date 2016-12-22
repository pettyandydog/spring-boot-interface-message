package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by andy on 2016/12/21.
 */
@EnableAutoConfiguration
@ComponentScan
public class Application {

        public static void main(String[] args) throws Exception {
            SpringApplication.run(Application.class, args);
        }

}

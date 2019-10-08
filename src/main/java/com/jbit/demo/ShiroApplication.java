package com.jbit.demo;

//import com.jbit.demo.config.MyExceptionResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class, args);
    }

//    @Bean
//    public MyExceptionResolver myExceptionResolver() {
//        return new MyExceptionResolver();
//    }

}

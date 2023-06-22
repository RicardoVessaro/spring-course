package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration defines a configurations class
@Configuration
public class SportConfig {

    /*
        The bean id defaults to the method name
        Use @Bean to define a Spring Bean
        @Bean use case:
            Take existing third-party class and expose as a Spring bean
        We can define a custom bean id given a String to the @Bean annotation.
            In this example the custom bean id is "aquatic"
     */
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}

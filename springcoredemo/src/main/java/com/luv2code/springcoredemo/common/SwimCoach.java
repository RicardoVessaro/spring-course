package com.luv2code.springcoredemo.common;

// We are not using @Component on purpose because we will define the SwimCoach in a Java Config Bean
public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}

package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
// @Primary annotation choose which class of N autowiring results. Now TrackCoach is primary
// @Primary
/*
    Beans annotated with @Lazy are not initialized, they will be initialized when they are used for dependency injection
    (as a dependency) or when they are explicitly request (endpoint of a @RestController for example).
 */
// @Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}

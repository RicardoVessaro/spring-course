package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    /*
        Constructor Injection Example
        @Autowired annotation tells Spring to inject a dependency. If you only
        have one constructor then @Autowired on constructor is optional
    */
    /*
        To use the @Qualifier we need to specify the bean id:
        Same name as class, first character lower-case
     */
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    /*
        Setter Injection Example (Need to use the @Autowired annotation)
        This method name don't need to be 'setCoach'. we can use any name.

    @Autowired
    public void doSomeStuff(Coach theCoach) {
         // We can have some logic here not just a regular setter.
    myCoach = theCoach;
    }

    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }
    */

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}

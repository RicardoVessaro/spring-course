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

    private Coach anotherCoach;

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
    public DemoController(
            /*
                Singleton Scope: theCoach and theAnotherCoach injections refer to the SAME bean
             */
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
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

    @GetMapping("/check")
    public String check() {
        // If singleton scope is true, if prototype scope is false
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

}

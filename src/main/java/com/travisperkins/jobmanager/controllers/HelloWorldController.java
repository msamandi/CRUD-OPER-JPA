package com.travisperkins.jobmanager.controllers;

import com.travisperkins.jobmanager.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by imunarriz on 23/02/2017.
 */

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Quote> sayHello() {
        Quote q1= new Quote("Senior", "Iban");


        return new ResponseEntity(q1, HttpStatus.OK);
    }
    /** test the creation of new branch integration

     */


}

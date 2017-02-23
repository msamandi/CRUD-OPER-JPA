package com.travisperkins.jobmanager.controllers;

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
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity("Hello world!", HttpStatus.OK);
    }


}

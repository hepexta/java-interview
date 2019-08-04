package com.hepexta.interview.spring.web.controller;

import com.hepexta.interview.spring.web.model.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetController {

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/greet", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Greeting greet() {
        Greeting greeting = new Greeting();
        greeting.setId(1);
        greeting.setMessage("Hello World!!!");
        return greeting;
    }

    @RequestMapping(value = "/greetWithPathVariable/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Greeting greetWithPathVariable(@PathVariable("name") String name) {
        Greeting greeting = new Greeting();
        greeting.setId(1);
        greeting.setMessage("Hello World " + name + "!!!");
        return greeting;
    }

    @RequestMapping(value = "/greetWithQueryVariable", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Greeting greetWithQueryVariable(@RequestParam("name") String name) {
        Greeting greeting = new Greeting();
        greeting.setId(1);
        greeting.setMessage("Hello World " + name + "!!!");
        return greeting;
    }

    @RequestMapping(value = "/greetWithPost", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Greeting greetWithPost() {
        Greeting greeting = new Greeting();
        greeting.setId(1);
        greeting.setMessage("Hello World!!!");
        return greeting;
    }

    @RequestMapping(value = "/greetWithPostAndFormData", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Greeting greetWithPostAndFormData(@RequestParam("id") int id, @RequestParam("name") String name) {
        Greeting greeting = new Greeting();
        greeting.setId(id);
        greeting.setMessage("Hello World " + name + "!!!");
        return greeting;
    }

    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public String handleHttpMediaTypeNotAcceptableException(Exception ex) {
        ex.printStackTrace();
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }

    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public String handleHttpMediaTypeNotSupportedException(Exception ex) {
        ex.printStackTrace();
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }

}

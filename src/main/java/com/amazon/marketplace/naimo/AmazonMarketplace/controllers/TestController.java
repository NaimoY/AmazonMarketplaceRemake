package com.amazon.marketplace.naimo.AmazonMarketplace.controllers;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{
    @GetMapping("/")
    public String testRoot(){

        return "<h1> Test successful </h1>";
    }

}
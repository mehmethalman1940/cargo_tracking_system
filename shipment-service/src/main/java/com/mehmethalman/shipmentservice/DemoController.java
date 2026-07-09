package com.mehmethalman.shipmentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @GetMapping("/test")
    public String test(){
        return "Test";
    }
}

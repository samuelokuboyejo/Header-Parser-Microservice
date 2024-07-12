package com.project.Header_Parser_Microservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParserController {

    @GetMapping("/api/whoami")
    public Map<String, String> generateheader(@RequestHeader(value="User-Agent")String userAgent,
                                              @RequestHeader(value="Accept-Language")String acceptLanguage,
                                              @RequestHeader(value="x-Forwarded-For", required = false)String xForwardedFor){

    Map<String, String> response = new HashMap<>();

    response.put("ipaddress", xForwardedFor != null ? xForwardedFor : "Unknown");
    response.put("language", acceptLanguage);
    response.put("software", userAgent);

    return response;


    }
}

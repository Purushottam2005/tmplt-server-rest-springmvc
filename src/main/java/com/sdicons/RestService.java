package com.sdicons;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestService {

    @RequestMapping(value = "/hello", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody Message hello(@RequestParam(value = "name", required = false)  String name) {
        if(name == null) name = "World";
        return new Message(String.format("REST Service - Hello %s!", name));
    }
}

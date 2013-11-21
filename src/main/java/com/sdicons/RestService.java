package com.sdicons;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestService {

    // @ResponseBody is used to map the result of a method into the body of the response.
    // @RequestBody can be used as parameter annotation to map the body of a request to a parameter.

    @RequestMapping(value = "/hello", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody ResponseEntity<Message> hello(@RequestParam(value = "name", required = false)  String name) {
        if(name == null) name = "World";
        Message msg = new Message(String.format("REST Service - Hello %s!", name));

        // The ResponseEntity is optional, it is used to return the Message instance as well as
        // a status code. The status code can be handy for rest applications!
        return new ResponseEntity<Message>(msg, HttpStatus.OK);
    }

    // Use exception handlers to turn application exceptions into return messages.

    @ExceptionHandler
    public ResponseEntity<Message> exceptionHandler(Exception e) {
        Message msg = new Message(e.getMessage());
        return new ResponseEntity<Message>(msg, HttpStatus.BAD_REQUEST);
    }

    // A method to test the exception handling feature.

    @RequestMapping(value = "/ouch", method= RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody ResponseEntity<Void> ouch() throws Exception{
        throw new Exception("This feature is not implemented.");
    }
}

package com.darwinfont.slackservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack/events")
public class SlackEventController {

    @PostMapping()
    public ResponseEntity<Object> onSlackEvent(@RequestBody Object event) {
        System.out.println("Event: " + event.toString());

//        System.out.println("App: " + app.getSlack());

        return ResponseEntity.ok(event);
    }
}

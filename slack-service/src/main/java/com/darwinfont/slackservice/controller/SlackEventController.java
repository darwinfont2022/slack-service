package com.darwinfont.slackservice.controller;

import com.slack.api.bolt.App;
import com.slack.api.model.event.MessageBotEvent;
import com.slack.api.model.event.MessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.composition.BlockCompositions.*;
import static com.slack.api.model.view.Views.*;
import com.slack.api.model.event.AppHomeOpenedEvent;
import static com.slack.api.model.block.element.BlockElements.*;

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

package com.darwinfont.slackservice.controller;

import com.darwinfont.slackservice.dto.RequestDtoIn;
import com.darwinfont.slackservice.service.WebHookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WebHookController {

    private final WebHookService webHookService;
    public WebHookController(WebHookService webHookService) {
        this.webHookService = webHookService;
    }

    @PostMapping()
    public ResponseEntity<Object> sendMessage(@RequestBody RequestDtoIn message){
        return ResponseEntity.ok(this.webHookService.sendMessage(message));
    }
}

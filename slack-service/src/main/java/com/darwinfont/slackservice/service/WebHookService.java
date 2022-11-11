package com.darwinfont.slackservice.service;

import com.darwinfont.slackservice.client.WebHookClient;
import com.darwinfont.slackservice.client.dto.*;
import com.darwinfont.slackservice.dto.RequestDtoIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class WebHookService {

    private final WebHookClient webHookClient;

    public WebHookService(WebHookClient webHookClient) {
        this.webHookClient = webHookClient;
    }

    public String sendMessage(RequestDtoIn message) {

        var header = HeaderBlock
                .builder()
                .text(message.getRemit())
                .build();

        var section = SectionBlock
                .builder()
                .text(TextBlock
                        .builder()
                        .type(TextType.MD)
                        .text("SectionBlock message")
                        .build()
                ).build();

        var messageBuilded = MessageModel
                .builder()
                .header(header)
                .section(section)
                .build();

        return this.webHookClient.createMessage(messageBuilded);
    }
}

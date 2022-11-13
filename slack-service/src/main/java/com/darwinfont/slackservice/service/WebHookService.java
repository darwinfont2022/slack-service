package com.darwinfont.slackservice.service;

import com.darwinfont.slackservice.client.WebHookClient;
import com.darwinfont.slackservice.client.dto.*;
import com.darwinfont.slackservice.client.dto.section.accessory.ButtonAcc;
import com.darwinfont.slackservice.client.dto.section.accessory.ImageAccessory;
import com.darwinfont.slackservice.client.dto.section.SectionAccessory;
import com.darwinfont.slackservice.client.dto.section.SectionBlock;
import com.darwinfont.slackservice.client.dto.section.Table;
import com.darwinfont.slackservice.client.dto.text.Text;
import com.darwinfont.slackservice.client.dto.type.TextType;
import com.darwinfont.slackservice.client.dto.header.HeaderBlock;
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

    public Object sendMessage(RequestDtoIn message) {

        var header = HeaderBlock
                .builder()
                .text(message.getRemit())
                .build();

        var button = ButtonAcc.builder()
                .text(message.getMessage())
                .build();

        var sectionAccessoryImg = SectionAccessory.builder()
                .text(Text.builder().type(TextType.MD).text(message.getMessage()).build())
                .accessory(button)
                .build();

        var messageBuilded = MessageModel
                .builder()
                .section(sectionAccessoryImg)
                .build();

        try {
            this.webHookClient.createMessage(messageBuilded);
        } catch (Exception e) {
            log.error("Error creating" + e.getMessage(), e);
        }
        return messageBuilded;
    }
}

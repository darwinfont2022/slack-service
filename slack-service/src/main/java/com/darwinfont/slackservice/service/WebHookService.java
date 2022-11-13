package com.darwinfont.slackservice.service;

import com.darwinfont.slackservice.client.WebHookClient;
import com.darwinfont.slackservice.client.dto.*;
import com.darwinfont.slackservice.client.dto.section.SectionAccessory;
import com.darwinfont.slackservice.client.dto.section.accessory.Option;
import com.darwinfont.slackservice.client.dto.section.accessory.OptionList;
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

        var list = new ArrayList<Option>();
        for (int i = 0; i <= 3; i++){
            list.add(Option.builder()
                    .text("option " + i)
                    .value(""+i)
                    .build());
        }
        var accessory = OptionList.builder()
                .option(message.getMessage(), "accessibility")
                .options(list)
                .build();

        var sectionAccessoryImg = SectionAccessory.builder()
                .text(Text.builder().type(TextType.MD).text(message.getMessage()).build())
                .accessory(accessory)
                .build();

        var messageModel = MessageModel
                .builder()
                .section(sectionAccessoryImg)
                .build();

        try {
            this.webHookClient.createMessage(messageModel);
        } catch (Exception e) {
            log.error("Error creating" + e.getMessage(), e);
        }
        return messageModel;
    }
}

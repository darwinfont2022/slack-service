package com.darwinfont.slackservice.service;

import com.darwinfont.slackservice.client.WebHookClient;
import com.darwinfont.slackservice.client.dto.*;
import com.darwinfont.slackservice.client.dto.image.ImageAccessory;
import com.darwinfont.slackservice.client.dto.section.SectionAccessoryImg;
import com.darwinfont.slackservice.client.dto.section.SectionBlock;
import com.darwinfont.slackservice.client.dto.text.TextBlock;
import com.darwinfont.slackservice.client.dto.type.TextType;
import com.darwinfont.slackservice.client.dto.header.HeaderBlock;
import com.darwinfont.slackservice.dto.RequestDtoIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

        var imgUrl = "https://pbs.twimg.com/profile_images/625633822235693056/lNGUneLX_400x400.jpg";
                //"https://i1.wp.com/thetempest.co/wp-content/uploads/2017/08/The-wise-words-of-Michael-Scott-Imgur-2.jpg?w=1024&ssl=1";

        var sectionAccessoryImg = SectionAccessoryImg.builder()
                .text(TextBlock.builder().type(TextType.MD).text(message.getMessage()).build())
                .accessory(ImageAccessory
                        .builder()
//                        .image_url(imgUrl)
                        .alt_text(message.getMessage())
                        .build()
                )
                .build();

        var messageBuilded = MessageModel
                .builder()
                .header(header)
                .section(sectionAccessoryImg)
//                .image(
//                        ImageBlock.builder()
//                                .title("I Need a Marg")
//                                .image_url(imgUrl)
//                                .alt_text("I Need a Marg")
//                        .build())
                .build();

        return this.webHookClient.createMessage(messageBuilded);
    }
}

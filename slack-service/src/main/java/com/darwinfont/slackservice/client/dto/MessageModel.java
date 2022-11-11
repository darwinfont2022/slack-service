package com.darwinfont.slackservice.client.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Slf4j
public class MessageModel {
    public List<Object> blocks;

    public MessageModel() {
        this.blocks = new ArrayList<>();
    }

    private MessageModel(MessageBuilder builder) {
        this.blocks = new ArrayList<>();
        this.blocks.addAll(builder.blocks);
    }

    public static MessageBuilder builder() {
        return new MessageBuilder();
    }

    public static class MessageBuilder {
        public List<Object> blocks;

        public MessageBuilder() {
            this.blocks = new ArrayList<>();
            this.blocks.add(
                    HeaderBlock
                            .builder()
                            .text(" ")
                            .build()
            );
        }

        public MessageBuilder header(HeaderBlock header) {
            this.blocks.add(header);
            return this;
        }

        public MessageBuilder section(SectionBlock section) {
            this.blocks.clear();
            this.blocks.add(section);
            return this;
        }

        public MessageBuilder sections(List<SectionBlock> sections) {
            this.blocks.addAll(sections);
            return this;
        }

        public MessageModel build() {
            return new MessageModel(this);
        }
    }
    public String toString() {
        return "Message\n{\n" + this.blocks.toString() +"\n\t\t]\n}";
    }
}

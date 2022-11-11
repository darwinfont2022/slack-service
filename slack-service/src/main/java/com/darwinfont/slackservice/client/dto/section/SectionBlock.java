package com.darwinfont.slackservice.client.dto.section;

import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.text.TextBlock;
import com.darwinfont.slackservice.client.dto.type.TextType;

import java.util.ArrayList;
import java.util.List;

public class SectionBlock {
    private final String type;
    private final TextBlock text;
    private final List<Object> fields;

    public String getType() {
        return this.type;
    }

    public TextBlock getText() {
        return this.text;
    }

    public List<Object> getFields() {
        return this.fields;
    }

    private SectionBlock(SectionBlockBuilder builder) {
        this.type = BlockType.SECTION;
        this.text = builder.text;
        this.fields = builder.fields;
    }

    public static class SectionBlockBuilder {
        private TextBlock text;
        private List<Object> fields;

        public SectionBlockBuilder() {
            this.text = TextBlock
                    .builder()
                    .type(TextType.TEXT)
                    .text(" ")
                    .build();
            this.fields = new ArrayList<>();
            this.fields.add(
                    TextBlock
                        .builder()
                        .type(TextType.MD)
                        .text(" ")
                        .build()
            );
        }

        public SectionBlockBuilder text(TextBlock text) {
            this.text = text;
            return this;
        }

        public SectionBlockBuilder fields(List<TextBlock> fields) {
            this.fields.addAll(fields);
            return this;
        }

        public SectionBlock build(){
            return new SectionBlock(this);
        }
    }

    public static SectionBlockBuilder builder() {
        return new SectionBlockBuilder();
    }

}

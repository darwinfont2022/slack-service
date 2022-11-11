package com.darwinfont.slackservice.client.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Getter
//@Setter
@Data
public class SectionBlock {
    private String type;
    private TextBlock text;
    private List<TextBlock> fields;

    private SectionBlock(String type, TextBlock text, List<TextBlock> fields){
        this.type = type;
        this.text = text;
        this.fields = fields;
    }

    private SectionBlock(SectionBlockBuilder builder) {
        this.type = builder.type;
        this.text = builder.text;
        this.fields = builder.fields;
    }

    public static class SectionBlockBuilder {
        private String type;
        private TextBlock text;
        private List<TextBlock> fields;

        public SectionBlockBuilder() {
            this.type = BlockType.SECTION;
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
            this.fields = fields;
            return this;
        }

        public SectionBlock build(){
            return new SectionBlock(this);
        }
    }

    public static SectionBlockBuilder builder() {
        return new SectionBlockBuilder();
    }

    public String toString(){
        return "{\n\ttype: " + this.type
                + "\n\ttext: {\n\t\ttype: " + this.text.getType()
                + "\n\t\ttext: " + this.text.getText()
                + "\n\t},\n\tfields: ["
                + this.fields.stream().map(TextBlock::toString).collect(Collectors.joining(","))
                + "\n\t]\n}";
    }
}

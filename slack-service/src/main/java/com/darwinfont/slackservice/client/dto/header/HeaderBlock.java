package com.darwinfont.slackservice.client.dto.header;

import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.text.TextBlock;
import com.darwinfont.slackservice.client.dto.type.TextType;

public class HeaderBlock {
    private final String type;
    private final TextBlock text;

    public String getType() {
        return this.type;
    }

    public TextBlock getText() {
        return this.text;
    }

    private HeaderBlock(HeaderBuilder builder) {
        this.type = builder.type;
        this.text = builder.text;
    }

    public static class HeaderBuilder {
        private String type;
        private TextBlock text;

        public HeaderBuilder() {
            this.type = BlockType.HEADER;
            this.text = TextBlock.builder()
                    .type(TextType.TEXT)
                    .text(" ")
                    .build();
        }

        public HeaderBuilder text(String text) {
            this.text.setText(text);
            return this;
        }

        public HeaderBlock build(){
            return new HeaderBlock(this);
        }
    }

    public static HeaderBuilder builder() {
        return new HeaderBuilder();
    }

    public String toString() {
        return "{\n\t"
                + "type: " + type
                + "\n\ttext: {\n\t\ttype: " + text.getType()
                + "\n\t\ttext: " + text.getText()
                + "\n\t}\n}";
    }
}

package com.darwinfont.slackservice.client.dto.header;

import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.text.Text;

public class HeaderBlock {
    private final String type;
    private final Text text;

    public String getType() {
        return this.type;
    }

    public Text getText() {
        return this.text;
    }

    private HeaderBlock(HeaderBuilder builder) {
        this.type = BlockType.HEADER;
        this.text = builder.text;
    }

    public static class HeaderBuilder {
        private final Text text;

        public HeaderBuilder() {
            this.text = Text.builder().build();
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
        return "{ type: " + this.getType()
                + ", text: { type: "
                + this.text.getType()
                + ", text: " + this.text.getText()
                + " } }";
    }
}

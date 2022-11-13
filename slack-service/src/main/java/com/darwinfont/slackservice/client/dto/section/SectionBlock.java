package com.darwinfont.slackservice.client.dto.section;

import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.text.Text;
import com.darwinfont.slackservice.client.dto.type.TextType;

public class SectionBlock {
    private final String type;
    private final Text text;

    public String getType() {
        return this.type;
    }

    public Text getText() {
        return this.text;
    }

    private SectionBlock(SectionBlockBuilder builder) {
        this.type = BlockType.SECTION;
        this.text = builder.text;
    }

    public static SectionBlockBuilder builder() {
        return new SectionBlockBuilder();
    }

    public static class SectionBlockBuilder {
        private Text text;

        public SectionBlockBuilder() {
            this.text = Text.builder().type(TextType.MD).build();
        }

        public SectionBlockBuilder text(Text text) {
            this.text = text;
            return this;
        }

        public SectionBlock build(){
            return new SectionBlock(this);
        }
    }
}

package com.darwinfont.slackservice.client.dto.section;

import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.text.TextBlock;
import com.darwinfont.slackservice.client.dto.type.TextType;
import com.darwinfont.slackservice.client.dto.image.ImageAccessory;

public class SectionAccessoryImg {
    private final String type;
    private final TextBlock text;
    private final ImageAccessory accessory;

    public String getType() {
        return this.type;
    }

    public TextBlock getText() {
        return this.text;
    }

    public ImageAccessory getAccessory() {
        return this.accessory;
    }

    private SectionAccessoryImg(SectionBlockBuilder builder) {
        this.type = builder.type;
        this.text = builder.text;
        this.accessory = builder.accessory;
    }

    public static class SectionBlockBuilder {
        private String type;
        private TextBlock text;
        private ImageAccessory accessory;

        public SectionBlockBuilder() {
            this.type = BlockType.SECTION;
            this.text = TextBlock
                    .builder()
                    .type(TextType.TEXT)
                    .text(" ")
                    .build();
            this.accessory = ImageAccessory.builder().build();
        }

        public SectionBlockBuilder text(TextBlock text) {
            this.text = text;
            return this;
        }

        public SectionBlockBuilder accessory(ImageAccessory accessory) {
            this.accessory = accessory;
            return this;
        }

        public SectionAccessoryImg build(){
            return new SectionAccessoryImg(this);
        }
    }

    public static SectionBlockBuilder builder() {
        return new SectionBlockBuilder();
    }
}

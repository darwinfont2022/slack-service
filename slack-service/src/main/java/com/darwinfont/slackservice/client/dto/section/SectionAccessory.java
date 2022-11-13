package com.darwinfont.slackservice.client.dto.section;

import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.text.Text;
import com.darwinfont.slackservice.client.dto.type.TextType;
import com.darwinfont.slackservice.client.dto.section.accessory.ImageAccessory;

public class SectionAccessory {
    private final String type;
    private final Text text;
    private final Object accessory;

    public String getType() {
        return this.type;
    }

    public Text getText() {
        return this.text;
    }

    public Object getAccessory() {
        return this.accessory;
    }

    private SectionAccessory(SectionAccessoryBuilder builder) {
        this.type = builder.type;
        this.text = builder.text;
        this.accessory = builder.accessory;
    }

    public static class SectionAccessoryBuilder {
        private final String type;
        private Text text;
        private Object accessory;

        public SectionAccessoryBuilder() {
            this.type = BlockType.SECTION;
            this.text = Text.builder().type(TextType.MD).build();
            this.accessory = ImageAccessory.builder().build();
        }

        public SectionAccessoryBuilder text(Text text) {
            this.text = text;
            return this;
        }

        public SectionAccessoryBuilder accessory(Object accessory) {
            this.accessory = accessory;
            return this;
        }

        public SectionAccessoryBuilder image(ImageAccessory accessory) {
            this.accessory = accessory;
            return this;
        }

        public SectionAccessory build(){
            return new SectionAccessory(this);
        }
    }

    public static SectionAccessoryBuilder builder() {
        return new SectionAccessoryBuilder();
    }
}

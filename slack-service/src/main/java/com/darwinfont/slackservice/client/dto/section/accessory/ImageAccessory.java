package com.darwinfont.slackservice.client.dto.section.accessory;

import com.darwinfont.slackservice.client.dto.type.BlockType;

public class ImageAccessory {
    private final String type;
    private final String image_url;
    private final String alt_text;

    private ImageAccessory(ImageAccessoryBuilder builder){
        this.type = BlockType.IMAGE;
        this.image_url = builder.image_url;
        this.alt_text = builder.alt_text;
    }

    public static ImageAccessoryBuilder builder() {
        return new ImageAccessoryBuilder();
    }
    public static class ImageAccessoryBuilder {
        private String image_url;
        private String alt_text;


        public ImageAccessoryBuilder() {
            this.image_url = "https://pbs.twimg.com/profile_images/625633822235693056/lNGUneLX_400x400.jpg";
            this.alt_text = "";
        }

        public ImageAccessoryBuilder alt_text(String alt_text) {
            this.alt_text = alt_text;
            return this;
        }

        public ImageAccessoryBuilder image_url(String image_url) {
            this.image_url = image_url;
            return this;
        }

        public ImageAccessory build(){
            return new ImageAccessory(this);
        }
    }

    public String getType() {
        return this.type;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public String getAlt_text() {
        return this.alt_text;
    }
}

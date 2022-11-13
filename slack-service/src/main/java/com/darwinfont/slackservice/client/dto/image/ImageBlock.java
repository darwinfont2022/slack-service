package com.darwinfont.slackservice.client.dto.image;

import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.text.Text;
import com.darwinfont.slackservice.client.dto.type.TextType;

public class ImageBlock {
    private final String type;
    private final String image_url;
    private final String alt_text;
    private final Text title;

    private ImageBlock(ImageBlockBuilder builder){
        this.type = BlockType.IMAGE;
        this.image_url = builder.image_url;
        this.alt_text = builder.alt_text;
        this.title = builder.title;
    }

    public static ImageBlockBuilder builder() {
        return new ImageBlockBuilder();
    }
    public static class ImageBlockBuilder {
        private String image_url;
        private String alt_text;
        private final Text title;

        public ImageBlockBuilder() {
            this.image_url = "";
            this.alt_text = "";
            this.title = Text.builder().build();
        }

        public ImageBlockBuilder alt_text(String alt_text) {
            this.alt_text = alt_text;
            return this;
        }

        public ImageBlockBuilder image_url(String image_url) {
            this.image_url = image_url;
            return this;
        }

        public ImageBlockBuilder title(String title) {
            this.title.setText(title);
            return this;
        }

        public ImageBlock build(){
            return new ImageBlock(this);
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
    public Text getTitle() {
        return this.title;
    }
}

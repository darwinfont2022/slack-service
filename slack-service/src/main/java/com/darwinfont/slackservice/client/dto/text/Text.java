package com.darwinfont.slackservice.client.dto.text;

import com.darwinfont.slackservice.client.dto.type.TextType;
import lombok.Data;

import java.util.Objects;

@Data
public class Text {
    private String type;
    private String text;

    public String getType() { return this.type; }
    public String getText() { return this.text; }

    public void bold(){
        if(Objects.equals(this.type, TextType.MD)) {
            this.text = "*" + this.text + "*";
        }
    }

    public void italics(){
        if(Objects.equals(this.type, TextType.MD)) {
            this.text = "_" + this.text + "_";
        }
    }

    public void stress(){
        if(Objects.equals(this.type, TextType.MD)) {
            this.text = "~" + this.text + "~";
        }
    }
    private Text(TextBuilder builder) {
        this.type = builder.type;
        this.text = builder.text;
    }

    public static TextBuilder builder(){
        return new TextBuilder();
    }

    public String toString() {
        return "{ type: " + type + ", text: " + text + " }";
    }

    public static class TextBuilder {
        private String type;
        private String text;

        public TextBuilder() {
            this.type = TextType.TEXT;
            this.text = " ";
        }

        public Text build() {
            return new Text(this);
        }

        public TextBuilder type(String type){
            this.type = type;
            return this;
        }

        public TextBuilder md(){
            this.type = TextType.MD;
            return this;
        }

        public TextBuilder text(){
            this.type = TextType.TEXT;
            return this;
        }

        public TextBuilder text(String text) {
            this.text = text;
            return this;
        }

        public TextBuilder bold(){
            if(Objects.equals(this.type, TextType.MD)) {
                this.text = "*" + this.text + "*";
            }
            return this;
        }

        public TextBuilder italics() {
            if(Objects.equals(this.type, TextType.MD)) {
                this.text = "_" + this.text + "_";
            }
            return this;
        }

        public TextBuilder stress(){
            if(Objects.equals(this.type, TextType.MD)) {
                this.text = "~" + this.text + "~";
            }
            return this;
        }
    }
}

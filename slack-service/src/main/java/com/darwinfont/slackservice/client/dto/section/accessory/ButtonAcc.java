package com.darwinfont.slackservice.client.dto.section.accessory;

import com.darwinfont.slackservice.client.dto.text.Text;

public class ButtonAcc {
    private final String type;

    private final Text text;

    private final String value;

    private final String url;

    private final String action_id;

    private ButtonAcc(ButtonAccBuilder builder) {
        this.type = "button";
        this.text = builder.text;
        this.value = builder.value;
        this.url = builder.url;
        this.action_id = builder.action_id;
    }

    public static ButtonAccBuilder builder() {
        return new ButtonAccBuilder();
    }

    public static class ButtonAccBuilder {
        private final Text text;

        private String value;

        private String url;

        private String action_id;

        public ButtonAccBuilder(){
            this.text = Text.builder().build();
            this.value = " ";
            this.url = "https://google.com";
            this.action_id = "button-action";
        }

        public ButtonAcc build() {
            return new ButtonAcc(this);
        }

        public ButtonAccBuilder text(String value) {
            this.text.setText(value);
            return this;
        }

        public ButtonAccBuilder value(String value) {
            this.value = value;
            return this;
        }

        public ButtonAccBuilder url(String url) {
            this.url = url;
            return this;
        }

        public ButtonAccBuilder action_id(String action_id) {
            this.action_id = action_id;
            return this;
        }
    }

        public Text getText() { return text; }
        public String getValue() { return value; }
        public String getAction_id() { return action_id; }
        public String getUrl() { return url; }
        public String getType() { return type; }
}

package com.darwinfont.slackservice.client.dto.section.accessory;

import com.darwinfont.slackservice.client.dto.text.Text;

public class Option {
    private Text text;
    private String value;

    private Option(OptionBuilder builder) {
        this.text = builder.text;
        this.value = builder.value;
    }

    public static OptionBuilder builder() { return new OptionBuilder(); }

    public static class OptionBuilder {
        private Text text;
        private String value;

        public OptionBuilder() {
            this.text = Text.builder().build();
            this.value = " ";
        }

        public OptionBuilder text(String text) {
            this.text = Text.builder().text(text).build();
            return this;
        }

        public OptionBuilder text(Text text) {
            this.text = text;
            return this;
        }

        public OptionBuilder value(String value) {
            this.value = value;
            return this;
        }

        public Option build() {
            return new Option(this);
        }
    }

    public Text getText() { return this.text; }
    public String getValue() { return this.value; }

    public void setText(String text) { this.text = Text.builder().text(text).build(); }
    public void setText(Text text) { this.text = text; }
    public void setValue(String value) { this.value = value; }
}

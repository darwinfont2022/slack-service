package com.darwinfont.slackservice.client.dto.section.accessory;

import java.util.ArrayList;
import java.util.List;

public class OptionList {
    private final String type;
    private final List<Option> options;

    private OptionList(OptionsListBuilder builder){
        this.type = builder.type;
        this.options = builder.options;
    }

    public static OptionsListBuilder builder(){
        return new OptionsListBuilder();
    }
    public static class OptionsListBuilder {
        private String type;
        private final List<Option> options;

        public OptionsListBuilder(){
            this.type = AccessoryType.CHECKBOXES;
            this.options = new ArrayList<>();
        }

        public OptionsListBuilder type(String type){
            this.type = type;
            return this;
        }

        public OptionsListBuilder option(String text, String value){
            this.options.add(Option.builder().text(text).value(value).build());
            return this;
        }

        public OptionsListBuilder options(List<Option> options){
            this.options.addAll(options);
            return this;
        }

        public OptionList build() {
            return new OptionList(this);
        }
    }

    public void add(Option option) { this.options.add(option); }

    public void add(String text, String value) {
        this.options.add(Option.builder().text(text).value(value).build());
    }

    public void add(String option) {
        this.options.add(Option.builder().text(option).value(option).build());
    }

    public void addAll(List<Option> options) { this.options.addAll(options); }

    public String getType() { return this.type; }
    public List<Option> getOptions() { return this.options; }
}

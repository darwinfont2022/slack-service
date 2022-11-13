package com.darwinfont.slackservice.client.dto.section;

import com.darwinfont.slackservice.client.dto.text.Text;
import com.darwinfont.slackservice.client.dto.type.BlockType;
import com.darwinfont.slackservice.client.dto.type.TextType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private final Text text;
    private final String type;

    private final List<Text> fields;

    public String getType() { return this.type; }

    public List<Text> getFields() { return this.fields; }

    public Text getText() { return this.text; }

    private Table(TableBuilder builder){
        this.text = builder.text;
        this.fields = builder.fields;
        this.type = BlockType.SECTION;
    }

    public static class TableBuilder {

        private Text text;
        private final List<Text> fields;

        private boolean isEmpty;

        public TableBuilder() {
            this.fields = new ArrayList<>();
            this.isEmpty = true;
            this.fields.add(Text.builder().build());
            this.text = Text.builder().bold().build();
        }

        public Table build() {
            return new Table(this);
        }

        public TableBuilder header(Text header) {
            this.text = header;
            return this;
        }

        public TableBuilder row(String col1, String col2) {
            var field1 = (col1.isBlank() ? Text.builder() : Text.builder().text(col1)).build();
            var field2 = (col2.isBlank() ? Text.builder() : Text.builder().text(col2)).build();

            if (isEmpty) {
                this.isEmpty = false;
                this.fields.clear();
            }

            this.fields.add(field1);
            this.fields.add(field2);

            return this;
        }

        public TableBuilder rows(List<String> columns) {
            var fields = columns.stream().map(text ->
                    Text.builder().text(text).build()
            ).collect(Collectors.toList());

            if (isEmpty) {
                this.isEmpty = false;
                this.fields.clear();
            }

            this.fields.addAll(fields);

            return this;
        }
    }

    public static TableBuilder builder() {
        return new TableBuilder();
    }
}

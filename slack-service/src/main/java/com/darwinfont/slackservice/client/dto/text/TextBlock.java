package com.darwinfont.slackservice.client.dto.text;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TextBlock {
    private String type;
    private String text;

    public String toString() {
        return "{\n\ttype: " + type + "\n\ttext: " + text + "\n}";
    }
}

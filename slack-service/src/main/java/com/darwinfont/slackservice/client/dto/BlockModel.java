package com.darwinfont.slackservice.client.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class BlockModel {
    private String type;
    private Object text;
}

package com.darwinfont.slackservice.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class WebHookDto {
    private List<Object> blocks;
}

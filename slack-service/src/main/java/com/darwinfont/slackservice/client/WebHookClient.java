package com.darwinfont.slackservice.client;

import com.darwinfont.slackservice.client.dto.WebHookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "webhook-client", url = "${slack.webhook_url}")
public interface WebHookClient {
    @PostMapping(produces = "application/json")
    public String createMessage(@RequestBody Object message);
}

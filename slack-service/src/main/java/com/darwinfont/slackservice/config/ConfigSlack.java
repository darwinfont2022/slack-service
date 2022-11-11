package com.darwinfont.slackservice.config;

import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigSlack {

    public void configure() throws Exception {
        var app = App.builder().build();

        var server = new SlackAppServer(app);
        server.start();
    }

    @Bean
    public void start() {
        try {
            this.configure();
        } catch (Exception e) {
            System.out.println("Exception initial server started: " + e.getMessage());
        }
    }
}

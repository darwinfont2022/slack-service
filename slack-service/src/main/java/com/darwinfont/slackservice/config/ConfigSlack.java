package com.darwinfont.slackservice.config;

import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
public class ConfigSlack {

    public App configure() throws Exception {
        var app = new App();

        var server = new SlackAppServer(app);
        server.start();
        return app;
    }

//    @Bean
//    @Qualifier("SlackApp")
    public App start() {
        try {
            return this.configure();
        } catch (Exception e) {
            System.out.println("Exception initial server started: " + e.getMessage());
            return null;
        }
    }
}

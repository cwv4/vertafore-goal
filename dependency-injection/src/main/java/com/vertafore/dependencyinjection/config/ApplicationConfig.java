package com.vertafore.dependencyinjection.config;

import com.vertafore.dependencyinjection.model.Apple;
import com.vertafore.dependencyinjection.model.Banana;
import com.vertafore.dependencyinjection.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.vertafore.dependencyinjection")
public class ApplicationConfig {

    // Showcases properties. This can be overridden with environment variables
    @Value("${app.message}")
    private String message;

    // Using Spring Expression Language (SpEL) to determine current profile
    @Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
    private boolean devEnvironment;

    @Bean
    public MessageService getMessageService() {
        return new MessageService(message);
    }

    @Bean
    @Scope("singleton") // Singleton is default scope
    public Apple getApple() {
        String eatString;
        if (devEnvironment) {
            eatString = "Eating apple in dev environment";
        } else {
            eatString = "Eating apple in non-dev environment";
        }

        return new Apple(eatString);
    }

    @Bean
    @Scope("prototype")
    public Banana getBanana() {
        return new Banana("Eating a banana");
    }


}

package com.vertafore.dependencyinjection;

import com.vertafore.dependencyinjection.config.ApplicationConfig;
import com.vertafore.dependencyinjection.model.Apple;
import com.vertafore.dependencyinjection.model.Banana;
import com.vertafore.dependencyinjection.model.Dog;
import com.vertafore.dependencyinjection.service.MessageService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // Dependency injection using application context. Good in main, but more difficult elsewhere
        Dog dog = context.getBean(Dog.class);
        dog.bark();
        dog.playWithToy();

        MessageService messageService = context.getBean(MessageService.class);
        messageService.sendMessage();

        Apple apple = context.getBean(Apple.class);
        apple.eatApple();
        apple.setEatString("Eating an apple again");
        apple = null; // Releasing reference to apple

        Apple secondApple = context.getBean(Apple.class); // Same object as above, eatString has been updated
        secondApple.eatApple();

        Banana banana = context.getBean(Banana.class);
        banana.eatBanana();
        banana.setEatString("This doesn't get saved");
        banana = null;

        Banana secondBanana = context.getBean(Banana.class); // Different, each banana is new b/c of prototype scope
        secondBanana.eatBanana();
    }

}

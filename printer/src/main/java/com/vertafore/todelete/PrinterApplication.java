package com.vertafore.todelete;

import com.vertafore.todelete.model.MyPrinter;
import jakarta.ws.rs.core.StreamingOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;

@SpringBootApplication
public class PrinterApplication {

    public static void main(String[] args) {
        // Load XML-based Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the MyPrinter bean from the context
        MyPrinter myPrinter = (MyPrinter) context.getBean("myPrinter");

        System.out.println("----------String Content----------");
        myPrinter.printMessages();
        System.out.println("----------------------------------");
        System.out.println();

        printStreamingOutput(myPrinter.getStreamingOutputMessage());
    }

    public static void printStreamingOutput(StreamingOutput message) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            message.write(baos);
            String result = baos.toString("UTF-8");
            System.out.println("----------String Content via Streaming Output----------");
            System.out.println(result);
            System.out.println("-------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package jy;

import jy.service.DubboTestService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubbo
public class ConsumerStarterApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DubboTestService.class);
        DubboTestService dubboTestService = context.getBean(DubboTestService.class);
        // dubboTestService.sayHello("Hello");
        //SpringApplication.run(ConsumerStarterApplication.class);
    }
}

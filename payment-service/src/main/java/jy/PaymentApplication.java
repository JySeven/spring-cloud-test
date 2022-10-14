package jy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jiangyi
 */
@SpringBootApplication
@MapperScan(basePackages = {"jy.mapper"})
public class PaymentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentApplication.class);
    }
}

package aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jiangyi
 */
@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentApplication.class);
    }
}

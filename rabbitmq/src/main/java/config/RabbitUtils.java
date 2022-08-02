package config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitUtils {
    static ConnectionFactory connectionFactory=new ConnectionFactory();
    public static String QUEUE_HELLO_WORLD="helloworld";
    public static ConnectionFactory createConnectionFactory(){
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }
    public static Connection getConnection() throws IOException, TimeoutException {
        return RabbitUtils.createConnectionFactory().newConnection();
    }
}

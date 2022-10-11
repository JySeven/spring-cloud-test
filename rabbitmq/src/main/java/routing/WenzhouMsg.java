package routing;

import com.rabbitmq.client.*;
import config.RabbitUtils;
import config.RabbitmqConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class WenzhouMsg {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        // 1.声明队列
        channel.queueDeclare(RabbitmqConstant.QUEUE_WENZHOU, false, false, false, null);
        // 2.绑定队列与交换机并且指定routingkey
        channel.queueBind(RabbitmqConstant.QUEUE_WENZHOU, RabbitmqConstant.EXCHANGE_ROUTING_WEATHER, "wenzhou,2022-08-01");
        channel.queueBind(RabbitmqConstant.QUEUE_WENZHOU, RabbitmqConstant.EXCHANGE_ROUTING_WEATHER, "wenzhou,2022-08-02");
        // 每次消费消息的数量
        channel.basicQos(1);
        channel.basicConsume(RabbitmqConstant.QUEUE_WENZHOU, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("温州:" + message);
                System.out.println("温州的TagId" + envelope.getDeliveryTag());
                // false代表只签收当前消息 true代表签收该消费者所有未签收的消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}

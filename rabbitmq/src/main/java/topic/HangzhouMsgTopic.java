package topic;

import com.rabbitmq.client.*;
import config.RabbitUtils;
import config.RabbitmqConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


/**
 * routingkey模式下 和发布订阅队列有所不同是因为绑定了指定的routingkey多了层筛选
 */
public class HangzhouMsgTopic {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= RabbitUtils.getConnection();
        Channel channel = connection.createChannel();
        // 1.声明队列
        channel.queueDeclare(RabbitmqConstant.QUEUE_HANGZHOU,false,false,false,null);
        // 2.绑定队列与交换机并且指定routingkey
        channel.queueBind(RabbitmqConstant.QUEUE_HANGZHOU,RabbitmqConstant.EXCHANGE_TOPIC_WEATHER,"hangzhou.#");
        // 每次消费消息的数量
        channel.basicQos(1);
        channel.basicConsume(RabbitmqConstant.QUEUE_HANGZHOU,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message=new String(body);
                System.out.println("杭州:"+message);
                System.out.println("杭州的TagId"+envelope.getDeliveryTag());
                // false代表只签收当前消息 true代表签收该消费者所有未签收的消息
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}

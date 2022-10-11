package workqueue;

import com.rabbitmq.client.*;
import config.RabbitUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 建立TCP连接
        Connection connection = RabbitUtils.getConnection();
        // 创建通道
        final Channel channel = connection.createChannel();
        //.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
        // 创建一个队列 如果队列存在则使用这个队列
        // 1.队列名称
        // 2.是否持久化
        // 3.是否私有化,false表示所有消费者都可以访问,true表示只有第一次拥有它的消费者才能一直消费
        // 4.是否自动删除,false 表示连接停掉之后不自动删除这个队列
        // 5.其他额外的参数
        channel.queueDeclare(RabbitUtils.QUEUE_HELLO_WORLD, false, false, false, null);
        // 参数1代表消费完一条消息之后才进行确认 之后再去队列获取消息
        channel.basicQos(1);
        // 1.队列名称
        // 2.是否自动确认消息 false 手动代码确认消息,rabbitmq推荐
        // 3.消费者对象
        channel.basicConsume(RabbitUtils.QUEUE_HELLO_WORLD, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("消费者1:" + message);
                System.out.println("消息的TagId" + envelope.getDeliveryTag());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // false代表只签收当前消息 true代表签收该消费者所有未签收的消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}

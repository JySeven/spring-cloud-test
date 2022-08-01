package workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import config.RabbitUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作队列模式
 * 无需指定交换机
 */
public class OrderSender {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 建立TCP连接
        Connection connection=RabbitUtils.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        //.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
        // 创建一个队列 如果队列存在则使用这个队列
        // 1.队列名称
        // 2.是否持久化
        // 3.是否私有化,false表示所有消费者都可以访问,true表示只有第一次拥有它的消费者才能一直消费
        // 4.是否自动删除,false 表示连接停掉之后不自动删除这个队列
        // 5.其他额外的参数
        channel.queueDeclare("helloworld",false,false,false,null);

        for (int i=0;i<100;i++){
            String message="135582"+"买到第"+i+"张票成功!";
            // 1.交换机名称
            // 2.队列名称
            // 3.额外参数
            // 4.传递消息的字节数组
            channel.basicPublish("","helloworld",null,message.getBytes());
        }

        channel.close();
        connection.close();
        System.out.println("数据发送成功");
    }
}

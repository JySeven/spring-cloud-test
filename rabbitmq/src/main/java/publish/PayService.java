package publish;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import config.RabbitUtils;
import config.RabbitmqConstant;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 支付消息生产者
 * 发布订阅模式
 */
public class PayService {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 建立TCP连接
        Connection connection = RabbitUtils.getConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        while (true) {
            String input = new Scanner(System.in).next();

            // 1.交换机名字
            // 2.队列名字 在发布订阅模式下发布者不需要绑定队列 消费者自行绑定队列,队列绑定交换机来实现通信
            channel.basicPublish(RabbitmqConstant.EXCHANGE_PAY_SUCCESS, "", false, null, input.getBytes());
//        channel.close();
//        connection.close();
            System.out.println("数据发送成功");
        }
    }
}

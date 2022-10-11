package routing;


import com.rabbitmq.client.*;
import config.RabbitUtils;
import config.RabbitmqConstant;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 * route key 模式
 */
public class WeatherPub {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        // 建立通道
        Channel channel = connection.createChannel();
        Map<String, String> areaMap = new LinkedHashMap<>();
        areaMap.put("hangzhou,2022-08-01", "小雨");
        areaMap.put("quzhou,2022-08-01", "晴天");
        areaMap.put("wenzhou,2022-08-01", "多云");
        areaMap.put("hangzhou,2022-08-02", "小雨2");
        areaMap.put("quzhou,2022-08-02", "晴天2");
        areaMap.put("wenzhou,2022-08-02", "多云2");
        areaMap.put("11123,2022-08-02", "多云2");
        // 开启监听模式
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {

            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {

            }
        });
        // 消息发送给broker的时候没有被接受
        channel.addReturnListener(r -> {
            System.out.println("====================");
            System.out.println("Return编码:" + r.getReplyCode() + "-Return描述" + r.getReplyText());
            System.out.println("Return交换机:" + r.getExchange() + "-Return的路由Key" + r.getRoutingKey());
            System.out.println("Return主题:" + Arrays.toString(r.getBody()));
            System.out.println("====================");
        });
        for (String key : areaMap.keySet()) {
            // 第一个参数交换机名字
            // 第二个参数消息的routing key
            channel.basicPublish(RabbitmqConstant.EXCHANGE_ROUTING_WEATHER, key, null, areaMap.get(key).getBytes());
        }
        // 通道保持开启可以监听消息是否被接收
//        channel.close();
//        connection.close();
    }
}

package topic;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import config.RabbitUtils;
import config.RabbitmqConstant;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Administrator
 * route key 模式
 */
public class WeatherPubTopic {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        // 建立通道
        Channel channel = connection.createChannel();
        Map<String, String> areaMap = new LinkedHashMap<>();
        areaMap.put("hangzhou.20220801", "小雨");
        areaMap.put("quzhou.20220801", "晴天");
        areaMap.put("wenzhou.20220801", "多云");
        areaMap.put("hangzhou.20220802", "小雨2");
        areaMap.put("quzhou.20220802", "晴天2");
        areaMap.put("wenzhou.20220802", "多云2");
        for (String key : areaMap.keySet()) {
            // 第一个参数交换机名字
            // 第二个参数消息的routing key
            channel.basicPublish(RabbitmqConstant.EXCHANGE_TOPIC_WEATHER, key, null, areaMap.get(key).getBytes());
        }
        channel.close();
        connection.close();
    }
}

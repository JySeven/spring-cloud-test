package routing;


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
public class WeatherPub {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtils.getConnection();
        // 建立通道
        Channel channel = connection.createChannel();
        Map<String, String> areaMap=new LinkedHashMap<>();
        areaMap.put("hangzhou,2022-08-01","小雨");
        areaMap.put("quzhou,2022-08-01","晴天");
        areaMap.put("wenzhou,2022-08-01","多云");
        areaMap.put("hangzhou,2022-08-02","小雨2");
        areaMap.put("quzhou,2022-08-02","晴天2");
        areaMap.put("wenzhou,2022-08-02","多云2");
        for (String key :areaMap.keySet()){
            // 第一个参数交换机名字
            // 第二个参数消息的routing key
            channel.basicPublish(RabbitmqConstant.EXCHANGE_ROUTING_WEATHER, key,null,areaMap.get(key).getBytes());
        }
        channel.close();
        connection.close();
    }
}

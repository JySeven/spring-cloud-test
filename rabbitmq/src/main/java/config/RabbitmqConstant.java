package config;

/**
 * rabbitmq常量
 * @author Administrator
 */
public class RabbitmqConstant {
    // 支付成功交换机
    public static String EXCHANGE_PAY_SUCCESS="pay_success";
    // 支付成功队列1
    public static String QUEUE_PAY_1="pay_queue_1";
    // 支付成功队列2
    public static String QUEUE_PAY_2="pay_queue_2";

    // 天气消息交换机 routingkey模式
    public static String EXCHANGE_ROUTING_WEATHER ="exchange_routing_weather";
    // 杭州天气队列
    public static String QUEUE_HANGZHOU="queue_hangzhou";
    // 温州天气队列
    public static String QUEUE_WENZHOU="queue_wenzhou";
    // 衢州天气队列
    public static String QUEUE_QUZHOU="queue_quzhou";


    // 天气消息交换机 topic模式
    public static String EXCHANGE_TOPIC_WEATHER ="exchange_topic_weather";
}

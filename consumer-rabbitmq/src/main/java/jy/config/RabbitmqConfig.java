package jy.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * mq配置
 * @author Jy
 * @Configuration注解是单例的
 * 如果使用 @Configuration 注解修饰的类，并且该注解中的 proxyBeanMethods 属性的值为 true，则会为这个 bean 创建一个代理类，该代理类会拦截所有被 @Bean 修饰的方法，在拦截的方法逻辑中，会从容器中返回所需要的单例对象。
 * 如果使用 @Component 注解修饰的类，则不会为这个 bean 创建一个代理类。 那么我们就会直接执行用户的方法，所以每次都会返回一个新的对象。
 * https://juejin.cn/post/6873314485449261069
 */
@Component
public class RabbitmqConfig {
    public Exchange getExchange(String name){
        if (StringUtils.isEmpty(name)){
            name = "exchange";
        }
        return ExchangeBuilder.topicExchange(name).durable(true).build();
    }
}

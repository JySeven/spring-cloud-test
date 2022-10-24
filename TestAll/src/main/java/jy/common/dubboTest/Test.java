package jy.common.dubboTest;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

/**
 * @author Jiangyi
 * @date 2022/10/20 22:22
 * dubbo 服务暴露过程代码
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ServiceConfig<DemoServiceImpl> service = new ServiceConfig<DemoServiceImpl>();
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());
        service.setApplication(new ApplicationConfig("dubbo-demo-api-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.export();//暴露入口

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

}

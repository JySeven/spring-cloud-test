package common.spi;

import java.util.ServiceLoader;

/**
 * @author Jiangyi
 * @date 2022/10/12 21:54
 */
public class TestApi {
    public static void main(String[] args) {
        ServiceLoader<SPITestService> serviceServiceLoader = ServiceLoader.load(SPITestService.class);
        for (SPITestService service : serviceServiceLoader) {
            if (service instanceof SPITestImpl){
                System.out.println("调用了mysql服务");
                ((SPITestImpl) service).insertData("调用了mysql服务");
            }
        }
    }
}

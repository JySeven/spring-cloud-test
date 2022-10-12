package common.spi;

/**
 * @author Jiangyi
 * @date 2022/10/12 21:43
 * spi 示例 spi (Service Provider Interface) 是框架提供给开发者接口 然后开发者实现接口 实现了自定义框架接口的功能
 * 要使用Java SPI，需要遵循如下约定：
 *
 * （1）当服务提供者提供了接口的具体实现后，在jar包的META-INF/services目录下创建一个以“接口全限定名”为命名的文件，内容为实现类的全限定名；
 *
 * （2）引入接口实现类所在的jar包；
 *
 * （3）主程序通过java.util.ServiceLoder<S>动态装载实现模块，它通过扫描META-INF/services目录下的配置文件找到实现类的全限定名，把类加载到JVM；
 *
 * （4）SPI的实现类必须携带一个不带参数的构造方法；
 */
public class SPITestImpl implements SPITestService {


    @Override
    public void insertData(String str) {
        System.out.println("Mysql insert data:" + str);
    }
}

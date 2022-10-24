package jy.common.proxy;

/**
 * @author Jiangyi
 * @date 2022/10/20 21:57
 */
public class Test {
    public static void main(String[] args) {
        TestService testService =new TestServiceImpl();
        ProxyInvocationHandler proxy =new ProxyInvocationHandler();
        proxy.setTarget(testService);

        TestService testService1 = (TestService) proxy.getProxy();
        testService1.test2();
    }
}

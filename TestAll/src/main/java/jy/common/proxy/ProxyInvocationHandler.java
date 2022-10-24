package jy.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//我们会用这个类，自动生成一个代理类
public class ProxyInvocationHandler implements InvocationHandler {

//    Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
//            new Class<?>[] { Foo.class },
//            handler);

    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到 (动态的)  代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }



    //处理代理的实例，并返回结果；
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //动态代理的本质，就是使用反射机制实现；
        Object result = method.invoke(target, args);

        return result;
    }

    //日志方法：
    public void log(String msg){
        System.out.println("【debug】使用了"+msg+"方法");
    }
}


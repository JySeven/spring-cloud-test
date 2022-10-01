package jy.service.impl;

import jy.service.DubboTestService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.security.auth.login.Configuration;

@DubboService(version = "first",protocol = "dubbo")
public class DubboTestServiceImpl implements DubboTestService {

    @Reference(version = "second")
    private DubboTestService dubboTestService;


    @Override
    public String sayHello(String msg) {
        URL url = RpcContext.getContext().getUrl();
        return String.format("%s:%s,Hello,%s",url.getProtocol(), url.getPort(),msg);
    }

    public static void main(String[] args) {
       // ConfigurableApplicationContext context=new S
    }
}

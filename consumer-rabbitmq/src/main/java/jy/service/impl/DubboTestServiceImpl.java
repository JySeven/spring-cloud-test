package jy.service.impl;

import jy.service.DubboTestService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;


@DubboService(version = "first", protocol = "dubbo")
public class DubboTestServiceImpl implements DubboTestService {

    @DubboReference(version = "second",loadbalance = "1")
    private DubboTestService dubboTestService;

    @Override
    public String sayHello(String msg) {
        URL url = RpcContext.getContext().getUrl();
        return String.format("%s:%s,Hello,%s", url.getProtocol(), url.getPort(), msg);
    }

}

package jy.service.impl;

import jy.service.DubboTestService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

@DubboService(version = "second",protocol = "dubbo")
public class DubboSyncServiceImpl implements DubboTestService {

    @Override
    public String sayHello(String msg) {
        URL url = RpcContext.getContext().getUrl();
        return String.format("%s:%s,Hello,%s",url.getProtocol(), url.getPort(),msg);
    }
}

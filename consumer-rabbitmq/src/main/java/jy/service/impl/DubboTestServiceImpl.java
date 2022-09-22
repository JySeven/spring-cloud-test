package jy.service.impl;

import jy.service.DubboTestService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "first",protocol = "dubbo")
public class DubboTestServiceImpl implements DubboTestService {

    @Override
    public String sayHello(String msg) {
        return null;
    }
}

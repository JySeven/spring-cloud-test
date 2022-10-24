package jy.service.impl;

import jy.manager.TestManager;
import jy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestManager testManager;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void test() {
        testManager.test();
    }

    @Override
    public void test2() {
        System.out.println("输出了test2");
    }


}

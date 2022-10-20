package jy.controller;

import java.util.List;
import javax.annotation.Resource;
import jy.mapper.MybatisTestDao;
import jy.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/MybatisTest")
public class MybatisTestController {

    @Resource
    private MybatisTestDao mybatisTestDao;

    @RequestMapping(value = "/test")
    @ResponseBody
    @Transactional
    public String test(){
        List<User> userList =  mybatisTestDao.selectByIdList();
        List<User> userList2 =  mybatisTestDao.selectByIdList();

        return "Hello World!";
    }

}

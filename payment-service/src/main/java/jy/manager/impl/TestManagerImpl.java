package jy.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Random;
import jy.manager.TestManager;
import jy.mapper.UserMapper;
import jy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestManagerImpl implements TestManager {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void test() {
        User user = new User();
        user.setAge(String.valueOf(new Random().nextInt(100)));
        userMapper.insert(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        userMapper.selectList(queryWrapper);
    }
}

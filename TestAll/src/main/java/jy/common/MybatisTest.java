package jy.common;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;

public class MybatisTest {

//    public static void main(String[] args) throws IOException {
//        //1. 读取mybatis-config.xml 文件
//        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//        //2. 构建SqlSessionFactory(创建了DefaultSqlSessionFactory)
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        //3. 打开SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        //4. 获取Mapper 接口对象
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//        //5. 获取mapper 接口对象的方法操作数据库
//        List<User> sysUsers = mapper.selectByIdList(Arrays.asList(1L));
//        System.out.println("查询结果为：" + sysUsers.size());
//    }
    public static void main(String[] args) {
        SpringApplication.run(MybatisTest.class);
    }

    interface  UserMapper {

        List<User> selectByIdList(List<Long> asList);
    }

    @Mapper
    class UserMapperImpl implements UserMapper {

        @Override
        public List<User> selectByIdList(List<Long> asList) {
            return null;
        }
    }

    class User {

    }
}


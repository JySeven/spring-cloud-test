package jy.mapper;

import java.util.List;
import jy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisTestDao {

    List<User> selectByIdList();

}

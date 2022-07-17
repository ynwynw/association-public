package com.muxi.association.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muxi.association.pojo.entity.User;
import com.muxi.association.pojo.vo.UserRoleVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZXW
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 获取UserRole对象集合
     * @param username
     * @param credit
     * @param authority
     * @param pageNum
     * @param limit
     * @return
     */
    List<UserRoleVo> selectUserRoleListByCondition(@Param("username") String username, @Param("credit") Double credit, @Param("authority") String authority, @Param("pageNum") Long pageNum, @Param("limit") Integer limit);

    /**
     * 获取UserRole对象总数
     * @param username
     * @param credit
     * @param authority
     * @return
     */
    Long selectUserRoleCountByCondition(@Param("username") String username, @Param("credit") Double credit, @Param("authority") String authority);

}

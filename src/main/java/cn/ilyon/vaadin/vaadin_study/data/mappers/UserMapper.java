package cn.ilyon.vaadin.vaadin_study.data.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.ilyon.vaadin.vaadin_study.data.models.User;

public interface UserMapper {
	@Select("SELECT * FROM users WHERE id = #{userId}")
	public User findById(@Param("userId") Long userId);

	@Update("update users set user_name=#{userName} where id=#{id}")
	public int updateNameById(@Param("id") long id, @Param("userName") String userName);

}

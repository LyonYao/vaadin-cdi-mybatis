package cn.ilyon.vaadin.vaadin_study.services.impls;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.mybatis.cdi.Mapper;
import org.mybatis.cdi.Transactional;

import cn.ilyon.vaadin.vaadin_study.data.mappers.UserMapper;
import cn.ilyon.vaadin.vaadin_study.data.models.User;
import cn.ilyon.vaadin.vaadin_study.services.UserService;

@ApplicationScoped
//@Named("defaultUserService")
@Default
public class UserServiceImpl implements UserService {
	@Inject
	@Mapper
	private UserMapper userMapper;

	@Transactional
	@Override
	public User getUser(Long id) {
		return userMapper.findById(id);
	}
	@Transactional(rollbackFor={Exception.class})
	@Override
	public void updateName(String userName) throws Exception {
		userMapper.updateNameById(1L,userName);
		if(System.currentTimeMillis()%3==0){
			throw new Exception("");
		}
		
	}

}

package cn.ilyon.vaadin.vaadin_study.services;

import cn.ilyon.vaadin.vaadin_study.data.models.User;

public interface UserService {

	User getUser(Long id);

	void updateName(String userName) throws Exception;
}

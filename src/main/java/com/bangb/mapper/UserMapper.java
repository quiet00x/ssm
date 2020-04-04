package com.bangb.mapper;

import java.util.List;
import java.util.Map;

import com.bangb.user.bean.UserBean;

public interface UserMapper {

	public List<UserBean> queryUserForList(UserBean userBean);

	public int addUsers(Map<String, Object> params);

}

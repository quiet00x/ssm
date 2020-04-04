package com.bangb.user.bean;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.map.annotate.JsonView;

import lombok.Data;

@Data
public class UserBean {
	
	public interface UserSimpleView {};
	
    public interface UserDetailView extends UserSimpleView {};
	
	@NotNull
	@JsonView(UserSimpleView.class)
	private Integer id;
	@JsonView(UserSimpleView.class)
	private String userName;
	@JsonView(UserDetailView.class)
	private String password;
	private String telephone;
	private String address;
	@Email
	private String emailAddr;
	private String age;
	private Date birthday;
	private Character sex;
	
}

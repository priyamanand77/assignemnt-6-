package com.webflux.utility;

import org.springframework.beans.BeanUtils;

import com.webflux.dto.UserDto;
import com.webflux.model.User;

public class AppUtils {

	private AppUtils() {
		super();
	}

	public static UserDto entityToDto(User u) {
		UserDto udto = new UserDto();
		BeanUtils.copyProperties(u, udto);
		return udto;
	}

	public static User dtoToEntity(UserDto udto) {
		User u = new User();
		BeanUtils.copyProperties(udto, u);
		return u;
	}



}

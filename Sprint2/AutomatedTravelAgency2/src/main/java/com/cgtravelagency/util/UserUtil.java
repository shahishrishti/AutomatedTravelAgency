package com.cgtravelagency.util;

import com.cgtravelagency.entity.UserEntity;
import com.cgtravelagency.json.User;

public class UserUtil {

	public static User convertUserEntityIntoUser(UserEntity userEntity) {
			return new User(userEntity.getUserId(),userEntity.getName(),userEntity.getEmail(),
					userEntity.getAddress(),userEntity.getContact(),userEntity.getPassword(),
					userEntity.getGender(),userEntity.getDob());
		}

	public static UserEntity convertUserIntoUserEntity(User user) {
			return new UserEntity(user.getUserId(),user.getName(),user.getEmail(),user.getAddress(),
					user.getContact(),user.getPassword(),user.getGender(),user.getDob());
		}

		
}

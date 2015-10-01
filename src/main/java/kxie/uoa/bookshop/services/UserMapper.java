package kxie.uoa.bookshop.services;

import kxie.uoa.bookshop.domain.User;
import kxie.uoa.bookshop.dto.UserDto;

public class UserMapper {

	public static User toDomainModel(UserDto userDto) {
		User fullUser = new User(userDto.getUsername(), userDto.getPassword(), userDto.getLastname(),
				userDto.getFirstname());
		return fullUser;
	}

	static UserDto toDto(User user) {
		UserDto userDto = new UserDto(
				user.getId(), 
				user.getUsername(), 
				user.getPassword(), 
				user.getLastname(), 
				user.getFirstname());
		return userDto;

	}
}

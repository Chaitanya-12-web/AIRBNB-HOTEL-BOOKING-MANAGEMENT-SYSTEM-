package com.chaitan.airBnb.services;

import com.chaitan.airBnb.dtos.ProfileUpdateRequestDto;
import com.chaitan.airBnb.dtos.UserDto;
import com.chaitan.airBnb.entity.User;

public interface UserService {
    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}

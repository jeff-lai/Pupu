package com.lai.pupu.service;


import com.lai.pupu.base.result.Results;
import com.lai.pupu.dto.UserDto;
import com.lai.pupu.entity.SysUser;

public interface UserService {

	SysUser getUser(String username);

	Results<SysUser> getAllUsersByPage(Integer startPosition, Integer limit);

	SysUser getUserByPhone(String phone);

	SysUser getUserByEmail(String email);

    Results save(SysUser user, Integer roleId);

    SysUser getUserById(Long id);

    Results updateUser(UserDto userDto, Integer roleId);

    int deleteUser(Long id);

    Results<SysUser> getUserByFuzzyUserNamePage(String username, Integer startPosition, Integer limit);

    Results changePassword(String username, String oldPassword, String newPassword);

}

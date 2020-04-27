package com.lai.pupu.service.impl;


import com.lai.pupu.base.result.Results;
import com.lai.pupu.dao.RoleUserDao;
import com.lai.pupu.dao.UserDao;
import com.lai.pupu.dto.UserDto;
import com.lai.pupu.entity.SysRoleUser;
import com.lai.pupu.entity.SysUser;
import com.lai.pupu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleUserDao roleUserDao;

	@Override
	public SysUser getUser(String username) {
		return userDao.getUser(username);
	}

	@Override
	public Results<SysUser> getAllUsersByPage(Integer startPosition, Integer limit) {
		return Results.success(userDao.countAllUsers().intValue(),userDao.getAllUsersByPage(startPosition,limit));
	}

	@Override
	public SysUser getUserByPhone(String phone) {
		return userDao.getUserByPhone(phone);
	}

	@Override
	public SysUser getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public Results save(SysUser user,Integer roleId) {

		if(roleId != null){
			userDao.save(user);
			SysRoleUser sysRoleUser = new SysRoleUser();
			sysRoleUser.setRoleId(roleId);
			sysRoleUser.setUserId(user.getId().intValue());
			roleUserDao.save(sysRoleUser);
			return Results.success();
		}
		return Results.failure();
	}

    @Override
    public SysUser getUserById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public Results updateUser(UserDto userDto, Integer roleId) {
        if(roleId != null){
            userDao.updateUser(userDto);
            SysRoleUser sysRoleUser = new SysRoleUser();
            sysRoleUser.setUserId(userDto.getId().intValue());
            sysRoleUser.setRoleId(roleId);
            if(roleUserDao.getSysRoleUserByUserId(userDto.getId().intValue())!= null){
                roleUserDao.updateSysRoleUser(sysRoleUser);
            }else{
                roleUserDao.save(sysRoleUser);
            }
            return Results.success();
        }else{
            return Results.failure();
        }
    }

    public int deleteUser(Long id) {
        roleUserDao.deleteRoleUserByUserId(id.intValue());
        return userDao.deleteUser(id);
    }

	@Override
	public Results<SysUser> getUserByFuzzyUserNamePage(String username, Integer startPosition, Integer limit) {
		return Results.success(userDao.getUserByFuzzyUserName(username).intValue(),userDao.getUserByFuzzyUserNamePage(username,startPosition,limit));
	}

	@Override
	public Results<SysUser> changePassword(String username, String oldPassword, String newPassword) {
//		SysUser u = userDao.getUser(username);
//		if (u == null) {
//			return Results.failure(1,"用户不存在");
//		}
//		if (!new BCryptPasswordEncoder().encode(oldPassword).equals(u.getPassword())) {
//			return Results.failure(1,"旧密码错误");
//		}
//		userDao.changePassword(u.getId(), new BCryptPasswordEncoder().encode(newPassword));
		return Results.success();
	}
}

package com.lai.pupu.service;


import com.lai.pupu.base.result.Results;
import com.lai.pupu.dto.RoleDto;
import com.lai.pupu.entity.SysRole;

public interface RoleService {

	Results<SysRole> getAllRoles();

	Results<SysRole> getAllRolesByPage(Integer offset, Integer limit);

	Results<SysRole> save(RoleDto roleDto);

	SysRole getRoleById(Integer id);

	Results update(RoleDto roleDto);

	Results delete(Integer id);

	Results<SysRole> getRoleByFuzzyRoleNamePage(String roleName, Integer offset, Integer limit);
}

package com.shequ2.xms.service;

import java.util.List;

import com.shequ2.xms.entity.SystemRole;
import com.shequ2.xms.unit.Pager;
import com.shequ2.xms.unit.Result;
import com.shequ2.xms.unit.SpecParam;

public interface SystemRoleService {
	Result<Pager> pageSystemRoles(SpecParam<SystemRole> specs, Pager pager);
	Result<SystemRole> getSystemRole(Long id);
	Result<SystemRole> createSystemRole(SystemRole systemRole);
	Result<SystemRole> updateSystemRole(SystemRole systemRole);
	Result<Boolean> deleteSystemRole(Long id);
	Result<Boolean> assign(Long id, Long[] functions);
	Result<List<SystemRole>> getSystemRoles(SpecParam<SystemRole> specs);
}
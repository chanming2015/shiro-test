package com.shequ2.xms.service;

import com.shequ2.xms.entity.SystemUser;
import com.shequ2.xms.unit.Pager;
import com.shequ2.xms.unit.Result;
import com.shequ2.xms.unit.SpecParam;

public interface SystemUserService {
	Result<Pager> pageSystemUsers(SpecParam<SystemUser> specs, Pager pager);
	Result<SystemUser> getSystemUser(Long id);
	Result<SystemUser> getSystemUser(String loginName);
	Result<SystemUser> createSystemUser(SystemUser systemUser);
	Result<SystemUser> updateSystemUser(SystemUser systemUser);
	Result<Boolean> deleteSystemUser(Long id);
}
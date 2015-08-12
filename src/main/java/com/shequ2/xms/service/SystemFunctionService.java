package com.shequ2.xms.service;

import java.util.List;

import com.shequ2.xms.entity.SystemFunction;
import com.shequ2.xms.unit.Pager;
import com.shequ2.xms.unit.Result;
import com.shequ2.xms.unit.SpecParam;

public interface SystemFunctionService {
	Result<Pager> pageSystemFunctions(SpecParam<SystemFunction> specs, Pager pager);
	Result<SystemFunction> getSystemFunction(Long id);
	Result<SystemFunction> createSystemFunction(SystemFunction systemFunction);
	Result<SystemFunction> updateSystemFunction(SystemFunction systemFunction);
	Result<Boolean> deleteSystemFunction(Long id);
	Result<List<SystemFunction>> getAllFunctions();
}
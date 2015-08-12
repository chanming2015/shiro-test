package com.shequ2.xms.service;

import java.util.Set;


public interface AuthorityService {
	Set<String> getRoles(String userName);
	Set<String> getPermissions(String userName);
}

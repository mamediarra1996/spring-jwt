package com.isigroup.springJWT.service;

import com.isigroup.springJWT.entity.AppRole;
import com.isigroup.springJWT.entity.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String rolename);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUser();
}

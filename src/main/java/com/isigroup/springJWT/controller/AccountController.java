package com.isigroup.springJWT.controller;

import com.isigroup.springJWT.entity.AppRole;
import com.isigroup.springJWT.entity.AppUser;
import com.isigroup.springJWT.service.AccountService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    public AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
     return accountService.listUser();
    }
    @PostMapping(path = "/users")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }
    @PostMapping(path = "/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }
    @PostMapping(path = "/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRolename());
    }
    @Data
    class RoleUserForm{
        private String username;
        private String rolename;
    }


}

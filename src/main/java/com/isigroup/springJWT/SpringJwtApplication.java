package com.isigroup.springJWT;

import com.isigroup.springJWT.entity.AppRole;
import com.isigroup.springJWT.entity.AppUser;
import com.isigroup.springJWT.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
           accountService.addNewRole(new AppRole(null,"USER"));
		   accountService.addNewRole(new AppRole(null,"ADMIN"));
		   accountService.addNewRole(new AppRole(null,"COSTOMER_MANAGER"));
		   accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
		   accountService.addNewRole(new AppRole(null,"BILIS_MANAGER"));

		    accountService.addNewUser(new AppUser(null,"user1","1234",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"user2","1234",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"user3","1234",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"user4","1234",new ArrayList<>()));

			accountService.addRoleToUser("user1","USER");
			accountService.addRoleToUser("admin","USER");
			accountService.addRoleToUser("admin","ADMIN");
			accountService.addRoleToUser("user2","USER");
			accountService.addRoleToUser("user2","COSTOMER_MANAGER");
			accountService.addRoleToUser("user3","USER");
			accountService.addRoleToUser("user3","PRODUCT_MANAGER");
			accountService.addRoleToUser("user4","USER");
			accountService.addRoleToUser("user4","BILIS_MANAGER");



		};
	}
}

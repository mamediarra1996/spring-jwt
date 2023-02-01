package com.isigroup.springJWT.repository;

import com.isigroup.springJWT.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String releName);
}

package com.example.demo.Repository;

import com.example.demo.Entity.RoleEntity;
import com.example.demo.Entity.EnumType.Roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
  public RoleEntity findByrole(Roles role);
}

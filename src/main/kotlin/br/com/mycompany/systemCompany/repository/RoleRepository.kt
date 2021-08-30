package br.com.mycompany.systemCompany.repository

import br.com.mycompany.systemCompany.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository:JpaRepository<Role,Long> {
}
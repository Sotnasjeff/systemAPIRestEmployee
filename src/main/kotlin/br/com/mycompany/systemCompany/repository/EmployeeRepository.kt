package br.com.mycompany.systemCompany.repository

import br.com.mycompany.systemCompany.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository:JpaRepository<Employee,Long> {
}
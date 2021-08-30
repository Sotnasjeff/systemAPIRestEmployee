package br.com.mycompany.systemCompany.dto

import br.com.mycompany.systemCompany.model.Role
import br.com.mycompany.systemCompany.model.Seniority
import java.time.LocalDateTime

data class EmployeeView(
    val id: Long?,
    val name: String,
    val role: Role,
    val seniority: Seniority,
    val admission: LocalDateTime
)
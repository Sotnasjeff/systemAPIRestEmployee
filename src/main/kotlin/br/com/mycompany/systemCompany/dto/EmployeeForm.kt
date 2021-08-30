package br.com.mycompany.systemCompany.dto

import br.com.mycompany.systemCompany.model.Seniority
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class EmployeeForm(
    @field:NotEmpty @field:Size(min = 2, max = 50) val name: String,
    @field:NotEmpty @field: NotNull val cpf: String,
    @field: NotNull val id_position: Long,
    @field:NotEmpty @field: NotNull val seniority: Seniority,
    @field:NotEmpty @field: NotNull val wage: Double
)

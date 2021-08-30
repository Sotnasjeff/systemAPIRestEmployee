package br.com.mycompany.systemCompany.dto

import br.com.mycompany.systemCompany.model.Seniority
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateEmployeeForm(
    @field: NotNull val id: Long,
    @field: NotNull @field: NotEmpty val id_position: Long,
    @field: NotNull @field: NotEmpty val seniority: Seniority,
    @field: NotNull @field: NotEmpty val wage: Double,
)

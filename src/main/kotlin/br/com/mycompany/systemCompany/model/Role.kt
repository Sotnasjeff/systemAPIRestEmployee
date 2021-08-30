package br.com.mycompany.systemCompany.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @field:NotNull @field:NotEmpty val name: String,
)

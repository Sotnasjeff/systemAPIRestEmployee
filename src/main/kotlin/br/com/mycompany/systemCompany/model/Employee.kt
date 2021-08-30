package br.com.mycompany.systemCompany.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val cpf: String,
    @OneToOne
    var role: Role,
    var seniority: Seniority = Seniority.JUNIOR,
    var wage: Double,
    val admission: LocalDateTime = LocalDateTime.now()
)
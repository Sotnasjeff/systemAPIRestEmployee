package br.com.mycompany.systemCompany.service

import br.com.mycompany.systemCompany.exception.NotFoundException
import br.com.mycompany.systemCompany.model.Role
import br.com.mycompany.systemCompany.repository.RoleRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RoleService(
    private var role: RoleRepository,
    private val notFoundMessage: String = "Position Not Found"
) {

    fun getAllPosition(page: Pageable): Page<Role> {
        return role.findAll(page)
    }

    fun getPositionById(id: Long): Role {
        return role.findById(id).orElseThrow{NotFoundException(notFoundMessage)}
    }

    fun registerNewPosition(roleData: Role): Role {
        return role.save(roleData)
    }

    fun deletePosition(id: Long) {
        role.deleteById(id)
    }


}

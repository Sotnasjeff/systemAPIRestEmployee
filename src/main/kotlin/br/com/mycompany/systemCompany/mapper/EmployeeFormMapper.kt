package br.com.mycompany.systemCompany.mapper

import br.com.mycompany.systemCompany.dto.EmployeeForm
import br.com.mycompany.systemCompany.model.Employee
import br.com.mycompany.systemCompany.service.RoleService
import org.springframework.stereotype.Component

@Component
class EmployeeFormMapper(
    private val roleService: RoleService
):Mapper<EmployeeForm, Employee> {

    override fun map(t: EmployeeForm): Employee {
        return Employee(
            name = t.name,
            cpf = t.cpf,
            role = roleService.getPositionById(t.id_position),
            seniority = t.seniority,
            wage = t.wage
        )
    }

}

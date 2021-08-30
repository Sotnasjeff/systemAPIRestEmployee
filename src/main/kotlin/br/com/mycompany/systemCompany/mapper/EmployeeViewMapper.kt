package br.com.mycompany.systemCompany.mapper

import br.com.mycompany.systemCompany.dto.EmployeeView
import br.com.mycompany.systemCompany.model.Employee
import org.springframework.stereotype.Component

@Component
class EmployeeViewMapper():Mapper<Employee, EmployeeView> {

    override fun map(t: Employee): EmployeeView {
        return EmployeeView(
            id= t.id,
            name= t.name,
            role = t.role,
            seniority = t.seniority,
            admission = t.admission
        )
    }

}
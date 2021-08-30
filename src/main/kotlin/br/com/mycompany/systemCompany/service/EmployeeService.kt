package br.com.mycompany.systemCompany.service

import br.com.mycompany.systemCompany.dto.EmployeeForm
import br.com.mycompany.systemCompany.dto.EmployeeView
import br.com.mycompany.systemCompany.dto.UpdateEmployeeForm
import br.com.mycompany.systemCompany.mapper.EmployeeFormMapper
import br.com.mycompany.systemCompany.mapper.EmployeeViewMapper
import br.com.mycompany.systemCompany.repository.EmployeeRepository
import javassist.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private var employee: EmployeeRepository,
    private val employeeViewMapper: EmployeeViewMapper,
    private val employeeFormMapper: EmployeeFormMapper,
    private val roleService: RoleService,
    private val notFoundMessage: String = "Employee not found"
) {

    fun getAllEmployee(page: Pageable): Page<EmployeeView> {
        val employeeRepository = employee.findAll(page)

        return employeeRepository.map {
            t -> employeeViewMapper.map(t)
        }
    }

    fun getEmployeeById(id: Long): EmployeeView {
        val employeeById = employee.findById(id).orElseThrow {NotFoundException(notFoundMessage)}

        return employeeViewMapper.map(employeeById)
    }

    fun registerEmployee(employeeData: EmployeeForm): EmployeeView {
        val employeeRegistered = employeeFormMapper.map(employeeData)
        employee.save(employeeRegistered)
        return employeeViewMapper.map(employeeRegistered)
    }

    fun updateEmployee(employeeUpdated: UpdateEmployeeForm): EmployeeView {
        val findEmployeeByIdToUpdate = employee
            .findById(employeeUpdated.id)
            .orElseThrow {NotFoundException(notFoundMessage)}

        findEmployeeByIdToUpdate.role = roleService.getPositionById(employeeUpdated.id_position)
        findEmployeeByIdToUpdate.seniority = employeeUpdated.seniority
        findEmployeeByIdToUpdate.wage = employeeUpdated.wage

        return employeeViewMapper.map((findEmployeeByIdToUpdate))
    }

    fun deleteEmployee(id: Long) {
        employee.deleteById(id)
    }


}

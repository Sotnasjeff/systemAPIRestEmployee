package br.com.mycompany.systemCompany.controller

import br.com.mycompany.systemCompany.dto.EmployeeForm
import br.com.mycompany.systemCompany.dto.EmployeeView
import br.com.mycompany.systemCompany.dto.UpdateEmployeeForm
import br.com.mycompany.systemCompany.service.EmployeeService
import javax.transaction.Transactional
import javax.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/employee")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    @Cacheable("/employee")
    fun getAllEmployee(
        @PageableDefault(size = 5, sort = ["admission"], direction = Sort.Direction.DESC) page: Pageable
    ): Page<EmployeeView> {
        return employeeService.getAllEmployee(page)
    }

    @GetMapping("/{id}")
    fun getEmployeeByID(@PathVariable id: Long): EmployeeView {
        return employeeService.getEmployeeById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict("employee", allEntries = true)
    fun registerEmployee(
        @RequestBody @Valid employee: EmployeeForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<EmployeeView> {
        val employeeTransformToView = employeeService.registerEmployee(employee)
        val uri = uriBuilder.path("/topico/${employeeTransformToView.id}").build().toUri()
        return ResponseEntity.created(uri).body(employeeTransformToView)
    }

    @PutMapping
    @Transactional
    @CacheEvict("employee", allEntries = true)
    fun updateEmployee(@RequestBody @Valid employee: UpdateEmployeeForm): ResponseEntity<EmployeeView> {
        val employeeView = employeeService.updateEmployee(employee)
        return ResponseEntity.ok(employeeView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict("employee", allEntries = true)
    fun deleteEmployee(@PathVariable id: Long) {
        employeeService.deleteEmployee(id)
    }


}
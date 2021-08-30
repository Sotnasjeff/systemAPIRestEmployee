package br.com.mycompany.systemCompany.controller

import br.com.mycompany.systemCompany.model.Role
import br.com.mycompany.systemCompany.service.RoleService
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
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/role")
class RoleController(private val roleService: RoleService) {

    @GetMapping
    @Cacheable("/role")
    fun getAllRole(
        @PageableDefault(size = 5, direction = Sort.Direction.DESC) page: Pageable
    ): Page<Role> {
        return roleService.getAllPosition(page)
    }

    @GetMapping("{id}")
    fun getRoleById(
        @PathVariable id: Long
    ): Role {
        return roleService.getPositionById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict("role", allEntries = true)
    fun registerNewRole(
        @RequestBody @Valid role: Role,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Role> {
        val RoleView = roleService.registerNewPosition(role)
        val uri = uriBuilder.path("/position/${RoleView.id}").build().toUri()
        return ResponseEntity.created(uri).body(RoleView)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict("role", allEntries = true)
    fun deletePosition(@RequestParam id: Long) {
        return roleService.deletePosition(id)
    }


}
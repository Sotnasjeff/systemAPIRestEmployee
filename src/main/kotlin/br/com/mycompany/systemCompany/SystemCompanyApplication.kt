package br.com.mycompany.systemCompany

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class SystemCompanyApplication

fun main(args: Array<String>) {
	runApplication<SystemCompanyApplication>(*args)
}

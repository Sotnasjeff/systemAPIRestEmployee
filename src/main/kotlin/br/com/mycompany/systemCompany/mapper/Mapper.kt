package br.com.mycompany.systemCompany.mapper

interface Mapper<T,U> {

    fun map(t: T): U

}
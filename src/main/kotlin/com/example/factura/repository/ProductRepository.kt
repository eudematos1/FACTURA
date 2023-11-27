package com.example.factura.repository

import com.example.factura.model.Client
import com.example.factura.model.Invoice
import com.example.factura.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long?> {

    fun findById (id: Long?): Product?
    @Query(nativeQuery = true)
    fun filterStock(value:Long):List<Product>

}
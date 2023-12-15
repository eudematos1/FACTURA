package com.example.factura.repository

import com.example.factura.model.Client
import com.example.factura.model.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?> {

    fun findById (id: Long?): Detail?
    @Query(nativeQuery = true)
    fun filterPrice(value:Double):List<Detail>
    fun findByInvoiceId(invoiceId: Long?): List<Detail>
}

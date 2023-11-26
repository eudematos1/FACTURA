package com.example.factura.repository

import com.example.factura.model.Client
import com.example.factura.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long?> {

    fun findById (id: Long?): Invoice?


}
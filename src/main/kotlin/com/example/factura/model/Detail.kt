package com.example.factura.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "detail")
class Detail{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var quantity: Long? = null   //description_one en la base de datos
    var price: Double? = null   //address
    @Column (name= "invoice_id")
    var invoiceid: Long? = null
    @Column (name= "product_id")
    var productid: Long?= null
}


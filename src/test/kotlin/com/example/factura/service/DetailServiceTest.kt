package com.example.factura.service

import com.example.factura.model.Detail
import com.example.factura.model.Invoice
import com.example.factura.model.Product
import com.example.factura.repository.DetailRepository
import com.example.factura.repository.InvoiceRepository
import com.example.factura.repository.ProductRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class DetailServiceTest {

    @InjectMocks
    lateinit var detailService: DetailService

    @Mock
    lateinit var detailRepository: DetailRepository

    @Mock
    lateinit var invoiceRepository: InvoiceRepository
    @Mock
    lateinit var productRepository: ProductRepository

    val jsonString = File("./src/test/resources/invoice.json").readText(Charsets.UTF_8)
    val invoiceMock = Gson().fromJson(jsonString, Invoice::class.java)

    val jsonStringtwo = File("./src/test/resources/product.json").readText(Charsets.UTF_8)
    val productMock = Gson().fromJson(jsonStringtwo, Product::class.java)

    val detailMock = com.example.factura.model.Detail().apply {
        id=1
        quantity=12
        price=12.5
        invoiceId=1
        productId=1
    }

    @Test
    fun saveInvoiceWhenIsCorrect(){
        Mockito.`when`(invoiceRepository.findById(detailMock.invoiceId)).thenReturn(invoiceMock)
        Mockito.`when`(productRepository.findById(detailMock.productId)).thenReturn(productMock)
        Mockito.`when`(detailRepository.save(Mockito.any(Detail::class.java))).thenReturn(detailMock)
        val actualResponse = detailService.save(detailMock)
        Assertions.assertEquals(actualResponse.id, detailMock.id)
    }




}


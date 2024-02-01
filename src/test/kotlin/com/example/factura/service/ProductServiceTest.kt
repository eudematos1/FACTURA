package com.example.factura.service

import com.example.factura.model.Product
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
class ProductServiceTest {

    @InjectMocks
    lateinit var productService: ProductService

    @Mock
    lateinit var productRepository: ProductRepository

    val jsonString = File("./src/test/resources/product.json").readText(Charsets.UTF_8)
    val productMock = Gson().fromJson(jsonString, Product::class.java)

    @Test
    fun save() {

        Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
        val response = productService.save(productMock)
        Assertions.assertEquals(response.id, productMock.id)
    }
}
package com.example.factura.controller

import com.example.factura.model.Detail
import com.example.factura.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/detail")   //endpoint
class DetailController {
    @Autowired
    lateinit var detailService: DetailService

    @GetMapping
    fun list ():List <Detail>{
        return detailService.list()
    }
    @GetMapping("/filter-price/{value}")
    fun listPrice (@PathVariable("value") value: Double ):ResponseEntity<*>{
        return ResponseEntity(detailService.listByPrice(value), HttpStatus.OK)
    }
    @PostMapping
    fun save (@RequestBody detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.save(detail), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.update(detail), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.updateName(detail), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(detailService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return detailService.delete(id)
    }

}
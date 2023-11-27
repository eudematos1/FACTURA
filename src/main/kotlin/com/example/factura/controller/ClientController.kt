package com.example.factura.controller

import com.example.factura.model.Client
import com.example.factura.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
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
@RequestMapping("/client")   //endpoint
class ClientController {
    @Autowired
    lateinit var clientService: ClientService

   /* @GetMapping
    fun list ():List <Client>{
        return clientService.list()
    }*/
    @GetMapping
    fun list (client: Client, pageable: Pageable):ResponseEntity<*>{
        val response= clientService.list(pageable,client)
        return ResponseEntity(response, HttpStatus.OK)
    }
    @GetMapping("/filter-address/{value}")
    fun listTotals (@PathVariable("value") value: String ):ResponseEntity<*>{
        return ResponseEntity(clientService.listByAddress(value), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody client: Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.save(client), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody client: Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.update(client), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody client: Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.updateName(client), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(clientService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return clientService.delete(id)
    }


}

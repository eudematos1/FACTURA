package com.example.factura.service

import com.example.factura.model.Client
import com.example.factura.model.Product
import com.example.factura.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    /*fun list ():List<Client>{
        return clientRepository.findAll()
    }*/
    fun list (pageable: Pageable,client: Client):Page<Client>{
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return clientRepository.findAll(Example.of(client, matcher), pageable)
    }
    fun listByAddress(value:String): List<Client> {
        return clientRepository.filterAddress(value)
    }

    fun save(client: Client): Client{
        try{
            client.fullname?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombres no debe ser vacio")
            return clientRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(client: Client): Client{
        try {
            clientRepository.findById(client.id)
                    ?: throw Exception("ID no existe")

            return clientRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(client: Client): Client{
        try{
            val response = clientRepository.findById(client.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                fullname=client.fullname //un atributo del modelo
            }
            return clientRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Client?{
        return clientRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = clientRepository.findById(id)
                    ?: throw Exception("ID no existe")
            clientRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}
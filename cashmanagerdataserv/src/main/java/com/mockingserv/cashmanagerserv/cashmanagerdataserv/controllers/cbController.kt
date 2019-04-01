package com.mockingserv.cashmanagerserv.cashmanagerdataserv.controllers

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs.CBDTO
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs.ProduitDTO
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.CB
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.CBService
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.ProduitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/rest")
class cbController(@Autowired
                         private val cbService: CBService) {

    companion object {
        private const val basePath = "/cb"
    }


    @GetMapping("$basePath/{code}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getByCode(@PathVariable code: Int): CBDTO = cbService.validateCode(code).toDto()

    @GetMapping("/ping", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun pong(): CBDTO = CB(666).toDto()
}

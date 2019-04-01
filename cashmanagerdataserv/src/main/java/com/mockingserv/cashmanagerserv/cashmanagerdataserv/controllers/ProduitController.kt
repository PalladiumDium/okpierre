package com.mockingserv.cashmanagerserv.cashmanagerdataserv.controllers

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs.ProduitDTO
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.ProduitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/rest")
class ProduitController(@Autowired
                         private val productService: ProduitService) {

    companion object {
        private const val basePath = "/products"
    }

    //method = arrayOf(RequestMethod.GET)
    @GetMapping(basePath, produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll():List<ProduitDTO> = productService.all.map { it.toDTO() }

    @GetMapping("$basePath/category/{name}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getByCatego(@PathVariable name: String): List<ProduitDTO> = productService.getByCatego(name.toLowerCase()).map { it.toDTO() }

    @GetMapping(basePath + "/search/{query}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProductQuery(@PathVariable query: String): List<ProduitDTO> = productService.search(query.toLowerCase()).map { it.toDTO() }

}

package com.mockingserv.cashmanagerserv.cashmanagerdataserv.controllers

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs.CategoryDTO
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.CB
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/rest")
class CategoryController(@Autowired
                         private val categoryService: CategoryService) {

    companion object {
        private const val basePath = "/category"
    }

    //method = arrayOf(RequestMethod.GET)
    @RequestMapping(basePath)
    fun getAll():List<CategoryDTO> = categoryService.all.map { it.toDTO() }

}

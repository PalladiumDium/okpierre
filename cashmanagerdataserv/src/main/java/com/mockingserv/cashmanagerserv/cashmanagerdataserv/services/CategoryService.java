package com.mockingserv.cashmanagerserv.cashmanagerdataserv.services;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Category;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Produit;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.CategoryRepository;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category getPostById(Long id) {

        return categoryRepository.getById(id);

    }

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
}

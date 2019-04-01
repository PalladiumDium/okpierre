package com.mockingserv.cashmanagerserv.cashmanagerdataserv.services;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Category;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Produit;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.CategoryRepository;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.ProduitRepository;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.IFACE.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProduitService implements ProductServiceInterface {

    @Autowired
    private ProduitRepository produitRepository;


    public Produit getProduitById(Long id) {
        return produitRepository.getById(id);
    }

    public List<Produit> getAll() {
        return produitRepository.getAll();
    }

    public List<Produit> getByCatego(String name) {
        return produitRepository.getAllByCategory(name.toLowerCase());
    }

    public List<Produit> search(String query) {
        //todo if number ?
        return produitRepository.getByQuery(query);
    }
}

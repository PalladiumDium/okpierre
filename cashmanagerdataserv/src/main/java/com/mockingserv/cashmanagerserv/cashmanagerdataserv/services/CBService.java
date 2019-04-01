package com.mockingserv.cashmanagerserv.cashmanagerdataserv.services;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.CB;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Produit;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.CBRepository;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CBService {

    @Autowired
    private CBRepository cbRepository;

   public CB validateCode(int code) {
        CB cb = cbRepository.getByCode(code);
        if (cb == null) {
            return new CB(100000);
        } else {
            return cb;
        }
    }
}

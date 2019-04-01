package com.mockingserv.cashmanagerserv.cashmanagerdataserv.Config;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Category;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Produit;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.CBRepository;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.CategoryRepository;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo.ProduitRepository;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.CBService;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.CategoryService;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.services.ProduitService;
import org.modelmapper.ModelMapper;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.CB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Configuration
public class AppConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public ProduitService produitService() {
        return new ProduitService();
    }
    @Bean
    public CategoryService categoryService() {
        return new CategoryService();
    }

    @Bean
    public CBService cbService() {
        return new CBService();
    }

    @Bean
    public CommandLineRunner loadDataCategory(CategoryRepository repository) {
        return (args) -> {
            repository.save(new Category("smartphone"));
            repository.save(new Category("smartwatch"));
            repository.save(new Category("ordinateur"));
            repository.save(new Category("mediaplayer"));
        };
    }
    @Bean
    public CommandLineRunner loadDataCb(CBRepository repository) {
        return (args) -> {
            Random rand = new Random();
            for (int i = 0; i < 254; i++) {
                repository.save(new CB(rand.nextInt(9999) + 1000));
            }
        };
    }


    @Bean
    public CommandLineRunner loadDataProd(ProduitRepository repository) {
        return (args) -> {
            List<String> listName = new ArrayList<>();
            listName.add("Iphone MyOwl");
            listName.add("Poor people watch");
            listName.add("Alien war XML 1998");
            listName.add("Ipod Manu");
            int i = 0;
            Random rand = new Random();
            List<Category> listCat = categoryService().getAll();
            for (int k = 0; k < 30; k++) {
                i = k%4;
                Produit newProd = new Produit();
                newProd.setCategory(listCat.get(i));
                newProd.setCodeProduit(UUID.randomUUID().toString());
                newProd.setName(listName.get(i));
                newProd.setPrice(rand.nextInt(3320) + 199);
                newProd.setStock(rand.nextInt(125));
                switch (listCat.get(i).getName()) {
                    case "smartphone":
                        newProd.setImagePath("/assets/iphone.png");
                        break;
                    case "smartwatch":
                        newProd.setImagePath("/assets/watch.png");
                        break;
                    case "ordinateur":
                        newProd.setImagePath("/assets/rog.png");
                        break;
                    case "mediaplayer":
                        newProd.setImagePath("/assets/watch.png");
                        break;

                }
                repository.save(newProd);
            }
        };
    }
}
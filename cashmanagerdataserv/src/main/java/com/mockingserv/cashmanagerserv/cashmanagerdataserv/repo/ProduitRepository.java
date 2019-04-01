package com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Category;
import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

        Produit getById(long id);

        List<Produit> getAllByCategoryIs(Category category);

        @Query("FROM Produit")
        List<Produit> getAll();

        @Query(value = "FROM Produit prod WHERE prod.category.name = :name")
        List<Produit> getAllByCategory(@Param("name") String name);

        @Query(value = "FROM Produit prod where prod.category.name LIKE  %:name% OR prod.codeProduit LIKE  %:name% " +
                "OR prod.name LIKE  %:name%")
        List<Produit> getByQuery(@Param("name") String name);


}

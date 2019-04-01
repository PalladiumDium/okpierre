package com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getById(long id);

    @Query(" FROM Category")
    List<Category> getAll();
}

package com.mockingserv.cashmanagerserv.cashmanagerdataserv.repo;

import com.mockingserv.cashmanagerserv.cashmanagerdataserv.models.CB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CBRepository extends JpaRepository<CB, Long> {

    CB getByCode(int code);

}

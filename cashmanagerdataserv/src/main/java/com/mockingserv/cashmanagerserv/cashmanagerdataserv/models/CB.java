package com.mockingserv.cashmanagerserv.cashmanagerdataserv.models;


import com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs.CBDTO;

import javax.persistence.*;


@Entity
@Table(name = "carte_")
public class CB extends AuditModel {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_")
    private long id;

    @Column(name = "code")
    private int code;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CB(int code) {
        this.code = code;
    }

    public CB() {
    }

    public CBDTO toDto() {
        return new CBDTO(this.id, this.code);
    }
}

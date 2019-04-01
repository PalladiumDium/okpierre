package com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs;

import java.text.SimpleDateFormat;

public class CategoryDTO {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

}

package com.mockingserv.cashmanagerserv.cashmanagerdataserv.DTOs;

import java.text.SimpleDateFormat;

public class CBDTO {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private long id;
    private int code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CBDTO(long id, int code) {
        this.id = id;
        this.code = code;
    }

}

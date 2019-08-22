package com.aks.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Students {
    @Size(min = 2, max = 30, message = "Name must be between 2 to 30 characters")
    @NotNull
    private String name;
    @Size(min = 10, max = 50, message = "Address must be between 10 to 50 characters.")
    private String address;
    private String number;

    public Students() {
    }

    public Students(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

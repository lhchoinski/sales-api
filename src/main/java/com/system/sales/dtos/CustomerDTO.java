package com.system.sales.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomerDTO implements Serializable {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;
}

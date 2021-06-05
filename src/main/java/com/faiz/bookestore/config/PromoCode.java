package com.faiz.bookestore.config;

import lombok.Data;

@Data
public class PromoCode {

    private String promoCode;
    private String bookType;
    private String expireDate;
    private double discount;
}

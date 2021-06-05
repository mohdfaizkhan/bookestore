package com.faiz.bookestore.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetTotalPriceReq {

    private List<String> booksName;

    private String promoCode;

}

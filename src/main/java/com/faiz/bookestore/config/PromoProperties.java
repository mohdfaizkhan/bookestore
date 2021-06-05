package com.faiz.bookestore.config;


import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@ConfigurationProperties(prefix = "promocodes")
@Setter
public class PromoProperties {

    private List<PromoCode> promos;

    public List<PromoCode> getPromos(){
        return Optional.ofNullable(promos).orElseGet(ArrayList::new);
    }
}

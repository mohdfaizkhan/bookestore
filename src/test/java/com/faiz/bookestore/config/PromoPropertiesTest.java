package com.faiz.bookestore.config;

import com.faiz.bookestore.config.PromoCode;
import com.faiz.bookestore.config.PromoProperties;
import io.qameta.allure.Feature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DisplayName("Unit Tests - PromoProperties Unit Tests")
@Feature("Unit Tests - PromoProperties Unit Tests")
public class PromoPropertiesTest {

    private static final Supplier<PromoCode> promoCode = () -> {
        PromoCode promo = new PromoCode();
        promo.setBookType("comic");
        promo.setPromoCode("abc");
        promo.setExpireDate("23/11/2021");
        promo.setDiscount(10);

        return promo;
    };

    private static final Supplier<List<PromoCode>> promoCodes = () -> Stream.of(promoCode.get()).collect(Collectors.toList());

    private static final Supplier<PromoProperties> PROMOPROPERTIES = () -> {
        PromoProperties props = new PromoProperties();
        props.setPromos(promoCodes.get());
        return props;
    };

    @Test
    public void testPromoProperties(){
        final PromoProperties props = PROMOPROPERTIES.get();
        assertEquals(1, props.getPromos().size());
        final PromoCode promoCode = props.getPromos().get(0);

        assertEquals("comic", promoCode.getBookType());
        assertEquals("abc", promoCode.getPromoCode());
        assertEquals("23/11/2021", promoCode.getExpireDate());
        assertEquals(10.0, promoCode.getDiscount());

    }
}

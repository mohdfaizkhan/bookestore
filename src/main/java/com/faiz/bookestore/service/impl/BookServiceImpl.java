package com.faiz.bookestore.service.impl;

import com.faiz.bookestore.config.PromoCode;
import com.faiz.bookestore.config.PromoProperties;
import com.faiz.bookestore.dao.BookDao;
import com.faiz.bookestore.exception.BookAlreadyExistException;
import com.faiz.bookestore.exception.NoDataFoundException;
import com.faiz.bookestore.exception.RequestPayloadException;
import com.faiz.bookestore.model.Book;
import com.faiz.bookestore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service(value = "bookService")
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    private static final Predicate<String> isNotBlank = StringUtils::isNotBlank;
    private static final Predicate<List<?>> isListNotEmpty = CollectionUtils::isNotEmpty;
    private static final BiFunction<String, String, Boolean> validatePromoCode = (configPromo, promoCode) -> configPromo.equalsIgnoreCase(promoCode);


    private final PromoProperties promoProperties;

    private final Function<List<String>, Map<String, List<Book>>> listMapFunction = books ->
            Optional.of(!CollectionUtils.isEmpty(books))
                    .filter(Boolean::booleanValue)
                    .map(correctRequest -> {
                                List<Book> bookDetails = bookDao.findByBookNames(books);
                                return Optional.of(!CollectionUtils.isEmpty(bookDetails))
                                        .filter(Boolean::booleanValue)
                                        .map(dataPresent -> bookDetails.stream()
                                                .collect(Collectors.groupingBy(Book::getType))
                                        )
                                        .orElseThrow(() -> new NoDataFoundException());
                            }
                    ).orElseThrow(() -> new RequestPayloadException());


    @Override
    public Book findById(long id) {
        Optional<Book> optionalBook = bookDao.findById(id);
        return optionalBook.isPresent() ? optionalBook.get() : null;
    }

    public Book findByName(String name) {
        Book bookList = bookDao.findByName(name);
        return bookList;
    }


    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookDao.findAll().iterator().forEachRemaining(list::add);
        if (list.isEmpty()) {
            throw new NoDataFoundException();
        }
        return list;
    }

    @Override
    public Book save(Book book) {

        return Optional.of(!StringUtils.isEmpty(book.getName()))
                .filter(Boolean::booleanValue)
                .map(correctRequest ->
                        Optional.ofNullable(null == bookDao.findByName(book.getName()))
                                .filter(Boolean::booleanValue)
                                .map(notPresentBook -> bookDao.save(Book.builder()
                                        .name(book.getName())
                                        .description(book.getDescription())
                                        .author(book.getAuthor())
                                        .price(book.getPrice())
                                        .isbn(book.getIsbn())
                                        .type(book.getType())
                                        .build()))
                                .orElseThrow(() -> new BookAlreadyExistException())
                ).orElseThrow(() -> new RequestPayloadException());
    }

    @Override
    public void delete(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        Book book1 = findById(book.getId());
        if (book1 != null) {
            bookDao.save(book);
        }
        return book;
    }

    @Override
    public Double getTotalPrice(List<String> books) {

        return Optional.of(!CollectionUtils.isEmpty(books))
                .filter(Boolean::booleanValue)
                .map(correctPayload -> Optional.of(bookDao.findByBookNames(books))
                        .filter(isListNotEmpty::test)
                        .map(bookList -> bookList.stream()
                                .map(Book::getPrice)
                                .collect(Collectors.summarizingDouble(Double::doubleValue))
                                .getSum())
                        .orElseThrow(() -> new NoDataFoundException())
                )
                .orElseThrow(() -> new RequestPayloadException());
    }

    @Override
    public Double getDiscountedPrice(List<String> books, String promoCode) {
        return Optional.of(promoCode)
                .filter(isNotBlank::test)
                .map(code -> Optional.of(promoProperties.getPromos())
                        .filter(isListNotEmpty::test)
                        .map(promos -> {
                            AtomicInteger count = new AtomicInteger();
                            return promos.stream()
                                    .map(promo ->
                                            Optional.of(validatePromoCode.apply(promo.getPromoCode(), promoCode))
                                                    .filter(Boolean::booleanValue)
                                                    .map(validPromo -> listMapFunction.apply(books).entrySet()
                                                            .stream()
                                                            .map(entry -> Optional.of(entry.getKey().equalsIgnoreCase(promo.getBookType()))
                                                                    .filter(Boolean::booleanValue)
                                                                    .map(val -> applyDiscount(promo, getPriceSum(entry)))
                                                                    .orElse(0.0)
                                                            ).collect(Collectors.summarizingDouble(Double::doubleValue))
                                                            .getSum()
                                                    ).orElseGet(() -> {
                                                if (count.get() == 0) {
                                                    count.getAndIncrement();
                                                    return getTotalPrice(books);
                                                }
                                                return 0.0;
                                            })
                                    )
                                    .collect(Collectors.summarizingDouble(Double::doubleValue))
                                    .getSum();
                        })
                        .orElseGet(() -> getTotalPrice(books))
                )
                .orElseGet(() -> getTotalPrice(books));
    }


    private double applyDiscount(final PromoCode promo, final double priceSum) {
        double dis = promo.getDiscount();
        if (promo.getDiscount() != 0.0 && validatePromoExpiry(promo.getExpireDate())) {
            return priceSum - (priceSum * dis) / 100;
        }
        return priceSum;
    }

    private double getPriceSum(Map.Entry<String, List<Book>> entry) {
        return entry.getValue()
                .stream()
                .map(Book::getPrice)
                .collect(Collectors.summarizingDouble(Double::doubleValue))
                .getSum();
    }

    private Boolean validatePromoExpiry(String date) {
        boolean validDate = Boolean.FALSE;
        try {
            Date formateDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            validDate = new Date().before(formateDate);
        } catch (Exception ex) {

        }
        return validDate;
    }

}

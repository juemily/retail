package com.example.retail.application.service.impl;

import com.example.retail.domain.error.exceptions.RetailException;
import com.example.retail.domain.model.dto.Price;
import com.example.retail.infrastructure.dbo.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class RetailServiceImplTest {

    @Autowired
    private PriceServiceImpl service;



    private List<Price> priceList = new ArrayList<>();
    private List<PriceEntity> priceEntityList = new ArrayList<>();
    private Price price = new Price();
    private PriceEntity priceEntity = new PriceEntity();




    @Test
    void listPrices() throws RetailException {

        List<String> listStarDate = new ArrayList<>();
        listStarDate.add("2024-02-15 10:00:00");
        listStarDate.add("2024-02-16 21:00:00");
        listStarDate.add("2024-02-14 21:00:00");
        listStarDate.add("2024-02-14 16:00:00");
        listStarDate.add("2024-02-14 10:00:00");

        for(String date : listStarDate){
            List<Price> result = service.listPrices(date, "1", "1");//listPrices("2024-03-01 00:00:00", "1", "1");

            // Realiza las aserciones necesarias
            assertNotNull(result);
            for(Price price : result){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateToSearch = LocalDateTime.parse(date, formatter);

                assertEquals(dateToSearch,price.getEndDate());

            }
        }

    }
}
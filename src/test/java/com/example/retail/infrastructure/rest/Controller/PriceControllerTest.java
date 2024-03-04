package com.example.retail.infrastructure.rest.Controller;

import com.example.retail.domain.error.exceptions.RetailException;
import com.example.retail.domain.model.dto.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PriceControllerTest {

    @Autowired
    PriceController controller;

    @Test
    void getPrices() throws RetailException {

        ResponseEntity<List<Price>> response = controller.getPrices("1","1","2024-02-15 10:00:00");
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
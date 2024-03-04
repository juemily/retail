package com.example.retail.infrastructure.rest;

import com.example.retail.domain.error.exceptions.RetailException;
import com.example.retail.domain.model.dto.Price;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("retail/prices")
public interface PriceApi {

    @GetMapping(value = "/list",  produces = {"application/json;charset=utf-8"})
    public ResponseEntity<List<Price>> getPrices(@RequestParam String brandId, @RequestParam String productId, @RequestParam String dateToApply)throws RetailException;
}

package com.example.retail.application.service;

import com.example.retail.domain.error.exceptions.RetailException;
import com.example.retail.domain.model.dto.Price;

import java.util.List;

public interface PriceServce {

    List<Price> listPrices(String startData, String productId, String brandId) throws RetailException;
}

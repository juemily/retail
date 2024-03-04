package com.example.retail.application.service.impl;

import com.example.retail.application.repository.PriceRepository;
import com.example.retail.application.service.PriceServce;
import com.example.retail.domain.enums.ErrorDefinitionEnum;
import com.example.retail.domain.error.exceptions.RetailException;
import com.example.retail.domain.model.dto.Price;
import com.example.retail.infrastructure.dbo.PriceEntity;
import com.example.retail.infrastructure.mapper.RetailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Slf4j
@Service
public class PriceServiceImpl implements PriceServce {

    private final PriceRepository repository;

    private final RetailMapper mapper;

    @Autowired
    public PriceServiceImpl(PriceRepository repository, RetailMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    /**
     * @Params: String startData, String productId, String brandId
     * Search prices using input parameters.
     */
    @Override
    @Cacheable("price")
    public List<Price> listPrices(String startData, String productId, String brandId) throws RetailException {
        LocalDateTime dateToSearch = getFormatToDate(startData);

        List<PriceEntity> listOfPrices = repository.findAll();

        List<Price> response = listOfPrices.stream()
                .filter(data -> (data.getStartDate().equals(dateToSearch) || data.getEndDate().equals(dateToSearch))
                        && data.getBrand_id().equals(Long.valueOf(brandId))
                        && data.getProductId().equals(Long.valueOf(productId)))
                .map(mapper::toDto)
                .toList();

        if (response.isEmpty()) {
            throw new RetailException(ErrorDefinitionEnum.GENERIC_ERROR,
                    "No products found with the filters sent",
                    HttpStatus.NOT_FOUND.value());
        }

        return response;

    }

    /**
     * @Params string startData
     * receives a String, validates and transforms to localDate
     */
    private LocalDateTime getFormatToDate(String startData) throws RetailException {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateToSearch = LocalDateTime.parse(startData, formatter);

            return dateToSearch;
        } catch (DateTimeParseException e) {
            throw new RetailException(ErrorDefinitionEnum.GENERIC_ERROR,
                    "The received date could not be transformed into date",
                    HttpStatus.BAD_REQUEST.value());
        }


    }


}

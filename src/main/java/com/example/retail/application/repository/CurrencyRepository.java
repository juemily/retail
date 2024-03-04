package com.example.retail.application.repository;

import com.example.retail.infrastructure.dbo.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long>, JpaSpecificationExecutor<CurrencyEntity> {
}

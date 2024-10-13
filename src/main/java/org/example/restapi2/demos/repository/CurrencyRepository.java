package org.example.restapi2.demos.repository;

import org.example.restapi2.demos.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCode(String code);
}

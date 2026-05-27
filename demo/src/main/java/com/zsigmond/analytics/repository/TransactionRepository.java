package com.zsigmond.analytics.repository;

import com.zsigmond.analytics.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
}
// kapcsolat a db-vel, save, findall, delete
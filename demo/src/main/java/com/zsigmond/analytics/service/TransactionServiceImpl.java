package com.zsigmond.analytics.service;

import com.zsigmond.analytics.model.Transaction;
import com.zsigmond.analytics.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    @Override
    public BigDecimal getTotalAmount() {
        return repository.findAll()
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getTotalByCategory(String category) {
        return repository.findAll()
                .stream()
                .filter(t -> t.getCategory().equalsIgnoreCase(category))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}


package com.zsigmond.analytics.service;

import java.math.BigDecimal;
import java.util.List;
import com.zsigmond.analytics.model.Transaction;

public interface TransactionService {

    Transaction create(Transaction transaction);

    List<Transaction> getAll();

    BigDecimal getTotalAmount();

    BigDecimal getTotalByCategory(String category);
}

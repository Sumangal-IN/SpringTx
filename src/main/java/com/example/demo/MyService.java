package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@AllArgsConstructor
public class MyService {

    private final MyComponent1 myComponent1;
    private final PlatformTransactionManager transactionManager;

    public void mark(final boolean willFail) {
        TransactionTemplate txTemplate = new TransactionTemplate(transactionManager);
        txTemplate.execute(
                status -> myComponent1.mark(willFail)
        );
    }
}

package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
@AllArgsConstructor
public class MyComponent1 {

    private final MyComponent2 myComponent2;
    private final PlatformTransactionManager transactionManager;

    public Mark mark(final boolean willFail) {
        TransactionTemplate txTemplate = new TransactionTemplate(transactionManager);
        return txTemplate.execute(
                status -> myComponent2.mark(willFail)
        );
    }
}

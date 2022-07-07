package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class MyComponent2 {

    private final MarkRepository markRepository;

    @Transactional(noRollbackFor = ETLException.class, propagation = Propagation.REQUIRES_NEW)
    public Mark mark(final boolean willFail) {
        try {
            Mark mark = markRepository.save(Mark.builder()
                    .id(UUID.randomUUID().toString())
                    .purpose("Value")
                    .markTime(System.currentTimeMillis()).build());
            failManager(willFail);
            return mark;
        } catch (Exception e) {
            log.error("An exception caught: {}", e.getMessage());
            throw e;
        } finally {
            markRepository.save(Mark.builder()
                    .id(UUID.randomUUID().toString())
                    .purpose("Flag")
                    .markTime(System.currentTimeMillis()).build());
        }
    }

    private void failManager(boolean willFail) {
        if (willFail) {
            log.error("Failing as requested");
            throw new ETLException("Throwing ETLException");
        }
        throw new MyException("Throwing MyException");
    }
}

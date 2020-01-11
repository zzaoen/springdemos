package com.demo;
/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-24 09:22
 * @desc:
 */

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public interface MyService {
    @Retryable(value = {NullPointerException.class},
            maxAttempts = 1,
            backoff = @Backoff(delay = 500))
    void retryService(String message) throws NullPointerException;

    @Recover
    void recover(NullPointerException e, String message);


}

package com.demo;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-24 09:29
 * @desc:
 */

import org.springframework.stereotype.Service;

@Service
public class MyServiceImp implements MyService {

    @Override
    public void retryService(String message) throws NullPointerException {
        if(message == null) {
            System.out.println("123123");
            throw new NullPointerException();
        }
    }

    @Override
    public void recover(NullPointerException e, String message) {
        System.out.println("111111");
    }
}

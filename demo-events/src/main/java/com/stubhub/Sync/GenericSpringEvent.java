package com.stubhub.Sync;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-09 19:03
 * @desc:
 */

import lombok.Data;

@Data
public class GenericSpringEvent<T> {
    private T what;
    protected int code;

    public GenericSpringEvent(T what, int code) {
        this.what = what;
        this.code = code;
    }
}

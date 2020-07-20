package com.example.profiledemo.service.imp;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-03-19 08:19
 * @desc:
 */

import com.example.profiledemo.service.ProfileService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!dev")
@Service
public class ProdProfileService implements ProfileService {

    @Override
    public String getMessage() {
        return "prod";
    }
}

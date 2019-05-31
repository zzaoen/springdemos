package stubhub;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-24 09:49
 * @desc:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Autowired
    private MyServiceImp myService;

    @Autowired
    private RetryTemplate retryTemplate;

    public static void main(String[] args) {

    }
}

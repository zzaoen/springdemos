package stubhub;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-24 09:24
 * @desc:
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RetryController {

    @Autowired
    private MyServiceImp myService;

    @Autowired
    private RetryTemplate retryTemplate;

    @RequestMapping("/retry")
    public void retry() {
        myService.retryService(null);
    }

    @RequestMapping("/retry2")
    public void retry2() {
        retryTemplate.execute(arg0 -> {
            myService.retryService(null);
            return null;
        });
    }
}

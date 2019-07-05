

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-24 09:58
 * @desc:
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.stubhub.DZone.SampleRetryClientService;
import com.stubhub.DZone.TypeOneException;
import com.stubhub.DZone.TypeTwoException;
import com.stubhub.RetryApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetryApplication.class)
public class RetryTest {

    @Autowired
    private SampleRetryClientService clientService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sampleRetryService() {
        try {
            final String message = clientService.callRetryService();
            System.out.println("message: " + message);
        } catch (TypeOneException | TypeTwoException e) {
            e.printStackTrace();
        }
    }
}

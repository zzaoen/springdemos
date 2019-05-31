package stubhub.DZone;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-24 09:57
 * @desc:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleRetryClientService {
    @Autowired
    private SampleRetryService sampleRetryService;

    public String callRetryService() throws TypeOneException, TypeTwoException {
        return sampleRetryService.retryWhenException();
    }
}

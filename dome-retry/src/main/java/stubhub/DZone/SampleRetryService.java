package stubhub.DZone;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-24 09:54
 * @desc:
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SampleRetryService {

    private static int COUNTER = 0;

    @Retryable(
            value = {TypeOneException.class},
            maxAttempts = 4, backoff = @Backoff(2000))
    public String retryWhenException() throws TypeOneException, TypeTwoException {
        COUNTER++;
        log.info("COUNTER = " + COUNTER);
        if (COUNTER == 1)
            throw new TypeOneException();
        else if (COUNTER == 2)
            throw new TypeTwoException();
        else
            throw new RuntimeException();
    }

    @Recover
    public String recover(TypeTwoException t) {
        log.info("SampleRetryService.recover");
        return "Error Class :: " + t.getClass().getName();
    }
}

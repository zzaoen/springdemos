
/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-31 13:25
 * @desc:
 */

import java.util.Date;

public class Test2 {

    public static void main(String[] args) {
        Date d1 = new Date();
        long time = d1.getTime();
        Date d2 = new Date(time);

        Config config1 = new Config("app", d1);
        Config config2 = new Config("app", d2);

        System.out.println(config1.getUpdatedTime().equals(config2.getUpdatedTime()));
    }
}

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-31 13:25
 * @desc:
 */
@Data
@AllArgsConstructor

public class Config {
    String name;
    Date updatedTime;
}

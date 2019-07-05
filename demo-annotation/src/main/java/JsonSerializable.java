
/*
 * @author: zzhao3@ebay.com
 * @date: 2019-06-12 11:30
 * @desc: The custom annotations with the goal of serializing an object into a JSON string
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//specify scope and target
@Retention(RetentionPolicy.RUNTIME) //Runtime visibility
@Target(ElementType.TYPE) // Apply it to types(classes)
public @interface JsonSerializable {
}

// No methods, simply mark classes that can be serialized into JSON
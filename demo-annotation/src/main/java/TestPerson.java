

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-06-12 14:13
 * @desc:
 */

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("zhao", "Zhen");

        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        String s = converter.convertToJson(person);
        System.out.println(s);

        System.out.println(person);

    }
}



/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-15 16:16
 * @desc:
 */

import lombok.Data;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        for(int i = 0; i < 30; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 10));
        }

        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("11");
        map.put("1", list);

        List<String> strings = map.get("1");
        strings.add("111");


        System.out.println(map.get("1"));


        String output = String.format("%s_%s_", "reload", "1.0.0-SNAPSHOT");
        System.out.println(output);

        List<String> initList = Arrays.asList("a", "b", "c");
        List<String> currentList = Arrays.asList("a", "b", "c", "d", "x");

        List<String> collect = currentList.stream().filter(x -> !(initList.contains(x))).collect(Collectors.toList());
        System.out.println(collect);

        List<User> users1 = Arrays.asList(new User("a", "1")
                , new User("b", "2"));

        List<String> collect1 = users1.stream().map(x -> x.getName() + x.getVersion()).collect(Collectors.toList());
        System.out.println(collect1);
    }

    @Data
    public static class User {
        String name;
        String version;

        public User(String name, String version) {
            this.name = name;
            this.version = version;
        }
    }
}

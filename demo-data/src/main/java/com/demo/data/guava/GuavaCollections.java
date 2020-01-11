package com.demo.data.guava;

/*
 * @author: zzhao3@ebay.com
 * @date: 2019-05-14 18:30
 * @desc:
 */

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import java.util.*;

public class GuavaCollections {

    public static void main(String[] args) {

//        testjoin();

//        testSplit();

        testPredict();

    }

    private static void testPredict() {
//        check null
        String obj = "234";
        int value = 1;
        String s = Preconditions.checkNotNull(obj); // s is a reference of obj
        Preconditions.checkArgument(value > 0, "Invalid value, value not > 1");

//        best practice
        new demoPredict("z");
    }

    static class demoPredict {
        private String name;
        public demoPredict(String name) {
            this.name = Preconditions.checkNotNull(name, "null name");
            Preconditions.checkState(validate(), "empty name");

            Preconditions.checkElementIndex(5, 4, "Illegal index");
        }
        private boolean validate() {
            return this.name.length() > 0;
        }
    }

    private static void testSplit() {
//        simple split
        String test = "alpha,beta,gamma,,delta,,";
        Iterable<String> parts = Splitter.on(",").split(test);
        parts.forEach(System.out::println);
        System.out.println(parts);

//        map split
        String mapString = "a=a,b=b";
        Map<String, String> split = Splitter.on(",").withKeyValueSeparator("=").split(mapString);
        split.forEach((x, y) -> System.out.println(x + "=" + y));

    }

    private static void testjoin() {
        //        Simple joiner
        List<String> strings = Arrays.asList("r", "o", "y", null, "b", "d", "z");
        String join = Joiner.on(",")
                .skipNulls()
                .join(strings);
        System.out.println(join);

        join = Joiner.on(",")
                .useForNull("*")
                .join(strings);
        System.out.println(join);

        List<Date> dates = Arrays.asList(new Date(), new Date());
        join = Joiner.on(",")
                .skipNulls()
                .join(dates);
        System.out.println(join);

//        map join
        Map<String, String> map = Maps.newLinkedHashMap();
        map.put("a", "a");
        map.put("b", "b");
        join = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(join);
    }
}

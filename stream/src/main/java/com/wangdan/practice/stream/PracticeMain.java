package com.wangdan.practice.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeMain {
    public static final Logger logger = LoggerFactory.getLogger(PracticeMain.class);
    public static void main(String[] args) {
        testSerial();
    }

    private static void testSerial() {
        Integer[] integers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        logger.info("1. create a integer stream, without terminal operation");
        Stream<Integer> integerStream = Arrays.asList(integers).stream()
                .map(integer->{
                    logger.info("multiply {} with 10", integer);
                    return integer * 10;
                })
                .map(integer -> {
                    logger.info("add {} with 5", integer);
                    return integer + 5;
                });
        logger.info("2. add a terminal operation to stream");
        List<Integer> integerList = integerStream.collect(Collectors.toList());
        logger.info("3. result {}", integerList);
    }
}

package com.example.invoice.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname EncryptionUtil
 * @Description TODO
 * @Date 2022/3/17 14:20
 * @Author by fuxf
 */
public class EncryptionUtil {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

      list.stream().forEach(System.out::println);
    }


    public static void group(Integer size, List<String> list){

        int number = list.size() / size;
        int remainder = list.size() % size;
        if (remainder > 0) {
            number++;
        }
        System.out.println("number:"+number);
        for (int i = 1; i < number; i++) {
            List<String> temp = new ArrayList<>();
            int fromIndex = (i - 1) * size;
            int toIndex = (size * i) > list.size() ? list.size() : (size * i);
            temp.addAll(list.subList(fromIndex,toIndex));
            System.out.println("第"+i+"次循环"+"====推送："+temp.toString());
        }

    }
}

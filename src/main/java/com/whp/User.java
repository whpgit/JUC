package com.whp;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 1:04 下午
 * @Describe
 * @Version V1.0
 */
@Data
public class User {

    private String userName;

    private int age;
    private boolean couponTemplateSign;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("user finalize ");
    }

    public static void main(String[] args) {
        User user1 = new User();
        user1.setAge(1);
        user1.setUserName("aa");
        User user2 = new User();
        user2.setAge(1);
        user2.setUserName("bb");
        User user3 = new User();
        user3.setAge(2);
        user3.setUserName("cc");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Map<Integer, Map<String, List<User>>> collect = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.groupingBy(User::getUserName)));
        System.out.println(collect);
    }
}

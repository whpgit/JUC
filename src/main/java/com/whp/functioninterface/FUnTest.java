package com.whp.functioninterface;

import com.whp.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: wanghp
 * @Date: 2021/7/25 8:15 下午
 * @Describe
 * @Version V1.0
 */
public class FUnTest {

    static void print(Consumer<User> consumer) {
        consumer.accept(null);
    }

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User() {{
            setUserName("wanghaiping");
        }});
        Fun<String, User> fun = key -> userList.stream().filter(u -> u.getUserName().equals(key)).findFirst().orElse(null);
//
        System.out.println(fun.get("wanghaiping").getUserName());

        print(key -> userList.stream().findFirst().orElse(null));


        try{

        }catch (Exception e){
        }
    }
}

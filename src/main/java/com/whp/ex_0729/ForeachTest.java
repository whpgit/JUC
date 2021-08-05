package com.whp.ex_0729;

import com.whp.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Author: wanghp
 * @Date: 2021/7/30 下午12:04
 * @Describe
 * @Version V1.0
 */
public class ForeachTest {

    public static void main(String[] args) {
        User u = new User();
        System.out.println(u.isCouponTemplateSign());
        List<User> userList = Arrays.asList(new User() {{
            setAge(1);
        }}, new User() {{
            setAge(2);
        }});

        Function<Integer, User> function = age -> userList.stream().filter(us -> us.getAge() == age).findFirst().orElse(null);

        function.apply(1).setAge(100);
        System.out.println(userList);


        for (User user : userList) {
            if (user.getAge() == 1) {
//                return;
            }
            System.out.println(user.toString());
        }
        System.out.println("====");
        userList.forEach(user -> {

            if (user.getAge() == 1) {
                return;
            }
            System.out.println(user.toString());
        });
    }
}

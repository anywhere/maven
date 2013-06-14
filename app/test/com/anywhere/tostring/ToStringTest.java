package com.anywhere.tostring;

import java.util.Date;

public class ToStringTest
{
    public static void main(String[] args)
    {
        User user = new User(0, "0000", new Date());
        User1 user1 = new User1(1, "0001", new Date());
        User2 user2 = new User2(2, "0002", new Date());
        User3 user3 = new User3(3, "0003", new Date());
        User4 user4 = new User4(4, "0004", new Date());
        user4.setName("john");
        System.out.println(user.toString());
        System.out.println("StringBuffer:" + user1.toString());
        System.out.println("ReflectionToStringBuilder:" + user2.toString());
        System.out.println("ToStringBuilder:" + user3.toString());
        System.out.println("ToStringBuilder.reflectionToString:" + user4.toString());
    }
}

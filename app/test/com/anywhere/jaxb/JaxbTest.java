package com.anywhere.jaxb;

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class JaxbTest {
    
    @Test
    public void testAccount() throws Exception {
        JAXBContext context = JAXBContext.newInstance(Account.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        URL xmlFileUrl = JaxbTest.class.getResource("/jaxb/account.xml");
        Account account = (Account) unmarshaller.unmarshal(xmlFileUrl);
        System.out.println(account.getId());
        System.out.println(account.getName());
    }
    
    @Test
    public void testUser() throws Exception {
        JAXBContext context = JAXBContext.newInstance(UserList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        URL xmlFileUrl = JaxbTest.class.getResource("/jaxb/users.xml");
        UserList userList = (UserList) unmarshaller.unmarshal(xmlFileUrl);
        System.out.println(userList.getUsers().get(0).getName());
        System.out.println(userList.getUsers().get(0).getId());
    }
}
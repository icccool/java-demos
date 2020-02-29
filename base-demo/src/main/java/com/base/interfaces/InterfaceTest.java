package com.base.interfaces;

import java.util.ArrayList;

public class InterfaceTest {

    public static void main(String[] args) {

        Message messageData = new MessageData<String>(false,"111");
        Message messageQuery = new MessageQuery<String>(new ArrayList<>());

        if(messageData instanceof Message){
            Message msg = (Message)messageData;
            if(msg.success){
                System.out.printf("123");
            }
        }

    }

}

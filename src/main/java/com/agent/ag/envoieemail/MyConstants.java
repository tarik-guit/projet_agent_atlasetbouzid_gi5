package com.agent.ag.envoieemail;

import lombok.Data;

@Data

public class MyConstants {



    // Replace with your email here:
    public static final String MY_EMAIL = "essaie.programme@gmail.com";

    // Replace password!!
    public static final String MY_PASSWORD = "pourprogrammer";

    // And receiver!
    public  String FRIEND_EMAIL ;
    public  String SUBJECT_EMAIL ;
    public  String TEXT_EMAIL ;

    public MyConstants(String FRIEND_EMAIL, String SUBJECT_EMAIL, String TEXT_EMAIL) {
        this.FRIEND_EMAIL = FRIEND_EMAIL;
        this.SUBJECT_EMAIL = SUBJECT_EMAIL;
        this.TEXT_EMAIL = TEXT_EMAIL;
    }
}
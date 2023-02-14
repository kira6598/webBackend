package com.example.webbanhangfinal.auththenticate.Login.JWT;

import java.lang.reflect.Field;

import com.example.webbanhangfinal.auththenticate.UserManagerment.AppUser;

public class testReflextion {
    public static void main(String[] args) {
        AppUser user = new AppUser();
        try {
            demoReflextion(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void demoReflextion(Object object) throws ClassNotFoundException{
       Class<?> clazz = object.getClass();
       System.out.println(clazz.getSimpleName()); 
       Field[] fields = clazz.getDeclaredFields();
       for (Field field : fields) {
        System.out.println(field);
       }
       
    }
}
//package com.library.foxwearmanagement.util;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class PasswordUtil {
//    public static String encryptPassword(String password) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(password);
//    }
//
//    public static boolean checkPassword(String password, String encodedPassword) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.matches(password, encodedPassword);
//    }
//}

package com.demo1;

import java.util.Scanner;

/**
 * program: 20200511
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-11 09
 * Time:08
 */

class UserError extends Exception {
    public UserError(String message) {
        super(message);
    }
}

class PasswordError extends Exception {
    public PasswordError(String message) {
        super(message);
    }
}
public class TestDemo {

    private static String userName = "admin";
    private static String password = "123456";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        try {
            login(str1,str2);
        }catch (UserError userError) {
            userError.printStackTrace();
        }catch (PasswordError passwordError) {
            passwordError.printStackTrace();
        }
    }

    public static void login(String userName, String password) throws UserError, PasswordError {
        if (!TestDemo.userName.equals(userName)) {
            throw new UserError("用户名错误！");
        }
        if (!TestDemo.password.equals(password)) {
            throw new PasswordError("密码错误！");
        }
        System.out.println("登陆成功！");
    }
}

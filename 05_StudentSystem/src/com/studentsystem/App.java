package com.studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static void main(String[] args) {
        ArrayList<Users> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("欢迎来到学生系统");
            System.out.println("请选择操作：1登录  2注册  3忘记密码  4退出");
            String choose = sc.next();
            switch(choose){
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                }
            }
        }
    }

    static void login(ArrayList<Users> list) {
        Scanner sc = new Scanner(System.in);
        Users user = null;

        while (true) {
            System.out.println("输入用户名");
            String uname = sc.next();

            user = null;

            for (int i = 0; i < list.size(); i++) {
                Users u = list.get(i);

                if(uname.equals(u.getName())) {
                    user = u;
                    break;
                }
            }

            if(user == null){
                System.out.println("用户不存在，请先注册");
                continue;
            }
            break;
        }

        while(true){
            System.out.println("请输入验证码123");
            String input = sc.next();

            if(!(input.equals("123"))){
                System.out.println("验证码错误");
                continue;
            }
            break;
        }

        int flag = 3;
        String password = user.getPassword();
        while(flag>0){
            System.out.println("请输入密码");
            String upassword = sc.next();

            if(!password.equals(upassword)){
                flag--;
                System.out.println("密码错误，你还有"+ flag +"次机会");
                continue;
            }
            System.out.println("登录成功");
            break;
        }
        if(flag == 0){
            System.out.println("密码验证失败，自动返回");
        }
    }

    static void register(ArrayList<Users> list) {
        Scanner sc = new Scanner(System.in);
        String name;
        String password;
        String ID;
        String phone;

        while (true) {
            System.out.println("请输入用户名，要求：长度3-15位，数字加字母，不能纯数字");
            name = sc.next();

            if(nameContains(list, name)) {
                System.out.println("用户名已存在，请重新输入");
            }
            else if(name.length()>15 || name.length()<3){
                System.out.println("用户名要求长度3-15位，请重新输入");
            }
            else if (!name.matches("^(?=.*[A-Za-z])[A-Za-z0-9]+$")) {
                System.out.println("用户名要求数字加字母，不能纯数字，请重新输入");
            }else break;
        }

        while(true){
            System.out.println("请输入密码");
            password = sc.next();

            System.out.println("请再次输入密码");
            String againpassword = sc.next();

            if(password.equals(againpassword)) {
                break;
            }
            else{
                System.out.println("两次密码不一致，请重新输入");
            }
        }

        while(true){
            System.out.println("请输入身份证id");
            ID = sc.next();

            if(ID.length() != 18){
                System.out.println("ID不合规,请重新输入");
                continue;
            }
            if(ID.charAt(0) == '0'){
                System.out.println("ID不合规,请重新输入");
                continue;
            }
            boolean valid = true;

            for (int i = 0; i < 17; i++) {
                char c = ID.charAt(i);

                if(c < '0' || c > '9'){
                    valid = false;
                    break;
                }
            }
            if(!valid){
                System.out.println("ID不合规,请重新输入");
                continue;
            }
            char last = ID.charAt(17);
            if(!((last >= '0' && last <= '9') ||
                    last == 'X' ||
                    last == 'x')){
                System.out.println("ID不合规,请重新输入");
                continue;
            }
            break;
        }

        while(true){
            System.out.println("请输入手机号");
            phone = sc.next();
            if(phone.length() != 11){
                System.out.println("输入要求是11位数字");
                continue;
            }
            char firstChar = phone.charAt(0);
            if(firstChar == '0'){
                System.out.println("不能以0为开头");
                continue;
            }
            if(!(phone.matches("[0-9]{11}"))){
                System.out.println("输入要求是11位数字");
                continue;
            }
            break;
        }

        Users user = new Users(name, password, ID, phone);
        list.add(user);
        System.out.println("用户注册成功");


    }

    static void forgetPassword(ArrayList<Users> list) {
        Scanner sc = new Scanner(System.in);
        Users user = null;

        while (true) {
            System.out.println("请输入用户名");
            String uname = sc.next();

            user = null;

            for (int i = 0; i < list.size(); i++) {
                Users u = list.get(i);

                if(uname.equals(u.getName())){
                    user = u;
                    break;
                }
            }

            if (user == null) {
                System.out.println("未注册");
                continue;
            }
            break;
        }

        System.out.println("请输入身份证号：");
        String uID = sc.next();
        if(!uID.equals(user.getID())){
            System.out.println("身份证号错误");
            return;
        }
        System.out.println("请输入手机号：");
        String unumber = sc.next();
        if(!unumber.equals(user.getNumber())){
            System.out.println("手机号错误");
            return;
        }
        while (true) {
            System.out.println("输入新密码：");
            String newpasspord = sc.next();
            if(newpasspord.equals(user.getPassword())){
                System.out.println("不能与旧密码相同！");
                return;
            }
            System.out.println("再次输入新密码：");
            String againnewpasspord = sc.next();
            if(!newpasspord.equals(againnewpasspord)) {
                System.out.println("两次密码不一致，请重新输入！");
                continue;
            }else{
                user.setPassword(newpasspord);
                System.out.println("密码重置成功！");
                return;
            }
        }


    }

    static boolean nameContains(ArrayList<Users> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            Users user = list.get(i);
            String uname = user.getName();
            if(uname.equals(name)){
                return true;
            }
        }
        return false;
    }
}

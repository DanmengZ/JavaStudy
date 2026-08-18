package com.studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    static void main() {
        ArrayList<Student> list = new ArrayList<>();
        loop:
        while (true) {
            System.out.println("-----欢迎使用学生系统----");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5: 退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> delStudent(list);
                case "3" -> altStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    static void addStudent(ArrayList<Student> list) {
        Student s = new Student();

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("输入学生id");
            String id = sc.next();
            if (!contains(list, id)) {
                s.setId(id);
                break;
            } else {
                System.out.println("此id已经存在");

            }
        }

        System.out.println("输入学生姓名");
        String name = sc.next();
        s.setName(name);

        System.out.println("输入学生年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("输入学生家庭住址");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);
        System.out.println("添加成功");

    }

    static void delStudent(ArrayList<Student> list) {
        System.out.println("输入删除学生的id：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        if(index < 0){
            System.out.println("学生不存在");
        }else{
            list.remove(index);
            System.out.println("id为"+id+"的学生已经删除");
        }
    }

    static void altStudent(ArrayList<Student> list) {
        System.out.println("输入修改学生的id：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();

        if(!contains(list, id)){
            System.out.println("该学生不存在,请重新输入");
            return;
        }else{
            int index = getIndex(list, id);
            Student s = list.get(index);
            System.out.println("输入学生姓名");
            String name = sc.next();
            s.setName(name);

            System.out.println("输入学生年龄");
            int age = sc.nextInt();
            s.setAge(age);

            System.out.println("输入学生家庭住址");
            String address = sc.next();
            s.setAddress(address);

            System.out.println("修改成功");
        }

    }

    static void queryStudent(ArrayList<Student> list) {
        //System.out.println("查询学生");
        if (list.isEmpty()) {
            System.out.println("无学生信息");
        } else {
            System.out.println("id\t\t姓名\t年龄\t家庭住址");
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
            }
        }
    }

    static boolean contains(ArrayList<Student> list, String id) {
        int flag = getIndex(list, id);
        if(flag < 0){
            return false;
        }else
            return true;
    }

    static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if (id.equals(sid)){
                return i;
            }
        }
        return -1;
    }
}

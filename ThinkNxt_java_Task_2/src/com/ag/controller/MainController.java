package com.ag.controller;

import com.ag.dto.Student;

import java.util.Scanner;

public class MainController {
     Student[] studentStore=new Student[5];
     int count=0;
     //Changing Name of Student
     public void changeName(int id,String newName){
        for(Student st:studentStore){
            if (st !=null){
                if (st.getSid()==id){
                    System.out.println("Before Updating Name");
                    System.out.println(st);
                    st.setSname(newName);
                    System.out.println("After update name");
                    System.out.println(st);
                }
            }
        }
    }
    //Add Student
    public  void addStudent(Student student){
        if(student!=null){
            studentStore[count]=student;
            System.out.println("Student added Successfully");
            count++;
        }
    }
    //Find student by id
    public  Student getStudentById(int sid){
        for(Student st:studentStore) {
            if(st!=null) {
                if(st.getSid()==sid) {
                    return st;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Scanner scn = new Scanner(System.in);

        int option=0;
        while (option!=4){
            System.out.println("1)Add Student\n"+"2)Find Student by Id\n"+"3)Change Name by Id\n"+"4)Exit");

            option= scn.nextInt();

            switch (option){
                case 1:
                    System.out.println("enter Student Id");
                    int sid=scn.nextInt();
                    System.out.println("Enter Student Name");
                    String sname=scn.next();
                    System.out.println("Enter Student Roll Number");
                    int srollno=scn.nextInt();

                    Student student = new Student();
                    student.setSid(sid);
                    student.setSname(sname);
                    student.setSrollno(srollno);
                    mainController.addStudent(student);
                    break;
                case 2:
                    System.out.println("Enter Student Id");
                    sid=scn.nextInt();
                    Student studentFound=mainController.getStudentById(sid);
                    if (studentFound!=null){
                    System.out.println(studentFound);
                    }
                    else{
                         System.out.println("Student not Found with the given Id");
                        }
                    break;
                case 3:
                    boolean flag=true;
                    while (flag) {
                        System.out.println("Enter student id which student name you want to update");
                        sid = scn.nextInt();
                        Student studentById = mainController.getStudentById(sid);
                        if (studentById != null) {
                            System.out.println("Enter new name for the given student id");
                            sname = scn.next();
                            mainController.changeName(sid, sname);
                            flag=false;
                        } else {
                            System.out.println("Student not found with given Id\n" + "please enter correct Id");
                        }
                    }
                    break;
            }
        }
        System.out.println("Thank you");
    }
}
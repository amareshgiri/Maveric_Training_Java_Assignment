package com.ag.controller;

import com.ag.dto.Customer;
import com.ag.dto.FeedBack;

import java.util.Scanner;

public class MainController {
    Customer[] customerStore = new Customer[3];
    FeedBack[] feedBackStore = new FeedBack[3];
    FeedBack[] feedbacksByCustomerId = new FeedBack[5];

    int customer_count = 0;
    int feedback_count = 0;
    int feedbacksByCustomerId_count = 0;

    public void changeName(int id, String newName) {
        for (Customer c : customerStore) {
            if (c != null) {
                if (c.getCid() == id) {
                    System.out.println("Before Updating Name");
                    System.out.println(c);
                    c.setSname(newName);
                    System.out.println("After update name");
                    System.out.println(c);
                }
            }
        }
    }

    public void registerCustomer(Customer customer) {
        if (customer != null) {
            customerStore[customer_count] = customer;
            System.out.println("Customer Register Successfully");
            customer_count++;
        }
    }

    public void addFeedBack(FeedBack feedBack) {
        if (feedBack != null) {
            feedBackStore[feedback_count] = feedBack;
            System.out.println("FeedBack added Successfully");
            feedback_count++;
        }
    }

    public FeedBack[] getFeedbacksByCustomerId(int cid) {
        for (FeedBack fs : feedBackStore) {
            if (fs != null) {
                if (fs.getCustomer().getCid() == cid) {
                    feedbacksByCustomerId[feedbacksByCustomerId_count] = fs;
                    feedbacksByCustomerId_count++;
                }
            }
        }
        return feedbacksByCustomerId != null ? feedbacksByCustomerId : null;
    }

    public Customer getCustomerById(int cid) {
        for (Customer customer : customerStore) {
            if (customer != null) {
                if (customer.getCid() == cid) {
                    return customer;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {

        MainController mainController = new MainController();
        Scanner sc = new Scanner(System.in);

        int option=0;
        while(option !=5) {
            System.out.println("1) Register customer in customer store\n"
                    + "2) Add feedback in feedback store\n"
                    + "3) Fetch all feedbacks by customer id\n"
                    + "4) Change customer name by id\n"
                    + "5) Exit\n");

            option = sc.nextInt();

            switch(option) {

                case 1:
                    System.out.println("Enter customer id");
                    int cid = sc.nextInt();
                    System.out.println("Enter customer Name");
                    String cname = sc.next();

                    Customer customer = new Customer();
                    customer.setSid(cid);
                    customer.setSname(cname);
                    mainController.registerCustomer(customer);
                    break;
                case 2:
                    System.out.println("Enter customer id under which customer name you want to give feedback");
                    cid = sc.nextInt();
                    Customer customerFound = mainController.getCustomerById(cid);
                    if(customerFound != null) {
                        System.out.println("Enter Feedback id");
                        int fid = sc.nextInt();
                        System.out.println("Enter Feddback Description");
                        String fdescription = sc.next();

                        FeedBack feedback = new FeedBack();
                        feedback.setFid(fid);
                        feedback.setFDescription(fdescription);
                        feedback.setCustomer(customerFound);

                        mainController.addFeedBack(feedback);
                    }else {
                        System.out.println("Customer not found with the given id to give the feedbacks");
                    }

                    break;

                case 3:
                    System.out.println("Enter Customer id");
                    cid = sc.nextInt();
                    FeedBack[] feedbacksFound = mainController.getFeedbacksByCustomerId(cid);

                    for(FeedBack feedback:feedbacksFound) {
                        if(feedback!=null) {
                            System.out.println(feedback);
                        }
                    }
                    mainController.feedbacksByCustomerId = new FeedBack[5];
                    break;

                case 4:
                    boolean flag=true;
                    while(flag) {
                        System.out.println("Enter customer id which customer name you want to update");
                        cid = sc.nextInt();

                        Customer customerById = mainController.getCustomerById(cid);
                        if(customerById!=null) {
                            System.out.println("Enter new name for the given customer id");
                            cname = sc.next();
                            mainController.changeName(cid, cname);
                            flag=false;
                        }else {
                            System.out.println("Customer not found with the given id to change name");
                        }
                    }
                    break;
            }
        }
        System.out.println("Thank you");
        sc.close();
    }
}

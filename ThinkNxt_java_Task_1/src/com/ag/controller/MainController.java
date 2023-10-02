package com.ag.controller;

import com.ag.dto.Product;
import com.ag.services.ProductServices;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {

//		List<Product> productsList= new ArrayList<>();
        Product[] products = new Product[5];
        int size = 0;
        Scanner sc = new Scanner(System.in);
        ProductServices productServices = new ProductServices(products, size);


        int option = 1;
        while(option!=4) {
            System.out.println("1) Add products to array\n"
                    + "2)iterate on array and print details of products\n"
                    + "3) find product by id and print details of product\n"
                    + "4) increasePriceById");

            option = sc.nextInt();

            switch(option) {
                case 1:
                    System.out.println("Enter product pid");
                    long pid = sc.nextLong();
                    System.out.println("Enter product price");
                    double price = sc.nextDouble();
                    Product product = new Product();
                    product.setPid(pid);
                    product.setPprice(price);
                    productServices.registerProduct(product);
                    break;
                case 2:
                    Product[] allProducts = productServices.getAllProducts();
                    for(Product p: allProducts) {
                        if(p!=null) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter product pid");
                    long id = sc.nextLong();
                    Product productFound = productServices.getProductById(id);
                    if(productFound != null) {
                        System.out.println(productFound);
                    }else {
                        System.out.println("Product not found with the given id");
                    }
                    break;
                case 4:
                    System.out.println("Enter product id for which product you want to update the price");
                    id = sc.nextLong();
                    System.out.println("Enter amount that you want to update");
                    double amount = sc.nextDouble();
                    productServices.increasePriceById(amount, id);
            }
        }
        System.out.println("Thank you");
        sc.close();
    }
}

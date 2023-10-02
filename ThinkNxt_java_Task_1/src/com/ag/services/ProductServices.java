package com.ag.services;

import com.ag.dto.Product;

public class ProductServices {
    Product[] products;
    int size ;

    public ProductServices(Product[] products, int size) {
        this.products = products;
        this.size=size;
    }

    //	1) Add products to array
    public void registerProduct(Product product) {
        this.products[size] = product;
        size++;
    }

    //	2)iterate on array and print details of products
    public Product[] getAllProducts() {
        return products;
    }

    //	3) find product by id and print details of product
    public Product getProductById(long id) {
        for (Product p : products) {
            if(p!=null) {
                if (p.getPid() == id) {
                    return p;
                }
            }
        }
        return null;
    }

    public void increasePriceById(double amount, long id) {
        for (Product p : products) {
            if(p!=null) {
                if(p.getPid() == id) {
                    System.out.println("Before price update:"+p);
                    p.setPprice(p.getPprice()+amount);
                    System.out.println("After price update:"+p);
                }
            }
        }
    }
}

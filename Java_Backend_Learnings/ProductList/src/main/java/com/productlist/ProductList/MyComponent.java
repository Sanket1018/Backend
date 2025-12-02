package com.productlist.ProductList;

import org.springframework.stereotype.Component;


public class MyComponent {


    MyApp myapp;

    public void message()
    {
        System.out.println("Hello from component");
    }

    public MyComponent(MyApp myapp)
    {
        this.myapp=myapp;
    }

    public MyComponent() {
        System.out.println("Hello from my component");
    }
}

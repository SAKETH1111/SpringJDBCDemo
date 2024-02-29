package com.telusko.SpringJDBCDemo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Alien {
    private int age;
    private String name;

    private String tech;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        System.out.println("I am here");
        return "Alien{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}

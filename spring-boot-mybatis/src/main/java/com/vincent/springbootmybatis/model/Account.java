package com.vincent.springbootmybatis.model;

public class Account {
    private int id;
    private String name;
    private double money;

    public Account() {
        super();
    }

    public Account(String name, double money) {
        super();
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

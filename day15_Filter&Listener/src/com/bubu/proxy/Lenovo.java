package com.bubu.proxy;

public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("卖出电脑：" + money);
        return "Lenovo";
    }

    @Override
    public void show() {
        System.out.println("Lenovo show");
    }
}

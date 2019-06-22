package com.rmi;

public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int getAdd(int a, int b) {
        System.out.println("a=" + a + ",b=" + b);
        return a + b;
    }
}

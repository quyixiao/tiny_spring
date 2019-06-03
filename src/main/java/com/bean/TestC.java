package com.bean;

public class TestC {
    private TestA testA;
    public TestC(TestA a ){
        this.testA = a;
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}

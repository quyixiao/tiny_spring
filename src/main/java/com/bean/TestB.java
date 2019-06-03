package com.bean;

public class TestB {

    private TestC testC;

    public TestB(TestC c ){
        this.testC = c;
    }


    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}

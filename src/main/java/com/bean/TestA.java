package com.bean;

public class TestA {
    private TestB testB;
    public TestA(TestB b ){
        this.testB = b;
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}

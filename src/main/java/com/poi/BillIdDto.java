package com.poi;

public class BillIdDto {

    private Long billId;

    private String tempValue;

    private Integer var;


    public BillIdDto(Long billId, String tempValue,Integer var) {
        this.billId = billId;
        this.tempValue = tempValue;
        this.var = var;
    }

    public String getTempValue() {
        return tempValue;
    }

    public void setTempValue(String tempValue) {
        this.tempValue = tempValue;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Integer getVar() {
        return var;
    }

    public void setVar(Integer var) {
        this.var = var;
    }
}

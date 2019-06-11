package com.poi;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

@ExcelTarget("borrowInfo")
public class BorrowInfo {

    @Excel(name = "标的名称",needMerge = true, mergeVertical = true,width = 20)
    private String title ;


    @Excel(name = "借款金额",needMerge = true, mergeVertical = true)
    private String borrowAmount ;


    @Excel(name = "借款利率",needMerge = true, mergeVertical = true)
    private String apr ;


    @Excel(name = "借款期限",needMerge = true, mergeVertical = true)
    private String borrowPeriod;


    @Excel(name = "放款日期",needMerge = true, mergeVertical = true)
    private String releaseTime;


    @Excel(name = "到期日期",needMerge = true, mergeVertical = true)
    private String lastRepayTime;


    @Excel(name = "投资人名称",needMerge = true, mergeVertical = true)
    private String realName;

    @Excel(name = "联系方式",needMerge = true, mergeVertical = true,width = 20)
    private String mobile;


    @Excel(name = "身份证号码",needMerge = true, mergeVertical = true,width = 25)
    private String idNumber;



    @Excel(name = "投资金额",needMerge = true, mergeVertical = true)
    private String investAmount;

    @Excel(name = "第几期")
    private String period;

    @Excel(name = "每期回款时间")
    private String repayTime;

    @Excel(name = "每期回款金额")
    private String repayAmount;

    @Excel(name = "是否已结清")
    private String isFinished;


    @Excel(name = "billId")
    private Long billId;

    @Excel(name = "borrowId")
    private Long borrowId;


    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(String borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getBorrowPeriod() {
        return borrowPeriod;
    }

    public void setBorrowPeriod(String borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getLastRepayTime() {
        return lastRepayTime;
    }

    public void setLastRepayTime(String lastRepayTime) {
        this.lastRepayTime = lastRepayTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }

    public String getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(String repayAmount) {
        this.repayAmount = repayAmount;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }
}

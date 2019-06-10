package com.poi;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.utils.DateUtil;


import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: djc
 * @Desc:
 * @Date: 2019/5/22 14:13
 */
@ExcelTarget("cashbackDto")
public class CashbackDto{

    @Excel(name = "序号",needMerge = true, mergeVertical = true)
    private String serialNo ;


    @Excel(name = "到期时间", format = DateUtil.DEFAULT_PATTERN_WITH_HYPHEN)
    private Date gmtExpire ;


    @Excel(name = "还款时间", format = DateUtil.DATE_TIME_SHORT)
    private Date gmtRepay ;


    @Excel(name = "用户姓名")
    private String userName ;

    @Excel(name = "用户手机号码")
    private String phone ;


    @Excel(name = "借款总金额",needMerge = true, mergeVertical = true)
    private BigDecimal borrowAmount ;


    @Excel(name = "账期")
    private Integer curNper ;


    @Excel(name = "本期还款总金额")
    private BigDecimal repayAmount ;


    @Excel(name = "应发红包金额")
    private BigDecimal rewardAmount ;


    @Excel(name = "备注")
    private String remark ;


    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Date getGmtExpire() {
        return gmtExpire;
    }

    public void setGmtExpire(Date gmtExpire) {
        this.gmtExpire = gmtExpire;
    }

    public Date getGmtRepay() {
        return gmtRepay;
    }

    public void setGmtRepay(Date gmtRepay) {
        this.gmtRepay = gmtRepay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(BigDecimal borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public Integer getCurNper() {
        return curNper;
    }

    public void setCurNper(Integer curNper) {
        this.curNper = curNper;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}


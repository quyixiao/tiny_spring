package com.poi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.jdbc.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRowMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setTitle(rs.getString("title"));
        borrowInfo.setBorrowAmount(rs.getString("borrowAmount"));
        borrowInfo.setApr(rs.getString("apr"));
        borrowInfo.setBorrowPeriod(rs.getString("borrowPeriod"));
        borrowInfo.setReleaseTime(rs.getString("releaseTime"));
        borrowInfo.setLastRepayTime(rs.getString("lastRepayTime"));
        borrowInfo.setRealName(rs.getString("realName"));
        borrowInfo.setMobile(rs.getString("mobile"));
        borrowInfo.setIdNumber(rs.getString("idNumber"));
        borrowInfo.setInvestAmount(rs.getString("investAmount"));
        borrowInfo.setPeriod(rs.getString("period"));
        borrowInfo.setRepayTime(rs.getString("repayTime"));
        borrowInfo.setRepayAmount(rs.getString("repayAmount"));
        borrowInfo.setIsFinished(rs.getString("isFinished"));
        borrowInfo.setBillId(rs.getLong("billId"));
        borrowInfo.setBorrowId(rs.getLong("borrowId"));
        return borrowInfo;
    }
}

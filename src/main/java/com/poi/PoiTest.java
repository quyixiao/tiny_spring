package com.poi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PoiTest {


    private String title;
    private String borrowAmount;
    private String apr;
    private String borrowPeriod;
    private String releaseTime;
    private String lastRepayTime;
    private String realName;
    private String mobile;
    private String idNumber;
    private String investAmount;
    private String period;
    private String repayTime;
    private String repayAmount;
    private String isFinished;
    private Long billId;
    private Long borrowId;


    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans7.xml");
        BorrowService borrowService = (BorrowService) applicationContext.getBean("borrowService");

        List<BorrowInfo> borrowInfos = borrowService.getAllBorrows();


        List<BorrowInfo> newBorrowInfos = new ArrayList<>();
        int k = 0;
        int l = 0;
        Long maxBorrowId = 0l;
        Long maxBillId = 0l;
        for (int i = 0; i < borrowInfos.size(); i++) {
            BorrowInfo borrowInfo = borrowInfos.get(i);
            if (borrowInfo.getBorrowId() > maxBorrowId) {
                maxBorrowId = borrowInfo.getBorrowId();
                k++;
            }
            String borrowTemp = "_a";
            if (k % 2 == 0) {
                borrowTemp = "_b";
            }
            BorrowInfo b = new BorrowInfo();
            b.setTitle(borrowInfo.getTitle());
            b.setBorrowAmount(borrowInfo.getBorrowAmount() + borrowTemp);
            b.setApr(borrowInfo.getApr() + borrowTemp);
            b.setBorrowPeriod(borrowInfo.getBorrowPeriod() + borrowTemp);
            b.setReleaseTime(borrowInfo.getReleaseTime() + borrowTemp);
            b.setLastRepayTime(borrowInfo.getLastRepayTime() + borrowTemp);


            if (borrowInfo.getBillId() > maxBillId) {
                maxBillId = borrowInfo.getBillId();
                l++;
            }
            String investTemp = "_a";
            if (l % 2 == 0) {
                investTemp = "_b";
            }

            b.setRealName(borrowInfo.getRealName() + investTemp);
            b.setMobile(borrowInfo.getMobile() + investTemp);
            b.setIdNumber(borrowInfo.getIdNumber() + investTemp);
            b.setInvestAmount(borrowInfo.getInvestAmount() + investTemp);


            b.setPeriod(borrowInfo.getPeriod());
            b.setRepayTime(borrowInfo.getRepayTime());
            b.setRepayAmount(borrowInfo.getRepayAmount());
            b.setIsFinished(borrowInfo.getIsFinished());
            newBorrowInfos.add(b);
        }


        System.out.println(borrowInfos.size());

        Workbook sheets = ExcelExportUtil.exportExcel(new ExportParams(), BorrowInfo.class, newBorrowInfos);


        String fileName = "/Users/quyixiao/git/tiny_spring/src/test/java/data_result1.xls";

        FileOutputStream fos = new FileOutputStream(fileName);

        sheets.write(fos);

        fos.close();


    }
}

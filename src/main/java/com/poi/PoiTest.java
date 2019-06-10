package com.poi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.jdbc.UserSerivce;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileOutputStream;
import java.util.List;

public class PoiTest {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans7.xml");
        BorrowService borrowService = (BorrowService) applicationContext.getBean("borrowService");

        List<BorrowInfo> borrowInfos = borrowService.getAllBorrows();
        System.out.println(borrowInfos.size());

        Workbook sheets = ExcelExportUtil.exportExcel(new ExportParams(), BorrowInfo.class, borrowInfos);


        String fileName = "/Users/quyixiao/git/tiny_spring/src/test/java/data_result1.xls";

        FileOutputStream fos = new FileOutputStream(fileName);

        sheets.write(fos);

        fos.close();


    }
}

package com.poi;

import com.jdbc.User;
import com.jdbc.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BorrowServiceImpl implements BorrowService {



    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<BorrowInfo> getAllBorrows() {

        String sql = "select \n" +
                "tb.title as title,\n" +
                "tb.amount as borrowAmount,\n" +
                "tb.apr as apr,\n" +
                "case when tb.period_unit = 1 then  CONCAT(tb.period,'天') \n" +
                "\telse CONCAT(tb. period ,'月') end borrowPeriod,\n" +
                " DATE_FORMAT(tb.release_time , '%Y-%m-%d') as releaseTime,\n" +
                "  DATE_FORMAT(tb.last_repay_time , '%Y-%m-%d') as lastRepayTime,\n" +
                "tui.reality_name as realName,\n" +
                "tu.mobile as mobile,\n" +
                "tui.id_number as idNumber,\n" +
                "ti.amount as investAmount,\n" +
                "concat(tbi.period,'期')  as  period,\n" +
                "(select  DATE_FORMAT(tb.repayment_time  , '%Y-%m-%d') from t_bill tb where tb.bid_id = tbi.bid_id and tb.period = tbi.period ) as repayTime,\n" +
                "(tbi.receive_corpus + tbi.receive_interest + tbi.overdue_fine + tbi.pre_interest + tbi.add_invest + tbi.pre_penalty  )  as repayAmount,\n" +
                " case when tb.status = 5  then '是'\n" +
                " else '' end isFinished,\n" +
                " ti.id as billId,\n" +
                " tb.id as borrowId\n" +
                "  from t_bill_invest tbi \n" +
                "left join t_invest ti on tbi.invest_id = ti.id \n" +
                "left join t_bid tb on tbi.bid_id = tb.id \n" +
                "left join t_user tu on tu.id = tbi.user_id\n" +
                "left join t_user_info tui on tbi.user_id = tui.user_id   ORDER BY tb.id asc ,ti.id  asc    ";
               // "where tb.status = 5 and tb.period_unit = 2  and tb.period > 1  ORDER BY tb.id asc ,ti.id  asc   ";

        System.out.println(sql);

        List<BorrowInfo> list = jdbcTemplate.query(sql, new BorrowRowMapper());

        return list;
    }
}

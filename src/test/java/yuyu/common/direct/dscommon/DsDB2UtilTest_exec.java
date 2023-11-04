package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsDB2Util.E_Result;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳＤＢ２ユーティリティのメソッド{@link DsDB2Util#exec(Throwable)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsDB2UtilTest_exec {

    @Inject
    private DsDB2Util dsDB2Util;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        Throwable t = new java.io.IOException();
        E_Result result = dsDB2Util.exec(t);

        exEnumEquals(result, E_Result.OTHER, "判定結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        Throwable t = new org.hibernate.exception.GenericJDBCException("", new java.sql.SQLException());
        E_Result result = dsDB2Util.exec(t);

        exEnumEquals(result, E_Result.OTHER, "判定結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        Throwable t = new org.hibernate.exception.GenericJDBCException("", new com.ibm.db2.jcc.am.SqlException("SQLException:00C90088"));
        E_Result result = dsDB2Util.exec(t);

        exEnumEquals(result, E_Result.DEADLOCK, "判定結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        Throwable t = new org.hibernate.exception.GenericJDBCException("", new com.ibm.db2.jcc.am.SqlException("SQLException:00C9008E"));
        E_Result result = dsDB2Util.exec(t);

        exEnumEquals(result, E_Result.QUERY_TIMEOUT, "判定結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        Throwable t = new org.hibernate.exception.GenericJDBCException("", new com.ibm.db2.jcc.am.SqlException("SQLException:XXXXXXXX"));
        E_Result result = dsDB2Util.exec(t);

        exEnumEquals(result, E_Result.OTHER, "判定結果");
    }
}

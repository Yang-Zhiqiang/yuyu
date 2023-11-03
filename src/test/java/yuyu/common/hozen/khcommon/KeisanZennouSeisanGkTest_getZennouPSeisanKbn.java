package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納精算額計算クラスのメソッド {@link KeisanZennouSeisanGk#getZennouPSeisanKbn(BizDate, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGkTest_getZennouPSeisanKbn {

    @Inject
    private KeisanZennouSeisanGk keisanZennouSeisanGk;

    @Test
    @TestOrder(010)
    public void testGetZennouPSeisanKbn_A1() {

        BizDate ryosyuymd = BizDate.valueOf("20170422");
        BizDate denYmd = BizDate.valueOf("20160405");
        String zennouPSeisanKbn = keisanZennouSeisanGk.getZennouPSeisanKbn(ryosyuymd, denYmd);

        exStringEquals(zennouPSeisanKbn, "1", "前納Ｐ精算区分");
    }

    @Test
    @TestOrder(020)
    public void testGetZennouPSeisanKbn_A2() {

        BizDate ryosyuymd = BizDate.valueOf("20170321");
        BizDate denYmd = BizDate.valueOf("20170320");
        String zennouPSeisanKbn = keisanZennouSeisanGk.getZennouPSeisanKbn(ryosyuymd, denYmd);

        exStringEquals(zennouPSeisanKbn, "1", "前納Ｐ精算区分");
    }

    @Test
    @TestOrder(030)
    public void testGetZennouPSeisanKbn_A3() {

        BizDate ryosyuymd = BizDate.valueOf("20170203");
        BizDate denYmd = BizDate.valueOf("20180206");
        String zennouPSeisanKbn = keisanZennouSeisanGk.getZennouPSeisanKbn(ryosyuymd, denYmd);

        exStringEquals(zennouPSeisanKbn, "2", "前納Ｐ精算区分");
    }
}

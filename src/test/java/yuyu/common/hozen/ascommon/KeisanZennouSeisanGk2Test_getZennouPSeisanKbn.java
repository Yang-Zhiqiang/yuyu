package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納精算額計算２クラスのメソッド {@link KeisanZennouSeisanGk2#getZennouPSeisanKbn(BizDate, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGk2Test_getZennouPSeisanKbn {

    @Inject
    private KeisanZennouSeisanGk2 keisanZennouSeisanGk2;

    @Test
    @TestOrder(10)
    public void testGetZennouPSeisanKbn_A1() {

        BizDate ryosyuymd = BizDate.valueOf("20170422");
        BizDate denYmd = BizDate.valueOf("20160405");

        String zennouPSeisanKbn = keisanZennouSeisanGk2.getZennouPSeisanKbn(ryosyuymd, denYmd);

        exStringEquals(zennouPSeisanKbn, "1", "前納Ｐ精算区分");
    }

    @Test
    @TestOrder(20)
    public void testGetZennouPSeisanKbn_A2() {

        BizDate ryosyuymd = BizDate.valueOf("20170321");
        BizDate denYmd = BizDate.valueOf("20170320");

        String zennouPSeisanKbn = keisanZennouSeisanGk2.getZennouPSeisanKbn(ryosyuymd, denYmd);

        exStringEquals(zennouPSeisanKbn, "1", "前納Ｐ精算区分");
    }

    @Test
    @TestOrder(30)
    public void testGetZennouPSeisanKbn_A3() {

        BizDate ryosyuymd = BizDate.valueOf("20170203");
        BizDate denYmd = BizDate.valueOf("20180206");

        String zennouPSeisanKbn = keisanZennouSeisanGk2.getZennouPSeisanKbn(ryosyuymd, denYmd);

        exStringEquals(zennouPSeisanKbn, "2", "前納Ｐ精算区分");
    }
}

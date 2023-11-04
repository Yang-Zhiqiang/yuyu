package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 証券発行日設定クラスのメソッド {@link SetSyokenhakkouymd#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSyokenhakkouymdTest_exec {

    @Inject
    private SetSyokenhakkouymd setSyokenhakkouymd;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate hanteibi = BizDate.valueOf(20160912);

        BizDate syoHakkoubi = setSyokenhakkouymd.exec(hanteibi);

        exDateEquals(syoHakkoubi, BizDate.valueOf(20160914), "証券発行日");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate hanteibi = BizDate.valueOf(20160902);

        BizDate syoHakkoubi = setSyokenhakkouymd.exec(hanteibi);

        exDateEquals(syoHakkoubi, BizDate.valueOf(20160906), "証券発行日");

    }

    //    @Test
    //    @TestOrder(20)
    //    public void testExec_A2() {
    //
    //        BizDate hanteibi = BizDate.valueOf(20160311);
    //
    //        BizDate syoHakkoubi = setSyokenhakkouymd.exec(hanteibi);
    //
    //        exDateEquals(syoHakkoubi, BizDate.valueOf(20160316), "証券発行日");
    //
    //    }
    //
    //    @Test
    //    @TestOrder(30)
    //    public void testExec_A3() {
    //
    //        BizDate hanteibi = BizDate.valueOf(20160301);
    //
    //        BizDate syoHakkoubi = setSyokenhakkouymd.exec(hanteibi);
    //
    //        exDateEquals(syoHakkoubi, BizDate.valueOf(20160307), "証券発行日");
    //
    //    }
}

package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 期間満了日設定クラスのメソッド {@link SetManryoubi#exec(BizDate, int, int, C_KknsmnKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetManryoubiTest_exec {

    @Inject
    private SetManryoubi setManryoubi;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate kikanManryouYmd = setManryoubi.exec(null, 0, 99, null);
        exDateEquals(kikanManryouYmd, BizDate.MAX_VALID_DATE, "期間満了日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate kikanManryouYmd = setManryoubi.exec(null, 0, 0, null);
        exDateEquals(kikanManryouYmd, BizDate.MIN_VALUE, "期間満了日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate kikanManryouYmd = setManryoubi.exec(BizDate.valueOf("20120229"), 0, 1, C_KknsmnKbn.NEN);
        exDateEquals(kikanManryouYmd, BizDate.valueOf("20130228"), "期間満了日");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate kikanManryouYmd = setManryoubi.exec(BizDate.valueOf("20080229"), 1, 3, C_KknsmnKbn.SAI);
        exDateEquals(kikanManryouYmd, BizDate.valueOf("20100228"), "期間満了日");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate kikanManryouYmd = setManryoubi.exec(BizDate.valueOf("20150601"), 2, 2, C_KknsmnKbn.BLNK);
        exDateEquals(kikanManryouYmd, null, "期間満了日");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate kikanManryouYmd = setManryoubi.exec(BizDate.valueOf("20110228"), 0, 1, C_KknsmnKbn.NEN);
        exDateEquals(kikanManryouYmd, BizDate.valueOf("20120228"), "期間満了日");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate kikanManryouYmd = setManryoubi.exec(BizDate.valueOf("20060228"), 1, 3, C_KknsmnKbn.SAI);
        exDateEquals(kikanManryouYmd, BizDate.valueOf("20080228"), "期間満了日");
    }

}

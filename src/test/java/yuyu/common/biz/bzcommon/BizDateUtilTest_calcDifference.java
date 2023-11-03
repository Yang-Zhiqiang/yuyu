package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 日付ユーティリティクラスのメソッド {@link BizDateUtil#calcDifference(BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BizDateUtilTest_calcDifference {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    private final BizDate date1 = BizDate.valueOf(20180818);

    private final BizDate date2 = BizDate.valueOf(20150629);

    @Test
    @TestOrder(10)
    public void testEditBean_A1() {

        exNumericEquals(BizDateUtil.calcDifference(date1, date2).getYears(), 3, "期間");
        exNumericEquals(BizDateUtil.calcDifference(date1, date2).getMonths(), 1, "期間");
        exNumericEquals(BizDateUtil.calcDifference(date1, date2).getDays(), 20, "期間");

    }

    @Test
    @TestOrder(20)
    public void testEditBean_A2() {

        exNumericEquals(BizDateUtil.calcDifference(date2, date2).getYears(), 0, "期間");
        exNumericEquals(BizDateUtil.calcDifference(date2, date2).getMonths(), 0, "期間");
        exNumericEquals(BizDateUtil.calcDifference(date2, date2).getDays(), 0, "期間");
    }

    @Test
    @TestOrder(30)
    public void testEditBean_A3() {

        exNumericEquals(BizDateUtil.calcDifference(date2, date1).getYears(), 3, "期間");
        exNumericEquals(BizDateUtil.calcDifference(date2, date1).getMonths(), 1, "期間");
        exNumericEquals(BizDateUtil.calcDifference(date2, date1).getDays(), 20, "期間");
    }

}

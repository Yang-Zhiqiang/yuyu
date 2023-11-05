package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 日付ユーティリティクラスのメソッド {@link BizDateUtil#calcDifferenceDays(BizDate, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BizDateUtilTest_calcDifferenceDays extends AbstractTest {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testCalcDifferenceDays01() {

        BizDate date1 = BizDate.valueOf(20170222);
        BizDate date2 = BizDate.valueOf(20170221);

        int kikanDays = BizDateUtil.calcDifferenceDays(date1, date2);

        exNumericEquals(kikanDays, 1, "期間(間隔の日数)");
    }

    @Test
    @TestOrder(20)
    public void testCalcDifferenceDays02() {

        BizDate date1 = BizDate.valueOf(20170222);
        BizDate date2 = BizDate.valueOf(20170222);

        int kikanDays = BizDateUtil.calcDifferenceDays(date1, date2);

        exNumericEquals(kikanDays, 0, "期間(間隔の日数)");
    }

    @Test
    @TestOrder(30)
    public void testCalcDifferenceDays03() {

        BizDate date1 = BizDate.valueOf(20170222);
        BizDate date2 = BizDate.valueOf(20170223);

        int kikanDays = BizDateUtil.calcDifferenceDays(date1, date2);

        exNumericEquals(kikanDays, 1, "期間(間隔の日数)");
    }
}

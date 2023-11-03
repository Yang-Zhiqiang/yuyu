package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 日付ユーティリティクラスのメソッド {@link BizDateUtil#calcDifferenceMonths(BizDateYM, BizDateYM)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BizDateUtilTest_calcDifferenceMonths extends AbstractTest {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }
    @Test
    @TestOrder(10)
    public void testCalcDifferenceMonths01() {

        BizDateYM dateYm1 = BizDateYM.valueOf(201702);
        BizDateYM dateYm2 = BizDateYM.valueOf(201701);

        int kikanMonths = BizDateUtil.calcDifferenceMonths(dateYm1, dateYm2);

        exNumericEquals(kikanMonths, 1, "期間(間隔の月数)");
    }

    @Test
    @TestOrder(20)
    public void testCalcDifferenceMonths02() {

        BizDateYM date1 = BizDateYM.valueOf(201702);
        BizDateYM date2 = BizDateYM.valueOf(201702);

        int kikanMonths = BizDateUtil.calcDifferenceMonths(date1, date2);

        exNumericEquals(kikanMonths, 0, "期間(間隔の月数)");
    }

    @Test
    @TestOrder(30)
    public void testCalcDifferenceMonths03() {

        BizDateYM date1 = BizDateYM.valueOf(201702);
        BizDateYM date2 = BizDateYM.valueOf(201703);

        int kikanMonths = BizDateUtil.calcDifferenceMonths(date1, date2);

        exNumericEquals(kikanMonths, 1, "期間(間隔の月数)");
    }
}

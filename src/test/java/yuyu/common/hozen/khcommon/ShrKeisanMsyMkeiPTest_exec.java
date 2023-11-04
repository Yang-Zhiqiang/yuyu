package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * （支払）未収Ｐ・未経過Ｐ計算クラスのメソッド {@link ShrKeisanMsyMkeiP#exec(String, BizDate, BizDate)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class ShrKeisanMsyMkeiPTest_exec {

    @Inject
    private ShrKeisanMsyMkeiP shrKeisanMsyMkeiP;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String syoNo = "17806000013";
        BizDate keisanYmd = BizDate.valueOf(20150817);
        BizDate denYmd = BizDate.valueOf(20150817);

        shrKeisanMsyMkeiP.exec(syoNo, keisanYmd, denYmd);

        exBizCalcbleEquals(shrKeisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exNumericEquals(shrKeisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(shrKeisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(shrKeisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(shrKeisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(shrKeisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(shrKeisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(shrKeisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(shrKeisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(shrKeisanMsyMkeiP.getMiKeikaPBeans());
    }
}

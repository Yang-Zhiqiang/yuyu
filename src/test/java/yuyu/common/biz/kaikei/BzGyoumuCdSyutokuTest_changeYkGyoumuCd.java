package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Gyoumucd;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link BzGyoumuCdSyutoku#changeYkGyoumuCd(String)}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGyoumuCdSyutokuTest_changeYkGyoumuCd extends AbstractTest {

    @Test
    @TestOrder(10)
    public void testChangeYkGyoumuCd_B1() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        String denGyoumuCd = "0";

        C_Gyoumucd gyoumucd = bzGyoumuCdSyutoku.changeYkGyoumuCd(denGyoumuCd);
        exClassificationEquals(gyoumucd, C_Gyoumucd.BLNK, "業務コード");
    }

    @Test
    @TestOrder(20)
    public void testChangeYkGyoumuCd_B2() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        String denGyoumuCd = "9900";

        C_Gyoumucd gyoumucd = bzGyoumuCdSyutoku.changeYkGyoumuCd(denGyoumuCd);
        exClassificationEquals(gyoumucd, C_Gyoumucd.SKFUSEIRITUPHENKIN, "業務コード");
    }

    @Test
    @TestOrder(30)
    public void testChangeYkGyoumuCd_B3() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        String denGyoumuCd = "1234";

        C_Gyoumucd gyoumucd = bzGyoumuCdSyutoku.changeYkGyoumuCd(denGyoumuCd);
        exClassificationEquals(gyoumucd, C_Gyoumucd.SETTEI_HUKA, "業務コード");
    }
}

package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * {@link BzGyoumuCdSyutoku#changeGkGyoumuCd(String)}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGyoumuCdSyutokuTest_changeGkGyoumuCd extends AbstractTest {

    @Test
    @TestOrder(10)
    public void testchangeGkGyoumuCd_C1() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        String denGyoumuCd = "0";

        C_Gkgyoumucd gkgyoumucd = bzGyoumuCdSyutoku.changeGkGyoumuCd(denGyoumuCd);
        exClassificationEquals(gkgyoumucd, C_Gkgyoumucd.BLNK, "外貨業務コード");
    }

    @Test
    @TestOrder(20)
    public void testchangeGkGyoumuCd_C2() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        String denGyoumuCd = "99000";

        C_Gkgyoumucd gkgyoumucd = bzGyoumuCdSyutoku.changeGkGyoumuCd(denGyoumuCd);
        exClassificationEquals(gkgyoumucd, C_Gkgyoumucd.SKFUSEIRITUPHENKIN, "外貨業務コード");
    }

    @Test
    @TestOrder(30)
    public void testchangeGkGyoumuCd_C3() {

        BzGyoumuCdSyutoku bzGyoumuCdSyutoku = SWAKInjector.getInstance(BzGyoumuCdSyutoku.class);

        String denGyoumuCd = "12345";

        C_Gkgyoumucd gkgyoumucd = bzGyoumuCdSyutoku.changeGkGyoumuCd(denGyoumuCd);
        exClassificationEquals(gkgyoumucd, C_Gkgyoumucd.SETTEI_HUKA, "外貨業務コード");
    }
}

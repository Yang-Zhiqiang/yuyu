package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * KeisanGaisanPsougkクラスのメソッド {@link KeisanGaisanPsougk#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanGaisanPsougkTest_exec {

    @Inject
    private KeisanGaisanPsougk keisanGaisanPsougk;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizCurrency pHrkp=BizCurrency.valueOf(100);
        C_Hrkkaisuu pHrkkaisuu=C_Hrkkaisuu.HALFY;
        BizDate pKykYmd=BizDate.valueOf(20191210);
        BizDate pHaraimanYmd=BizDate.valueOf(20221210);

        BizCurrency gaisanPsougk = keisanGaisanPsougk.exec(pHrkp,pHrkkaisuu,pKykYmd,pHaraimanYmd);

        exBizCalcbleEquals(gaisanPsougk, BizCurrency.valueOf(600), "概算保険料総額");

    }
}

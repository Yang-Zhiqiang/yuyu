package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 払込期月未到来Ｐ判定のメソッド {@link CheckHrkkigetuMitouraiP#exists(BizDate, BizDateYM, C_Hrkkaisuu, Integer, Integer)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckHrkkigetuMitouraiPTest_exists {

    @Test
    @TestOrder(10)
    @Transactional
    public void testExists_A1() {

        CheckHrkkigetuMitouraiP checkHrkkigetuMitouraiP = SWAKInjector.getInstance(CheckHrkkigetuMitouraiP.class);
        BizDate kijyunymd = BizDate.valueOf("20201010");
        BizDateYM jyutoustartym = BizDateYM.valueOf("202011");
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        Integer jyutoukaisuuy = 0;
        Integer jyutoukaisuum = 0;
        boolean result = checkHrkkigetuMitouraiP.exists(kijyunymd, jyutoustartym, hrkkaisuu,jyutoukaisuuy, jyutoukaisuum);
        exBooleanEquals(result, false, "判定結果");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        CheckHrkkigetuMitouraiP checkHrkkigetuMitouraiP = SWAKInjector.getInstance(CheckHrkkigetuMitouraiP.class);
        BizDate kijyunymd = BizDate.valueOf("20201010");
        BizDateYM jyutoustartym = BizDateYM.valueOf("202011");
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        Integer jyutoukaisuuy = 0;
        Integer jyutoukaisuum = 1;
        boolean result = checkHrkkigetuMitouraiP.exists(kijyunymd, jyutoustartym, hrkkaisuu,jyutoukaisuuy, jyutoukaisuum);
        exBooleanEquals(result, true, "判定結果");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        CheckHrkkigetuMitouraiP checkHrkkigetuMitouraiP = SWAKInjector.getInstance(CheckHrkkigetuMitouraiP.class);
        BizDate kijyunymd = BizDate.valueOf("20201010");
        BizDateYM jyutoustartym = BizDateYM.valueOf("202009");
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;
        Integer jyutoukaisuuy = 0;
        Integer jyutoukaisuum = 3;
        boolean result = checkHrkkigetuMitouraiP.exists(kijyunymd, jyutoustartym, hrkkaisuu,jyutoukaisuuy, jyutoukaisuum);
        exBooleanEquals(result, true, "判定結果");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        CheckHrkkigetuMitouraiP checkHrkkigetuMitouraiP = SWAKInjector.getInstance(CheckHrkkigetuMitouraiP.class);
        BizDate kijyunymd = BizDate.valueOf("20201010");
        BizDateYM jyutoustartym = BizDateYM.valueOf("202005");
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;
        Integer jyutoukaisuuy = 0;
        Integer jyutoukaisuum = 12;
        boolean result = checkHrkkigetuMitouraiP.exists(kijyunymd, jyutoustartym, hrkkaisuu,jyutoukaisuuy, jyutoukaisuum);
        exBooleanEquals(result, true, "判定結果");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        CheckHrkkigetuMitouraiP checkHrkkigetuMitouraiP = SWAKInjector.getInstance(CheckHrkkigetuMitouraiP.class);
        BizDate kijyunymd = BizDate.valueOf("20201010");
        BizDateYM jyutoustartym = BizDateYM.valueOf("202005");
        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.NEN;
        Integer jyutoukaisuuy = 1;
        Integer jyutoukaisuum = 0;
        boolean result = checkHrkkigetuMitouraiP.exists(kijyunymd, jyutoustartym, hrkkaisuu,jyutoukaisuuy, jyutoukaisuum);
        exBooleanEquals(result, false, "判定結果");
    }
}

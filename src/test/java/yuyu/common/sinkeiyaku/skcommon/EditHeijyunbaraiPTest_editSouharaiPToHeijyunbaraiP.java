package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 平準払Ｐ編集 {@link EditHeijyunbaraiP#editSouharaiPToHeijyunbaraiP(BizCurrency, C_Hrkkaisuu,
 * Integer, C_HrkkknsmnKbn, Integer, C_HasuusyoriKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditHeijyunbaraiPTest_editSouharaiPToHeijyunbaraiP {

    @Inject
    private EditHeijyunbaraiP editHeijyunbaraiP;

    @Test
    @TestOrder(10)
    public void testEditSouharaiPToHeijyunbaraiP_A1() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(null, C_Hrkkaisuu.NEN, 2,
            C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(20)
    public void testEditSouharaiPToHeijyunbaraiP_A2() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000), null, 2,
            C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(30)
    public void testEditSouharaiPToHeijyunbaraiP_A3() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.NEN, null, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(40)
    public void testEditSouharaiPToHeijyunbaraiP_A4() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.NEN, 2, null, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(50)
    public void testEditSouharaiPToHeijyunbaraiP_A5() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.NEN, 2, C_HrkkknsmnKbn.NENMANKI, null, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(60)
    public void testEditSouharaiPToHeijyunbaraiP_A6() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.NEN, 2, C_HrkkknsmnKbn.NENMANKI, 20, null);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(70)
    public void testEditSouharaiPToHeijyunbaraiP_A7() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.BLNK, 2, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(80)
    public void testEditSouharaiPToHeijyunbaraiP_A8() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.NEN, 2, C_HrkkknsmnKbn.BLNK, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(90)
    public void testEditSouharaiPToHeijyunbaraiP_A9() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.NEN, 2, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.BLNK);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(100)
    public void testEditSouharaiPToHeijyunbaraiP_A10() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000),
            C_Hrkkaisuu.NEN, 2, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.OK, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), BizCurrency.valueOf(500), "平準払Ｐ");
    }

    @Test
    @TestOrder(110)
    public void testEditSouharaiPToHeijyunbaraiP_A11() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(36012),
            C_Hrkkaisuu.TUKI, 2, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SSYGNY);

        exClassificationEquals(C_ErrorKbn.OK, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), BizCurrency.valueOf(1501), "平準払Ｐ");
    }

    @Test
    @TestOrder(120)
    public void testEditSouharaiPToHeijyunbaraiP_A12() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(36013),
            C_Hrkkaisuu.HALFY, 2, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SUTE);

        exClassificationEquals(C_ErrorKbn.OK, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), BizCurrency.valueOf(9003), "平準払Ｐ");
    }

    @Test
    @TestOrder(130)
    public void testEditSouharaiPToHeijyunbaraiP_A13() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(36013.4),
            C_Hrkkaisuu.ITIJI, 2, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.AGE);

        exClassificationEquals(C_ErrorKbn.OK, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), BizCurrency.valueOf(36014), "平準払Ｐ");
    }

    @Test
    @TestOrder(140)
    public void testEditSouharaiPToHeijyunbaraiP_A14() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000.9),
            C_Hrkkaisuu.ITIJI, 100, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SUTE);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(150)
    public void testEditSouharaiPToHeijyunbaraiP_A15() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000.9),
            C_Hrkkaisuu.NEN, 0, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SUTE);

        exClassificationEquals(C_ErrorKbn.ERROR, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), null, "平準払Ｐ");
    }

    @Test
    @TestOrder(160)
    public void testEditSouharaiPToHeijyunbaraiP_A16() {

        C_ErrorKbn errorKbn = editHeijyunbaraiP.editSouharaiPToHeijyunbaraiP(BizCurrency.valueOf(1000.9),
            C_Hrkkaisuu.NEN, 2, C_HrkkknsmnKbn.NENMANKI, 20, C_HasuusyoriKbn.SUTE);

        exClassificationEquals(C_ErrorKbn.OK, errorKbn, "エラー区分");

        exBizCalcbleEquals(editHeijyunbaraiP.getHeijyunbaraiP(), BizCurrency.valueOf(500), "平準払Ｐ");
    }
}
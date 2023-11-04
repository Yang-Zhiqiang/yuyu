package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 クレジットカード決済用番号採番クラスのメソッド{@link SaibanCreditKessaiyouNo#exec
 * (C_CreditCardKeySyuruiKbn, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SaibanCreditKessaiyouNoTest_exec extends AbstractTest {

    @Inject
    private SaibanCreditKessaiyouNo saibanCreditKessaiyouNo;

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn = C_CreditCardKeySyuruiKbn.MOSNO;

        String pCreditCardDbKey = "14516325";

        try {
            saibanCreditKessaiyouNo.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。引数が不正です。"
                + "クレジットカードＤＢキー＝14516325", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn = C_CreditCardKeySyuruiKbn.MOSNO;

        String pCreditCardDbKey = "5238415510";

        try {
            saibanCreditKessaiyouNo.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。引数が不正です。"
                + "クレジットカードＤＢキー＝5238415510", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn = C_CreditCardKeySyuruiKbn.MOSNO;

        String pCreditCardDbKey = "621911584";

        String creditKessaiyouNo = saibanCreditKessaiyouNo.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);

        exStringEquals(creditKessaiyouNo,"32006219115841910101113285", "クレジットカード決済用番号");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {

        C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn = C_CreditCardKeySyuruiKbn.SYONO;

        String pCreditCardDbKey = "145163252253";

        try {
            saibanCreditKessaiyouNo.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。引数が不正です。"
                + "クレジットカードＤＢキー＝145163252253", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {

        C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn = C_CreditCardKeySyuruiKbn.SYONO;

        String pCreditCardDbKey = "4451568902";

        try {
            saibanCreditKessaiyouNo.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。引数が不正です。"
                + "クレジットカードＤＢキー＝4451568902", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn = C_CreditCardKeySyuruiKbn.SYONO;

        String pCreditCardDbKey = "62181150114";

        String creditKessaiyouNo = saibanCreditKessaiyouNo.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);

        exStringEquals(creditKessaiyouNo, "33621811501141910101113280", "クレジットカード決済用番号");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        C_CreditCardKeySyuruiKbn pCreditCardKeySyuruiKbn = C_CreditCardKeySyuruiKbn.SYONO;

        String pCreditCardDbKey = "62181150113";

        String creditKessaiyouNo = saibanCreditKessaiyouNo.exec(pCreditCardKeySyuruiKbn, pCreditCardDbKey);

        exStringEquals(creditKessaiyouNo, "33621811501131910101113282", "クレジットカード決済用番号");
    }
}

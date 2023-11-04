package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getHrkkknsmnKbn(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getHrkkknsmnKbn extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetHrkkknsmnKbn_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        C_HrkkknsmnKbn hrkkknsmnKbn = setMosGamenctrl.getHrkkknsmnKbn(pCtrlBean);

        exClassificationEquals(hrkkknsmnKbn, C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
    }

    @Test
    @TestOrder(20)
    public void testGetHrkkknsmnKbn_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        C_HrkkknsmnKbn hrkkknsmnKbn = setMosGamenctrl.getHrkkknsmnKbn(pCtrlBean);

        exClassificationEquals(hrkkknsmnKbn, C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
    }

    @Test
    @TestOrder(30)
    public void testGetHrkkknsmnKbn_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT);

        C_HrkkknsmnKbn hrkkknsmnKbn = setMosGamenctrl.getHrkkknsmnKbn(pCtrlBean);

        exClassificationEquals(hrkkknsmnKbn, C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
    }

    @Test
    @TestOrder(40)
    public void testGetHrkkknsmnKbn_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT);

        C_HrkkknsmnKbn hrkkknsmnKbn = setMosGamenctrl.getHrkkknsmnKbn(pCtrlBean);

        exClassificationEquals(hrkkknsmnKbn, C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
    }
}

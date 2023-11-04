package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getHknkknsmnKbn(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getHknkknsmnKbn extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetgetHknkknsmnKbn_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(20)
    public void testGetgetHknkknsmnKbn_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(30)
    public void testGetgetHknkknsmnKbn_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(40)
    public void testGetgetHknkknsmnKbn_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(50)
    public void testGetgetHknkknsmnKbn_A5() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(60)
    public void testGetgetHknkknsmnKbn_A6() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(70)
    public void testGetgetHknkknsmnKbn_A7() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(80)
    public void testGetgetHknkknsmnKbn_A8() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(90)
    public void testGetgetHknkknsmnKbn_A9() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(100)
    public void testGetgetHknkknsmnKbn_A10() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
    }

    @Test
    @TestOrder(110)
    public void testGetgetHknkknsmnKbn_A11() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT);

        C_HknkknsmnKbn cHknkknsmnKbn = setMosGamenctrl.getHknkknsmnKbn(pCtrlBean);

        exClassificationEquals(cHknkknsmnKbn, C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
    }
}
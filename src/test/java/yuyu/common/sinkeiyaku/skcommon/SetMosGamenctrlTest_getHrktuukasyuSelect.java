package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.ui.UserDefsList;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getHrktuukasyuSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getHrktuukasyuSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetHrktuukasyuSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(20)
    public void testGetHrktuukasyuSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(30)
    public void testGetHrktuukasyuSelect_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(40)
    public void testGetHrktuukasyuSelect_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(50)
    public void testGetHrktuukasyuSelect_A5() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "円", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(60)
    public void testGetHrktuukasyuSelect_A6() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }

    @Test
    @TestOrder(70)
    public void testGetHrktuukasyuSelect_A7() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "豪ドル", "設定の選択肢.Label");
    }


    @Test
    @TestOrder(80)
    public void testGetHrktuukasyuSelect_A8() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "豪ドル", "設定の選択肢.Label");
    }


    @Test
    @TestOrder(90)
    public void testGetHrktuukasyuSelect_A9() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(100)
    public void testGetHrktuukasyuSelect_A10() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "円", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(110)
    public void testGetHrktuukasyuSelect_A11() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT);

        UserDefsList list = setMosGamenctrl.getHrktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 3, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "円", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "米ドル", "設定の選択肢.Label");
    }

}

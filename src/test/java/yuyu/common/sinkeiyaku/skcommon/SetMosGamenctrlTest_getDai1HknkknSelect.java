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
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getDai1HknkknSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getDai1HknkknSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetDai1HknkknSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);

        UserDefsList list = setMosGamenctrl.getDai1HknkknSelect(pCtrlBean);

        exNumericEquals(list.size(), 3, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "5", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "5", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "10", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "10", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(20)
    public void testGetDai1HknkknSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI);

        UserDefsList list = setMosGamenctrl.getDai1HknkknSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "2", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(30)
    public void testGetDai1HknkknSelect_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getDai1HknkknSelect(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }

    @Test
    @TestOrder(40)
    public void testGetDai1HknkknSelect_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT);

        UserDefsList list = setMosGamenctrl.getDai1HknkknSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "5", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "5", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(50)
    public void testGetDai1HknkknSelect_A5() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT);

        UserDefsList list = setMosGamenctrl.getDai1HknkknSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "5", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "5", "設定の選択肢.Label");
    }
}

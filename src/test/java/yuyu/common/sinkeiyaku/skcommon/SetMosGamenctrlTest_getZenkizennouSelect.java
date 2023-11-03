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
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getZenkizennouumuSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getZenkizennouSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testZenkizennouumuSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        UserDefsList list = setMosGamenctrl.getZenkizennouSelect(pCtrlBean);

        exNumericEquals(list.size(), 2, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "あり", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "なし", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(20)
    public void testZenkizennouumuSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getZenkizennouSelect(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }

    @Test
    @TestOrder(30)
    public void testZenkizennouumuSelect_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT);

        UserDefsList list = setMosGamenctrl.getZenkizennouSelect(pCtrlBean);

        exNumericEquals(list.size(), 2, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "あり", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "なし", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(40)
    public void testZenkizennouumuSelect_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT);

        UserDefsList list = setMosGamenctrl.getZenkizennouSelect(pCtrlBean);

        exNumericEquals(list.size(), 2, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "あり", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "なし", "設定の選択肢.Label");
    }
}

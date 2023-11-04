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
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getHaraikomikaisuSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getHrkkaisuuSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetHrkkaisuuSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        UserDefsList list = setMosGamenctrl.getHrkkaisuuSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "月払", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(20)
    public void testGetHrkkaisuuSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getHrkkaisuuSelect(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }

    @Test
    @TestOrder(30)
    public void testGetHrkkaisuuSelect_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT);

        UserDefsList list = setMosGamenctrl.getHrkkaisuuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "月払", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "6", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "年２回払", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "12", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "年１回払", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(40)
    public void testGetHrkkaisuuSelect_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT);

        UserDefsList list = setMosGamenctrl.getHrkkaisuuSelect(pCtrlBean);

        exNumericEquals(list.size(), 4, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "月払", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "6", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "年２回払", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "12", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "年１回払", "設定の選択肢.Label");
    }
}

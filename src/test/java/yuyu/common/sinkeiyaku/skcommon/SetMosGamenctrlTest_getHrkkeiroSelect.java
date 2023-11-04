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
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getHrkkeiroSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getHrkkeiroSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetHrkkeiroSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        UserDefsList list = setMosGamenctrl.getHrkkeiroSelect(pCtrlBean);

        exNumericEquals(list.size(), 2, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "口座振替", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "4", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "振替", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(20)
    public void testGetHrkkeiroSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getHrkkeiroSelect(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }
}

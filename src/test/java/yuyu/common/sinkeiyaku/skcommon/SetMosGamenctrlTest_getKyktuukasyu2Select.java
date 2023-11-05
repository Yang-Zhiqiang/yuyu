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
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getKyktuukasyu2Select(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getKyktuukasyu2Select extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetKyktuukasyu2Select_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        UserDefsList list = setMosGamenctrl.getKyktuukasyu2Select(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(20)
    public void testGetKyktuukasyu2Select_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getKyktuukasyu2Select(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }
}

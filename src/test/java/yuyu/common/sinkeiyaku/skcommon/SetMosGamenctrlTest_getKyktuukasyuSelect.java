package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.ui.UserDefsList;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getKyktuukasyuSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getKyktuukasyuSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetKyktuukasyuSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);
        pCtrlBean.setMos2hyoujiumuKbn(C_UmuKbn.ARI);

        UserDefsList list = setMosGamenctrl.getKyktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "米ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(20)
    public void testGetKyktuukasyuSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);
        pCtrlBean.setMos2hyoujiumuKbn(C_UmuKbn.NONE);

        UserDefsList list = setMosGamenctrl.getKyktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 3, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(30)
    public void testGetKyktuukasyuSelect_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);
        pCtrlBean.setMos2hyoujiumuKbn(C_UmuKbn.ARI);

        UserDefsList list = setMosGamenctrl.getKyktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 3, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "米ドル", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "AUD", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "豪ドル", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(40)
    public void testGetKyktuukasyuSelect_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_YENDT);

        UserDefsList list = setMosGamenctrl.getKyktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "JPY", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "円", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(50)
    public void testGetKyktuukasyuSelect_A5() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.TEIKAIYAKUHRKNSYSN_USDDT);

        UserDefsList list = setMosGamenctrl.getKyktuukasyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 1, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "USD", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "米ドル", "設定の選択肢.Label");
    }
}

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
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getNenkinsyuSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getNenkinsyuSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetNenkinsyuSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK);

        UserDefsList list = setMosGamenctrl.getNenkinsyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 5, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１０年確定", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "3", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "8", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "年金総額保証付終身", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(20)
    public void testGetNenkinsyuSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getNenkinsyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }

    @Test
    @TestOrder(30)
    public void testGetNenkinsyuSelect_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);

        UserDefsList list = setMosGamenctrl.getNenkinsyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 5, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１０年確定", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "3", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "8", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "年金総額保証付終身", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(40)
    public void testGetNenkinsyuSelect_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU);

        UserDefsList list = setMosGamenctrl.getNenkinsyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 5, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１０年確定", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "3", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "8", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "年金総額保証付終身", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(50)
    public void testGetNenkinsyuSelect_A5() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);

        UserDefsList list = setMosGamenctrl.getNenkinsyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 5, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１０年確定", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "3", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "A", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "５年確定（第１回年金倍額型）", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(60)
    public void testGetNenkinsyuSelect_A6() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU);

        UserDefsList list = setMosGamenctrl.getNenkinsyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 5, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１０年確定", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "3", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "8", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "年金総額保証付終身", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(70)
    public void testGetNenkinsyuSelect_A7() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI);

        UserDefsList list = setMosGamenctrl.getNenkinsyuSelect(pCtrlBean);

        exNumericEquals(list.size(), 5, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "1", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "2", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１０年確定", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "3", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１５年確定", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "8", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "年金総額保証付終身", "設定の選択肢.Label");

    }
}

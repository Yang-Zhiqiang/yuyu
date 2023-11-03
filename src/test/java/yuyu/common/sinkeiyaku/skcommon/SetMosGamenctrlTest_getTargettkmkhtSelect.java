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
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getTargettkmkhtSelect(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getTargettkmkhtSelect extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetTargettkmkhtSelect_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 12, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "110", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "１１０％", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "120", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１２０％", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "130", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１３０％", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "140", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "１４０％", "設定の選択肢.Label");
        exStringEquals(list.get(5).getValue(), "150", "設定の選択肢.Value");
        exStringEquals(list.get(5).getLabel(), "１５０％", "設定の選択肢.Label");
        exStringEquals(list.get(6).getValue(), "160", "設定の選択肢.Value");
        exStringEquals(list.get(6).getLabel(), "１６０％", "設定の選択肢.Label");
        exStringEquals(list.get(7).getValue(), "170", "設定の選択肢.Value");
        exStringEquals(list.get(7).getLabel(), "１７０％", "設定の選択肢.Label");
        exStringEquals(list.get(8).getValue(), "180", "設定の選択肢.Value");
        exStringEquals(list.get(8).getLabel(), "１８０％", "設定の選択肢.Label");
        exStringEquals(list.get(9).getValue(), "190", "設定の選択肢.Value");
        exStringEquals(list.get(9).getLabel(), "１９０％", "設定の選択肢.Label");
        exStringEquals(list.get(10).getValue(), "200", "設定の選択肢.Value");
        exStringEquals(list.get(10).getLabel(), "２００％", "設定の選択肢.Label");
        exStringEquals(list.get(11).getValue(), "999", "設定の選択肢.Value");
        exStringEquals(list.get(11).getLabel(), "設定しない", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(20)
    public void testGetTargettkmkhtSelect_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 13, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "105", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "１０５％", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "110", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１１０％", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "120", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１２０％", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "130", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "１３０％", "設定の選択肢.Label");
        exStringEquals(list.get(5).getValue(), "140", "設定の選択肢.Value");
        exStringEquals(list.get(5).getLabel(), "１４０％", "設定の選択肢.Label");
        exStringEquals(list.get(6).getValue(), "150", "設定の選択肢.Value");
        exStringEquals(list.get(6).getLabel(), "１５０％", "設定の選択肢.Label");
        exStringEquals(list.get(7).getValue(), "160", "設定の選択肢.Value");
        exStringEquals(list.get(7).getLabel(), "１６０％", "設定の選択肢.Label");
        exStringEquals(list.get(8).getValue(), "170", "設定の選択肢.Value");
        exStringEquals(list.get(8).getLabel(), "１７０％", "設定の選択肢.Label");
        exStringEquals(list.get(9).getValue(), "180", "設定の選択肢.Value");
        exStringEquals(list.get(9).getLabel(), "１８０％", "設定の選択肢.Label");
        exStringEquals(list.get(10).getValue(), "190", "設定の選択肢.Value");
        exStringEquals(list.get(10).getLabel(), "１９０％", "設定の選択肢.Label");
        exStringEquals(list.get(11).getValue(), "200", "設定の選択肢.Value");
        exStringEquals(list.get(11).getLabel(), "２００％", "設定の選択肢.Label");
        exStringEquals(list.get(12).getValue(), "999", "設定の選択肢.Value");
        exStringEquals(list.get(12).getLabel(), "設定しない", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(30)
    public void testGetTargettkmkhtSelect_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 0, "選択肢Listのサイズ");
    }

    @Test
    @TestOrder(40)
    public void testGetTargettkmkhtSelect_A4() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 13, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "105", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "１０５％", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "110", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１１０％", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "120", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１２０％", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "130", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "１３０％", "設定の選択肢.Label");
        exStringEquals(list.get(5).getValue(), "140", "設定の選択肢.Value");
        exStringEquals(list.get(5).getLabel(), "１４０％", "設定の選択肢.Label");
        exStringEquals(list.get(6).getValue(), "150", "設定の選択肢.Value");
        exStringEquals(list.get(6).getLabel(), "１５０％", "設定の選択肢.Label");
        exStringEquals(list.get(7).getValue(), "160", "設定の選択肢.Value");
        exStringEquals(list.get(7).getLabel(), "１６０％", "設定の選択肢.Label");
        exStringEquals(list.get(8).getValue(), "170", "設定の選択肢.Value");
        exStringEquals(list.get(8).getLabel(), "１７０％", "設定の選択肢.Label");
        exStringEquals(list.get(9).getValue(), "180", "設定の選択肢.Value");
        exStringEquals(list.get(9).getLabel(), "１８０％", "設定の選択肢.Label");
        exStringEquals(list.get(10).getValue(), "190", "設定の選択肢.Value");
        exStringEquals(list.get(10).getLabel(), "１９０％", "設定の選択肢.Label");
        exStringEquals(list.get(11).getValue(), "200", "設定の選択肢.Value");
        exStringEquals(list.get(11).getLabel(), "２００％", "設定の選択肢.Label");
        exStringEquals(list.get(12).getValue(), "999", "設定の選択肢.Value");
        exStringEquals(list.get(12).getLabel(), "設定しない", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(50)
    public void testGetTargettkmkhtSelect_A5() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_TEIRITU);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 13, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "105", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "１０５％", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "110", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１１０％", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "120", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１２０％", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "130", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "１３０％", "設定の選択肢.Label");
        exStringEquals(list.get(5).getValue(), "140", "設定の選択肢.Value");
        exStringEquals(list.get(5).getLabel(), "１４０％", "設定の選択肢.Label");
        exStringEquals(list.get(6).getValue(), "150", "設定の選択肢.Value");
        exStringEquals(list.get(6).getLabel(), "１５０％", "設定の選択肢.Label");
        exStringEquals(list.get(7).getValue(), "160", "設定の選択肢.Value");
        exStringEquals(list.get(7).getLabel(), "１６０％", "設定の選択肢.Label");
        exStringEquals(list.get(8).getValue(), "170", "設定の選択肢.Value");
        exStringEquals(list.get(8).getLabel(), "１７０％", "設定の選択肢.Label");
        exStringEquals(list.get(9).getValue(), "180", "設定の選択肢.Value");
        exStringEquals(list.get(9).getLabel(), "１８０％", "設定の選択肢.Label");
        exStringEquals(list.get(10).getValue(), "190", "設定の選択肢.Value");
        exStringEquals(list.get(10).getLabel(), "１９０％", "設定の選択肢.Label");
        exStringEquals(list.get(11).getValue(), "200", "設定の選択肢.Value");
        exStringEquals(list.get(11).getLabel(), "２００％", "設定の選択肢.Label");
        exStringEquals(list.get(12).getValue(), "999", "設定の選択肢.Value");
        exStringEquals(list.get(12).getLabel(), "設定しない", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(60)
    public void testGetTargettkmkhtSelect_A6() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 12, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "110", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "１１０％", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "120", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１２０％", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "130", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１３０％", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "140", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "１４０％", "設定の選択肢.Label");
        exStringEquals(list.get(5).getValue(), "150", "設定の選択肢.Value");
        exStringEquals(list.get(5).getLabel(), "１５０％", "設定の選択肢.Label");
        exStringEquals(list.get(6).getValue(), "160", "設定の選択肢.Value");
        exStringEquals(list.get(6).getLabel(), "１６０％", "設定の選択肢.Label");
        exStringEquals(list.get(7).getValue(), "170", "設定の選択肢.Value");
        exStringEquals(list.get(7).getLabel(), "１７０％", "設定の選択肢.Label");
        exStringEquals(list.get(8).getValue(), "180", "設定の選択肢.Value");
        exStringEquals(list.get(8).getLabel(), "１８０％", "設定の選択肢.Label");
        exStringEquals(list.get(9).getValue(), "190", "設定の選択肢.Value");
        exStringEquals(list.get(9).getLabel(), "１９０％", "設定の選択肢.Label");
        exStringEquals(list.get(10).getValue(), "200", "設定の選択肢.Value");
        exStringEquals(list.get(10).getLabel(), "２００％", "設定の選択肢.Label");
        exStringEquals(list.get(11).getValue(), "999", "設定の選択肢.Value");
        exStringEquals(list.get(11).getLabel(), "設定しない", "設定の選択肢.Label");
    }

    @Test
    @TestOrder(70)
    public void testGetTargettkmkhtSelect_A7() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_SISUU);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 13, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "105", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "１０５％", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "110", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１１０％", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "120", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１２０％", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "130", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "１３０％", "設定の選択肢.Label");
        exStringEquals(list.get(5).getValue(), "140", "設定の選択肢.Value");
        exStringEquals(list.get(5).getLabel(), "１４０％", "設定の選択肢.Label");
        exStringEquals(list.get(6).getValue(), "150", "設定の選択肢.Value");
        exStringEquals(list.get(6).getLabel(), "１５０％", "設定の選択肢.Label");
        exStringEquals(list.get(7).getValue(), "160", "設定の選択肢.Value");
        exStringEquals(list.get(7).getLabel(), "１６０％", "設定の選択肢.Label");
        exStringEquals(list.get(8).getValue(), "170", "設定の選択肢.Value");
        exStringEquals(list.get(8).getLabel(), "１７０％", "設定の選択肢.Label");
        exStringEquals(list.get(9).getValue(), "180", "設定の選択肢.Value");
        exStringEquals(list.get(9).getLabel(), "１８０％", "設定の選択肢.Label");
        exStringEquals(list.get(10).getValue(), "190", "設定の選択肢.Value");
        exStringEquals(list.get(10).getLabel(), "１９０％", "設定の選択肢.Label");
        exStringEquals(list.get(11).getValue(), "200", "設定の選択肢.Value");
        exStringEquals(list.get(11).getLabel(), "２００％", "設定の選択肢.Label");
        exStringEquals(list.get(12).getValue(), "999", "設定の選択肢.Value");
        exStringEquals(list.get(12).getLabel(), "設定しない", "設定の選択肢.Label");

    }

    @Test
    @TestOrder(80)
    public void testGetTargettkmkhtSelect_A8() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_20_TEIRITUTEIKI);

        UserDefsList list = setMosGamenctrl.getTargettkmkhtSelect(pCtrlBean);

        exNumericEquals(list.size(), 13, "選択肢Listのサイズ");
        exStringEquals(list.get(0).getValue(), "0", "設定の選択肢.Value");
        exStringEquals(list.get(0).getLabel(), "", "設定の選択肢.Label");
        exStringEquals(list.get(1).getValue(), "105", "設定の選択肢.Value");
        exStringEquals(list.get(1).getLabel(), "１０５％", "設定の選択肢.Label");
        exStringEquals(list.get(2).getValue(), "110", "設定の選択肢.Value");
        exStringEquals(list.get(2).getLabel(), "１１０％", "設定の選択肢.Label");
        exStringEquals(list.get(3).getValue(), "120", "設定の選択肢.Value");
        exStringEquals(list.get(3).getLabel(), "１２０％", "設定の選択肢.Label");
        exStringEquals(list.get(4).getValue(), "130", "設定の選択肢.Value");
        exStringEquals(list.get(4).getLabel(), "１３０％", "設定の選択肢.Label");
        exStringEquals(list.get(5).getValue(), "140", "設定の選択肢.Value");
        exStringEquals(list.get(5).getLabel(), "１４０％", "設定の選択肢.Label");
        exStringEquals(list.get(6).getValue(), "150", "設定の選択肢.Value");
        exStringEquals(list.get(6).getLabel(), "１５０％", "設定の選択肢.Label");
        exStringEquals(list.get(7).getValue(), "160", "設定の選択肢.Value");
        exStringEquals(list.get(7).getLabel(), "１６０％", "設定の選択肢.Label");
        exStringEquals(list.get(8).getValue(), "170", "設定の選択肢.Value");
        exStringEquals(list.get(8).getLabel(), "１７０％", "設定の選択肢.Label");
        exStringEquals(list.get(9).getValue(), "180", "設定の選択肢.Value");
        exStringEquals(list.get(9).getLabel(), "１８０％", "設定の選択肢.Label");
        exStringEquals(list.get(10).getValue(), "190", "設定の選択肢.Value");
        exStringEquals(list.get(10).getLabel(), "１９０％", "設定の選択肢.Label");
        exStringEquals(list.get(11).getValue(), "200", "設定の選択肢.Value");
        exStringEquals(list.get(11).getLabel(), "２００％", "設定の選択肢.Label");
        exStringEquals(list.get(12).getValue(), "999", "設定の選択肢.Value");
        exStringEquals(list.get(12).getLabel(), "設定しない", "設定の選択肢.Label");

    }
}

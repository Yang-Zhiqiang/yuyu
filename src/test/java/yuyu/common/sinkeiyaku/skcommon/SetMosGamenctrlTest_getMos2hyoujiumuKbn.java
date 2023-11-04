package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込書入力画面共通制御設定クラスのメソッド {@link SetMosGamenctrl#getMos2DispUmuKbn(GetSyouhnZokuseiCtrlOutBean pCtrlBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMosGamenctrlTest_getMos2hyoujiumuKbn extends AbstractTest {

    @Inject
    private SetMosGamenctrl setMosGamenctrl;

    @Test
    @TestOrder(10)
    public void testGetMos2hyoujiumuKbn_A1() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);
        pCtrlBean.setMos2hyoujiumuKbn(C_UmuKbn.ARI);

        C_UmuKbn mms2DispUmuKbn = setMosGamenctrl.getMos2hyoujiumuKbn(pCtrlBean);

        exClassificationEquals(mms2DispUmuKbn, C_UmuKbn.ARI, "申込２表示有無区分");
    }

    @Test
    @TestOrder(20)
    public void testGetMos2hyoujiumuKbn_A2() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.GAIKARIRITUHENDOUNK);
        pCtrlBean.setMos2hyoujiumuKbn(C_UmuKbn.NONE);

        C_UmuKbn mms2DispUmuKbn = setMosGamenctrl.getMos2hyoujiumuKbn(pCtrlBean);

        exClassificationEquals(mms2DispUmuKbn, C_UmuKbn.NONE, "申込２表示有無区分");
    }

    @Test
    @TestOrder(30)
    public void testGetMos2hyoujiumuKbn_A3() {

        GetSyouhnZokuseiCtrlOutBean pCtrlBean = new GetSyouhnZokuseiCtrlOutBean();
        pCtrlBean.setHknsyuruino(C_HknsyuruiNo.BLNK);
        pCtrlBean.setMos2hyoujiumuKbn(C_UmuKbn.ARI);

        C_UmuKbn mms2DispUmuKbn = setMosGamenctrl.getMos2hyoujiumuKbn(pCtrlBean);

        exClassificationEquals(mms2DispUmuKbn, C_UmuKbn.NONE, "申込２表示有無区分");
    }

}

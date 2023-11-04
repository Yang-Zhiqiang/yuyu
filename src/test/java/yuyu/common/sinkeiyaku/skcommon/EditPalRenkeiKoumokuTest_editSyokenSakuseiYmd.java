package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeirituKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editSyokenSakuseiYmd(C_SeirituKbn, BizDate)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editSyokenSakuseiYmd {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testEditSyokenSakuseiYmd_A1() {

        String syokenSakuseiYmd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(C_SeirituKbn.SEIRITU, BizDate.valueOf(20160105));

        exStringEquals(syokenSakuseiYmd, "20160105", "証券作成日");
    }

    @Test
    @TestOrder(20)
    public void testEditSyokenSakuseiYmd_A2() {

        String syokenSakuseiYmd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(C_SeirituKbn.HUSEIRITU, BizDate.valueOf(20160105));

        exStringEquals(syokenSakuseiYmd, "00000000", "証券作成日");
    }

    @Test
    @TestOrder(30)
    public void testEditSyokenSakuseiYmd_A3() {

        String syokenSakuseiYmd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(C_SeirituKbn.BLNK, BizDate.valueOf(20160105));

        exStringEquals(syokenSakuseiYmd, "00000000", "証券作成日");
    }

    @Test
    @TestOrder(40)
    public void testEditSyokenSakuseiYmd_A4() {

        String syokenSakuseiYmd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(C_SeirituKbn.NONE, BizDate.valueOf(20160105));

        exStringEquals(syokenSakuseiYmd, "00000000", "証券作成日");
    }

    @Test
    @TestOrder(50)
    public void testEditSyokenSakuseiYmd_A5() {

        String syokenSakuseiYmd = editPalRenkeiKoumoku.editSyokenSakuseiYmd(C_SeirituKbn.ITIPMATI, BizDate.valueOf(20160105));

        exStringEquals(syokenSakuseiYmd, "00000000", "証券作成日");
        MockObjectManager.initialize();
    }
}
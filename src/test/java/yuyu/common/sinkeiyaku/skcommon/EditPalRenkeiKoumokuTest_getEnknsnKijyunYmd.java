package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#getEnknsnKijyunYmd(C_Tuukasyu, BizDate, BizDate)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_getEnknsnKijyunYmd {

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testGetEnknsnKijyunYmd_A1() {
        BizDate enknsnKijyunYmd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(
            C_Tuukasyu.JPY, BizDate.valueOf(20160202), BizDate.valueOf(20160303));

        exDateEquals(enknsnKijyunYmd, null, "円換算基準日");
    }

    @Test
    @TestOrder(20)
    public void testGetEnknsnKijyunYmd_A2() {
        BizDate enknsnKijyunYmd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(
            C_Tuukasyu.USD, BizDate.valueOf(20160202), BizDate.valueOf(20160303));

        exDateEquals(enknsnKijyunYmd, BizDate.valueOf(20160202), "円換算基準日");
    }

    @Test
    @TestOrder(30)
    public void testGetEnknsnKijyunYmd_A3() {
        BizDate enknsnKijyunYmd = editPalRenkeiKoumoku.getEnknsnKijyunYmd(
            C_Tuukasyu.USD, null, BizDate.valueOf(20160303));

        exDateEquals(enknsnKijyunYmd, BizDate.valueOf(20160303), "円換算基準日");
        MockObjectManager.initialize();
    }

}

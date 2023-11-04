package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全文字列編集クラスのメソッド {@link KhozenEdit#editTienRkksanhi(C_ShrhousiteiKbn, BizCurrency, BizDate, Integer)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class KhozenEditTest_editTienRkksanhi {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testEditTienRkksanhi_A1() {
        String result = KhozenEdit.editTienRkksanhi(null, BizCurrency.valueOf(50), BizDate.valueOf(20160101), 20);
        exStringEquals(result, null, "遅延利息起算日・日数");
    }

    @Test
    @TestOrder(20)
    public void testEditTienRkksanhi_A2() {
        String result = KhozenEdit.editTienRkksanhi(C_ShrhousiteiKbn.BLNK, BizCurrency.valueOf(50),
            BizDate.valueOf(20160101), 20);
        exStringEquals(result, null, "遅延利息起算日・日数");
    }

    @Test
    @TestOrder(30)
    public void testEditTienRkksanhi_A3() {
        String result = KhozenEdit.editTienRkksanhi(C_ShrhousiteiKbn.FB_YOKUJITU, null, BizDate.valueOf(20160101), 20);
        exStringEquals(result, null, "遅延利息起算日・日数");
    }

    @Test
    @TestOrder(40)
    public void testEditTienRkksanhi_A4() {
        String result = KhozenEdit.editTienRkksanhi(C_ShrhousiteiKbn.FB_YOKUJITU, BizCurrency.valueOf(50), null, 20);
        exStringEquals(result, null, "遅延利息起算日・日数");
    }

    @Test
    @TestOrder(50)
    public void testEditTienRkksanhi_A5() {
        String result = KhozenEdit.editTienRkksanhi(C_ShrhousiteiKbn.FB_YOKUJITU, BizCurrency.valueOf(50),
            BizDate.valueOf(20160101), null);
        exStringEquals(result, null, "遅延利息起算日・日数");
    }

    @Test
    @TestOrder(60)
    public void testEditTienRkksanhi_A6() {
        String result = KhozenEdit.editTienRkksanhi(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI, BizCurrency.valueOf(50),
            BizDate.valueOf(20160101), 20);
        exStringEquals(result, "（計算対象外）", "遅延利息起算日・日数");
    }

    @Test
    @TestOrder(70)
    public void testEditTienRkksanhi_A7() {
        String result = KhozenEdit.editTienRkksanhi(C_ShrhousiteiKbn.FB_YOKUJITU, BizCurrency.valueOf(0),
            BizDate.valueOf(20160101), 20);
        exStringEquals(result, "", "遅延利息起算日・日数");
    }

    @Test
    @TestOrder(80)
    public void testEditTienRkksanhi_A8() {
        String result = KhozenEdit.editTienRkksanhi(C_ShrhousiteiKbn.FB_YOKUJITU, BizCurrency.valueOf(50),
            BizDate.valueOf(20160101), 20);
        exStringEquals(result, "（起算日：H28/01/01　20日分）", "遅延利息起算日・日数");
    }

}

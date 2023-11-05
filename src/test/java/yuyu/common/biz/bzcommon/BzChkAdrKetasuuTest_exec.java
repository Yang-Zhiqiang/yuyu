package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_JyougenketasuutyoukaKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * BzChkAdrKetasuuクラスのメソッド {@link BzChkAdrKetasuu#exec(String,String,String)}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class BzChkAdrKetasuuTest_exec extends AbstractTest {

    @Inject
    private BzChkAdrKetasuu bzChkAdrKetasuu;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String jyuusyo1 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  3";

        String jyuusyo2 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  ";

        String jyuusyo3 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  ";

        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(jyuusyo1, jyuusyo2, jyuusyo3);

        exClassificationEquals(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn(),
            C_JyougenketasuutyoukaKbn.JYOUGENNAI,
            "上限桁数超過区分");
        exNumericEquals(bzChkAdrKetasuuOutBean.getInKetasuu(), 61, "入力桁数");
        exNumericEquals(bzChkAdrKetasuuOutBean.getInJyougenKetasuu(), 62, "入力上限桁数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String jyuusyo1 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  ";

        String jyuusyo2 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  3３";

        String jyuusyo3 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  ";

        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(jyuusyo1, jyuusyo2, jyuusyo3);

        exClassificationEquals(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn(),
            C_JyougenketasuutyoukaKbn.JYOUGENNAI,
            "上限桁数超過区分");
        exNumericEquals(bzChkAdrKetasuuOutBean.getInKetasuu(), 62, "入力桁数");
        exNumericEquals(bzChkAdrKetasuuOutBean.getInJyougenKetasuu(), 62, "入力上限桁数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String jyuusyo1 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  ";

        String jyuusyo2 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  ";

        String jyuusyo3 = "がぎガギｶﾞｷﾞｸﾞＡB①②℡㈱　　  3３三";

        BzChkAdrKetasuuOutBean bzChkAdrKetasuuOutBean = bzChkAdrKetasuu.exec(jyuusyo1, jyuusyo2, jyuusyo3);

        exClassificationEquals(bzChkAdrKetasuuOutBean.getJyougenKetasuuTyoukaKbn(),
            C_JyougenketasuutyoukaKbn.CYOUKA,
            "上限桁数超過区分");
        exNumericEquals(bzChkAdrKetasuuOutBean.getInKetasuu(), 63, "入力桁数");
        exNumericEquals(bzChkAdrKetasuuOutBean.getInJyougenKetasuu(), 62, "入力上限桁数");
    }
}

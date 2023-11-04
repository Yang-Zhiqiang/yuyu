package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払方法指定区分設定のメソッド{@link SetteiShrhousiteiKbn#exec(C_InputShrhousiteiKbn, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetteiShrhousiteiKbnTest_exec {

    @Inject
    private SetteiShrhousiteiKbn setteiShrhousiteiKbn;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(C_InputShrhousiteiKbn.BLNK, C_Tuukasyu.JPY);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.BLNK, "支払方法指定区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI, C_Tuukasyu.BLNK);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.BLNK, "支払方法指定区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI, C_Tuukasyu.JPY);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI, "支払方法指定区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, C_Tuukasyu.JPY);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI, "支払方法指定区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(C_InputShrhousiteiKbn.FBSOUKIN, C_Tuukasyu.JPY);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(C_InputShrhousiteiKbn.FBSOUKIN, C_Tuukasyu.USD);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(C_InputShrhousiteiKbn.FBSOUKIN, null);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.BLNK, "支払方法指定区分");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        C_ShrhousiteiKbn shrhousiteiKbn;
        shrhousiteiKbn = setteiShrhousiteiKbn.exec(null, C_Tuukasyu.AUD);
        exClassificationEquals(shrhousiteiKbn, C_ShrhousiteiKbn.BLNK, "支払方法指定区分");

        MockObjectManager.initialize();

    }
}

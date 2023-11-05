package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.testinfr.TestOrder;

/**
 * 氏名カナ入力チェッククラスのメソッド {@link CheckSimeiKana#exec(MosnaiCheckParam, String, String)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckSimeiKanaTest_exec {

    @Inject
    private CheckSimeiKana checkSimeiKana;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        checkSimeiKana.exec( mosnaiCheckParam, "", null);

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        String message = "氏名カナ";
        checkSimeiKana.exec( mosnaiCheckParam, "カナ　カナ", message);

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        String message = "氏名カナ";

        checkSimeiKana.exec( mosnaiCheckParam, "A1#B2", message);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "氏名カナが正しくありません。", "結果画面ＭＳＧ");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        String message = "氏名カナ";

        checkSimeiKana.exec( mosnaiCheckParam, "カナカナカナカナカナカナカナカナカナ　カ", message);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "氏名カナ　半角カナでの入力桁数が超過しています。（１８文字以下）", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(50)
    public void testExec_B1() {

        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        checkSimeiKana.exec( mosnaiCheckParam, null, null);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");

        MockObjectManager.initialize();
    }
}

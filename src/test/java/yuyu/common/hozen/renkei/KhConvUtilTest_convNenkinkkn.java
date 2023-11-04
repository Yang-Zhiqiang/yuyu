package yuyu.common.hozen.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金期間変換 {@link KhConvUtil#convNenkinkkn(C_Sknenkinsyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhConvUtilTest_convNenkinkkn {

    @Inject
    private KhConvUtil khConvUtil;

    @Test
    @TestOrder(10)
    public void testExec_B1() {
        int nenkinsyu = khConvUtil.convNenkinkkn(C_Sknenkinsyu.BLNK);

        exNumericEquals(nenkinsyu, 0, "年金期間");
    }

    @Test
    @TestOrder(20)
    public void testExec_B2() {
        int nenkinsyu = khConvUtil.convNenkinkkn(C_Sknenkinsyu.KKTI5);

        exNumericEquals(nenkinsyu, 5, "年金期間");
    }

    @Test
    @TestOrder(30)
    public void testExec_B3() {
        int nenkinsyu = khConvUtil.convNenkinkkn(C_Sknenkinsyu.KKTI5DAI1BAIGAKU);

        exNumericEquals(nenkinsyu, 5, "年金期間");
    }

    @Test
    @TestOrder(40)
    public void testExec_B4() {
        int nenkinsyu = khConvUtil.convNenkinkkn(C_Sknenkinsyu.KKTI10);

        exNumericEquals(nenkinsyu, 10, "年金期間");
    }

    @Test
    @TestOrder(50)
    public void testExec_B5() {
        int nenkinsyu = khConvUtil.convNenkinkkn(C_Sknenkinsyu.KKTI15);

        exNumericEquals(nenkinsyu, 15, "年金期間");
    }

    @Test
    @TestOrder(60)
    public void testExec_B6() {
        int nenkinsyu = khConvUtil.convNenkinkkn(C_Sknenkinsyu.SGKHSYSYSN);

        exNumericEquals(nenkinsyu, 99, "年金期間");
    }
}
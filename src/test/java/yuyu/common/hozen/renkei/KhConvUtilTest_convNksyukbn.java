package yuyu.common.hozen.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金種類区分変換 {@link KhConvUtil#convNksyukbn(C_Sknenkinsyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhConvUtilTest_convNksyukbn {

    @Inject
    private KhConvUtil khConvUtil;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        C_Nenkinsyu nenkinsyu = khConvUtil.convNksyukbn(C_Sknenkinsyu.BLNK);

        exClassificationEquals(nenkinsyu, C_Nenkinsyu.BLNK, "年金種類区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        C_Nenkinsyu nenkinsyu = khConvUtil.convNksyukbn(C_Sknenkinsyu.KKTI5);

        exClassificationEquals(nenkinsyu, C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        C_Nenkinsyu nenkinsyu = khConvUtil.convNksyukbn(C_Sknenkinsyu.KKTI10);

        exClassificationEquals(nenkinsyu, C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        C_Nenkinsyu nenkinsyu = khConvUtil.convNksyukbn(C_Sknenkinsyu.KKTI15);

        exClassificationEquals(nenkinsyu, C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        C_Nenkinsyu nenkinsyu = khConvUtil.convNksyukbn(C_Sknenkinsyu.SGKHSYSYSN);

        exClassificationEquals(nenkinsyu, C_Nenkinsyu.SGKHSYSYSNNENKIN, "年金種類区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        C_Nenkinsyu nenkinsyu = khConvUtil.convNksyukbn(C_Sknenkinsyu.KKTI5DAI1BAIGAKU);

        exClassificationEquals(nenkinsyu, C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK, "年金種類区分");
    }
}
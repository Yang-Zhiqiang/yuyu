package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定関係法人チェックのメソッド {@link CheckTkhjn#checkYouhiHantei(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTkhjnTest_hanteiCheckYouhi {

    @Inject
    private CheckTkhjn checkTkhjn;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testHanteiCheckYouhi_A1() {

        C_YouhiKbn youhiKbn = checkTkhjn.hanteiCheckYouhi("0009");

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "要否区分");

    }

    @Test
    @TestOrder(20)
    public void testHanteiCheckYouhi_A2() {

        C_YouhiKbn youhiKbn = checkTkhjn.hanteiCheckYouhi("0008");

        exClassificationEquals(youhiKbn, C_YouhiKbn.YOU, "要否区分");

    }
}

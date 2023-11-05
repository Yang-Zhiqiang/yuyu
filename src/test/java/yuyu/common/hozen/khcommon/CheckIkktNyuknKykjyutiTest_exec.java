package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * CheckIkktNyuknKykjyutiクラスのメソッド {@link CheckIkktNyuknKykjyuti#exec(BizDate, BizDateYM)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckIkktNyuknKykjyutiTest_exec {

    @Inject
    private CheckIkktNyuknKykjyuti checkIkktNyuknKykjyuti;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_Kykjyoutai kykjyoutaikbn = checkIkktNyuknKykjyuti.exec(BizDate.valueOf(20180101), BizDateYM.valueOf(201802));
        exClassificationEquals(kykjyoutaikbn, C_Kykjyoutai.HRKMTYUU, "契約状態");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_Kykjyoutai kykjyoutaikbn = checkIkktNyuknKykjyuti.exec(BizDate.valueOf(20180101), BizDateYM.valueOf(201804));
        exClassificationEquals(kykjyoutaikbn, C_Kykjyoutai.IKKATUNK, "契約状態");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_Kykjyoutai kykjyoutaikbn = checkIkktNyuknKykjyuti.exec(BizDate.valueOf(20180101), BizDateYM.valueOf(201803));
        exClassificationEquals(kykjyoutaikbn, C_Kykjyoutai.IKKATUNK, "契約状態");
    }
}

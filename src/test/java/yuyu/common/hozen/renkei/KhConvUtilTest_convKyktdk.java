package yuyu.common.hozen.renkei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約管理契約者続柄変換 {@link KhConvUtil#convKyktdk(C_KykKbn,C_Tdk)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhConvUtilTest_convKyktdk {

    @Inject
    private KhConvUtil khConvUtil;

    @Test
    @TestOrder(10)
    public void testExec_C1() {
        C_Tdk tdk = khConvUtil.convKyktdk(C_KykKbn.KEIHI_DOUITU, C_Tdk.BLNK);

        exClassificationEquals(tdk, C_Tdk.HONNIN, "契約管理契約者続柄");
    }

    @Test
    @TestOrder(20)
    public void testExec_C2() {
        C_Tdk tdk = khConvUtil.convKyktdk(C_KykKbn.BLNK, C_Tdk.HGU);

        exClassificationEquals(tdk, C_Tdk.HGU, "契約管理契約者続柄");
    }
}
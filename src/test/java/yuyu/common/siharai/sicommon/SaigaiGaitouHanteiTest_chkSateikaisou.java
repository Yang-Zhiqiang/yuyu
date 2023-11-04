package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 災害該当判定クラスの災害該当判定（査定回送要否）メソッド {@link SaigaiGaitouHantei#chkSateikaisou(C_UmuKbn)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SaigaiGaitouHanteiTest_chkSateikaisou {

    @Inject
    private SaigaiGaitouHantei saigaiGaitouHantei;

    @Test
    @TestOrder(310)
    public void testChkSateikaisou_A1() {

        boolean result = saigaiGaitouHantei.chkSateikaisou(null);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(320)
    public void testChkSateikaisou_A2() {

        boolean result = saigaiGaitouHantei.chkSateikaisou(C_UmuKbn.NONE);

        exBooleanEquals(result, false, "判定結果フラグ");
    }

    @Test
    @TestOrder(330)
    public void testChkSateikaisou_A3() {

        boolean result = saigaiGaitouHantei.chkSateikaisou(C_UmuKbn.ARI);

        exBooleanEquals(result, true, "判定結果フラグ");
    }


}

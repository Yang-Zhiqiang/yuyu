package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 組織判定ユーティリティ {@link BzHanteiSosikiUtil#exec(String,SosikiCd)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzHanteiSosikiUtilTest1_exec extends AbstractTest {

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String SosikiCd = "";

        Boolean result = BzHanteiSosikiUtil.isCallcenterKeySosikicd(SosikiCd);
        exBooleanEquals(result, false, "組織判定結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String SosikiCd = null;

        Boolean result = BzHanteiSosikiUtil.isCallcenterKeySosikicd(SosikiCd);
        exBooleanEquals(result, false, "組織判定結果");

    }


    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String SosikiCd = "6620000";

        Boolean result = BzHanteiSosikiUtil.isCallcenterKeySosikicd(SosikiCd);
        exBooleanEquals(result, true, "組織判定結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String SosikiCd = "1070010";

        Boolean result = BzHanteiSosikiUtil.isCallcenterKeySosikicd(SosikiCd);
        exBooleanEquals(result, false, "組織判定結果");

    }
}


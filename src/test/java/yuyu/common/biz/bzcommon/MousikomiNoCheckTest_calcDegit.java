package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 申込番号チェッククラスのメソッド {@link MousikomiNoCheck#calcDegit(String)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class MousikomiNoCheckTest_calcDegit {

    @Test
    @TestOrder(10)
    public void testCalcDegit_A1() {

        String mosno = "98abcdef";

        int result = MousikomiNoCheck.calcDegit(mosno);

        exNumericEquals(result, -999, "チェックディジット");
    }

    @Test
    @TestOrder(20)
    public void testCalcDegit_A2() {

        String mosno = "ab123456";

        int result = MousikomiNoCheck.calcDegit(mosno);

        exNumericEquals(result, -999, "チェックディジット");
    }

    @Test
    @TestOrder(30)
    public void testCalcDegit_A3() {

        String mosno = "14234567";

        int result = MousikomiNoCheck.calcDegit(mosno);

        exNumericEquals(result, -999, "チェックディジット");
    }

    @Test
    @TestOrder(40)
    public void testCalcDegit_A4() {

        String mosno = "98000000";

        int result = MousikomiNoCheck.calcDegit(mosno);

        exNumericEquals(result, 4, "チェックディジット");
    }

    @Test
    @TestOrder(50)
    public void testCalcDegit_A5() {

        String mosno = "98000002";

        int result = MousikomiNoCheck.calcDegit(mosno);

        exNumericEquals(result, 0, "チェックディジット");
    }

    @Test
    @TestOrder(60)
    public void testCalcDegit_A6() {

        String mosno = "98000003";

        int result = MousikomiNoCheck.calcDegit(mosno);

        exNumericEquals(result, 8, "チェックディジット");

        MockObjectManager.initialize();
    }

}

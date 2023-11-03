package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 充当回数計算クラスのメソッド {@link JtKaisukeisan#exec(int, int, C_Hrkkaisuu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class JtKaisukeisanTest_exec {

    @Inject
    private JtKaisukeisan jtKaisukeisan;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        jtKaisukeisan.exec(1, 1, C_Hrkkaisuu.ITIJI);
        exNumericEquals(jtKaisukeisan.getJyutoukaisuu(), 1, "充当回数");
        exNumericEquals(jtKaisukeisan.getHasuutuki(), 0, "端数月");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        jtKaisukeisan.exec(0, 0, C_Hrkkaisuu.TUKI);
        exNumericEquals(jtKaisukeisan.getJyutoukaisuu(), 0, "充当回数");
        exNumericEquals(jtKaisukeisan.getHasuutuki(), 0, "端数月");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        jtKaisukeisan.exec(-1, -1, C_Hrkkaisuu.TUKI);
        exNumericEquals(jtKaisukeisan.getJyutoukaisuu(), 0, "充当回数");
        exNumericEquals(jtKaisukeisan.getHasuutuki(), 0, "端数月");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        jtKaisukeisan.exec(1, 1, C_Hrkkaisuu.HALFY);
        exNumericEquals(jtKaisukeisan.getJyutoukaisuu(), 2, "充当回数");
        exNumericEquals(jtKaisukeisan.getHasuutuki(), 1, "端数月");

    }

}

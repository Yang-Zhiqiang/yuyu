package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 決算年始日設定クラスのメソッド {@link SetKessanNensibi#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SetKessanNensibiTest_Exec {

    @Inject
    private SetKessanNensibi setKessanNensibi;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        BizDate resultDate = setKessanNensibi.exec(BizDate.valueOf("20130331"));

        exDateEquals(resultDate, BizDate.valueOf("20120401"), "決算年始日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        BizDate resultDate = setKessanNensibi.exec(BizDate.valueOf("20130401"));

        exDateEquals(resultDate, BizDate.valueOf("20130401"), "決算年始日");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        BizDate resultDate = setKessanNensibi.exec(BizDate.valueOf("20130402"));

        exDateEquals(resultDate, BizDate.valueOf("20130401"), "決算年始日");
    }
}
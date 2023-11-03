package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険年齢設定のメソッド {@link SetHokenNenrei#exec(BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHokenNenreiTest_exec {

    @Inject
    private SetHokenNenrei setHokenNenrei;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate pKijyunYmd = BizDate.valueOf("20051023");
        BizDate pBirthday = BizDate.valueOf("20151023");
        int phkNenrei = setHokenNenrei.exec(pKijyunYmd, pBirthday);
        exNumericEquals(phkNenrei, 1, "保険年齢");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate pKijyunYmd = BizDate.valueOf("20150423");
        BizDate pBirthday = BizDate.valueOf("20151023");
        int phkNenrei = setHokenNenrei.exec(pKijyunYmd, pBirthday);
        exNumericEquals(phkNenrei, 1, "保険年齢");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate pKijyunYmd = BizDate.valueOf("20151023");
        BizDate pBirthday = BizDate.valueOf("20051023");
        int phkNenrei = setHokenNenrei.exec(pKijyunYmd, pBirthday);
        exNumericEquals(phkNenrei, 10, "保険年齢");

    }
}

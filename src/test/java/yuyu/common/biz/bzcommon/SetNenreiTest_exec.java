package yuyu.common.biz.bzcommon;

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
 * {@link SetNenrei}クラスに含まれる {@link SetNenrei#exec( BizDate pKijyunYmd, BizDate pBirthday )} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)

public class SetNenreiTest_exec {

    @Inject
    private static SetNenrei setNenrei;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1(){
        BizDate pKijyunYmd = BizDate.valueOf(20000612) ;
        BizDate pBirthday = null ;
        int nenrei = setNenrei.exec(pKijyunYmd,pBirthday);
        int expect = 0;
        exNumericEquals(nenrei, expect, "年齢");
    }

    @Test
    @TestOrder(20)
    public void testExec_B1(){
        BizDate pKijyunYmd = BizDate.valueOf(20150612) ;
        BizDate pBirthday = BizDate.valueOf(20150611) ;
        int nenrei = setNenrei.exec(pKijyunYmd,pBirthday);
        int expect = 0;
        exNumericEquals(nenrei, expect, "年齢");
    }

    @Test
    @TestOrder(30)
    public void testExec_B2(){
        BizDate pKijyunYmd = BizDate.valueOf(20150611) ;
        BizDate pBirthday = BizDate.valueOf(20150612) ;
        int nenrei = setNenrei.exec(pKijyunYmd,pBirthday);
        int expect = 0;
        exNumericEquals(nenrei, expect, "年齢");
    }

    @Test
    @TestOrder(40)
    public void testExec_B3(){
        BizDate pKijyunYmd = BizDate.valueOf(20140612) ;
        BizDate pBirthday = BizDate.valueOf(20140612) ;
        int nenrei = setNenrei.exec(pKijyunYmd,pBirthday);
        int expect = 0;
        exNumericEquals(nenrei, expect, "年齢");
    }

    @Test
    @TestOrder(50)
    public void testExec_B4(){
        BizDate pKijyunYmd = BizDate.valueOf(20150612) ;
        BizDate pBirthday = BizDate.valueOf(10150612) ;
        int nenrei = setNenrei.exec(pKijyunYmd,pBirthday);
        int expect = 0;
        exNumericEquals(nenrei, expect, "年齢");
    }

    @Test
    @TestOrder(60)
    public void testExec_B5(){
        BizDate pKijyunYmd = BizDate.valueOf(19990612) ;
        BizDate pBirthday = BizDate.valueOf(10000612) ;
        int nenrei = setNenrei.exec(pKijyunYmd,pBirthday);
        int expect = 999;
        exNumericEquals(nenrei, expect, "年齢");
    }

    @Test
    @TestOrder(60)
    public void testExec_B6(){
        BizDate pKijyunYmd = BizDate.valueOf(19980612) ;
        BizDate pBirthday = BizDate.valueOf(10000612) ;
        int nenrei = setNenrei.exec(pKijyunYmd,pBirthday);
        int expect = 998;
        exNumericEquals(nenrei, expect, "年齢");
    }
}

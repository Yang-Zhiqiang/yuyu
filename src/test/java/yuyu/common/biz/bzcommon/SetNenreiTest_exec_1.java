package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link SetNenrei}クラスに含まれる {@link SetNenrei#getNkshrStartNenrei( int pHhknnen, int pHknkkn )} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)

public class SetNenreiTest_exec_1 {

    @Inject
    private static SetNenrei setNenrei;


    @Test
    @TestOrder(10)
    public void testExec_A1(){
        int pHhknnen = 60 ;
        int pHknkkn = 60 ;
        int nkshrStartNenrei = setNenrei.getNkshrStartNenrei(pHhknnen, pHknkkn);
        int expect = 99;
        exNumericEquals(nkshrStartNenrei, expect, "年金支払開始年齢");
    }

    @Test
    @TestOrder(10)
    public void testExec_A2(){
        int pHhknnen = 50 ;
        int pHknkkn = 50 ;
        int nkshrStartNenrei = setNenrei.getNkshrStartNenrei(pHhknnen, pHknkkn);
        int expect = 99;
        exNumericEquals(nkshrStartNenrei, expect, "年金支払開始年齢");
    }

    @Test
    @TestOrder(10)
    public void testExec_A3(){
        int pHhknnen = 40 ;
        int pHknkkn = 40 ;
        int nkshrStartNenrei = setNenrei.getNkshrStartNenrei(pHhknnen, pHknkkn);
        int expect = 80;
        exNumericEquals(nkshrStartNenrei, expect, "年金支払開始年齢");
    }

    @Test
    @TestOrder(10)
    public void testExec_A4(){
        int pHhknnen = 0 ;
        int pHknkkn = 0 ;
        int nkshrStartNenrei = setNenrei.getNkshrStartNenrei(pHhknnen, pHknkkn);
        int expect = 0;
        exNumericEquals(nkshrStartNenrei, expect, "年金支払開始年齢");
    }

    @Test
    @TestOrder(10)
    public void testExec_A5(){
        int pHhknnen = -60 ;
        int pHknkkn = -60 ;
        int nkshrStartNenrei = setNenrei.getNkshrStartNenrei(pHhknnen, pHknkkn);
        int expect = 0;
        exNumericEquals(nkshrStartNenrei, expect, "年金支払開始年齢");
    }
}

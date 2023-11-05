package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.classification.Classification;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AuthoritrkKbn;
import yuyu.def.classification.C_SyuukeilvKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagetorihikiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 区分変換クラスＣクラスのメソッド {@link ConvKbnC#getCodeCnv( Classification<?> pClassification, int pConvKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvKbnCTest_getCodeCnv {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testGetCodeCnv_A1(){
        Classification<?> target1 = null ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }


    @Test
    @TestOrder(20)
    public void testGetCodeCnv_B1(){
        Classification<?> target1 = C_AuthoritrkKbn.ITIYEN ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "0";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(30)
    public void testGetCodeCnv_B2(){
        Classification<?> target1 = C_AuthoritrkKbn.JITUGAKU ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "9";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(40)
    public void testGetCodeCnv_B3(){
        Classification<?> target1 = C_SyuukeilvKbn.FLOORLIMITOVER ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "0";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(50)
    public void testGetCodeCnv_B4(){
        Classification<?> target1 = C_SyuukeilvKbn.AUTHORIHUYOU ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(60)
    public void testGetCodeCnv_B5(){
        Classification<?> target1 = C_SyuukeilvKbn.AUTHORIHITUYOU ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(70)
    public void testGetCodeCnv_B6(){
        Classification<?> target1 = C_UriagetorihikiKbn.TUUJYOUURIAGE ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "0";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(80)
    public void testGetCodeCnv_B7(){
        Classification<?> target1 = C_UriagetorihikiKbn.HENPINTORIKESI ;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(90)
    public void testGetCodeCnv_B8(){
        Classification<?> target1 = C_AuthoritrkKbn.ITIYEN ;
        int target2 = 1 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(100)
    public void testGetCodeCnv_B9(){
        Classification<?> target1 = C_AuthoritrkKbn.JITUGAKU ;
        int target2 = 1 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(110)
    public void testGetCodeCnv_B10(){
        Classification<?> target1 = C_SyuukeilvKbn.FLOORLIMITOVER ;
        int target2 = 1;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(120)
    public void testGetCodeCnv_B11(){
        Classification<?> target1 = C_SyuukeilvKbn.AUTHORIHUYOU ;
        int target2 = 1 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "3";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(130)
    public void testGetCodeCnv_B12(){
        Classification<?> target1 = C_SyuukeilvKbn.AUTHORIHITUYOU ;
        int target2 = 1 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(140)
    public void testGetCodeCnv_B13(){
        Classification<?> target1 = C_UriagetorihikiKbn.TUUJYOUURIAGE ;
        int target2 = 1 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(150)
    public void testGetCodeCnv_B14(){
        Classification<?> target1 = C_UriagetorihikiKbn.HENPINTORIKESI ;
        int target2 = 1 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }


    @Test
    @TestOrder(160)
    public void testGetCodeCnv_B15(){
        Classification<?> target1 = C_AuthoritrkKbn.BLNK;
        int target2 = 0 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }

    @Test
    @TestOrder(170)
    public void testGetCodeCnv_C1(){
        Classification<?> target1 = C_UmuKbn.ARI ;
        int target2 = 3 ;
        String result = ConvKbnC.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "業務コード体系のコード変換");
    }
}

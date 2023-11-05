package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.classification.Classification;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 区分変換クラスＢクラスのメソッド {@link ConvKbnB#getCodeCnv( Classification<?> pClassification, int pConvKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvKbnBTest_getCodeCnv {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testGetCodeCnv_A1(){
        Classification<?> target1 = null ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(20)
    public void testGetCodeCnv_B1(){
        Classification<?> target1 = C_YokinKbn.HUTUU ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(30)
    public void testGetCodeCnv_B2(){
        Classification<?> target1 = C_YokinKbn.TOUZA ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(40)
    public void testGetCodeCnv_B3(){
        Classification<?> target1 = C_YokinKbn.TYOTIKU ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "4";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(50)
    public void testGetCodeCnv_B4(){
        Classification<?> target1 = C_YokinKbn.TTYOKIN ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "5";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(60)
    public void testGetCodeCnv_B5(){
        Classification<?> target1 = C_YokinKbn.TEIKI ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "6";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(70)
    public void testGetCodeCnv_B6(){
        Classification<?> target1 = C_YokinKbn.TUMITATE ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "7";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(80)
    public void testGetCodeCnv_B7(){
        Classification<?> target1 = C_YokinKbn.HUTUU ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(90)
    public void testGetCodeCnv_B8(){
        Classification<?> target1 = C_YokinKbn.TOUZA ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(100)
    public void testGetCodeCnv_B9(){
        Classification<?> target1 = C_YokinKbn.TYOTIKU ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "4";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(110)
    public void testGetCodeCnv_B10(){
        Classification<?> target1 = C_YokinKbn.HUTUUYUTYO ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "3";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(120)
    public void testGetCodeCnv_B11(){
        Classification<?> target1 = C_YokinKbn.TEIKI ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "6";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(130)
    public void testGetCodeCnv_B12(){
        Classification<?> target1 = C_YokinKbn.TUMITATE ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "7";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(140)
    public void testGetCodeCnv_C1(){
        Classification<?> target1 = C_YokinKbn.BLNK ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(150)
    public void testGetCodeCnv_C2(){
        Classification<?> target1 = C_YokinKbn.BLNK ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(160)
    public void testGetCodeCnv_C3(){
        Classification<?> target1 = C_UmuKbn.NONE ;
        int target2 = 0 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(170)
    public void testGetCodeCnv_C4(){
        Classification<?> target1 = C_UmuKbn.NONE ;
        int target2 = 1 ;
        String result = ConvKbnB.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

}

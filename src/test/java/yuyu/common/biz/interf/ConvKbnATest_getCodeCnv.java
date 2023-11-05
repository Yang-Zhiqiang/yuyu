package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.classification.Classification;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 区分変換クラスＡクラスのメソッド {@link ConvKbnA#getCodeCnv( Classification<?> pClassification, int pConvKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvKbnATest_getCodeCnv {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testGetCodeCnv_A1(){
        Classification<?> target1 = null ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }


    @Test
    @TestOrder(20)
    public void testGetCodeCnv_B1(){
        Classification<?> target1 = C_YokinKbn.HUTUU ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(30)
    public void testGetCodeCnv_B2(){
        Classification<?> target1 = C_YokinKbn.TOUZA ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(40)
    public void testGetCodeCnv_B3(){
        Classification<?> target1 = C_YokinKbn.HUTUU ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(50)
    public void testGetCodeCnv_B4(){
        Classification<?> target1 = C_YokinKbn.TOUZA ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(60)
    public void testGetCodeCnv_B5(){
        Classification<?> target1 = C_SinkeizkKbn.SHINKI ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(70)
    public void testGetCodeCnv_B6(){
        Classification<?> target1 = C_SinkeizkKbn.HENKOU ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(80)
    public void testGetCodeCnv_B7(){
        Classification<?> target1 = C_SinkeizkKbn.KEIZOKU ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "0";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(90)
    public void testGetCodeCnv_B8(){
        Classification<?> target1 = C_SinkeizkKbn.SHINKI ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(100)
    public void testGetCodeCnv_B9(){
        Classification<?> target1 = C_SinkeizkKbn.KEIZOKU ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "3";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(110)
    public void testGetCodeCnv_B10(){
        Classification<?> target1 = C_HurihunoKbn.BLNK ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "0";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(120)
    public void testGetCodeCnv_B11(){
        Classification<?> target1 = C_HurihunoKbn.SIKINHUSOKU ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(130)
    public void testGetCodeCnv_B12(){
        Classification<?> target1 = C_HurihunoKbn.NOKOZA ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(140)
    public void testGetCodeCnv_B13(){
        Classification<?> target1 = C_HurihunoKbn.YKNSYATUGOU ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "3";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(150)
    public void testGetCodeCnv_B14(){
        Classification<?> target1 = C_HurihunoKbn.NOKOUHURIIRAI ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "4";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(160)
    public void testGetCodeCnv_B15(){
        Classification<?> target1 = C_HurihunoKbn.ITKTUGOU ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "8";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(170)
    public void testGetCodeCnv_B16(){
        Classification<?> target1 = C_HurihunoKbn.OTHER ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "9";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(180)
    public void testGetCodeCnv_B17(){
        Classification<?> target1 = C_HurihunoKbn.BLNK ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "0";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(190)
    public void testGetCodeCnv_B18(){
        Classification<?> target1 = C_HurihunoKbn.SIKINHUSOKU ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(200)
    public void testGetCodeCnv_B19(){
        Classification<?> target1 = C_HurihunoKbn.NOKOZA ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(210)
    public void testGetCodeCnv_B20(){
        Classification<?> target1 = C_HurihunoKbn.YKNSYATUGOU ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "3";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(220)
    public void testGetCodeCnv_B21(){
        Classification<?> target1 = C_HurihunoKbn.NOKOUHURIIRAI ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "4";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(230)
    public void testGetCodeCnv_B22(){
        Classification<?> target1 = C_HurihunoKbn.ITKTUGOU ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "8";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(240)
    public void testGetCodeCnv_B23(){
        Classification<?> target1 = C_HurihunoKbn.OTHER ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "9";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(250)
    public void testGetCodeCnv_C1(){
        Classification<?> target1 = C_YokinKbn.BLNK ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(260)
    public void testGetCodeCnv_C2(){
        Classification<?> target1 = C_YokinKbn.BLNK ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(270)
    public void testGetCodeCnv_C3(){
        Classification<?> target1 = C_UmuKbn.NONE ;
        int target2 = 0 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(280)
    public void testGetCodeCnv_C4(){
        Classification<?> target1 = C_UmuKbn.NONE ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(290)
    public void testGetCodeCnv_C5(){
        Classification<?> target1 = C_SinkeizkKbn.HENKOU ;
        int target2 = 1 ;
        String result = ConvKbnA.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }
}

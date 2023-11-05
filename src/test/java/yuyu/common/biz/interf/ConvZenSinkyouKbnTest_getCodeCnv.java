package yuyu.common.biz.interf;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.classification.Classification;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TratkidrtenKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 区分変換クラス（全信協用）クラスのメソッド {@link ConvZenSinkyouKbn#getCodeCnv( Classification<?> pClassification,
 * int pConvKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvZenSinkyouKbnTest_getCodeCnv {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testGetCodeCnv_A1(){
        Classification<?> target1 = null ;
        int target2 = 0 ;
        String result = ConvZenSinkyouKbn.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }


    @Test
    @TestOrder(20)
    public void testGetCodeCnv_B1(){
        Classification<?> target1 = C_TratkidrtenKbn.SINKIN ;
        int target2 = 0 ;
        String result = ConvZenSinkyouKbn.getCodeCnv(target1,target2);
        String expect = "0";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(30)
    public void testGetCodeCnv_B2(){
        Classification<?> target1 = C_TratkidrtenKbn.KOKAISYA_DRTEN ;
        int target2 = 0 ;
        String result = ConvZenSinkyouKbn.getCodeCnv(target1,target2);
        String expect = "1";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(40)
    public void testGetCodeCnv_B3(){
        Classification<?> target1 = C_TratkidrtenKbn.SINKIN ;
        int target2 = 1 ;
        String result = ConvZenSinkyouKbn.getCodeCnv(target1,target2);
        String expect = "2";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(50)
    public void testGetCodeCnv_C1(){
        Classification<?> target1 = C_UmuKbn.ARI ;
        int target2 = 3 ;
        String result = ConvZenSinkyouKbn.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }

    @Test
    @TestOrder(60)
    public void testGetCodeCnv_C2(){
        Classification<?> target1 = C_TratkidrtenKbn.KOKAISYA_DRTEN ;
        int target2 = 1 ;
        String result = ConvZenSinkyouKbn.getCodeCnv(target1,target2);
        String expect = "";
        exStringEquals(result, expect, "コードキーに対応するコード内容");
    }
}

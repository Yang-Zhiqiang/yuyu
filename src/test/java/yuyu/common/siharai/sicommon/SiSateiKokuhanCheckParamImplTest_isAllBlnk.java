package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiSateiKokuhanCheckParamImpl;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定告反チェックParamインターフェース実装クラスのメソッド{@link SiSateiKokuhanCheckParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSateiKokuhanCheckParamImplTest_isAllBlnk {

    @Inject
    SiSateiKokuhanCheckParamImpl siSateiKokuhanCheckParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(30)
    public void testIsAllBlnk_A3(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(40)
    public void testIsAllBlnk_A4(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(50)
    public void testIsAllBlnk_A5(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(60)
    public void testIsAllBlnk_A6(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(70)
    public void testIsAllBlnk_A7(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(80)
    public void testIsAllBlnk_A8(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(90)
    public void testIsAllBlnk_A9(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(100)
    public void testIsAllBlnk_A10(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(110)
    public void testIsAllBlnk_A11(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(120)
    public void testIsAllBlnk_A12(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(130)
    public void testIsAllBlnk_A13(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(140)
    public void testIsAllBlnk_A14(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("11");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(150)
    public void testIsAllBlnk_A15(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.ARI);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(160)
    public void testIsAllBlnk_A16(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("11");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(170)
    public void testIsAllBlnk_A17(){
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn1(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment1("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn2(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment2("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn3(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment3("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn4(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment4("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn5(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment5("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn6(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment6("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn7(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment7("");
        siSateiKokuhanCheckParamImpl.setKokuhancheckkbn8(C_UmuKbn.NONE);
        siSateiKokuhanCheckParamImpl.setKokuhanchecomment8("");

        boolean result = siSateiKokuhanCheckParamImpl.isAllBlnk();

        assertTrue(result);

        MockObjectManager.initialize();
    }

}

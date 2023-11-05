package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiSateiIppanHanteiParamImpl;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定一般判定Paramインターフェース実装クラスのメソッド{@link SiSateiIppanHanteiParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSateiIppanHanteiParamImplTest_isAllBlnk {

    @Inject
    SiSateiIppanHanteiParamImpl siSateiIppanHanteiParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("11");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("11");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(30)
    public void testIsAllBlnk_A3(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("11");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(40)
    public void testIsAllBlnk_A4(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("11");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(50)
    public void testIsAllBlnk_A5(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("11");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(60)
    public void testIsAllBlnk_A6(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("11");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(70)
    public void testIsAllBlnk_A7(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("11");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(80)
    public void testIsAllBlnk_A8(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("11");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(90)
    public void testIsAllBlnk_A9(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("11");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(100)
    public void testIsAllBlnk_A10(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("11");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(110)
    public void testIsAllBlnk_A11(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("11");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(120)
    public void testIsAllBlnk_A12(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("11");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(130)
    public void testIsAllBlnk_A13(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("11");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(140)
    public void testIsAllBlnk_A14(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("11");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(150)
    public void testIsAllBlnk_A15(){
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu1("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment1("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu2("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment2("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu3("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment3("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu4("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment4("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu5("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment5("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuu6("");
        siSateiIppanHanteiParamImpl.setIppanhanteicomment6("");
        siSateiIppanHanteiParamImpl.setIppanhanteitensuugoukei("");
        siSateiIppanHanteiParamImpl.setIppanhanteigoukeicomment("");

        boolean result = siSateiIppanHanteiParamImpl.isAllBlnk();

        assertTrue(result);

        MockObjectManager.initialize();
    }
}

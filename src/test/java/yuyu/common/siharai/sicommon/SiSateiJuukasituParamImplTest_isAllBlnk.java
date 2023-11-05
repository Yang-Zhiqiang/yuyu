package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiSateiJuukasituParamImpl;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 査定重過失チェックParamインターフェース実装クラスのメソッド{@link SiSateiJuukasituParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSateiJuukasituParamImplTest_isAllBlnk {

    @Inject
    SiSateiJuukasituParamImpl siSateiJuukasituParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.ARI);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("11");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(30)
    public void testIsAllBlnk_A3(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.ARI);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(40)
    public void testIsAllBlnk_A4(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("22");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(50)
    public void testIsAllBlnk_A5(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.ARI);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(60)
    public void testIsAllBlnk_A6(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("33");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(70)
    public void testIsAllBlnk_A7(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.ARI);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(80)
    public void testIsAllBlnk_A8(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("44");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(90)
    public void testIsAllBlnk_A9(){
        siSateiJuukasituParamImpl.setJuukasitucheckkbn1(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment1("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn2(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment2("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn3(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment3("");
        siSateiJuukasituParamImpl.setJuukasitucheckkbn4(C_UmuKbn.NONE);
        siSateiJuukasituParamImpl.setJuukasitucheckcomment4("");

        boolean result = siSateiJuukasituParamImpl.isAllBlnk();

        assertTrue(result);

        MockObjectManager.initialize();
    }
}

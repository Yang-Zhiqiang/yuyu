package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiMeigihenkouSateiParamImpl;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 名義変更査定Paramインターフェース実装クラスのメソッド{@link SiMeigihenkouSateiParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiMeigihenkouSateiParamImplTest_isAllBlnk {

    @Inject
    SiMeigihenkouSateiParamImpl siMeigihenkouSateiParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siMeigihenkouSateiParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.ENABLE);
        siMeigihenkouSateiParamImpl.setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktnm("");


        boolean result = siMeigihenkouSateiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siMeigihenkouSateiParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktkbn(C_MeihenUktKbn.DOUITU);
        siMeigihenkouSateiParamImpl.setMeihenuktnm("");


        boolean result = siMeigihenkouSateiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(30)
    public void testIsAllBlnk_A3(){
        siMeigihenkouSateiParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktnm("11");


        boolean result = siMeigihenkouSateiParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(40)
    public void testIsAllBlnk_A4(){
        siMeigihenkouSateiParamImpl.setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktkbn(C_MeihenUktKbn.BLNK);
        siMeigihenkouSateiParamImpl.setMeihenuktnm("");


        boolean result = siMeigihenkouSateiParamImpl.isAllBlnk();

        assertTrue(result);

        MockObjectManager.initialize();
    }
}

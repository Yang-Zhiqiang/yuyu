package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiBetukutiSateiSbParamImpl;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 別口チェック項目（死亡）Paramインターフェース実装クラスのメソッド{@link SiBetukutiSateiSbParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiBetukutiSateiSbParamImplTest_isAllBlnk {

    @Inject
    SiBetukutiSateiSbParamImpl siBetukutiSateiSbParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siBetukutiSateiSbParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.ARI);
        siBetukutiSateiSbParamImpl.setBetusiboucomment("");
        siBetukutiSateiSbParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusoukicomment("");

        boolean result = siBetukutiSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siBetukutiSateiSbParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusiboucomment("11");
        siBetukutiSateiSbParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusoukicomment("");

        boolean result = siBetukutiSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(30)
    public void testIsAllBlnk_A3(){
        siBetukutiSateiSbParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusiboucomment("");
        siBetukutiSateiSbParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.ARI);
        siBetukutiSateiSbParamImpl.setBetusoukicomment("");

        boolean result = siBetukutiSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(40)
    public void testIsAllBlnk_A4(){
        siBetukutiSateiSbParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusiboucomment("");
        siBetukutiSateiSbParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusoukicomment("11");

        boolean result = siBetukutiSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(50)
    public void testIsAllBlnk_A5(){
        siBetukutiSateiSbParamImpl.setBetusibouumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusiboucomment("");
        siBetukutiSateiSbParamImpl.setBetusoukiumukbn(C_NoinitUmuKbn.BLNK);
        siBetukutiSateiSbParamImpl.setBetusoukicomment("");

        boolean result = siBetukutiSateiSbParamImpl.isAllBlnk();

        assertTrue(result);

        MockObjectManager.initialize();
    }
}

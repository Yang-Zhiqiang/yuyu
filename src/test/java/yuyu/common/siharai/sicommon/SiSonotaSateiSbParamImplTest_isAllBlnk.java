package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiSonotaSateiSbParamImpl;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * その他チェック項目（死亡）Paramインターフェース実装クラスのメソッド{@link SiSonotaSateiSbParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSonotaSateiSbParamImplTest_isAllBlnk {

    @Inject
    SiSonotaSateiSbParamImpl siSonotaSateiSbParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siSonotaSateiSbParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.ARI);
        siSonotaSateiSbParamImpl.setKujyouumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setJimumissumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.BLNK);

        boolean result = siSonotaSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siSonotaSateiSbParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKujyouumukbn(C_NoinitUmuKbn.ARI);
        siSonotaSateiSbParamImpl.setJimumissumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.BLNK);

        boolean result = siSonotaSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(30)
    public void testIsAllBlnk_A3(){
        siSonotaSateiSbParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKujyouumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setJimumissumukbn(C_NoinitUmuKbn.ARI);
        siSonotaSateiSbParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.BLNK);

        boolean result = siSonotaSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(40)
    public void testIsAllBlnk_A4(){
        siSonotaSateiSbParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKujyouumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setJimumissumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.YOU);

        boolean result = siSonotaSateiSbParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(50)
    public void testIsAllBlnk_A5(){
        siSonotaSateiSbParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKujyouumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setJimumissumukbn(C_NoinitUmuKbn.BLNK);
        siSonotaSateiSbParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.BLNK);

        boolean result = siSonotaSateiSbParamImpl.isAllBlnk();

        assertTrue(result);

        MockObjectManager.initialize();
    }
}

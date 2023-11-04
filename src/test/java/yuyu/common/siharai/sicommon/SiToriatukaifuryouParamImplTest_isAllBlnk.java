package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.siharai.edittbl.SiToriatukaifuryouParamImpl;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取扱不良・不祥事件等Paramインターフェース実装クラスのメソッド{@link SiToriatukaifuryouParamImpl#isAllBlnk()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiToriatukaifuryouParamImplTest_isAllBlnk {

    @Inject
    SiToriatukaifuryouParamImpl siToriatukaifuryouParamImpl;

    @Test
    @TestOrder(10)
    public void testIsAllBlnk_A1(){
        siToriatukaifuryouParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.ARI);
        siToriatukaifuryouParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.BLNK);
        siToriatukaifuryouParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.BLNK);
        siToriatukaifuryouParamImpl.setTratkihuryoucomment("");

        boolean result = siToriatukaifuryouParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(20)
    public void testIsAllBlnk_A2(){
        siToriatukaifuryouParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.BLNK);
        siToriatukaifuryouParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.YOU);
        siToriatukaifuryouParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.BLNK);
        siToriatukaifuryouParamImpl.setTratkihuryoucomment("");

        boolean result = siToriatukaifuryouParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(30)
    public void testIsAllBlnk_A3(){
        siToriatukaifuryouParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.BLNK);
        siToriatukaifuryouParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.BLNK);
        siToriatukaifuryouParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.SYORIZUMI);
        siToriatukaifuryouParamImpl.setTratkihuryoucomment("");

        boolean result = siToriatukaifuryouParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(40)
    public void testIsAllBlnk_A4(){
        siToriatukaifuryouParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.BLNK);
        siToriatukaifuryouParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.BLNK);
        siToriatukaifuryouParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.BLNK);
        siToriatukaifuryouParamImpl.setTratkihuryoucomment("11");

        boolean result = siToriatukaifuryouParamImpl.isAllBlnk();

        assertFalse(result);
    }

    @Test
    @TestOrder(50)
    public void testIsAllBlnk_A5(){
        siToriatukaifuryouParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.BLNK);
        siToriatukaifuryouParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.BLNK);
        siToriatukaifuryouParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.BLNK);
        siToriatukaifuryouParamImpl.setTratkihuryoucomment("");

        boolean result = siToriatukaifuryouParamImpl.isAllBlnk();

        assertTrue(result);
        MockObjectManager.initialize();
    }
}

package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 契約保全文字列編集クラスのメソッド {@link KhozenEdit#editKouzaNo(String, String)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)

public class KhozenEditTest_editKouzaNo_1 {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testEditKouzaNo_A1(){
        String pBankcd = "9900" ;
        String pKouzano = "1234" ;
        String result = KhozenEdit.editKouzaNo(pBankcd,pKouzano);
        String expect = "12***";
        exStringEquals(result, expect, "（編集後）口座番号");
    }

    @Test
    @TestOrder(20)
    public void testEditKouzaNo_A2(){
        String pBankcd = "1000" ;
        String pKouzano = "1234" ;
        String result = KhozenEdit.editKouzaNo(pBankcd,pKouzano);
        String expect = "1***";
        exStringEquals(result, expect, "（編集後）口座番号");
    }
}

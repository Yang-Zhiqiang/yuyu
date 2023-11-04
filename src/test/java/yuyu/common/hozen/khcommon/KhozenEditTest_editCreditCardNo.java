package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全文字列編集クラスのメソッド {@link KhozenEdit#editCreditCardNo(String, String, int)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhozenEditTest_editCreditCardNo {

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testEditCreditCardNo_A1(){
        String pValue = "1234567890123456789";
        String pSyono = "10000000001";
        String pCreditcardno = EditSecurityKm.getEncodeData(pSyono, pValue);
        int pIndex = 4 ;
        String result = KhozenEdit.editCreditCardNo(pSyono, pCreditcardno, pIndex);
        String expect = "1234567890123456789";
        exStringEquals(result, expect, "（編集後）クレジットカード番号");
    }

    @Test
    @TestOrder(20)
    public void testEditCreditCardNo_A2(){
        String pValue = "1234567890123456789";
        String pSyono = "10000000001";
        String pCreditcardno = EditSecurityKm.getEncodeData(pSyono, pValue);
        int pIndex = 2 ;
        String result = KhozenEdit.editCreditCardNo(pSyono, pCreditcardno, pIndex);
        String expect = "****";
        exStringEquals(result, expect, "（編集後）クレジットカード番号");
    }
}
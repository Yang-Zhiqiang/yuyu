package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 契約保全文字列編集クラスのメソッド {@link KhozenEdit#editSeirekiYMD(BizDate)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class KhozenEditTest_editSeirekiYMD_1 {
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testEditSeirekiYMD_A1(){
        BizDate pKouzano = BizDate.valueOf(20150101) ;
        String result = KhozenEdit.editSeirekiYMD(pKouzano);
        String expect = "2015.01.01";
        exStringEquals(result, expect, " 編集された日付文字列（YYYY.MM.DD）");
    }

    @Test
    @TestOrder(20)
    public void testEditSeirekiYMD_B1(){
        BizDate pKouzano = null ;
        String result = KhozenEdit.editSeirekiYMD(pKouzano);
        String expect = "";
        exStringEquals(result, expect, " 編集された日付文字列（YYYY.MM.DD）");
    }
}

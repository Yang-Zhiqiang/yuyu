package yuyu.common.biz.bzunyo;

import static org.junit.Assert.*;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_TestSyonokanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * テストデータ変換クラス<br />
 * setTestKanjiNm メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ConvertTestDataTest_exec_setTestKanjiNm{

    @Inject
    private ConvertTestData convertTestData;

    @Inject
    BM_TestSyonokanri bmTestSyonokanri = new BM_TestSyonokanri();

    @Inject
    ConvertTestDataOutBean convertTestDataOutBean1 = new ConvertTestDataOutBean();

    @Test
    @TestOrder(10)
    public void normal1(){

        String convertTestData1 = convertTestData.setTestKanjiNm("テスト契約者", "テスト契約者", "178080195435");
        assertEquals("テスト契約者　４３５",convertTestData1);

    }

    @Test
    @TestOrder(20)
    public void normal2(){

        String convertTestData2 =convertTestData.setTestKanjiNm(null, "テスト契約者", "178080195435");
        assertEquals("<NULL>",convertTestData2);

    }

    @Test
    @TestOrder(30)
    public void normal3(){

        String convertTestData3 = convertTestData.setTestKanjiNm("", "テスト契約者", "178080195435");
        assertEquals("",convertTestData3);

    }
}
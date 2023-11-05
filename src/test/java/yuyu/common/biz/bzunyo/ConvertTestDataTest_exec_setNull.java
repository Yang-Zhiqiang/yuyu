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
 * setNull メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ConvertTestDataTest_exec_setNull{

    @Inject
    private ConvertTestData convertTestData;

    @Inject
    BM_TestSyonokanri bmTestSyonokanri = new BM_TestSyonokanri();

    @Inject
    ConvertTestDataOutBean convertTestDataOutBean1 = new ConvertTestDataOutBean();

    @Test
    @TestOrder(10)
    public void normal1(){

        String nullValue = convertTestData.setNull("NULLテスト項目");
        assertEquals("NULLテスト項目",nullValue);

    }

    @Test
    @TestOrder(20)
    public void normal2(){

        String nullValue = convertTestData.setNull(null);
        assertEquals("<NULL>",nullValue);

    }

    @Test
    @TestOrder(30)
    public void normal3(){

        String nullValue = convertTestData.setNull("null");
        assertEquals("<NULL>",nullValue);

    }
}
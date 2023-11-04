package yuyu.common.biz.prereport;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.OrderedRunner;

/**
 * {@link GetQRCode}クラスに含まれる、{@link GetQRCode#execGetQRCode (String)} メソッドのテストです。
 * <br />
 */
@RunWith(OrderedRunner.class)
public class GetQRCodeTest_execGetQRCode {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_QRコード値取得処理";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetQRCodeTest_execGetQRCode.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());
    }

    @Test
    public void testExecGetQRCode_A1(){
        String pSyoruiCd = null;
        String result = GetQRCode.execGetQRCode(pSyoruiCd);
        assertNull(result);
    }

    @Test
    public void testExecGetQRCode_A2(){
        String pSyoruiCd = "cm021";
        GetQRCode.execGetQRCode(pSyoruiCd);
    }

    @Test
    public void testExecGetQRCode_A3(){
        String pSyoruiCd = "cm001";
        GetQRCode.execGetQRCode(pSyoruiCd);
    }

    @Test
    public void testExecGetQRCode_A4(){
        String pSyoruiCd = "cm002";
        String result = GetQRCode.execGetQRCode(pSyoruiCd);
        assertNull(result);
    }
}

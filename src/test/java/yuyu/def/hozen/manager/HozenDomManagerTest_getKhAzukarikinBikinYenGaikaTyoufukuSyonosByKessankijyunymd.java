package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約保全預り金備金リスト作成<br />
 * 預り金円貨外貨重複証券番号リスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd {

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd";

    private final static String sheetName = "INデータ";

    /**
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("マスタデータ", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }
     */

    /**
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
    }
     */

    @Transactional
    private void insertData(String pDate) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd.class, fileName, sheetName);
            testDataMaker.insDataByDataId(pDate, testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    private void deleteData() {
        hozenDomManager.delete(hozenDomManager.getAllAzukarikinKessankanri());
        hozenDomManager.flush();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {
        deleteData();
        List<String> syonoList = hozenDomManager.
            getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate.valueOf(20190624));
        Assert.assertEquals(0, syonoList.size());
        deleteData();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void noResult2() {
        insertData("データ001");
        List<String> syonoList = hozenDomManager.
            getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate.valueOf(20190624));
        Assert.assertEquals(0, syonoList.size());
        deleteData();
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal1() {
        insertData("データ002");
        List<String> syonoList = hozenDomManager.
            getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate.valueOf(20190624));
        Assert.assertEquals(1, syonoList.size());
        Assert.assertEquals("60806000103", syonoList.get(0));
        deleteData();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal2() {
        insertData("データ003");
        List<String> syonoList = hozenDomManager.
            getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate.valueOf(20190624));
        Assert.assertEquals(3, syonoList.size());
        Assert.assertEquals("60806000309", syonoList.get(0));
        Assert.assertEquals("60806000206", syonoList.get(1));
        Assert.assertEquals("60806000103", syonoList.get(2));
        deleteData();
    }
}
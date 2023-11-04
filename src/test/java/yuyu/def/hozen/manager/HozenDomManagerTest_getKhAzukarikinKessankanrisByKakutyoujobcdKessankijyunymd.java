package yuyu.def.hozen.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約保全預り金リスト作成<br />
 * 預り金決算管理テーブルエンティティリスト(大量)取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd {

    @Inject
    HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("マスタデータ", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
    }

    @Transactional
    private void insertData(String pDate) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HozenDomManagerTest_getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd.class, fileName, sheetName);
            testDataMaker.insDataByDataId(pDate, testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    private void deleteData() {
        hozenDomManager.delete(hozenDomManager.getAllAzukarikinKessankanri());
        hozenDomManager.flush();
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSkipKey());
        bizDomManager.flush();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {
        deleteData();
        try(ExDBResults<IT_AzukarikinKessankanri> exDBResBean = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd("RBGDX000", BizDate.valueOf(20190624))){
            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void noResult2() {
        insertData("データ001");
        List<String> syonoList = new ArrayList<String>();
        try(ExDBResults<IT_AzukarikinKessankanri> exDBResBean = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd("RBGDX000", BizDate.valueOf(20190624));){
            for (IT_AzukarikinKessankanri azukarikinKessankanri : exDBResBean) {
                syonoList.add(azukarikinKessankanri.getSyono());
            }
            Assert.assertEquals(0, syonoList.size());
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal1() {
        insertData("データ002");
        List<String> syonoList = new ArrayList<String>();
        try(ExDBResults<IT_AzukarikinKessankanri> exDBResBean = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd("RBGDX000", BizDate.valueOf(20190624));){
            for (IT_AzukarikinKessankanri azukarikinKessankanri : exDBResBean) {
                syonoList.add(azukarikinKessankanri.getSyono());
            }
            Assert.assertEquals(1, syonoList.size());
            Assert.assertEquals("60806000103", syonoList.get(0));
        }
        deleteData();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal2() {
        insertData("データ003");
        List<String> syonoList = new ArrayList<String>();
        try(ExDBResults<IT_AzukarikinKessankanri> exDBResBean = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd("RBGDX000", BizDate.valueOf(20190624));){
            for (IT_AzukarikinKessankanri azukarikinKessankanri : exDBResBean) {
                syonoList.add(azukarikinKessankanri.getSyono());
            }
            Assert.assertEquals(3, syonoList.size());
            Assert.assertEquals("60806000103", syonoList.get(0));
            Assert.assertEquals("60806000206", syonoList.get(1));
            Assert.assertEquals("60806000309", syonoList.get(2));
        }
        deleteData();
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void skippedFilter1() {
        insertData("データ003");
        List<String> syonoList = new ArrayList<String>();
        try(ExDBResults<IT_AzukarikinKessankanri> exDBResBean = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd("RBGDX000", BizDate.valueOf(20190624));){
            for (IT_AzukarikinKessankanri azukarikinKessankanri : exDBResBean) {
                syonoList.add(azukarikinKessankanri.getSyono());
            }
            Assert.assertEquals(3, syonoList.size());
            Assert.assertEquals("60806000103", syonoList.get(0));
            Assert.assertEquals("60806000206", syonoList.get(1));
            Assert.assertEquals("60806000309", syonoList.get(2));
        }
        deleteData();
        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("RBGDX000_IT_AzukarikinKessankanri_60806000103");
        bT_SkipKey1.setKakutyoujobcd("RBGDX000");
        bT_SkipKey1.setTableid("IT_AzukarikinKessankanri");
        bT_SkipKey1.setRecoveryfilterid("Bz001");
        bT_SkipKey1.setRecoveryfilterkey1("60806000103");
        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void skippedFilter2() {
        insertData("データ003");

        List<String> syonoList = new ArrayList<String>();
        try(ExDBResults<IT_AzukarikinKessankanri> exDBResBean = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd("RBGDX000", BizDate.valueOf(20190624));){
            for (IT_AzukarikinKessankanri azukarikinKessankanri : exDBResBean) {
                syonoList.add(azukarikinKessankanri.getSyono());
            }
            Assert.assertEquals(2, syonoList.size());
            Assert.assertEquals("60806000206", syonoList.get(0));
            Assert.assertEquals("60806000309", syonoList.get(1));
        }
        deleteData();
        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("RBGDX000_IT_AzukarikinKessankanri_60806000103");
        bT_SkipKey1.setKakutyoujobcd("RBGDX000");
        bT_SkipKey1.setTableid("IT_AzukarikinKessankanri");
        bT_SkipKey1.setRecoveryfilterid("Bz001");
        bT_SkipKey1.setRecoveryfilterkey1("60806000103");
        hozenDomManager.insert(bT_SkipKey1);
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("RBGDX000_IT_AzukarikinKessankanri_60806000206");
        bT_SkipKey2.setKakutyoujobcd("RBGDX000");
        bT_SkipKey2.setTableid("IT_AzukarikinKessankanri");
        bT_SkipKey2.setRecoveryfilterid("Bz001");
        bT_SkipKey2.setRecoveryfilterkey1("60806000206");
        hozenDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void skippedFilter3() {
        insertData("データ003");
        List<String> syonoList = new ArrayList<String>();
        try(ExDBResults<IT_AzukarikinKessankanri> exDBResBean = hozenDomManager.
            getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd("RBGDX000", BizDate.valueOf(20190624));){
            for (IT_AzukarikinKessankanri azukarikinKessankanri : exDBResBean) {
                syonoList.add(azukarikinKessankanri.getSyono());
            }
            Assert.assertEquals(1, syonoList.size());
            Assert.assertEquals("60806000309", syonoList.get(0));
        }
        deleteData();
    }

}
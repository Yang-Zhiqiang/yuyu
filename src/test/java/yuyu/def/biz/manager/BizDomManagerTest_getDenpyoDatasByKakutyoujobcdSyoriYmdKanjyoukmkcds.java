package yuyu.def.biz.manager;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds";

    private final static String sheetName = "INデータ";

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try(ExDBResults<BT_DenpyoData>  beans = bizDomManager.
            getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds("RGD1", BizDate.valueOf(20160701))){
            Assert.assertFalse(beans.iterator().hasNext());
        }

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDenpyoData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<BT_DenpyoData>  beans = bizDomManager.
            getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds("RGD1", BizDate.valueOf(20170701))){
            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_DenpyoData>  beans = bizDomManager.
            getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds("RGD1", BizDate.valueOf(20160701))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = beans.iterator();
            BT_DenpyoData bT_DenpyoData = null;
            while (iter.hasNext()) {

                bT_DenpyoData = iter.next();
                iCount++;

                Assert.assertEquals(C_DensysKbn.SKEI, bT_DenpyoData.getDensyskbn());
                Assert.assertEquals("1", bT_DenpyoData.getDenrenno());
                Assert.assertEquals(10, bT_DenpyoData.getEdano().intValue());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<BT_DenpyoData>  beans = bizDomManager.
            getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds("RGD1", BizDate.valueOf(20150701))){

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = beans.iterator();
            BT_DenpyoData denpyoData = null;
            while (iter.hasNext()) {

                denpyoData = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(18, denpyoData.getEdano().intValue());
                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(19, denpyoData.getEdano().intValue());
                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(20, denpyoData.getEdano().intValue());
                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                    Assert.assertEquals("2", denpyoData.getDenrenno());
                    Assert.assertEquals(20, denpyoData.getEdano().intValue());
                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                    Assert.assertEquals("3", denpyoData.getDenrenno());
                    Assert.assertEquals(20, denpyoData.getEdano().intValue());
                    continue;
                }

                if (6 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HOZEN, denpyoData.getDensyskbn());
                    Assert.assertEquals("3", denpyoData.getDenrenno());
                    Assert.assertEquals(20, denpyoData.getEdano().intValue());
                    continue;
                }

                if (7 == iCount) {

                    Assert.assertEquals(C_DensysKbn.HKSIHARAI, denpyoData.getDensyskbn());
                    Assert.assertEquals("3", denpyoData.getDenrenno());
                    Assert.assertEquals(20, denpyoData.getEdano().intValue());
                    continue;
                }

                if (8 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(30, denpyoData.getEdano().intValue());
                    continue;
                }
                if (9 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(34, denpyoData.getEdano().intValue());
                    continue;
                }
                if (10 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(35, denpyoData.getEdano().intValue());
                    continue;
                }
                if (11 == iCount) {

                    Assert.assertEquals(C_DensysKbn.NENKIN, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(36, denpyoData.getEdano().intValue());
                    continue;
                }
            }
            Assert.assertEquals(11, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(41)
    public void testSkippedFilter11() {

        try (ExDBResults<BT_DenpyoData>  beans = bizDomManager.
            getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds("RGD1", BizDate.valueOf(20150701))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = beans.iterator();
            BT_DenpyoData denpyoData = null;
            while (iter.hasNext()) {

                denpyoData = iter.next();
                iCount++;
            }

            Assert.assertEquals(11, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20(){

        try (ExDBResults<BT_DenpyoData>  beans = bizDomManager.
            getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds("RGD1", BizDate.valueOf(20150701))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = beans.iterator();
            BT_DenpyoData denpyoData = null;
            while (iter.hasNext()) {

                denpyoData = iter.next();
                assertNotEquals(denpyoData.getDensyskbn(), C_DensysKbn.HKSIHARAI);

                iCount++;
            }
            Assert.assertEquals(10, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3(){

        try (ExDBResults<BT_DenpyoData>  beans = bizDomManager.
            getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds("RGD1", BizDate.valueOf(20150701))) {

            int iCount = 0;
            Iterator<BT_DenpyoData> iter = beans.iterator();
            BT_DenpyoData denpyoData = null;
            while (iter.hasNext()) {

                denpyoData = iter.next();
                assertNotEquals(denpyoData.getDensyskbn(), C_DensysKbn.HKSIHARAI);
                assertNotEquals(denpyoData.getDensyskbn(), C_DensysKbn.HOZEN);

                iCount++;
            }
            Assert.assertEquals(9, iCount);
        }
    }

}

package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getIdCardWksSyoukaiUserByNotExistsUserWk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getIdCardWksSyoukaiUserByNotExistsUserWk {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getIdCardWksSyoukaiUserByNotExistsUserWk";

    private final static String sheetName = "INデータ";

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {


        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BW_IdCardWk> idCardWkLst =
            bizDomManager.getIdCardWksSyoukaiUserByNotExistsUserWk()) {

            Assert.assertFalse(idCardWkLst.iterator().hasNext());
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllUserWk());
        bizDomManager.delete(bizDomManager.getAllIdCardWk());
        bizDomManager.delete(bizDomManager.getAllUserIdKanrenWk());
        bizDomManager.delete(bizDomManager.getAllUserKengenHaneiSskInfo());
    }

    @Transactional
    public static void insertTestData(String testDataId) {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getIdCardWksSyoukaiUserByNotExistsUserWk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId(testDataId, testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<BW_IdCardWk> beans =
            bizDomManager.getIdCardWksSyoukaiUserByNotExistsUserWk()) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {


        insertTestData("データ001");
        try (ExDBResults<BW_IdCardWk> idCardWkLst =
            bizDomManager.getIdCardWksSyoukaiUserByNotExistsUserWk()) {

            int iCount = 0;
            Iterator<BW_IdCardWk> iter = idCardWkLst.iterator();
            BW_IdCardWk idCardWk = null;
            while (iter.hasNext()) {

                idCardWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("01", idCardWk.getIdkbn());
                    Assert.assertEquals("100001", idCardWk.getIdcd());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        deleteTestSubData();
        insertTestData("データ002");

        try (ExDBResults<BW_IdCardWk> idCardWkLst =
            bizDomManager.getIdCardWksSyoukaiUserByNotExistsUserWk()) {

            int iCount = 0;
            Iterator<BW_IdCardWk> iter = idCardWkLst.iterator();
            BW_IdCardWk idCardWk = null;
            while (iter.hasNext()) {

                idCardWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("01", idCardWk.getIdkbn());
                    Assert.assertEquals("100001", idCardWk.getIdcd());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("02", idCardWk.getIdkbn());
                    Assert.assertEquals("100002", idCardWk.getIdcd());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("02", idCardWk.getIdkbn());
                    Assert.assertEquals("100003", idCardWk.getIdcd());

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
        }
    }
}

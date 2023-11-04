package yuyu.def.biz.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUserWksNotExistsSyoukaiUserRoleWk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUserWksNotExistsSyoukaiUserRoleWk {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getUserWksNotExistsSyoukaiUserRoleWk";

    private final static String sheetName = "INデータ";

    private final static String[] hnsaSknmSsyRoruCdList1 = {"258"};
    private final static String[] hnsaSknmSsyRoruCdList2 = {"222","333","999"};
    private final static String[] hnsaSknmSsyRoruCdList3 = {"123","258"};
    private final static String[] hnsaSknmSsyRoruCdList4 = {""};

    @Inject
    BizDomManager bizDomManager;
    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSyoukaiUserRoleWk(hnsaSknmSsyRoruCdList1)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Transactional
    public static void insertSubData(String pDataCd) {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getUserWksNotExistsSyoukaiUserRoleWk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId(pDataCd, testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        insertSubData("データ001");

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSyoukaiUserRoleWk(hnsaSknmSsyRoruCdList2)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("111", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal2() {

        deleteTestData();
        insertSubData("データ002");
        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSyoukaiUserRoleWk(hnsaSknmSsyRoruCdList3)) {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("111", userWk.getUserId());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("222", userWk.getUserId());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("333", userWk.getUserId());

                    continue;
                }
                if (4 == iCount) {

                    Assert.assertEquals("444", userWk.getUserId());

                    continue;
                }
                if (5 == iCount) {

                    Assert.assertEquals("555", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(5, iCount);
        }
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void blankCondition() {

        deleteTestData();
        insertSubData("データ002");

        try (ExDBUpdatableResults<BW_UserWk> beans =
            bizDomManager.getUserWksNotExistsSyoukaiUserRoleWk(hnsaSknmSsyRoruCdList4))  {

            int iCount = 0;
            Iterator<BW_UserWk> iter = beans.iterator();
            BW_UserWk userWk = null;
            while (iter.hasNext()) {

                userWk = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("111", userWk.getUserId());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("222", userWk.getUserId());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("333", userWk.getUserId());

                    continue;
                }
                if (4 == iCount) {

                    Assert.assertEquals("444", userWk.getUserId());

                    continue;
                }
                if (5 == iCount) {

                    Assert.assertEquals("555", userWk.getUserId());

                    continue;
                }
            }
            Assert.assertEquals(5, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BW_UserWk> userWkList = bizDomManager.getAllUserWk();
        if(userWkList.size() > 0){
            bizDomManager.delete(userWkList);
        }

        List<BW_UserRoleWk> userRoleWkList = bizDomManager.getAllUserRoleWk();
        if(userRoleWkList.size() > 0){
            bizDomManager.delete(userRoleWkList);
        }

        List<BW_UserIdKanrenWk> userIdKanrenWkList = bizDomManager.getAllUserIdKanrenWk();
        if(userIdKanrenWkList.size() > 0){
            bizDomManager.delete(userIdKanrenWkList);
        }
        List<BW_IdCardWk> idCardWkList = bizDomManager.getAllIdCardWk();
        if(idCardWkList.size() > 0){
            bizDomManager.delete(idCardWkList);
        }
        List<BT_UserKengenHaneiSskInfo> userKengenHaneiSskInfoList = bizDomManager.getAllUserKengenHaneiSskInfo();
        if (userKengenHaneiSskInfoList.size() > 0) {
            bizDomManager.delete(userKengenHaneiSskInfoList);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}

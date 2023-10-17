package yuyu.def.suuri.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * SuuriDomManagerクラスの、<br />
 * getKiykSyuhnDatasBySyonoSyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getHoyuuMeisaiTyukeiyouItzHzns {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getHoyuuMeisaiTyukeiyouItzHzns";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> exDBResEntity = srCommonKinouDao
            .getHoyuuMeisaiTyukeiyouItzHzns("201806", "JCD01", "12")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getHoyuuMeisaiTyukeiyouItzHzns.class,
                fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst = suuriDomManager
            .getAllHoyuuMeisaiTyukeiyouItzHzn();
        if (hoyuuMeisaiTyukeiyouItzHznLst.size() > 0) {

            suuriDomManager.delete(hoyuuMeisaiTyukeiyouItzHznLst);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> exDBResEntity = srCommonKinouDao
            .getHoyuuMeisaiTyukeiyouItzHzns("201805", "JCD01", "12")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> exDBResEntity = srCommonKinouDao
            .getHoyuuMeisaiTyukeiyouItzHzns("201806", "JCD01", "12")) {

            int iCount = 0;
            Iterator<ST_HoyuuMeisaiTyukeiyouItzHzn> iter = exDBResEntity.iterator();
            ST_HoyuuMeisaiTyukeiyouItzHzn hoyuuMeisaiTyukeiyouItzHzn = null;
            while (iter.hasNext()) {

                hoyuuMeisaiTyukeiyouItzHzn = iter.next();
                iCount++;

                exStringEquals("201806", hoyuuMeisaiTyukeiyouItzHzn.getZtysrkijyunym(), "（中継用）数理用基準年月");
                exStringEquals("JCD01", hoyuuMeisaiTyukeiyouItzHzn.getZtysrkakutyoujobcd(), "（中継用）数理用拡張ジョブコード");
                exNumericEquals(100001, hoyuuMeisaiTyukeiyouItzHzn.getZtysequenceno(), "（中継用）シーケンス番号");
            }

            exNumericEquals(1, iCount, "取得件数");
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> risanomiTuujyuHitusyyugkMap = new HashMap<String, String>();
        risanomiTuujyuHitusyyugkMap.put($("201807", "JCD03", Integer.valueOf(100001)), "1");
        risanomiTuujyuHitusyyugkMap.put($("201807", "JCD03", Integer.valueOf(100002)), "1");
        risanomiTuujyuHitusyyugkMap.put($("201807", "JCD03", Integer.valueOf(100003)), "1");
        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> exDBResEntity = srCommonKinouDao
            .getHoyuuMeisaiTyukeiyouItzHzns("201807", "JCD03", "12", "13")) {

            int iCount = 0;
            Iterator<ST_HoyuuMeisaiTyukeiyouItzHzn> iter = exDBResEntity.iterator();
            ST_HoyuuMeisaiTyukeiyouItzHzn hoyuuMeisaiTyukeiyouItzHzn = null;
            while (iter.hasNext()) {

                hoyuuMeisaiTyukeiyouItzHzn = iter.next();
                iCount++;
                risanomiTuujyuHitusyyugkMap.remove($(hoyuuMeisaiTyukeiyouItzHzn.getZtysrkijyunym(),
                    hoyuuMeisaiTyukeiyouItzHzn.getZtysrkakutyoujobcd(),
                    hoyuuMeisaiTyukeiyouItzHzn.getZtysequenceno()));
            }

            Assert.assertEquals(3, iCount);
            assertTrue(risanomiTuujyuHitusyyugkMap.isEmpty());
        }
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> exDBResEntity = srCommonKinouDao
            .getHoyuuMeisaiTyukeiyouItzHzns("", "", "", "")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }
}

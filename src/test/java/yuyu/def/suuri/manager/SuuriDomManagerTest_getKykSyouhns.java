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
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getKykSyouhns() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKykSyouhns {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKykSyouhns";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        try (ExDBResults<IT_KykSyouhn> exDBResEntity = srCommonKinouDao
            .getKykSyouhns(C_SyutkKbn.SYU, "04")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = new IT_KykKihon("04", "11807111141");
        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "11807111233");
        hozenDomManager.insert(kykKihon1);
        hozenDomManager.insert(kykKihon2);

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getKykSyouhns.class,
                fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KykSyouhn").executeUpdate();
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
        //hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        // IT_KykKihon kykKihon = new IT_KykKihon();
        // kykKihon.setKbnkey("04");
        //kykKihon.setSyono("11807111141");

        //HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        //List<IT_KykSyouhn> kykSyouhnLst = hozenDomManager.
        //    getKykSyouhnsBySyonoKouryokuhasseiymd("11807111141", BizDate.valueOf(20170423));
        // if (kykSyouhnLst.size() > 0) {
        //    hozenDomManager.delete(kykSyouhnLst);
        //}
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<IT_KykSyouhn> exDBResEntity = srCommonKinouDao
            .getKykSyouhns(C_SyutkKbn.SYU, "01")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<IT_KykSyouhn> exDBResEntity = srCommonKinouDao
            .getKykSyouhns(C_SyutkKbn.SYU, "04")) {

            int iCount = 0;
            Iterator<IT_KykSyouhn> iter = exDBResEntity.iterator();
            IT_KykSyouhn kykSyouhn = null;
            while (iter.hasNext()) {

                kykSyouhn = iter.next();
                iCount++;

                exStringEquals("04", kykSyouhn.getKbnkey(), "区分キー");
                exStringEquals("11807111141", kykSyouhn.getSyono(), "証券番号");
                exClassificationEquals(C_SyutkKbn.SYU, kykSyouhn.getSyutkkbn(), "主契約特約区分");
                exStringEquals("ﾕｵ", kykSyouhn.getSyouhncd(), "商品コード");
                exBooleanEquals(kykSyouhn.getSyouhnsdno() == 1, true, "商品世代番号");
                exBooleanEquals(kykSyouhn.getKyksyouhnrenno() == 1, true, "契約商品連番");
            }

            exNumericEquals(1, iCount, "取得件数");
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> risanomiTuujyuHitusyyugkMap = new HashMap<String, String>();
        risanomiTuujyuHitusyyugkMap.put($("03", "11807111233", C_SyutkKbn.SYU, "ﾕｵ", Integer.valueOf(2), Integer.valueOf(2)), "1");
        risanomiTuujyuHitusyyugkMap.put($("03", "11807111233", C_SyutkKbn.SYU, "ﾕｵ", Integer.valueOf(3), Integer.valueOf(3)), "1");
        risanomiTuujyuHitusyyugkMap.put($("03", "11807111233", C_SyutkKbn.SYU, "ﾕｵ", Integer.valueOf(4), Integer.valueOf(4)), "1");
        risanomiTuujyuHitusyyugkMap.put($("04", "11807111141", C_SyutkKbn.SYU, "ﾕｵ", Integer.valueOf(1), Integer.valueOf(1)), "1");
        try (ExDBResults<IT_KykSyouhn> exDBResEntity = srCommonKinouDao
            .getKykSyouhns(C_SyutkKbn.SYU, "03")) {

            int iCount = 0;
            Iterator<IT_KykSyouhn> iter = exDBResEntity.iterator();
            IT_KykSyouhn kykSyouhn = null;
            while (iter.hasNext()) {

                kykSyouhn = iter.next();
                iCount++;
                risanomiTuujyuHitusyyugkMap.remove($(kykSyouhn.getKbnkey(),
                    kykSyouhn.getSyono(),
                    kykSyouhn.getSyutkkbn(),
                    kykSyouhn.getSyouhncd(),
                    kykSyouhn.getSyouhnsdno(),
                    kykSyouhn.getKyksyouhnrenno()));
            }

            Assert.assertEquals(4, iCount);
            assertTrue(risanomiTuujyuHitusyyugkMap.isEmpty());
        }
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        try (ExDBResults<IT_KykSyouhn> exDBResEntity = srCommonKinouDao
            .getKykSyouhns(C_SyutkKbn.SYU, "")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }
}

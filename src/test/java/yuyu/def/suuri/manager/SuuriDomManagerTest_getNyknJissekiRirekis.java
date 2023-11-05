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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * SuuriDomManagerクラスの、<br />
 * getNyknJissekiRirekis() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getNyknJissekiRirekis {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getNyknJissekiRirekis";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        try (ExDBResults<IT_NyknJissekiRireki> exDBResEntity = srCommonKinouDao
            .getNyknJissekiRirekis("60806000033", BizDate.valueOf(20170424))) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = new IT_KykKihon("03", "60806000033");
        IT_KykKihon kykKihon2 = new IT_KykKihon("04", "60806000044");
        IT_KykKihon kykKihon3 = new IT_KykKihon("02", "60806000022");
        hozenDomManager.insert(kykKihon1);
        hozenDomManager.insert(kykKihon2);
        hozenDomManager.insert(kykKihon3);
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getNyknJissekiRirekis.class,
                fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
        em.createJPQL("delete from IT_NyknJissekiRireki").executeUpdate();

        //List<IT_NyknJissekiRireki> nyknJissekiRireki = hozenDomManager
        //    .getNyknJissekiRirekisBySyonoMaxJyutoustartymNyktrksflg("60806000033", C_Nyktrksflg.BLNK);
        //if (nyknJissekiRireki.size() > 0) {

        //   hozenDomManager.delete(nyknJissekiRireki);
        //}
    }

    /**
     * 後処理
     * テストデータの削除
     */
    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<IT_NyknJissekiRireki> exDBResEntity = srCommonKinouDao
            .getNyknJissekiRirekis("60806000022", BizDate.valueOf(20170424))) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<IT_NyknJissekiRireki> exDBResEntity = srCommonKinouDao
            .getNyknJissekiRirekis("60806000033", BizDate.valueOf(20170424))) {

            int iCount = 0;
            Iterator<IT_NyknJissekiRireki> iter = exDBResEntity.iterator();
            IT_NyknJissekiRireki nyknJissekiRireki = null;
            while (iter.hasNext()) {

                nyknJissekiRireki = iter.next();
                iCount++;

                exStringEquals("03", nyknJissekiRireki.getKbnkey(), "区分キー");
                exStringEquals("60806000033", nyknJissekiRireki.getSyono(), "証券番号");
                exDateYMEquals(BizDateYM.valueOf(201704), nyknJissekiRireki.getJyutoustartym(), "充当開始年月");
                exBooleanEquals(nyknJissekiRireki.getRenno() == 1, true, "連番");
                exDateEquals(BizDate.valueOf(20170424), nyknJissekiRireki.getRyosyuymd(), "領収日");
                exDateEquals(BizDate.valueOf(20170424), nyknJissekiRireki.getNyktrksymd(), "入金取消処理日");
            }

            exNumericEquals(1, iCount, "取得件数");
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> risanomiTuujyuHitusyyugkMap = new HashMap<String, String>();
        risanomiTuujyuHitusyyugkMap.put($("04", "60806000044", BizDateYM.valueOf(201705), Integer.valueOf(4), BizDate.valueOf(20170424), BizDate.valueOf(20170423), "20170406161709096"), "1");
        risanomiTuujyuHitusyyugkMap.put($("04", "60806000044", BizDateYM.valueOf(201704), Integer.valueOf(2), BizDate.valueOf(20170423), BizDate.valueOf(20170424), "20170406161709097"), "1");
        risanomiTuujyuHitusyyugkMap.put($("04", "60806000044", BizDateYM.valueOf(201703), Integer.valueOf(3), BizDate.valueOf(20170425), BizDate.valueOf(20170425), "20170406161709098"), "1");
        try (ExDBResults<IT_NyknJissekiRireki> exDBResEntity = srCommonKinouDao
            .getNyknJissekiRirekis("60806000044", BizDate.valueOf(20170424))) {

            int iCount = 0;
            Iterator<IT_NyknJissekiRireki> iter = exDBResEntity.iterator();
            IT_NyknJissekiRireki nyknJissekiRireki = null;
            while (iter.hasNext()) {

                nyknJissekiRireki = iter.next();
                iCount++;
                risanomiTuujyuHitusyyugkMap.remove($(nyknJissekiRireki.getKbnkey(),
                    nyknJissekiRireki.getSyono(),
                    nyknJissekiRireki.getJyutoustartym(),
                    nyknJissekiRireki.getRenno(),
                    nyknJissekiRireki.getRyosyuymd(),
                    nyknJissekiRireki.getNyktrksymd(),
                    nyknJissekiRireki.getGyoumuKousinTime()));
            }

            Assert.assertEquals(3, iCount);
            assertTrue(risanomiTuujyuHitusyyugkMap.isEmpty());
        }
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        try (ExDBResults<IT_NyknJissekiRireki> exDBResEntity = srCommonKinouDao
            .getNyknJissekiRirekis("", BizDate.valueOf(20170424))) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }
}

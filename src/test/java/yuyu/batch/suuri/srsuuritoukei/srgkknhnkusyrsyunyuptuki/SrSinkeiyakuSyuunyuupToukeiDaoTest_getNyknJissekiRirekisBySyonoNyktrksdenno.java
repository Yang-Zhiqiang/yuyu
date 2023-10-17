package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki.SrGkknHnkuSyrSyunyupTukiDao;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrGkknHnkuSyrSyunyupTukiDaoクラスの、<br />
 * getNyknJissekiRirekisBySyonoNyktrksdenno メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuSyuunyuupToukeiDaoTest_getNyknJissekiRirekisBySyonoNyktrksdenno {

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getNyknJissekiRirekisBySyonoNyktrksdenno";

    private final static String sheetName = "INデータ";

    @Inject
    SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao = SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDao.class);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = srGkknHnkuSyrSyunyupTukiDao.
            getNyknJissekiRirekisBySyonoNyktrksdenno("60806000033", "101");

        exNumericEquals(0, nyknJissekiRireki.size(), "取得件数");

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = new IT_KykKihon("02", "60806000022");
        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "60806000033");
        IT_KykKihon kykKihon3 = new IT_KykKihon("04", "60806000044");
        hozenDomManager.insert(kykKihon1);
        hozenDomManager.insert(kykKihon2);
        hozenDomManager.insert(kykKihon3);
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSinkeiyakuSyuunyuupToukeiDaoTest_getNyknJissekiRirekisBySyonoNyktrksdenno.class, fileName,
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
        em.createJPQL("delete from IT_NyknJissekiRireki").executeUpdate();
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = srGkknHnkuSyrSyunyupTukiDao.
            getNyknJissekiRirekisBySyonoNyktrksdenno("60806000022", "101");

        Assert.assertEquals(0, nyknJissekiRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = srGkknHnkuSyrSyunyupTukiDao.
            getNyknJissekiRirekisBySyonoNyktrksdenno("60806000033", "101");

        exNumericEquals(1, nyknJissekiRirekiLst.size(), "取得件数");

        exStringEquals("03", nyknJissekiRirekiLst.get(0).getKbnkey(), "区分キー");
        exStringEquals("60806000033", nyknJissekiRirekiLst.get(0).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201704), nyknJissekiRirekiLst.get(0).getJyutoustartym(), "充当開始年月");
        exNumericEquals(Integer.valueOf(1), nyknJissekiRirekiLst.get(0).getRenno(), "連番");
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = srGkknHnkuSyrSyunyupTukiDao.
            getNyknJissekiRirekisBySyonoNyktrksdenno("60806000044", "101");

        exNumericEquals(3, nyknJissekiRirekiLst.size(), "取得件数");

        exStringEquals("04", nyknJissekiRirekiLst.get(0).getKbnkey(), "区分キー");
        exStringEquals("60806000044", nyknJissekiRirekiLst.get(0).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201703), nyknJissekiRirekiLst.get(0).getJyutoustartym(), "充当開始年月");
        exNumericEquals(Integer.valueOf(4), nyknJissekiRirekiLst.get(0).getRenno(), "連番");

        exStringEquals("04", nyknJissekiRirekiLst.get(1).getKbnkey(), "区分キー");
        exStringEquals("60806000044", nyknJissekiRirekiLst.get(1).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201704), nyknJissekiRirekiLst.get(1).getJyutoustartym(), "充当開始年月");
        exNumericEquals(Integer.valueOf(3), nyknJissekiRirekiLst.get(1).getRenno(), "連番");

        exStringEquals("04", nyknJissekiRirekiLst.get(2).getKbnkey(), "区分キー");
        exStringEquals("60806000044", nyknJissekiRirekiLst.get(2).getSyono(), "証券番号");
        exDateYMEquals(BizDateYM.valueOf(201705), nyknJissekiRirekiLst.get(2).getJyutoustartym(), "充当開始年月");
        exNumericEquals(Integer.valueOf(2), nyknJissekiRirekiLst.get(2).getRenno(), "連番");
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = srGkknHnkuSyrSyunyupTukiDao.
            getNyknJissekiRirekisBySyonoNyktrksdenno("", "");

        exNumericEquals(0, nyknJissekiRirekiLst.size(), "取得件数");

    }
}

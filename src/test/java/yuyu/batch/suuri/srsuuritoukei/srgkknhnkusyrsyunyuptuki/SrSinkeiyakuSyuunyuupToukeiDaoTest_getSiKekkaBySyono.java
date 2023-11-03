package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki.SrGkknHnkuSyrSyunyupTukiDao;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrGkknHnkuSyrSyunyupTukiDaoクラスの、<br />
 * getSiKekkaBySyono メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuSyuunyuupToukeiDaoTest_getSiKekkaBySyono {

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getSiKekkaBySyono";

    private final static String sheetName = "INデータ";

    @Inject
    SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao = SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDao.class);

        JT_SiKekka siKekka = srGkknHnkuSyrSyunyupTukiDao.
            getSiKekkaBySyono("60806000033");

        assertNull(siKekka);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon1 = new IT_KykKihon("02", "60806000022");
        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "60806000033");
        hozenDomManager.insert(kykKihon1);
        hozenDomManager.insert(kykKihon2);

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSinkeiyakuSyuunyuupToukeiDaoTest_getSiKekkaBySyono.class, fileName,
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
        em.createJPQL("delete from JT_SiKekka").executeUpdate();
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

        JT_SiKekka siKekka = srGkknHnkuSyrSyunyupTukiDao.getSiKekkaBySyono("60806000022");

        assertNull(siKekka);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SiKekka siKekka = srGkknHnkuSyrSyunyupTukiDao.getSiKekkaBySyono("60806000033");


        assertNotNull(siKekka);

        exClassificationEquals(C_ShiharaikekkadataKbn.SYOUMETU, siKekka.getShiharaikekkadatakbn(), "支払結果データ区分");
        exStringEquals("60806000033", siKekka.getSyono(), "証券番号");
        exStringEquals("ﾕｵ", siKekka.getSyouhncd(), "商品コード");
        exBooleanEquals(siKekka.getSyouhnsdno() == 1, true, "商品世代番号");
        exBooleanEquals(siKekka.getKyksyouhnrenno() == 2, true, "契約商品連番");
        exClassificationEquals(C_SyutkKbn.SYU, siKekka.getSyutkkbn(), "主契約特約区分");
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        JT_SiKekka siKekka = srGkknHnkuSyrSyunyupTukiDao.getSiKekkaBySyono("");
        assertNull(siKekka);

    }
}

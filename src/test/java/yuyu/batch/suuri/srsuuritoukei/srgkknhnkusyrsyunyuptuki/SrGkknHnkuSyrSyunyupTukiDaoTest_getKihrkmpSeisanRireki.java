package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki.SrGkknHnkuSyrSyunyupTukiDao;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrGkknHnkuSyrSyunyupTukiDaoクラスの、<br />
 * getKihrkmpSeisanRirekiBySyonoHenkousikibetukey メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrGkknHnkuSyrSyunyupTukiDaoTest_getKihrkmpSeisanRireki {

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getKihrkmpSeisanRireki";

    private final static String sheetName = "INデータ";

    @Inject
    SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao = SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDao.class);

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = srGkknHnkuSyrSyunyupTukiDao.
            getKihrkmpSeisanRireki("60806000033", "1001", C_KiharaiPseisanNaiyouKbn.HENKANKIN);

        assertNull(kihrkmpSeisanRireki);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrGkknHnkuSyrSyunyupTukiDaoTest_getKihrkmpSeisanRireki.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = srGkknHnkuSyrSyunyupTukiDao.
            getKihrkmpSeisanRireki("60806000022", "1001", C_KiharaiPseisanNaiyouKbn.HENKANKIN);

        assertNull(kihrkmpSeisanRireki);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = srGkknHnkuSyrSyunyupTukiDao.
            getKihrkmpSeisanRireki("60806000033", "1001", C_KiharaiPseisanNaiyouKbn.HENKANKIN);


        assertNotNull(kihrkmpSeisanRireki);

        exStringEquals("03", kihrkmpSeisanRireki.getKbnkey(), "区分キー");
        exStringEquals("60806000033", kihrkmpSeisanRireki.getSyono(), "証券番号");
        exNumericEquals(1, kihrkmpSeisanRireki.getRenno(), "連番");
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = srGkknHnkuSyrSyunyupTukiDao.
            getKihrkmpSeisanRireki("", "1001", C_KiharaiPseisanNaiyouKbn.HENKANKIN);
        assertNull(kihrkmpSeisanRireki);

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = srGkknHnkuSyrSyunyupTukiDao.
            getKihrkmpSeisanRireki("60806000033", "", C_KiharaiPseisanNaiyouKbn.HENKANKIN);
        assertNull(kihrkmpSeisanRireki);

    }
}

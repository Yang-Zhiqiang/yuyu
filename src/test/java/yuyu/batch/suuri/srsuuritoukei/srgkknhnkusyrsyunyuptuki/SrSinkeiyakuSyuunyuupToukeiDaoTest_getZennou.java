package yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.batch.suuri.srsuuritoukei.srgkknhnkusyrsyunyuptuki.SrGkknHnkuSyrSyunyupTukiDao;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrGkknHnkuSyrSyunyupTukiDaoクラスの、<br />
 * getZennou メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuSyuunyuupToukeiDaoTest_getZennou {

    private final static String fileName = "UT-SP_単体テスト仕様書（Dao）_getZennou";

    private final static String sheetName = "INデータ";

    @Inject
    SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrGkknHnkuSyrSyunyupTukiDao srGkknHnkuSyrSyunyupTukiDao = SWAKInjector.getInstance(SrGkknHnkuSyrSyunyupTukiDao.class);

        IT_Zennou zennou = srGkknHnkuSyrSyunyupTukiDao.
            getZennou("60806000033", BizDate.valueOf(20160101), 1);

        assertNull(zennou);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SrSinkeiyakuSyuunyuupToukeiDaoTest_getZennou.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_Zennou zennou = srGkknHnkuSyrSyunyupTukiDao.
            getZennou("60806000022", BizDate.valueOf(20160101), 1);

        assertNull(zennou);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_Zennou zennou = srGkknHnkuSyrSyunyupTukiDao.
            getZennou("60806000033", BizDate.valueOf(20160101), 1);


        assertNotNull(zennou);

        exStringEquals("03", zennou.getKbnkey(), "区分キー");
        exStringEquals("60806000033", zennou.getSyono(), "証券番号");
        exDateEquals(BizDate.valueOf(20160101), zennou.getZennoukaisiymd(), "前納開始年月日");
        exNumericEquals(1, zennou.getRenno(), "連番");
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        IT_Zennou zennou = srGkknHnkuSyrSyunyupTukiDao.
            getZennou("", BizDate.valueOf(20160101), 1);

        assertNull(zennou);

    }
}

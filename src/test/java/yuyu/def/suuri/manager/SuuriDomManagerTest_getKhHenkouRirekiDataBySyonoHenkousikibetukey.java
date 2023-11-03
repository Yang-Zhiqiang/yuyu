package yuyu.def.suuri.manager;

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
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getKhHenkouRirekiDataBySyonoHenkousikibetukey メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKhHenkouRirekiDataBySyonoHenkousikibetukey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhHenkouRirekiDataBySyonoHenkousikibetukey";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setKbnkey("01");
        kykKihon.setSyono("11807111118");
        hozenDomManager.insert(kykKihon);

        IT_KhHenkouRireki khHenkouRireki = srCommonKinouDao.getKhHenkouRirekiDataBySyonoHenkousikibetukey("11807111118", "1001", "10001", C_HnkSyuruiKbn.TUIKA);

        assertNull(khHenkouRireki);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getKhHenkouRirekiDataBySyonoHenkousikibetukey.class, fileName,
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

        IT_KhHenkouRireki khHenkouRireki = srCommonKinouDao.
            getKhHenkouRirekiDataBySyonoHenkousikibetukey("11807111118", "1001", "10001", C_HnkSyuruiKbn.BLNK);

        assertNull(khHenkouRireki);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KhHenkouRireki khHenkouRireki = srCommonKinouDao.
            getKhHenkouRirekiDataBySyonoHenkousikibetukey("11807111118", "1001", "10001", C_HnkSyuruiKbn.TUIKA);

        assertNotNull(khHenkouRireki);

        exStringEquals(khHenkouRireki.getKbnkey(), "01", "区分キー");
        exStringEquals(khHenkouRireki.getSyono(), "11807111118", "証券番号");
        exStringEquals(khHenkouRireki.getHenkousikibetukey(), "1001", "変更識別キー");
        exNumericEquals(khHenkouRireki.getRenno3keta(), Integer.valueOf(101), "連番（３桁）");
        exStringEquals(khHenkouRireki.getTableid(), "10001", "テーブルＩＤ");
        exClassificationEquals(khHenkouRireki.getHnksyuruikbn(), C_HnkSyuruiKbn.TUIKA, "変更種類区分");
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        IT_KhHenkouRireki khHenkouRireki = srCommonKinouDao.
            getKhHenkouRirekiDataBySyonoHenkousikibetukey("11807111118", "", "10001", C_HnkSyuruiKbn.TUIKA);

        assertNull(khHenkouRireki);
    }

    @Test
    @TestOrder(40)
    public void blankCondition2() {

        IT_KhHenkouRireki khHenkouRireki = srCommonKinouDao.
            getKhHenkouRirekiDataBySyonoHenkousikibetukey("11807111118", "1001", "", C_HnkSyuruiKbn.TUIKA);

        assertNull(khHenkouRireki);
    }

    @Test
    @TestOrder(50)
    public void tableNull() {

        IT_KhHenkouRireki khHenkouRireki = srCommonKinouDao.
            getKhHenkouRirekiDataBySyonoHenkousikibetukey("11807111118", "1002", "10001", C_HnkSyuruiKbn.TUIKA);

        assertNull(khHenkouRireki);
    }
}

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
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getKhTtdkRirekiDatasBySyonoHenkousikibetukey メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKhTtdkRirekiDatasBySyonoHenkousikibetukey {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKhTtdkRirekiDatasBySyonoHenkousikibetukey";

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
        kykKihon.setKbnkey("03");
        kykKihon.setSyono("11807111130");
        hozenDomManager.insert(kykKihon);

        List<IT_KhTtdkRireki> khTtdkRirekiLst = srCommonKinouDao.getKhTtdkRirekiDatasBySyonoHenkousikibetukey(
            "11807111130", "000000000000000002");

        assertEquals(0, khTtdkRirekiLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                SuuriDomManagerTest_getKhTtdkRirekiDatasBySyonoHenkousikibetukey.class, fileName, sheetName);
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

        List<IT_KhTtdkRireki> khTtdkRirekiLst = srCommonKinouDao.getKhTtdkRirekiDatasBySyonoHenkousikibetukey(
            "11807111130", "000000000000000030");

        Assert.assertEquals(0, khTtdkRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhTtdkRireki> khTtdkRirekiLst = srCommonKinouDao.getKhTtdkRirekiDatasBySyonoHenkousikibetukey("11807111130", "000000000000000002");

        Assert.assertEquals(1, khTtdkRirekiLst.size());

        exStringEquals("03", khTtdkRirekiLst.get(0).getKbnkey(), "区分キー");
        exStringEquals("11807111130", khTtdkRirekiLst.get(0).getSyono(), "証券番号");
        exStringEquals("000000000000000002", khTtdkRirekiLst.get(0).getHenkousikibetukey(), "変更識別キー");
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<IT_KhTtdkRireki> khTtdkRirekiLst = srCommonKinouDao.getKhTtdkRirekiDatasBySyonoHenkousikibetukey(
            "11807111152", "000000000000000002");

        assertEquals(3, khTtdkRirekiLst.size());

        exStringEquals("05", khTtdkRirekiLst.get(0).getKbnkey(), "区分キー");
        exStringEquals("11807111152", khTtdkRirekiLst.get(0).getSyono(), "証券番号");
        exStringEquals("000000000000000005", khTtdkRirekiLst.get(0).getHenkousikibetukey(), "変更識別キー");

        exStringEquals("05", khTtdkRirekiLst.get(1).getKbnkey(), "区分キー");
        exStringEquals("11807111152", khTtdkRirekiLst.get(1).getSyono(), "証券番号");
        exStringEquals("000000000000000004", khTtdkRirekiLst.get(1).getHenkousikibetukey(), "変更識別キー");

        exStringEquals("05", khTtdkRirekiLst.get(2).getKbnkey(), "区分キー");
        exStringEquals("11807111152", khTtdkRirekiLst.get(2).getSyono(), "証券番号");
        exStringEquals("000000000000000003", khTtdkRirekiLst.get(2).getHenkousikibetukey(), "変更識別キー");
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhTtdkRireki> khTtdkRirekiLst = srCommonKinouDao.getKhTtdkRirekiDatasBySyonoHenkousikibetukey(
            "11807111130", "");

        assertEquals(2, khTtdkRirekiLst.size());

        exStringEquals("03", khTtdkRirekiLst.get(0).getKbnkey(), "区分キー");
        exStringEquals("11807111130", khTtdkRirekiLst.get(0).getSyono(), "証券番号");
        exStringEquals("000000000000000002", khTtdkRirekiLst.get(0).getHenkousikibetukey(), "変更識別キー");

        exStringEquals("03", khTtdkRirekiLst.get(1).getKbnkey(), "区分キー");
        exStringEquals("11807111130", khTtdkRirekiLst.get(1).getSyono(), "証券番号");
        exStringEquals("000000000000000001", khTtdkRirekiLst.get(1).getHenkousikibetukey(), "変更識別キー");
    }
}

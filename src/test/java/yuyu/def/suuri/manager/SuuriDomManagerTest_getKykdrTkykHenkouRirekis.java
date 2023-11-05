package yuyu.def.suuri.manager;

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
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理統計共通機能DAOクラスのメソッド {@link SrCommonKinouDao#getKykdrTkykHenkouRirekis}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKykdrTkykHenkouRirekis {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getKykdrTkykHenkouRirekis";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        List<IT_KhHenkouRireki> iT_KhHenkouRirekiLst =
            srCommonKinouDao.getKykdrTkykHenkouRirekis("11807111129");

        assertEquals(0, iT_KhHenkouRirekiLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                SuuriDomManagerTest_getKykdrTkykHenkouRirekis.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KhHenkouRireki").executeUpdate();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhHenkouRireki> iT_KhHenkouRirekiLst =
            srCommonKinouDao.getKykdrTkykHenkouRirekis("11807111118");

        assertEquals(0, iT_KhHenkouRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhHenkouRireki> iT_KhHenkouRirekiLst =
            srCommonKinouDao.getKykdrTkykHenkouRirekis("11807111129");

        assertEquals(1, iT_KhHenkouRirekiLst.size());

        exStringEquals("02", iT_KhHenkouRirekiLst.get(0).getKbnkey(), "区分キー");
        exStringEquals("11807111129", iT_KhHenkouRirekiLst.get(0).getSyono(), "証券番号");
        exStringEquals("000000000000000110", iT_KhHenkouRirekiLst.get(0).getHenkousikibetukey(), "変更識別キー");
        exNumericEquals(Integer.valueOf(1), iT_KhHenkouRirekiLst.get(0).getRenno3keta(), "連番（３桁）");

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhHenkouRireki> iT_KhHenkouRirekiLst =
            srCommonKinouDao.getKykdrTkykHenkouRirekis("11807111130");

        assertEquals(5, iT_KhHenkouRirekiLst.size());

        exStringEquals("03", iT_KhHenkouRirekiLst.get(0).getKbnkey(), "区分キー");
        exStringEquals("11807111130", iT_KhHenkouRirekiLst.get(0).getSyono(), "証券番号");
        exStringEquals("000000000000000110", iT_KhHenkouRirekiLst.get(0).getHenkousikibetukey(), "変更識別キー");
        exNumericEquals(Integer.valueOf(10), iT_KhHenkouRirekiLst.get(0).getRenno3keta(), "連番（３桁）");

        exStringEquals("03", iT_KhHenkouRirekiLst.get(1).getKbnkey(), "区分キー");
        exStringEquals("11807111130", iT_KhHenkouRirekiLst.get(1).getSyono(), "証券番号");
        exStringEquals("000000000000000090", iT_KhHenkouRirekiLst.get(1).getHenkousikibetukey(), "変更識別キー");
        exNumericEquals(Integer.valueOf(9), iT_KhHenkouRirekiLst.get(1).getRenno3keta(), "連番（３桁）");

        exStringEquals("03", iT_KhHenkouRirekiLst.get(2).getKbnkey(), "区分キー");
        exStringEquals("11807111130", iT_KhHenkouRirekiLst.get(2).getSyono(), "証券番号");
        exStringEquals("000000000000000050", iT_KhHenkouRirekiLst.get(2).getHenkousikibetukey(), "変更識別キー");
        exNumericEquals(Integer.valueOf(7), iT_KhHenkouRirekiLst.get(2).getRenno3keta(), "連番（３桁）");

        exStringEquals("03", iT_KhHenkouRirekiLst.get(3).getKbnkey(), "区分キー");
        exStringEquals("11807111130", iT_KhHenkouRirekiLst.get(3).getSyono(), "証券番号");
        exStringEquals("000000000000000030", iT_KhHenkouRirekiLst.get(3).getHenkousikibetukey(), "変更識別キー");
        exNumericEquals(Integer.valueOf(8), iT_KhHenkouRirekiLst.get(3).getRenno3keta(), "連番（３桁）");

        exStringEquals("03", iT_KhHenkouRirekiLst.get(4).getKbnkey(), "区分キー");
        exStringEquals("11807111130", iT_KhHenkouRirekiLst.get(4).getSyono(), "証券番号");
        exStringEquals("000000000000000010", iT_KhHenkouRirekiLst.get(4).getHenkousikibetukey(), "変更識別キー");
        exNumericEquals(Integer.valueOf(6), iT_KhHenkouRirekiLst.get(4).getRenno3keta(), "連番（３桁）");
    }

    @Test
    @TestOrder(40)
    public void blank1Condition() {

        List<IT_KhHenkouRireki> iT_KhHenkouRirekiLst =
            srCommonKinouDao.getKykdrTkykHenkouRirekis("");

        assertEquals(0, iT_KhHenkouRirekiLst.size());
    }
}

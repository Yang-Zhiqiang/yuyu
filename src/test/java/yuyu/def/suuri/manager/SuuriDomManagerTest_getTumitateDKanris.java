package yuyu.def.suuri.manager;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getTumitateDKanris メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getTumitateDKanris {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getTumitateDKanris";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        List<IT_KhTumitateDKanri> khTumitateDKanriList = srCommonKinouDao.getTumitateDKanris(
            "17806000024", BizDate.valueOf(20190909));

        assertEquals(0, khTumitateDKanriList.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getTumitateDKanris.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KhTumitateDKanri").executeUpdate();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhTumitateDKanri> khTumitateDKanriList = srCommonKinouDao.getTumitateDKanris(
            "17806000013", BizDate.valueOf(20190909));

        assertEquals(0, khTumitateDKanriList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhTumitateDKanri> khTumitateDKanriList = srCommonKinouDao.getTumitateDKanris(
            "17806000024", BizDate.valueOf(20190909));

        assertEquals(1, khTumitateDKanriList.size());

        exStringEquals("02", khTumitateDKanriList.get(0).getKbnkey(), "区分キー");
        exStringEquals("17806000024", khTumitateDKanriList.get(0).getSyono(), "証券番号");
        exDateEquals(
            BizDate.valueOf(20190909), khTumitateDKanriList.get(0).getTumitatedtumitateymd(), "積立Ｄ積立年月日");
        exNumericEquals(3, khTumitateDKanriList.get(0).getRenno(), "連番");
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhTumitateDKanri> khTumitateDKanriList = srCommonKinouDao.getTumitateDKanris(
            "17806000035", BizDate.valueOf(20191010));

        assertEquals(5, khTumitateDKanriList.size());

        exStringEquals("03", khTumitateDKanriList.get(0).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khTumitateDKanriList.get(0).getSyono(), "証券番号");
        exDateEquals(BizDate.valueOf(20190910), khTumitateDKanriList.get(0).getTumitatedtumitateymd(), "積立Ｄ積立年月日");
        exNumericEquals(3, khTumitateDKanriList.get(0).getRenno(), "連番");

        exStringEquals("03", khTumitateDKanriList.get(1).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khTumitateDKanriList.get(1).getSyono(), "証券番号");
        exDateEquals(BizDate.valueOf(20190910), khTumitateDKanriList.get(1).getTumitatedtumitateymd(), "積立Ｄ積立年月日");
        exNumericEquals(2, khTumitateDKanriList.get(1).getRenno(), "連番");

        exStringEquals("03", khTumitateDKanriList.get(2).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khTumitateDKanriList.get(2).getSyono(), "証券番号");
        exDateEquals(BizDate.valueOf(20190910), khTumitateDKanriList.get(2).getTumitatedtumitateymd(), "積立Ｄ積立年月日");
        exNumericEquals(1, khTumitateDKanriList.get(2).getRenno(), "連番");

        exStringEquals("03", khTumitateDKanriList.get(3).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khTumitateDKanriList.get(3).getSyono(), "証券番号");
        exDateEquals(BizDate.valueOf(20190909), khTumitateDKanriList.get(3).getTumitatedtumitateymd(), "積立Ｄ積立年月日");
        exNumericEquals(5, khTumitateDKanriList.get(3).getRenno(), "連番");

        exStringEquals("03", khTumitateDKanriList.get(4).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khTumitateDKanriList.get(4).getSyono(), "証券番号");
        exDateEquals(BizDate.valueOf(20190908), khTumitateDKanriList.get(4).getTumitatedtumitateymd(), "積立Ｄ積立年月日");
        exNumericEquals(4, khTumitateDKanriList.get(4).getRenno(), "連番");
    }

    @Test
    @TestOrder(40)
    public void blank1Condition() {

        List<IT_KhTumitateDKanri> khTumitateDKanriList = srCommonKinouDao.getTumitateDKanris(
            "", BizDate.valueOf(20190909));

        assertEquals(0, khTumitateDKanriList.size());
    }

    @Test
    @TestOrder(50)
    public void blank2Condition() {

        List<IT_KhTumitateDKanri> khTumitateDKanriList = srCommonKinouDao.getTumitateDKanris(
            "17806000035", null);

        assertEquals(0, khTumitateDKanriList.size());
    }
}

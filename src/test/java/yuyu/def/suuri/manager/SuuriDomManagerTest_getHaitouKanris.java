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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrCommonKinouDaoクラスの、<br />
 * getHaitouKanris メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getHaitouKanris {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getHaitouKanris";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        List<IT_KhHaitouKanri> khHaitouKanriList = srCommonKinouDao.getHaitouKanris(
            "17806000024", C_HaitoumeisaiKbn.SYU, BizDate.valueOf(20190909));

        assertEquals(0, khHaitouKanriList.size());

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
        em.createJPQL("delete from IT_KhHaitouKanri").executeUpdate();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhHaitouKanri> khHaitouKanriList = srCommonKinouDao.getHaitouKanris(
            "17806000013", C_HaitoumeisaiKbn.SYU, BizDate.valueOf(20190909));

        assertEquals(0, khHaitouKanriList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhHaitouKanri> khHaitouKanriList = srCommonKinouDao.getHaitouKanris(
            "17806000024", C_HaitoumeisaiKbn.SYU, BizDate.valueOf(20190909));

        assertEquals(1, khHaitouKanriList.size());

        exStringEquals("02", khHaitouKanriList.get(0).getKbnkey(), "区分キー");
        exStringEquals("17806000024", khHaitouKanriList.get(0).getSyono(), "証券番号");
        exDateYEquals(BizDateY.valueOf(2019), khHaitouKanriList.get(0).getHaitounendo(), "配当年度");
        exNumericEquals(4, khHaitouKanriList.get(0).getRenno(), "連番");
        exClassificationEquals(
            C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriList.get(0).getHaitoukinskskbn(), "配当金作成区分");
        exClassificationEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriList.get(0).getHaitoumeisaikbn(), "配当明細区分");
        exDateEquals(
            BizDate.valueOf(20190909), khHaitouKanriList.get(0).getKariwariatedshrymd(), "仮割当Ｄ支払年月日");

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<IT_KhHaitouKanri> khHaitouKanriList = srCommonKinouDao.getHaitouKanris(
            "17806000035", C_HaitoumeisaiKbn.SYU, BizDate.valueOf(20191010));

        assertEquals(5, khHaitouKanriList.size());

        exStringEquals("03", khHaitouKanriList.get(0).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khHaitouKanriList.get(0).getSyono(), "証券番号");
        exDateYEquals(BizDateY.valueOf(2019), khHaitouKanriList.get(0).getHaitounendo(), "配当年度");
        exNumericEquals(3, khHaitouKanriList.get(0).getRenno(), "連番");
        exClassificationEquals(
            C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriList.get(0).getHaitoukinskskbn(), "配当金作成区分");
        exClassificationEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriList.get(0).getHaitoumeisaikbn(), "配当明細区分");
        exDateEquals(
            BizDate.valueOf(20190910), khHaitouKanriList.get(0).getKariwariatedshrymd(), "仮割当Ｄ支払年月日");

        exStringEquals("03", khHaitouKanriList.get(1).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khHaitouKanriList.get(1).getSyono(), "証券番号");
        exDateYEquals(BizDateY.valueOf(2019), khHaitouKanriList.get(1).getHaitounendo(), "配当年度");
        exNumericEquals(2, khHaitouKanriList.get(1).getRenno(), "連番");
        exClassificationEquals(
            C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriList.get(1).getHaitoukinskskbn(), "配当金作成区分");
        exClassificationEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriList.get(1).getHaitoumeisaikbn(), "配当明細区分");
        exDateEquals(
            BizDate.valueOf(20190910), khHaitouKanriList.get(1).getKariwariatedshrymd(), "仮割当Ｄ支払年月日");

        exStringEquals("03", khHaitouKanriList.get(2).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khHaitouKanriList.get(2).getSyono(), "証券番号");
        exDateYEquals(BizDateY.valueOf(2019), khHaitouKanriList.get(2).getHaitounendo(), "配当年度");
        exNumericEquals(1, khHaitouKanriList.get(2).getRenno(), "連番");
        exClassificationEquals(
            C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriList.get(2).getHaitoukinskskbn(), "配当金作成区分");
        exClassificationEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriList.get(2).getHaitoumeisaikbn(), "配当明細区分");
        exDateEquals(
            BizDate.valueOf(20190910), khHaitouKanriList.get(2).getKariwariatedshrymd(), "仮割当Ｄ支払年月日");

        exStringEquals("03", khHaitouKanriList.get(3).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khHaitouKanriList.get(3).getSyono(), "証券番号");
        exDateYEquals(BizDateY.valueOf(2019), khHaitouKanriList.get(3).getHaitounendo(), "配当年度");
        exNumericEquals(6, khHaitouKanriList.get(3).getRenno(), "連番");
        exClassificationEquals(
            C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriList.get(3).getHaitoukinskskbn(), "配当金作成区分");
        exClassificationEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriList.get(3).getHaitoumeisaikbn(), "配当明細区分");
        exDateEquals(
            BizDate.valueOf(20190909), khHaitouKanriList.get(3).getKariwariatedshrymd(), "仮割当Ｄ支払年月日");

        exStringEquals("03", khHaitouKanriList.get(4).getKbnkey(), "区分キー");
        exStringEquals("17806000035", khHaitouKanriList.get(4).getSyono(), "証券番号");
        exDateYEquals(BizDateY.valueOf(2019), khHaitouKanriList.get(4).getHaitounendo(), "配当年度");
        exNumericEquals(5, khHaitouKanriList.get(4).getRenno(), "連番");
        exClassificationEquals(
            C_HaitoukinsksKbn.KARIWARIATE1, khHaitouKanriList.get(4).getHaitoukinskskbn(), "配当金作成区分");
        exClassificationEquals(C_HaitoumeisaiKbn.SYU, khHaitouKanriList.get(4).getHaitoumeisaikbn(), "配当明細区分");
        exDateEquals(
            BizDate.valueOf(20190908), khHaitouKanriList.get(4).getKariwariatedshrymd(), "仮割当Ｄ支払年月日");
    }

    @Test
    @TestOrder(40)
    public void blank1Condition() {

        List<IT_KhHaitouKanri> khHaitouKanriList = srCommonKinouDao.getHaitouKanris(
            "", C_HaitoumeisaiKbn.SYU, BizDate.valueOf(20190909));

        assertEquals(0, khHaitouKanriList.size());
    }

    @Test
    @TestOrder(50)
    public void blank2Condition() {

        List<IT_KhHaitouKanri> khHaitouKanriList = srCommonKinouDao.getHaitouKanris(
            "17806000035", null, BizDate.valueOf(20190909));

        assertEquals(0, khHaitouKanriList.size());
    }

    @Test
    @TestOrder(60)
    public void blank3Condition() {

        List<IT_KhHaitouKanri> khHaitouKanriList = srCommonKinouDao.getHaitouKanris(
            "17806000035", C_HaitoumeisaiKbn.SYU, null);

        assertEquals(0, khHaitouKanriList.size());
    }
}

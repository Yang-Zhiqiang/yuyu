package yuyu.def.suuri.manager;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * SuuriDomManagerクラスの、<br />
 * getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn";

    private final static String sheetName = "INデータ";

    @Inject
    SrCommonKinouDao srCommonKinouDao;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SrCommonKinouDao srCommonKinouDao = SWAKInjector.getInstance(SrCommonKinouDao.class);

        List<BT_DenpyoData> denpyoDataLst = srCommonKinouDao.
            getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn.HOZEN, "200000000000000001", C_DensyoriKbn.FP_KZHKSR);

        exNumericEquals(0, denpyoDataLst.size(), "取得件数");

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SuuriDomManagerTest_getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn.class,
                fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_DenpyoData").executeUpdate();
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_DenpyoData> denpyoDataLst = srCommonKinouDao.
            getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn.HOZEN, "100000000000000001", C_DensyoriKbn.FP_KZHKSR);

        Assert.assertEquals(0, denpyoDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_DenpyoData> denpyoDataLst = srCommonKinouDao.
            getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn.HOZEN, "200000000000000001", C_DensyoriKbn.FP_KZHKSR);

        exNumericEquals(1, denpyoDataLst.size(), "取得件数");

        exClassificationEquals(C_DensysKbn.HOZEN, denpyoDataLst.get(0).getDensyskbn(), "伝票用システム区分");
        exStringEquals("20000000000000000002", denpyoDataLst.get(0).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(0).getEdano() == 4, true, "枝番号");
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_DenpyoData> denpyoDataLst = srCommonKinouDao.
            getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn.HKSIHARAI, "100000000000000001", C_DensyoriKbn.FP_KZHKSR);

        exNumericEquals(12, denpyoDataLst.size(), "取得件数");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(0).getDensyskbn(), "伝票用システム区分");
        exStringEquals("50000000000000000002", denpyoDataLst.get(0).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(0).getEdano() == 3, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(1).getDensyskbn(), "伝票用システム区分");
        exStringEquals("60000000000000000002", denpyoDataLst.get(1).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(1).getEdano() == 3, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(2).getDensyskbn(), "伝票用システム区分");
        exStringEquals("70000000000000000002", denpyoDataLst.get(2).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(2).getEdano() == 1, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(3).getDensyskbn(), "伝票用システム区分");
        exStringEquals("70000000000000000002", denpyoDataLst.get(3).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(3).getEdano() == 2, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(4).getDensyskbn(), "伝票用システム区分");
        exStringEquals("80000000000000000002", denpyoDataLst.get(4).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(4).getEdano() == 1, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(5).getDensyskbn(), "伝票用システム区分");
        exStringEquals("90000000000000000002", denpyoDataLst.get(5).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(5).getEdano() == 4, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(6).getDensyskbn(), "伝票用システム区分");
        exStringEquals("90000000000000000002", denpyoDataLst.get(6).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(6).getEdano() == 5, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(7).getDensyskbn(), "伝票用システム区分");
        exStringEquals("90000000000000000002", denpyoDataLst.get(7).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(7).getEdano() == 6, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(8).getDensyskbn(), "伝票用システム区分");
        exStringEquals("90000000000000000002", denpyoDataLst.get(8).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(8).getEdano() == 7, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(9).getDensyskbn(), "伝票用システム区分");
        exStringEquals("90000000000000000002", denpyoDataLst.get(9).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(9).getEdano() == 8, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(10).getDensyskbn(), "伝票用システム区分");
        exStringEquals("90000000000000000002", denpyoDataLst.get(10).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(10).getEdano() == 9, true, "枝番号");

        exClassificationEquals(C_DensysKbn.HKSIHARAI, denpyoDataLst.get(11).getDensyskbn(), "伝票用システム区分");
        exStringEquals("90000000000000000002", denpyoDataLst.get(11).getDenrenno(), "伝票データ連番");
        exBooleanEquals(denpyoDataLst.get(11).getEdano() == 10, true, "枝番号");
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BT_DenpyoData> denpyoDataLst = srCommonKinouDao.
            getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn.HKSIHARAI, "", C_DensyoriKbn.FP_KZHKSR);

        Assert.assertEquals(0, denpyoDataLst.size());

    }
}

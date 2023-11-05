package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.dba4KeisanTienrisoku.KeisanTienrisokuDao;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Tienrskhasuusyori;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 遅延利息計算クラスのメソッド {@link KeisanTienrisoku#exec(BizDate,BizDate,BizDate,BizCurrency,Integer,C_SinsaGendoKknKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTienrisokuTest_exec {

    @Inject
    private KeisanTienrisokuDao keisanTienrisokuDao;

    @Inject
    private KeisanTienrisoku keisanTienrisoku;

    private static C_Tienrskhasuusyori tienRskHasuusyori;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_遅延利息計算";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    public static void testInit() {
        tienRskHasuusyori = YuyuBizConfig.getInstance().getTienRskHasuusyori();
    }

    @AfterClass
    public static void testClear() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(tienRskHasuusyori);
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanTienrisokuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector
            .getInstance(ExDBEntityManager.class);

        String jpql = "delete from " + "BM_TienrisokuRiritu";
        em.createJPQL(jpql).executeUpdate();

        testDataAndTblMap = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            BizDate.valueOf("20160302"),
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(489), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160310"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 298, "遅延日数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160302"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(489), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160310"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 298, "遅延日数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BD5
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(491), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160309"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 299, "遅延日数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            null,
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BD5
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(491), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160309"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 299, "遅延日数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            null,
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D45
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(401), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160503"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 244, "遅延日数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            null,
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(182), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160913"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 111, "遅延日数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            BizDate.valueOf("20160302"),
            BizDate.valueOf("20170502"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D45
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(600), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160503"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170502"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 365, "遅延日数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDUP);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20200212"),
            BizDate.valueOf("20200212"),
            BizDate.valueOf("20210218"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(-173), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(600), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20200220"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20210218"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 365, "遅延日数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUND);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160229"),
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(-190), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(493), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160308"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 300, "遅延日数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUND);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160229"),
            BizDate.valueOf("20170101"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D45
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(401), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160503"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20170101"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 244, "遅延日数");
    }


    @Test
    @TestOrder(110)
    public void testExec_A11() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            BizDate.valueOf("20160302"),
            BizDate.valueOf("20160310"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160310"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20160310"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1, "遅延日数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160301"),
            BizDate.valueOf("20160302"),
            BizDate.valueOf("20160309"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(0), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), null, "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), null, "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 0, "遅延日数");
    }

    @Test
    @TestOrder(125)
    @Transactional
    public void testExec_inData2() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(130)
    public void testExec_B1() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUND);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20200913"),
            BizCurrency.valueOf(1.1111),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(0), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160913"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20200913"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1462, "遅延日数");
    }

    @Test
    @TestOrder(135)
    @Transactional
    public void testExec_inData3() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(140)
    public void testExec_B2() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDUP);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20240913"),
            BizCurrency.valueOf(1000.1111),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(801), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160913"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20240913"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 2923, "遅延日数");
    }

    @Test
    @TestOrder(150)
    public void testExec_B3() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20240913"),
            BizCurrency.valueOf(1000.1111),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(800), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160913"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20240913"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 2923, "遅延日数");
    }

    @Test
    @TestOrder(160)
    public void testExec_B4() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20340913"),
            BizCurrency.valueOf(1100.1111),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1980), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160913"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20340913"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 6575, "遅延日数");
    }

    @Test
    @TestOrder(170)
    public void testExec_B5() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDUP);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20340913"),
            BizCurrency.valueOf(1100.1111),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1981), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160913"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20340913"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 6575, "遅延日数");
    }

    @Test
    @TestOrder(180)
    public void testExec_B6() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUND);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20160229"),
            BizDate.valueOf("20160301"),
            BizDate.valueOf("20340913"),
            BizCurrency.valueOf(1100.1111),
            Integer.valueOf(15), C_SinsaGendoKknKbn.D180
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1980), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160913"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20340913"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 6575, "遅延日数");
    }

    @Test
    @TestOrder(185)
    @Transactional
    public void testExec_inData4() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(190)
    public void testExec_C1() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20200319"),
            BizDate.valueOf("20200323"),
            BizDate.valueOf("20240404"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(2408), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20200331"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20240404"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1466, "遅延日数");
        exBizCalcbleEquals(keisanTienrisokuDao.getTienrisokuRiritu(BizDate.valueOf("20200331")), BizNumber.valueOf(0.06), "メンバ変数．遅延利息利率");

    }

    @Test
    @TestOrder(200)
    public void testExec_C2() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20200323"),
            BizDate.valueOf("20200324"),
            BizDate.valueOf("20240405"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1204), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20200401"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20240405"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1466, "遅延日数");
        exBizCalcbleEquals(keisanTienrisokuDao.getTienrisokuRiritu(BizDate.valueOf("20200401")), BizNumber.valueOf(0.03), "メンバ変数．遅延利息利率");

    }

    @Test
    @TestOrder(210)
    public void testExec_C3() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20230322"),
            BizDate.valueOf("20230323"),
            BizDate.valueOf("20270404"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1204), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20230331"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20270404"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1466, "遅延日数");
        exBizCalcbleEquals(keisanTienrisokuDao.getTienrisokuRiritu(BizDate.valueOf("20230331")), BizNumber.valueOf(0.03), "メンバ変数．遅延利息利率");

    }

    @Test
    @TestOrder(220)
    public void testExec_C4() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.exec(BizDate.valueOf("20230323"),
            BizDate.valueOf("20230324"),
            BizDate.valueOf("20270405"),
            BizCurrency.valueOf(10000),
            Integer.valueOf(15), C_SinsaGendoKknKbn.BLNK
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1605), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20230401"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20270405"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1466, "遅延日数");
        exBizCalcbleEquals(keisanTienrisokuDao.getTienrisokuRiritu(BizDate.valueOf("20230401")), BizNumber.valueOf(0.04), "メンバ変数．遅延利息利率");

    }

    @Test
    @TestOrder(230)
    public void testExec_D1() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.execHaitouKin(BizDate.valueOf("20160301"),
            BizDate.valueOf("20200305"),
            BizCurrency.valueOf(10000)
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(2408), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160301"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20200305"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1466, "遅延日数");

    }

    @Test
    @TestOrder(240)
    public void testExec_D2() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.execHaitouKin(BizDate.valueOf("20160301"),
            BizDate.valueOf("20160305"),
            BizCurrency.valueOf(10000)
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(8), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160301"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20160305"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 5, "遅延日数");

    }

    @Test
    @TestOrder(250)
    public void testExec_D3() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.execHaitouKin(BizDate.valueOf("20160301"),
            BizDate.valueOf("20200229"),
            BizCurrency.valueOf(10000)
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(2400), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160301"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20200229"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1461, "遅延日数");

    }

    @Test
    @TestOrder(260)
    public void testExec_D4() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.execHaitouKin(BizDate.valueOf("20160301"),
            BizDate.valueOf("20200228"),
            BizCurrency.valueOf(10000)
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(2400), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160301"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20200228"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1460, "遅延日数");

    }

    @Test
    @TestOrder(290)
    public void testExec_D7() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.execHaitouKin(BizDate.valueOf("20160310"),
            BizDate.valueOf("20160310"),
            BizCurrency.valueOf(10000)
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(1), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), BizDate.valueOf("20160310"), "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), BizDate.valueOf("20160310"), "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 1, "遅延日数");
    }


    @Test
    @TestOrder(300)
    public void testExec_D8() {
        YuyuBizConfig.getInstance().setTienRskHasuusyori(C_Tienrskhasuusyori.ROUNDDOWN);
        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienrisoku.execHaitouKin(BizDate.valueOf("20160310"),
            BizDate.valueOf("20160309"),
            BizCurrency.valueOf(10000)
            );
        exBizCalcbleEquals(keisanTienrisokuBean.getShrtienrsk(), BizCurrency.valueOf(0), "遅延利息");
        exDateEquals(keisanTienrisokuBean.getShrtienrskStartYmd(), null, "遅延利息開始日");
        exDateEquals(keisanTienrisokuBean.getShrtienrskEndYmd(), null, "遅延利息終了日");
        exNumericEquals(keisanTienrisokuBean.getShrtienNissuu(), 0, "遅延日数");
    }
}

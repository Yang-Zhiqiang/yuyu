package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当利率取得クラスのメソッド {@link GetDRiritu#exec(BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetDRirituTest_exec extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当利率取得";
    private final static String sheetName = "INデータ";
    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(GetDRirituTest_exec.class, fileName, sheetName);
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

        String jpql = "delete from " + "BM_HaitouRiritu";
        em.createJPQL(jpql).executeUpdate();

        testDataAndTblMap = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_1_01() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20180101"), BizDate.valueOf("20180101"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_1_02() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170630"), BizDate.valueOf("20170417"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), null, "メンバ変数．配当利率");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getKinouId(), getDRiritu.getClass().getSimpleName(), "機能ID");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo2(), "計算基準日自 ＞ 計算基準日至", "エラー情報（小分類）");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_1_03() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20160101"), BizDate.valueOf("20170101"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), null, "メンバ変数．配当利率");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getKinouId(), getDRiritu.getClass().getSimpleName(), "機能ID");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo1(), "配当利率マスタ取得エラー", "エラー情報（大分類）");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo2(), "取得件数０件", "エラー情報（小分類）");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_1_04() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170101"), BizDate.valueOf("20180101"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), null, "メンバ変数．配当利率");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getKinouId(), getDRiritu.getClass().getSimpleName(), "機能ID");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo1(), "配当利率マスタ取得エラー", "エラー情報（大分類）");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo2(), "計算基準日自 ＜ 配当利率マスタで最小の基準日（自）", "エラー情報（小分類）");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_1_05() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20180101"), BizDate.valueOf("20190101"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.04), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_inData4() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }


    @Test
    @TestOrder(45)
    public void testExec_1_07() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20190227"), BizDate.valueOf("20200228"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), null, "メンバ変数．配当利率");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getKinouId(), getDRiritu.getClass().getSimpleName(), "機能ID");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo2(), "計算基準日至 ＞ 計算基準日自 ＋ 1年", "エラー情報（小分類）");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_08() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20190228"), BizDate.valueOf("20200228"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.04), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_09() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20190301"), BizDate.valueOf("20200228"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0398904109), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_10() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20190227"), BizDate.valueOf("20200229"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), null, "メンバ変数．配当利率");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getKinouId(), getDRiritu.getClass().getSimpleName(), "機能ID");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo2(), "計算基準日至 ＞ 計算基準日自 ＋ 1年", "エラー情報（小分類）");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_11() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20190228"), BizDate.valueOf("20200229"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.04), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_12() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20190301"), BizDate.valueOf("20200229"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.04), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_13() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20200229"), BizDate.valueOf("20210301"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), null, "メンバ変数．配当利率");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getKinouId(), getDRiritu.getClass().getSimpleName(), "機能ID");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo1(), "入力値エラー", "エラー情報（大分類）");
        exStringEquals(getDRiritu.getErrorInfo().get(0).getErrorInfo2(), "計算基準日至 ＞ 計算基準日自 ＋ 1年", "エラー情報（小分類）");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_14() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20200229"), BizDate.valueOf("20210228"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.04), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(45)
    public void testExec_1_15() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20200229"), BizDate.valueOf("20210227"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0398904109), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_2_01() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170630"), BizDate.valueOf("20180101"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0203013698), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_2_02() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170601"), BizDate.valueOf("20170702"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0042191780), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_inData5() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(55)
    public void testExec_2_03() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170417"), BizDate.valueOf("20170418"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0001095890), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_3_01() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20200101"), BizDate.valueOf("20210101"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.03), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_3_02() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20231231"), BizDate.valueOf("20241231"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.06), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(10)
    public void testExec_3_03() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170701"), BizDate.valueOf("20180701"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.04), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(20)
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
    @TestOrder(25)
    public void testExec_3_04() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20230702"), BizDate.valueOf("20240702"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.183), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
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
    @TestOrder(35)
    public void testExec_4_01() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170601"), BizDate.valueOf("20180601"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.3167123287), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(35)
    public void testExec_4_02() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170101"), BizDate.valueOf("20180101"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.3827397260), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(35)
    public void testExec_4_03() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20170101"), BizDate.valueOf("20170801"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.2569863013), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(35)
    public void testExec_4_04() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20160801"), BizDate.valueOf("20170801"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.5084931506), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_inData6() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(65)
    public void testExec_5_01() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20180601"), BizDate.valueOf("20190601"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0001), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(65)
    public void testExec_5_02() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20180901"), BizDate.valueOf("20190601"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0000747945), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(65)
    public void testExec_6_01() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20191201"), BizDate.valueOf("20201201"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0001), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(65)
    public void testExec_6_02() {

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        C_ErrorKbn errorKbn = getDRiritu.exec(BizDate.valueOf("20200201"), BizDate.valueOf("20201201"));

        exBizCalcbleEquals(getDRiritu.getDRiritu(), BizNumber.valueOf(0.0000832876), "メンバ変数．配当利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
}

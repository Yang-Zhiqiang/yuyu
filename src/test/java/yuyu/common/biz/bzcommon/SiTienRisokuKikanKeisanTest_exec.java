package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_YmdkeisikiKbn;
import yuyu.testinfr.TestOrder;

/**
 * 遅延利息期間計算テストのクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class SiTienRisokuKikanKeisanTest_exec {

    @Inject
    SiTienRisokuKikanKeisan siTienRisokuKikanKeisan;

    @Test(expected = BizLogicException.class)
    @TestOrder(10)
    public void testExec_A1() {

        SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean =
            new SiTienRisokuKikanKeisanBean();

        siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(C_YmdkeisikiKbn.YYYYMMDD);
        siTienRisokuKikanKeisanBean.setEndYmd(null);
        siTienRisokuKikanKeisanBean.setStartYmd("20160126");

        try {
            siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage()
                , "パラメータエラー　param='遅延利息終了年月日'"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2() {

        SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean =
            new SiTienRisokuKikanKeisanBean();

        siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(C_YmdkeisikiKbn.YYYYMMDD);
        siTienRisokuKikanKeisanBean.setEndYmd("20160126");
        siTienRisokuKikanKeisanBean.setStartYmd(null);

        try {
            siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage()
                , "パラメータエラー　param='遅延利息開始年月日'"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(30)
    public void testExec_A3() {

        SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean =
            new SiTienRisokuKikanKeisanBean();

        siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(C_YmdkeisikiKbn.YYYYMMDD);
        siTienRisokuKikanKeisanBean.setEndYmd("20160405");
        siTienRisokuKikanKeisanBean.setStartYmd("20160406");

        try {
            siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage()
                , "遅延利息開始年月日が遅延利息終了年月日より先日付のため処理できません。"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testExec_A4() {

        SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean =
            new SiTienRisokuKikanKeisanBean();

        siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(C_YmdkeisikiKbn.YYYYMM);
        siTienRisokuKikanKeisanBean.setEndYmd("201603");
        siTienRisokuKikanKeisanBean.setStartYmd("201604");

        try {
            siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage()
                , "遅延利息開始年月日が遅延利息終了年月日より先日付のため処理できません。"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(50)
    public void testExec_A5() {

        SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean =
            new SiTienRisokuKikanKeisanBean();

        siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(C_YmdkeisikiKbn.BLNK);
        siTienRisokuKikanKeisanBean.setEndYmd("20160406");
        siTienRisokuKikanKeisanBean.setStartYmd("20160306");

        try {
            siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage()
                , "パラメータエラー　param='遅延利息年月日形式区分'"
                , "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMM, "201601", "201402", "699", "1", "334");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMM, "201602", "201601", "31", "0", "31");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMM, "201603", "201603", "0", "0", "0");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20150216", "20140129", "383", "1", "18");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160229", "20160128", "32", "0", "32");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "21000228", "21000228", "0", "0", "0");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "16000228", "15980229", "729", "1", "365");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20170125", "20160227", "333", "0", "333");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "16000325", "16000228", "26", "0", "26");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160407", "20160406", "1", "0", "1");
    }

    @Test
    @TestOrder(160)
    public void testExec_B1() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160227", "20150228", "364", "0", "364");
    }

    @Test
    @TestOrder(170)
    public void testExec_B2() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160228", "20150228", "365", "1", "0");
    }

    @Test
    @TestOrder(180)
    public void testExec_B3() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160229", "20150228", "366", "1", "1");
    }

    @Test
    @TestOrder(190)
    public void testExec_B4() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160301", "20150228", "367", "1", "2");
    }

    @Test
    @TestOrder(200)
    public void testExec_B5() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160229", "20150301", "365", "0", "365");
    }

    @Test
    @TestOrder(210)
    public void testExec_B6() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20170228", "20160228", "366", "1", "0");
    }

    @Test
    @TestOrder(220)
    public void testExec_B7() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20170228", "20160229", "365", "1", "0");
    }

    @Test
    @TestOrder(230)
    public void testExec_B8() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20170301", "20160229", "366", "1", "1");
    }

    @Test
    @TestOrder(240)
    public void testExec_B9() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20151001", "20141001", "365", "1", "0");
    }

    @Test
    @TestOrder(250)
    public void testExec_B10() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20150930", "20141001", "364", "0", "364");
    }

    @Test
    @TestOrder(260)
    public void testExec_B11() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20161001", "20151001", "366", "1", "0");
    }

    @Test
    @TestOrder(270)
    public void testExec_B12() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20160930", "20151001", "365", "0", "365");
    }

    @Test
    @TestOrder(280)
    public void testExec_B13() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20170228", "20160227", "367", "1", "1");
    }

    @Test
    @TestOrder(290)
    public void testExec_B14() {

        testKikanExec(C_YmdkeisikiKbn.YYYYMMDD, "20170227", "20160228", "365", "0", "365");
    }

    private void testKikanExec(C_YmdkeisikiKbn ymdkeisikiKbn,
        String endYmd,
        String startYmd,
        String kikan_ddddd,
        String kikan_yy,
        String kikan_ddd) {

        SiTienRisokuKikanKeisanBean siTienRisokuKikanKeisanBean =
            new SiTienRisokuKikanKeisanBean();

        siTienRisokuKikanKeisanBean.setYmdkeisikiKbn(ymdkeisikiKbn);
        siTienRisokuKikanKeisanBean.setEndYmd(endYmd);
        siTienRisokuKikanKeisanBean.setStartYmd(startYmd);

        siTienRisokuKikanKeisan.exec(siTienRisokuKikanKeisanBean);

        exClassificationEquals(siTienRisokuKikanKeisanBean.getYmdkeisikiKbn(), ymdkeisikiKbn, "年月日形式区分");
        exStringEquals(siTienRisokuKikanKeisanBean.getEndYmd(), endYmd, "終了年月日");
        exStringEquals(siTienRisokuKikanKeisanBean.getStartYmd(), startYmd, "開始年月日");
        exStringEquals(siTienRisokuKikanKeisanBean.getKikan_ddddd().toString(), kikan_ddddd, "期間（DDDDD）");
        exStringEquals(siTienRisokuKikanKeisanBean.getKikan_yy().toString(), kikan_yy, "期間（YY）");
        exStringEquals(siTienRisokuKikanKeisanBean.getKikan_ddd().toString(), kikan_ddd, "期間（DDD）");

        MockObjectManager.initialize();
    }
}

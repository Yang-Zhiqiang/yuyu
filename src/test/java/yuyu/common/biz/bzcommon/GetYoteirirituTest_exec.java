package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 予定利率取得クラスのメソッド {@link GetYoteiriritu#exec(GetYoteirirituBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetYoteirirituTest_exec extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_予定利率取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetYoteirirituTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu2());
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕｹ");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180102"));
        bean.setHknkkn(2);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕｺ");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180102"));
        bean.setHknkkn(2);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.1234), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0.2345), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0.3456), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0.12), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0.5678), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕｱ");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180105"));
        bean.setHknkkn(3);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }
    @Test
    @TestOrder(40)
    public void testExec_A4() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕｲ");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180105"));
        bean.setHknkkn(2);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.7), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0.1), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0.2), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0.3), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0.6), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(50)
    public void testExec_A5() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕﾁ");
        bean.setKijyunymd(BizDate.valueOf("20280105"));
        bean.setKykymd(BizDate.valueOf("20180105"));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }
    @Test
    @TestOrder(60)
    public void testExec_A6() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕﾂ");
        bean.setKijyunymd(BizDate.valueOf("20271230"));
        bean.setKykymd(BizDate.valueOf("20180105"));
        bean.setSitihsyuriritu(BizNumber.valueOf(0.0166));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.0166), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(70)
    public void testExec_A7() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕﾃ");
        bean.setKijyunymd(BizDate.valueOf("20271120"));
        bean.setKykymd(BizDate.valueOf("20180105"));
        bean.setSitihsyuriritu(BizNumber.valueOf(0.0177));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.0177), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(80)
    public void testExec_A8() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕﾃ");
        bean.setKijyunymd(BizDate.valueOf("20271120"));
        bean.setKykymd(BizDate.valueOf("20180105"));
        bean.setSitihsyuriritu(BizNumber.valueOf(0.0176));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.0177), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
    @Test
    @TestOrder(90)
    public void testExec_A9() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕB");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180102"));
        bean.setHknkkn(2);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕﾊ");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180105"));
        bean.setHknkkn(2);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.7), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0.1), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0.2), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0.3), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0.5678), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕﾍ");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180102"));
        bean.setHknkkn(2);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.1234), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0.2345), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0.3456), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0.12), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0.5678), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ﾕF");
        bean.setSknnkaisiymd(BizDate.valueOf("20180101"));
        bean.setKykymd(BizDate.valueOf("20180104"));
        bean.setHknkkn(2);

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.1234), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0.2345), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0.3456), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0.12), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0.5678), "メンバ変数．ローディング変更後積立利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ｳ1");
        bean.setTuukasyu(C_Tuukasyu.JPY);
        bean.setKykymd(BizDate.valueOf("20180102"));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "メンバ変数．ローディング変更後積立利率");
        exBizCalcbleEquals(getYoteiriritu.getRendouritu(), BizNumber.valueOf(0), "メンバ変数．連動率");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ｳ2");
        bean.setTuukasyu(C_Tuukasyu.JPY);
        bean.setKykymd(BizDate.valueOf("20180102"));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.1234), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0.2345), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0.3456), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0.12), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0.5678), "メンバ変数．ローディング変更後積立利率");
        exBizCalcbleEquals(getYoteiriritu.getRendouritu(), BizNumber.valueOf(0.6789), "メンバ変数．連動率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        GetYoteirirituBean bean = SWAKInjector
            .getInstance(GetYoteirirituBean.class);
        bean.setSyouhncd("ｲ1");
        bean.setTuukasyu(C_Tuukasyu.JPY);
        bean.setKykymd(BizDate.valueOf("20180102"));

        GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
        C_ErrorKbn errorKbn = getYoteiriritu.exec(bean);

        exBizCalcbleEquals(getYoteiriritu.getYoteiriritu(), BizNumber.valueOf(0.7), "メンバ変数．予定利率");
        exBizCalcbleEquals(getYoteiriritu.getTumitateriritu(), BizNumber.valueOf(0.1), "メンバ変数．積立利率");
        exBizCalcbleEquals(getYoteiriritu.getTmttknzoukaritujygn(), BizNumber.valueOf(0.2), "メンバ変数．積立金増加率上限");
        exBizCalcbleEquals(getYoteiriritu.getSetteibairitu(), BizNumber.valueOf(0.3), "メンバ変数．設定倍率");
        exBizCalcbleEquals(getYoteiriritu.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0.6), "メンバ変数．ローディング変更後積立利率");
        exBizCalcbleEquals(getYoteiriritu.getRendouritu(), BizNumber.valueOf(0.8), "メンバ変数．連動率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
}

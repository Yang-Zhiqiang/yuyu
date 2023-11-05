package yuyu.common.biz.bzcommon;

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
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 市場価格調整用利率（最大基準日）取得クラスのメソッド {@link GetSjkkktyouseiyouriritu#execMaxkjnymd(GetSjkkktyouseiyourirituBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSjkkktyouseiyourirituTest_execMaxkjnymd extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_市場価格調整用利率取得";
    private final static String sheetName = "INデータ";
    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(GetSjkkktyouseiyourirituTest_execMaxkjnymd.class, fileName, sheetName);
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

        String jpql = "delete from " + "BM_SjkkkTyouseiyouRiritu2";
        em.createJPQL(jpql).executeUpdate();

        testDataAndTblMap = null;
    }

    @Test
    @TestOrder(10)
    public void testExecMaxkjnymd_A1() {

        GetSjkkktyouseiyourirituBean bean = SWAKInjector
            .getInstance(GetSjkkktyouseiyourirituBean.class);
        bean.setSyouhncd("ﾕｻ");
        bean.setKijyunymd(BizDate.valueOf("20180101"));
        bean.setHknkkn(2);

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.execMaxkjnymd(bean);

        exBizCalcbleEquals(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu(), BizNumber.valueOf(0), "メンバ変数．市場価格調整用利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExecMaxkjnymd_A2() {

        GetSjkkktyouseiyourirituBean bean = SWAKInjector
            .getInstance(GetSjkkktyouseiyourirituBean.class);
        bean.setSyouhncd("ﾕｼ");
        bean.setKijyunymd(BizDate.valueOf("20180101"));
        bean.setHknkkn(2);

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.execMaxkjnymd(bean);

        exBizCalcbleEquals(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu(), BizNumber.valueOf(0.1234), "メンバ変数．市場価格調整用利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExecMaxkjnymd_A3() {

        GetSjkkktyouseiyourirituBean bean = SWAKInjector
            .getInstance(GetSjkkktyouseiyourirituBean.class);
        bean.setSyouhncd("ｲ1");
        bean.setKijyunymd(BizDate.valueOf("20180105"));
        bean.setHknkkn(3);

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.execMaxkjnymd(bean);

        exBizCalcbleEquals(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu(), BizNumber.valueOf(0), "メンバ変数．市場価格調整用利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }
    @Test
    @TestOrder(40)
    public void testExecMaxkjnymd_A4() {

        GetSjkkktyouseiyourirituBean bean = SWAKInjector
            .getInstance(GetSjkkktyouseiyourirituBean.class);
        bean.setSyouhncd("ｲ2");
        bean.setKijyunymd(BizDate.valueOf("20180105"));
        bean.setHknkkn(2);

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.execMaxkjnymd(bean);

        exBizCalcbleEquals(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu(), BizNumber.valueOf(0.7), "メンバ変数．市場価格調整用利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExecMaxkjnymd_A5() {

        GetSjkkktyouseiyourirituBean bean = SWAKInjector
            .getInstance(GetSjkkktyouseiyourirituBean.class);
        bean.setSyouhncd("ﾕﾍ");
        bean.setKijyunymd(BizDate.valueOf("20180101"));
        bean.setHknkkn(2);

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.execMaxkjnymd(bean);

        exBizCalcbleEquals(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu(), BizNumber.valueOf(0.1234), "メンバ変数．市場価格調整用利率");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }
}

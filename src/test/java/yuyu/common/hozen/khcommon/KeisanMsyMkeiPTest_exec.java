package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 未収Ｐ・未経過Ｐ計算クラスのメソッド {@link KeisanMsyMkeiP#exec(String, BizDate, C_MisyuptsKbn)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanMsyMkeiPTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_未収Ｐ・未経過Ｐ計算";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(JtKaisukeisan.class).to(JtKaisukeisanMockForHozen.class);
                bind(KeisanGaikaP.class).to(KeisanGaikaPMockForHozen.class);
                bind(KeisanIkkatuPGk.class).to(KeisanIkkatuPGkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanMsyMkeiPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit(){
        JtKaisukeisanMockForHozen.caller = KeisanMsyMkeiPTest_exec.class;
        KeisanGaikaPMockForHozen.caller = KeisanMsyMkeiPTest_exec.class;
        KeisanIkkatuPGkMockForHozen.caller = KeisanMsyMkeiPTest_exec.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KykSyouhn").executeUpdate();

    }
    @AfterClass
    public static void testClear() {
        JtKaisukeisanMockForHozen.caller = null;
        JtKaisukeisanMockForHozen.SYORIPTN =null;
        KeisanGaikaPMockForHozen.caller = null;
        KeisanGaikaPMockForHozen.SYORIPTN =null;
        KeisanIkkatuPGkMockForHozen.caller = null;
        KeisanIkkatuPGkMockForHozen.SYORIPTN =null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        try {
            keisanMsyMkeiP.exec("11807111141", BizDate.valueOf("20181129"), BizDateYM.valueOf("201811"), BizCurrency.valueOf(1000),
                C_MisyuptsKbn.MITS);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。証券番号=11807111141", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        try {
            keisanMsyMkeiP.exec("11807111152", BizDate.valueOf("20181129"), BizDateYM.valueOf("201811"), BizCurrency.valueOf(1000),
                C_MisyuptsKbn.MITS);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。証券番号=11807111152", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        try {
            keisanMsyMkeiP.exec("11807111163", BizDate.valueOf("20181129"), BizDateYM.valueOf("201811"), BizCurrency.valueOf(1000),
                C_MisyuptsKbn.MITS);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。証券番号=11807111163", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111174", BizDate.valueOf("20181129"), BizDateYM.valueOf("201811"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.MITS);

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());

        MockObjectManager.assertNotCalled(SetOutoubi.class, "exec");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        keisanMsyMkeiP.exec("11807111185", BizDate.valueOf("20181129"), BizDateYM.valueOf("201806"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.MITS);

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());

        MockObjectManager.assertNotCalled(JtKaisukeisan.class, "exec");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111196", BizDate.valueOf("20181129"), BizDateYM.valueOf("201901"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.MITS);

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111200", BizDate.valueOf("20181130"), BizDateYM.valueOf("201901"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.MITS);

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(10000), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 5, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 7, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), BizDateYM.valueOf(201812), "未経過Ｐ充当年月");
        exBizCalcbleEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMiKeikaP(), BizCurrency.valueOf(10000), "明細未経過Ｐ");
        exDateEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(), BizDate.valueOf(20180101), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.TUKI, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 0, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 67, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytYm(), BizDateYM.valueOf(201812), "明細未経過Ｐ充当年月");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN1;
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.execKyknaiyouSitei("11807111211", BizDate.valueOf("20181130"), BizDateYM.valueOf("201903"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.MITS, BizCurrency.valueOf(6000), 20, C_Hhknsei.MALE, 12);

        KeisanIkkatuPGkBean keisanIkkatuPGkBean = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 0, 0);
        exStringEquals(keisanIkkatuPGkBean.getSyouhnCd(), "1002", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean.getSyouhnsdNo(), 2, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean.getRyouritusdNo(), "101", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean.getKeikamon(), 9, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getYoteiRiritu(), BizNumber.valueOf(1.5), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean.getHhknnen(), 20, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean.getHknkknsmnKbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean.getHknkkn(), 11, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean.getHrkkkn(), 12, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getHokenkngk(), BizCurrency.valueOf(6000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean.getDai1hknkkn(), 20, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");

        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 0, 1), false, "一括割引不要フラグ");

        KeisanIkkatuPGkBean keisanIkkatuPGkBean1 = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 1, 0);
        exStringEquals(keisanIkkatuPGkBean1.getSyouhnCd(), "1002", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean1.getSyouhnsdNo(), 2, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean1.getRyouritusdNo(), "101", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean1.getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean1.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean1.getKeikamon(), 1, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean1.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getYoteiRiritu(), BizNumber.valueOf(1.5), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean.getHhknnen(), 20, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean.getHknkknsmnKbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean.getHknkkn(), 11, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean.getHrkkkn(), 12, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getHokenkngk(), BizCurrency.valueOf(6000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean.getDai1hknkkn(), 20, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean.getHrkkeiro(), C_Hrkkeiro.SYUUDAN, "払込経路");

        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 1, 1), false, "一括割引不要フラグ");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(2100), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 21, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 31, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), BizDateYM.valueOf(201812), "未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMiKeikaP(), BizCurrency.valueOf(100), "明細未経過Ｐ");
        exDateEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(), BizDate.valueOf(20180104), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.TUKI, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 0, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 104, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytYm(), BizDateYM.valueOf(201812), "明細未経過Ｐ充当年月");
        exBizCalcbleEquals(keisanMsyMkeiP.getMiKeikaPBeans()[1].getMiKeikaP(), BizCurrency.valueOf(1000), "明細未経過Ｐ");
        exDateEquals(keisanMsyMkeiP.getMiKeikaPBeans()[1].getMkeiPNykDenYmd(), BizDate.valueOf(20180103), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanMsyMkeiP.getMiKeikaPBeans()[1].getMkeiPHrkKaisuu(), C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[1].getMkeiPJytKaisuuY(), 7, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[1].getMkeiPJytKaisuuM(), 12, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMiKeikaPBeans()[1].getMkeiPJytYm(), BizDateYM.valueOf(201812), "明細未経過Ｐ充当年月");
        exBizCalcbleEquals(keisanMsyMkeiP.getMiKeikaPBeans()[2].getMiKeikaP(), BizCurrency.valueOf(1000), "明細未経過Ｐ");
        exDateEquals(keisanMsyMkeiP.getMiKeikaPBeans()[2].getMkeiPNykDenYmd(), BizDate.valueOf(20180102), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanMsyMkeiP.getMiKeikaPBeans()[2].getMkeiPHrkKaisuu(), C_Hrkkaisuu.NEN, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[2].getMkeiPJytKaisuuY(), 6, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[2].getMkeiPJytKaisuuM(), 11, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMiKeikaPBeans()[2].getMkeiPJytYm(), BizDateYM.valueOf(201901), "明細未経過Ｐ充当年月");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN2;
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111222", BizDate.valueOf("20181130"), BizDateYM.valueOf("201901"), BizCurrency.valueOf(2000),
            C_MisyuptsKbn.MITS);

        KeisanIkkatuPGkBean keisanIkkatuPGkBean = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 0, 0);
        exStringEquals(keisanIkkatuPGkBean.getSyouhnCd(), "1003", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean.getSyouhnsdNo(), 3, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean.getRyouritusdNo(), "102", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getHokenryou(), BizCurrency.valueOf(2000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean.getKeikamon(), 3, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getYoteiRiritu(), BizNumber.valueOf(1.1), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean.getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean.getHknkknsmnKbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean.getHknkkn(), 11, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean.getHrkkkn(), 21, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean.getHokenkngk(), BizCurrency.valueOf(1000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean.getKykjyoutai(), C_Kykjyoutai.HARAIMAN, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean.getDai1hknkkn(), 40, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean.getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");


        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 0, 1), false, "一括割引不要フラグ");

        KeisanIkkatuPGkBean keisanIkkatuPGkBean1 = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 1, 0);
        exStringEquals(keisanIkkatuPGkBean1.getSyouhnCd(), "1004", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean1.getSyouhnsdNo(), 4, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean1.getRyouritusdNo(), "103", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean1.getHokenryou(), BizCurrency.valueOf(2000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean1.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean1.getKeikamon(), 3, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean1.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean1.getYoteiRiritu(), BizNumber.valueOf(1.2), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean1.getHhknnen(), 40, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean1.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean1.getHknkknsmnKbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean1.getHknkkn(), 12, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean1.getHrkkkn(), 22, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean1.getHokenkngk(), BizCurrency.valueOf(2000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean1.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean1.getKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean1.getDai1hknkkn(), 41, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean1.getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");

        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 1, 1), false, "一括割引不要フラグ");

        KeisanIkkatuPGkBean keisanIkkatuPGkBean2 = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 2, 0);
        exStringEquals(keisanIkkatuPGkBean2.getSyouhnCd(), "1005", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean2.getSyouhnsdNo(), 5, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean2.getRyouritusdNo(), "104", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean2.getHokenryou(), BizCurrency.valueOf(2000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean2.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean2.getKeikamon(), 3, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean2.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean2.getYoteiRiritu(), BizNumber.valueOf(1.3), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean2.getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean2.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean2.getHknkknsmnKbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean2.getHknkkn(), 13, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean2.getHrkkkn(), 23, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean2.getHokenkngk(), BizCurrency.valueOf(3000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean2.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean2.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean2.getDai1hknkkn(), 42, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean2.getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");

        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 2, 1), false, "一括割引不要フラグ");

        KeisanIkkatuPGkBean keisanIkkatuPGkBean3 = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 3, 0);
        exStringEquals(keisanIkkatuPGkBean3.getSyouhnCd(), "1003", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean3.getSyouhnsdNo(), 3, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean3.getRyouritusdNo(), "102", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean3.getHokenryou(), BizCurrency.valueOf(2000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean3.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean3.getKeikamon(), 4, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean3.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean3.getYoteiRiritu(), BizNumber.valueOf(1.1), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean3.getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean3.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean3.getHknkknsmnKbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean3.getHknkkn(), 11, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean3.getHrkkkn(), 21, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean3.getHokenkngk(), BizCurrency.valueOf(1000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean3.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean3.getKykjyoutai(), C_Kykjyoutai.HARAIMAN, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean3.getDai1hknkkn(), 40, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean3.getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");

        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 3, 1), false, "一括割引不要フラグ");

        KeisanIkkatuPGkBean keisanIkkatuPGkBean4 = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 4, 0);
        exStringEquals(keisanIkkatuPGkBean4.getSyouhnCd(), "1004", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean4.getSyouhnsdNo(), 4, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean4.getRyouritusdNo(), "103", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean4.getHokenryou(), BizCurrency.valueOf(2000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean4.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean4.getKeikamon(), 4, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean4.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean4.getYoteiRiritu(), BizNumber.valueOf(1.2), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean4.getHhknnen(), 40, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean4.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean4.getHknkknsmnKbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean4.getHknkkn(), 12, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean4.getHrkkkn(), 22, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean4.getHokenkngk(), BizCurrency.valueOf(2000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean4.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean4.getKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean4.getDai1hknkkn(), 41, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean4.getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");

        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 4, 1), false, "一括割引不要フラグ");

        KeisanIkkatuPGkBean keisanIkkatuPGkBean5 = (KeisanIkkatuPGkBean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 5, 0);
        exStringEquals(keisanIkkatuPGkBean5.getSyouhnCd(), "1005", "商品コード");
        exNumericEquals(keisanIkkatuPGkBean5.getSyouhnsdNo(), 5, "商品世代番号");
        exStringEquals(keisanIkkatuPGkBean5.getRyouritusdNo(), "104", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuPGkBean5.getHokenryou(), BizCurrency.valueOf(2000), "保険料");
        exClassificationEquals(keisanIkkatuPGkBean5.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(keisanIkkatuPGkBean5.getKeikamon(), 4, "経過月数");
        exClassificationEquals(keisanIkkatuPGkBean5.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBizCalcbleEquals(keisanIkkatuPGkBean5.getYoteiRiritu(), BizNumber.valueOf(1.3), "予定利率");
        exNumericEquals(keisanIkkatuPGkBean5.getHhknnen(), 50, "被保険者年齢");
        exClassificationEquals(keisanIkkatuPGkBean5.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exClassificationEquals(keisanIkkatuPGkBean5.getHknkknsmnKbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanIkkatuPGkBean5.getHknkkn(), 13, "保険期間");
        exNumericEquals(keisanIkkatuPGkBean5.getHrkkkn(), 23, "払込期間");
        exBizCalcbleEquals(keisanIkkatuPGkBean5.getHokenkngk(), BizCurrency.valueOf(3000), "保険金額");
        exClassificationEquals(keisanIkkatuPGkBean5.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(keisanIkkatuPGkBean5.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exNumericEquals(keisanIkkatuPGkBean5.getDai1hknkkn(), 42, "第１保険期間");
        exClassificationEquals(keisanIkkatuPGkBean5.getHrkkeiro(), C_Hrkkeiro.HURIKAE, "払込経路");

        exBooleanEquals((boolean) MockObjectManager.getArgument(KeisanIkkatuPGkMockForHozen.class, "exec", 5, 1), false, "一括割引不要フラグ");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(300), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 2, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), -1, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), BizDateYM.valueOf(201812), "未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMiKeikaP(), BizCurrency.valueOf(300), "明細未経過Ｐ");
        exDateEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(), BizDate.valueOf(20180105), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.TUKI, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 0, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 23, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytYm(), BizDateYM.valueOf(201812), "明細未経過Ｐ充当年月");
    }


    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN1;
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111233", BizDate.valueOf("20181130"), BizDateYM.valueOf("201901"), BizCurrency.valueOf(2000),
            C_MisyuptsKbn.MITS);

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(2000), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 1, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 11, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), BizDateYM.valueOf(201811), "未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMiKeikaP(), BizCurrency.valueOf(2000), "明細未経過Ｐ");
        exDateEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(), BizDate.valueOf(20180106), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.NEN, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 0, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 23, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytYm(), BizDateYM.valueOf(201807), "明細未経過Ｐ充当年月");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111244", BizDate.valueOf("20181129"), BizDateYM.valueOf("201805"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.TS);

        exNumericEquals((int)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 0), 0, "充当年数");
        exNumericEquals((int)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 1), 1, "充当月数");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 2),
            C_Hrkkaisuu.TUKI, "払込回数");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());

        MockObjectManager.assertNotCalled(KeisanGaikaP.class, "exec");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN2;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111255", BizDate.valueOf("20181129"), BizDateYM.valueOf("201804"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.TSKKTK);

        exNumericEquals((int)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 0), 0, "充当年数");
        exNumericEquals((int)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 1), 2, "充当月数");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 2),
            C_Hrkkaisuu.TUKI, "払込回数");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(20000), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 1, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), BizDateYM.valueOf(201804), "未収Ｐ充当年月");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMisyuuP(), BizCurrency.valueOf(20000), "明細未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMisyuuPGaika(), BizCurrency.valueOf(0), "明細未収Ｐ（外貨）");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPIkkatuNkUmu(), C_UmuKbn.NONE, "明細未収Ｐ一括入金有無");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPHrkKaisuu(), C_Hrkkaisuu.TUKI, "明細未収Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPJytKaisuuY(), 0, "明細未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPJytKaisuuM(), 1, "明細未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPJytYm(), BizDateYM.valueOf(201804), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN3;
        KeisanGaikaPMockForHozen.SYORIPTN = KeisanGaikaPMockForHozen.TESTPATTERN1;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("11807111266", BizDate.valueOf("20181129"), BizDateYM.valueOf("201803"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.TSKKTK);

        exNumericEquals((int)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 0), 0, "充当年数");
        exNumericEquals((int)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 1), 3, "充当月数");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(JtKaisukeisanMockForHozen.class, "exec", 0, 2),
            C_Hrkkaisuu.TUKI, "払込回数");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 0), BizCurrency.valueOf(20000), "保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 1), C_Tuukasyu.USD, "契約通貨種類");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 2), BizDateYM.valueOf(201803), "払込期月");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 3), BizDate.valueOf(20180501), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 0, 4), BizDate.valueOf(20181111), "初回保険料領収日");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 1, 0), BizCurrency.valueOf(20000), "保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 1, 1), C_Tuukasyu.USD, "契約通貨種類");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 1, 2), BizDateYM.valueOf(201804), "払込期月");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 1, 3), BizDate.valueOf(20180501), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 1, 4), BizDate.valueOf(20181111), "初回保険料領収日");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 2, 0), BizCurrency.valueOf(20000), "保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 2, 1), C_Tuukasyu.USD, "契約通貨種類");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 2, 2), BizDateYM.valueOf(201805), "払込期月");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 2, 3), BizDate.valueOf(20180501), "契約日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanGaikaPMockForHozen.class, "exec", 2, 4), BizDate.valueOf(20181111), "初回保険料領収日");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(60000), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(30300 ,BizCurrencyTypes.DOLLAR), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 3, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), BizDateYM.valueOf(201803), "未収Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMisyuuP(), BizCurrency.valueOf(20000), "明細未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMisyuuPGaika(), BizCurrency.valueOf(10100 ,BizCurrencyTypes.DOLLAR), "明細未収Ｐ（外貨）");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPIkkatuNkUmu(), C_UmuKbn.NONE, "明細未収Ｐ一括入金有無");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPHrkKaisuu(), C_Hrkkaisuu.TUKI, "明細未収Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPJytKaisuuY(), 0, "明細未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPJytKaisuuM(), 1, "明細未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMsyPJytYm(), BizDateYM.valueOf(201803), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[1].getMisyuuP(), BizCurrency.valueOf(20000), "明細未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[1].getMisyuuPGaika(), BizCurrency.valueOf(10100 ,BizCurrencyTypes.DOLLAR), "明細未収Ｐ（外貨）");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[1].getMsyPIkkatuNkUmu(), C_UmuKbn.NONE, "明細未収Ｐ一括入金有無");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[1].getMsyPHrkKaisuu(), C_Hrkkaisuu.TUKI, "明細未収Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[1].getMsyPJytKaisuuY(), 0, "明細未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[1].getMsyPJytKaisuuM(), 1, "明細未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuuPBeans()[1].getMsyPJytYm(), BizDateYM.valueOf(201804), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[2].getMisyuuP(), BizCurrency.valueOf(20000), "明細未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[2].getMisyuuPGaika(), BizCurrency.valueOf(10100 ,BizCurrencyTypes.DOLLAR), "明細未収Ｐ（外貨）");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[2].getMsyPIkkatuNkUmu(), C_UmuKbn.NONE, "明細未収Ｐ一括入金有無");
        exClassificationEquals(keisanMsyMkeiP.getMisyuuPBeans()[2].getMsyPHrkKaisuu(), C_Hrkkaisuu.TUKI, "明細未収Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[2].getMsyPJytKaisuuY(), 0, "明細未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuuPBeans()[2].getMsyPJytKaisuuM(), 1, "明細未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuuPBeans()[2].getMsyPJytYm(), BizDateYM.valueOf(201805), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());

    }
    @Test
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN4;
        KeisanIkkatuPGkMockForHozen.SYORIPTN = KeisanIkkatuPGkMockForHozen.TESTPATTERN4;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.execKyknaiyouSitei("17806000035", BizDate.valueOf("20181129"), BizDateYM.valueOf("201804"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.TSKKTK, BizCurrency.valueOf(60.00, BizCurrencyTypes.DOLLAR), 20, C_Hhknsei.MALE, 12);
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR), "未収Ｐ（外貨）");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMisyuuP(), BizCurrency.valueOf(0), "明細未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuuPBeans()[0].getMisyuuPGaika(), BizCurrency.valueOf(200,BizCurrencyTypes.DOLLAR), "明細未収Ｐ（外貨）");
        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 5, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), BizDateYM.valueOf(201812), "未経過Ｐ充当年月");
        exBizCalcbleEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMiKeikaP(),BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "明細未経過Ｐ");
        exDateEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(), BizDate.valueOf(20181129), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 0, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 5, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMiKeikaPBeans()[0].getMkeiPJytYm(), BizDateYM.valueOf(201804), "明細未経過Ｐ充当年月");

    }
    @Test
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN5;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("17806000068", BizDate.valueOf("20181129"), BizDateYM.valueOf("201804"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.TSKKTK);


        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());
    }
    @Test
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN6;

        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        keisanMsyMkeiP.exec("17806000079", BizDate.valueOf("20181129"), BizDateYM.valueOf("201804"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.TSKKTK);


        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());
    }
    @Test
    @TestOrder(170)
    public void testExec_A17() {
        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        keisanMsyMkeiP.exec("11807111277", BizDate.valueOf("20181130"), BizDateYM.valueOf("201806"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.MITS);

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());

        MockObjectManager.assertNotCalled(JtKaisukeisan.class, "exec");
    }
    @Test
    @TestOrder(180)
    public void testExec_A18() {
        KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
        MockObjectManager.initialize();
        JtKaisukeisanMockForHozen.SYORIPTN = JtKaisukeisanMockForHozen.TESTPATTERN1;

        keisanMsyMkeiP.exec("11807111288", BizDate.valueOf("20181129"), BizDateYM.valueOf("201806"), BizCurrency.valueOf(1000),
            C_MisyuptsKbn.MITS);

        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuP(), BizCurrency.valueOf(0), "未収Ｐ");
        exBizCalcbleEquals(keisanMsyMkeiP.getMisyuPGaika(), BizCurrency.valueOf(0), "未収Ｐ（外貨）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuY(), 0, "未収Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMisyuPJyutouKaisuuM(), 0, "未収Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMisyuPJyutouYM(), null, "未収Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMisyuuPBeans());

        exBizCalcbleEquals(keisanMsyMkeiP.getMikeikaP(), BizCurrency.valueOf(0), "未経過Ｐ");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanMsyMkeiP.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanMsyMkeiP.getMikeikaPJyutouYM(), null, "未経過Ｐ充当年月");
        assertNull(keisanMsyMkeiP.getMiKeikaPBeans());

        MockObjectManager.assertNotCalled(JtKaisukeisan.class, "exec");
    }
}

package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 貯蓄性保険判定処理のメソッド {@link SetTyotikuseihokenhyouji#hanteiTyotikuseihoken(HanteiTyotikuseihokenBean)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiTyotikuseihokenTest_exec {

    @Inject
    private SetTyotikuseihokenhyouji setTyotikuseihokenhyouji;

    private C_ErrorKbn erroKbn;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_貯蓄性保険表示設定";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanWMockForHozen.caller = HanteiTyotikuseihokenTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        KeisanWMockForHozen.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(HanteiTyotikuseihokenTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testHanteiTyotikuseihoken_A1() {

        MockObjectManager.initialize();

        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1002");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(false);

        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.ARI, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.NONE, "貯蓄性保険表示");

    }

    @Test
    @TestOrder(20)
    public void testHanteiTyotikuseihoken_A2() {

        MockObjectManager.initialize();

        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1003");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        hanteiTyotikuseihokenBean.setHrkkeiro(C_Hrkkeiro.HURIKAE);
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(false);

        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.ARI, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.NONE, "貯蓄性保険表示");

    }

    @Test
    @TestOrder(30)
    public void testHanteiTyotikuseihoken_A3() {

        MockObjectManager.initialize();

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1003");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setRyouritusdNo("3");
        hanteiTyotikuseihokenBean.setYoteiriritu(BizNumber.valueOf(1.5));
        hanteiTyotikuseihokenBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        hanteiTyotikuseihokenBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        hanteiTyotikuseihokenBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        hanteiTyotikuseihokenBean.setHrkkkn(2);
        hanteiTyotikuseihokenBean.setHknkkn(4);
        hanteiTyotikuseihokenBean.setHhknnen(20);
        hanteiTyotikuseihokenBean.setHhknsei(C_Hhknsei.MALE);
        hanteiTyotikuseihokenBean.setKihons(BizCurrency.valueOf(12345));
        hanteiTyotikuseihokenBean.setHokenryou(BizCurrency.valueOf(60000000));
        hanteiTyotikuseihokenBean.setKykymd(BizDate.valueOf(20200601));
        hanteiTyotikuseihokenBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(BizNumber.valueOf(1.6));
        hanteiTyotikuseihokenBean.setHrkkeiro(C_Hrkkeiro.HURIKAE);
        hanteiTyotikuseihokenBean.setHaraimanymd(BizDate.valueOf(20200901));
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
        hanteiTyotikuseihokenBean.setDai1hknkkn(10);

        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);
        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.NONE, "貯蓄性保険表示");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20200831"), "計算基準日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1), BizDateYM.valueOf("202009"), "解約返戻金計算基準年月");
        KeisanWExtBean keisanWExtBean = (KeisanWExtBean)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 2);
        exStringEquals(keisanWExtBean.getSyouhncd(), "1003", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "3", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(1.5), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(),C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(),C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(),C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 4, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 2, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 20, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(),C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(),BizCurrency.valueOf(12345),"基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(),BizCurrency.valueOf(60000000),"保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf("20200601"), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(),C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getYoteirrthendohosyurrt(), BizNumber.valueOf(1.6), "予定利率変動時保証利率");
        exNumericEquals(keisanWExtBean.getDai1hknkkn(), 10, "第１保険期間");
        exClassificationEquals(keisanWExtBean.getKykJyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
    }

    @Test
    @TestOrder(40)
    public void testHanteiTyotikuseihoken_A4() {

        MockObjectManager.initialize();

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1003");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setRyouritusdNo("3");
        hanteiTyotikuseihokenBean.setYoteiriritu(BizNumber.valueOf(1.5));
        hanteiTyotikuseihokenBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        hanteiTyotikuseihokenBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        hanteiTyotikuseihokenBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        hanteiTyotikuseihokenBean.setHrkkkn(2);
        hanteiTyotikuseihokenBean.setHknkkn(4);
        hanteiTyotikuseihokenBean.setHhknnen(20);
        hanteiTyotikuseihokenBean.setHhknsei(C_Hhknsei.MALE);
        hanteiTyotikuseihokenBean.setKihons(BizCurrency.valueOf(12345));
        hanteiTyotikuseihokenBean.setHokenryou(BizCurrency.valueOf(60000000));
        hanteiTyotikuseihokenBean.setKykymd(BizDate.valueOf(20200601));
        hanteiTyotikuseihokenBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(BizNumber.valueOf(1.6));
        hanteiTyotikuseihokenBean.setHrkkeiro(C_Hrkkeiro.SYUUDAN);
        hanteiTyotikuseihokenBean.setHaraimanymd(BizDate.valueOf(20200901));
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);

        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.ARI, "貯蓄性保険表示");
    }

    @Test
    @TestOrder(60)
    public void testHanteiTyotikuseihoken_A6() {
        MockObjectManager.initialize();

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;


        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1003");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setRyouritusdNo("3");
        hanteiTyotikuseihokenBean.setYoteiriritu(BizNumber.valueOf(1.5));
        hanteiTyotikuseihokenBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        hanteiTyotikuseihokenBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        hanteiTyotikuseihokenBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        hanteiTyotikuseihokenBean.setHrkkkn(2);
        hanteiTyotikuseihokenBean.setHknkkn(4);
        hanteiTyotikuseihokenBean.setHhknnen(20);
        hanteiTyotikuseihokenBean.setHhknsei(C_Hhknsei.MALE);
        hanteiTyotikuseihokenBean.setKihons(BizCurrency.valueOf(12345));
        hanteiTyotikuseihokenBean.setHokenryou(BizCurrency.valueOf(60000000));
        hanteiTyotikuseihokenBean.setKykymd(BizDate.valueOf(20200601));
        hanteiTyotikuseihokenBean.setKyktuukaSyu(C_Tuukasyu.USD);
        hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(BizNumber.valueOf(1.6));
        hanteiTyotikuseihokenBean.setHrkkeiro(C_Hrkkeiro.HURIKAE);
        hanteiTyotikuseihokenBean.setMosymd(BizDate.valueOf(20210201));
        hanteiTyotikuseihokenBean.setHaraimanymd(BizDate.valueOf(20210402));
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.ARI, "貯蓄性保険表示");
    }

    @Test
    @TestOrder(70)
    public void testHanteiTyotikuseihoken_A7() {

        MockObjectManager.initialize();

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN5;


        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1003");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setRyouritusdNo("3");
        hanteiTyotikuseihokenBean.setYoteiriritu(BizNumber.valueOf(1.5));
        hanteiTyotikuseihokenBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        hanteiTyotikuseihokenBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        hanteiTyotikuseihokenBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        hanteiTyotikuseihokenBean.setHrkkkn(2);
        hanteiTyotikuseihokenBean.setHknkkn(4);
        hanteiTyotikuseihokenBean.setHhknnen(20);
        hanteiTyotikuseihokenBean.setHhknsei(C_Hhknsei.MALE);
        hanteiTyotikuseihokenBean.setKihons(BizCurrency.valueOf(12345));
        hanteiTyotikuseihokenBean.setHokenryou(BizCurrency.valueOf(60000000));
        hanteiTyotikuseihokenBean.setKykymd(BizDate.valueOf(20200601));
        hanteiTyotikuseihokenBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(BizNumber.valueOf(1.6));
        hanteiTyotikuseihokenBean.setHrkkeiro(C_Hrkkeiro.SYUUDAN);
        hanteiTyotikuseihokenBean.setHaraimanymd(BizDate.valueOf(20200901));
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);

        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.NONE, "貯蓄性保険表示");
    }
    @Test
    @TestOrder(80)
    public void testHanteiTyotikuseihoken_A8() {
        MockObjectManager.initialize();

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;


        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1003");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setRyouritusdNo("3");
        hanteiTyotikuseihokenBean.setYoteiriritu(BizNumber.valueOf(1.5));
        hanteiTyotikuseihokenBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        hanteiTyotikuseihokenBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        hanteiTyotikuseihokenBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        hanteiTyotikuseihokenBean.setHrkkkn(2);
        hanteiTyotikuseihokenBean.setHknkkn(4);
        hanteiTyotikuseihokenBean.setHhknnen(20);
        hanteiTyotikuseihokenBean.setHhknsei(C_Hhknsei.MALE);
        hanteiTyotikuseihokenBean.setKihons(BizCurrency.valueOf(12345));
        hanteiTyotikuseihokenBean.setHokenryou(BizCurrency.valueOf(60000000));
        hanteiTyotikuseihokenBean.setKykymd(BizDate.valueOf(20200601));
        hanteiTyotikuseihokenBean.setKyktuukaSyu(C_Tuukasyu.USD);
        hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(BizNumber.valueOf(1.6));
        hanteiTyotikuseihokenBean.setHrkkeiro(C_Hrkkeiro.HURIKAE);
        hanteiTyotikuseihokenBean.setMosymd(BizDate.valueOf(20210301));
        hanteiTyotikuseihokenBean.setHaraimanymd(BizDate.valueOf(20210402));
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.ARI, "貯蓄性保険表示");
    }
    @Test
    @TestOrder(90)
    public void testHanteiTyotikuseihoken_A9() {
        MockObjectManager.initialize();

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;


        HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);

        hanteiTyotikuseihokenBean.setSyouhnCd("1003");
        hanteiTyotikuseihokenBean.setSyouhnsdNo(1);
        hanteiTyotikuseihokenBean.setRyouritusdNo("3");
        hanteiTyotikuseihokenBean.setYoteiriritu(BizNumber.valueOf(1.5));
        hanteiTyotikuseihokenBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        hanteiTyotikuseihokenBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        hanteiTyotikuseihokenBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        hanteiTyotikuseihokenBean.setHrkkkn(2);
        hanteiTyotikuseihokenBean.setHknkkn(4);
        hanteiTyotikuseihokenBean.setHhknnen(20);
        hanteiTyotikuseihokenBean.setHhknsei(C_Hhknsei.MALE);
        hanteiTyotikuseihokenBean.setKihons(BizCurrency.valueOf(12345));
        hanteiTyotikuseihokenBean.setHokenryou(BizCurrency.valueOf(60000000));
        hanteiTyotikuseihokenBean.setKykymd(BizDate.valueOf(20200601));
        hanteiTyotikuseihokenBean.setKyktuukaSyu(C_Tuukasyu.USD);
        hanteiTyotikuseihokenBean.setYoteirrthendohosyurrt(BizNumber.valueOf(1.6));
        hanteiTyotikuseihokenBean.setHrkkeiro(C_Hrkkeiro.HURIKAE);
        hanteiTyotikuseihokenBean.setMosymd(BizDate.valueOf(20210401));
        hanteiTyotikuseihokenBean.setHaraimanymd(BizDate.valueOf(20210402));
        hanteiTyotikuseihokenBean.setTyotikuseihokenhyoujihanteiflag(true);
        erroKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(setTyotikuseihokenhyouji.getHouteityotkhknhyj(),C_UmuKbn.NONE, "法定貯蓄性保険表示");
        exClassificationEquals(setTyotikuseihokenhyouji.getTyotkhknhyj(),C_UmuKbn.ARI, "貯蓄性保険表示");
    }

}

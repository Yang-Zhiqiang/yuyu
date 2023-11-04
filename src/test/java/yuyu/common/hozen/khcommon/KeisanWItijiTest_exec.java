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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 一時払用解約返戻金計算のメソッド {@link KeisanWItiji#exec(BizDate, BizDateYM, KeisanWExtBean) } テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanWItijiTest_exec {

    @Inject
    private KeisanWItiji keisanWItiji;

    private final static String fileName = "UT_SP_単体テスト仕様書_一時払用解約返戻金計算";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanWItijiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanV.class).to(KeisanVMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanVMockForHozen.caller = KeisanWItijiTest_exec.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllKaiyakuKoujyoRitu());
    }

    @AfterClass
    public static void testClear() {

        KeisanVMockForHozen.caller = null;
        KeisanVMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate calcKijyunYmd = BizDate.valueOf(20180323);
        BizDateYM kijyunYm = BizDateYM.valueOf(201704);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｹ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), null, "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), null, "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), null, "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), null, "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), null, "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), null, "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate calcKijyunYmd = BizDate.valueOf(20180324);
        BizDateYM kijyunYm = BizDateYM.valueOf(201704);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｹ01");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), null, "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), null, "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), null, "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), null, "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), null, "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), null, "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate calcKijyunYmd = BizDate.valueOf(20180324);
        BizDateYM kijyunYm = BizDateYM.valueOf(201704);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｹ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), null, "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), null, "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), null, "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), null, "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), null, "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), null, "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN1;

        BizDate calcKijyunYmd = BizDate.valueOf(20180324);
        BizDateYM kijyunYm = BizDateYM.valueOf(201906);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A001");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), null, "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), null, "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), null, "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), null, "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), null, "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), null, "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");

        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 0, BizDate.valueOf(20180324));
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 1, BizDateYM.valueOf(201906));
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 2, BizDate.valueOf(20180324));
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 3, "A001");
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 4, 1);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 5, "233");
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 6, BizNumber.valueOf(10));
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 7, C_Hrkkaisuu.NEN);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 8, C_Hhknsei.MALE);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 9, 13);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 10, C_HknkknsmnKbn.NENMANKI);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 11, 11);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 12, C_HrkkknsmnKbn.BLNK);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 13, 12);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 14, BizCurrency.valueOf(550022));
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 15, 1);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 16, 3);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 17, C_Tuukasyu.JPY);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 18, BizCurrency.valueOf(778833));
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 19, C_TyksenhokanhouKbn.JITUGAKU);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 20, C_Kykjyoutai.ITIJIBARAI);
        MockObjectManager.assertArgumentPassed(KeisanVMockForHozen.class, "exec", 21, 5);

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf(20180324);
        BizDateYM kijyunYm = BizDateYM.valueOf(201906);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A001");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), null, "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), null, "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), null, "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), null, "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), null, "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 0, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), null, "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), null, "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), null, "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), null, "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate calcKijyunYmd = BizDate.valueOf(20180623);
        BizDateYM kijyunYm = BizDateYM.valueOf(201704);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｻ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(0);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setYendthnkymd(BizDate.valueOf(20190601));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), null, "積立金額");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 0, "経過月数");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate calcKijyunYmd = BizDate.valueOf(20180623);
        BizDateYM kijyunYm = BizDateYM.valueOf(201704);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｻ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), null, "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), null, "積立金額");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 0, "経過月数");

    }

    @Test
    @TestOrder(1010)
    public void testExec_B1() {

        BizDate calcKijyunYmd = BizDate.valueOf(20201026);
        BizDateYM kijyunYm = BizDateYM.valueOf(201906);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｺ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(3);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201806));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(1420.57, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(3698.45, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0.475), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 2, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 1, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 2, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(1420.57, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(3698.45, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");
    }

    @Test
    @TestOrder(1020)
    public void testExec_B2() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf(20221026);
        BizDateYM kijyunYm = BizDateYM.valueOf(201902);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A002");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(5);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(9944.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0.475), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 4, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 11, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 4, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1030)
    public void testExec_B3() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN3;

        BizDate calcKijyunYmd = BizDate.valueOf(20231026);
        BizDateYM kijyunYm = BizDateYM.valueOf(201902);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A003");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(5);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(9944.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(1.00, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(1.00, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 11, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 5, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(1.00, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1040)
    public void testExec_B4() {

        BizDate calcKijyunYmd = BizDate.valueOf(20201026);
        BizDateYM kijyunYm = BizDateYM.valueOf(201906);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｺ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(3);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201806));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(162178));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(20021), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(389966), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0.475), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(369945), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 2, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 1, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 2, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(162178), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(227788), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(389966), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1050)
    public void testExec_B5() {

        BizDate calcKijyunYmd = BizDate.valueOf(20200224);
        BizDateYM kijyunYm = BizDateYM.valueOf(202006);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｼ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(3);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(1000.00, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.7633));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2544));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201906));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(3722.12, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(6392.72, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(6000.00, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(1.1446207461), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(867.72, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0.475), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(475.00, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 1, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 2, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0.3022), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 1, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(3722.12, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(6867.72, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1060)
    public void testExec_B6() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN4;

        BizDate calcKijyunYmd = BizDate.valueOf(20200224);
        BizDateYM kijyunYm = BizDateYM.valueOf(202006);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A004");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(4);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.1133));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2411));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(9944.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0.7020079126), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 2, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0.3022), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 1, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1070)
    public void testExec_B7() {

        BizDate calcKijyunYmd = BizDate.valueOf(20200224);
        BizDateYM kijyunYm = BizDateYM.valueOf(202006);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｼ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(3);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.1133));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2411));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201906));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(2722.12, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(5000.00, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0.7020079126), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(-1489.97, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0.475), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 1, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 2, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0.3022), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 1, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(2722.12, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(3510.03, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1080)
    public void testExec_B8() {

        BizDate calcKijyunYmd = BizDate.valueOf(20190124);
        BizDateYM kijyunYm = BizDateYM.valueOf(202006);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｽ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(13);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(11);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(10000));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.5533));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.1155));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201906));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(3723));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(101388), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(6000), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(17.6897072818), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(100138), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0.475), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(4750), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 2, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0.1111), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 0, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(3723), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(2277), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(106138), "解約返戻金（解約控除前）");
    }

    @Test
    @TestOrder(1090)
    public void testExec_B9() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf(20221026);
        BizDateYM kijyunYm = BizDateYM.valueOf(201902);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A005");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(5);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(9944.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 4, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 11, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 4, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1100)
    public void testExec_B10() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN3;

        BizDate calcKijyunYmd = BizDate.valueOf(20231026);
        BizDateYM kijyunYm = BizDateYM.valueOf(201902);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A006");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(5);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(9944.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(1.00, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(1.00, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 11, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 5, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(1.00, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1110)
    public void testExec_B11() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN4;

        BizDate calcKijyunYmd = BizDate.valueOf(20200224);
        BizDateYM kijyunYm = BizDateYM.valueOf(202006);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A007");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(4);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.1133));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2411));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(9944.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0.7020079126), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 0, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 2, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0.3022), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 1, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1120)
    public void testExec_B12() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf(20221026);
        BizDateYM kijyunYm = BizDateYM.valueOf(201902);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("A008");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(5);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(5500.22, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(7788.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(9944.33, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(2277.88, BizCurrencyTypes.DOLLAR));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 4, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 0, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 11, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 4, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(3699.45, BizCurrencyTypes.DOLLAR), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1130)
    public void testExec_B13() {

        BizDate calcKijyunYmd = BizDate.valueOf(20180623);
        BizDateYM kijyunYm = BizDateYM.valueOf(201704);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕｻ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(BizDate.valueOf(20180601));
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(95251), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(962858), "積立金額");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 1, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 2, "経過月数");

    }

    @Test
    @TestOrder(1140)
    public void testExec_B14() {

        MockObjectManager.initialize();

        KeisanVMockForHozen.SYORIPTN = KeisanVMockForHozen.TESTPATTERN2;

        BizDate calcKijyunYmd = BizDate.valueOf(20201026);
        BizDateYM kijyunYm = BizDateYM.valueOf(202006);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕﾍ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(3);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201906));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(null);
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(1464847), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(1834792), "積立金額");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseiritu(), BizNumber.valueOf(0), "市場価格調整率");
        exBizCalcbleEquals(keisanWItiji.getSjkkktyouseigk(), BizCurrency.valueOf(0), "市場価格調整額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjritu(), BizNumber.valueOf(0.475), "解約控除率");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjgk(), BizCurrency.valueOf(369945), "解約控除額");
        exNumericEquals(keisanWItiji.getKaiyakukoujyokeikanensuu(), 2, "解約控除用経過年数");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 2, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 3, "経過月数");
        exBizCalcbleEquals(keisanWItiji.getCV(), null, "変額積立金（契約単位）");
        exClassificationEquals(keisanWItiji.getFiSiyouKbn(), null, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanWItiji.getMvaTyouseikou(), BizNumber.valueOf(0), "ＭＶＡ調整項");
        exNumericEquals(keisanWItiji.getMvaYouKeikanensuu(), 2, "ＭＶＡ用経過年数");
        exBizCalcbleEquals(keisanWItiji.getTeiriTutmttKngk(), BizCurrency.valueOf(1607004), "定率積立金額");
        exBizCalcbleEquals(keisanWItiji.getSisuuRendouTmttKngk(), BizCurrency.valueOf(227788), "指数連動積立金額");
        exBizCalcbleEquals(keisanWItiji.getKaiyakukjMaeW(), BizCurrency.valueOf(1834792), "解約返戻金（解約控除前）");

    }

    @Test
    @TestOrder(1150)
    public void testExec_B15() {

        BizDate calcKijyunYmd = BizDate.valueOf(20180623);
        BizDateYM kijyunYm = BizDateYM.valueOf(201704);

        KeisanWExtBean keisanWExtBean = new KeisanWExtBean();
        keisanWExtBean.setSyouhncd("ﾕF");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("233");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(10));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(12);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHhknnen(13);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(550022));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(778833));
        keisanWExtBean.setKykymd(BizDate.valueOf(20180324));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.614));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.615));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201705));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(994433));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(227788));
        keisanWExtBean.setTmttknhaneisisuu(BizNumber.valueOf(0));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.616));
        keisanWExtBean.setJkipjytym(null);
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(0));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(0));
        keisanWExtBean.setFstpryosyuymd(null);
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
        keisanWExtBean.setSisanyoteiriritu(BizNumber.valueOf(0));
        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0));
        keisanWExtBean.setSisansyoriymd(null);
        keisanWExtBean.setYendthnkymd(BizDate.valueOf(20180601));
        keisanWExtBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ITIJIBARAI);

        C_ErrorKbn resultKbn = keisanWItiji.exec(calcKijyunYmd, kijyunYm, keisanWExtBean);

        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanWItiji.getW(), BizCurrency.valueOf(592913), "解約返戻金");
        exBizCalcbleEquals(keisanWItiji.getV(), BizCurrency.valueOf(962858), "積立金額");
        exNumericEquals(keisanWItiji.getKeikanensuu(), 1, "経過年数");
        exNumericEquals(keisanWItiji.getKeikatukisuu(), 2, "経過月数");

    }
}
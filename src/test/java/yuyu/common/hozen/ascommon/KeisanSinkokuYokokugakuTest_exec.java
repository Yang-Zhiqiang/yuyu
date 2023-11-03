package yuyu.common.hozen.ascommon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申告予告額計算クラスのメソッド {@link KeisanSinkokuYokokugaku#exec(KhozenCommonParam,IT_KykSyouhn,
 * BM_SyouhnZokusei,String,C_Kykjyoutai,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSinkokuYokokugakuTest_exec {

    @Inject
    private KeisanSinkokuYokokugaku keisanSinkokuYokokugaku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申告予告額計算";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(
                KeisanSinkokuYokokugakuTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        try {

            keisanSinkokuYokokugaku.exec(khozenCommonParam,
                kykSyouhn,
                syouhnZokusei,
                "2020",
                C_Kykjyoutai.BLNK,
                "99806001010");
        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品TBLにデータが存在しません。 証券番号＝99806001010", "エラーメッセージ");
        }

        exStringEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getSyoumeiNendo(), "",  "証明年度");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getTekiyouseidokbn(), C_TekiyouseidoKbn.BLNK,  "適用制度区分");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getHrkkaisuu(), C_Hrkkaisuu.BLNK,  "払込回数");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutoustartyoteiym(), null,  "保険料充当開始予定年月");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutouendyoteiym(), null,  "保険料充当終了予定年月");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkp(), BizCurrency.valueOf(0),  "新制度一般予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkhaitoukin(), BizCurrency.valueOf(0),  "新制度一般予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykksyoumeigk(), BizCurrency.valueOf(0),  "新制度一般予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkp(), BizCurrency.valueOf(0),  "新制度介護医療予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkhaitoukin(), BizCurrency.valueOf(0),  "新制度介護医療予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykksyoumeigk(), BizCurrency.valueOf(0),  "新制度介護医療予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkp(), BizCurrency.valueOf(0),  "新制度年金予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkhaitoukin(), BizCurrency.valueOf(0),  "新制度年金予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykksyoumeigk(), BizCurrency.valueOf(0),  "新制度年金予告証明額");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        try {

            keisanSinkokuYokokugaku.exec(khozenCommonParam,
                kykSyouhn,
                syouhnZokusei,
                "2020",
                C_Kykjyoutai.HRKMTYUU,
                "99806001021");
        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。商品属性マスタにデータが存在しません。 証券番号＝99806001021", "エラーメッセージ");
        }

        exStringEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getSyoumeiNendo(), "",  "証明年度");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getTekiyouseidokbn(), C_TekiyouseidoKbn.BLNK,  "適用制度区分");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getHrkkaisuu(), C_Hrkkaisuu.BLNK,  "払込回数");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutoustartyoteiym(), null,  "保険料充当開始予定年月");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutouendyoteiym(), null,  "保険料充当終了予定年月");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkp(), BizCurrency.valueOf(0),  "新制度一般予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkhaitoukin(), BizCurrency.valueOf(0),  "新制度一般予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykksyoumeigk(), BizCurrency.valueOf(0),  "新制度一般予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkp(), BizCurrency.valueOf(0),  "新制度介護医療予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkhaitoukin(), BizCurrency.valueOf(0),  "新制度介護医療予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykksyoumeigk(), BizCurrency.valueOf(0),  "新制度介護医療予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkp(), BizCurrency.valueOf(0),  "新制度年金予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkhaitoukin(), BizCurrency.valueOf(0),  "新制度年金予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykksyoumeigk(), BizCurrency.valueOf(0),  "新制度年金予告証明額");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        syouhnZokusei.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.IPPAN);

        keisanSinkokuYokokugaku.exec(khozenCommonParam,
            kykSyouhn,
            syouhnZokusei,
            "2020",
            C_Kykjyoutai.HRKMTYUU,
            "99806001032");

        exStringEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getSyoumeiNendo(), "2020",  "証明年度");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD,  "適用制度区分");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getHrkkaisuu(), C_Hrkkaisuu.HALFY,  "払込回数");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutoustartyoteiym(), BizDateYM.valueOf(202001),  "保険料充当開始予定年月");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutouendyoteiym(), BizDateYM.valueOf(202006),  "保険料充当終了予定年月");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkp(), BizCurrency.valueOf(10000.00, BizCurrencyTypes.DOLLAR),  "新制度一般予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkhaitoukin(), BizCurrency.valueOf(0),  "新制度一般予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykksyoumeigk(), BizCurrency.valueOf(10000.00, BizCurrencyTypes.DOLLAR),  "新制度一般予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkp(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度介護医療予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkhaitoukin(), BizCurrency.valueOf(0),  "新制度介護医療予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykksyoumeigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度介護医療予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkp(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度年金予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkhaitoukin(), BizCurrency.valueOf(0),  "新制度年金予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykksyoumeigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度年金予告証明額");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        syouhnZokusei.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.BLNK);

        keisanSinkokuYokokugaku.exec(khozenCommonParam,
            kykSyouhn,
            syouhnZokusei,
            "2020",
            C_Kykjyoutai.HRKMTYUU,
            "99806001043");

        exStringEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getSyoumeiNendo(), "2020",  "証明年度");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD,  "適用制度区分");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getHrkkaisuu(), C_Hrkkaisuu.HALFY,  "払込回数");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutoustartyoteiym(), BizDateYM.valueOf(202001),  "保険料充当開始予定年月");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutouendyoteiym(), BizDateYM.valueOf(202006),  "保険料充当終了予定年月");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkp(), BizCurrency.valueOf(20000.02, BizCurrencyTypes.DOLLAR),  "新制度一般予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkhaitoukin(), BizCurrency.valueOf(0),  "新制度一般予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykksyoumeigk(), BizCurrency.valueOf(20000.02, BizCurrencyTypes.DOLLAR),  "新制度一般予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkp(), BizCurrency.valueOf(20000.04, BizCurrencyTypes.DOLLAR),  "新制度介護医療予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkhaitoukin(), BizCurrency.valueOf(0),  "新制度介護医療予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykksyoumeigk(), BizCurrency.valueOf(20000.04, BizCurrencyTypes.DOLLAR),  "新制度介護医療予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkp(), BizCurrency.valueOf(20000.06, BizCurrencyTypes.DOLLAR),  "新制度年金予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkhaitoukin(), BizCurrency.valueOf(0),  "新制度年金予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykksyoumeigk(), BizCurrency.valueOf(20000.06, BizCurrencyTypes.DOLLAR),  "新制度年金予告証明額");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        syouhnZokusei.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);

        try {
            keisanSinkokuYokokugaku.exec(khozenCommonParam,
                kykSyouhn,
                syouhnZokusei,
                "2020",
                C_Kykjyoutai.ZENNOU,
                "99806001065");
        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。前納テーブル  取得エラー  証券番号＝99806001065", "エラーメッセージ");
        }


        exStringEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getSyoumeiNendo(), "",  "証明年度");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getTekiyouseidokbn(), C_TekiyouseidoKbn.BLNK,  "適用制度区分");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getHrkkaisuu(), C_Hrkkaisuu.BLNK,  "払込回数");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutoustartyoteiym(), null,  "保険料充当開始予定年月");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutouendyoteiym(), null,  "保険料充当終了予定年月");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkp(), BizCurrency.valueOf(0),  "新制度一般予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkhaitoukin(), BizCurrency.valueOf(0),  "新制度一般予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykksyoumeigk(), BizCurrency.valueOf(0),  "新制度一般予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkp(), BizCurrency.valueOf(0),  "新制度介護医療予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkhaitoukin(), BizCurrency.valueOf(0),  "新制度介護医療予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykksyoumeigk(), BizCurrency.valueOf(0),  "新制度介護医療予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkp(), BizCurrency.valueOf(0),  "新制度年金予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkhaitoukin(), BizCurrency.valueOf(0),  "新制度年金予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykksyoumeigk(), BizCurrency.valueOf(0),  "新制度年金予告証明額");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        syouhnZokusei.setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn.NENKIN);

        keisanSinkokuYokokugaku.exec(khozenCommonParam,
            kykSyouhn,
            syouhnZokusei,
            "2020",
            C_Kykjyoutai.ZENNOU,
            "99806001076");

        exStringEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getSyoumeiNendo(), "2020",  "証明年度");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD,  "適用制度区分");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutoustartyoteiym(), BizDateYM.valueOf(202001),  "保険料充当開始予定年月");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutouendyoteiym(), BizDateYM.valueOf(202006),  "保険料充当終了予定年月");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkp(), BizCurrency.valueOf(2087719, BizCurrencyTypes.YEN),  "新制度一般予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkhaitoukin(), BizCurrency.valueOf(0),  "新制度一般予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykksyoumeigk(), BizCurrency.valueOf(2087719, BizCurrencyTypes.YEN),  "新制度一般予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkp(), BizCurrency.valueOf(4175438, BizCurrencyTypes.YEN),  "新制度介護医療予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkhaitoukin(), BizCurrency.valueOf(0),  "新制度介護医療予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykksyoumeigk(), BizCurrency.valueOf(4175438, BizCurrencyTypes.YEN),  "新制度介護医療予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkp(), BizCurrency.valueOf(6263158, BizCurrencyTypes.YEN),  "新制度年金予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkhaitoukin(), BizCurrency.valueOf(0),  "新制度年金予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykksyoumeigk(), BizCurrency.valueOf(6263158, BizCurrencyTypes.YEN),  "新制度年金予告証明額");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

        keisanSinkokuYokokugaku.exec(khozenCommonParam,
            kykSyouhn,
            syouhnZokusei,
            "2020",
            C_Kykjyoutai.HRKMTYUU,
            "99806001054");

        exStringEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getSyoumeiNendo(), "2020",  "証明年度");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getTekiyouseidokbn(), C_TekiyouseidoKbn.NEWSD,  "適用制度区分");
        exClassificationEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutoustartyoteiym(), BizDateYM.valueOf(202001),  "保険料充当開始予定年月");
        exDateYMEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getPjyutouendyoteiym(), BizDateYM.valueOf(202006),  "保険料充当終了予定年月");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkp(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度一般予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykkhaitoukin(), BizCurrency.valueOf(0),  "新制度一般予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewippanykksyoumeigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度一般予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkp(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度介護医療予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykkhaitoukin(), BizCurrency.valueOf(0),  "新制度介護医療予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewiryouykksyoumeigk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR),  "新制度介護医療予告証明額");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkp(), BizCurrency.valueOf(10000.00, BizCurrencyTypes.DOLLAR),  "新制度年金予告保険料");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykkhaitoukin(), BizCurrency.valueOf(0),  "新制度年金予告配当金");
        exBizCalcbleEquals(keisanSinkokuYokokugaku.getSkkYkkTuutiParam().getNewnenkinykksyoumeigk(), BizCurrency.valueOf(10000.00, BizCurrencyTypes.DOLLAR),  "新制度年金予告証明額");
    }
}
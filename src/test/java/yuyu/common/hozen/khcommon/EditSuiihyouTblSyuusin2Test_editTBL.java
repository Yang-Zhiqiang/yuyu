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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 推移表ＴＢＬ編集（終身２）のメソッド {@link EditSuiihyouTblSyuusin2#editTBL(KhozenCommonParam, IT_KykKihon,
 *  List<IT_KykSyouhn>, List<IT_KykSyouhn>, IT_HhknSya, BizDate, EditHokenSyoukenParam, C_SinsaihkKbn, BM_SyouhnZokusei, IT_KykSonotaTkyk)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSuiihyouTblSyuusin2Test_editTBL {

    @Inject
    private EditSuiihyouTblSyuusin2 editSuiihyouTblSyuusin2;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private static Logger logger;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_推移表ＴＢＬ編集（終身２）";
    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
                bind(WSuiihyouSyuusin2.class).to(WSuiihyouSyuusin2MockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanWExtMockForHozen.caller = EditSuiihyouTblSyuusin2Test_editTBL.class;
        WSuiihyouSyuusin2MockForHozen.caller = EditSuiihyouTblSyuusin2Test_editTBL.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.caller = null;
        WSuiihyouSyuusin2MockForHozen.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditSuiihyouTblSyuusin2Test_editTBL.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1010)
    public void testEditTBL_A1() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN1;

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033011");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200930);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        try {
            editSuiihyouTblSyuusin2.editTBL(
                khozenCommonParam,
                kykKihon,
                kykSyouhnSyuLst,
                kykSyouhnTkLst,
                hhknSya,
                syoriYmd,
                editHokenSyoukenParam,
                C_SinsaihkKbn.SAI,
                syouhnZokusei,
                kykSonotaTkyk);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。解約返戻金計算拡張情報作成が実行できませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(2010)
    public void testEditTBL_B1() {

        MockObjectManager.initialize();
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033011");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200930);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20200831));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SIN;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouSyuusin2MockForHozen.class, "exec", 0, 0);
        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕﾉ", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "J", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.0101), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 99, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 0, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(20001), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(30001), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20200901), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0.01), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(100), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exDateYMEquals(keisanWExtBean.getJkipjytym(), null, "次回Ｐ充当年月");
        exBizCalcbleEquals(keisanWExtBean.getPtmttkngk(), BizCurrency.valueOf(0), "保険料積立金額");
        exBizCalcbleEquals(keisanWExtBean.getKihrkmpstgk(), BizCurrency.valueOf(0), "既払込保険料相当額");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), null, "初回保険料領収日");
        exBizCalcbleEquals(keisanWExtBean.getYoteirrthendohosyurrt(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exClassificationEquals(keisanWExtBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.JISSEKI, "（試算用）計算種類");
        exBizCalcbleEquals(keisanWExtBean.getSisanyoteiriritu(), BizNumber.valueOf(0), "（試算用）予定利率");
        exBizCalcbleEquals(keisanWExtBean.getSisankawaserate(), BizNumber.valueOf(0), "（試算用）為替レート");
        exDateEquals(keisanWExtBean.getSisansyoriymd(), null, "（試算用）処理日");
        exDateEquals(keisanWExtBean.getYendthnkymd(), null, "円建変更日");
        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20200901), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20200831), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 15, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(1.01), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(1.0101), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(101), "指数連動部分割合");
        exClassificationEquals(wSuiihyouParam.getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.BLNK, "積立金配分状態");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(10001), "ターゲット特約基準金額");
        exBizCalcbleEquals(wSuiihyouParam.getHeijyunP(), BizCurrency.valueOf(0), "平準払Ｐ");
        exBooleanEquals(wSuiihyouParam.getYoteiRirituList() == null, true, "予定利率リスト（件数）");
        exClassificationEquals(wSuiihyouParam.getZennouUmuKbn(), C_UmuKbn.NONE, "前納有無区分");
        exBizCalcbleEquals(wSuiihyouParam.getZennoujiHrkP(), BizCurrency.valueOf(0), "前納時払込保険料");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), null, "前納開始年月日");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), null, "領収日");
        exBizCalcbleEquals(wSuiihyouParam.getZennouNyuukingk(), BizCurrency.valueOf(0), "前納入金額");

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 26, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.DOLLAR;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 0;
            } else if (i <= 15) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 23) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "01", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033011", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200930), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類[i=" + i + "]");
            if (i < 15) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");

            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup2(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame2(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown2(), BizNumber.valueOf(0), "市場価格調整用利率（低下）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup3(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame3(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown3(), BizNumber.valueOf(0), "市場価格調整用利率（低下）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt1(), BizNumber.valueOf(0), "予定利率計算基準利率１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2020)
    public void testEditTBL_B2() {

        MockObjectManager.initialize();
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033022");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200930);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20200831));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SIN;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 26, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.AU_DOLLAR;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 0;
            } else if (i <= 15) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 24) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "02", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033022", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200930), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類[i=" + i + "]");
            if (i < 15) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2030)
    public void testEditTBL_B3() {

        MockObjectManager.initialize();
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033033");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200903);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20200831));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SIN;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 26, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.YEN;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 0;
            } else if (i <= 15) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 24) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "03", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033033", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200903), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類[i=" + i + "]");
            if (i < 15) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2040)
    public void testEditTBL_B4() {

        MockObjectManager.initialize();
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033044");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200831);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20200831));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 26, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.DOLLAR;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 0;
            } else if (i <= 15) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "04", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033044", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200831), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類[i=" + i + "]");
            if (i < 15) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2050)
    public void testEditTBL_B5() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033055");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200930);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210901));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        exStringEquals((String) MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), "99806033055", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf(20210901), "計算基準日");

        exClassificationEquals((C_YouhiKbn) MockObjectManager.getArgument(WSuiihyouSyuusin2MockForHozen.class, "setYenkansannYhKbn", 0, 0), C_YouhiKbn.HUYOU, "円換算要否区分");

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouSyuusin2MockForHozen.class, "exec", 0, 0);
        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "ﾕF", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "K", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(0.9999), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 99, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 0, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 30, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(22222), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(33333), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20200930), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0.99), "契約時市場価格調整用利率");
        exBizCalcbleEquals(keisanWExtBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exDateYMEquals(keisanWExtBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(keisanWExtBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(0), "指数連動積立金額");
        exBizCalcbleEquals(keisanWExtBean.getTmttknhaneisisuu(), BizNumber.valueOf(0), "積立金反映時指数");
        exBizCalcbleEquals(keisanWExtBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exDateYMEquals(keisanWExtBean.getJkipjytym(), null, "次回Ｐ充当年月");
        exBizCalcbleEquals(keisanWExtBean.getPtmttkngk(), BizCurrency.valueOf(0), "保険料積立金額");
        exBizCalcbleEquals(keisanWExtBean.getKihrkmpstgk(), BizCurrency.valueOf(0), "既払込保険料相当額");
        exDateEquals(keisanWExtBean.getFstpryosyuymd(), null, "初回保険料領収日");
        exBizCalcbleEquals(keisanWExtBean.getYoteirrthendohosyurrt(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exClassificationEquals(keisanWExtBean.getSisansyuruikbn(), C_KhSisanSyuruiKbn.JISSEKI, "（試算用）計算種類");
        exBizCalcbleEquals(keisanWExtBean.getSisanyoteiriritu(), BizNumber.valueOf(0), "（試算用）予定利率");
        exBizCalcbleEquals(keisanWExtBean.getSisankawaserate(), BizNumber.valueOf(0), "（試算用）為替レート");
        exDateEquals(keisanWExtBean.getSisansyoriymd(), null, "（試算用）処理日");
        exDateEquals(keisanWExtBean.getYendthnkymd(), null, "円建変更日");
        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20200905), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20210901), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 15, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(1.05), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(1.0505), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(105), "指数連動部分割合");
        exClassificationEquals(wSuiihyouParam.getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.BLNK, "積立金配分状態");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(10005), "ターゲット特約基準金額");
        exBizCalcbleEquals(wSuiihyouParam.getHeijyunP(), BizCurrency.valueOf(0), "平準払Ｐ");
        exBooleanEquals(wSuiihyouParam.getYoteiRirituList() == null, true, "予定利率リスト（件数）");
        exClassificationEquals(wSuiihyouParam.getZennouUmuKbn(), C_UmuKbn.NONE, "前納有無区分");
        exBizCalcbleEquals(wSuiihyouParam.getZennoujiHrkP(), BizCurrency.valueOf(0), "前納時払込保険料");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), null, "前納開始年月日");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), null, "領収日");
        exBizCalcbleEquals(wSuiihyouParam.getZennouNyuukingk(), BizCurrency.valueOf(0), "前納入金額");

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 27, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.YEN;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 1;
            } else if (i <= 14) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "05", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033055", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200930), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類[i=" + i + "]");
            if (i < 14) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2060)
    public void testEditTBL_B6() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033066");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200930);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20310901));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 17, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.YEN;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 11;
            } else if (i <= 4) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "06", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033066", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200930), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類[i=" + i + "]");
            if (i < 4) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2070)
    public void testEditTBL_B7() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033077");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200930);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20340901));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.BLNK;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 15, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.YEN;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 14;
            } else if (i <= 4) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 13) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "07", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033077", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200930), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類[i=" + i + "]");
            if (i < 1) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2080)
    public void testEditTBL_B8() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN3;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033088");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200930);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20360901));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.BLNK;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.AU_DOLLAR;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 16;
            } else if (i <= 4) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 12) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "08", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033088", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200930), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類[i=" + i + "]");
            if (i < 0) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2090)
    public void testEditTBL_B9() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN3;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033099");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200909);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20350901));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.BLNK;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.AU_DOLLAR;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 15;
            } else if (i <= 4) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 11) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "09", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033099", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200909), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), BizDate.valueOf(20200930).addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類[i=" + i + "]");
            if (i < 0) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2100)
    public void testEditTBL_B10() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033103");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200901);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20950901));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.BLNK;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 1, "件数");

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.YEN;
        int wkKeikaNensuu = 0;

        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 75;
            }

            exStringEquals(suiihyouLst.get(i).getKbnkey(), "00", "区分キー[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSyono(), "99806033103", "証券番号[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), BizDate.valueOf(20200901), "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), kykSyouhnSyuLst.get(0).getKykymd().addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exClassificationEquals(suiihyouLst.get(i).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類[i=" + i + "]");
            if (i < 0) {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0.1111), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0.2222), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0.3333), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0.1001), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0.3003), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0201"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0202"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0203"), wkKykTuukasyu), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0301"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0302"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0303"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0401"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0402"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0403"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0501"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0502"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0503"), BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0602"), wkKykTuukasyu), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            else {
                exClassificationEquals(suiihyouLst.get(i).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwsame(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwdown(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyenupyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyensameyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyendaka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariwyendownyenyasu(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvaariptumitatekin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "ＭＶＡ適用保険料積立金[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0702"), wkKykTuukasyu), "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0801"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0802"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0803"), BizCurrencyTypes.YEN), "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
                exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), BizCurrency.valueOf(Long.valueOf(String.valueOf(wkKeikaNensuu) + "0902"), wkKykTuukasyu), "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            }
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");
            exStringEquals(suiihyouLst.get(i).getSuiihyousyubetu(), "99", "推移表種別[i=" + i + "]");
        }
    }

    @Test
    @TestOrder(2110)
    public void testEditTBL_B11() {

        MockObjectManager.initialize();
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = WSuiihyouSyuusin2MockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User1");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806033114");
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20200901);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210901));

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.BLNK;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnSyuLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            wSinsaihkKbn,
            syouhnZokusei,
            kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 1, "件数");
        exStringEquals(suiihyouLst.get(0).getSyono(), "99806033114", "証券番号");
        exDateEquals(suiihyouLst.get(0).getTyouhyouymd(), BizDate.valueOf(20200901), "帳票作成日");
        exNumericEquals(suiihyouLst.get(0).getKeikanensuu(), 99, "経過年数");
        exDateEquals(suiihyouLst.get(0).getCalckijyunymd(), null, "計算基準日");
        exDateYMEquals(suiihyouLst.get(0).getCalcym(), null, "計算年月");
        exClassificationEquals(suiihyouLst.get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(suiihyouLst.get(0).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(suiihyouLst.get(0).getSuiihyousyubetu(), "00", "推移表種別");
    }

    @Test
    @TestOrder(3101)
    public void testEditTBL_C1_1() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20210913);
        BizDate kykYmd = BizDate.valueOf(20200911);

        CurrencyType wkKykTuukasyu = BizCurrencyTypes.YEN;

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        int wkKeikaNensuu = 0;
        BizCurrency tmttKngk = BizCurrency.valueOf(0,wkKykTuukasyu);

        for (IT_Suiihyou suiihyouForLog : suiihyouLst) {
            displayContents(suiihyouForLog);
        }

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 2;
            } else if (i <= 4) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 9) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            switch (i){
                case  0:tmttKngk = BizCurrency.valueOf(2001000,wkKykTuukasyu);break;
                case  1:tmttKngk = BizCurrency.valueOf(2002001,wkKykTuukasyu);break;
                case  2:tmttKngk = BizCurrency.valueOf(2003003,wkKykTuukasyu);break;
                case  3:tmttKngk = BizCurrency.valueOf(2004005,wkKykTuukasyu);break;
                case  4:tmttKngk = BizCurrency.valueOf(2005008,wkKykTuukasyu);break;
                case  5:tmttKngk = BizCurrency.valueOf(2010029,wkKykTuukasyu);break;
                case  6:tmttKngk = BizCurrency.valueOf(2015063,wkKykTuukasyu);break;
                case  7:tmttKngk = BizCurrency.valueOf(2020109,wkKykTuukasyu);break;
                case  8:tmttKngk = BizCurrency.valueOf(2025168,wkKykTuukasyu);break;
                case  9:tmttKngk = BizCurrency.valueOf(2030239,wkKykTuukasyu);break;
                case 10:tmttKngk = BizCurrency.valueOf(2040419,wkKykTuukasyu);break;
                case 11:tmttKngk = BizCurrency.valueOf(2050649,wkKykTuukasyu);break;
                case 12:tmttKngk = BizCurrency.valueOf(2060929,wkKykTuukasyu);break;
                case 13:tmttKngk = BizCurrency.valueOf(2071263,wkKykTuukasyu);break;
                default :
            }

            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), kykYmd.addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), tmttKngk, "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), tmttKngk, "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), tmttKngk, "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), tmttKngk, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), tmttKngk, "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
            check_yendate(suiihyouLst.get(i), i, syono);
        }
    }

    @Test
    @TestOrder(3102)
    public void testEditTBL_C1_2() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        BizDate syoriYmd = BizDate.valueOf(20260913);
        BizDate kykYmd = BizDate.valueOf(20200911);
        CurrencyType wkKykTuukasyu = BizCurrencyTypes.YEN;

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);

        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        int wkKeikaNensuu = 0;
        BizCurrency tmttKngk = BizCurrency.valueOf(0,wkKykTuukasyu);

        for (IT_Suiihyou suiihyouForLog : suiihyouLst) {
            displayContents(suiihyouForLog);
        }

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            if (i == 0) {
                wkKeikaNensuu = 7;
            } else if (i <= 4) {
                wkKeikaNensuu = wkKeikaNensuu + 1;
            } else if (i <= 10) {
                wkKeikaNensuu = wkKeikaNensuu + 5;
            } else {
                wkKeikaNensuu = wkKeikaNensuu + 10;
            }

            switch (i){
                case  0:tmttKngk = BizCurrency.valueOf(2006011,wkKykTuukasyu);break;
                case  1:tmttKngk = BizCurrency.valueOf(2007015,wkKykTuukasyu);break;
                case  2:tmttKngk = BizCurrency.valueOf(2008019,wkKykTuukasyu);break;
                case  3:tmttKngk = BizCurrency.valueOf(2009024,wkKykTuukasyu);break;
                case  4:tmttKngk = BizCurrency.valueOf(2010029,wkKykTuukasyu);break;
                case  5:tmttKngk = BizCurrency.valueOf(2015063,wkKykTuukasyu);break;
                case  6:tmttKngk = BizCurrency.valueOf(2020109,wkKykTuukasyu);break;
                case  7:tmttKngk = BizCurrency.valueOf(2025168,wkKykTuukasyu);break;
                case  8:tmttKngk = BizCurrency.valueOf(2030239,wkKykTuukasyu);break;
                case  9:tmttKngk = BizCurrency.valueOf(2035323,wkKykTuukasyu);break;
                case 10:tmttKngk = BizCurrency.valueOf(2040419,wkKykTuukasyu);break;
                case 11:tmttKngk = BizCurrency.valueOf(2050649,wkKykTuukasyu);break;
                case 12:tmttKngk = BizCurrency.valueOf(2060929,wkKykTuukasyu);break;
                case 13:tmttKngk = BizCurrency.valueOf(2071263,wkKykTuukasyu);break;
                default :
            }

            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
            exDateYMEquals(suiihyouLst.get(i).getCalcym(), kykYmd.addYears(wkKeikaNensuu).getBizDateYM(), "計算年月[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanoneptumitatekin(), tmttKngk, "ＭＶＡ適用外保険料積立金[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewsame(), tmttKngk, "ＭＶＡ適用外解約返戻金額[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyendaka(), tmttKngk, "ＭＶＡ適用外解約返戻金額（円貨）（円高）[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenkijyun(), tmttKngk, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）[i=" + i + "]");
            exBizCalcbleEquals(suiihyouLst.get(i).getMvanonewyensameyenyasu(), tmttKngk, "ＭＶＡ適用外解約返戻金額（円貨）（円安）[i=" + i + "]");
            check_yendate(suiihyouLst.get(i), i, syono);
        }
    }

    @Test
    @TestOrder(3103)
    public void testEditTBL_C1_3() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20260911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu =  7;break;
                case  1:wkKeikaNensuu =  8;break;
                case  2:wkKeikaNensuu =  9;break;
                case  3:wkKeikaNensuu = 10;break;
                case  4:wkKeikaNensuu = 11;break;
                case  5:wkKeikaNensuu = 16;break;
                case  6:wkKeikaNensuu = 21;break;
                case  7:wkKeikaNensuu = 26;break;
                case  8:wkKeikaNensuu = 31;break;
                case  9:wkKeikaNensuu = 36;break;
                case 10:wkKeikaNensuu = 41;break;
                case 11:wkKeikaNensuu = 51;break;
                case 12:wkKeikaNensuu = 61;break;
                case 13:wkKeikaNensuu = 71;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3104)
    public void testEditTBL_C1_4() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20300911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 11;break;
                case  1:wkKeikaNensuu = 12;break;
                case  2:wkKeikaNensuu = 13;break;
                case  3:wkKeikaNensuu = 14;break;
                case  4:wkKeikaNensuu = 15;break;
                case  5:wkKeikaNensuu = 20;break;
                case  6:wkKeikaNensuu = 25;break;
                case  7:wkKeikaNensuu = 30;break;
                case  8:wkKeikaNensuu = 35;break;
                case  9:wkKeikaNensuu = 40;break;
                case 10:wkKeikaNensuu = 45;break;
                case 11:wkKeikaNensuu = 55;break;
                case 12:wkKeikaNensuu = 65;break;
                case 13:wkKeikaNensuu = 75;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3105)
    public void testEditTBL_C1_5() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20310911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 12;break;
                case  1:wkKeikaNensuu = 13;break;
                case  2:wkKeikaNensuu = 14;break;
                case  3:wkKeikaNensuu = 15;break;
                case  4:wkKeikaNensuu = 16;break;
                case  5:wkKeikaNensuu = 21;break;
                case  6:wkKeikaNensuu = 26;break;
                case  7:wkKeikaNensuu = 31;break;
                case  8:wkKeikaNensuu = 36;break;
                case  9:wkKeikaNensuu = 41;break;
                case 10:wkKeikaNensuu = 46;break;
                case 11:wkKeikaNensuu = 51;break;
                case 12:wkKeikaNensuu = 61;break;
                case 13:wkKeikaNensuu = 71;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3106)
    public void testEditTBL_C1_6() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20350911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 16;break;
                case  1:wkKeikaNensuu = 17;break;
                case  2:wkKeikaNensuu = 18;break;
                case  3:wkKeikaNensuu = 19;break;
                case  4:wkKeikaNensuu = 20;break;
                case  5:wkKeikaNensuu = 25;break;
                case  6:wkKeikaNensuu = 30;break;
                case  7:wkKeikaNensuu = 35;break;
                case  8:wkKeikaNensuu = 40;break;
                case  9:wkKeikaNensuu = 45;break;
                case 10:wkKeikaNensuu = 50;break;
                case 11:wkKeikaNensuu = 55;break;
                case 12:wkKeikaNensuu = 65;break;
                case 13:wkKeikaNensuu = 75;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3107)
    public void testEditTBL_C1_7() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20400911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 21;break;
                case  1:wkKeikaNensuu = 22;break;
                case  2:wkKeikaNensuu = 23;break;
                case  3:wkKeikaNensuu = 24;break;
                case  4:wkKeikaNensuu = 25;break;
                case  5:wkKeikaNensuu = 30;break;
                case  6:wkKeikaNensuu = 35;break;
                case  7:wkKeikaNensuu = 40;break;
                case  8:wkKeikaNensuu = 45;break;
                case  9:wkKeikaNensuu = 50;break;
                case 10:wkKeikaNensuu = 55;break;
                case 11:wkKeikaNensuu = 60;break;
                case 12:wkKeikaNensuu = 65;break;
                case 13:wkKeikaNensuu = 75;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3108)
    public void testEditTBL_C1_8() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20410911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 22;break;
                case  1:wkKeikaNensuu = 23;break;
                case  2:wkKeikaNensuu = 24;break;
                case  3:wkKeikaNensuu = 25;break;
                case  4:wkKeikaNensuu = 26;break;
                case  5:wkKeikaNensuu = 31;break;
                case  6:wkKeikaNensuu = 36;break;
                case  7:wkKeikaNensuu = 41;break;
                case  8:wkKeikaNensuu = 46;break;
                case  9:wkKeikaNensuu = 51;break;
                case 10:wkKeikaNensuu = 56;break;
                case 11:wkKeikaNensuu = 61;break;
                case 12:wkKeikaNensuu = 66;break;
                case 13:wkKeikaNensuu = 71;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3109)
    public void testEditTBL_C1_9() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20460911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 13, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 27;break;
                case  1:wkKeikaNensuu = 28;break;
                case  2:wkKeikaNensuu = 29;break;
                case  3:wkKeikaNensuu = 30;break;
                case  4:wkKeikaNensuu = 31;break;
                case  5:wkKeikaNensuu = 36;break;
                case  6:wkKeikaNensuu = 41;break;
                case  7:wkKeikaNensuu = 46;break;
                case  8:wkKeikaNensuu = 51;break;
                case  9:wkKeikaNensuu = 56;break;
                case 10:wkKeikaNensuu = 61;break;
                case 11:wkKeikaNensuu = 66;break;
                case 12:wkKeikaNensuu = 71;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3110)
    public void testEditTBL_C1_10() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20690911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 9, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 50;break;
                case  1:wkKeikaNensuu = 51;break;
                case  2:wkKeikaNensuu = 52;break;
                case  3:wkKeikaNensuu = 53;break;
                case  4:wkKeikaNensuu = 54;break;
                case  5:wkKeikaNensuu = 59;break;
                case  6:wkKeikaNensuu = 64;break;
                case  7:wkKeikaNensuu = 69;break;
                case  8:wkKeikaNensuu = 74;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3111)
    public void testEditTBL_C1_11() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20850911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 6, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 66;break;
                case  1:wkKeikaNensuu = 67;break;
                case  2:wkKeikaNensuu = 68;break;
                case  3:wkKeikaNensuu = 69;break;
                case  4:wkKeikaNensuu = 70;break;
                case  5:wkKeikaNensuu = 75;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3112)
    public void testEditTBL_C1_12() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN4;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "99806032917";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20890911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 5, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 70;break;
                case  1:wkKeikaNensuu = 71;break;
                case  2:wkKeikaNensuu = 72;break;
                case  3:wkKeikaNensuu = 73;break;
                case  4:wkKeikaNensuu = 74;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：30歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3201)
    public void testEditTBL_C2_1() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20210913);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 2;break;
                case  1:wkKeikaNensuu = 3;break;
                case  2:wkKeikaNensuu = 4;break;
                case  3:wkKeikaNensuu = 5;break;
                case  4:wkKeikaNensuu = 6;break;
                case  5:wkKeikaNensuu = 11;break;
                case  6:wkKeikaNensuu = 16;break;
                case  7:wkKeikaNensuu = 21;break;
                case  8:wkKeikaNensuu = 26;break;
                case  9:wkKeikaNensuu = 31;break;
                case 10:wkKeikaNensuu = 36;break;
                case 11:wkKeikaNensuu = 46;break;
                case 12:wkKeikaNensuu = 56;break;
                case 13:wkKeikaNensuu = 66;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3202)
    public void testEditTBL_C2_2() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20250911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 6;break;
                case  1:wkKeikaNensuu = 7;break;
                case  2:wkKeikaNensuu = 8;break;
                case  3:wkKeikaNensuu = 9;break;
                case  4:wkKeikaNensuu = 10;break;
                case  5:wkKeikaNensuu = 15;break;
                case  6:wkKeikaNensuu = 20;break;
                case  7:wkKeikaNensuu = 25;break;
                case  8:wkKeikaNensuu = 30;break;
                case  9:wkKeikaNensuu = 35;break;
                case 10:wkKeikaNensuu = 40;break;
                case 11:wkKeikaNensuu = 50;break;
                case 12:wkKeikaNensuu = 60;break;
                case 13:wkKeikaNensuu = 70;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3203)
    public void testEditTBL_C2_3() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20260911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 7;break;
                case  1:wkKeikaNensuu = 8;break;
                case  2:wkKeikaNensuu = 9;break;
                case  3:wkKeikaNensuu = 10;break;
                case  4:wkKeikaNensuu = 11;break;
                case  5:wkKeikaNensuu = 16;break;
                case  6:wkKeikaNensuu = 21;break;
                case  7:wkKeikaNensuu = 26;break;
                case  8:wkKeikaNensuu = 31;break;
                case  9:wkKeikaNensuu = 36;break;
                case 10:wkKeikaNensuu = 41;break;
                case 11:wkKeikaNensuu = 46;break;
                case 12:wkKeikaNensuu = 56;break;
                case 13:wkKeikaNensuu = 66;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3204)
    public void testEditTBL_C2_4() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20300911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 11;break;
                case  1:wkKeikaNensuu = 12;break;
                case  2:wkKeikaNensuu = 13;break;
                case  3:wkKeikaNensuu = 14;break;
                case  4:wkKeikaNensuu = 15;break;
                case  5:wkKeikaNensuu = 20;break;
                case  6:wkKeikaNensuu = 25;break;
                case  7:wkKeikaNensuu = 30;break;
                case  8:wkKeikaNensuu = 35;break;
                case  9:wkKeikaNensuu = 40;break;
                case 10:wkKeikaNensuu = 45;break;
                case 11:wkKeikaNensuu = 50;break;
                case 12:wkKeikaNensuu = 60;break;
                case 13:wkKeikaNensuu = 70;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3205)
    public void testEditTBL_C2_5() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20310911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 12;break;
                case  1:wkKeikaNensuu = 13;break;
                case  2:wkKeikaNensuu = 14;break;
                case  3:wkKeikaNensuu = 15;break;
                case  4:wkKeikaNensuu = 16;break;
                case  5:wkKeikaNensuu = 21;break;
                case  6:wkKeikaNensuu = 26;break;
                case  7:wkKeikaNensuu = 31;break;
                case  8:wkKeikaNensuu = 36;break;
                case  9:wkKeikaNensuu = 41;break;
                case 10:wkKeikaNensuu = 46;break;
                case 11:wkKeikaNensuu = 51;break;
                case 12:wkKeikaNensuu = 56;break;
                case 13:wkKeikaNensuu = 66;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3206)
    public void testEditTBL_C2_6() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20350911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 16;break;
                case  1:wkKeikaNensuu = 17;break;
                case  2:wkKeikaNensuu = 18;break;
                case  3:wkKeikaNensuu = 19;break;
                case  4:wkKeikaNensuu = 20;break;
                case  5:wkKeikaNensuu = 25;break;
                case  6:wkKeikaNensuu = 30;break;
                case  7:wkKeikaNensuu = 35;break;
                case  8:wkKeikaNensuu = 40;break;
                case  9:wkKeikaNensuu = 45;break;
                case 10:wkKeikaNensuu = 50;break;
                case 11:wkKeikaNensuu = 55;break;
                case 12:wkKeikaNensuu = 60;break;
                case 13:wkKeikaNensuu = 70;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3207)
    public void testEditTBL_C2_7() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20400911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 14, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 21;break;
                case  1:wkKeikaNensuu = 22;break;
                case  2:wkKeikaNensuu = 23;break;
                case  3:wkKeikaNensuu = 24;break;
                case  4:wkKeikaNensuu = 25;break;
                case  5:wkKeikaNensuu = 30;break;
                case  6:wkKeikaNensuu = 35;break;
                case  7:wkKeikaNensuu = 40;break;
                case  8:wkKeikaNensuu = 45;break;
                case  9:wkKeikaNensuu = 50;break;
                case 10:wkKeikaNensuu = 55;break;
                case 11:wkKeikaNensuu = 60;break;
                case 12:wkKeikaNensuu = 65;break;
                case 13:wkKeikaNensuu = 70;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3208)
    public void testEditTBL_C2_8() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20410911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 13, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 22;break;
                case  1:wkKeikaNensuu = 23;break;
                case  2:wkKeikaNensuu = 24;break;
                case  3:wkKeikaNensuu = 25;break;
                case  4:wkKeikaNensuu = 26;break;
                case  5:wkKeikaNensuu = 31;break;
                case  6:wkKeikaNensuu = 36;break;
                case  7:wkKeikaNensuu = 41;break;
                case  8:wkKeikaNensuu = 46;break;
                case  9:wkKeikaNensuu = 51;break;
                case 10:wkKeikaNensuu = 56;break;
                case 11:wkKeikaNensuu = 61;break;
                case 12:wkKeikaNensuu = 66;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3209)
    public void testEditTBL_C2_9() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20460911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 12, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 27;break;
                case  1:wkKeikaNensuu = 28;break;
                case  2:wkKeikaNensuu = 29;break;
                case  3:wkKeikaNensuu = 30;break;
                case  4:wkKeikaNensuu = 31;break;
                case  5:wkKeikaNensuu = 36;break;
                case  6:wkKeikaNensuu = 41;break;
                case  7:wkKeikaNensuu = 46;break;
                case  8:wkKeikaNensuu = 51;break;
                case  9:wkKeikaNensuu = 56;break;
                case 10:wkKeikaNensuu = 61;break;
                case 11:wkKeikaNensuu = 66;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3210)
    public void testEditTBL_C2_10() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20690911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 8, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 50;break;
                case  1:wkKeikaNensuu = 51;break;
                case  2:wkKeikaNensuu = 52;break;
                case  3:wkKeikaNensuu = 53;break;
                case  4:wkKeikaNensuu = 54;break;
                case  5:wkKeikaNensuu = 59;break;
                case  6:wkKeikaNensuu = 64;break;
                case  7:wkKeikaNensuu = 69;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3211)
    public void testEditTBL_C2_11() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20850911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 5, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 66;break;
                case  1:wkKeikaNensuu = 67;break;
                case  2:wkKeikaNensuu = 68;break;
                case  3:wkKeikaNensuu = 69;break;
                case  4:wkKeikaNensuu = 70;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    @Test
    @TestOrder(3212)
    public void testEditTBL_C2_12() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN5;
        WSuiihyouSyuusin2MockForHozen.SYORIPTN = null;

        baseUserInfo.getUser().setUserId("User1");
        String syono = "17806000013";

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTblSyuusin2");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
        List<IT_KykSyouhn> kykSyouhnSyuLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_KykSyouhn> kykSyouhnTkLst =  kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        BizDate kykYmd = BizDate.valueOf(20200911);
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn wSinsaihkKbn = C_SinsaihkKbn.SAI;
        BM_SyouhnZokusei syouhnZokusei = kykSyouhnSyuLst.get(0).getSyouhnZokusei();
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        BizDate syoriYmd = BizDate.valueOf(20890911);
        editHokenSyoukenParam.setCalckijyunYMD(syoriYmd);
        int wkKeikaNensuu = BizDateUtil.calcDifference(syoriYmd, kykYmd).getYears() + 1 ;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力開始経過年：" + wkKeikaNensuu + "　検証開始" );

        editSuiihyouTblSyuusin2.editTBL(khozenCommonParam, kykKihon, kykSyouhnSyuLst, kykSyouhnTkLst, hhknSya, syoriYmd,
            editHokenSyoukenParam, wSinsaihkKbn, syouhnZokusei, kykSonotaTkyk);
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyous();

        exNumericEquals(suiihyouLst.size(), 1, "件数");
        for (int i = 0; i < suiihyouLst.size(); i ++) {
            displayContents(suiihyouLst.get(i));
            check_yendate(suiihyouLst.get(i), i, syono);
            exDateEquals(suiihyouLst.get(i).getTyouhyouymd(), syoriYmd, "帳票作成日[i=" + i + "]");
            switch (i){
                case  0:wkKeikaNensuu = 70;break;
                default :
            }
            exNumericEquals(suiihyouLst.get(i).getKeikanensuu(), wkKeikaNensuu, "経過年数[i=" + i + "]");
            exDateEquals(suiihyouLst.get(i).getCalckijyunymd(), kykYmd.addYears(wkKeikaNensuu), "計算基準日[i=" + i + "]");
        }
        int LastNenrei = 30 + wkKeikaNensuu;
        logger.debug("○ 被保険者年齢：35歳, 契約日：" + (kykYmd).toString() + ", 計算基準日：" + (syoriYmd).toString() + "出力終了年齢：" + LastNenrei + "　検証終了" );
    }

    private void check_yendate(IT_Suiihyou pSuiihyou, int i, String syono) {
        exStringEquals(pSuiihyou.getSuiihyousyubetu(), "04", "推移表種別[i=" + i + "]");
        exStringEquals(pSuiihyou.getKbnkey(), "01", "区分キー[i=" + i + "]");
        exStringEquals(pSuiihyou.getSyono(), syono, "証券番号[i=" + i + "]");
        exClassificationEquals(pSuiihyou.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類[i=" + i + "]");
        exClassificationEquals(pSuiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分[i=" + i + "]");
        exStringEquals(pSuiihyou.getGyoumuKousinKinou(), "EditSuiihyouTblSyuusin2", "業務用更新機能ＩＤ[i=" + i + "]");
        exStringEquals(pSuiihyou.getGyoumuKousinsyaId(), "User1", "業務用更新者ＩＤ[i=" + i + "]");

        BizCurrency baseCurrency = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtup(), BizNumber.ZERO, "市場価格調整用利率（上昇）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtsame(), BizNumber.ZERO, "市場価格調整用利率（同水準）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtdown(), BizNumber.ZERO, "市場価格調整用利率（低下）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendouup(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendoudown(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtup2(), BizNumber.ZERO, "市場価格調整用利率（上昇）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtsame2(), BizNumber.ZERO, "市場価格調整用利率（同水準）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtdown2(), BizNumber.ZERO, "市場価格調整用利率（低下）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendouup2(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendoudown2(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtup3(), BizNumber.ZERO, "市場価格調整用利率（上昇）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtsame3(), BizNumber.ZERO, "市場価格調整用利率（同水準）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtdown3(), BizNumber.ZERO, "市場価格調整用利率（低下）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendouup3(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendoudown3(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）３[i=" + i + "]");

        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyendaka(), BizNumber.ZERO, "円換算適用為替レート（円高）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.ZERO, "円換算適用為替レート（中央値）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenyasu(), BizNumber.ZERO, "円換算適用為替レート（円安）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyendaka2(), BizNumber.ZERO, "円換算適用為替レート（円高）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.ZERO, "円換算適用為替レート（中央値）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.ZERO, "円換算適用為替レート（円安）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyendaka2(), baseCurrency, "円換算適用為替レート変動額（円高）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyenyasu2(), baseCurrency, "円換算適用為替レート変動額（円安）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyendaka3(), BizNumber.ZERO, "円換算適用為替レート（円高）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.ZERO, "円換算適用為替レート（中央値）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.ZERO, "円換算適用為替レート（円安）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyendaka3(), baseCurrency, "円換算適用為替レート変動額（円高）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyenyasu3(), baseCurrency, "円換算適用為替レート変動額（円安）３[i=" + i + "]");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup(), baseCurrency, "ＭＶＡ適用解約返戻金額（上昇）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame(), baseCurrency, "ＭＶＡ適用解約返戻金額（同水準）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown(), baseCurrency, "ＭＶＡ適用解約返戻金額（低下）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin(), baseCurrency, "ＭＶＡ適用保険料積立金[i=" + i + "]");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup2(), baseCurrency, "ＭＶＡ適用解約返戻金額（上昇）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame2(), baseCurrency, "ＭＶＡ適用解約返戻金額（同水準）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown2(), baseCurrency, "ＭＶＡ適用解約返戻金額（低下）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu2(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin2(), baseCurrency, "ＭＶＡ適用保険料積立金２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewsame2(), baseCurrency, "ＭＶＡ適用外解約返戻金額２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyendaka2(), baseCurrency, "ＭＶＡ適用外解約返戻金額（円貨）（円高）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenkijyun2(), baseCurrency, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenyasu2(), baseCurrency, "ＭＶＡ適用外解約返戻金額（円貨）（円安）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanoneptumitatekin2(), baseCurrency, "ＭＶＡ適用外保険料積立金２[i=" + i + "]");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup3(), baseCurrency, "ＭＶＡ適用解約返戻金額（上昇）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame3(), baseCurrency, "ＭＶＡ適用解約返戻金額（同水準）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown3(), baseCurrency, "ＭＶＡ適用解約返戻金額（低下）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu3(), baseCurrency, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin3(), baseCurrency, "ＭＶＡ適用保険料積立金３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewsame3(), baseCurrency, "ＭＶＡ適用外解約返戻金額３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyendaka3(), baseCurrency, "ＭＶＡ適用外解約返戻金額（円貨）（円高）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenkijyun3(), baseCurrency, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenyasu3(), baseCurrency, "ＭＶＡ適用外解約返戻金額（円貨）（円安）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvanoneptumitatekin3(), baseCurrency, "ＭＶＡ適用外保険料積立金３[i=" + i + "]");

        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaeup1(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（上昇）１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaesame1(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（同水準）１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaedown1(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（低下）１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaeup2(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（上昇）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaeup3(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（上昇）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaesame2(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（同水準）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaesame3(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（同水準）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaedown2(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（低下）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaedown3(), baseCurrency, "ＭＶＡ適用積立金額（解約控除前）（低下）３[i=" + i + "]");

        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake11(), baseCurrency, "積立金内訳（１）１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake21(), baseCurrency, "積立金内訳（２）１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake12(), baseCurrency, "積立金内訳（１）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake22(), baseCurrency, "積立金内訳（２）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake13(), baseCurrency, "積立金内訳（１）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake23(), baseCurrency, "積立金内訳（２）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getZennouzndkyen1(), baseCurrency, "前納残高（円貨）１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getZennouzndkyen2(), baseCurrency, "前納残高（円貨）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getZennouzndkyen3(), baseCurrency, "前納残高（円貨）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getKihrkmpyen1(), baseCurrency, "既払込保険料（円貨）１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getKihrkmpyen2(), baseCurrency, "既払込保険料（円貨）２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getKihrkmpyen3(), baseCurrency, "既払込保険料（円貨）３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getKihrkmp1(), baseCurrency, "既払込保険料１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getKihrkmp2(), baseCurrency, "既払込保険料２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getKihrkmp3(), baseCurrency, "既払込保険料３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getMkhyouyensysnikougk(), baseCurrency, "目標到達時円建終身保険移行特約目標額[i=" + i + "]");

        exBizCalcbleEquals(pSuiihyou.getTmttknzoukaritu1(), BizNumber.ZERO, "積立金増加率１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getTmttknzoukaritu2(), BizNumber.ZERO, "積立金増加率２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getTmttknzoukaritu3(), BizNumber.ZERO, "積立金増加率３[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSisuuupritu1(), BizNumber.ZERO, "指数上昇率１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSisuuupritu2(), BizNumber.ZERO, "指数上昇率２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getSisuuupritu3(), BizNumber.ZERO, "指数上昇率３[i=" + i + "]");
        exClassificationEquals(pSuiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYtirrtcalckijyunrrt1(), BizNumber.ZERO, "予定利率計算基準利率１[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYtirrtcalckijyunrrt2(), BizNumber.ZERO, "予定利率計算基準利率２[i=" + i + "]");
        exBizCalcbleEquals(pSuiihyou.getYtirrtcalckijyunrrt3(), BizNumber.ZERO, "予定利率計算基準利率３[i=" + i + "]");
    }


    private void displayContents(IT_Suiihyou pSuiihyou) {
        logger.debug("▼ 推移表TBLの設定値");
        logger.debug("│ ★共通：経過年数 = {}", pSuiihyou.getKeikanensuu());
        logger.debug("│ ★共通：計算基準日 = {}", pSuiihyou.getCalckijyunymd());
        logger.debug("│ ★共通：計算年月 = {}", pSuiihyou.getCalcym());
        logger.debug("│ ★共通：ＭＶＡ適用状態区分 = {}", pSuiihyou.getMvatekijyoutaikbn());
        logger.debug("│ ★共通：契約通貨種類 = {}", pSuiihyou.getKyktuukasyu());
        logger.debug("│ ★共通：推移表種別 = {}", pSuiihyou.getSuiihyousyubetu());
        logger.debug("│ ★共通：払込期間満了有無区分 = {}", pSuiihyou.getHrkkknmnryumukbn());
        logger.debug("│ ★①：市場価格調整用利率（上昇） = {}", pSuiihyou.getSjkkktusirrtup());
        logger.debug("│ ★①：市場価格調整用利率（同水準） = {}", pSuiihyou.getSjkkktusirrtsame());
        logger.debug("│ ★①：市場価格調整用利率（低下） = {}", pSuiihyou.getSjkkktusirrtdown());
        logger.debug("│ ★①：市場価格調整用利率変動幅（上） = {}", pSuiihyou.getSjkkktusirrthendouup());
        logger.debug("│ ★①：市場価格調整用利率変動幅（下） = {}", pSuiihyou.getSjkkktusirrthendoudown());
        logger.debug("│ ★②：市場価格調整用利率（上昇）２ = {}", pSuiihyou.getSjkkktusirrtup2());
        logger.debug("│ ★②：市場価格調整用利率（同水準）２ = {}", pSuiihyou.getSjkkktusirrtsame2());
        logger.debug("│ ★②：市場価格調整用利率（低下）２ = {}", pSuiihyou.getSjkkktusirrtdown2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（上）２ = {}", pSuiihyou.getSjkkktusirrthendouup2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（下）２ = {}", pSuiihyou.getSjkkktusirrthendoudown2());
        logger.debug("│ ★③：市場価格調整用利率（上昇）３ = {}", pSuiihyou.getSjkkktusirrtup3());
        logger.debug("│ ★③：市場価格調整用利率（同水準）３ = {}", pSuiihyou.getSjkkktusirrtsame3());
        logger.debug("│ ★③：市場価格調整用利率（低下）３ = {}", pSuiihyou.getSjkkktusirrtdown3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（上）３ = {}", pSuiihyou.getSjkkktusirrthendouup3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（下）３ = {}", pSuiihyou.getSjkkktusirrthendoudown3());
        logger.debug("│ ★①：円換算適用為替レート（円高） = {}", pSuiihyou.getYenknsnkwsrateyendaka());
        logger.debug("│ ★①：円換算適用為替レート（中央値） = {}", pSuiihyou.getYenknsnkwsrateyenkijyun());
        logger.debug("│ ★①：円換算適用為替レート（円安） = {}", pSuiihyou.getYenknsnkwsrateyenyasu());
        logger.debug("│ ★①：円換算適用為替レート変動額（円高） = {}", pSuiihyou.getYenknsnkwsrategkyendaka());
        logger.debug("│ ★①：円換算適用為替レート変動額（円安） = {}", pSuiihyou.getYenknsnkwsrategkyenyasu());
        logger.debug("│ ★②：円換算適用為替レート（円高）２ = {}", pSuiihyou.getYenknsnkwsrateyendaka2());
        logger.debug("│ ★②：円換算適用為替レート（中央値）２ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun2());
        logger.debug("│ ★②：円換算適用為替レート（円安）２ = {}", pSuiihyou.getYenknsnkwsrateyenyasu2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円高）２ = {}", pSuiihyou.getYenknsnkwsrategkyendaka2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円安）２ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu2());
        logger.debug("│ ★③：円換算適用為替レート（円高）３ = {}", pSuiihyou.getYenknsnkwsrateyendaka3());
        logger.debug("│ ★③：円換算適用為替レート（中央値）３ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun3());
        logger.debug("│ ★③：円換算適用為替レート（円安）３ = {}", pSuiihyou.getYenknsnkwsrateyenyasu3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円高）３ = {}", pSuiihyou.getYenknsnkwsrategkyendaka3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円安）３ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu3());
        logger.debug("│ ★①：指数上昇率１ = {}", pSuiihyou.getSisuuupritu1());
        logger.debug("│ ★①：積立金増加率１ = {}", pSuiihyou.getTmttknzoukaritu1());
        logger.debug("│ ★①：ＭＶＡ適用保険料積立金 = {}", pSuiihyou.getMvaariptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（上昇）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（同水準）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（低下）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（上昇） = {}", pSuiihyou.getMvaariwup());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（同水準） = {}", pSuiihyou.getMvaariwsame());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（低下） = {}", pSuiihyou.getMvaariwdown());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高） = {}", pSuiihyou.getMvaariwyenupyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値） = {}", pSuiihyou.getMvaariwyenupyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安） = {}", pSuiihyou.getMvaariwyenupyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高） = {}", pSuiihyou.getMvaariwyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値） = {}", pSuiihyou.getMvaariwyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安） = {}", pSuiihyou.getMvaariwyensameyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高） = {}", pSuiihyou.getMvaariwyendownyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値） = {}", pSuiihyou.getMvaariwyendownyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安） = {}", pSuiihyou.getMvaariwyendownyenyasu());
        logger.debug("│ ★①：積立金内訳（１）１ = {}", pSuiihyou.getTutmttknutiwake11());
        logger.debug("│ ★①：積立金内訳（２）１ = {}", pSuiihyou.getTutmttknutiwake21());
        logger.debug("│ ★②：指数上昇率２ = {}", pSuiihyou.getSisuuupritu2());
        logger.debug("│ ★②：積立金増加率２ = {}", pSuiihyou.getTmttknzoukaritu2());
        logger.debug("│ ★②：ＭＶＡ適用保険料積立金２ = {}", pSuiihyou.getMvaariptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（上昇）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（同水準）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（低下）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（上昇）２ = {}", pSuiihyou.getMvaariwup2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（同水準）２ = {}", pSuiihyou.getMvaariwsame2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（低下）２ = {}", pSuiihyou.getMvaariwdown2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２ = {}", pSuiihyou.getMvaariwyenupyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２ = {}", pSuiihyou.getMvaariwyenupyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２ = {}", pSuiihyou.getMvaariwyenupyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２ = {}", pSuiihyou.getMvaariwyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２ = {}", pSuiihyou.getMvaariwyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２ = {}", pSuiihyou.getMvaariwyensameyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２ = {}", pSuiihyou.getMvaariwyendownyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２ = {}", pSuiihyou.getMvaariwyendownyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２ = {}", pSuiihyou.getMvaariwyendownyenyasu2());
        logger.debug("│ ★②：積立金内訳（１）２ = {}", pSuiihyou.getTutmttknutiwake12());
        logger.debug("│ ★②：積立金内訳（２）２ = {}", pSuiihyou.getTutmttknutiwake22());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（上昇）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（同水準）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（低下）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        logger.debug("│ ★③：指数上昇率３ = {}", pSuiihyou.getSisuuupritu3());
        logger.debug("│ ★③：積立金増加率３ = {}", pSuiihyou.getTmttknzoukaritu3());
        logger.debug("│ ★③：ＭＶＡ適用保険料積立金３ = {}", pSuiihyou.getMvaariptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（上昇）３ = {}", pSuiihyou.getMvaariwup3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（同水準）３ = {}", pSuiihyou.getMvaariwsame3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（低下）３ = {}", pSuiihyou.getMvaariwdown3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３ = {}", pSuiihyou.getMvaariwyenupyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３ = {}", pSuiihyou.getMvaariwyenupyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３ = {}", pSuiihyou.getMvaariwyenupyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３ = {}", pSuiihyou.getMvaariwyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３ = {}", pSuiihyou.getMvaariwyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３ = {}", pSuiihyou.getMvaariwyensameyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３ = {}", pSuiihyou.getMvaariwyendownyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３ = {}", pSuiihyou.getMvaariwyendownyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３ = {}", pSuiihyou.getMvaariwyendownyenyasu3());
        logger.debug("│ ★③：積立金内訳（１）３ = {}", pSuiihyou.getTutmttknutiwake13());
        logger.debug("│ ★③：積立金内訳（２）３ = {}", pSuiihyou.getTutmttknutiwake23());
        logger.debug("│ ★①：ＭＶＡ適用外保険料積立金 = {}", pSuiihyou.getMvanoneptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額 = {}", pSuiihyou.getMvanonewsame());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円高） = {}", pSuiihyou.getMvanonewyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（中央値） = {}", pSuiihyou.getMvanonewyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円安） = {}", pSuiihyou.getMvanonewyensameyenyasu());
        logger.debug("│ ★②：ＭＶＡ適用外保険料積立金２ = {}", pSuiihyou.getMvanoneptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額２ = {}", pSuiihyou.getMvanonewsame2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円高）２ = {}", pSuiihyou.getMvanonewyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（中央値）２ = {}", pSuiihyou.getMvanonewyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円安）２ = {}", pSuiihyou.getMvanonewyensameyenyasu2());
        logger.debug("│ ★③：ＭＶＡ適用外保険料積立金３ = {}", pSuiihyou.getMvanoneptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額３ = {}", pSuiihyou.getMvanonewsame3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円高）３ = {}", pSuiihyou.getMvanonewyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（中央値）３ = {}", pSuiihyou.getMvanonewyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円安）３ = {}", pSuiihyou.getMvanonewyensameyenyasu3());
        logger.debug("│ ★①：予定利率計算基準利率１ = {}", pSuiihyou.getYtirrtcalckijyunrrt1());
        logger.debug("│ ★②：予定利率計算基準利率２ = {}", pSuiihyou.getYtirrtcalckijyunrrt2());
        logger.debug("│ ★③：予定利率計算基準利率３ = {}", pSuiihyou.getYtirrtcalckijyunrrt3());
        logger.debug("│ ★①：前納残高（円貨）１ = {}", pSuiihyou.getZennouzndkyen1());
        logger.debug("│ ★②：前納残高（円貨）２ = {}", pSuiihyou.getZennouzndkyen2());
        logger.debug("│ ★③：前納残高（円貨）３ = {}", pSuiihyou.getZennouzndkyen3());
        logger.debug("│ ★①：既払込保険料（円貨）１ = {}", pSuiihyou.getKihrkmpyen1());
        logger.debug("│ ★②：既払込保険料（円貨）２ = {}", pSuiihyou.getKihrkmpyen2());
        logger.debug("│ ★③：既払込保険料（円貨）３ = {}", pSuiihyou.getKihrkmpyen3());
        logger.debug("│ ★①：既払込保険料１ = {}", pSuiihyou.getKihrkmp1());
        logger.debug("│ ★②：既払込保険料２ = {}", pSuiihyou.getKihrkmp2());
        logger.debug("│ ★③：既払込保険料３ = {}", pSuiihyou.getKihrkmp3());
        logger.debug("▲ 推移表TBLの設定値");
    }
}

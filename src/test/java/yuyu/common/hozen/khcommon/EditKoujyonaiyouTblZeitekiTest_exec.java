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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_ZeitekiHenkouSyoriKbn;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 税適特約変更時控除証明内容TBL編集クラスのメソッド {@link EditKoujyonaiyouTblZeiteki#exec(String, BizDate, C_ZeitekiHenkouSyoriKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKoujyonaiyouTblZeitekiTest_exec {

    @Inject
    private EditKoujyonaiyouTblZeiteki editKoujyonaiyouTblZeiteki;

    private final static String fileName = "UT_SP_単体テスト仕様書_税適特約変更時控除証明内容TBL編集";

    private final static String sheetName = "INデータ";

    private static final String SYONO_1 = "58807006679";

    private static final String SYONO_2 = "32810003205";

    private static final String SYONO_3 = "85809006671";

    private static final String SYONO_4 = "24809001459";

    private static final String SYONO_5 = "24809001460";

    private static final String SYONO_6 = "24809001471";

    private static final String SYONO_7 = "24809001482";

    private static final String SYONO_9 = "24809001493";

    private static final String SYONO_10 = "24809001518";

    private static final String SYONO_11 = "24809001529";

    private static final String SYONO_12 = "24809001530";

    private static final String SYONO_13 = "24809001541";

    private static final String SYONO_14 = "24809001552";

    private static final String SYONO_15 = "24809001563";

    private static final String SYONO_16 = "24809001574";

    private static final String SYONO_17 = "24809001585";

    private static final String SYONO_18 = "24809001596";

    private static final String SYONO_19 = "24809001611";

    private static final String SYONO_20 = "32806001635";

    private static final String SYONO_21 = "32806001624";

    private static final String SYONO_22 = "32810003238";

    private static final String SYONO_23 = "32810003227";

    private static final String SYONO_B1 = "32806001451";

    private static final String SYONO_B2 = "32806001462";

    private static final String SYONO_B3 = "32806001473";

    private static final String SYONO_B4 = "32806001484";

    private static final String SYONO_B5 = "32806001495";

    private static final String SYONO_C1 = "32806001509";

    private static final String SYONO_C2 = "32806001510";

    private static final String SYONO_C3 = "32806001521";

    private static final String SYONO_C4 = "32806001532";

    private static final String SYONO_C5 = "32806001543";

    private static final String SYONO_C6 = "32806001554";

    private static final String SYONO_C7 = "32806001565";

    private static final String SYONO_C8 = "32806001576";

    private static final String SYONO_C9 = "32810003146";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanZennouKoujyogaku.class).to(KeisanZennouKoujyogakuMockForKhansyuu.class);
                bind(KoujyoSyoumeiUtil.class).to(KoujyoSyoumeiUtilMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        KeisanZennouKoujyogakuMockForKhansyuu.caller = EditKoujyonaiyouTblZeitekiTest_exec.class;
        KoujyoSyoumeiUtilMockForKhansyuu.caller = EditKoujyonaiyouTblZeitekiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanZennouKoujyogakuMockForKhansyuu.caller = null;
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = null;
        KoujyoSyoumeiUtilMockForKhansyuu.caller = null;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKoujyonaiyouTblZeitekiTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        try {

            editKoujyonaiyouTblZeiteki.exec(SYONO_1, null, null);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。契約基本テーブルが取得できませんでした。"
                    + " 証券番号 ＝" + SYONO_1, "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        try {

            editKoujyonaiyouTblZeiteki.exec(SYONO_2, null, null);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "契約商品テーブルが取得できませんでした。"
                + " 証券番号 ＝ " + SYONO_2, "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        try {

            editKoujyonaiyouTblZeiteki.exec(SYONO_3, null, null);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "商品属性マスタが取得できませんでした。 証券番号 ＝ " + SYONO_3,
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_4,
            null, null);
        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU,
            "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.HUKA;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_5,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);
        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageLst().get(0), "2015年 7月保険料から個人年金保険料控除対象です。", "メッセージリスト");
        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageIdLst().get(0), MessageId.WIF3008, "メッセージIDリスト");
        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.WARNING, "チェック結果区分");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        try {

            editKoujyonaiyouTblZeiteki.exec(SYONO_6, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        } catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。税適特約変更時控除証明内容TBL編集エラー　表定Ｐ計算不能" ,"エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.HUKA;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_7,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_7);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou koujyoSymNaiyou = koujyoSymNaiyouList.get(0);
        exStringEquals(koujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyou.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyou.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201311), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyou.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyou.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouZen = koujyoSymNaiyouList.get(1);
        exStringEquals(koujyoSymNaiyouZen.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouZen.getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouZen.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouZen.getSyoumeistartym(), BizDateYM.valueOf(201311), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouZen.getSyoumeiendym(), BizDateYM.valueOf(201506), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouZen.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouZen.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouZen.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouZen.getKoujyosyoumeigk(), BizCurrency.valueOf(600000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouZen.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouZen.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouZen.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouZen.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouZen.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouZen.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouZen.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouZen.getKeisanhukariyuucd(), "", "計算不可理由コード");


        IT_KoujyoSymNaiyou koujyoSymNaiyouAto = koujyoSymNaiyouList.get(2);
        exStringEquals(koujyoSymNaiyouAto.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouAto.getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouAto.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouAto.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouAto.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouAto.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.NENKIN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouAto.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouAto.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouAto.getKoujyosyoumeigk(), BizCurrency.valueOf(210000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouAto.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouAto.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouAto.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouAto.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouAto.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouAto.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouAto.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouAto.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.WARNING, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150907);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_7, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageLst().get(0), "控除証明書発行済み契約です。控除証明書を再発行してください。", "メッセージリスト");
        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageIdLst().get(0), MessageId.WIF3009, "メッセージIDリスト");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.WARNING, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_9, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_10, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_10);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();


        IT_KoujyoSymNaiyou koujyosyoumeigk = koujyoSymNaiyouList.get(0);
        exStringEquals(koujyosyoumeigk.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyosyoumeigk.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyosyoumeigk.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyosyoumeigk.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyosyoumeigk.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyosyoumeigk.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyosyoumeigk.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyosyoumeigk.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyosyoumeigk.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyosyoumeigk.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyosyoumeigk.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyosyoumeigk.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyosyoumeigk.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyosyoumeigk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyosyoumeigk.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyosyoumeigk.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyosyoumeigk.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyosyoumeigk.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyosyoumeigk.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyosyoumeigkBwfy = koujyoSymNaiyouList.get(1);
        exStringEquals(koujyosyoumeigkBwfy.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyosyoumeigkBwfy.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyosyoumeigkBwfy.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyosyoumeigkBwfy.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyosyoumeigkBwfy.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyosyoumeigkBwfy.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyosyoumeigkBwfy.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyosyoumeigkBwfy.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyosyoumeigkBwfy.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyosyoumeigkBwfy.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyosyoumeigkBwfy.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyosyoumeigkBwfy.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyosyoumeigk.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyosyoumeigk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyosyoumeigkBwfy.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyosyoumeigkBwfy.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyosyoumeigkBwfy.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyosyoumeigkBwfy.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyosyoumeigkBwfy.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150607);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_11, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_11);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou koujyosyoumeigkBwfy_3 = koujyoSymNaiyouList.get(2);
        exNumericEquals(koujyosyoumeigkBwfy_3.getRenno3keta(), 3, "連番（３桁）");
        exClassificationEquals(koujyosyoumeigkBwfy_3.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exBizCalcbleEquals(koujyosyoumeigkBwfy_3.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150807);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_12, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_12);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyou = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyou.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyou.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyou.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouZen = koujyoSymNaiyouList.get(1);
        exStringEquals(zennoKoujyoSymNaiyouZen.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouZen.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouZen.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouZen.getSyoumeiendym(), BizDateYM.valueOf(201507), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouZen.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouZen.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouZen.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouZen.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouZen.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouZen.getKeisanhukariyuucd(), "", "計算不可理由コード");


        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouAto = koujyoSymNaiyouList.get(2);
        exStringEquals(zennoKoujyoSymNaiyouAto.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouAto.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouAto.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouAto.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouAto.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouAto.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouAto.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouAto.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouAto.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouAto.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_13, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_13);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyou = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyou.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyou.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyou.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouBwfy = koujyoSymNaiyouList.get(1);
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfy.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfy.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfy.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouBwfy.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_14, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_14);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou entity3 = koujyoSymNaiyouList.get(2);
        exNumericEquals(entity3.getRenno3keta(), 2, "連番（３桁）");
        exClassificationEquals(entity3.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");

        IT_KoujyoSymNaiyou entity4 = koujyoSymNaiyouList.get(3);
        exNumericEquals(entity4.getRenno3keta(), 3, "連番（３桁）");
        exClassificationEquals(entity4.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");

        IT_KoujyoSymNaiyou entity5 = koujyoSymNaiyouList.get(4);
        exNumericEquals(entity5.getRenno3keta(), 3, "連番（３桁）");
        exClassificationEquals(entity5.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");

        IT_KoujyoSymNaiyou entity6 = koujyoSymNaiyouList.get(5);
        exNumericEquals(entity6.getRenno3keta(), 4, "連番（３桁）");
        exClassificationEquals(entity6.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_15, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_15);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou entity3 = koujyoSymNaiyouList.get(2);
        exNumericEquals(entity3.getRenno3keta(), 2, "連番（３桁）");
        exClassificationEquals(entity3.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");

        IT_KoujyoSymNaiyou entity4 = koujyoSymNaiyouList.get(3);
        exNumericEquals(entity4.getRenno3keta(), 3, "連番（３桁）");
        exClassificationEquals(entity4.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");

        IT_KoujyoSymNaiyou entity5 = koujyoSymNaiyouList.get(4);
        exNumericEquals(entity5.getRenno3keta(), 3, "連番（３桁）");
        exClassificationEquals(entity5.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");

        IT_KoujyoSymNaiyou entity6 = koujyoSymNaiyouList.get(5);
        exNumericEquals(entity6.getRenno3keta(), 4, "連番（３桁）");
        exClassificationEquals(entity6.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20160707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_16, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_16);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou entity0 = koujyoSymNaiyouList.get(0);
        exStringEquals(entity0.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(entity0.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(entity0.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(entity0.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(entity0.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(entity0.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(entity0.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(entity0.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(entity0.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(entity0.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(entity0.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(entity0.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(entity0.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(entity0.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(entity0.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(entity0.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(entity0.getZennourenno(), 1, "前納連番");
        exClassificationEquals(entity0.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(entity0.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou entity2 = koujyoSymNaiyouList.get(1);
        exStringEquals(entity2.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(entity2.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(entity2.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(entity2.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(entity2.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(entity2.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(entity2.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(entity2.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(entity2.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(entity2.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(entity2.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(entity2.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(entity2.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(entity2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(entity2.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(entity2.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(entity2.getZennourenno(), 1, "前納連番");
        exClassificationEquals(entity2.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(entity2.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou entity1 = koujyoSymNaiyouList.get(2);
        exStringEquals(entity1.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(entity1.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(entity1.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(entity1.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(entity1.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(entity1.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(entity1.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(entity1.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(entity1.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(entity1.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(entity1.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(entity1.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(entity1.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(entity1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(entity1.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(entity1.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(entity1.getZennourenno(), 1, "前納連番");
        exClassificationEquals(entity1.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(entity1.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNyssZen = koujyoSymNaiyouList.get(3);
        exStringEquals(zennoKoujyoSymNyssZen.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNyssZen.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNyssZen.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNyssZen.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNyssZen.getSyoumeiendym(), BizDateYM.valueOf(201606), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNyssZen.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNyssZen.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNyssZen.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNyssZen.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNyssZen.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNyssZen.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNyssZen.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNyssZen.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNyssZen.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNyssZen.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNyssZen.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNyssZen.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNyssZen.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNyssZen.getKeisanhukariyuucd(), "RY01", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNyssAto = koujyoSymNaiyouList.get(4);
        exStringEquals(zennoKoujyoSymNyssAto.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNyssAto.getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNyssAto.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNyssAto.getSyoumeistartym(), BizDateYM.valueOf(201607), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNyssAto.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNyssAto.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNyssAto.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNyssAto.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNyssAto.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNyssAto.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNyssAto.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNyssAto.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNyssAto.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNyssAto.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNyssAto.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNyssAto.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNyssAto.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNyssAto.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNyssAto.getKeisanhukariyuucd(), "RY01", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20160707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_17, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_17);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou entity0 = koujyoSymNaiyouList.get(0);
        exStringEquals(entity0.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(entity0.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(entity0.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(entity0.getSyoumeistartym(), BizDateYM.valueOf(201607), "証明開始年月");
        exDateYMEquals(entity0.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(entity0.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(entity0.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(entity0.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(entity0.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(entity0.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(entity0.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(entity0.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(entity0.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(entity0.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(entity0.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(entity0.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(entity0.getZennourenno(), 1, "前納連番");
        exClassificationEquals(entity0.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(entity0.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou entity1 = koujyoSymNaiyouList.get(1);
        exStringEquals(entity1.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(entity1.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(entity1.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(entity1.getSyoumeistartym(), BizDateYM.valueOf(201607), "証明開始年月");
        exDateYMEquals(entity1.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(entity1.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(entity1.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(entity1.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(entity1.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(entity1.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(entity1.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(entity1.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(entity1.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(entity1.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(entity1.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(entity1.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(entity1.getZennourenno(), 1, "前納連番");
        exClassificationEquals(entity1.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(entity1.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou entity2 = koujyoSymNaiyouList.get(2);
        exStringEquals(entity2.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(entity2.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(entity2.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(entity2.getSyoumeistartym(), BizDateYM.valueOf(201607), "証明開始年月");
        exDateYMEquals(entity2.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(entity2.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(entity2.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(entity2.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(entity2.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(entity2.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(entity2.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(entity2.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(entity2.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(entity2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(entity2.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(entity2.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(entity2.getZennourenno(), 1, "前納連番");
        exClassificationEquals(entity2.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(entity2.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20160707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_18, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_18);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        IT_KoujyoSymNaiyou entity7 = koujyoSymNaiyouList.get(6);
        exClassificationEquals(entity7.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(entity7.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(entity7.getKeisanhukariyuucd(), "", "計算不可理由コード");
        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN2;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_19, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }


    @Test
    @Transactional
    @TestOrder(191)
    public void testExec_A20() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20151007);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.HUKA;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_20, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageLst().get(0), "2015年 1月保険料から個人年金保険料控除対象です。", "メッセージリスト");
        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageIdLst().get(0), MessageId.WIF3008, "メッセージIDリスト");

        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageLst().get(1), "控除証明書発行済み契約です。控除証明書を再発行してください。", "メッセージリスト");
        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageIdLst().get(1), MessageId.WIF3009, "メッセージIDリスト");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.WARNING, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(192)
    public void testExec_A21() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20151007);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.HUKA;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_21, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageLst().get(0), "2015年 9月保険料から個人年金保険料控除対象です。", "メッセージリスト");
        exStringEquals(editKoujyonaiyouTblZeiteki.getMessageIdLst().get(0), MessageId.WIF3008, "メッセージIDリスト");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.WARNING, "チェック結果区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(193)
    public void testExec_A22() {

        try {
            editKoujyonaiyouTblZeiteki.exec(SYONO_22, null, null);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "案内収納基本テーブルが取得できませんでした。 証券番号 ＝32810003238", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(194)
    public void testExec_A23() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_23, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_23);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 12, "要素数");

        exNumericEquals(koujyoSymNaiyouList.get(0).getRenno3keta(), 1, "連番（３桁）");
        exDateYMEquals(koujyoSymNaiyouList.get(0).getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exNumericEquals(koujyoSymNaiyouList.get(1).getRenno3keta(), 2, "連番（３桁）");
        exDateYMEquals(koujyoSymNaiyouList.get(1).getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exNumericEquals(koujyoSymNaiyouList.get(2).getRenno3keta(), 3, "連番（３桁）");
        exDateYMEquals(koujyoSymNaiyouList.get(2).getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exNumericEquals(koujyoSymNaiyouList.get(3).getRenno3keta(), 1, "連番（３桁）");
        exDateYMEquals(koujyoSymNaiyouList.get(3).getSyoumeistartym(), BizDateYM.valueOf(201506), "証明開始年月");
        exNumericEquals(koujyoSymNaiyouList.get(4).getRenno3keta(), 2, "連番（３桁）");
        exDateYMEquals(koujyoSymNaiyouList.get(4).getSyoumeistartym(), BizDateYM.valueOf(201506), "証明開始年月");

        exNumericEquals(koujyoSymNaiyouList.get(5).getRenno3keta(), 3, "連番（３桁）");
        exNumericEquals(koujyoSymNaiyouList.get(6).getRenno3keta(), 4, "連番（３桁）");
        exNumericEquals(koujyoSymNaiyouList.get(7).getRenno3keta(), 5, "連番（３桁）");
        exNumericEquals(koujyoSymNaiyouList.get(8).getRenno3keta(), 6, "連番（３桁）");

        exNumericEquals(koujyoSymNaiyouList.get(9).getRenno3keta(), 4, "連番（３桁）");
        exNumericEquals(koujyoSymNaiyouList.get(10).getRenno3keta(), 5, "連番（３桁）");
        exNumericEquals(koujyoSymNaiyouList.get(11).getRenno3keta(), 6, "連番（３桁）");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }


    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_B1() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20180801);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_B1,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_B1);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(editKoujyonaiyouTblZeiteki.getMessageLst().size(),0, "メッセージリスト");
        exNumericEquals(editKoujyonaiyouTblZeiteki.getMessageIdLst().size(),0, "メッセージIDリスト");
        exNumericEquals(koujyoSymNaiyouList.size(), 0, "要素数");
        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(201)
    public void testExec_B2() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_B2,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_B2);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 6, "要素数");

        IT_KoujyoSymNaiyou koujyoSymNaiyou = koujyoSymNaiyouList.get(0);

        exStringEquals(koujyoSymNaiyou.getKbnkey(), "06", "区分キー ");
        exStringEquals(koujyoSymNaiyou.getSyono(), SYONO_B2, "証券番号");
        exStringEquals(koujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyou.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyou.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201311), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyou.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyou.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouZen = koujyoSymNaiyouList.get(4);
        exStringEquals(koujyoSymNaiyouZen.getKbnkey(), "06", "区分キー ");
        exStringEquals(koujyoSymNaiyouZen.getSyono(), SYONO_B2, "証券番号");
        exStringEquals(koujyoSymNaiyouZen.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouZen.getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouZen.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouZen.getSyoumeistartym(), BizDateYM.valueOf(201311), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouZen.getSyoumeiendym(), BizDateYM.valueOf(201506), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouZen.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouZen.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouZen.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouZen.getKoujyosyoumeigk(), BizCurrency.valueOf(600000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouZen.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouZen.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouZen.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouZen.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouZen.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouZen.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouZen.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouZen.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouZen.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouZen.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouAto = koujyoSymNaiyouList.get(5);
        exStringEquals(koujyoSymNaiyouAto.getKbnkey(), "06", "区分キー ");
        exStringEquals(koujyoSymNaiyouAto.getSyono(), SYONO_B2, "証券番号");
        exStringEquals(koujyoSymNaiyouAto.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouAto.getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouAto.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouAto.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouAto.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouAto.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouAto.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouAto.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouAto.getKoujyosyoumeigk(), BizCurrency.valueOf(210000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouAto.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouAto.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouAto.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouAto.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouAto.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouAto.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouAto.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouAto.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouAto.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouAto.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(202)
    public void testExec_B3() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_B3,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_B3);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 6, "要素数");

        IT_KoujyoSymNaiyou koujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);

        exStringEquals(koujyoSymNaiyouOne.getKbnkey(), "07", "区分キー ");
        exStringEquals(koujyoSymNaiyouOne.getSyono(), SYONO_B3, "証券番号");
        exStringEquals(koujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201311), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouTwo = koujyoSymNaiyouList.get(1);

        exStringEquals(koujyoSymNaiyouTwo.getKbnkey(), "07", "区分キー ");
        exStringEquals(koujyoSymNaiyouTwo.getSyono(), SYONO_B3, "証券番号");
        exStringEquals(koujyoSymNaiyouTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouTwo.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouTwo.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeistartym(), BizDateYM.valueOf(201312), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeiendym(), BizDateYM.valueOf(201602), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(1620000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouTwo.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouTwo.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouTwo.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouTwo.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouTwo.getZennoukaisiymd(), BizDate.valueOf(20150802), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouTwo.getZennourenno(), 2, "前納連番");
        exClassificationEquals(koujyoSymNaiyouTwo.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouTwo.getKeisanhukariyuucd(), "r10", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouZenOne = koujyoSymNaiyouList.get(2);
        exStringEquals(koujyoSymNaiyouZenOne.getKbnkey(), "07", "区分キー ");
        exStringEquals(koujyoSymNaiyouZenOne.getSyono(), SYONO_B3, "証券番号");
        exStringEquals(koujyoSymNaiyouZenOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouZenOne.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouZenOne.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouZenOne.getSyoumeistartym(), BizDateYM.valueOf(201311), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouZenOne.getSyoumeiendym(), BizDateYM.valueOf(201506), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouZenOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouZenOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouZenOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouZenOne.getKoujyosyoumeigk(), BizCurrency.valueOf(600000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouZenOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouZenOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouZenOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouZenOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouZenOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouZenOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouZenOne.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouZenOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouZenOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouZenOne.getKeisanhukariyuucd(), "", "計算不可理由コード");


        IT_KoujyoSymNaiyou koujyoSymNaiyouZenTwo = koujyoSymNaiyouList.get(3);
        exStringEquals(koujyoSymNaiyouZenTwo.getKbnkey(), "07", "区分キー ");
        exStringEquals(koujyoSymNaiyouZenTwo.getSyono(), SYONO_B3, "証券番号");
        exStringEquals(koujyoSymNaiyouZenTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouZenTwo.getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouZenTwo.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouZenTwo.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouZenTwo.getSyoumeiendym(), BizDateYM.valueOf(201601), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouZenTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouZenTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouZenTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouZenTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(210000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouZenTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouZenTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouZenTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouZenTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouZenTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouZenTwo.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouZenTwo.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouZenTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouZenTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouZenTwo.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouAtoOne = koujyoSymNaiyouList.get(4);
        exStringEquals(koujyoSymNaiyouAtoOne.getKbnkey(), "07", "区分キー ");
        exStringEquals(koujyoSymNaiyouAtoOne.getSyono(), SYONO_B3, "証券番号");
        exStringEquals(koujyoSymNaiyouAtoOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouAtoOne.getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouAtoOne.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouAtoOne.getSyoumeistartym(), BizDateYM.valueOf(201312), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouAtoOne.getSyoumeiendym(), BizDateYM.valueOf(201506), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouAtoOne.getKoujyosyoumeigk(), BizCurrency.valueOf(1140000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouAtoOne.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouAtoOne.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouAtoOne.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouAtoOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouAtoOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouAtoOne.getZennoukaisiymd(), BizDate.valueOf(20150802), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouAtoOne.getZennourenno(), 2, "前納連番");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouAtoOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouAtoTwo = koujyoSymNaiyouList.get(5);
        exStringEquals(koujyoSymNaiyouAtoTwo.getKbnkey(), "07", "区分キー ");
        exStringEquals(koujyoSymNaiyouAtoTwo.getSyono(), SYONO_B3, "証券番号");
        exStringEquals(koujyoSymNaiyouAtoTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouAtoTwo.getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouAtoTwo.getKoujyosyoumeinnd(), "2013", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouAtoTwo.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouAtoTwo.getSyoumeiendym(), BizDateYM.valueOf(201602), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouAtoTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouAtoTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouAtoTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouAtoTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(480000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouAtoTwo.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouAtoTwo.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouAtoTwo.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouAtoTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouAtoTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouAtoTwo.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouAtoTwo.getZennoukaisiymd(), BizDate.valueOf(20150802), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouAtoTwo.getZennourenno(), 2, "前納連番");
        exClassificationEquals(koujyoSymNaiyouAtoTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouAtoTwo.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(203)
    public void testExec_B4() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_B4, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_B4);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 2, "要素数");

        IT_KoujyoSymNaiyou koujyoSymNaiyou = koujyoSymNaiyouList.get(0);
        exStringEquals(koujyoSymNaiyou.getKbnkey(), "08", "区分キー ");
        exStringEquals(koujyoSymNaiyou.getSyono(), SYONO_B4, "証券番号");
        exStringEquals(koujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyou.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyou.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyou.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyou.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouBwfy = koujyoSymNaiyouList.get(1);
        exStringEquals(koujyoSymNaiyouBwfy.getKbnkey(), "08", "区分キー ");
        exStringEquals(koujyoSymNaiyouBwfy.getSyono(), SYONO_B4, "証券番号");
        exStringEquals(koujyoSymNaiyouBwfy.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouBwfy.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouBwfy.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouBwfy.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouBwfy.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouBwfy.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouBwfy.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouBwfy.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouBwfy.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouBwfy.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouBwfy.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouBwfy.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouBwfy.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouBwfy.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouBwfy.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouBwfy.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouBwfy.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouBwfy.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouBwfy.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @Test
    @Transactional
    @TestOrder(204)
    public void testExec_B5() {

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_B5, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_B5);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 6, "要素数");

        IT_KoujyoSymNaiyou koujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);
        exStringEquals(koujyoSymNaiyouOne.getKbnkey(), "09", "区分キー ");
        exStringEquals(koujyoSymNaiyouOne.getSyono(), SYONO_B5, "証券番号");
        exStringEquals(koujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(1620000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouTwo = koujyoSymNaiyouList.get(1);
        exStringEquals(koujyoSymNaiyouTwo.getKbnkey(), "09", "区分キー ");
        exStringEquals(koujyoSymNaiyouTwo.getSyono(), SYONO_B5, "証券番号");
        exStringEquals(koujyoSymNaiyouTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouTwo.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouTwo.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeiendym(), BizDateYM.valueOf(201608), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(2430000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouTwo.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouTwo.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouTwo.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouTwo.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouTwo.getZennoukaisiymd(), BizDate.valueOf(20150802), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouTwo.getZennourenno(), 2, "前納連番");
        exClassificationEquals(koujyoSymNaiyouTwo.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouTwo.getKeisanhukariyuucd(), "r10", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouBwfyOne = koujyoSymNaiyouList.get(2);
        exStringEquals(koujyoSymNaiyouBwfyOne.getKbnkey(), "09", "区分キー ");
        exStringEquals(koujyoSymNaiyouBwfyOne.getSyono(), SYONO_B5, "証券番号");
        exStringEquals(koujyoSymNaiyouBwfyOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouBwfyOne.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouBwfyOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouBwfyOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouBwfyOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouBwfyOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouBwfyOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouBwfyOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouBwfyOne.getKoujyosyoumeigk(), BizCurrency.valueOf(1620000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouBwfyOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouBwfyOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouBwfyOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouBwfyOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouBwfyOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouBwfyOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouBwfyOne.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouBwfyOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouBwfyOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouBwfyOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouBwfyTwo = koujyoSymNaiyouList.get(3);
        exStringEquals(koujyoSymNaiyouBwfyTwo.getKbnkey(), "09", "区分キー ");
        exStringEquals(koujyoSymNaiyouBwfyTwo.getSyono(), SYONO_B5, "証券番号");
        exStringEquals(koujyoSymNaiyouBwfyTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouBwfyTwo.getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouBwfyTwo.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouBwfyTwo.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouBwfyTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouBwfyTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouBwfyTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouBwfyTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouBwfyTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(1620000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouBwfyTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouBwfyTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouBwfyTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouBwfyTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouBwfyTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouBwfyTwo.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouBwfyTwo.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouBwfyTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouBwfyTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouBwfyTwo.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouBwfyThree = koujyoSymNaiyouList.get(4);
        exStringEquals(koujyoSymNaiyouBwfyThree.getKbnkey(), "09", "区分キー ");
        exStringEquals(koujyoSymNaiyouBwfyThree.getSyono(), SYONO_B5, "証券番号");
        exStringEquals(koujyoSymNaiyouBwfyThree.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouBwfyThree.getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouBwfyThree.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouBwfyThree.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouBwfyThree.getSyoumeiendym(), BizDateYM.valueOf(201608), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouBwfyThree.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouBwfyThree.getTekiyouseidokbn(),C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouBwfyThree.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouBwfyThree.getKoujyosyoumeigk(), BizCurrency.valueOf(2430000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouBwfyThree.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouBwfyThree.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouBwfyThree.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouBwfyThree.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouBwfyThree.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouBwfyThree.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouBwfyThree.getZennoukaisiymd(), BizDate.valueOf(20150802), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouBwfyThree.getZennourenno(), 2, "前納連番");
        exClassificationEquals(koujyoSymNaiyouBwfyThree.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouBwfyThree.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouBwfyFour = koujyoSymNaiyouList.get(5);
        exStringEquals(koujyoSymNaiyouBwfyFour.getKbnkey(), "09", "区分キー ");
        exStringEquals(koujyoSymNaiyouBwfyFour.getSyono(), SYONO_B5, "証券番号");
        exStringEquals(koujyoSymNaiyouBwfyFour.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouBwfyFour.getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouBwfyFour.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouBwfyFour.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouBwfyFour.getSyoumeiendym(), BizDateYM.valueOf(201608), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouBwfyFour.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouBwfyFour.getTekiyouseidokbn(),C_TekiyouseidoKbn.NEWSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouBwfyFour.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouBwfyFour.getKoujyosyoumeigk(), BizCurrency.valueOf(2430000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouBwfyFour.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouBwfyFour.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouBwfyFour.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouBwfyFour.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouBwfyFour.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouBwfyFour.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouBwfyFour.getZennoukaisiymd(), BizDate.valueOf(20150802), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouBwfyFour.getZennourenno(), 2, "前納連番");
        exClassificationEquals(koujyoSymNaiyouBwfyFour.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouBwfyFour.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_C1() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150807);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C1,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C1);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 20, "要素数");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyou = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyou.getKbnkey(), "00", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyou.getSyono(), SYONO_C1, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyou.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201501), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201612), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyou.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyou.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouZen = koujyoSymNaiyouList.get(8);
        exStringEquals(zennoKoujyoSymNaiyouZen.getKbnkey(), "00", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouZen.getSyono(), SYONO_C1, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouZen.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouZen.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouZen.getSyoumeistartym(), BizDateYM.valueOf(201501), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouZen.getSyoumeiendym(), BizDateYM.valueOf(201507), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouZen.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouZen.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouZen.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouZen.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouZen.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouZen.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouZen.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouZen.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouAto = koujyoSymNaiyouList.get(9);
        exStringEquals(zennoKoujyoSymNaiyouAto.getKbnkey(), "00", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouAto.getSyono(), SYONO_C1, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouAto.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouAto.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouAto.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouAto.getSyoumeiendym(), BizDateYM.valueOf(201612), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouAto.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouAto.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouAto.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouAto.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouAto.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouAto.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouAto.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouAto.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の１次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "20", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20150805), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), BizCurrency.valueOf(300000), "前納控除証明額計算の１次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4), C_Hrkkaisuu.HALFY, "前納控除証明額計算の１次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201501), "前納控除証明額計算の１次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6), 0, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7), 7, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.IPPAN, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C1, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> KhShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(251)
    public void testExec_C2() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C2, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C2);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();


        exNumericEquals(koujyoSymNaiyouList.size(), 6, "要素数");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyouOne.getKbnkey(), "01", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyono(), SYONO_C2, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201501), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouTwo = koujyoSymNaiyouList.get(1);
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKbnkey(), "01", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getSyono(), SYONO_C2, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getSyoumeistartym(), BizDateYM.valueOf(201501), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouTwo.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKeisanhukariyuucd(), "r10", "計算不可理由コード");


        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouZenOne = koujyoSymNaiyouList.get(2);
        exStringEquals(zennoKoujyoSymNaiyouZenOne.getKbnkey(), "01", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouZenOne.getSyono(), SYONO_C2, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouZenOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouZenOne.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouZenOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouZenOne.getSyoumeistartym(), BizDateYM.valueOf(201501), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouZenOne.getSyoumeiendym(), BizDateYM.valueOf(201506), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouZenOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZenOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZenOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouZenOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouZenOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouZenOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouZenOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouZenOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouZenOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouZenOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouZenOne.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouZenOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouZenOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouZenOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouZenTwo = koujyoSymNaiyouList.get(3);
        exStringEquals(zennoKoujyoSymNaiyouZenTwo.getKbnkey(), "01", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouZenTwo.getSyono(), SYONO_C2, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouZenTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouZenTwo.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouZenTwo.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouZenTwo.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouZenTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouZenTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZenTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouZenTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouZenTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouZenTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouZenTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouZenTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouZenTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouZenTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouZenTwo.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouZenTwo.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouZenTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouZenTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouZenTwo.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouAtoOne = koujyoSymNaiyouList.get(4);
        exStringEquals(zennoKoujyoSymNaiyouAtoOne.getKbnkey(), "01", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouAtoOne.getSyono(), SYONO_C2, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouAtoOne.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouAtoOne.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouAtoOne.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouAtoOne.getSyoumeistartym(), BizDateYM.valueOf(201501), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouAtoOne.getSyoumeiendym(), BizDateYM.valueOf(201506), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouAtoOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouAtoOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouAtoOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouAtoOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouAtoOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouAtoOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouAtoOne.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouAtoOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouAtoOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouAtoTwo = koujyoSymNaiyouList.get(5);
        exStringEquals(zennoKoujyoSymNaiyouAtoTwo.getKbnkey(), "01", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouAtoTwo.getSyono(), SYONO_C2, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouAtoTwo.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouAtoTwo.getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouAtoTwo.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouAtoTwo.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouAtoTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouAtoTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouAtoTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouAtoTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouAtoTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouAtoTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouAtoTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoTwo.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouAtoTwo.getZennoukaisiymd(), BizDate.valueOf(20150801), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouAtoTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouAtoTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouAtoTwo.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の１次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "20", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20150805), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), BizCurrency.valueOf(400000), "前納控除証明額計算の１次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4), C_Hrkkaisuu.HALFY, "前納控除証明額計算の１次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201501), "前納控除証明額計算の１次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6), 0, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7), 6, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の２次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 1), "20", "前納控除証明額計算の２次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 2), BizDate.valueOf(20150805), "前納控除証明額計算の２次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 3), BizCurrency.valueOf(400000), "前納控除証明額計算の２次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 4), C_Hrkkaisuu.HALFY, "前納控除証明額計算の２次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 5), BizDateYM.valueOf(201507), "前納控除証明額計算の２次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 6), 0, "前納控除証明額計算の２次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 7), 13, "前納控除証明額計算の２次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.IPPAN, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C2, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の２次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の２次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList2 = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList2.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyono(), SYONO_C2, "証券番号");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> KhShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 0), "MD11", "前納控除証明額計算の２次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 1), "1", "前納控除証明額計算の２次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> KhShgtZennouKoujyogakuBeanList2 = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 2);
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getSyouhnsdno(),"1", "商品世代番号");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(252)
    public void testExec_C3() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C3, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C3);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 2, "要素数");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyou = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyou.getKbnkey(), "02", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyou.getSyono(), SYONO_C3, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyou.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyou.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyou.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouBwfy = koujyoSymNaiyouList.get(1);
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getKbnkey(), "02", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getSyono(), SYONO_C3, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfy.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfy.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouBwfy.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfy.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouBwfy.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouBwfy.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfy.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouBwfy.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の１次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "20", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20150805), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), BizCurrency.valueOf(300000), "前納控除証明額計算の１次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4), C_Hrkkaisuu.HALFY, "前納控除証明額計算の１次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201512), "前納控除証明額計算の１次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6), 0, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7), 8, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C3, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> KhShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(253)
    public void testExec_C4() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C4, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C4);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 4, "要素数");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyouOne.getKbnkey(), "03", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyono(), SYONO_C4, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");


        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouTwo = koujyoSymNaiyouList.get(1);
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKbnkey(), "03", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getSyono(), SYONO_C4, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(1620000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouTwo.getZennoukaisiymd(), BizDate.valueOf(20141226), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getZennourenno(), 2, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKeisanhukariyuucd(), "r10", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouBwfyOne = koujyoSymNaiyouList.get(2);
        exStringEquals(zennoKoujyoSymNaiyouBwfyOne.getKbnkey(), "03", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouBwfyOne.getSyono(), SYONO_C4, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouBwfyOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyOne.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouBwfyOne.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfyOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfyOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouBwfyOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfyOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouBwfyOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouBwfyOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouBwfyOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouBwfyOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouBwfyTwo = koujyoSymNaiyouList.get(3);
        exStringEquals(zennoKoujyoSymNaiyouBwfyTwo.getKbnkey(), "03", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouBwfyTwo.getSyono(), SYONO_C4, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouBwfyTwo.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyTwo.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouBwfyTwo.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfyTwo.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfyTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouBwfyTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouBwfyTwo.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyTwo.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyTwo.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouBwfyTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouBwfyTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyTwo.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouBwfyTwo.getZennoukaisiymd(), BizDate.valueOf(20141226), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouBwfyTwo.getZennourenno(), 2, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouBwfyTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouBwfyTwo.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の１次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "20", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20150805), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), BizCurrency.valueOf(300000), "前納控除証明額計算の１次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4), C_Hrkkaisuu.HALFY, "前納控除証明額計算の１次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201507), "前納控除証明額計算の１次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6), 0, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7), 13, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の２次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 1), "20", "前納控除証明額計算の２次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 2), BizDate.valueOf(20150805), "前納控除証明額計算の２次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 3), BizCurrency.valueOf(500000), "前納控除証明額計算の２次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 4), C_Hrkkaisuu.HALFY, "前納控除証明額計算の２次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 5), BizDateYM.valueOf(201512), "前納控除証明額計算の２次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 6), 0, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 1, 7), 8, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C4, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の２次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の２次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList2 = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 2);
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList2.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyono(), SYONO_C4, "証券番号");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> KhShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 0), "MD12", "前納控除証明額計算の２次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 1), "2", "前納控除証明額計算の２次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> KhShgtZennouKoujyogakuBeanList2 = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 2);
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBeanList2.get(0).getSyouhnsdno(),"1", "商品世代番号");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(254)
    public void testExec_C5() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150807);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C5,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C5);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 13, "要素数");

        IT_KoujyoSymNaiyou koujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);
        exStringEquals(koujyoSymNaiyouOne.getKbnkey(), "04", "区分キー ");
        exStringEquals(koujyoSymNaiyouOne.getSyono(), SYONO_C5, "証券番号");
        exStringEquals(koujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2430000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouTwo = koujyoSymNaiyouList.get(1);
        exStringEquals(koujyoSymNaiyouTwo.getKbnkey(), "04", "区分キー ");
        exStringEquals(koujyoSymNaiyouTwo.getSyono(), SYONO_C5, "証券番号");
        exStringEquals(koujyoSymNaiyouTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouTwo.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouTwo.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeiendym(), BizDateYM.valueOf(201508), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouTwo.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouTwo.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouTwo.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou seisanzenEntityOne = koujyoSymNaiyouList.get(6);
        exStringEquals(seisanzenEntityOne.getKbnkey(), "04", "区分キー ");
        exStringEquals(seisanzenEntityOne.getSyono(), SYONO_C5, "証券番号");
        exStringEquals(seisanzenEntityOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(seisanzenEntityOne.getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(seisanzenEntityOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(seisanzenEntityOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(seisanzenEntityOne.getSyoumeiendym(), BizDateYM.valueOf(201507), "証明終了年月");
        exClassificationEquals(seisanzenEntityOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(seisanzenEntityOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(seisanzenEntityOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(seisanzenEntityOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(seisanzenEntityOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(seisanzenEntityOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(seisanzenEntityOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(seisanzenEntityOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(seisanzenEntityOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(seisanzenEntityOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(seisanzenEntityOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(seisanzenEntityOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(seisanzenEntityOne.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(seisanzenEntityOne.getKeisanhukariyuucd(), "RY01", "計算不可理由コード");

        IT_KoujyoSymNaiyou seisanatoEntityOne = koujyoSymNaiyouList.get(7);
        exStringEquals(seisanatoEntityOne.getKbnkey(), "04", "区分キー ");
        exStringEquals(seisanatoEntityOne.getSyono(), SYONO_C5, "証券番号");
        exStringEquals(seisanatoEntityOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(seisanatoEntityOne.getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(seisanatoEntityOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(seisanatoEntityOne.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(seisanatoEntityOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(seisanatoEntityOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(seisanatoEntityOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(seisanatoEntityOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(seisanatoEntityOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(seisanatoEntityOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(seisanatoEntityOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(seisanatoEntityOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(seisanatoEntityOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(seisanatoEntityOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(seisanatoEntityOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(seisanatoEntityOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(seisanatoEntityOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(seisanatoEntityOne.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(seisanatoEntityOne.getKeisanhukariyuucd(), "RY01", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouZenOne = koujyoSymNaiyouList.get(8);
        exStringEquals(koujyoSymNaiyouZenOne.getKbnkey(), "04", "区分キー ");
        exStringEquals(koujyoSymNaiyouZenOne.getSyono(), SYONO_C5, "証券番号");
        exStringEquals(koujyoSymNaiyouZenOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouZenOne.getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouZenOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouZenOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouZenOne.getSyoumeiendym(), BizDateYM.valueOf(201507), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouZenOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouZenOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouZenOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouZenOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouZenOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouZenOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouZenOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouZenOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouZenOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouZenOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouZenOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouZenOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouZenOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouZenOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouAtoOne = koujyoSymNaiyouList.get(9);
        exStringEquals(koujyoSymNaiyouAtoOne.getKbnkey(), "04", "区分キー ");
        exStringEquals(koujyoSymNaiyouAtoOne.getSyono(), SYONO_C5, "証券番号");
        exStringEquals(koujyoSymNaiyouAtoOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouAtoOne.getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouAtoOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouAtoOne.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouAtoOne.getSyoumeiendym(), BizDateYM.valueOf(201508), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouAtoOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouAtoOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouAtoOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouAtoOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouAtoOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouAtoOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouAtoOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouAtoOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouAtoOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouAtoOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の１次呼出の控除証明用前納入金額");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 1), "20", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 2), BizDate.valueOf(20150805), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 3), BizCurrency.valueOf(300000), "前納控除証明額計算の１次呼出の払込保険料");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 4), C_Hrkkaisuu.HALFY, "前納控除証明額計算の１次呼出の払込回数");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 5), BizDateYM.valueOf(201507), "前納控除証明額計算の１次呼出の証明開始年月");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 6), 0, "前納控除証明額計算の１次呼出の証明回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getZennouKoujyogaku", 0, 7), 1, "前納控除証明額計算の１次呼出の証明回数（月）");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(0), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.IPPAN, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C5, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> KhShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(KhShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(KhShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");


        List<KykSyouhnCommonParam> kykSyouhnCommonParamList3 = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KoujyoSyoumeiUtilMockForKhansyuu.class, "sumSyouhnp", 0, 0);

        exClassificationEquals(kykSyouhnCommonParamList3.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList3.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnCommonParamList3.get(0).getSyouhnsdno(), 2, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList3.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList3.get(0).getHknkkn(), 12, "保険期間");
        exStringEquals(kykSyouhnCommonParamList3.get(0).getSyono(), SYONO_C5, "証券番号");
        exStringEquals(kykSyouhnCommonParamList3.get(0).getHenkousikibetukey(), "m8888", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList3.get(0).getSyouhncd(), "MD11", "商品コード");

        IT_KykKihon kykKihonParam = (IT_KykKihon)
            MockObjectManager.getArgument(KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 0);

        exStringEquals(kykKihonParam.getSyono(), SYONO_C5, "証券番号");
        exClassificationEquals(kykKihonParam.getHrkkaisuu(),C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(kykKihonParam.getHaitoukinuketorihoukbn(),C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");

        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 1), BizDateYM.valueOf(201507), "月払前納指定期間中精算チェックの１次呼出の証明開始年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 2), BizDateYM.valueOf(201508), "月払前納指定期間中精算チェックの１次呼出の証明終了年月");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(255)
    public void testExec_C6() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150807);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C6,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C6);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 5, "要素数");

        IT_KoujyoSymNaiyou koujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);
        exStringEquals(koujyoSymNaiyouOne.getKbnkey(), "05", "区分キー ");
        exStringEquals(koujyoSymNaiyouOne.getSyono(), SYONO_C6, "証券番号");
        exStringEquals(koujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2430000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouTwo = koujyoSymNaiyouList.get(1);
        exStringEquals(koujyoSymNaiyouTwo.getKbnkey(), "05", "区分キー ");
        exStringEquals(koujyoSymNaiyouTwo.getSyono(), SYONO_C6, "証券番号");
        exStringEquals(koujyoSymNaiyouTwo.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(koujyoSymNaiyouTwo.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouTwo.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.HKRNK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouTwo.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(koujyoSymNaiyouTwo.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(koujyoSymNaiyouTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouTwo.getKeisanhukariyuucd(), "r1", "計算不可理由コード");

        IT_KoujyoSymNaiyou koujyoSymNaiyouThree = koujyoSymNaiyouList.get(2);
        exStringEquals(koujyoSymNaiyouThree.getKbnkey(), "05", "区分キー ");
        exStringEquals(koujyoSymNaiyouThree.getSyono(), SYONO_C6, "証券番号");
        exStringEquals(koujyoSymNaiyouThree.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(koujyoSymNaiyouThree.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(koujyoSymNaiyouThree.getKoujyosyoumeinnd(), "2015", "控除証明年度");
        exDateYMEquals(koujyoSymNaiyouThree.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(koujyoSymNaiyouThree.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(koujyoSymNaiyouThree.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(koujyoSymNaiyouThree.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(koujyoSymNaiyouThree.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(koujyoSymNaiyouThree.getKoujyosyoumeigk(), BizCurrency.valueOf(1620000), "控除証明額");
        exDateYMEquals(koujyoSymNaiyouThree.getJyutoustartym(), BizDateYM.valueOf(201407), "充当開始年月");
        exNumericEquals(koujyoSymNaiyouThree.getNyknjskrrkrenno(), 2, "入金実績履歴連番");
        exNumericEquals(koujyoSymNaiyouThree.getKihrkpssrrkrenno(), 2, "既払込Ｐ精算履歴連番");
        exStringEquals(koujyoSymNaiyouThree.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(koujyoSymNaiyouThree.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(koujyoSymNaiyouThree.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(koujyoSymNaiyouThree.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(koujyoSymNaiyouThree.getZennourenno(), 2, "前納連番");
        exClassificationEquals(koujyoSymNaiyouThree.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(koujyoSymNaiyouThree.getKeisanhukariyuucd(), "r0", "計算不可理由コード");

        IT_KoujyoSymNaiyou seisanzenEntityOne = koujyoSymNaiyouList.get(3);
        exStringEquals(seisanzenEntityOne.getKbnkey(), "05", "区分キー ");
        exStringEquals(seisanzenEntityOne.getSyono(), SYONO_C6, "証券番号");
        exStringEquals(seisanzenEntityOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(seisanzenEntityOne.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(seisanzenEntityOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(seisanzenEntityOne.getSyoumeistartym(), BizDateYM.valueOf(201507), "証明開始年月");
        exDateYMEquals(seisanzenEntityOne.getSyoumeiendym(), BizDateYM.valueOf(201507), "証明終了年月");
        exClassificationEquals(seisanzenEntityOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(seisanzenEntityOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(seisanzenEntityOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(seisanzenEntityOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(seisanzenEntityOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(seisanzenEntityOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(seisanzenEntityOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(seisanzenEntityOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(seisanzenEntityOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(seisanzenEntityOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(seisanzenEntityOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(seisanzenEntityOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(seisanzenEntityOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(seisanzenEntityOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        IT_KoujyoSymNaiyou seisanatoEntityOne = koujyoSymNaiyouList.get(4);
        exStringEquals(seisanatoEntityOne.getKbnkey(), "05", "区分キー ");
        exStringEquals(seisanatoEntityOne.getSyono(), SYONO_C6, "証券番号");
        exStringEquals(seisanatoEntityOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(seisanatoEntityOne.getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(seisanatoEntityOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(seisanatoEntityOne.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(seisanatoEntityOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(seisanatoEntityOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(seisanatoEntityOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(seisanatoEntityOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(seisanatoEntityOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(seisanatoEntityOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(seisanatoEntityOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(seisanatoEntityOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(seisanatoEntityOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(seisanatoEntityOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(seisanatoEntityOne.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(seisanatoEntityOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(seisanatoEntityOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(seisanatoEntityOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(seisanatoEntityOne.getKeisanhukariyuucd(), "", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");


        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(7800), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.IPPAN, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C6, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 0), BizCurrency.valueOf(7800), "前納控除証明額計算の２次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の２次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList2 = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 2);
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList2.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyono(), SYONO_C6, "証券番号");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 0), "MD11", "前納控除証明額計算の２次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 1), "1", "前納控除証明額計算の２次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList2 = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 2);
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList2.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList2.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(khShgtZennouKoujyogakuBeanList2.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList2.get(0).getSyouhnsdno(),"1", "商品世代番号");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の１次呼出の変更前控除証明用前納入金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 1), BizCurrency.valueOf(100000), "前納控除証明額計算の１次呼出の変更後控除証明用前納入金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 2), BizCurrency.valueOf(350000), "前納控除証明額計算の１次呼出の変更前払込保険料");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 3), BizCurrency.valueOf(350000), "前納控除証明額計算の１次呼出の変更後払込保険料");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 4), BizDate.valueOf(20150805), "前納控除証明額計算の１次呼出の控除証明用前納開始年月日");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 5), "20", "前納控除証明額計算の１次呼出の控除証明用前納期間（月）");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 6), BizDateYM.valueOf(201507), "前納控除証明額計算の１次呼出の証明開始年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 7), BizDateYM.valueOf(201507), "前納控除証明額計算の１次呼出の証明終了年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 0, 8), BizDateYM.valueOf(201507), "前納控除証明額計算の１次呼出の精算開始年月");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 0), BizCurrency.valueOf(100000), "前納控除証明額計算の２次呼出の変更前控除証明用前納入金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 1), BizCurrency.valueOf(100000), "前納控除証明額計算の２次呼出の変更後控除証明用前納入金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 2), BizCurrency.valueOf(350000), "前納控除証明額計算の２次呼出の変更前払込保険料");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 3), BizCurrency.valueOf(350000), "前納控除証明額計算の２次呼出の変更後払込保険料");
        exDateEquals((BizDate)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 4), BizDate.valueOf(20150805), "前納控除証明額計算の２次呼出の控除証明用前納開始年月日");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 5), "20", "前納控除証明額計算の２次呼出の控除証明用前納期間（月）");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 6), BizDateYM.valueOf(201508), "前納控除証明額計算の２次呼出の証明開始年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 7), BizDateYM.valueOf(201607), "前納控除証明額計算の２次呼出の証明終了年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "keisanTukiZennouGngk", 1, 8), BizDateYM.valueOf(201508), "前納控除証明額計算の２次呼出の精算開始年月");


        List<KykSyouhnCommonParam> kykSyouhnCommonParamList3 = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KoujyoSyoumeiUtilMockForKhansyuu.class, "sumSyouhnp", 0, 0);

        exClassificationEquals(kykSyouhnCommonParamList3.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList3.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnCommonParamList3.get(0).getSyouhnsdno(), 2, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList3.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exBizCalcbleEquals(kykSyouhnCommonParamList3.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exBizCalcbleEquals(kykSyouhnCommonParamList3.get(0).getKihons(), BizCurrency.valueOf(1000), "基本Ｓ");
        exStringEquals(kykSyouhnCommonParamList3.get(0).getSyono(), SYONO_C6, "証券番号");
        exStringEquals(kykSyouhnCommonParamList3.get(0).getHenkousikibetukey(), "m9526", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList3.get(0).getSyouhncd(), "MD11", "商品コード");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList4 = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KoujyoSyoumeiUtilMockForKhansyuu.class, "sumSyouhnp", 1, 0);

        exClassificationEquals(kykSyouhnCommonParamList4.get(1).getSyutkkbn(),C_SyutkKbn.TK, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList4.get(1).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList4.get(1).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList4.get(1).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList4.get(1).getSyouhnsdno(), 2, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList4.get(1).getKyksyouhnrenno(), 2, "契約商品連番");
        exStringEquals(kykSyouhnCommonParamList4.get(1).getSyono(), SYONO_C6, "証券番号");
        exStringEquals(kykSyouhnCommonParamList4.get(1).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList4.get(1).getSyouhncd(), "MD12", "商品コード");

        IT_KykKihon kykKihonParam = (IT_KykKihon)
            MockObjectManager.getArgument(KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 0);

        exStringEquals(kykKihonParam.getSyono(), SYONO_C6, "証券番号");
        exClassificationEquals(kykKihonParam.getHrkkaisuu(),C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(kykKihonParam.getHaitoukinuketorihoukbn(),C_HaitoukinuketorihouKbn.TUMIHAI, "配当金受取方法区分");

        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 1), BizDateYM.valueOf(201507), "月払前納指定期間中精算チェックの１次呼出の証明開始年月");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(
            KoujyoSyoumeiUtilMockForKhansyuu.class, "chkTkZennouStkkntySeisan", 0, 2), BizDateYM.valueOf(201607), "月払前納指定期間中精算チェックの１次呼出の証明終了年月");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(256)
    public void testExec_C7() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150807);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C7,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C7);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 5, "要素数");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyouOne.getKbnkey(), "06", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyono(), SYONO_C7, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(2430000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyou = koujyoSymNaiyouList.get(4);
        exStringEquals(zennoKoujyoSymNaiyou.getKbnkey(), "06", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyou.getSyono(), SYONO_C7, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyou.getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201508), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyou.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyou.getKeisanhukariyuucd(), "RY01", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.IPPAN, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C7, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");
    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional
    @TestOrder(257)
    public void testExec_C8() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN1;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN1;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150807);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C8,
            zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(SYONO_C8);
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList = kykKihon.getKoujyoSymNaiyous();

        exNumericEquals(koujyoSymNaiyouList.size(), 7, "要素数");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouOne = koujyoSymNaiyouList.get(0);
        exStringEquals(zennoKoujyoSymNaiyouOne.getKbnkey(), "07", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyono(), SYONO_C8, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouOne.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouOne.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouOne.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouOne.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouOne.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouOne.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouOne.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouOne.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouTwo = koujyoSymNaiyouList.get(2);
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKbnkey(), "07", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getSyono(), SYONO_C8, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyouTwo.getKoujyosyoumeigk(), BizCurrency.valueOf(810000), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyouTwo.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getSakujyoflg(),C_Delflag.SAKUJYO, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyouTwo.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyouTwo.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyouTwo.getKeisanhukahyoujikbn(),C_DispKbn.HIHYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyouTwo.getKeisanhukariyuucd(), "r9", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyou = koujyoSymNaiyouList.get(5);
        exStringEquals(zennoKoujyoSymNaiyou.getKbnkey(), "07", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyou.getSyono(), SYONO_C8, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyou.getSyouhncd(), "MD11", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyou.getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyou.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.KAIGOIRYOU, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyou.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyou.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyou.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyou.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyou.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyou.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyou.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyou.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyou.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyou.getKeisanhukariyuucd(), "RY01", "計算不可理由コード");

        IT_KoujyoSymNaiyou zennoKoujyoSymNaiyou2 = koujyoSymNaiyouList.get(6);
        exStringEquals(zennoKoujyoSymNaiyou2.getKbnkey(), "07", "区分キー ");
        exStringEquals(zennoKoujyoSymNaiyou2.getSyono(), SYONO_C8, "証券番号");
        exStringEquals(zennoKoujyoSymNaiyou2.getSyouhncd(), "MD12", "商品コード");
        exNumericEquals(zennoKoujyoSymNaiyou2.getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(zennoKoujyoSymNaiyou2.getKoujyosyoumeinnd(), "2014", "控除証明年度");
        exDateYMEquals(zennoKoujyoSymNaiyou2.getSyoumeistartym(), BizDateYM.valueOf(201512), "証明開始年月");
        exDateYMEquals(zennoKoujyoSymNaiyou2.getSyoumeiendym(), BizDateYM.valueOf(201607), "証明終了年月");
        exClassificationEquals(zennoKoujyoSymNaiyou2.getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "控除証明保険料区分");
        exClassificationEquals(zennoKoujyoSymNaiyou2.getTekiyouseidokbn(),C_TekiyouseidoKbn.OLDSD, "適用制度区分");
        exClassificationEquals(zennoKoujyoSymNaiyou2.getKoujyosymnaiyoureckbn(),C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK, "控除証明内容レコ－ド区分");
        exBizCalcbleEquals(zennoKoujyoSymNaiyou2.getKoujyosyoumeigk(), BizCurrency.valueOf(2600), "控除証明額");
        exDateYMEquals(zennoKoujyoSymNaiyou2.getJyutoustartym(), BizDateYM.valueOf(201406), "充当開始年月");
        exNumericEquals(zennoKoujyoSymNaiyou2.getNyknjskrrkrenno(), 1, "入金実績履歴連番");
        exNumericEquals(zennoKoujyoSymNaiyou2.getKihrkpssrrkrenno(), 1, "既払込Ｐ精算履歴連番");
        exStringEquals(zennoKoujyoSymNaiyou2.getGyoumuKousinKinou(), "EditKoujyonaiyouTblZeitekiTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennoKoujyoSymNaiyou2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(zennoKoujyoSymNaiyou2.getSakujyoflg(),C_Delflag.BLNK, "削除フラグ");
        exDateEquals(zennoKoujyoSymNaiyou2.getZennoukaisiymd(), BizDate.valueOf(20141225), "前納開始年月日");
        exNumericEquals(zennoKoujyoSymNaiyou2.getZennourenno(), 1, "前納連番");
        exClassificationEquals(zennoKoujyoSymNaiyou2.getKeisanhukahyoujikbn(),C_DispKbn.HYOUJI, "計算不可表示区分");
        exStringEquals(zennoKoujyoSymNaiyou2.getKeisanhukariyuucd(), "RY01", "計算不可理由コード");

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 1), C_KoujyosyoumeipKbn.IPPAN, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 0, 2);
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyono(), SYONO_C8, "証券番号");
        exStringEquals(kykSyouhnCommonParamList.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList.get(0).getSyouhncd(), "MD11", "商品コード");

        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 0), BizCurrency.valueOf(10000), "前納控除証明額計算の１次呼出の前納控除証明額");
        exClassificationEquals((C_KoujyosyoumeipKbn)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 1), C_KoujyosyoumeipKbn.KAIGOIRYOU, "前納控除証明額計算の１次呼出の主契約控除証明保険料区分");

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList2 = (List<KykSyouhnCommonParam>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "doHaibunZennouKoujyogaku", 1, 2);
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnCommonParamList2.get(0).getKykjyoutai(),C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(kykSyouhnCommonParamList2.get(0).getKykymd(), BizDate.valueOf(20160411), "契約日");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exNumericEquals(kykSyouhnCommonParamList2.get(0).getHknkkn(), 10, "保険期間");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyono(), SYONO_C8, "証券番号");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getHenkousikibetukey(), "m9527", "変更識別キー");
        exStringEquals(kykSyouhnCommonParamList2.get(0).getSyouhncd(), "MD11", "商品コード");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 0, 2);
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList.get(0).getSyouhnsdno(),"1", "商品世代番号");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 0), "MD11", "前納控除証明額計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 1), "1", "前納控除証明額計算の１次呼出の商品世代番号");

        List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanList2 = (List<KhShgtZennouKoujyogakuBean>)
            MockObjectManager.getArgument(KeisanZennouKoujyogakuMockForKhansyuu.class, "getKhShgtZennouKoujyogakuBean", 1, 2);
        exBizCalcbleEquals(khShgtZennouKoujyogakuBeanList2.get(0).getKhShgtZennouKoujyogaku(),BizCurrency.valueOf(2500), "商品毎控除証明額");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList2.get(0).getSyutkkbn(),C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(khShgtZennouKoujyogakuBeanList2.get(0).getKoujyosyoumeipkbn(),C_KoujyosyoumeipKbn.IPPAN, "主契約控除証明保険料区分");
        exStringEquals(khShgtZennouKoujyogakuBeanList2.get(0).getSyouhncd(),"MD11", "商品コード");
        exStringEquals(khShgtZennouKoujyogakuBeanList2.get(0).getSyouhnsdno(),"1", "商品世代番号");
    }

    @Test
    @Transactional
    @TestOrder(258)
    public void testExec_C9() {

        MockObjectManager.initialize();
        KeisanZennouKoujyogakuMockForKhansyuu.SYORIPTN = KeisanZennouKoujyogakuMockForKhansyuu.TESTPATTERN2;
        KoujyoSyoumeiUtilMockForKhansyuu.SYORIPTN = KoujyoSyoumeiUtilMockForKhansyuu.TESTPATTERN2;

        BizDate zeitekihenkoYmd = BizDate.valueOf(20150707);
        C_ZeitekiHenkouSyoriKbn zeitekiHenkouSyoriKbn = C_ZeitekiHenkouSyoriKbn.SYOUMETU;

        C_ChkkekkaKbn chkkekkaKbn =  editKoujyonaiyouTblZeiteki.exec(SYONO_C9, zeitekihenkoYmd, zeitekiHenkouSyoriKbn);

        exClassificationEquals(chkkekkaKbn, C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
    }
}

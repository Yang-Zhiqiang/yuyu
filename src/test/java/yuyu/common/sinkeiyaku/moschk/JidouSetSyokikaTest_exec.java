package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 自動設定項目初期化クラスのメソッド {@link JidouSetSyokika#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class JidouSetSyokikaTest_exec {

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String mosNo3 = "791112246";

    private final static String mosNo4 = "791112253";

    private final static String mosNo5 = "790001119";

    private final static String mosNo6 = "790001127";

    @Inject
    private JidouSetSyokika jidouSetSyokika;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_自動設定項目初期化";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(JidouSetSyokikaTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000010");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        jidouSetSyokika.exec(mosnaiCheckParam);
        exClassificationEquals(syoriCTL.getKthhbkbn(), C_UmuKbn.NONE, "決定保留不備区分");
        exClassificationEquals(syoriCTL.getSrhhbkbn(), C_UmuKbn.NONE, "成立保留不備区分");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN, "入金状態区分");
        exDateEquals(syoriCTL.getKktymd(), null, "告知日");
        exDateEquals(syoriCTL.getRyosyuymd(), null, "領収日");
        exBizCalcbleEquals(syoriCTL.getNyknkwsrate(), BizNumber.valueOf(0), "入金用為替レート");
        exDateEquals(syoriCTL.getNyknkwsratekijyunymd(), null, "入金用為替レート基準日");
        exClassificationEquals(syoriCTL.getDoujimosumu(), C_UmuKbn.NONE, "同時申込有無");
        exClassificationEquals(syoriCTL.getPaldoujimosumu(), C_UmuKbn.NONE, "ＰＡＬ同時申込有無");
        exClassificationEquals(syoriCTL.getRaydoujimosumu(), C_UmuKbn.NONE, "ＲＡＹ同時申込有無");
        exStringEquals(syoriCTL.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getGyoumuKousinTime(), "20150604162000010", "業務用更新時間");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().size(),0,"申込商品テーブルエンティティリストの件数");
        exNumericEquals(mosnaiCheckParam.getDataSyoriControl().getMosDairitens().size(),0,"申込代理店テーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000010");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        jidouSetSyokika.exec(mosnaiCheckParam);
        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
        exNumericEquals(mosSyouhnLst.size(),1,"申込商品テーブルエンティティリストの件数");
        exNumericEquals(mosSyouhnLst.get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(0).getRyouritusdno(), String.valueOf(0), "料率世代番号");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getRendouritu(), BizNumber.valueOf(0), "連動率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(0), "正当基本Ｓ");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(0), "主契約・特約Ｐ");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0), "特条保険料");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTeikisiharaikin(), BizCurrency.valueOf(0), "定期支払金");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinTime(), "20150604162000010", "業務用更新時間");
    }
    @Test
    @TestOrder(30)
    public void testExec_B1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000010");

        jidouSetSyokika.exec(mosnaiCheckParam);

        exNumericEquals(mosnaiCheckParam.getBeforeCheckIkkatuyoupkaisuu(), 2, "（チェック前）一括要Ｐ回数");
        exClassificationEquals(mosnaiCheckParam.getBeforeCheckIkkatuyouptknKbn(), C_IkkatuyouptknKbn.SYOURYAKU, "（チェック前）一括要Ｐ特認区分");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf(201604), "申込月度");
        exDateEquals(mosKihon.getKykymd(), null, "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), null, "責任開始日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 0, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 0, "契約者年齢");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "平準払Ｐ（料増除）");
        exBizCalcbleEquals(mosKihon.getHrktuukaheijyunp() , BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "払込通貨平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括払Ｐ");
        exNumericEquals(mosKihon.getZnnkai(), 2, "前納回数");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHrktuukafstphrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "払込通貨初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "表定P");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料払込総額");
        exNumericEquals(mosKihon.getSkjpjyuutoukaisuu(), 0, "新契約時保険料充当回数");
        exClassificationEquals(mosKihon.getIkkatuyoupumukbn(), C_UmuKbn.NONE, "一括要Ｐ有無区分");
        exNumericEquals(mosKihon.getIkkatuyoupkaisuu(), 0, "一括要Ｐ回数");
        exBizCalcbleEquals(mosKihon.getIkkatuyoupgkkeizokup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括要Ｐ必要額（継続Ｐ）");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.NONE, "保険料割引適用区分");
        exClassificationEquals(mosKihon.getSisuukbn(), C_Sisuukbn.BLNK,"指数区分");
        exDateEquals(mosKihon.getKeizokuptkykwsratekjymd(), null, "継続Ｐ適用為替レート基準日");
        exBizCalcbleEquals(mosKihon.getKeizokuptkykwsrate(), BizNumber.valueOf(0), "継続Ｐ適用為替レート");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
        exNumericEquals(mosSyouhnLst.size(),1,"申込商品テーブルエンティティリストの件数");
        exNumericEquals(mosSyouhnLst.get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(mosSyouhnLst.get(0).getRyouritusdno(), String.valueOf(0), "料率世代番号");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getRendouritu(), BizNumber.valueOf(0), "連動率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getSeitoukihons(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "正当基本Ｓ");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getSyutkp(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "主契約・特約Ｐ");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTkjyp(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "特条保険料");
        exBizCalcbleEquals(mosSyouhnLst.get(0).getTeikisiharaikin(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "定期支払金");
        exNumericEquals(mosSyouhnLst.get(0).getHrkkkn(), 0, "払込期間");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosSyouhnLst.get(0).getGyoumuKousinTime(), "20150604162000010", "業務用更新時間");

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        exNumericEquals(mosDairitenLst.size(),1,"申込代理店テーブルエンティティリストの件数");
        exStringEquals(mosDairitenLst.get(0).getTratkiagcd(), "", "取扱代理店コード");
        exStringEquals(mosDairitenLst.get(0).getOyadrtencd(), "", "親代理店コード");
        exStringEquals(mosDairitenLst.get(0).getBosyuucd(), "", "募集人コード");
        exStringEquals(mosDairitenLst.get(0).getDaibosyuucd(), "", "代表募集人コード");
        exStringEquals(mosDairitenLst.get(0).getDrtenkanrisosikicd(), "", "代理店管理組織コード");
        exStringEquals(mosDairitenLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(mosDairitenLst.get(0).getGyoumuKousinTime(), "20150604162000010", "業務用更新時間");

        HT_Tokunin tokunin = syoriCTL.getTokunin();
        exClassificationEquals(tokunin.getIkkatuyouptknkbn(), C_IkkatuyouptknKbn.NONE, "一括要Ｐ特認区分");
        exStringEquals(tokunin.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tokunin.getGyoumuKousinTime(), "20150604162000010", "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    public void testExec_B2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000001");

        jidouSetSyokika.exec(mosnaiCheckParam);
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(mosnaiCheckParam.getBeforeCheckIkkatuyoupkaisuu(), 0, "（チェック前）一括要Ｐ回数");
        exClassificationEquals(mosnaiCheckParam.getBeforeCheckIkkatuyouptknKbn(), C_IkkatuyouptknKbn.NONE, "（チェック前）一括要Ｐ特認区分");

        exDateYMEquals(mosKihon.getMosym(), BizDateYM.valueOf(201605), "申込月度");
        exDateEquals(mosKihon.getKykymd(), null, "契約日");
        exDateEquals(mosKihon.getSknnkaisiymd(), null, "責任開始日");
        exDateYMEquals(mosKihon.getBosyuuym(), null, "募集年月");
        exDateYMEquals(mosKihon.getSeisekiym(), null, "成績計上年月");
        exDateYMEquals(mosKihon.getSkeikeijyouym(), null, "新契約計上年月");
        exNumericEquals(mosKihon.getHhknnen(), 0, "被保険者年齢");
        exNumericEquals(mosKihon.getKyknen(), 0, "契約者年齢");
        exBizCalcbleEquals(mosKihon.getHeijyunp(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHeijyunpryoumasinasi(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "平準払Ｐ（料増除）");
        exBizCalcbleEquals(mosKihon.getHrktuukaheijyunp(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "払込通貨平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getIkkatup(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "一括払Ｐ");
        exNumericEquals(mosKihon.getZnnkai(), 0, "前納回数");
        exBizCalcbleEquals(mosKihon.getZennoup(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "前納Ｐ");
        exBizCalcbleEquals(mosKihon.getZennoujyuutoup(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "前納年払充当Ｐ");
        exBizCalcbleEquals(mosKihon.getSeitoufstpkei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "正当初回Ｐ合計金額");
        exBizCalcbleEquals(mosKihon.getFstphrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHrktuukafstphrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "払込通貨初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getHyouteip(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "表定P");
        exBizCalcbleEquals(mosKihon.getPharaikomisougaku(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "保険料払込総額");
        exNumericEquals(mosKihon.getSkjpjyuutoukaisuu(), 0, "新契約時保険料充当回数");
        exClassificationEquals(mosKihon.getIkkatuyoupumukbn(), C_UmuKbn.NONE, "一括要Ｐ有無区分");
        exNumericEquals(mosKihon.getIkkatuyoupkaisuu(), 0, "一括要Ｐ回数");
        exBizCalcbleEquals(mosKihon.getIkkatuyoupgkkeizokup(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "一括要Ｐ必要額（継続Ｐ）");
        exClassificationEquals(mosKihon.getPwaribikitekiyoukbn(), C_PWaribikitekiyouKbn.NONE, "保険料割引適用区分");
        exClassificationEquals(mosKihon.getSisuukbn(), C_Sisuukbn.BLNK,"指数区分");
        exDateEquals(mosKihon.getKeizokuptkykwsratekjymd(), null, "継続Ｐ適用為替レート基準日");
        exBizCalcbleEquals(mosKihon.getKeizokuptkykwsrate(), BizNumber.valueOf(0), "継続Ｐ適用為替レート");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
        exNumericEquals(mosSyouhnLst.size(),3,"申込商品テーブルエンティティリストの件数");
        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {
            exNumericEquals(mosSyouhn.getSyouhnsdno(), 0, "商品世代番号");
            exStringEquals(mosSyouhn.getRyouritusdno(), String.valueOf(0), "料率世代番号");
            exBizCalcbleEquals(mosSyouhn.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
            exBizCalcbleEquals(mosSyouhn.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
            exBizCalcbleEquals(mosSyouhn.getTmttknzoukaritujygn(), BizNumber.valueOf(0), "積立金増加率上限");
            exBizCalcbleEquals(mosSyouhn.getSetteibairitu(), BizNumber.valueOf(0), "設定倍率");
            exBizCalcbleEquals(mosSyouhn.getRendouritu(), BizNumber.valueOf(0), "連動率");
            exBizCalcbleEquals(mosSyouhn.getLoadinghnkgtumitateriritu(), BizNumber.valueOf(0), "ローディング変更後積立利率");
            exBizCalcbleEquals(mosSyouhn.getSeitoukihons(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "正当基本Ｓ");
            exBizCalcbleEquals(mosSyouhn.getSyutkp(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "主契約・特約Ｐ");
            exBizCalcbleEquals(mosSyouhn.getTkjyp(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "特条保険料");
            exBizCalcbleEquals(mosSyouhn.getTeikisiharaikin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "定期支払金");
            exNumericEquals(mosSyouhn.getHrkkkn(), 0, "払込期間");
            exStringEquals(mosSyouhn.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
            exStringEquals(mosSyouhn.getGyoumuKousinTime(), "20150604162000001", "業務用更新時間");
        }

        List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
        exNumericEquals(mosDairitenLst.size(),3,"申込代理店テーブルエンティティリストの件数");
        for (HT_MosDairiten mosDairiten : mosDairitenLst) {
            exStringEquals(mosDairiten.getTratkiagcd(), "", "取扱代理店コード");
            exStringEquals(mosDairiten.getOyadrtencd(), "", "親代理店コード");
            exStringEquals(mosDairiten.getBosyuucd(), "", "募集人コード");
            exStringEquals(mosDairiten.getDaibosyuucd(), "", "代表募集人コード");
            exStringEquals(mosDairiten.getDrtenkanrisosikicd(), "", "代理店管理組織コード");
            exStringEquals(mosDairiten.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
            exStringEquals(mosDairiten.getGyoumuKousinTime(), "20150604162000001", "業務用更新時間");
        }

        assertNull("特認テーブル", syoriCTL.getTokunin());
    }

    @Test
    @TestOrder(50)
    public void testExec_B3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000010");

        jidouSetSyokika.exec(mosnaiCheckParam);

        exNumericEquals(mosnaiCheckParam.getBeforeCheckIkkatuyoupkaisuu(), 2, "（チェック前）一括要Ｐ回数");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
        exNumericEquals(mosSyouhnLst.size(),1,"申込商品テーブルエンティティリストの件数");
        exNumericEquals(mosSyouhnLst.get(0).getHrkkkn(), 1, "払込期間");
    }

    @Test
    @TestOrder(60)
    public void testExec_B4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000010");

        jidouSetSyokika.exec(mosnaiCheckParam);

        exNumericEquals(mosnaiCheckParam.getBeforeCheckIkkatuyoupkaisuu(), 2, "（チェック前）一括要Ｐ回数");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhns();
        exNumericEquals(mosSyouhnLst.size(),1,"申込商品テーブルエンティティリストの件数");
        exNumericEquals(mosSyouhnLst.get(0).getHrkkkn(), 2, "払込期間");
    }
}
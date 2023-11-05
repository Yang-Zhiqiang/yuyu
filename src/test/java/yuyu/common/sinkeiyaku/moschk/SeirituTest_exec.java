package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_JiketteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 成立処理クラスのメソッド {@link Seiritu#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SeirituTest_exec {

    private final static String fileName = "UT_SP_単体テスト仕様書_成立処理";

    private final static String sheetName = "テストデータ";

    @Inject
    private Seiritu seiritu;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou Kinou;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SeirituTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector
            .getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJigyouIkkatu());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        try {
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150603111400000");
            seiritu.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。代表申込番号=791112220", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        Kinou.setSyoricd("RG5H");
        seiritu.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112238", "申込番号");
        exClassificationEquals(syoriCTL.getUriagesousinkbn(), C_UriagesousinKbn.SOUSINMATI, "売上送信区分");
        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.ARI, "入金入力有無");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(syoriCTL.getSrsyoriymd(), BizDate.valueOf("20160229"), "成立処理日");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.SYOUMETU, "入金状態区分");

        List<HT_Nyuukin> nyuukinInsLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinInsLst.size(), 1, "件数");
        exStringEquals(nyuukinInsLst.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(nyuukinInsLst.get(0).getRenno(), 1, "連番");
        exDateEquals(nyuukinInsLst.get(0).getSoukinymd(), null, "送金日");
        exDateEquals(nyuukinInsLst.get(0).getTyakkinymd(), BizDate.valueOf("20160301"), "着金日");
        exDateEquals(nyuukinInsLst.get(0).getNyksyoriymd(), BizDate.valueOf("20160229"), "入金処理日");
        exStringEquals(nyuukinInsLst.get(0).getNyuukinsyoritime(), "20150603111400000", "入金処理日時");
        exClassificationEquals(nyuukinInsLst.get(0).getNyknsyubetu(), C_NyknsyubetuKbn.CREDIT, "入金種別");
        exStringEquals(nyuukinInsLst.get(0).getSoukincd(), "", "送金コード");
        exBizCalcbleEquals(nyuukinInsLst.get(0).getRsgaku(), BizCurrency.valueOf(1000), "領収金額");
        exClassificationEquals(nyuukinInsLst.get(0).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyuukinInsLst.get(0).getRyosyuymd(), BizDate.valueOf("20160301"), "領収日");
        exStringEquals(nyuukinInsLst.get(0).getRssyouno(), "", "領収証番号");
        exClassificationEquals(nyuukinInsLst.get(0).getZenhnknkbn(), C_ZenhnknKbn.BLNK, "全額返金区分");
        exClassificationEquals(nyuukinInsLst.get(0).getSrgonyknumu(), C_UmuKbn.NONE, "成立後入金有無");
        exNumericEquals(nyuukinInsLst.get(0).getEdano(), 2, "枝番号");
        exDateYMEquals(nyuukinInsLst.get(0).getJyuutouym(), null, "充当年月");
        exNumericEquals(nyuukinInsLst.get(0).getKrkno(), 0, "仮受番号");
        exStringEquals(nyuukinInsLst.get(0).getDntcd(), "", "団体コード");
        exStringEquals(nyuukinInsLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nyuukinInsLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("791112238");
        exStringEquals(jigyouIkkatu.getDaimosno(), "791112238", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getMosnrkumu(), C_UmuKbn.NONE, "申込書入力有無");
        exClassificationEquals(jigyouIkkatu.getKktnrkumu(), C_UmuKbn.NONE, "告知書入力有無");
        exClassificationEquals(jigyouIkkatu.getHjynrkumu(), C_UmuKbn.NONE, "報状入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(jigyouIkkatu.getNyknwarinrkumu(), C_UmuKbn.NONE, "入金割当入力有無");
        exClassificationEquals(jigyouIkkatu.getItijiketnrkumu(), C_UmuKbn.NONE, "１次決定入力有無");
        exClassificationEquals(jigyouIkkatu.getJiketteikbn(), C_JiketteiKbn.KETTEI_SUMI, "事業一括決定状態区分");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.SEIRITU, "事業一括成立区分");
        exDateEquals(jigyouIkkatu.getJgyiktsrymd(), BizDate.valueOf("20160229"), "事業一括成立日");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 2, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "契約が成立しました。", "結果画面ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(1), "事業一括契約が成立しました。", "結果画面ＭＳＧ");

        List<HT_SkDenpyoData> sklist = mosnaiCheckParam.getListSkDenpyoData();

        exNumericEquals(sklist.size(), 4, "新契約伝票データテーブル エンティティのサイズ");

        HT_SkDenpyoData skDenpyoData = sklist.get(0);
        exClassificationEquals(skDenpyoData.getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData.getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAMISYUUKIN, "勘定科目コード");
        exStringEquals(skDenpyoData.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData.getDenyenkagk(), BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData.getKeiyakutuukagk(), BizCurrency.valueOf(1000), "契約通貨金額");
        exStringEquals(skDenpyoData.getMosno(), "791112238", "申込番号");
        exStringEquals(skDenpyoData.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData.getDenymd(), BizDate.valueOf("20160229"), "伝票日付");
        exClassificationEquals(skDenpyoData.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData.getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(skDenpyoData.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData.getFstpryosyuymd(), BizDate.valueOf("20160229"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData.getRyouritusdno(), "", "料率世代番号");
        exStringEquals(skDenpyoData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData.getSyouhnsdno(), 0, "商品世代番号");

        HT_SkDenpyoData skDenpyoData1 = sklist.get(1);
        exClassificationEquals(skDenpyoData1.getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData1.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData1.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData1.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData1.getDenyenkagk(), BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData1.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData1.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData1.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData1.getKeiyakutuukagk(), BizCurrency.valueOf(1000), "契約通貨金額");
        exStringEquals(skDenpyoData1.getMosno(), "791112238", "申込番号");
        exStringEquals(skDenpyoData1.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData1.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData1.getDenymd(), BizDate.valueOf("20160229"), "伝票日付");
        exClassificationEquals(skDenpyoData1.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData1.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData1.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData1.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData1.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData1.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData1.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData1.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData1.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData1.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData1.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData1.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData1.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData1.getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(skDenpyoData1.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData1.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData1.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData1.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData1.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData1.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData1.getFstpryosyuymd(), BizDate.valueOf("20160229"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData1.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData1.getRyouritusdno(), "", "料率世代番号");
        exStringEquals(skDenpyoData1.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData1.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData1.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData1.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData1.getSyouhnsdno(), 0, "商品世代番号");

        HT_SkDenpyoData skDenpyoData2 = sklist.get(2);
        exClassificationEquals(skDenpyoData2.getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData2.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData2.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData2.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData2.getDenyenkagk(), BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData2.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData2.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData2.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData2.getKeiyakutuukagk(), BizCurrency.valueOf(1000), "契約通貨金額");
        exStringEquals(skDenpyoData2.getMosno(), "791112238", "申込番号");
        exStringEquals(skDenpyoData2.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData2.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData2.getDenymd(), BizDate.valueOf("20160301"), "伝票日付");
        exClassificationEquals(skDenpyoData2.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData2.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData2.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData2.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData2.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData2.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData2.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData2.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData2.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData2.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData2.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData2.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData2.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData2.getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(skDenpyoData2.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData2.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData2.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData2.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData2.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData2.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData2.getFstpryosyuymd(), BizDate.valueOf("20160229"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData2.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData2.getRyouritusdno(), "", "料率世代番号");
        exStringEquals(skDenpyoData2.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData2.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData2.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData2.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData2.getSyouhnsdno(), 0, "商品世代番号");

        HT_SkDenpyoData skDenpyoData3 = sklist.get(3);
        exClassificationEquals(skDenpyoData3.getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData3.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData3.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData3.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData3.getDenyenkagk(), BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData3.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData3.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData3.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData3.getKeiyakutuukagk(), BizCurrency.valueOf(1000), "契約通貨金額");
        exStringEquals(skDenpyoData3.getMosno(), "791112238", "申込番号");
        exStringEquals(skDenpyoData3.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData3.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData3.getDenymd(), BizDate.valueOf("20160301"), "伝票日付");
        exClassificationEquals(skDenpyoData3.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData3.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData3.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData3.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData3.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData3.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData3.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData3.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData3.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData3.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData3.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData3.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData3.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData3.getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(skDenpyoData3.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData3.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData3.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData3.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData3.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData3.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData3.getFstpryosyuymd(), BizDate.valueOf("20160229"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData3.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData3.getRyouritusdno(), "", "料率世代番号");
        exStringEquals(skDenpyoData3.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData3.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData3.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData3.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData3.getSyouhnsdno(), 0, "商品世代番号");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        seiritu.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112246", "申込番号");
        exClassificationEquals(syoriCTL.getUriagesousinkbn(), null, "売上送信区分");
        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(syoriCTL.getSrsyoriymd(), BizDate.valueOf("20160229"), "成立処理日");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.SYOUMETU, "入金状態区分");

        List<HT_Nyuukin> nyuukinInsLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinInsLst.size(), 0, "件数");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("791112246");
        exStringEquals(jigyouIkkatu.getDaimosno(), "791112246", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.BLNK, "事業一括成立区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), null, "業務用更新時間");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "契約が成立しました。", "結果画面ＭＳＧ");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        Kinou.setSyoricd("RG5H");
        seiritu.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112253", "申込番号");
        exClassificationEquals(syoriCTL.getUriagesousinkbn(), C_UriagesousinKbn.SOUSINMATI, "売上送信区分");
        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.ARI, "入金入力有無");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(syoriCTL.getSrsyoriymd(), BizDate.valueOf("20160229"), "成立処理日");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.SYOUMETU, "入金状態区分");

        List<HT_Nyuukin> nyuukinInsLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinInsLst.size(), 1, "件数");
        exStringEquals(nyuukinInsLst.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(nyuukinInsLst.get(0).getRenno(), 1, "連番");
        exDateEquals(nyuukinInsLst.get(0).getSoukinymd(), null, "送金日");
        exDateEquals(nyuukinInsLst.get(0).getTyakkinymd(), BizDate.valueOf("20160301"), "着金日");
        exDateEquals(nyuukinInsLst.get(0).getNyksyoriymd(), BizDate.valueOf("20160229"), "入金処理日");
        exStringEquals(nyuukinInsLst.get(0).getNyuukinsyoritime(), "20150603111400000", "入金処理日時");
        exClassificationEquals(nyuukinInsLst.get(0).getNyknsyubetu(), C_NyknsyubetuKbn.CREDIT, "入金種別");
        exStringEquals(nyuukinInsLst.get(0).getSoukincd(), "", "送金コード");
        exBizCalcbleEquals(nyuukinInsLst.get(0).getRsgaku(), BizCurrency.valueOf(10000), "領収金額");
        exClassificationEquals(nyuukinInsLst.get(0).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyuukinInsLst.get(0).getRyosyuymd(), BizDate.valueOf("20160301"), "領収日");
        exStringEquals(nyuukinInsLst.get(0).getRssyouno(), "", "領収証番号");
        exClassificationEquals(nyuukinInsLst.get(0).getZenhnknkbn(), C_ZenhnknKbn.BLNK, "全額返金区分");
        exClassificationEquals(nyuukinInsLst.get(0).getSrgonyknumu(), C_UmuKbn.NONE, "成立後入金有無");
        exNumericEquals(nyuukinInsLst.get(0).getEdano(), 2, "枝番号");
        exDateYMEquals(nyuukinInsLst.get(0).getJyuutouym(), null, "充当年月");
        exNumericEquals(nyuukinInsLst.get(0).getKrkno(), 0, "仮受番号");
        exStringEquals(nyuukinInsLst.get(0).getDntcd(), "", "団体コード");
        exStringEquals(nyuukinInsLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nyuukinInsLst.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("791112253");
        exStringEquals(jigyouIkkatu.getDaimosno(), "791112253", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.BLNK, "事業一括成立区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), null, "業務用更新時間");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "契約が成立しました。", "結果画面ＭＳＧ");

        List<HT_SkDenpyoData> sklist = mosnaiCheckParam.getListSkDenpyoData();

        exNumericEquals(sklist.size(), 4, "新契約伝票データテーブル エンティティのサイズ");

        HT_SkDenpyoData skDenpyoData = sklist.get(0);
        exClassificationEquals(skDenpyoData.getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData.getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAMISYUUKIN, "勘定科目コード");
        exStringEquals(skDenpyoData.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData.getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(skDenpyoData.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData.getKeiyakutuukagk(), BizCurrency.valueOf(82.0), "契約通貨金額");
        exStringEquals(skDenpyoData.getMosno(), "791112253", "申込番号");
        exStringEquals(skDenpyoData.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData.getDenymd(), BizDate.valueOf("20160229"), "伝票日付");
        exClassificationEquals(skDenpyoData.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN, "伝票処理区分");
        exStringEquals(skDenpyoData.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData.getAatsukaishasoshikicd(), "8001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData.getAatkisyadaibosyuucd(), "02", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData.getSyusyouhncd(), "1001", "主契約商品コード");
        exClassificationEquals(skDenpyoData.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData.getHrkkaisuu(), C_Hrkkaisuu.TUKI , "払込回数");
        exClassificationEquals(skDenpyoData.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData.getFstpryosyuymd(), BizDate.valueOf("20160202"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData.getAatkisyabosyuucd(), "20", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData.getKakokawaserateshiteiflg(), true, "過去レート指定フラグ");
        exDateEquals(skDenpyoData.getKakokawaserateshiteiymd(), BizDate.valueOf("20160202"), "過去レート指定年月日");
        exClassificationEquals(skDenpyoData.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exNumericEquals(skDenpyoData.getSyouhnsdno(), 02, "商品世代番号");

        HT_SkDenpyoData skDenpyoData1 = sklist.get(1);
        exClassificationEquals(skDenpyoData1.getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData1.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData1.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData1.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData1.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData1.getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(skDenpyoData1.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData1.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData1.getKeiyakutuukagk(), BizCurrency.valueOf(82.0), "契約通貨金額");
        exStringEquals(skDenpyoData.getMosno(), "791112253", "申込番号");
        exStringEquals(skDenpyoData.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData.getDenymd(), BizDate.valueOf("20160229"), "伝票日付");
        exClassificationEquals(skDenpyoData.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN, "伝票処理区分");
        exStringEquals(skDenpyoData.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData.getAatsukaishasoshikicd(), "8001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData.getAatkisyadaibosyuucd(), "02", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData.getSyusyouhncd(), "1001", "主契約商品コード");
        exClassificationEquals(skDenpyoData.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData.getHrkkaisuu(), C_Hrkkaisuu.TUKI , "払込回数");
        exClassificationEquals(skDenpyoData.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData.getFstpryosyuymd(), BizDate.valueOf("20160202"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData.getAatkisyabosyuucd(), "20", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData.getKakokawaserateshiteiflg(), true, "過去レート指定フラグ");
        exDateEquals(skDenpyoData.getKakokawaserateshiteiymd(), BizDate.valueOf("20160202"), "過去レート指定年月日");
        exClassificationEquals(skDenpyoData.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exNumericEquals(skDenpyoData.getSyouhnsdno(), 02, "商品世代番号");

        HT_SkDenpyoData skDenpyoData2 = sklist.get(2);
        exClassificationEquals(skDenpyoData2.getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData2.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData2.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData2.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData2.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData2.getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(skDenpyoData2.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData2.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData2.getKeiyakutuukagk(), BizCurrency.valueOf(82.0), "契約通貨金額");
        exStringEquals(skDenpyoData2.getMosno(), "791112253", "申込番号");
        exStringEquals(skDenpyoData2.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData2.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData2.getDenymd(), BizDate.valueOf("20160301"), "伝票日付");
        exClassificationEquals(skDenpyoData2.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData2.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData2.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData2.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData2.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData2.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData2.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData2.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData2.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData2.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData2.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData2.getAatsukaishasoshikicd(), "8001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData2.getAatkisyadaibosyuucd(), "02", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData2.getSyusyouhncd(), "1001", "主契約商品コード");
        exClassificationEquals(skDenpyoData2.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData2.getHrkkaisuu(), C_Hrkkaisuu.TUKI , "払込回数");
        exClassificationEquals(skDenpyoData2.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData2.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData2.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData2.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData2.getFstpryosyuymd(), BizDate.valueOf("20160202"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData2.getAatkisyabosyuucd(), "20", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData2.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData2.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData2.getKakokawaserateshiteiflg(), true, "過去レート指定フラグ");
        exDateEquals(skDenpyoData2.getKakokawaserateshiteiymd(), BizDate.valueOf("20160202"), "過去レート指定年月日");
        exClassificationEquals(skDenpyoData2.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exNumericEquals(skDenpyoData2.getSyouhnsdno(), 02, "商品世代番号");

        HT_SkDenpyoData skDenpyoData3 = sklist.get(3);
        exClassificationEquals(skDenpyoData3.getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData3.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData3.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData3.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData3.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData3.getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(skDenpyoData3.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData3.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData3.getKeiyakutuukagk(), BizCurrency.valueOf(82.0), "契約通貨金額");
        exStringEquals(skDenpyoData3.getMosno(), "791112253", "申込番号");
        exStringEquals(skDenpyoData3.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData3.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData3.getDenymd(), BizDate.valueOf("20160301"), "伝票日付");
        exClassificationEquals(skDenpyoData3.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData3.getSyoriYmd(), BizDate.valueOf("20160229"), "処理年月日");
        exStringEquals(skDenpyoData3.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData3.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData3.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData3.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData3.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData3.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData3.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData3.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData3.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData3.getAatsukaishasoshikicd(), "8001", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData3.getAatkisyadaibosyuucd(), "02", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData3.getSyusyouhncd(), "1001", "主契約商品コード");
        exClassificationEquals(skDenpyoData3.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData3.getHrkkaisuu(), C_Hrkkaisuu.TUKI , "払込回数");
        exClassificationEquals(skDenpyoData3.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData3.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData3.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData3.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData3.getFstpryosyuymd(), BizDate.valueOf("20160202"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData3.getAatkisyabosyuucd(), "20", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData3.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData3.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData3.getKakokawaserateshiteiflg(), true, "過去レート指定フラグ");
        exDateEquals(skDenpyoData3.getKakokawaserateshiteiymd(), BizDate.valueOf("20160202"), "過去レート指定年月日");
        exClassificationEquals(skDenpyoData3.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exNumericEquals(skDenpyoData3.getSyouhnsdno(), 02, "商品世代番号");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        seiritu.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112261", "申込番号");
        exClassificationEquals(syoriCTL.getUriagesousinkbn(), null, "売上送信区分");
        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.ARI, "入金入力有無");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(syoriCTL.getSrsyoriymd(), BizDate.valueOf("20160229"), "成立処理日");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.SYOUMETU, "入金状態区分");

        List<HT_Nyuukin> nyuukinInsLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinInsLst.size(), 0, "件数");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("791112261");
        exStringEquals(jigyouIkkatu.getDaimosno(), "791112261", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.BLNK, "事業一括成立区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), null, "業務用更新時間");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "契約が成立しました。", "結果画面ＭＳＧ");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        seiritu.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112279", "申込番号");
        exClassificationEquals(syoriCTL.getUriagesousinkbn(), null, "売上送信区分");
        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.ITIPMATI, "成立区分");
        exDateEquals(syoriCTL.getSrsyoriymd(), null, "成立処理日");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), null, "入金状態区分");

        List<HT_Nyuukin> nyuukinInsLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinInsLst.size(), 0, "件数");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("791112279");
        exStringEquals(jigyouIkkatu.getDaimosno(), "791112279", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.BLNK, "事業一括成立区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), null, "業務用更新時間");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 1, "結果画面ＭＳＧ件数");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "契約が１Ｐ待ち成立しました。", "結果画面ＭＳＧ");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        seiritu.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112287", "申込番号");
        exClassificationEquals(syoriCTL.getUriagesousinkbn(), null, "売上送信区分");
        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(syoriCTL.getSrsyoriymd(), null, "成立処理日");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), null, "入金状態区分");

        List<HT_Nyuukin> nyuukinInsLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinInsLst.size(), 0, "件数");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("791112287");
        exStringEquals(jigyouIkkatu.getDaimosno(), "791112287", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.BLNK, "事業一括成立区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), null, "業務用更新時間");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 0, "結果画面ＭＳＧ件数");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        seiritu.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "791112295", "申込番号");
        exClassificationEquals(syoriCTL.getUriagesousinkbn(), null, "売上送信区分");
        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");
        exClassificationEquals(syoriCTL.getSeiritukbn(), C_SeirituKbn.NONE, "成立区分");
        exDateEquals(syoriCTL.getSrsyoriymd(), null, "成立処理日");
        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), null, "入金状態区分");

        List<HT_Nyuukin> nyuukinInsLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinInsLst.size(), 0, "件数");

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu("791112295");
        exStringEquals(jigyouIkkatu.getDaimosno(), "791112295", "代表申込番号");
        exClassificationEquals(jigyouIkkatu.getJgyiktsrkbn(), C_SeirituKbn.BLNK, "事業一括成立区分");
        exStringEquals(jigyouIkkatu.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(jigyouIkkatu.getGyoumuKousinTime(), null, "業務用更新時間");

        exNumericEquals(mosnaiCheckParam.getListKekkaGmnMsg().size(), 0, "結果画面ＭＳＧ件数");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        try {
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110013");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150603111400000");
            seiritu.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110013", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @Transactional
    @TestOrder(100)
    public void testExec_B1() {

        try {
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf("20191101"));
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("201910011400000");
            seiritu.exec(mosnaiCheckParam);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "為替レートが取得できないため処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_B2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860015023");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20191010"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("201910011400000");
        Kinou.setSyoricd("RG5H");
        seiritu.exec(mosnaiCheckParam);

        List<HT_SkDenpyoData> sklist = mosnaiCheckParam.getListSkDenpyoData();

        exNumericEquals(sklist.size(), 4, "新契約伝票データテーブル エンティティのサイズ");

        HT_SkDenpyoData skDenpyoData = sklist.get(0);
        exClassificationEquals(skDenpyoData.getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData.getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAMISYUUKIN, "勘定科目コード");
        exStringEquals(skDenpyoData.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData.getKeiyakutuukagk(), BizCurrency.valueOf(10000), "契約通貨金額");
        exStringEquals(skDenpyoData.getMosno(), "860015023", "申込番号");
        exStringEquals(skDenpyoData.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData.getDenymd(), BizDate.valueOf("20191010"), "伝票日付");
        exClassificationEquals(skDenpyoData.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData.getSyoriYmd(), BizDate.valueOf("20191010"), "処理年月日");
        exStringEquals(skDenpyoData.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData.getSyusyouhncd(), "1002", "主契約商品コード");
        exClassificationEquals(skDenpyoData.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData.getFstpryosyuymd(), BizDate.valueOf("20191105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData.getSyouhnsdno(), 03, "商品世代番号");

        HT_SkDenpyoData skDenpyoData1 = sklist.get(1);
        exClassificationEquals(skDenpyoData1.getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData1.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData1.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData1.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData1.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData1.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData1.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData1.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData1.getKeiyakutuukagk(), BizCurrency.valueOf(10000), "契約通貨金額");
        exStringEquals(skDenpyoData1.getMosno(), "860015023", "申込番号");
        exStringEquals(skDenpyoData1.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData1.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData1.getDenymd(), BizDate.valueOf("20191010"), "伝票日付");
        exClassificationEquals(skDenpyoData1.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData1.getSyoriYmd(), BizDate.valueOf("20191010"), "処理年月日");
        exStringEquals(skDenpyoData1.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData1.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData1.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData1.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData1.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData1.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData1.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData1.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData1.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData1.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData1.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData1.getSyusyouhncd(), "1002", "主契約商品コード");
        exClassificationEquals(skDenpyoData1.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData1.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData1.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData1.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData1.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData1.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData1.getFstpryosyuymd(), BizDate.valueOf("20191105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData1.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData1.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData1.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData1.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData1.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData1.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData1.getSyouhnsdno(), 03, "商品世代番号");

        HT_SkDenpyoData skDenpyoData2 = sklist.get(2);
        exClassificationEquals(skDenpyoData2.getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData2.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData2.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData2.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData2.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData2.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData2.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData2.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData2.getKeiyakutuukagk(), BizCurrency.valueOf(10000), "契約通貨金額");
        exStringEquals(skDenpyoData2.getMosno(), "860015023", "申込番号");
        exStringEquals(skDenpyoData2.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData2.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData2.getDenymd(), BizDate.valueOf("20191011"), "伝票日付");
        exClassificationEquals(skDenpyoData2.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData2.getSyoriYmd(), BizDate.valueOf("20191010"), "処理年月日");
        exStringEquals(skDenpyoData2.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData2.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData2.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData2.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData2.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData2.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData2.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData2.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData2.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData2.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData2.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData2.getSyusyouhncd(), "1002", "主契約商品コード");
        exClassificationEquals(skDenpyoData2.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData2.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData2.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData2.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData2.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData2.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData2.getFstpryosyuymd(), BizDate.valueOf("20191105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData2.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData2.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData2.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData2.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData2.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData2.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData2.getSyouhnsdno(), 03, "商品世代番号");

        HT_SkDenpyoData skDenpyoData3 = sklist.get(3);
        exClassificationEquals(skDenpyoData3.getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoData3.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoData3.getSuitoubumoncd(), "565", "出納部門コード");
        exBizCalcbleEquals(skDenpyoData3.getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(skDenpyoData3.getDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(skDenpyoData3.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData3.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exStringEquals(skDenpyoData3.getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBizCalcbleEquals(skDenpyoData3.getKeiyakutuukagk(), BizCurrency.valueOf(10000), "契約通貨金額");
        exStringEquals(skDenpyoData3.getMosno(), "860015023", "申込番号");
        exStringEquals(skDenpyoData3.getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoData3.getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(skDenpyoData3.getDenymd(), BizDate.valueOf("20191011"), "伝票日付");
        exClassificationEquals(skDenpyoData3.getTuukasyu(), C_Tuukasyu.JPY , "通貨種類");
        exDateEquals(skDenpyoData3.getSyoriYmd(), BizDate.valueOf("20191010"), "処理年月日");
        exStringEquals(skDenpyoData3.getSyoricd(), "RG5H", "処理コード");
        exStringEquals(skDenpyoData3.getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(skDenpyoData3.getKessantyouseikbn(), C_KessantyouseiKbn.BLNK , "決算調整区分");
        exClassificationEquals(skDenpyoData3.getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK , "内部契約区分");
        exClassificationEquals(skDenpyoData3.getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(skDenpyoData3.getDensyorikbn(), C_DensyoriKbn.FP_CREDITNYKN , "伝票処理区分");
        exStringEquals(skDenpyoData3.getAatsukaishasuitososhikicd(), "5650000", "Ａ扱者出納組織コード");
        exDateEquals(skDenpyoData3.getKykymd(), BizDate.valueOf("20191012"), "契約日");
        exDateYMEquals(skDenpyoData3.getBosyuuym(),BizDateYM.valueOf("201911") , "募集年月");
        exStringEquals(skDenpyoData3.getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(skDenpyoData3.getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(skDenpyoData3.getSyusyouhncd(), "1002", "主契約商品コード");
        exClassificationEquals(skDenpyoData3.getSdpdkbn(), C_Sdpd.BLNK , "Ｓ建Ｐ建区分");
        exClassificationEquals(skDenpyoData3.getHrkkaisuu(), C_Hrkkaisuu.BLNK , "払込回数");
        exClassificationEquals(skDenpyoData3.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exDateEquals(skDenpyoData3.getSknnkaisiymd(), BizDate.valueOf("20191105"), "責任開始日");
        exDateEquals(skDenpyoData3.getMosymd(), BizDate.valueOf("20190901"), "申込日");
        exClassificationEquals(skDenpyoData3.getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exDateEquals(skDenpyoData3.getFstpryosyuymd(), BizDate.valueOf("20191105"), "初回Ｐ領収日");
        exStringEquals(skDenpyoData3.getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(skDenpyoData3.getRyouritusdno(), "103", "料率世代番号");
        exStringEquals(skDenpyoData3.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exBooleanEquals(skDenpyoData3.getKakokawaserateshiteiflg(), false, "過去レート指定フラグ");
        exDateEquals(skDenpyoData3.getKakokawaserateshiteiymd(), null, "過去レート指定年月日");
        exClassificationEquals(skDenpyoData3.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exNumericEquals(skDenpyoData3.getSyouhnsdno(), 03, "商品世代番号");

    }
    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160229"));
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        Kinou.setSyoricd("RG5H");
        seiritu.exec(mosnaiCheckParam);

        List<HT_SkDenpyoData> sklist = mosnaiCheckParam.getListSkDenpyoData();

        HT_SkDenpyoData skDenpyoData = sklist.get(0);
        exClassificationEquals(skDenpyoData.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");

        HT_SkDenpyoData skDenpyoData1 = sklist.get(1);
        exClassificationEquals(skDenpyoData1.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData1.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");

        HT_SkDenpyoData skDenpyoData2 = sklist.get(2);
        exClassificationEquals(skDenpyoData2.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData2.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");

        HT_SkDenpyoData skDenpyoData3 = sklist.get(3);
        exClassificationEquals(skDenpyoData3.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoData3.getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");

    }
}
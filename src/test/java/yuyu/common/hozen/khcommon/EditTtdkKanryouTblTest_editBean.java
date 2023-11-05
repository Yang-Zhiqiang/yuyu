package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.bean.report.BzKokyakuAtesakiBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.bean.report.KhTtdkkanryouBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.auth.RayHttpHeaderBeanMockForHozen;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続完了TBL編集のメソッド{@link EditTtdkKanryouTbl#editBean(C_SyoruiCdKbn,KhozenCommonParam,IT_TtdkKan,IT_KykSya)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditTtdkKanryouTblTest_editBean {

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditTtdkKanryouTbl editTtdkKanryouTbl;

    @Inject
    private HozenDomManager hozenDomManager;

    private static String hokenKaisyaNmKanji;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_手続完了TBL編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void testInit() {

        RayHttpHeaderBeanMockForHozen.caller = EditTtdkKanryouTblTest_editBean.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditTtdkKanryouTblTest_editBean.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
            hokenKaisyaNmKanji = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji(hokenKaisyaNmKanji);
        MockObjectManager.initialize();
        RayHttpHeaderBeanMockForHozen.caller = null;
        RayHttpHeaderBeanMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testEditBean_A1() {

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_ADRHNK_TTDKKR;
        IT_TtdkKan ttdkKan = null;
        IT_KykSya kykSya = new IT_KykSya();

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        assertNull(reportServicesBean);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditBean_A2() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111118", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrTyouhyousakuseiymd(), "２０１５年１１月２５日", "（ＩＲ）帳票作成日");
        exClassificationEquals(khTtdkkanryouBean.getIrTetudukisyukbn(), C_TetudukisyuKbn.NKTKYKHUKA, "（ＩＲ）手続種類区分");
        exClassificationEquals(khTtdkkanryouBean.getIrSyoruicd(), C_SyoruiCdKbn.KK_GENGAKU_TTDKKR, "（ＩＲ）書類コード");
        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111118", "（ＩＲ）証券番号");
        exClassificationEquals(khTtdkkanryouBean.getIrSyorikbn(), C_SyoriKbn.KYKTORIKESI, "（ＩＲ）処理区分");
        exStringEquals(khTtdkkanryouBean.getIrKyknmkj(), "契約者名", "（ＩＲ）契約者名（漢字）");
        exStringEquals(khTtdkkanryouBean.getIrHhknnmkj(), "被保険者名", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(khTtdkkanryouBean.getIrShrymd(), "２０１６年　４月　３日", "（ＩＲ）支払日");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrShrtienrsk(), BizCurrency.valueOf(212), "（ＩＲ）支払遅延利息");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrShrgk(), BizCurrency.valueOf(888), "（ＩＲ）支払金額");
        exStringEquals(khTtdkkanryouBean.getIrCalckijyunymd(), "２０１６年　４月１３日", "（ＩＲ）計算基準日");
        exStringEquals(khTtdkkanryouBean.getIrKaiykymd(), "２０１６年　４月２３日", "（ＩＲ）解約日");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou1(), "摘要１", "（ＩＲ）摘要１");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai1(), null, "（ＩＲ）金額明細１");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm1(), null, "（ＩＲ）金額明細通貨種類１");
        exStringEquals(khTtdkkanryouBean.getIrBikou1(), "備考１", "（ＩＲ）備考１");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou2(), "摘要２", "（ＩＲ）摘要２");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai2(), null, "（ＩＲ）金額明細２");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm2(), null, "（ＩＲ）金額明細通貨種類２");
        exStringEquals(khTtdkkanryouBean.getIrBikou2(), "備考２", "（ＩＲ）備考２");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou3(), "摘要３", "（ＩＲ）摘要３");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai3(), null, "（ＩＲ）金額明細３");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm3(), null, "（ＩＲ）金額明細通貨種類３");
        exStringEquals(khTtdkkanryouBean.getIrBikou3(), "備考３", "（ＩＲ）備考３");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou4(), "摘要４", "（ＩＲ）摘要４");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai4(), null, "（ＩＲ）金額明細４");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm4(), null, "（ＩＲ）金額明細通貨種類４");
        exStringEquals(khTtdkkanryouBean.getIrBikou4(), "備考４", "（ＩＲ）備考４");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou5(), "摘要５", "（ＩＲ）摘要５");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai5(), null, "（ＩＲ）金額明細５");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm5(), null, "（ＩＲ）金額明細通貨種類５");
        exStringEquals(khTtdkkanryouBean.getIrBikou5(), "備考５", "（ＩＲ）備考５");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou6(), "摘要６", "（ＩＲ）摘要６");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai6(), null, "（ＩＲ）金額明細６");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm6(), null, "（ＩＲ）金額明細通貨種類６");
        exStringEquals(khTtdkkanryouBean.getIrBikou6(), "備考６", "（ＩＲ）備考６");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou7(), "摘要７", "（ＩＲ）摘要７");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai7(), null, "（ＩＲ）金額明細７");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm7(), null, "（ＩＲ）金額明細通貨種類７");
        exStringEquals(khTtdkkanryouBean.getIrBikou7(), "備考７", "（ＩＲ）備考７");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou8(), "摘要８", "（ＩＲ）摘要８");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai8(), null, "（ＩＲ）金額明細８");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm8(), null, "（ＩＲ）金額明細通貨種類８");
        exStringEquals(khTtdkkanryouBean.getIrBikou8(), "備考８", "（ＩＲ）備考８");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou9(), "摘要９", "（ＩＲ）摘要９");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai9(), null, "（ＩＲ）金額明細９");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm9(), null, "（ＩＲ）金額明細通貨種類９");
        exStringEquals(khTtdkkanryouBean.getIrBikou9(), "備考９", "（ＩＲ）備考９");
        exStringEquals(khTtdkkanryouBean.getIrTekiyou10(), "摘要１０", "（ＩＲ）摘要１０");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai10(), null, "（ＩＲ）金額明細１０");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm10(), null, "（ＩＲ）金額明細通貨種類１０");
        exStringEquals(khTtdkkanryouBean.getIrBikou10(), "備考１０", "（ＩＲ）備考１０");
        exStringEquals(khTtdkkanryouBean.getIrShrtuukasyuryk(), "円", "（ＩＲ）支払通貨種類略称");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrSynykngk(), BizCurrency.valueOf(222), "（ＩＲ）収入金額");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrHtykeihi(), BizCurrency.valueOf(333), "（ＩＲ）必要経費");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrShrkyksyahtykeihi(), BizCurrency.valueOf(99999), "（ＩＲ）支払時契約者必要経費");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrGsbnrkztsaeki(), BizCurrency.valueOf(99999), "（ＩＲ）源泉分離課税対象差益");
        exClassificationEquals(khTtdkkanryouBean.getIrZeimunaiyouhensyuctrlkbn(), C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU, "（ＩＲ）税務内容編集制御区分");
        exStringEquals(khTtdkkanryouBean.getIrBanknmkj(), "銀行名０１", "（ＩＲ）銀行名（漢字）");
        exStringEquals(khTtdkkanryouBean.getIrSitennmkj(), "支店名０１", "（ＩＲ）支店名（漢字）");
        exClassificationEquals(khTtdkkanryouBean.getIrYokinkbn(), C_YokinKbn.HUTUU, "（ＩＲ）預金種目区分");
        exStringEquals(khTtdkkanryouBean.getIrKouzano(), "1010101", "（ＩＲ）口座番号");
        exStringEquals(khTtdkkanryouBean.getIrKzmeiginmkn(), "口座名義人氏名", "（ＩＲ）口座名義人氏名（カナ）");
        exClassificationEquals(khTtdkkanryouBean.getIrHtsiryosyukbn(), C_HtsiryosyuKbn.BLNK, "（ＩＲ）法定資料種類区分");
        exClassificationEquals(khTtdkkanryouBean.getIrSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "（ＩＲ）送金先指定区分");
        exStringEquals(khTtdkkanryouBean.getIrKazeinendo(), "２０１６年", "（ＩＲ）課税年度");
        exClassificationEquals(khTtdkkanryouBean.getIrKaiyakujiyuu(), C_Kaiyakujiyuu.KYKSB, "（ＩＲ）解約事由");
        exClassificationEquals(khTtdkkanryouBean.getIrShrumu(), C_UmuKbn.ARI, "（ＩＲ）支払有無区分");
        exClassificationEquals(khTtdkkanryouBean.getIrYenshrtktekiumu(), C_UmuKbn.ARI, "（ＩＲ）円支払特約適用有無");
        exStringEquals(khTtdkkanryouBean.getIrBankcd(), "1001", "（ＩＲ）銀行コード");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrHnkngkkngk(), BizCurrency.valueOf(1321), "（ＩＲ）返金額（金額）");
        exStringEquals(khTtdkkanryouBean.getIrHnkntuukasyunm(), "円", "（ＩＲ）返金額通貨種類名");
        exStringEquals(khTtdkkanryouBean.getIrHnknymd(), "２０１６年　９月　９日", "（ＩＲ）返金日");
        exStringEquals(khTtdkkanryouBean.getIrZeimumongon1(), "税務文言１", "（ＩＲ）税務文言１");
        exStringEquals(khTtdkkanryouBean.getIrZeimumongon2(), "税務文言２", "（ＩＲ）税務文言２");
        exStringEquals(khTtdkkanryouBean.getIrZeimumongon3(), "税務文言３", "（ＩＲ）税務文言３");
        exStringEquals(khTtdkkanryouBean.getIrZeimumongon4(), "税務文言４", "（ＩＲ）税務文言４");
        exStringEquals(khTtdkkanryouBean.getIrZeimumongon5(), "税務文言５", "（ＩＲ）税務文言５");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon1(), "お知らせ文言１", "（ＩＲ）お知らせ文言１");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon2(), "お知らせ文言２", "（ＩＲ）お知らせ文言２");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon3(), "お知らせ文言３", "（ＩＲ）お知らせ文言３");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon4(), "お知らせ文言４", "（ＩＲ）お知らせ文言４");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon5(), "お知らせ文言５", "（ＩＲ）お知らせ文言５");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon6(), "お知らせ文言６", "（ＩＲ）お知らせ文言６");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon7(), "お知らせ文言７", "（ＩＲ）お知らせ文言７");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon8(), "お知らせ文言８", "（ＩＲ）お知らせ文言８");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon9(), "お知らせ文言９", "（ＩＲ）お知らせ文言９");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon10(), "お知らせ文言１０", "（ＩＲ）お知らせ文言１０");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon11(), "お知らせ文言１１", "（ＩＲ）お知らせ文言１１");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon12(), "お知らせ文言１２", "（ＩＲ）お知らせ文言１２");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon13(), "お知らせ文言１３", "（ＩＲ）お知らせ文言１３");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon14(), "お知らせ文言１４", "（ＩＲ）お知らせ文言１４");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon15(), "お知らせ文言１５", "（ＩＲ）お知らせ文言１５");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon16(), "お知らせ文言１６", "（ＩＲ）お知らせ文言１６");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon17(), "お知らせ文言１７", "（ＩＲ）お知らせ文言１７");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon18(), "お知らせ文言１８", "（ＩＲ）お知らせ文言１８");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon19(), "お知らせ文言１９", "（ＩＲ）お知らせ文言１９");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon20(), "お知らせ文言２０", "（ＩＲ）お知らせ文言２０");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon21(), "お知らせ文言２１", "（ＩＲ）お知らせ文言２１");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon22(), "お知らせ文言２２", "（ＩＲ）お知らせ文言２２");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon23(), "お知らせ文言２３", "（ＩＲ）お知らせ文言２３");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon24(), "お知らせ文言２４", "（ＩＲ）お知らせ文言２４");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon25(), "お知らせ文言２５", "（ＩＲ）お知らせ文言２５");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon26(), "お知らせ文言２６", "（ＩＲ）お知らせ文言２６");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon27(), "お知らせ文言２７", "（ＩＲ）お知らせ文言２７");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon28(), "お知らせ文言２８", "（ＩＲ）お知らせ文言２８");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon29(), "お知らせ文言２９", "（ＩＲ）お知らせ文言２９");
        exStringEquals(khTtdkkanryouBean.getIrOsirasemongon30(), "お知らせ文言３０", "（ＩＲ）お知らせ文言３０");
        exStringEquals(khTtdkkanryouBean.getIrShrnaiyouhskmongon1(), "支払内容補足文言１", "（ＩＲ）支払内容補足文言１");

        BzKokyakuAtesakiBean bzKokyakuAtesakiBean = (BzKokyakuAtesakiBean) rSBean[1];

        exStringEquals(bzKokyakuAtesakiBean.getIrTyouhyousakuseiymd(), "２０１５年１１月２５日", "（ＩＲ）帳票作成日");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsyno(), "1234567", "（ＩＲ）送付先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr1kj(), "送付先住所１", "（ＩＲ）送付先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr2kj(), "送付先住所２", "（ＩＲ）送付先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShadr3kj(), "送付先住所３", "（ＩＲ）送付先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrShsnmkj(), "送付先氏名", "（ＩＲ）送付先氏名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrHknkisynm(), "問合", "（ＩＲ）保険会社名称");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasesosiki(), "問合せ先組織名０１", "（ＩＲ）問合せ先組織名（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetantounm(), "", "（ＩＲ）問合せ先担当者名");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseyno(), "7654321", "（ＩＲ）問合せ先郵便番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr1kj(), "問合せ先住所１", "（ＩＲ）問合せ先住所１（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr2kj(), "問合せ先住所２", "（ＩＲ）問合せ先住所２（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseadr3kj(), "問合せ先住所３", "（ＩＲ）問合せ先住所３（漢字）");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawasetelno(), "111-2222-3333", "（ＩＲ）問合せ先電話番号");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou1(), "20160401", "（ＩＲ）問合せ先電話受付可能時間１");
        exStringEquals(bzKokyakuAtesakiBean.getIrToiawaseteluktkkanou2(), "20160402", "（ＩＲ）問合せ先電話受付可能時間２");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditBean_A3() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111129");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111129", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111129", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai1(), BizCurrency.valueOf(-111), "（ＩＲ）金額明細１");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm1(), "円", "（ＩＲ）金額明細通貨種類１");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditBean_A4() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111130", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111130", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai2(), BizCurrency.valueOf(-112), "（ＩＲ）金額明細２");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm2(), "円", "（ＩＲ）金額明細通貨種類２");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testEditBean_A5() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111141");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111141", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111141", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai3(), BizCurrency.valueOf(-113), "（ＩＲ）金額明細３");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm3(), "円", "（ＩＲ）金額明細通貨種類３");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testEditBean_A6() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111152");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111152", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111152", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai4(), BizCurrency.valueOf(-114), "（ＩＲ）金額明細４");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm4(), "円", "（ＩＲ）金額明細通貨種類４");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testEditBean_A7() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111163");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111163", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111163", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai5(), BizCurrency.valueOf(-115), "（ＩＲ）金額明細５");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm5(), "円", "（ＩＲ）金額明細通貨種類５");

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testEditBean_A8() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111174");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111174", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111174", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai6(), BizCurrency.valueOf(-116), "（ＩＲ）金額明細６");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm6(), "円", "（ＩＲ）金額明細通貨種類６");

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testEditBean_A9() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111185");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111185", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111185", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai7(), BizCurrency.valueOf(-117), "（ＩＲ）金額明細７");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm7(), "円", "（ＩＲ）金額明細通貨種類７");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testEditBean_A10() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111196");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111196", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111196", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai8(), BizCurrency.valueOf(-118), "（ＩＲ）金額明細８");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm8(), "円", "（ＩＲ）金額明細通貨種類８");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testEditBean_A11() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111200");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111200", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111200", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai9(), BizCurrency.valueOf(-119), "（ＩＲ）金額明細９");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm9(), "円", "（ＩＲ）金額明細通貨種類９");

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testEditBean_A12() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111211");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "11807111211", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "11807111211", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai10(), BizCurrency.valueOf(-120), "（ＩＲ）金額明細１０");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm10(), "円", "（ＩＲ）金額明細通貨種類１０");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testEditBean_A13() {

        RayHttpHeaderBeanMockForHozen.SYORIPTN = RayHttpHeaderBeanMockForHozen.TESTPATTERN1;

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806004659");
        IT_TtdkKan ttdkKan = kykKihon.getTtdkKanByHenkousikibetukey("100");
        IT_KykSya kykSya = null;

        YuyuBizConfig.getInstance().setHokenKaisyaNmKanji("保険会社");

        ReportServicesBean reportServicesBean = editTtdkKanryouTbl.editBean(syoruiCdKbn, khozenCommonParam, ttdkKan,
            kykSya);

        Object[] rSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.getValue());

        exNumericEquals(reportServicesBean.getKensakuKeys().length, 1, "検索キー配列の要素数");
        exNumericEquals(rSBean.length, 2, "パラメータオブジェクトの要素数");

        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806004659", "検索キー");

        KhTtdkkanryouBean khTtdkkanryouBean = (KhTtdkkanryouBean) rSBean[0];

        exStringEquals(khTtdkkanryouBean.getIrSyono(), "17806004659", "（ＩＲ）証券番号");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai1(), BizCurrency.valueOf(111), "（ＩＲ）金額明細１");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm1(), "円", "（ＩＲ）金額明細通貨種類１");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai2(), BizCurrency.valueOf(112), "（ＩＲ）金額明細２");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm2(), "円", "（ＩＲ）金額明細通貨種類２");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai3(), BizCurrency.valueOf(113), "（ＩＲ）金額明細３");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm3(), "円", "（ＩＲ）金額明細通貨種類３");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai4(), BizCurrency.valueOf(114), "（ＩＲ）金額明細４");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm4(), "円", "（ＩＲ）金額明細通貨種類４");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai5(), BizCurrency.valueOf(115), "（ＩＲ）金額明細５");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm5(), "円", "（ＩＲ）金額明細通貨種類５");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai6(), BizCurrency.valueOf(116), "（ＩＲ）金額明細６");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm6(), "円", "（ＩＲ）金額明細通貨種類６");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai7(), BizCurrency.valueOf(117), "（ＩＲ）金額明細７");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm7(), "円", "（ＩＲ）金額明細通貨種類７");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai8(), BizCurrency.valueOf(118), "（ＩＲ）金額明細８");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm8(), "円", "（ＩＲ）金額明細通貨種類８");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai9(), BizCurrency.valueOf(119), "（ＩＲ）金額明細９");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm9(), "円", "（ＩＲ）金額明細通貨種類９");
        exBizCalcbleEquals(khTtdkkanryouBean.getIrKngkmeisai10(), BizCurrency.valueOf(120), "（ＩＲ）金額明細１０");
        exStringEquals(khTtdkkanryouBean.getIrKngkmisituukasyunm10(), "円", "（ＩＲ）金額明細通貨種類１０");

    }
}

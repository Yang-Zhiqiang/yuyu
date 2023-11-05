package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;
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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSksMockForKhansyuu;
import yuyu.common.hozen.ascommon.SetMinusUriagebi;
import yuyu.common.hozen.ascommon.SetMinusUriagebiMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tkiktannaitukisuu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 */
@RunWith(OrderedRunner.class)
public class CommonNyuukinTest_exec4 extends AbstractTest {

    private final static String syoNo2 = "12806345742";

    private final static String syoNo3 = "12806345753";

    private final static String syoNo4 = "12806345764";

    private final static String syoNo5 = "12806345775";

    private final static String syoNo6 = "11808111270";

    private final static String syoNo7 = "11808111292";

    @Inject
    private CommonNyuukin commonNyuukin;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_入金共通処理";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(AnsyuuCommonSiwake.class).to(AnsyuuCommonSiwakeMockForKhansyuu.class);
                bind(SetYuuyokknmanryobi.class).to(SetYuuyokknmanryobiMockForKhansyuu.class);
                bind(EditKoujyonaiyouTbl.class).to(EditKoujyonaiyouTblMockForKhansyuu.class);
                bind(EditDairitenTesuuryouTbl.class).to(EditDairitenTesuuryouTblMockForKhansyuu.class);
                bind(SetMinusUriagebi.class).to(SetMinusUriagebiMockForKhansyuu.class);
                bind(CreditHnknTuutiSks.class).to(CreditHnknTuutiSksMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec4.class;
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec4.class;
        EditKoujyonaiyouTblMockForKhansyuu.caller = CommonNyuukinTest_exec4.class;
        EditDairitenTesuuryouTblMockForKhansyuu.caller = CommonNyuukinTest_exec4.class;
        SetMinusUriagebiMockForKhansyuu.caller = CommonNyuukinTest_exec4.class;
        CreditHnknTuutiSksMockForKhansyuu.caller = CommonNyuukinTest_exec4.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec4.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
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

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @AfterClass
    public static void testClear() {
        SetYuuyokknmanryobiMockForKhansyuu.caller = null;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = null;
        AnsyuuCommonSiwakeMockForKhansyuu.caller = null;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = null;
        EditKoujyonaiyouTblMockForKhansyuu.caller = null;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = null;
        EditDairitenTesuuryouTblMockForKhansyuu.caller = null;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = null;
        SetMinusUriagebiMockForKhansyuu.caller = null;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = null;
        CreditHnknTuutiSksMockForKhansyuu.caller = null;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_D2() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo2);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo2);
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(new BigDecimal("0")));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151231));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);


        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 2, "入金実績履歴テーブルリスト件数");
        exStringEquals(nyknJissekiRirekiLst.get(1).getSyono(), syoNo2, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201403"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(1).getRenno(), 10, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(1).getJyutouendym(), BizDateYM.valueOf("201502"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getRsgaku(), BizCurrency.valueOf(new BigDecimal("1000567890123")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(1).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000567890123")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNyksyoriymd(), BizDate.valueOf("20160104"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(1).getRyosyuymd(), BizDate.valueOf("20151231"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNykdenymd(), BizDate.valueOf("20151230"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(1).getJyutoukaisuuy(), 1, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(1).getJyutoukaisuum(), 0, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(1).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(1).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(1).getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(1).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 0, "仮受金テーブルリスト件数");

        List<IT_KykSyouhn> kykSyouhnLst = itKykKihon.getKykSyouhns();
        exNumericEquals(kykSyouhnLst.size(), 1, "契約商品テーブルリスト件数");
        exStringEquals(kykSyouhnLst.get(0).getSyono(), syoNo2, "証券番号");
        exClassificationEquals(kykSyouhnLst.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnLst.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(kykSyouhnLst.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnLst.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exClassificationEquals(kykSyouhnLst.get(0).getKykjyoutai(), C_Kykjyoutai.ZENNOU, "契約状態");
        exStringEquals(kykSyouhnLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<BT_SikinIdouRireki> sikinIdouRirekiList = bizDomManager.getAllSikinIdouRireki();
        exNumericEquals(sikinIdouRirekiList.size(), 0, "資金移動用履歴テーブル件数");

        ansyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(ansyuKihon.getSyono(), syoNo2, "証券番号");
        exDateYMEquals(ansyuKihon.getJkipjytym(), BizDateYM.valueOf("201503"), "次回Ｐ充当年月");
        exClassificationEquals(ansyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(ansyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(ansyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160401"), "主契約払満日");
        exStringEquals(ansyuKihon.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(ansyuKihon.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        IT_Tokusin tokusin = ansyuKihon.getTokusin();
        assertNull(tokusin);

        List<IT_Zennou> zennouLst = ansyuKihon.getZennous();
        exNumericEquals(zennouLst.size(), 3, "前納テーブルリスト件数");
        exStringEquals(zennouLst.get(2).getSyono(), syoNo2, "証券番号");
        exDateEquals(zennouLst.get(2).getZennoukaisiymd(), BizDate.valueOf("20160101"), "前納開始年月");
        exNumericEquals(zennouLst.get(2).getRenno(), 2, "連番");
        exDateEquals(zennouLst.get(2).getZennounyuukinsyoriymd(), BizDate.valueOf("20160104"), "前納入金処理日");
        exDateEquals(zennouLst.get(2).getZennounyuukindenymd(), BizDate.valueOf("20151230"), "前納入金伝票日付");
        exDateEquals(zennouLst.get(2).getRyosyuymd(), BizDate.valueOf("20151231"), "領収日");
        exStringEquals(zennouLst.get(2).getZennoukikan(), "1", "前納期間");
        exBizCalcbleEquals(zennouLst.get(2).getZennounyuukinkgk(), BizCurrency.valueOf(-1000567890123L), "前納入金額");
        exBizCalcbleEquals(zennouLst.get(2).getZennoujihrkp(), BizCurrency.valueOf(1000567890123L), "前納時払込保険料");
        exDateYMEquals(zennouLst.get(2).getAnnaisaikaiym(), BizDateYM.valueOf("201603"), "案内再開年月");
        exStringEquals(zennouLst.get(2).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(2).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo2, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());

        exDateEquals(
            (BizDate) MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "setBatchSyoriYmd", 0, 0),
            BizDate.valueOf("20160104"), "バッチ処理年月日");

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = (AnsyuuCommonSiwakeInBean)MockObjectManager.getArgument(AnsyuuCommonSiwakeMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(ansyuuCommonSiwakeInBean.getSyuudaikoCd(), C_Syuudaikocd.SIS, "収納代行社コード");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_D3() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo3);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo3);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160402"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(new BigDecimal("2000000003000")));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160330));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160403"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20180202"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160330));


        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(2000000003000L), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 1, "入金実績履歴テーブルリスト件数");
        exStringEquals(nyknJissekiRirekiLst.get(0).getSyono(), syoNo3, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201403"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutouendym(), BizDateYM.valueOf("201502"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRsgaku(), BizCurrency.valueOf(new BigDecimal("1000000000000")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000000000000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyksyoriymd(), BizDate.valueOf("20160402"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyuymd(), BizDate.valueOf("20160330"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNykdenymd(), BizDate.valueOf("20160331"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuuy(), 1, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(0).getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo3, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160402"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(2000000003000L), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160331"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201403"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 2, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160330"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_KykSyouhn> kykSyouhnLst = commonNyuukin.getKykKihon().getKykSyouhns();
        exNumericEquals(kykSyouhnLst.size(), 1, "契約商品テーブルリスト件数");
        exStringEquals(kykSyouhnLst.get(0).getSyono(), syoNo3, "証券番号");
        exClassificationEquals(kykSyouhnLst.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnLst.get(0).getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(kykSyouhnLst.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnLst.get(0).getKyksyouhnrenno(), 1, "契約商品連番");
        exClassificationEquals(kykSyouhnLst.get(0).getKykjyoutai(), C_Kykjyoutai.ZENNOU, "契約状態");
        exStringEquals(kykSyouhnLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        ansyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(ansyuKihon.getSyono(), syoNo3, "証券番号");
        exDateYMEquals(ansyuKihon.getJkipjytym(), BizDateYM.valueOf("201503"), "次回Ｐ充当年月");
        exClassificationEquals(ansyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(ansyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(ansyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160401"), "主契約払満日");
        exStringEquals(ansyuKihon.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(ansyuKihon.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        IT_Tokusin tokusin = ansyuKihon.getTokusin();
        assertNull(tokusin);

        List<IT_Zennou> zennouLst = ansyuKihon.getZennous();
        exNumericEquals(zennouLst.size(), 1, "前納テーブルリスト件数");
        exStringEquals(zennouLst.get(0).getSyono(), syoNo3, "証券番号");
        exDateEquals(zennouLst.get(0).getZennoukaisiymd(), BizDate.valueOf("20160101"), "前納開始年月");
        exNumericEquals(zennouLst.get(0).getRenno(), 1, "連番");
        exDateEquals(zennouLst.get(0).getZennounyuukinsyoriymd(), BizDate.valueOf("20160402"), "前納入金処理日");
        exDateEquals(zennouLst.get(0).getZennounyuukindenymd(), BizDate.valueOf("20160331"), "前納入金伝票日付");
        exDateEquals(zennouLst.get(0).getRyosyuymd(), BizDate.valueOf("20160330"), "領収日");
        exStringEquals(zennouLst.get(0).getZennoukikan(), "1", "前納期間");
        exBizCalcbleEquals(zennouLst.get(0).getZennounyuukinkgk(), BizCurrency.valueOf(-1000000000000L), "前納入金額");
        exBizCalcbleEquals(zennouLst.get(0).getZennoujihrkp(), BizCurrency.valueOf(1000000000000L), "前納時払込保険料");
        exDateYMEquals(zennouLst.get(0).getAnnaisaikaiym(), BizDateYM.valueOf("201603"), "案内再開年月");
        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo3, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_D4() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo4);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo4);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160401"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(-1000000001000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160331));
        nyuukinTRParam.setKzHurikaeBankCd(null);
        nyuukinTRParam.setKzHurikaeSitenCd(null);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160401"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20180202"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160331));


        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(-1000000001000L), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo4, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160401"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(-1000000001000L), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160331"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201403"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 2, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160331"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        ansyuKihon = commonNyuukin.getAnsyuKihon();

        IT_Tokusin tokusin = ansyuKihon.getTokusin();
        assertNotNull(tokusin);

        List<IT_Zennou> zennouLst = ansyuKihon.getZennous();
        exNumericEquals(zennouLst.size(), 0, "前納テーブルリスト件数");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo4, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_D5() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo5);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo5);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20140103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000002000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20140103));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20140103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000000002000L), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 0, "仮受金テーブルリスト件数");

        ansyuKihon = commonNyuukin.getAnsyuKihon();
        IT_Tokusin tokusin = ansyuKihon.getTokusin();
        assertNotNull(tokusin);

        List<IT_Zennou> zennouLst = ansyuKihon.getZennous();
        exNumericEquals(zennouLst.size(), 1, "前納テーブルリスト件数");
        exStringEquals(zennouLst.get(0).getSyono(), syoNo5, "証券番号");
        exDateEquals(zennouLst.get(0).getZennoukaisiymd(), BizDate.valueOf("20150101"), "前納開始年月");
        exNumericEquals(zennouLst.get(0).getRenno(), 1, "連番");
        exDateEquals(zennouLst.get(0).getZennounyuukinsyoriymd(), BizDate.valueOf("20140103"), "前納入金処理日");
        exDateEquals(zennouLst.get(0).getZennounyuukindenymd(), BizDate.valueOf("20140103"), "前納入金伝票日付");
        exDateEquals(zennouLst.get(0).getRyosyuymd(), BizDate.valueOf("20140103"), "領収日");
        exStringEquals(zennouLst.get(0).getZennoukikan(), "2", "前納期間");
        exBizCalcbleEquals(zennouLst.get(0).getZennounyuukinkgk(), BizCurrency.valueOf(0), "前納入金額");
        exBizCalcbleEquals(zennouLst.get(0).getZennoujihrkp(), BizCurrency.valueOf(1000), "前納時払込保険料");
        exDateYMEquals(zennouLst.get(0).getAnnaisaikaiym(), BizDateYM.valueOf("201603"), "案内再開年月");
        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 2, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo5, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        exNumericEquals(itKhDenpyoDataList.get(1).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(1).getSyono(), syoNo5, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(1).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(1).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(1).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(1).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(1).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(1).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(1).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(1).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNotNull(commonNyuukin.getKhFBSoukinData());
        IT_KhFBSoukinData khFBSoukinData = commonNyuukin.getKhFBSoukinData();

        exNumericEquals(khFBSoukinData.getEdano(), 0, "枝番");
        exClassificationEquals(khFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(khFBSoukinData.getSyoricd(), "RG9F", "処理コード");
        exStringEquals(khFBSoukinData.getSyorisosikicd(), "12340000", "処理組織コード");
        exDateEquals(khFBSoukinData.getSyoriYmd(), BizDate.valueOf("20140103"), "処理年月日");
        exDateEquals(khFBSoukinData.getDenymd(), BizDate.valueOf("20140108"), "伝票日付");
        exStringEquals(khFBSoukinData.getSyono(), syoNo5, "証券番号");
        exClassificationEquals(khFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(khFBSoukinData.getBankcd(), "0001", "銀行コード");
        exStringEquals(khFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(khFBSoukinData.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khFBSoukinData.getKouzano(), "123456789012", "口座番号");
        exStringEquals(khFBSoukinData.getKzmeiginmkn(), "口座名義人氏名１口座名義人氏名２口座名義人氏名３口座名義人氏", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(khFBSoukinData.getSoukingk(), BizCurrency.valueOf(1000000002000L), "送金金額");
        exClassificationEquals(khFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(0), "外貨対価額");
        exBizCalcbleEquals(khFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(0), "送金用為替レート");
        exStringEquals(khFBSoukinData.getGyoumuKousinKinou(), "khcommon", "機能ＩＤ");
        exStringEquals(khFBSoukinData.getGyoumuKousinsyaId(), "JUnit", "ユーザーＩＤ");


        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syoNo5, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20140103"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201403"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 2, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 0, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("1000000002000")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20140103"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20140103"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "1001", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "101", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_D6() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo6);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo6);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20140103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000002000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20140103));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20140103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000000002000L), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 0, "仮受金テーブルリスト件数");

        ansyuKihon = commonNyuukin.getAnsyuKihon();
        IT_Tokusin tokusin = ansyuKihon.getTokusin();
        assertNotNull(tokusin);

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 2, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo6, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        exNumericEquals(itKhDenpyoDataList.get(1).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(1).getSyono(), syoNo6, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(1).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(1).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(1).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(1).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(1).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(1).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(1).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(1).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNotNull(commonNyuukin.getKhFBSoukinData());
        IT_KhFBSoukinData khFBSoukinData = commonNyuukin.getKhFBSoukinData();

        exNumericEquals(khFBSoukinData.getEdano(), 0, "枝番");
        exClassificationEquals(khFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(khFBSoukinData.getSyoricd(), "RG9F", "処理コード");
        exStringEquals(khFBSoukinData.getSyorisosikicd(), "12340000", "処理組織コード");
        exDateEquals(khFBSoukinData.getSyoriYmd(), BizDate.valueOf("20140103"), "処理年月日");
        exDateEquals(khFBSoukinData.getDenymd(), BizDate.valueOf("20140108"), "伝票日付");
        exStringEquals(khFBSoukinData.getSyono(), syoNo6, "証券番号");
        exClassificationEquals(khFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(khFBSoukinData.getBankcd(), "0001", "銀行コード");
        exStringEquals(khFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(khFBSoukinData.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khFBSoukinData.getKouzano(), "123456789012", "口座番号");
        exStringEquals(khFBSoukinData.getKzmeiginmkn(), "口座名義人氏名１口座名義人氏名２口座名義人氏名３口座名義人氏", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(khFBSoukinData.getSoukingk(), BizCurrency.valueOf(1000000002000L), "送金金額");
        exClassificationEquals(khFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(0), "外貨対価額");
        exBizCalcbleEquals(khFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(0), "送金用為替レート");
        exStringEquals(khFBSoukinData.getGyoumuKousinKinou(), "khcommon", "機能ＩＤ");
        exStringEquals(khFBSoukinData.getGyoumuKousinsyaId(), "JUnit", "ユーザーＩＤ");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_D7() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo7);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo7);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151231));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        MockObjectManager.assertNotCalled(EditDairitenTesuuryouTblMockForKhansyuu.class, "setBatchSyoriYmd");

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_D8() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = CreditHnknTuutiSksMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000286");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000286");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000286");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20140103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000002000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20140103));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20140103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setCreditkessaiyouno("22345678901234567890123456");

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000000002000L), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 0, "仮受金テーブルリスト件数");

        ansyuKihon = commonNyuukin.getAnsyuKihon();
        IT_Tokusin tokusin = ansyuKihon.getTokusin();
        assertNotNull(tokusin);
        assertNotNull(commonNyuukin.getKhDenpyoDatas());
        assertNull(commonNyuukin.getKhFBSoukinData());
        IT_SyuunouHenknRireki syuunouHenknRireki = commonNyuukin.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getSyono(), "17806000286", "証券番号");
        exStringEquals(syuunouHenknRireki.getDenrenno(), "100001", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 0, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf("20151230"), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf("20151231"), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(1000000002000L), "返金額");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "22345678901234567890123456", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_D9() {
        changeSystemDate(BizDate.valueOf(20201207));
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setSyoricd("RB30");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000493");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000493");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000493");
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201403));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151231));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);


        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        BT_SikinIdouRireki sikinIdouRireki = bizDomManager.getSikinIdouRireki(BizDate.valueOf(20201207), "1");
        exDateEquals(sikinIdouRireki.getSyoriYmd(), BizDate.valueOf(20201207), "処理年月日");
        exStringEquals(sikinIdouRireki.getKeirisyorirenno(), "1", "経理用処理連番");
        exStringEquals(sikinIdouRireki.getSyono(), "17806000493", "証券番号");
        exStringEquals(sikinIdouRireki.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exStringEquals(sikinIdouRireki.getTargetKinouId(), "khcommon", "対象機能ＩＤ");
        exStringEquals(sikinIdouRireki.getSkno(), "", "請求番号");
        exNumericEquals(sikinIdouRireki.getSeikyuurirekino(), 0, "請求履歴番号");
        exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(sikinIdouRireki.getNykshrkbn(), C_NykshrKbn.NYUUKIN, "入金支払区分");
        exStringEquals(sikinIdouRireki.getSyoricd(), "RB30", "処理コード");
        exClassificationEquals(sikinIdouRireki.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exClassificationEquals(sikinIdouRireki.getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(sikinIdouRireki.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(sikinIdouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(sikinIdouRireki.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exStringEquals(sikinIdouRireki.getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(sikinIdouRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(sikinIdouRireki.getKyksyouhnrenno(), 1, "契約商品連番");
        exClassificationEquals(sikinIdouRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exDateYMEquals(sikinIdouRireki.getPhendoukaisiym(), null, "Ｐ変動開始年月");
        exBizCalcbleEquals(sikinIdouRireki.getPhendoumaegk(), BizCurrency.valueOf(0), "Ｐ変動前金額");
        exBizCalcbleEquals(sikinIdouRireki.getPhendougogk(), BizCurrency.valueOf(0), "Ｐ変動後金額");
        exDateEquals(sikinIdouRireki.getKykymd(), BizDate.valueOf(20160101), "契約日");
        exDateEquals(sikinIdouRireki.getSeirituymd(), BizDate.valueOf(20201105), "成立日");
        exDateYMEquals(sikinIdouRireki.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exClassificationEquals(sikinIdouRireki.getShrsyorikbn(), C_ShrsyoriKbn.BLNK, "支払処理区分");
        exClassificationEquals(sikinIdouRireki.getSeikyuusyubetu(), C_SeikyuuSyubetu.BLNK, "請求種別");
        exClassificationEquals(sikinIdouRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateYMEquals(sikinIdouRireki.getJkipjytym(), BizDateYM.valueOf(201503), "次回Ｐ充当年月");
        exDateYMEquals(sikinIdouRireki.getJyutoustartym(), BizDateYM.valueOf(201403), "充当開始年月");
        exDateYMEquals(sikinIdouRireki.getJyutouendym(), BizDateYM.valueOf(201502), "充当終了年月");
        exClassificationEquals(sikinIdouRireki.getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exClassificationEquals(sikinIdouRireki.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(sikinIdouRireki.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exBizCalcbleEquals(sikinIdouRireki.getHrkp(), BizCurrency.valueOf(1000), "払込保険料");
        exBizCalcbleEquals(sikinIdouRireki.getHokenryou(), BizCurrency.valueOf(223456789), "保険料");

    }
}
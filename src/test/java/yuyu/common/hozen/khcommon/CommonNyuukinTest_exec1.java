package yuyu.common.hozen.khcommon;

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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 入金共通処理クラスのメソッド {@link CommonNyuukin#exec(KhozenCommonParam,NyuukinTRParam,C_YouhiKbn,C_YouhiKbn,AnsyuuBatSyoriHunoKykMisslistSks)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonNyuukinTest_exec1 {

    private final static String syoNo1 = "12806345672";

    private final static String syoNo2 = "12806345683";

    private final static String syoNo3 = "12806345694";

    @Inject
    private CommonNyuukin commonNyuukin;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou asKinou;

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
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec1.class;
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec1.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec1.class, fileName, sheetName);
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

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @AfterClass
    public static void testClear() {
        SetYuuyokknmanryobiMockForKhansyuu.caller = null;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = null;
        AnsyuuCommonSiwakeMockForKhansyuu.caller = null;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo1);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo1);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo1);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.OTHER);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201601"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd(null);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKEKEIJYOU);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        ansyuKihon = commonNyuukin.getAnsyuKihon();

        List<IT_AnsyuRireki> itAnsyuRirekiList = ansyuKihon.getAnsyuRirekis();
        exNumericEquals(itAnsyuRirekiList.size(), 8, "案内収納履歴テーブルリスト件数");
        exStringEquals(itAnsyuRirekiList.get(1).getSyono(), syoNo1, "証券番号");
        exClassificationEquals(itAnsyuRirekiList.get(1).getNyknaiyoukbn(), C_NyknaiyouKbn.OTHER, "入金内容区分");
        exDateYMEquals(itAnsyuRirekiList.get(1).getJyuutouym(), BizDateYM.valueOf("201601"), "充当年月");
        exNumericEquals(itAnsyuRirekiList.get(1).getAnnaino(), 1, "案内番号");
        exClassificationEquals(itAnsyuRirekiList.get(1).getKrkkeijyoflg(), C_UmuKbn.ARI, "仮受計上フラグ");
        exDateEquals(itAnsyuRirekiList.get(1).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exNumericEquals(itAnsyuRirekiList.get(1).getKrkno(), 1, "仮受番号");
        exClassificationEquals(itAnsyuRirekiList.get(1).getAnnaijkkbn(), C_AnnaijkKbn.NYUUKIN, "案内状況区分");
        exDateEquals(itAnsyuRirekiList.get(1).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exStringEquals(itAnsyuRirekiList.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuRirekiList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exClassificationEquals(itAnsyuRirekiList.get(0).getCredituriagengjiyuu(), null, "クレジットカード売上請求NG事由");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

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
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.OTHER);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201601"));
        nyuukinTRParam.setJyutouKaisuuY("10");
        nyuukinTRParam.setJyutouKaisuuM("11");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000000000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd(null);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKEKEIJYOU);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        nyuukinTRParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(new BigDecimal("1000000000000")), "仮受金額");

        ansyuKihon = commonNyuukin.getAnsyuKihon();

        List<IT_AnsyuRireki> itAnsyuRirekiList = ansyuKihon.getAnsyuRirekis();
        exNumericEquals(itAnsyuRirekiList.size(), 2, "案内収納履歴テーブルリスト件数");
        exStringEquals(itAnsyuRirekiList.get(0).getSyono(), syoNo2, "証券番号");
        exClassificationEquals(itAnsyuRirekiList.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.OTHER, "入金内容区分");
        exDateYMEquals(itAnsyuRirekiList.get(0).getJyuutouym(), BizDateYM.valueOf("201601"), "充当年月");
        exNumericEquals(itAnsyuRirekiList.get(0).getAnnaino(), 1, "案内番号");
        exClassificationEquals(itAnsyuRirekiList.get(0).getKrkkeijyoflg(), C_UmuKbn.ARI, "仮受計上フラグ");
        exDateEquals(itAnsyuRirekiList.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exNumericEquals(itAnsyuRirekiList.get(0).getKrkno(), 10000, "仮受番号");
        exClassificationEquals(itAnsyuRirekiList.get(0).getAnnaijkkbn(), C_AnnaijkKbn.NYUUKIN, "案内状況区分");
        exDateEquals(itAnsyuRirekiList.get(0).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exStringEquals(itAnsyuRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exClassificationEquals(itAnsyuRirekiList.get(0).getCredituriagengjiyuu(), C_CreditUriageNgJiyuuKbn.SEIJYOU, "クレジットカード売上請求NG事由");

        List<IT_Kariukekin> kariukekinLst = commonNyuukin.getKykKihon().getKariukekins();
        exNumericEquals(kariukekinLst.size(), 2, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(1).getSyono(), syoNo2, "証券番号");
        exNumericEquals(kariukekinLst.get(1).getKrkno(), 10000, "仮受番号");
        exDateEquals(kariukekinLst.get(1).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(1).getKrkgk(), BizCurrency.valueOf(new BigDecimal("1000000000000")), "仮受金額");
        exDateEquals(kariukekinLst.get(1).getHasseidenymd(), BizDate.valueOf("20160103"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(1).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(1).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(1).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(1).getNyknaiyoukbn(), C_NyknaiyouKbn.OTHER, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(1).getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exDateYMEquals(kariukekinLst.get(1).getJyuutouym(), BizDateYM.valueOf("201601"), "充当年月");
        exNumericEquals(kariukekinLst.get(1).getJyutoukaisuuy(), 10, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(1).getJyutoukaisuum(), 11, "充当回数（月）");
        exDateEquals(kariukekinLst.get(1).getRyosyuymd(), BizDate.valueOf("20160103"), "領収日");
        exStringEquals(kariukekinLst.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(1).getCreditkessaiyouno(), "", "クレジットカード決済用番号");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo3);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo3);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CONVENI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160103));
        nyuukinTRParam.setKzHurikaeBankCd(null);
        nyuukinTRParam.setKzHurikaeSitenCd(null);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd(null);
        nyuukinTRParam.setNykhouhouKbn(null);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        ansyuKihon = commonNyuukin.getAnsyuKihon();

        List<IT_AnsyuRireki> itAnsyuRirekiList = ansyuKihon.getAnsyuRirekis();
        exNumericEquals(itAnsyuRirekiList.size(), 1, "案内収納履歴テーブルリスト件数");
        exStringEquals(itAnsyuRirekiList.get(0).getSyono(), syoNo3, "証券番号");
        exClassificationEquals(itAnsyuRirekiList.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(itAnsyuRirekiList.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itAnsyuRirekiList.get(0).getAnnaino(), 1, "案内番号");
        exClassificationEquals(itAnsyuRirekiList.get(0).getKrkkeijyoflg(), C_UmuKbn.NONE, "仮受計上フラグ");
        exDateEquals(itAnsyuRirekiList.get(0).getKrkkeijyoymd(), null, "仮受計上処理日");
        exNumericEquals(itAnsyuRirekiList.get(0).getKrkno(), 0, "仮受番号");
        exClassificationEquals(itAnsyuRirekiList.get(0).getAnnaijkkbn(), C_AnnaijkKbn.NYUUKIN, "案内状況区分");
        exDateEquals(itAnsyuRirekiList.get(0).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exStringEquals(itAnsyuRirekiList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuRirekiList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exClassificationEquals(itAnsyuRirekiList.get(0).getCredituriagengjiyuu(), null, "クレジットカード売上請求NG事由");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806345708");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("12806345708");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("12806345708");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.OTHER);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201601"));
        nyuukinTRParam.setJyutouKaisuuY("10");
        nyuukinTRParam.setJyutouKaisuuM("11");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000000000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd(null);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKEKEIJYOU);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        nyuukinTRParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.RINJI);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(new BigDecimal("1000000000000")), "仮受金額");

        ansyuKihon = commonNyuukin.getAnsyuKihon();

        List<IT_AnsyuRireki> itAnsyuRirekiList = ansyuKihon.getAnsyuRirekis();
        exNumericEquals(itAnsyuRirekiList.size(), 1, "案内収納履歴テーブルリスト件数");
        exStringEquals(itAnsyuRirekiList.get(0).getSyono(), "12806345708", "証券番号");
        exClassificationEquals(itAnsyuRirekiList.get(0).getAnnaijkkbn(), C_AnnaijkKbn.ANNAI, "案内状況区分");
    }
}
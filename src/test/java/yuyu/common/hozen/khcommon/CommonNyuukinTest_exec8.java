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

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.def.biz.manager.BizDomManager;
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
public class CommonNyuukinTest_exec8 {

    private final static String syoNo1 = "17806000013";

    private final static String syoNo2 = "17806000024";

    private final static String syoNo3 = "17806000035";

    private final static String syoNo4 = "17806000046";

    private final static String syoNo5 = "17806000057";

    private final static String syoNo6 = "17806000068";

    private final static String syoNo7 = "17806000079";

    private final static String syoNo8 = "17806000080";

    private final static String syoNo9 = "17806000091";

    private final static String syoNo10 = "17806000105";

    @Inject
    private CommonNyuukin commonNyuukin;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private BaseUserInfo baseUserInfo;

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
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec8.class;
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec8.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec6.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ008", testDataAndTblMap);
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
        AnsyuuCommonSiwakeMockForKhansyuu.caller = null;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = null;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = null;
        SetYuuyokknmanryobiMockForKhansyuu.caller = null;
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    @Transactional
    public void testExec_H1() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo1);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160503"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.OTHER);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(2000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160330));
        nyuukinTRParam.setKzHurikaeBankCd(null);
        nyuukinTRParam.setKzHurikaeSitenCd(null);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(null);
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setDenymd(BizDate.valueOf("20160403"));


        try{
            commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。伝票の締切日を過ぎているため処理できません。伝票日付＝20160403　伝票日付の伝票締切日＝20160502", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_H2() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo2);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160502"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160729));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160801"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20180202"));
        nyuukinTRParam.setDenymd(BizDate.valueOf("20160403"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo2, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160502"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(1000), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160403"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160729"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_H3() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo3);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160501"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160929));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20161103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setDenymd(BizDate.valueOf("20160403"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo3, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160501"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160403"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160929"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_H4() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo4);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160202"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151130));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setDenymd(BizDate.valueOf("20160203"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo4, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160202"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160203"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20151130"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_H5() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo5);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160203"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151130));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setDenymd(BizDate.valueOf("20160203"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo5, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160203"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160203"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20151130"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_H6() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo6);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160801"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160729));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160801"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20180202"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160729));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo6, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160801"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(1000), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160801"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160729"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_H7() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo7);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20161004"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160929));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20161005"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo7, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20161004"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160930"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160929"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_H8() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo8);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160202"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151130));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20151130));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo8, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160202"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160202"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20151130"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_H9() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo9);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160202"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160302));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo9, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160202"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160202"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160302"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_H10() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo10);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160202"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201603"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160202));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo10, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160202"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160202"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160202"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }
}
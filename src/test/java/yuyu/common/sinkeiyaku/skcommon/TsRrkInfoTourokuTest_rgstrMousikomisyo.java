package yuyu.common.sinkeiyaku.skcommon;

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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 訂正履歴情報登録のメソッド {@link TsRrkInfoTouroku#rgstrMousikomisyo(
 * TsRrkInfoTourokuRgstrMousikomisyoUiBeanParam, String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TsRrkInfoTourokuTest_rgstrMousikomisyo extends AbstractTest {

    private static final String SYSTIME = "20160429100000001";
    private static final String SOUSASYACD = "sousasyatest";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_訂正履歴情報登録";

    private final static String sheetName = "INデータ";

    @Inject
    private TsRrkInfoTouroku tsRrkInfoTouroku;

    @Inject
    private TsRrkInfoTourokuRgstrMousikomisyoUiBeanParamImpl uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(TsRrkInfoTourokuTest_rgstrMousikomisyo.class, fileName,
                sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap, true);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(110)
    @Transactional
    public void testRgstrMousikomisyo_A1() {
        uiBean.setMosno("861110005");
        try {
            tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110005", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(120)
    @Transactional
    public void testRgstrMousikomisyo_A2() {
        uiBean.setMosno("861110013");
        try {
            tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110013", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(130)
    @Transactional
    public void testRgstrMousikomisyo_A3() {
        uiBean.setMosno("861110021");
        try {
            tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110021", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(130)
    @Transactional
    public void testRgstrMousikomisyo_A4() {
        uiBean.setMosno("860000017");
        try {
            tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=860000017", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testRgstrMousikomisyo_B1() {
        String mosno = "861110054";
        uiBean.setMosno(mosno);
        uiBean.setAitemosno("971110036");
        uiBean.setDoujikaiyakusyono("17806000013");
        uiBean.setMosymd(BizDate.valueOf(20160101));
        uiBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);
        uiBean.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        uiBean.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.SASSI);
        uiBean.setFatcasnsikbn(C_FatcasnsiKbn.GAITOU);
        uiBean.setBikkjnssinfokbn(C_BikkjnssinfoKbn.ARI);
        uiBean.setBikknzsyno("201100001");
        uiBean.setAeoisnsikbn(C_AeoisnsiKbn.BLNK);
        uiBean.setKyknmkn("ケイヤク１");
        uiBean.setKyknmkj("契約者１");
        uiBean.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setKykseiymd(BizDate.valueOf(20050701));
        uiBean.setKyksei(C_Kyksei.FEMALE);
        uiBean.setKyktdk(C_Tdk.SINTOU3);
        uiBean.setTsinyno("5508001");
        uiBean.setTsinadr1kj("通信先１１");
        uiBean.setTsinadr2kj("通信先１２");
        uiBean.setTsinadr3kj("通信先１３");
        uiBean.setTsintelno("01-1022-2001");
        uiBean.setDai2tsintelno("01-1055-5001");
        uiBean.setHhknnmkn("ヒホケン１");
        uiBean.setHhknnmkj("被保険者１");
        uiBean.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setHhknseiymd(BizDate.valueOf(20060601));
        uiBean.setHhknsei(C_Hhknsei.MALE);
        uiBean.setTsindousiteikbn(C_TsindousiteiKbn.ARI);
        uiBean.setHhknyno("5417001");
        uiBean.setHhknadr1kj("被保険者住所１１");
        uiBean.setHhknadr2kj("被保険者住所１２");
        uiBean.setHhknadr3kj("被保険者住所１３");
        uiBean.setHhkntelno("02-3055-8001");
        uiBean.setKktymd(BizDate.valueOf(20160419));
        uiBean.setHhknsykgycd("201");
        uiBean.setHhknnensyuukbn(C_NensyuuKbn.MORETHAN1000);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testRgstrMousikomisyo_B2() {
        String mosno = "861110062";
        uiBean.setMosno(mosno);
        uiBean.setAitemosno("971110036");
        uiBean.setDoujikaiyakusyono("17806000013");
        uiBean.setMosymd(BizDate.valueOf(20160101));
        uiBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);
        uiBean.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        uiBean.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.BLNK);
        uiBean.setFatcasnsikbn(C_FatcasnsiKbn.BLNK);
        uiBean.setBikkjnssinfokbn(C_BikkjnssinfoKbn.BLNK);
        uiBean.setBikknzsyno("201100001");
        uiBean.setAeoisnsikbn(C_AeoisnsiKbn.BLNK);
        uiBean.setKyknmkn("ケイヤク３");
        uiBean.setKyknmkj("契約者３");
        uiBean.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setKykseiymd(BizDate.valueOf(20050703));
        uiBean.setKyksei(C_Kyksei.HJNKYK);
        uiBean.setKyktdk(C_Tdk.HTSZN);
        uiBean.setTsinyno("5508003");
        uiBean.setTsinadr1kj("通信先３１");
        uiBean.setTsinadr2kj("通信先３２");
        uiBean.setTsinadr3kj("通信先３３");
        uiBean.setTsintelno("01-1022-2003");
        uiBean.setDai2tsintelno("01-1055-5003");
        uiBean.setHhknnmkn("ヒホケン３");
        uiBean.setHhknnmkj("被保険者３");
        uiBean.setHhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setHhknseiymd(BizDate.valueOf(20060603));
        uiBean.setHhknsei(C_Hhknsei.FEMALE);
        uiBean.setTsindousiteikbn(C_TsindousiteiKbn.BLNK);
        uiBean.setHhknyno("5417003");
        uiBean.setHhknadr1kj("被保険者住所３１");
        uiBean.setHhknadr2kj("被保険者住所３２");
        uiBean.setHhknadr3kj("被保険者住所被保険者住所被保険者住所被保険者住所被保険者住所");
        uiBean.setHhkntelno("02-3055-8003");
        uiBean.setKktymd(BizDate.valueOf(20160419));
        uiBean.setHhknsykgycd("203");
        uiBean.setHhknnensyuukbn(C_NensyuuKbn.MORETHAN1000);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee",
            "ffffffffffgggggggggghhhhhhhhhhjjjjjjjjjjkkkkkkkkkk", "sousasyatest123");

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 36, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110062", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "ffffffffffgggggggggghhhhhhhhhhjjjjjjjjjjkkkkkkkkkk",
            "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "相手申込番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "971110044", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "971110036", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest123", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest123", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "同時解約証券番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "17806000024", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "17806000013", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "申込日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "2016. 1. 2", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "2016. 1. 1", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "保険種類", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）（指数連動プラン）", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "契約者区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "契被別", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "契被同一", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "約款受領方法", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "冊子での受取り（すでに冊子をお受け取りいただいている場合）", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "ＦＡＴＣＡ宣誓", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "該当", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "米国人示唆情報", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "米国納税者番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "201100002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "201100001", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "ＡＥＯＩ宣誓", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "該当", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "契約者名（カナ）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "ケイヤク２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "ケイヤク３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "契約者名（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "契約者２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "契約者３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "契約者名漢字化不可区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "漢字化不可", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(13).getTskmnm(), "契約者生年月日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(13).getTsmaenaiyou(), "H17. 7. 2", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(13).getTsgonaiyou(), "H17. 7. 3", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(14).getTskmnm(), "契約者性別", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(14).getTsmaenaiyou(), "男性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(14).getTsgonaiyou(), "法人契約", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(15).getTskmnm(), "契約者続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(15).getTsmaenaiyou(), "３親等の親族", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(15).getTsgonaiyou(), "法定相続人", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(16).getTskmnm(), "通信先郵便番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(16).getTsmaenaiyou(), "5508002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(16).getTsgonaiyou(), "5508003", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(17).getTskmnm(), "通信先住所１（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(17).getTsmaenaiyou(), "通信先２１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(17).getTsgonaiyou(), "通信先３１", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(18).getTskmnm(), "通信先住所２（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(18).getTsmaenaiyou(), "通信先２２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(18).getTsgonaiyou(), "通信先３２", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(19).getTskmnm(), "通信先住所３（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(19).getTsmaenaiyou(), "通信先２３", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(19).getTsgonaiyou(), "通信先３３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(20).getTskmnm(), "通信先電話番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(20).getTsmaenaiyou(), "01-1022-2002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(20).getTsgonaiyou(), "01-1022-2003", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(21).getTskmnm(), "第２通信先電話番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(21).getTsmaenaiyou(), "01-1055-5002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(21).getTsgonaiyou(), "01-1055-5003", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(22).getTskmnm(), "被保険者名（カナ）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(22).getTsmaenaiyou(), "ヒホケン２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(22).getTsgonaiyou(), "ヒホケン３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(23).getTskmnm(), "被保険者名（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(23).getTsmaenaiyou(), "被保険者２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(23).getTsgonaiyou(), "被保険者３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(24).getTskmnm(), "被保険者名漢字化不可区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(24).getTsmaenaiyou(), "漢字化不可", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(24).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(25).getTskmnm(), "被保険者生年月日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(25).getTsmaenaiyou(), "H18. 6. 2", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(25).getTsgonaiyou(), "H18. 6. 3", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(26).getTskmnm(), "被保険者性別", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(26).getTsmaenaiyou(), "男性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(26).getTsgonaiyou(), "女性", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(27).getRenno3keta(), 28, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(27).getTskmnm(), "通信先同一指定", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(27).getTsmaenaiyou(), "指定あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(27).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(28).getRenno3keta(), 29, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(28).getTskmnm(), "被保険者郵便番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(28).getTsmaenaiyou(), "5417002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(28).getTsgonaiyou(), "5417003", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(29).getRenno3keta(), 30, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(29).getTskmnm(), "被保険者住所１（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(29).getTsmaenaiyou(), "被保険者住所２１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(29).getTsgonaiyou(), "被保険者住所３１", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(30).getRenno3keta(), 31, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(30).getTskmnm(), "被保険者住所２（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(30).getTsmaenaiyou(), "被保険者住所２２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(30).getTsgonaiyou(), "被保険者住所３２", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(31).getMosno(), "861110062", "申込番号");
        exStringEquals(kmTsRirekiLst.get(31).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(31).getRenno3keta(), 32, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(31).getKinouId(), "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeee", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(31).getKinouModeId(), "ffffffffffgggggggggghhhhhhhhhhjjjjjjjjjjkkkkkkkkkk",
            "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(31).getTskmnm(), "被保険者住所３（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(31).getTsmaenaiyou(), "被保険者住所被保険者住所被保険者住所被保険者住所１２３４５６", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(31).getTsgonaiyou(), "被保険者住所被保険者住所被保険者住所被保険者住所被保険者住所", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(31).getTantid(), "sousasyatest123", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(31).getGyoumuKousinsyaId(), "sousasyatest123", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(31).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exStringEquals(kmTsRirekiLst.get(31).getKousinsyaId(), null, "更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(31).getKousinTime(), null, "更新日時");
        exStringEquals(kmTsRirekiLst.get(31).getKousinKinou(), null, "更新機能ＩＤ");
        exNumericEquals(kmTsRirekiLst.get(32).getRenno3keta(), 33, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(32).getTskmnm(), "被保険者電話番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(32).getTsmaenaiyou(), "02-3055-8002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(32).getTsgonaiyou(), "02-3055-8003", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(33).getRenno3keta(), 34, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(33).getTskmnm(), "告知日", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(33).getTsmaenaiyou(), "2016. 4.20", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(33).getTsgonaiyou(), "2016. 4.19", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(34).getRenno3keta(), 35, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(34).getTskmnm(), "被保険者職業コード", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(34).getTsmaenaiyou(), "202", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(34).getTsgonaiyou(), "203", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(35).getRenno3keta(), 36, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(35).getTskmnm(), "被保険者年収", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(35).getTsmaenaiyou(), "７００～１０００万円未満", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(35).getTsgonaiyou(), "１０００万円以上", "訂正後内容");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testRgstrMousikomisyo_C1() {
        String mosno = "861110112";
        uiBean.setMosno(mosno);
        uiBean.setNenkinuktkbn(C_UktKbn.KYK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testRgstrMousikomisyo_C2() {
        String mosno = "861110120";
        uiBean.setMosno(mosno);
        uiBean.setNenkinuktkbn(C_UktKbn.KYK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110120", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "年金受取人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "被保険者と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "契約者と同じ", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testRgstrMousikomisyo_C3() {
        String mosno = "861110138";
        uiBean.setMosno(mosno);
        uiBean.setNenkinuktkbn(C_UktKbn.KYK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110138", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "年金受取人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "契約者と同じ", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testRgstrMousikomisyo_D1() {
        String mosno = "861110146";
        uiBean.setMosno(mosno);
        uiBean.setSbuktnin(5);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testRgstrMousikomisyo_D2() {
        String mosno = "861110153";
        uiBean.setMosno(mosno);
        uiBean.setSbuktnin(3);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110153", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "死亡受取人人数", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "4", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "3", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(510)
    @Transactional
    public void testRgstrMousikomisyo_E1() {
        String mosno = "861110161";
        uiBean.setMosno(mosno);
        uiBean.setSibouuktkbn1(C_UktKbn.KYK);
        uiBean.setSibouuktnmkana1("ニンメイカナ１");
        uiBean.setSibouuktnmkanji1("死亡受取人名１");
        uiBean.setSibouuktnmkanjikahukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd1(BizDate.valueOf(19900217));
        uiBean.setSibouukttdk1(C_Tdk.KO);
        uiBean.setSibouuktbnwari1(BizNumber.valueOf(50));
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testRgstrMousikomisyo_E2() {
        String mosno = "861110179";
        uiBean.setMosno(mosno);
        uiBean.setSibouuktkbn1(C_UktKbn.KYK);
        uiBean.setSibouuktnmkana1("ニンメイカナ１１");
        uiBean.setSibouuktnmkanji1("死亡受取人名１１");
        uiBean.setSibouuktnmkanjikahukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd1(BizDate.valueOf(19950101));
        uiBean.setSibouukttdk1(C_Tdk.BLNK);
        uiBean.setSibouuktbnwari1(BizNumber.valueOf(15));
        uiBean.setSibouuktkbn2(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSibouuktnmkana2("ニンメイカナ１２");
        uiBean.setSibouuktnmkanji2("死亡受取人名１２");
        uiBean.setSibouuktnmkanjikahukakbn2(C_KjkhukaKbn.BLNK);
        uiBean.setSibouuktseiymd2(BizDate.valueOf(19950202));
        uiBean.setSibouukttdk2(C_Tdk.SHB);
        uiBean.setSibouuktbnwari2(BizNumber.valueOf(25));
        uiBean.setSibouuktkbn3(C_UktKbn.BLNK);
        uiBean.setSibouuktnmkana3("ニンメイカナ１３");
        uiBean.setSibouuktnmkanji3("死亡受取人名１３");
        uiBean.setSibouuktnmkanjikahukakbn3(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd3(BizDate.valueOf(19950303));
        uiBean.setSibouukttdk3(C_Tdk.MAGO);
        uiBean.setSibouuktbnwari3(BizNumber.valueOf(35));
        uiBean.setSibouuktkbn4(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSibouuktnmkana4("ニンメイカナ１４");
        uiBean.setSibouuktnmkanji4("死亡受取人名１４");
        uiBean.setSibouuktnmkanjikahukakbn4(C_KjkhukaKbn.BLNK);
        uiBean.setSibouuktseiymd4(BizDate.valueOf(19950404));
        uiBean.setSibouukttdk4(C_Tdk.SONOTA);
        uiBean.setSibouuktbnwari4(BizNumber.valueOf(45));
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 28, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110179", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "死亡受取人区分1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "契約者と同じ", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "死亡受取人氏名（カナ）1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "ニンメイカナ１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "ニンメイカナ１１", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "死亡受取人氏名（漢字）1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "死亡受取人名１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "死亡受取人名１１", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "死亡受取人名漢字化不可1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "漢字化不可", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "死亡受取人生年月日1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "S40. 1. 1", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "H 7. 1. 1", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "死亡受取人続柄1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "配偶者", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "死亡受取人分割割合1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "50", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "15", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "死亡受取人区分2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "契約者と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "特定名義", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "死亡受取人氏名（カナ）2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "ニンメイカナ２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "ニンメイカナ１２", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "死亡受取人氏名（漢字）2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "死亡受取人名２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "死亡受取人名１２", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "死亡受取人名漢字化不可2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "漢字化不可", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "死亡受取人生年月日2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "S17. 2. 2", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "H 7. 2. 2", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "死亡受取人続柄2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "親", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "祖父母", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(13).getTskmnm(), "死亡受取人分割割合2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(13).getTsmaenaiyou(), "20", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(13).getTsgonaiyou(), "25", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(14).getTskmnm(), "死亡受取人区分3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(14).getTsmaenaiyou(), "特定名義", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(14).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(15).getTskmnm(), "死亡受取人氏名（カナ）3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(15).getTsmaenaiyou(), "ニンメイカナ３", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(15).getTsgonaiyou(), "ニンメイカナ１３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(16).getTskmnm(), "死亡受取人氏名（漢字）3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(16).getTsmaenaiyou(), "死亡受取人名３", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(16).getTsgonaiyou(), "死亡受取人名１３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(17).getTskmnm(), "死亡受取人名漢字化不可3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(17).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(17).getTsgonaiyou(), "漢字化不可", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(18).getTskmnm(), "死亡受取人生年月日3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(18).getTsmaenaiyou(), "H 2. 3. 3", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(18).getTsgonaiyou(), "H 7. 3. 3", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(19).getTskmnm(), "死亡受取人続柄3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(19).getTsmaenaiyou(), "子", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(19).getTsgonaiyou(), "孫", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(20).getTskmnm(), "死亡受取人分割割合3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(20).getTsmaenaiyou(), "25", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(20).getTsgonaiyou(), "35", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(21).getTskmnm(), "死亡受取人区分4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(21).getTsmaenaiyou(), "契約者と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(21).getTsgonaiyou(), "特定名義", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(22).getTskmnm(), "死亡受取人氏名（カナ）4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(22).getTsmaenaiyou(), "ニンメイカナ４", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(22).getTsgonaiyou(), "ニンメイカナ１４", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(23).getTskmnm(), "死亡受取人氏名（漢字）4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(23).getTsmaenaiyou(), "死亡受取人名４", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(23).getTsgonaiyou(), "死亡受取人名１４", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(24).getTskmnm(), "死亡受取人名漢字化不可4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(24).getTsmaenaiyou(), "漢字化不可", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(24).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(25).getTskmnm(), "死亡受取人生年月日4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(25).getTsmaenaiyou(), "S41. 4. 4", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(25).getTsgonaiyou(), "H 7. 4. 4", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(26).getTskmnm(), "死亡受取人続柄4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(26).getTsmaenaiyou(), "兄弟姉妹", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(26).getTsgonaiyou(), "その他", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(27).getRenno3keta(), 28, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(27).getTskmnm(), "死亡受取人分割割合4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(27).getTsmaenaiyou(), "5", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(27).getTsgonaiyou(), "45", "訂正後内容");
    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testRgstrMousikomisyo_E3() {
        String mosno = "861110187";
        uiBean.setMosno(mosno);
        uiBean.setSibouuktkbn1(C_UktKbn.KYK);
        uiBean.setSibouuktnmkana1("ニンメイカナ１１");
        uiBean.setSibouuktnmkanji1("死亡受取人名１１");
        uiBean.setSibouuktnmkanjikahukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd1(BizDate.valueOf(19950101));
        uiBean.setSibouukttdk1(C_Tdk.HGU);
        uiBean.setSibouuktbnwari1(BizNumber.valueOf(15));
        uiBean.setSibouuktkbn2(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSibouuktnmkana2("ニンメイカナ１２");
        uiBean.setSibouuktnmkanji2("死亡受取人名１２");
        uiBean.setSibouuktnmkanjikahukakbn2(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd2(BizDate.valueOf(19950202));
        uiBean.setSibouukttdk2(C_Tdk.SHB);
        uiBean.setSibouuktbnwari2(BizNumber.valueOf(25));
        uiBean.setSibouuktkbn3(C_UktKbn.KYK);
        uiBean.setSibouuktnmkana3("ニンメイカナ１３");
        uiBean.setSibouuktnmkanji3("死亡受取人名１３");
        uiBean.setSibouuktnmkanjikahukakbn3(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd3(BizDate.valueOf(19950303));
        uiBean.setSibouukttdk3(C_Tdk.MAGO);
        uiBean.setSibouuktbnwari3(BizNumber.valueOf(35));
        uiBean.setSibouuktkbn4(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSibouuktnmkana4("ニンメイカナ１４");
        uiBean.setSibouuktnmkanji4("死亡受取人名１４");
        uiBean.setSibouuktnmkanjikahukakbn4(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd4(BizDate.valueOf(19950404));
        uiBean.setSibouukttdk4(C_Tdk.BLNK);
        uiBean.setSibouuktbnwari4(BizNumber.valueOf(45));
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 27, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110187", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "死亡受取人区分1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "契約者と同じ", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "死亡受取人氏名（カナ）1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "ニンメイカナ１１", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "死亡受取人氏名（漢字）1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "死亡受取人名１１", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "死亡受取人名漢字化不可1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "漢字化不可", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "死亡受取人生年月日1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "H 7. 1. 1", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "死亡受取人続柄1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "配偶者", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "死亡受取人分割割合1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "15", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "死亡受取人区分2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "特定名義", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "死亡受取人氏名（カナ）2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "ニンメイカナ１２", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "死亡受取人氏名（漢字）2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "死亡受取人名１２", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "死亡受取人名漢字化不可2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "漢字化不可", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "死亡受取人生年月日2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "H 7. 2. 2", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "死亡受取人続柄2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "祖父母", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(13).getTskmnm(), "死亡受取人分割割合2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(13).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(13).getTsgonaiyou(), "25", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(14).getTskmnm(), "死亡受取人区分3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(14).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(14).getTsgonaiyou(), "契約者と同じ", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(15).getTskmnm(), "死亡受取人氏名（カナ）3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(15).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(15).getTsgonaiyou(), "ニンメイカナ１３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(16).getTskmnm(), "死亡受取人氏名（漢字）3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(16).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(16).getTsgonaiyou(), "死亡受取人名１３", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(17).getTskmnm(), "死亡受取人名漢字化不可3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(17).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(17).getTsgonaiyou(), "漢字化不可", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(18).getTskmnm(), "死亡受取人生年月日3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(18).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(18).getTsgonaiyou(), "H 7. 3. 3", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(19).getTskmnm(), "死亡受取人続柄3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(19).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(19).getTsgonaiyou(), "孫", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(20).getTskmnm(), "死亡受取人分割割合3", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(20).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(20).getTsgonaiyou(), "35", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(21).getTskmnm(), "死亡受取人区分4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(21).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(21).getTsgonaiyou(), "特定名義", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(22).getTskmnm(), "死亡受取人氏名（カナ）4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(22).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(22).getTsgonaiyou(), "ニンメイカナ１４", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(23).getTskmnm(), "死亡受取人氏名（漢字）4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(23).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(23).getTsgonaiyou(), "死亡受取人名１４", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(24).getTskmnm(), "死亡受取人名漢字化不可4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(24).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(24).getTsgonaiyou(), "漢字化不可", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(25).getTskmnm(), "死亡受取人生年月日4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(25).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(25).getTsgonaiyou(), "H 7. 4. 4", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(26).getTskmnm(), "死亡受取人分割割合4", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(26).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(26).getTsgonaiyou(), "45", "訂正後内容");
    }

    @Test
    @TestOrder(610)
    @Transactional
    public void testRgstrMousikomisyo_F1() {
        String mosno = "861110195";
        uiBean.setMosno(mosno);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(620)
    @Transactional
    public void testRgstrMousikomisyo_F2() {
        String mosno = "861110203";
        uiBean.setMosno(mosno);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110203", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "被保険者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "付加しない", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(810)
    @Transactional
    public void testRgstrMousikomisyo_H1() {
        String mosno = "861110039";
        uiBean.setMosno(mosno);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        uiBean.setSyudai1hknkknmosinput("5");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.AUD);
        uiBean.setHrktuukasyu(C_Tuukasyu.USD);
        uiBean.setSyukihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI5);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        uiBean.setHrkkeiro(C_Hrkkeiro.BLNK);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.BLNK);
        uiBean.setZnnkai(0);
        uiBean.setMosikkatup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.BLNK);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU6);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(820)
    @Transactional
    public void testRgstrMousikomisyo_H2() {
        String mosno = "861110047";
        uiBean.setMosno(mosno);
        uiBean.setSyuhrkkkn(10);
        uiBean.setSyuhrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        uiBean.setSyuhknkkn(18);
        uiBean.setSyuhknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        uiBean.setSyudai1hknkknmosinput("11");
        uiBean.setSdpdkbn(C_Sdpd.PD);
        uiBean.setKyktuukasyu(C_Tuukasyu.AUD);
        uiBean.setHrktuukasyu(C_Tuukasyu.USD);
        uiBean.setSyukihons(BizCurrency.valueOf(15000, BizCurrencyTypes.DOLLAR));
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(10000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setSueokikknmosinput("50");
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI10);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.BLNK);
        uiBean.setZnnkai(13);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU2);
        uiBean.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setMossyukykp(null);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 24, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110047", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "払込期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "0", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "10", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "払込期間歳満期区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "年", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "歳", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "保険期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "0", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "18", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "保険期間歳満期区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "歳", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "年", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "第１保険期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "0", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "11", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "Ｓ建Ｐ建", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "擬似Ｐ建", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "Ｐ建", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "年金種類", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "５年確定", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "１０年確定", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "全期前納", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "前納期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "13", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "払込回数", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "年２回払", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "月払", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "払込経路", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "団体", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "口座振替", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "初回保険料払込経路", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "口座振替", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "クレジットカード扱い", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "定期一括払回数", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "２か月定期一括払", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(13).getTskmnm(), "指定通貨／選択通貨", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(13).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(13).getTsgonaiyou(), "豪ドル", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(14).getTskmnm(), "払込通貨", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(14).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(14).getTsgonaiyou(), "米ドル", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(15).getTskmnm(), "保険金額／給付金額", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(15).getTsmaenaiyou(), "15,000.00 豪ドル", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(15).getTsgonaiyou(), "15,000.00 米ドル", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(16).getTskmnm(), "払込金額", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(16).getTsmaenaiyou(), "10,000.00 米ドル", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(16).getTsgonaiyou(), "10,000.00 豪ドル", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(17).getTskmnm(), "定期一括払保険料", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(17).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(17).getTsgonaiyou(), "100 円", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(18).getTskmnm(), "前納保険料", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(18).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(18).getTsgonaiyou(), "100 円", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(19).getTskmnm(), "指数連動", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(19).getTsmaenaiyou(), "１０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(19).getTsgonaiyou(), "２０％", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(20).getTskmnm(), "定率積立", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(20).getTsmaenaiyou(), "２０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(20).getTsgonaiyou(), "１０％", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(21).getTskmnm(), "据置期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(21).getTsmaenaiyou(), "60", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(21).getTsgonaiyou(), "50", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(22).getTskmnm(), "最低保証水準", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(22).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(22).getTsgonaiyou(), "１００％", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(23).getTskmnm(), "個人年金保険料税制適格特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(23).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(23).getTsgonaiyou(), "付加する", "訂正後内容");
    }

    @Test
    @TestOrder(830)
    @Transactional
    public void testRgstrMousikomisyo_H3() {
        String mosno = "861110245";
        uiBean.setMosno(mosno);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        uiBean.setSyudai1hknkknmosinput("5");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setSyukihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setSueokikknmosinput("50");
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI5);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        uiBean.setHrkkeiro(C_Hrkkeiro.BLNK);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.BLNK);
        uiBean.setZnnkai(0);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU2);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 6, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110245", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "前納期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "2", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "定期一括払回数", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "６か月定期一括払", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "２か月定期一括払", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "定期一括払保険料", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "100 円", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "前納保険料", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "100 円", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "据置期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "35", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "50", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "個人年金保険料税制適格特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "付加する", "訂正後内容");
    }

    @Test
    @TestOrder(840)
    @Transactional
    public void testRgstrMousikomisyo_H4() {
        String mosno = "860000041";
        uiBean.setMosno(mosno);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        uiBean.setSyudai1hknkknmosinput("5");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.AUD);
        uiBean.setHrktuukasyu(C_Tuukasyu.USD);
        uiBean.setSyukihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI5);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        uiBean.setHrkkeiro(C_Hrkkeiro.BLNK);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.BLNK);
        uiBean.setZnnkai(0);
        uiBean.setMosikkatup(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.BLNK);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU6);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(850)
    @Transactional
    public void testRgstrMousikomisyo_H5() {
        String mosno = "860000306";
        uiBean.setMosno(mosno);
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        uiBean.setSyudai1hknkknmosinput("5");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setSyukihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setHrktuukasyukykp(null);
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI5);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        uiBean.setHrkkeiro(C_Hrkkeiro.BLNK);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.NONE);
        uiBean.setZnnkai(0);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU2);
        uiBean.setMossyukykp(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 8, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000306", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "保険料払込満了年齢", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "30", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "0", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "年金支払開始年齢", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "35", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "0", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "前納期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "2", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "定期一括払回数", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "６か月定期一括払", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "２か月定期一括払", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "定期一括払保険料", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "100 円", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "保険料", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "10,000.00 米ドル", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "100 円", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "前納保険料", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "100 円", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "個人年金保険料税制適格特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "付加する", "訂正後内容");
    }

    @Test
    @TestOrder(860)
    @Transactional
    public void testRgstrMousikomisyo_H6() {
        String mosno = "860000298";
        uiBean.setMosno(mosno);
        uiBean.setSyuhrkkkn(19);
        uiBean.setSyuhrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        uiBean.setSyuhknkkn(24);
        uiBean.setSyuhknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        uiBean.setSyudai1hknkknmosinput("5");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setSyukihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setHrktuukasyukykp(null);
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI5);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        uiBean.setHrkkeiro(C_Hrkkeiro.BLNK);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.NONE);
        uiBean.setZnnkai(2);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU6);
        uiBean.setMossyukykp(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 2, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "860000298", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "払込期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "30", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "19", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "保険期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "35", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "24", "訂正後内容");
    }

    @Test
    @TestOrder(1110)
    @Transactional
    public void testRgstrMousikomisyo_K1() {
        String mosno = "861110096";
        uiBean.setMosno(mosno);
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstksbnkkn(10);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("");
        uiBean.setSitencd("");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
        uiBean.setKzmeiginmkn("");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();
        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1120)
    @Transactional
    public void testRgstrMousikomisyo_K2() {
        String mosno = "861110104";
        uiBean.setMosno(mosno);
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU105);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET200);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstksbnkkn(10);
        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        uiBean.setBankcd("1101");
        uiBean.setSitencd("201");
        uiBean.setYokinkbn(C_YokinKbn.HUTUU);
        uiBean.setKouzano("110112340001");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
        uiBean.setKzmeiginmkn("サトウユキ１");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 13, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110104", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "指定通貨建年金保険定期支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "付加する", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "定期支払金支払通貨", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "円貨", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "指定通貨", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "支払金指定口座情報銀行コード", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "1102", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "1101", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "支払金指定口座情報支店コード", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "202", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "201", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "支払金指定口座情報預金種目", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "当座", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "普通", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "支払金指定口座情報口座番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "110112340002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "110112340001", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "支払金指定口座情報口座名義人同一区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "指定", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "同一", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "支払金指定口座情報口座名義人", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "サトウユキ２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "目標額割合", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "１２０％", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "２００％", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "初期死亡時円換算支払額最低保証特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "付加する", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "重度介護前払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "付加する", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "付加しない", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "年金支払特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "付加する", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "年金支払特約期間", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "20", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "10", "訂正後内容");
    }

    @Test
    @TestOrder(710)
    @Transactional
    public void testRgstrMousikomisyo_G1() {
        String mosno = "861110211";
        uiBean.setMosno(mosno);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSiteidruktnmkn("ダイリニンシメイ");
        uiBean.setSiteidruktnmkj("代理人氏名");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(720)
    @Transactional
    public void testRgstrMousikomisyo_G2() {
        String mosno = "861110229";
        uiBean.setMosno(mosno);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSiteidruktnmkn("ダイリニンシメイ");
        uiBean.setSiteidruktnmkj("代理人氏名");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn1("登録家族名（カナ）１");
        uiBean.setTrkkzknmkj1("登録家族名（漢字）１１");
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf("19850420"));
        uiBean.setTrkkzksei1(C_Seibetu.FEMALE);
        uiBean.setTrkkzktdk1(C_Tdk.MAGO);
        uiBean.setStdrskseiymd(BizDate.valueOf(19900101));

        uiBean.setKykdrtkykhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKykdrkbn(C_UktKbn.TOUROKUKAZOKU1);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);

        uiBean.setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 24, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110229", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "ご家族登録サービス", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "申し込まない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "申し込む", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族氏名（カナ）１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "トウロクカゾクカナ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "登録家族名（カナ）１", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "登録家族氏名（漢字）１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "登録家族名（漢字）１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "登録家族名（漢字）１１", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "登録家族名漢字化不可１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "漢字化不可", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "登録家族生年月日１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "S63. 4.21", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "S60. 4.20", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "登録家族性別１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "男性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "女性", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "登録家族続柄１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "兄弟姉妹", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "孫", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "登録家族通信先同一指定１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "指定あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "登録家族郵便番号１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "9897654", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "登録家族住所１（漢字）１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "登録家族住所１（漢字）１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "登録家族住所２（漢字）１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "登録家族住所２（漢字）１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "登録家族住所３（漢字）１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "登録家族住所３（漢字）１", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "登録家族通信先電話番号１", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "080-1234-5678", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(13).getTskmnm(), "保険契約者代理特約", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(13).getTsmaenaiyou(), "付加しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(13).getTsgonaiyou(), "付加する", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(14).getTskmnm(), "契約者代理人区分", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(14).getTsmaenaiyou(), "登録家族２人目と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(14).getTsgonaiyou(), "登録家族１人目と同じ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(15).getTskmnm(), "被保険者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(15).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(15).getTsgonaiyou(), "付加する", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(16).getTskmnm(), "被保険者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(16).getTsmaenaiyou(), "死亡受取人と同じ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(16).getTsgonaiyou(), "特定名義", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(17).getTskmnm(), "被保険者代理人氏名（カナ）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(17).getTsmaenaiyou(), "ダイリニンシメイカナ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(17).getTsgonaiyou(), "ダイリニンシメイ", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(18).getTskmnm(), "被保険者代理人氏名（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(18).getTsmaenaiyou(), "代理人氏名漢字", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(18).getTsgonaiyou(), "代理人氏名", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(19).getTskmnm(), "被保険者代理人名漢字化不可区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(19).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(19).getTsgonaiyou(), "漢字化不可", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(20).getTskmnm(), "被保険者代理人生年月日", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(20).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(20).getTsgonaiyou(), "H 2. 1. 1", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(21).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(21).getTsmaenaiyou(), "親", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(21).getTsgonaiyou(), "配偶者", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(22).getTskmnm(), "ダイレクトサービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(22).getTsmaenaiyou(), "後続事務で確認", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(22).getTsgonaiyou(), "申し込む", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(23).getTskmnm(), "円貨払込額のご案内通知", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(23).getTsmaenaiyou(), "郵送を希望しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(23).getTsgonaiyou(), "郵送を希望する", "訂正後内容");
    }

    @Test
    @TestOrder(730)
    @Transactional
    public void testRgstrMousikomisyo_G3() {
        String mosno = "861110237";
        uiBean.setMosno(mosno);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSiteidruktnmkn("ダイリニンシメイ");
        uiBean.setSiteidruktnmkj("代理人氏名");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkn2("登録家族名（カナ）１");
        uiBean.setTrkkzknmkj2("登録家族名（漢字）１１");
        uiBean.setTrkkzknmkjkhukakbn2(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn2(C_TsindousiteiKbn.BLNK);
        uiBean.setTrkkzkseiymd2(BizDate.valueOf("19850420"));
        uiBean.setTrkkzksei2(C_Seibetu.FEMALE);
        uiBean.setTrkkzktdk2(C_Tdk.MAGO);
        uiBean.setStdrskseiymd(BizDate.valueOf(19900101));

        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);

        uiBean.setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 22, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110237", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");

        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "ご家族登録サービス", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "申し込まない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "申し込む", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "登録家族氏名（カナ）２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "トウロクカゾクカナ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "登録家族名（カナ）１", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "登録家族氏名（漢字）２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "登録家族名（漢字）２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "登録家族名（漢字）１１", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "登録家族名漢字化不可２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "漢字化不可", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "登録家族生年月日２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "S63. 4.21", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "S60. 4.20", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "登録家族性別２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "男性", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "女性", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "登録家族続柄２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "兄弟姉妹", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "孫", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "登録家族通信先同一指定２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "指定あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "登録家族郵便番号２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "9897654", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(9).getTskmnm(), "登録家族住所１（漢字）２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(9).getTsmaenaiyou(), "登録家族住所１（漢字）２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(9).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(10).getTskmnm(), "登録家族住所２（漢字）２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(10).getTsmaenaiyou(), "登録家族住所２（漢字）２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(10).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(11).getTskmnm(), "登録家族住所３（漢字）２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(11).getTsmaenaiyou(), "登録家族住所３（漢字）２", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(11).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(12).getTskmnm(), "登録家族通信先電話番号２", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(12).getTsmaenaiyou(), "080-1234-5678", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(12).getTsgonaiyou(), "", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(13).getTskmnm(), "被保険者代理特約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(13).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(13).getTsgonaiyou(), "付加する", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(14).getTskmnm(), "被保険者代理人区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(14).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(14).getTsgonaiyou(), "特定名義", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(15).getTskmnm(), "被保険者代理人氏名（カナ）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(15).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(15).getTsgonaiyou(), "ダイリニンシメイ", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(16).getTskmnm(), "被保険者代理人氏名（漢字）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(16).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(16).getTsgonaiyou(), "代理人氏名", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(17).getTskmnm(), "被保険者代理人名漢字化不可区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(17).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(17).getTsgonaiyou(), "漢字化不可", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(18).getTskmnm(), "被保険者代理人生年月日", "入力相違項目");
        exStringEquals(kmTsRirekiLst.get(18).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(18).getTsgonaiyou(), "H 2. 1. 1", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(19).getTskmnm(), "被保険者代理人続柄", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(19).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(19).getTsgonaiyou(), "配偶者", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(20).getTskmnm(), "ダイレクトサービス", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(20).getTsmaenaiyou(), "申し込まない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(20).getTsgonaiyou(), "申し込む", "訂正後内容");

        exNumericEquals(kmTsRirekiLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(21).getTskmnm(), "円貨払込額のご案内通知", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(21).getTsmaenaiyou(), "郵送を希望しない", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(21).getTsgonaiyou(), "郵送を希望する", "訂正後内容");
    }

    @Test
    @TestOrder(1310)
    @Transactional
    public void testRgstrMousikomisyo_M1() {
        String mosno = "861110294";
        uiBean.setMosno(mosno);
        uiBean.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.UNTEN);
        uiBean.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PASSPORT);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI);
        uiBean.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.BLNK);
        uiBean.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.ARI);

        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 5, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110294", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "契約者", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "5:健康保険被保険者証", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "1:運転免許証・運転経歴証明書", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "親権者・後見人", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "6:船員保険被保険者証", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "2:パスポート", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "ご家族等への説明方法", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "ご家族等事前説明（対面）", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "ご家族等同席", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "面談回数（２回以上）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "取扱者以外の同席", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "あり", "訂正後内容");
    }

    @Test
    @TestOrder(1320)
    @Transactional
    public void testRgstrMousikomisyo_M2() {
        String mosno = "861110302";
        uiBean.setMosno(mosno);
        uiBean.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.UNTEN);
        uiBean.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PASSPORT);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI);
        uiBean.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.BLNK);
        uiBean.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.ARI);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 5, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110302", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "契約者", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "15:健康保険被保険者証", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "11:運転免許証・運転経歴証明書", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "親権者・後見人", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "16:船員保険被保険者証", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "12:パスポート", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "ご家族等への説明方法", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "ご家族等事前説明（対面）", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "ご家族等同席", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "面談回数（２回以上）", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "取扱者以外の同席", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "あり", "訂正後内容");
    }

    @Test
    @TestOrder(1330)
    @Transactional
    public void testRgstrMousikomisyo_M3() {
        String mosno = "861110310";
        uiBean.setMosno(mosno);
        uiBean.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.UNTEN);
        uiBean.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PASSPORT);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI);
        uiBean.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.BLNK);
        uiBean.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.ARI);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1410)
    @Transactional
    public void testRgstrMousikomisyo_N1() {
        String mosno = "861110328";
        uiBean.setMosno(mosno);
        uiBean.setDrtenjimcd1("1501");
        uiBean.setDairitenkinyuukikancd1("1521");
        uiBean.setDairitenkinyuukikansitencd1("301");
        uiBean.setDairitentoriatukaikouincd1("200000001501");
        uiBean.setInputbosyuucd1("1234566");
        uiBean.setBosyuunintourokuno1("1001234501501");
        uiBean.setGyousekikeijyousakisosikicd1("6001501");
        uiBean.setDairitenbuntanwariai1(BizNumber.valueOf(50));
        uiBean.setCifcd("130011234500001");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1420)
    @Transactional
    public void testRgstrMousikomisyo_N2() {
        String mosno = "861110336";
        uiBean.setMosno(mosno);
        uiBean.setDrtenjimcd1("1501");
        uiBean.setDairitenkinyuukikancd1("1521");
        uiBean.setDairitenkinyuukikansitencd1("301");
        uiBean.setDairitentoriatukaikouincd1("200000001501");
        uiBean.setInputbosyuucd1("1234582");
        uiBean.setBosyuunintourokuno1("1001234501501");
        uiBean.setGyousekikeijyousakisosikicd1("6001501");
        uiBean.setDairitenbuntanwariai1(BizNumber.valueOf(50));
        uiBean.setCifcd("130011234500003");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 9, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110336", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "代理店事務所コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "1503", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "1501", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "代理店金融機関コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "1523", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "1521", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "代理店金融機関支店コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "303", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "301", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "代理店取扱行員コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "200000001503", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "200000001501", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "入力募集人コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "1234566", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "1234582", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "募集人登録番号1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "1001234501503", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "1001234501501", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "業績計上先組織コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "6001503", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "6001501", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "代理店分担割合1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "30", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "50", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "ＣＩＦコード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "130011234500002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "130011234500003", "訂正後内容");
    }

    @Test
    @TestOrder(1430)
    @Transactional
    public void testRgstrMousikomisyo_N3() {
        String mosno = "861110476";
        uiBean.setMosno(mosno);
        uiBean.setDrtenjimcd1("1501");
        uiBean.setDairitenkinyuukikancd1("1521");
        uiBean.setDairitenkinyuukikansitencd1("301");
        uiBean.setDairitentoriatukaikouincd1("200000001501");
        uiBean.setInputbosyuucd1("4015001");
        uiBean.setBosyuunintourokuno1("1001234501501");
        uiBean.setGyousekikeijyousakisosikicd1("6001501");
        uiBean.setDairitenbuntanwariai1(BizNumber.valueOf(50));
        uiBean.setCifcd("130011234500003");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 9, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110476", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "代理店事務所コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "1501", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "代理店金融機関コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "1521", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "代理店金融機関支店コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "301", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "代理店取扱行員コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "200000001501", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "入力募集人コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "4015001", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "募集人登録番号1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "1001234501501", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "業績計上先組織コード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "6001501", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "代理店分担割合1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "50", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(8).getTskmnm(), "ＣＩＦコード1", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(8).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(8).getTsgonaiyou(), "130011234500003", "訂正後内容");
    }

    @Test
    @TestOrder(1510)
    @Transactional
    public void testRgstrMousikomisyo_O1() {
        String mosno = "861110344";
        uiBean.setMosno(mosno);
        uiBean.setUktkid("14010000001");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1520)
    @Transactional
    public void testRgstrMousikomisyo_O2() {
        String mosno = "861110351";
        uiBean.setMosno(mosno);
        uiBean.setUktkid("14010000003");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110351", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "受付管理ＩＤ", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "14010000002", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "14010000003", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(1610)
    @Transactional
    public void testRgstrMousikomisyo_P1() {
        String mosno = "861110369";
        uiBean.setMosno(mosno);
        uiBean.setDrtenjimcd2("1502");
        uiBean.setDairitenkinyuukikancd2("1522");
        uiBean.setDairitenkinyuukikansitencd2("302");
        uiBean.setDairitentoriatukaikouincd2("200000001502");
        uiBean.setInputbosyuucd2("1234566");
        uiBean.setBosyuunintourokuno2("1001234501502");
        uiBean.setGyousekikeijyousakisosikicd2("6001502");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1620)
    @Transactional
    public void testRgstrMousikomisyo_P2() {
        String mosno = "861110377";
        uiBean.setMosno(mosno);
        uiBean.setDrtenjimcd2("1502");
        uiBean.setDairitenkinyuukikancd2("1522");
        uiBean.setDairitenkinyuukikansitencd2("302");
        uiBean.setDairitentoriatukaikouincd2("200000001502");
        uiBean.setInputbosyuucd2("1234582");
        uiBean.setBosyuunintourokuno2("1001234501502");
        uiBean.setGyousekikeijyousakisosikicd2("6001502");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 7, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110377", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "代理店事務所コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "1504", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "1502", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "代理店金融機関コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "1524", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "1522", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "代理店金融機関支店コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "304", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "302", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "代理店取扱行員コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "200000001504", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "200000001502", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "入力募集人コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "1234566", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "1234582", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "募集人登録番号2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "1001234501504", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "1001234501502", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "業績計上先組織コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "6001504", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "6001502", "訂正後内容");
    }

    @Test
    @TestOrder(1630)
    @Transactional
    public void testRgstrMousikomisyo_P3() {
        String mosno = "861110385";
        uiBean.setMosno(mosno);
        uiBean.setDrtenjimcd2("1506");
        uiBean.setDairitenkinyuukikancd2("1526");
        uiBean.setDairitenkinyuukikansitencd2("306");
        uiBean.setDairitentoriatukaikouincd2("200000001506");
        uiBean.setInputbosyuucd2("4015006");
        uiBean.setBosyuunintourokuno2("1001234501506");
        uiBean.setGyousekikeijyousakisosikicd2("6001506");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 7, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110385", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "代理店事務所コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "1506", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "代理店金融機関コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "1526", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "代理店金融機関支店コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "306", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "代理店取扱行員コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "200000001506", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "入力募集人コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "4015006", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "募集人登録番号2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "1001234501506", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "業績計上先組織コード2", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "6001506", "訂正後内容");
    }

    @Test
    @TestOrder(1710)
    @Transactional
    public void testRgstrMousikomisyo_Q1() {
        String mosno = "861110393";
        uiBean.setMosno(mosno);
        uiBean.setTsryhshrkykumukbn(C_UmuKbn.ARI);
        uiBean.setSyosisyatodokeumukbn(C_UmuKbn.ARI);
        uiBean.setKakukisyouryakukbumukbn(C_UmuKbn.ARI);
        uiBean.setSeiymdmosseitouumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1720)
    @Transactional
    public void testRgstrMousikomisyo_Q2() {
        String mosno = "861110401";
        uiBean.setMosno(mosno);
        uiBean.setTsryhshrkykumukbn(C_UmuKbn.ARI);
        uiBean.setSyosisyatodokeumukbn(C_UmuKbn.ARI);
        uiBean.setKakukisyouryakukbumukbn(C_UmuKbn.ARI);
        uiBean.setSeiymdmosseitouumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 4, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110401", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "手数料不支払契約", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "あり", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "証券支社届", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "あり", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "カク基省略希望", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "あり", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "生年月日申込書正当", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "あり", "訂正後内容");
    }

    @Test
    @TestOrder(1810)
    @Transactional
    public void testRgstrMousikomisyo_R1() {
        String mosno = "861110419";
        uiBean.setMosno(mosno);
        uiBean.setTkhsyouryakuumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1820)
    @Transactional
    public void testRgstrMousikomisyo_R2() {
        String mosno = "861110427";
        uiBean.setMosno(mosno);
        uiBean.setTkhsyouryakuumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110427", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "通計保留省略有無区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "あり", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(1910)
    @Transactional
    public void testRgstrMousikomisyo_S1() {
        String mosno = "861110435";
        uiBean.setMosno(mosno);
        uiBean.setKhnchkcmnt("基本チェックコメント１");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1920)
    @Transactional
    public void testRgstrMousikomisyo_S2() {
        String mosno = "861110443";
        uiBean.setMosno(mosno);
        uiBean.setKhnchkcmnt("");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110443", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "基本チェックコメント", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "入力あり", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "入力なし", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(1930)
    @Transactional
    public void testRgstrMousikomisyo_S3() {
        String mosno = "861110450";
        uiBean.setMosno(mosno);
        uiBean.setKhnchkcmnt("基本チェックコメント３");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 1, "項目訂正履歴テーブルエンティティリストのサイズ");
        exStringEquals(kmTsRirekiLst.get(0).getMosno(), "861110450", "申込番号");
        exStringEquals(kmTsRirekiLst.get(0).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "基本チェックコメント", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "入力なし", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "入力あり", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(0).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(0).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
    }

    @Test
    @TestOrder(2010)
    @Transactional
    public void testRgstrMousikomisyo_T1() {
        String mosno = "870000015";
        uiBean.setMosno(mosno);
        uiBean.setKzhuritourokuhoukbn(C_KzhuritourokuhouKbn.BLNK);
        uiBean.setKouhurikouzainfositencd("");
        uiBean.setKouhurikouzainfoyokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouhurikouzainfokouzano("");
        uiBean.setKouhurikouzainfokzdoukbn(C_KzkykdouKbn.BLNK);
        uiBean.setKouhurikouzainfokzmeiginmkn("");
        uiBean.setKouzakakuniniraikbn(C_YouhiblnkKbn.BLNK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 0, "項目訂正履歴テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(2020)
    @Transactional
    public void testRgstrMousikomisyo_T2() {
        String mosno = "870000023";
        uiBean.setMosno(mosno);
        uiBean.setKzhuritourokuhoukbn(C_KzhuritourokuhouKbn.SYOMEN);
        uiBean.setKouhurikouzainfobankcd("1002");
        uiBean.setKouhurikouzainfositencd("102");
        uiBean.setKouhurikouzainfoyokinkbn(C_YokinKbn.TOUZA);
        uiBean.setKouhurikouzainfokouzano("1001102");
        uiBean.setKouhurikouzainfokzdoukbn(C_KzkykdouKbn.DOUITU);
        uiBean.setKouhurikouzainfokzmeiginmkn("タナカ");
        uiBean.setKouzakakuniniraikbn(C_YouhiblnkKbn.HUYOU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        BizPropertyInitializer.initialize(uiBean);

        tsRrkInfoTouroku.rgstrMousikomisyo(uiBean, SYSTIME, "mousikomisyo", "mousikomisyo_upd", SOUSASYACD);

        List<HT_KmTsRireki> kmTsRirekiLst = sinkeiyakuDomManager.getSyoriCTL(mosno).getKmTsRirekis();

        exNumericEquals(kmTsRirekiLst.size(), 8, "項目訂正履歴テーブルエンティティリストのサイズ");
        exNumericEquals(kmTsRirekiLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(0).getTskmnm(), "口振口座情報口座振替登録方法区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(0).getTsmaenaiyou(), "ＱＲコード方式での登録", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(0).getTsgonaiyou(), "生命保険料支払申込書による登録（書面）", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(1).getMosno(), "870000023", "申込番号");
        exStringEquals(kmTsRirekiLst.get(1).getSyoriTime(), "20160429100000001", "処理時間");
        exNumericEquals(kmTsRirekiLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(1).getKinouId(), "mousikomisyo", "機能ＩＤ");
        exStringEquals(kmTsRirekiLst.get(1).getKinouModeId(), "mousikomisyo_upd", "機能モードＩＤ");
        exStringEquals(kmTsRirekiLst.get(1).getTskmnm(), "口振口座情報銀行コード", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(1).getTsmaenaiyou(), "1001", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(1).getTsgonaiyou(), "1002", "訂正後内容");
        exStringEquals(kmTsRirekiLst.get(1).getTantid(), "sousasyatest", "担当者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(1).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(kmTsRirekiLst.get(1).getGyoumuKousinTime(), "20160429100000001", "業務用更新時間");
        exNumericEquals(kmTsRirekiLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(2).getTskmnm(), "口振口座情報支店コード", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(2).getTsmaenaiyou(), "101", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(2).getTsgonaiyou(), "102", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(3).getTskmnm(), "口振口座情報預金種目", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(3).getTsmaenaiyou(), "普通", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(3).getTsgonaiyou(), "当座", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(4).getTskmnm(), "口振口座情報口座番号", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(4).getTsmaenaiyou(), "1001101", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(4).getTsgonaiyou(), "1001102", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(5).getTskmnm(), "口振口座情報口座名義人同一区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(5).getTsmaenaiyou(), "指定", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(5).getTsgonaiyou(), "同一", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(6).getTskmnm(), "口振口座情報口座名義人", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(6).getTsmaenaiyou(), "サイタマ", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(6).getTsgonaiyou(), "", "訂正後内容");
        exNumericEquals(kmTsRirekiLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(kmTsRirekiLst.get(7).getTskmnm(), "ＣＳＳ確認依頼区分", "訂正項目名");
        exStringEquals(kmTsRirekiLst.get(7).getTsmaenaiyou(), "要", "訂正前内容");
        exStringEquals(kmTsRirekiLst.get(7).getTsgonaiyou(), "不要", "訂正後内容");
    }
}
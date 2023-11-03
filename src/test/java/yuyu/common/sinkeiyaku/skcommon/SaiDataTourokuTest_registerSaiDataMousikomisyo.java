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
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
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
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 差異データ登録のメソッド {@link SaiDataTouroku#registerSaiDataMousikomisyo(
 * SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SaiDataTourokuTest_registerSaiDataMousikomisyo extends AbstractTest{

    private static final String SOUSASYACD = "sousasyatest";
    private static final String SYSDATE = "20160420";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_差異データ登録";

    private final static String sheetName = "INデータ";

    @Inject
    private SaiDataTouroku saiDataTouroku;

    @Inject
    private SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParamImpl uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SaiDataTourokuTest_registerSaiDataMousikomisyo.class, fileName, sheetName);
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
    public void testRegisterSaiDataMousikomisyo_A1() {
        uiBean.setMosno("861110005");
        try {
            saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110005", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(120)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_A2() {
        uiBean.setMosno("861110013");
        try {
            saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110013", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_B1() {
        String mosNo = "861110021";
        uiBean.setMosno(mosNo);
        uiBean.setAitemosno("971110036");
        uiBean.setDoujikaiyakusyono("17806000013");
        uiBean.setMosymd(BizDate.valueOf(20160101));
        uiBean.setJimuyoucd("101");
        uiBean.setHknsyuruino(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);
        uiBean.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        uiBean.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.BLNK);
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
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_B2() {
        String mosNo = "861110039";
        uiBean.setMosno(mosNo);
        uiBean.setAitemosno("971110036");
        uiBean.setDoujikaiyakusyono("17806000013");
        uiBean.setMosymd(BizDate.valueOf(20160101));
        uiBean.setJimuyoucd("103");
        uiBean.setHknsyuruino(C_HknsyuruiNo.GAIKAINDEXNK_SISUU);
        uiBean.setKykkbn(C_KykKbn.KEIHI_DOUITU);
        uiBean.setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn.WEB);
        uiBean.setFatcasnsikbn(C_FatcasnsiKbn.BLNK);
        uiBean.setBikkjnssinfokbn(C_BikkjnssinfoKbn.BLNK);
        uiBean.setBikknzsyno("201100001");
        uiBean.setAeoisnsikbn(C_AeoisnsiKbn.BLNK);
        uiBean.setKyknmkn("ケイヤクシャ３");
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
        uiBean.setHhknnmkn("ヒホケンシャ３");
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
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, "sousasyatest123", "20160420100000001");

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 37, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110039", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "相手申込番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "971110044", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "971110036", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest123", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420100000001", "業務用更新時間");
        exStringEquals(nrkDifLst.get(33).getKousinsyaId(), null, "更新者ＩＤ");
        exStringEquals(nrkDifLst.get(33).getKousinTime(), null, "更新日時");
        exStringEquals(nrkDifLst.get(33).getKousinKinou(), null, "更新機能ＩＤ");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "同時解約証券番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "17806000024", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "17806000013", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "申込日", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "2016. 1. 2", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "2016. 1. 1", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "事務用コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "102", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "103", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "保険種類", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）（指数連動プラン）", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "契約者区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "契被別", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "契被同一", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "約款受領方法", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "Ｗｅｂでの受取り（インターネット環境で確認）", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "ＦＡＴＣＡ宣誓", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "該当", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "米国人示唆情報", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "あり", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "米国納税者番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "201100002", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "201100001", "２次入力");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "ＡＥＯＩ宣誓", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "該当", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "契約者名（カナ）", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "ケイヤク２", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "ケイヤクシャ３", "２次入力");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "契約者名（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "契約者２", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "契約者３", "２次入力");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "契約者名漢字化不可区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "漢字化不可", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(nrkDifLst.get(14).getNrksouikm(), "契約者生年月日", "入力相違項目");
        exStringEquals(nrkDifLst.get(14).getItijinyuuroku(), "H17. 7. 2", "１次入力");
        exStringEquals(nrkDifLst.get(14).getNijinyrk(), "H17. 7. 3", "２次入力");
        exNumericEquals(nrkDifLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(nrkDifLst.get(15).getNrksouikm(), "契約者性別", "入力相違項目");
        exStringEquals(nrkDifLst.get(15).getItijinyuuroku(), "男性", "１次入力");
        exStringEquals(nrkDifLst.get(15).getNijinyrk(), "法人契約", "２次入力");
        exNumericEquals(nrkDifLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(nrkDifLst.get(16).getNrksouikm(), "契約者続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(16).getItijinyuuroku(), "３親等の親族", "１次入力");
        exStringEquals(nrkDifLst.get(16).getNijinyrk(), "法定相続人", "２次入力");
        exNumericEquals(nrkDifLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(nrkDifLst.get(17).getNrksouikm(), "通信先郵便番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(17).getItijinyuuroku(), "5508002", "１次入力");
        exStringEquals(nrkDifLst.get(17).getNijinyrk(), "5508003", "２次入力");
        exNumericEquals(nrkDifLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(nrkDifLst.get(18).getNrksouikm(), "通信先住所１（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(18).getItijinyuuroku(), "通信先２１", "１次入力");
        exStringEquals(nrkDifLst.get(18).getNijinyrk(), "通信先３１", "２次入力");
        exNumericEquals(nrkDifLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(nrkDifLst.get(19).getNrksouikm(), "通信先住所２（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(19).getItijinyuuroku(), "通信先２２", "１次入力");
        exStringEquals(nrkDifLst.get(19).getNijinyrk(), "通信先３２", "２次入力");
        exNumericEquals(nrkDifLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(nrkDifLst.get(20).getNrksouikm(), "通信先住所３（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(20).getItijinyuuroku(), "通信先２３", "１次入力");
        exStringEquals(nrkDifLst.get(20).getNijinyrk(), "通信先３３", "２次入力");
        exNumericEquals(nrkDifLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(nrkDifLst.get(21).getNrksouikm(), "通信先電話番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(21).getItijinyuuroku(), "01-1022-2002", "１次入力");
        exStringEquals(nrkDifLst.get(21).getNijinyrk(), "01-1022-2003", "２次入力");
        exNumericEquals(nrkDifLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(nrkDifLst.get(22).getNrksouikm(), "第２通信先電話番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(22).getItijinyuuroku(), "01-1055-5002", "１次入力");
        exStringEquals(nrkDifLst.get(22).getNijinyrk(), "01-1055-5003", "２次入力");
        exNumericEquals(nrkDifLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(nrkDifLst.get(23).getNrksouikm(), "被保険者名（カナ）", "入力相違項目");
        exStringEquals(nrkDifLst.get(23).getItijinyuuroku(), "ヒホケン２", "１次入力");
        exStringEquals(nrkDifLst.get(23).getNijinyrk(), "ヒホケンシャ３", "２次入力");
        exNumericEquals(nrkDifLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(nrkDifLst.get(24).getNrksouikm(), "被保険者名（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(24).getItijinyuuroku(), "被保険者２", "１次入力");
        exStringEquals(nrkDifLst.get(24).getNijinyrk(), "被保険者３", "２次入力");
        exNumericEquals(nrkDifLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(nrkDifLst.get(25).getNrksouikm(), "被保険者名漢字化不可区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(25).getItijinyuuroku(), "漢字化不可", "１次入力");
        exStringEquals(nrkDifLst.get(25).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(nrkDifLst.get(26).getNrksouikm(), "被保険者生年月日", "入力相違項目");
        exStringEquals(nrkDifLst.get(26).getItijinyuuroku(), "H18. 6. 2", "１次入力");
        exStringEquals(nrkDifLst.get(26).getNijinyrk(), "H18. 6. 3", "２次入力");
        exNumericEquals(nrkDifLst.get(27).getRenno3keta(), 28, "連番（３桁）");
        exStringEquals(nrkDifLst.get(27).getNrksouikm(), "被保険者性別", "入力相違項目");
        exStringEquals(nrkDifLst.get(27).getItijinyuuroku(), "男性", "１次入力");
        exStringEquals(nrkDifLst.get(27).getNijinyrk(), "女性", "２次入力");
        exNumericEquals(nrkDifLst.get(28).getRenno3keta(), 29, "連番（３桁）");
        exStringEquals(nrkDifLst.get(28).getNrksouikm(), "通信先同一指定区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(28).getItijinyuuroku(), "指定あり", "１次入力");
        exStringEquals(nrkDifLst.get(28).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(29).getRenno3keta(), 30, "連番（３桁）");
        exStringEquals(nrkDifLst.get(29).getNrksouikm(), "被保険者郵便番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(29).getItijinyuuroku(), "5417002", "１次入力");
        exStringEquals(nrkDifLst.get(29).getNijinyrk(), "5417003", "２次入力");
        exNumericEquals(nrkDifLst.get(30).getRenno3keta(), 31, "連番（３桁）");
        exStringEquals(nrkDifLst.get(30).getNrksouikm(), "被保険者住所１（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(30).getItijinyuuroku(), "被保険者住所２１", "１次入力");
        exStringEquals(nrkDifLst.get(30).getNijinyrk(), "被保険者住所３１", "２次入力");
        exNumericEquals(nrkDifLst.get(31).getRenno3keta(), 32, "連番（３桁）");
        exStringEquals(nrkDifLst.get(31).getNrksouikm(), "被保険者住所２（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(31).getItijinyuuroku(), "被保険者住所２２", "１次入力");
        exStringEquals(nrkDifLst.get(31).getNijinyrk(), "被保険者住所３２", "２次入力");
        exStringEquals(nrkDifLst.get(32).getMosno(), "861110039", "申込番号");
        exStringEquals(nrkDifLst.get(32).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(32).getRenno3keta(), 33, "連番（３桁）");
        exStringEquals(nrkDifLst.get(32).getNrksouikm(), "被保険者住所３（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(32).getItijinyuuroku(), "被保険者住所被保険者住所被保険者住所被保険者住所１２３４５６", "１次入力");
        exStringEquals(nrkDifLst.get(32).getNijinyrk(), "被保険者住所被保険者住所被保険者住所被保険者住所被保険者住所", "２次入力");
        exStringEquals(nrkDifLst.get(32).getGyoumuKousinsyaId(), "sousasyatest123", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(32).getGyoumuKousinTime(), "20160420100000001", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(33).getRenno3keta(), 34, "連番（３桁）");
        exStringEquals(nrkDifLst.get(33).getNrksouikm(), "被保険者電話番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(33).getItijinyuuroku(), "02-3055-8002", "１次入力");
        exStringEquals(nrkDifLst.get(33).getNijinyrk(), "02-3055-8003", "２次入力");
        exNumericEquals(nrkDifLst.get(34).getRenno3keta(), 35, "連番（３桁）");
        exStringEquals(nrkDifLst.get(34).getNrksouikm(), "告知日", "入力相違項目");
        exStringEquals(nrkDifLst.get(34).getItijinyuuroku(), "2016. 4.20", "１次入力");
        exStringEquals(nrkDifLst.get(34).getNijinyrk(), "2016. 4.19", "２次入力");
        exNumericEquals(nrkDifLst.get(35).getRenno3keta(), 36, "連番（３桁）");
        exStringEquals(nrkDifLst.get(35).getNrksouikm(), "被保険者職業コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(35).getItijinyuuroku(), "202", "１次入力");
        exStringEquals(nrkDifLst.get(35).getNijinyrk(), "203", "２次入力");
        exNumericEquals(nrkDifLst.get(36).getRenno3keta(), 37, "連番（３桁）");
        exStringEquals(nrkDifLst.get(36).getNrksouikm(), "被保険者年収", "入力相違項目");
        exStringEquals(nrkDifLst.get(36).getItijinyuuroku(), "７００～１０００万円未満", "１次入力");
        exStringEquals(nrkDifLst.get(36).getNijinyrk(), "１０００万円以上", "２次入力");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_C1() {
        String mosNo = "861110047";
        uiBean.setMosno(mosNo);
        uiBean.setNenkinuktkbn(C_UktKbn.KYK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_C2() {
        String mosNo = "861110054";
        uiBean.setMosno(mosNo);
        uiBean.setNenkinuktkbn(C_UktKbn.KYK);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110054", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "年金受取人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "被保険者と同じ", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "契約者と同じ", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_C3() {
        String mosNo = "861110062";
        uiBean.setMosno(mosNo);
        uiBean.setNenkinuktkbn(C_UktKbn.KYK);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110062", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "年金受取人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "契約者と同じ", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_D1() {
        String mosNo = "861110070";
        uiBean.setMosno(mosNo);
        uiBean.setSbuktnin(5);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_D2() {
        String mosNo = "861110088";
        uiBean.setMosno(mosNo);
        uiBean.setSbuktnin(3);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110088", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "死亡受取人人数", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "4", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "3", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(510)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_E1() {
        String mosNo = "861110096";
        uiBean.setMosno(mosNo);
        uiBean.setSibouuktkbn1(C_UktKbn.KYK);
        uiBean.setSibouuktnmkana1("ニンメイカナ１");
        uiBean.setSibouuktnmkanji1("死亡受取人名１");
        uiBean.setSibouuktnmkanjikahukakbn1(C_KjkhukaKbn.KJKHUKA);
        uiBean.setSibouuktseiymd1(BizDate.valueOf(19900217));
        uiBean.setSibouukttdk1(C_Tdk.KO);
        uiBean.setSibouuktbnwari1(BizNumber.valueOf(50));
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_E2() {
        String mosNo = "861110104";
        uiBean.setMosno(mosNo);
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
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setNkshrstartnen(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 28, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110104", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "死亡受取人区分1", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "契約者と同じ", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "死亡受取人氏名（カナ）1", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "ニンメイカナ１", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "ニンメイカナ１１", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "死亡受取人氏名（漢字）1", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "死亡受取人名１", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "死亡受取人名１１", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "死亡受取人名漢字化不可1", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "死亡受取人生年月日1", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "S40. 1. 1", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "H 7. 1. 1", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "死亡受取人続柄1", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "配偶者", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "死亡受取人分割割合1", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "50", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "15", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "死亡受取人区分2", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "契約者と同じ", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "特定名義", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "死亡受取人氏名（カナ）2", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "ニンメイカナ２", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "ニンメイカナ１２", "２次入力");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "死亡受取人氏名（漢字）2", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "死亡受取人名２", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "死亡受取人名１２", "２次入力");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "死亡受取人名漢字化不可2", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "漢字化不可", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "死亡受取人生年月日2", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "S17. 2. 2", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "H 7. 2. 2", "２次入力");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "死亡受取人続柄2", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "親", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "祖父母", "２次入力");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "死亡受取人分割割合2", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "20", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "25", "２次入力");
        exNumericEquals(nrkDifLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(nrkDifLst.get(14).getNrksouikm(), "死亡受取人区分3", "入力相違項目");
        exStringEquals(nrkDifLst.get(14).getItijinyuuroku(), "特定名義", "１次入力");
        exStringEquals(nrkDifLst.get(14).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(nrkDifLst.get(15).getNrksouikm(), "死亡受取人氏名（カナ）3", "入力相違項目");
        exStringEquals(nrkDifLst.get(15).getItijinyuuroku(), "ニンメイカナ３", "１次入力");
        exStringEquals(nrkDifLst.get(15).getNijinyrk(), "ニンメイカナ１３", "２次入力");
        exNumericEquals(nrkDifLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(nrkDifLst.get(16).getNrksouikm(), "死亡受取人氏名（漢字）3", "入力相違項目");
        exStringEquals(nrkDifLst.get(16).getItijinyuuroku(), "死亡受取人名３", "１次入力");
        exStringEquals(nrkDifLst.get(16).getNijinyrk(), "死亡受取人名１３", "２次入力");
        exNumericEquals(nrkDifLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(nrkDifLst.get(17).getNrksouikm(), "死亡受取人名漢字化不可3", "入力相違項目");
        exStringEquals(nrkDifLst.get(17).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(17).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(nrkDifLst.get(18).getNrksouikm(), "死亡受取人生年月日3", "入力相違項目");
        exStringEquals(nrkDifLst.get(18).getItijinyuuroku(), "H 2. 3. 3", "１次入力");
        exStringEquals(nrkDifLst.get(18).getNijinyrk(), "H 7. 3. 3", "２次入力");
        exNumericEquals(nrkDifLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(nrkDifLst.get(19).getNrksouikm(), "死亡受取人続柄3", "入力相違項目");
        exStringEquals(nrkDifLst.get(19).getItijinyuuroku(), "子", "１次入力");
        exStringEquals(nrkDifLst.get(19).getNijinyrk(), "孫", "２次入力");
        exNumericEquals(nrkDifLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(nrkDifLst.get(20).getNrksouikm(), "死亡受取人分割割合3", "入力相違項目");
        exStringEquals(nrkDifLst.get(20).getItijinyuuroku(), "25", "１次入力");
        exStringEquals(nrkDifLst.get(20).getNijinyrk(), "35", "２次入力");
        exNumericEquals(nrkDifLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(nrkDifLst.get(21).getNrksouikm(), "死亡受取人区分4", "入力相違項目");
        exStringEquals(nrkDifLst.get(21).getItijinyuuroku(), "契約者と同じ", "１次入力");
        exStringEquals(nrkDifLst.get(21).getNijinyrk(), "特定名義", "２次入力");
        exNumericEquals(nrkDifLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(nrkDifLst.get(22).getNrksouikm(), "死亡受取人氏名（カナ）4", "入力相違項目");
        exStringEquals(nrkDifLst.get(22).getItijinyuuroku(), "ニンメイカナ４", "１次入力");
        exStringEquals(nrkDifLst.get(22).getNijinyrk(), "ニンメイカナ１４", "２次入力");
        exNumericEquals(nrkDifLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(nrkDifLst.get(23).getNrksouikm(), "死亡受取人氏名（漢字）4", "入力相違項目");
        exStringEquals(nrkDifLst.get(23).getItijinyuuroku(), "死亡受取人名４", "１次入力");
        exStringEquals(nrkDifLst.get(23).getNijinyrk(), "死亡受取人名１４", "２次入力");
        exNumericEquals(nrkDifLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(nrkDifLst.get(24).getNrksouikm(), "死亡受取人名漢字化不可4", "入力相違項目");
        exStringEquals(nrkDifLst.get(24).getItijinyuuroku(), "漢字化不可", "１次入力");
        exStringEquals(nrkDifLst.get(24).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(nrkDifLst.get(25).getNrksouikm(), "死亡受取人生年月日4", "入力相違項目");
        exStringEquals(nrkDifLst.get(25).getItijinyuuroku(), "S41. 4. 4", "１次入力");
        exStringEquals(nrkDifLst.get(25).getNijinyrk(), "H 7. 4. 4", "２次入力");
        exNumericEquals(nrkDifLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(nrkDifLst.get(26).getNrksouikm(), "死亡受取人続柄4", "入力相違項目");
        exStringEquals(nrkDifLst.get(26).getItijinyuuroku(), "兄弟姉妹", "１次入力");
        exStringEquals(nrkDifLst.get(26).getNijinyrk(), "その他", "２次入力");
        exNumericEquals(nrkDifLst.get(27).getRenno3keta(), 28, "連番（３桁）");
        exStringEquals(nrkDifLst.get(27).getNrksouikm(), "死亡受取人分割割合4", "入力相違項目");
        exStringEquals(nrkDifLst.get(27).getItijinyuuroku(), "5", "１次入力");
        exStringEquals(nrkDifLst.get(27).getNijinyrk(), "45", "２次入力");
    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_E3() {
        String mosNo = "861110112";
        uiBean.setMosno(mosNo);
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
        uiBean.setSibouukttdk4(C_Tdk.SONOTA);
        uiBean.setSibouuktbnwari4(BizNumber.valueOf(0));
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 27, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110112", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "死亡受取人区分1", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "契約者と同じ", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "死亡受取人氏名（カナ）1", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "ニンメイカナ１１", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "死亡受取人氏名（漢字）1", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "死亡受取人名１１", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "死亡受取人名漢字化不可1", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "死亡受取人生年月日1", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "H 7. 1. 1", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "死亡受取人続柄1", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "配偶者", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "死亡受取人分割割合1", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "15", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "死亡受取人区分2", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "特定名義", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "死亡受取人氏名（カナ）2", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "ニンメイカナ１２", "２次入力");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "死亡受取人氏名（漢字）2", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "死亡受取人名１２", "２次入力");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "死亡受取人名漢字化不可2", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "死亡受取人生年月日2", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "H 7. 2. 2", "２次入力");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "死亡受取人続柄2", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "祖父母", "２次入力");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "死亡受取人分割割合2", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "25", "２次入力");
        exNumericEquals(nrkDifLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(nrkDifLst.get(14).getNrksouikm(), "死亡受取人区分3", "入力相違項目");
        exStringEquals(nrkDifLst.get(14).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(14).getNijinyrk(), "契約者と同じ", "２次入力");
        exNumericEquals(nrkDifLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(nrkDifLst.get(15).getNrksouikm(), "死亡受取人氏名（カナ）3", "入力相違項目");
        exStringEquals(nrkDifLst.get(15).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(15).getNijinyrk(), "ニンメイカナ１３", "２次入力");
        exNumericEquals(nrkDifLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(nrkDifLst.get(16).getNrksouikm(), "死亡受取人氏名（漢字）3", "入力相違項目");
        exStringEquals(nrkDifLst.get(16).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(16).getNijinyrk(), "死亡受取人名１３", "２次入力");
        exNumericEquals(nrkDifLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(nrkDifLst.get(17).getNrksouikm(), "死亡受取人名漢字化不可3", "入力相違項目");
        exStringEquals(nrkDifLst.get(17).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(17).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(nrkDifLst.get(18).getNrksouikm(), "死亡受取人生年月日3", "入力相違項目");
        exStringEquals(nrkDifLst.get(18).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(18).getNijinyrk(), "H 7. 3. 3", "２次入力");
        exNumericEquals(nrkDifLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(nrkDifLst.get(19).getNrksouikm(), "死亡受取人続柄3", "入力相違項目");
        exStringEquals(nrkDifLst.get(19).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(19).getNijinyrk(), "孫", "２次入力");
        exNumericEquals(nrkDifLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(nrkDifLst.get(20).getNrksouikm(), "死亡受取人分割割合3", "入力相違項目");
        exStringEquals(nrkDifLst.get(20).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(20).getNijinyrk(), "35", "２次入力");
        exNumericEquals(nrkDifLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(nrkDifLst.get(21).getNrksouikm(), "死亡受取人区分4", "入力相違項目");
        exStringEquals(nrkDifLst.get(21).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(21).getNijinyrk(), "特定名義", "２次入力");
        exNumericEquals(nrkDifLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(nrkDifLst.get(22).getNrksouikm(), "死亡受取人氏名（カナ）4", "入力相違項目");
        exStringEquals(nrkDifLst.get(22).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(22).getNijinyrk(), "ニンメイカナ１４", "２次入力");
        exNumericEquals(nrkDifLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(nrkDifLst.get(23).getNrksouikm(), "死亡受取人氏名（漢字）4", "入力相違項目");
        exStringEquals(nrkDifLst.get(23).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(23).getNijinyrk(), "死亡受取人名１４", "２次入力");
        exNumericEquals(nrkDifLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(nrkDifLst.get(24).getNrksouikm(), "死亡受取人名漢字化不可4", "入力相違項目");
        exStringEquals(nrkDifLst.get(24).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(24).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(nrkDifLst.get(25).getNrksouikm(), "死亡受取人生年月日4", "入力相違項目");
        exStringEquals(nrkDifLst.get(25).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(25).getNijinyrk(), "H 7. 4. 4", "２次入力");
        exNumericEquals(nrkDifLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(nrkDifLst.get(26).getNrksouikm(), "死亡受取人続柄4", "入力相違項目");
        exStringEquals(nrkDifLst.get(26).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(26).getNijinyrk(), "その他", "２次入力");
    }

    @Test
    @TestOrder(610)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_F1() {
        String mosNo = "861110120";
        uiBean.setMosno(mosNo);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(620)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_F2() {
        String mosNo = "861110138";
        uiBean.setMosno(mosNo);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110138", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "被保険者代理特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "付加しない", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }


    @Test
    @TestOrder(810)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I1() {
        String mosNo = "861110203";
        uiBean.setMosno(mosNo);
        uiBean.setSyudai1hknkknmosinput("");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu(C_Tuukasyu.BLNK);
        uiBean.setKihons(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        uiBean.setSyuhknkkn(0);
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI5);
        uiBean.setSyuhrkkkn(0);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.ARI);
        uiBean.setZnnkai(0);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKyktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setKihons2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setHrktuukasyukykp2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMosikkatup2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU6);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }


    @Test
    @TestOrder(820)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I2() {
        String mosNo = "861110211";
        uiBean.setMosno(mosNo);
        uiBean.setSyudai1hknkknmosinput("1");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.AUD);
        uiBean.setHrktuukasyu(C_Tuukasyu.JPY);
        uiBean.setKihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setSyuhknkkn(10);
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(25000, BizCurrencyTypes.YEN));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        uiBean.setSueokikknmosinput("15");
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI10);
        uiBean.setSyuhrkkkn(0);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.ARI);
        uiBean.setZnnkai(31);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKyktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setKihons2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setHrktuukasyukykp2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMosikkatup2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);
        uiBean.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 9, "入力差異テーブルエンティティリストのサイズ");

        exStringEquals(nrkDifLst.get(0).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "15", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "10", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(1).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(1).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "第１保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "1", "２次入力");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(2).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(2).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "初回保険料払込経路", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "口座振替", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "振込み", "２次入力");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(3).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(3).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "指定通貨／選択通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "豪ドル", "２次入力");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(4).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(4).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "払込通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "円", "２次入力");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(5).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(5).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "保険金額／給付金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "15,000.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "15,000.00 豪ドル", "２次入力");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(6).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(6).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "払込金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "25,000.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "25,000 円", "２次入力");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(7).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(7).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "据置期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "15", "２次入力");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(8).getMosno(), "861110211", "申込番号");
        exStringEquals(nrkDifLst.get(8).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "最低保証水準", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "１０５％", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "１００％", "２次入力");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(830)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I3() {
        String mosNo = "861110229";
        uiBean.setMosno(mosNo);
        uiBean.setSyudai1hknkknmosinput("1");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.USD);
        uiBean.setHrktuukasyu(C_Tuukasyu.USD);
        uiBean.setKihons(BizCurrency.valueOf(15000, BizCurrencyTypes.DOLLAR ));
        uiBean.setSyuhknkkn(16);
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setSueokikknmosinput("6");
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI10);
        uiBean.setSyuhrkkkn(0);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.ARI);
        uiBean.setZnnkai(1);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKyktuukasyu2(C_Tuukasyu.USD);
        uiBean.setHrktuukasyu2(C_Tuukasyu.USD);
        uiBean.setKihons2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setHrktuukasyukykp2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMosikkatup2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        uiBean.setAitemosno("860000025");

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 28, "入力差異テーブルエンティティリストのサイズ");

        exStringEquals(nrkDifLst.get(0).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "保険料払込満了年齢", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "22", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "0", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(1).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(1).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "年金支払開始年齢", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "16", "２次入力");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(2).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(2).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "第１保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "1", "２次入力");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(3).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(3).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "Ｓ建Ｐ建", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "Ｐ建", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "擬似Ｐ建", "２次入力");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(4).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(4).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "年金種類", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "１０年確定", "２次入力");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(5).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(5).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "全期前納", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "あり", "２次入力");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(6).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(6).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "前納期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "1", "２次入力");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(7).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(7).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "払込回数", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "月払", "２次入力");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(8).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(8).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "払込経路", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "口座振替", "２次入力");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(9).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(9).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "定期一括払回数", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "２か月定期一括払", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(9).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(9).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(10).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(10).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "主契約保障情報（米ドル）　指定通貨／選択通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(10).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(10).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(11).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(11).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "主契約保障情報（米ドル）　払込通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(11).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(11).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(12).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(12).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "主契約保障情報（米ドル）　保険金額／給付金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "1.00 豪ドル", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "15,000.00 米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(12).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(12).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(13).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(13).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "主契約保障情報（米ドル）　払込金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "2.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(13).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(13).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(14).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(14).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(nrkDifLst.get(14).getNrksouikm(), "主契約保障情報（米ドル）　定期一括払保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(14).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(14).getNijinyrk(), "100 円", "２次入力");
        exStringEquals(nrkDifLst.get(14).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(14).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(15).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(15).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(nrkDifLst.get(15).getNrksouikm(), "主契約保障情報（米ドル）　前納保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(15).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(15).getNijinyrk(), "200 円", "２次入力");
        exStringEquals(nrkDifLst.get(15).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(15).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(16).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(16).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(nrkDifLst.get(16).getNrksouikm(), "指数連動", "入力相違項目");
        exStringEquals(nrkDifLst.get(16).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(16).getNijinyrk(), "１０％", "２次入力");
        exStringEquals(nrkDifLst.get(16).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(16).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(17).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(17).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(nrkDifLst.get(17).getNrksouikm(), "定率積立", "入力相違項目");
        exStringEquals(nrkDifLst.get(17).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(17).getNijinyrk(), "２０％", "２次入力");
        exStringEquals(nrkDifLst.get(17).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(17).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(18).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(18).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(nrkDifLst.get(18).getNrksouikm(), "据置期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(18).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(18).getNijinyrk(), "6", "２次入力");
        exStringEquals(nrkDifLst.get(18).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(18).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(19).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(19).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(nrkDifLst.get(19).getNrksouikm(), "最低保証水準", "入力相違項目");
        exStringEquals(nrkDifLst.get(19).getItijinyuuroku(), "１０５％", "１次入力");
        exStringEquals(nrkDifLst.get(19).getNijinyrk(), "１００％", "２次入力");
        exStringEquals(nrkDifLst.get(19).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(06).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(20).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(20).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(nrkDifLst.get(20).getNrksouikm(), "主契約保障情報（米ドル）　個人年金保険料税制適格特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(20).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(20).getNijinyrk(), "付加する", "２次入力");
        exStringEquals(nrkDifLst.get(20).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(20).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(21).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(21).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(nrkDifLst.get(21).getNrksouikm(), "主契約保障情報（豪ドル）　指定通貨／選択通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(21).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(21).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(21).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(21).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(22).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(22).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(nrkDifLst.get(22).getNrksouikm(), "主契約保障情報（豪ドル）　払込通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(22).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(22).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(22).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(22).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(23).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(23).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(nrkDifLst.get(23).getNrksouikm(), "主契約保障情報（豪ドル）　保険金額／給付金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(23).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(23).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(23).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(23).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(24).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(24).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(nrkDifLst.get(24).getNrksouikm(), "主契約保障情報（豪ドル）　払込金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(24).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(24).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(24).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(24).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(25).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(25).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(nrkDifLst.get(25).getNrksouikm(), "主契約保障情報（豪ドル）　定期一括払保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(25).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(25).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(25).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(25).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(26).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(26).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(nrkDifLst.get(26).getNrksouikm(), "主契約保障情報（豪ドル）　前納保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(26).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(26).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(26).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(25).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(27).getMosno(), "861110229", "申込番号");
        exStringEquals(nrkDifLst.get(27).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(27).getRenno3keta(), 28, "連番（３桁）");
        exStringEquals(nrkDifLst.get(27).getNrksouikm(), "主契約保障情報（豪ドル）　個人年金保険料税制適格特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(27).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(27).getNijinyrk(), "付加する", "２次入力");
        exStringEquals(nrkDifLst.get(27).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(27).getGyoumuKousinTime(), "20160420", "業務用更新時間");

    }

    @Test
    @TestOrder(835)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I4() {
        String mosNo = "860000017";
        uiBean.setMosno(mosNo);
        uiBean.setSyudai1hknkknmosinput("1");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.USD);
        uiBean.setHrktuukasyu(C_Tuukasyu.USD);
        uiBean.setKihons(BizCurrency.valueOf(15000, BizCurrencyTypes.DOLLAR ));
        uiBean.setSyuhknkkn(16);
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI020);
        uiBean.setSueokikknmosinput("6");
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI10);
        uiBean.setSyuhrkkkn(0);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.ARI);
        uiBean.setZnnkai(0);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKyktuukasyu2(C_Tuukasyu.USD);
        uiBean.setHrktuukasyu2(C_Tuukasyu.USD);
        uiBean.setKihons2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setHrktuukasyukykp2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMosikkatup2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.IKKATU3);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 28, "入力差異テーブルエンティティリストのサイズ");

        exStringEquals(nrkDifLst.get(0).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "保険料払込満了年齢", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "22", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "0", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(1).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(1).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "年金支払開始年齢", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "16", "２次入力");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(2).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(2).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "第１保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "1", "２次入力");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(3).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(3).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "Ｓ建Ｐ建", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "Ｐ建", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "擬似Ｐ建", "２次入力");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(4).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(4).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "年金種類", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "１０年確定", "２次入力");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(5).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(5).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "全期前納", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "あり", "２次入力");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(6).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(6).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "前納期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "2", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(7).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(7).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "払込回数", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "月払", "２次入力");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(8).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(8).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "払込経路", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "口座振替", "２次入力");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(9).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(9).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "定期一括払回数", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "２か月定期一括払", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "３か月定期一括払", "２次入力");
        exStringEquals(nrkDifLst.get(9).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(9).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(10).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(10).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "指定通貨／選択通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(10).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(10).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(11).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(11).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "払込通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(11).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(11).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(12).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(12).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "保険金額／給付金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "1.00 豪ドル", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "15,000.00 米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(12).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(12).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(13).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(13).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "払込金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "2.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(13).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(13).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(14).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(14).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(nrkDifLst.get(14).getNrksouikm(), "定期一括払保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(14).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(14).getNijinyrk(), "100 円", "２次入力");
        exStringEquals(nrkDifLst.get(14).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(14).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(15).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(15).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(nrkDifLst.get(15).getNrksouikm(), "前納保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(15).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(15).getNijinyrk(), "200 円", "２次入力");
        exStringEquals(nrkDifLst.get(15).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(15).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(16).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(16).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(nrkDifLst.get(16).getNrksouikm(), "指数連動", "入力相違項目");
        exStringEquals(nrkDifLst.get(16).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(16).getNijinyrk(), "１０％", "２次入力");
        exStringEquals(nrkDifLst.get(16).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(16).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(17).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(17).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(nrkDifLst.get(17).getNrksouikm(), "定率積立", "入力相違項目");
        exStringEquals(nrkDifLst.get(17).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(17).getNijinyrk(), "２０％", "２次入力");
        exStringEquals(nrkDifLst.get(17).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(17).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(18).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(18).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(nrkDifLst.get(18).getNrksouikm(), "据置期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(18).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(18).getNijinyrk(), "6", "２次入力");
        exStringEquals(nrkDifLst.get(18).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(18).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(19).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(19).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(nrkDifLst.get(19).getNrksouikm(), "最低保証水準", "入力相違項目");
        exStringEquals(nrkDifLst.get(19).getItijinyuuroku(), "１０５％", "１次入力");
        exStringEquals(nrkDifLst.get(19).getNijinyrk(), "１００％", "２次入力");
        exStringEquals(nrkDifLst.get(19).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(19).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(20).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(20).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(nrkDifLst.get(20).getNrksouikm(), "個人年金保険料税制適格特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(20).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(20).getNijinyrk(), "付加する", "２次入力");
        exStringEquals(nrkDifLst.get(20).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(20).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(21).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(21).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(21).getRenno3keta(), 22, "連番（３桁）");
        exStringEquals(nrkDifLst.get(21).getNrksouikm(), "主契約保障情報（豪ドル）　指定通貨／選択通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(21).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(21).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(21).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(21).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(22).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(22).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(22).getRenno3keta(), 23, "連番（３桁）");
        exStringEquals(nrkDifLst.get(22).getNrksouikm(), "主契約保障情報（豪ドル）　払込通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(22).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(22).getNijinyrk(), "米ドル", "２次入力");
        exStringEquals(nrkDifLst.get(22).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(22).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(23).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(23).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(23).getRenno3keta(), 24, "連番（３桁）");
        exStringEquals(nrkDifLst.get(23).getNrksouikm(), "主契約保障情報（豪ドル）　保険金額／給付金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(23).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(23).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(23).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(23).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(24).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(24).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(24).getRenno3keta(), 25, "連番（３桁）");
        exStringEquals(nrkDifLst.get(24).getNrksouikm(), "主契約保障情報（豪ドル）　払込金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(24).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(24).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(24).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(24).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(25).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(25).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(25).getRenno3keta(), 26, "連番（３桁）");
        exStringEquals(nrkDifLst.get(25).getNrksouikm(), "主契約保障情報（豪ドル）　定期一括払保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(25).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(25).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(25).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(25).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(26).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(26).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(26).getRenno3keta(), 27, "連番（３桁）");
        exStringEquals(nrkDifLst.get(26).getNrksouikm(), "主契約保障情報（豪ドル）　前納保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(26).getItijinyuuroku(), "100 円", "１次入力");
        exStringEquals(nrkDifLst.get(26).getNijinyrk(), "", "２次入力");
        exStringEquals(nrkDifLst.get(26).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(26).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(27).getMosno(), "860000017", "申込番号");
        exStringEquals(nrkDifLst.get(27).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(27).getRenno3keta(), 28, "連番（３桁）");
        exStringEquals(nrkDifLst.get(27).getNrksouikm(), "主契約保障情報（豪ドル）　個人年金保険料税制適格特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(27).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(27).getNijinyrk(), "付加する", "２次入力");
        exStringEquals(nrkDifLst.get(27).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(27).getGyoumuKousinTime(), "20160420", "業務用更新時間");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(840)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I5() {
        uiBean.setMosno("861110419");
        changeSystemDate(BizDate.valueOf(20180323));
        try {
            saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号=861110419", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(850)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I6() {
        String mosNo = "860000280";
        uiBean.setMosno(mosNo);
        uiBean.setSyudai1hknkknmosinput("1");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.AUD);
        uiBean.setHrktuukasyu(C_Tuukasyu.JPY);
        uiBean.setKihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setSyuhknkkn(10);
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(25000, BizCurrencyTypes.YEN));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        uiBean.setSueokikknmosinput("15");
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI10);
        uiBean.setSyuhrkkkn(0);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.ARI);
        uiBean.setZnnkai(31);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKyktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setKihons2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setHrktuukasyukykp2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMosikkatup2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        uiBean.setMossyukykp(BizCurrency.valueOf(2500, BizCurrencyTypes.YEN));

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 9, "入力差異テーブルエンティティリストのサイズ");

        exStringEquals(nrkDifLst.get(0).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "15", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "10", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(1).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(1).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "第１保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "1", "２次入力");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(2).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(2).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "指定通貨／選択通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "豪ドル", "２次入力");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(3).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(3).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "払込通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "円", "２次入力");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(4).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(4).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "保険金額／給付金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "15,000.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "15,000.00 豪ドル", "２次入力");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(5).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(5).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "払込金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "25,000 円", "２次入力");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(6).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(6).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "25,000.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "2,500 円", "２次入力");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(7).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(7).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "据置期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "15", "２次入力");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(8).getMosno(), "860000280", "申込番号");
        exStringEquals(nrkDifLst.get(8).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "最低保証水準", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "１０５％", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "１００％", "２次入力");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(870)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I7() {
        String mosNo = "860000033";
        uiBean.setMosno(mosNo);
        uiBean.setSyudai1hknkknmosinput("1");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.AUD);
        uiBean.setHrktuukasyu(C_Tuukasyu.JPY);
        uiBean.setKihons(BizCurrency.valueOf(15000, BizCurrencyTypes.AU_DOLLAR));
        uiBean.setSyuhknkkn(10);
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(25000, BizCurrencyTypes.YEN));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU100);
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI10);
        uiBean.setSyuhrkkkn(0);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.ARI);
        uiBean.setZnnkai(31);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKyktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setKihons2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setHrktuukasyukykp2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMosikkatup2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);
        uiBean.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);

        uiBean.setMossyukykp(BizCurrency.valueOf(25000, BizCurrencyTypes.YEN));

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 10, "入力差異テーブルエンティティリストのサイズ");

        exStringEquals(nrkDifLst.get(0).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "10", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(1).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(1).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "第１保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "0", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "1", "２次入力");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(2).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(2).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "初回保険料払込経路", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "口座振替", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "振込み", "２次入力");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(2).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(3).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(3).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "指定通貨／選択通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "豪ドル", "２次入力");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(3).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(4).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(4).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "払込通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "円", "２次入力");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(4).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(5).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(5).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "保険金額／給付金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "15,000.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "15,000.00 豪ドル", "２次入力");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(5).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(6).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(6).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "払込金額", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "25,000.00 米ドル", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "25,000 円", "２次入力");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(6).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(7).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(7).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "保険料", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "25,000 円", "２次入力");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(7).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(8).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(8).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "据置期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "15", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "0", "２次入力");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(8).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(9).getMosno(), "860000033", "申込番号");
        exStringEquals(nrkDifLst.get(9).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "最低保証水準", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "１０５％", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "１００％", "２次入力");
        exStringEquals(nrkDifLst.get(9).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(9).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(880)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_I8() {
        String mosNo = "860000298";
        uiBean.setMosno(mosNo);
        uiBean.setSyudai1hknkknmosinput("0");
        uiBean.setSdpdkbn(C_Sdpd.GIJIPD);
        uiBean.setKyktuukasyu(C_Tuukasyu.USD);
        uiBean.setHrktuukasyu(C_Tuukasyu.USD);
        uiBean.setKihons(BizCurrency.valueOf(15000, BizCurrencyTypes.DOLLAR));
        uiBean.setSyuhknkkn(11);
        uiBean.setHrktuukasyukykp(BizCurrency.valueOf(25000, BizCurrencyTypes.DOLLAR));
        uiBean.setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn.WARIAI010);
        uiBean.setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn.BLNK);
        uiBean.setSueokikknmosinput("0");
        uiBean.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.RITU105);
        uiBean.setSknenkinsyu(C_Sknenkinsyu.KKTI10);
        uiBean.setSyuhrkkkn(25);
        uiBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        uiBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        uiBean.setZenkizennouumu(C_BlnktkumuKbn.ARI);
        uiBean.setZnnkai(31);
        uiBean.setMosikkatup(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn(C_Tkhukaumu.HUKA);
        uiBean.setKyktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setHrktuukasyu2(C_Tuukasyu.BLNK);
        uiBean.setKihons2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setHrktuukasyukykp2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMosikkatup2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setMoszennoupsyokaiari2(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        uiBean.setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu.HUKA);
        uiBean.setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn.BLNK);
        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);
        uiBean.setFstphrkkeirokbn(C_FstphrkkeiroKbn.HURIKOMI);

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 2, "入力差異テーブルエンティティリストのサイズ");

        exStringEquals(nrkDifLst.get(0).getMosno(), "860000298", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "払込期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "21", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "25", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exStringEquals(nrkDifLst.get(1).getMosno(), "860000298", "申込番号");
        exStringEquals(nrkDifLst.get(1).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "保険期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "15", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "11", "２次入力");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(1).getGyoumuKousinTime(), "20160420", "業務用更新時間");

    }

    @Test
    @TestOrder(1110)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_K1() {
        String mosNo = "861110252";
        uiBean.setMosno(mosNo);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstksbnkkn(10);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.BLNK);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("");
        uiBean.setSitencd("");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
        uiBean.setKzmeiginmkn("");

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1120)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_K2() {
        String mosNo = "861110260";
        uiBean.setMosno(mosNo);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET200);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstksbnkkn(10);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        uiBean.setBankcd("1101");
        uiBean.setSitencd("201");
        uiBean.setYokinkbn(C_YokinKbn.HUTUU);
        uiBean.setKouzano("110112340001");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKzmeiginmkn("サトウユキ１");

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 14, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110260", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "指定通貨建年金保険定期支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "付加する", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "支払金指定口座情報入力保留", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "保留", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "定期支払金支払通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "指定通貨", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "支払金指定口座情報銀行コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "1101", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "支払金指定口座情報支店コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "201", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "支払金指定口座情報預金種目", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "普通", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "支払金指定口座情報口座番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "110112340001", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "支払金指定口座情報口座名義人同一区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "指定", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "支払金指定口座情報口座名義人", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "サトウユキ１", "２次入力");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "１９０％", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "２００％", "２次入力");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "初期死亡時円換算支払額最低保証特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "付加しない", "２次入力");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "重度介護前払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "付加しない", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "付加する", "２次入力");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "年金支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "付加しない", "２次入力");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "年金支払特約期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "20", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "10", "２次入力");
    }

    @Test
    @TestOrder(1130)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_K3() {
        String mosNo = "861110278";
        uiBean.setMosno(mosNo);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstksbnkkn(10);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.BLNK);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("1101");
        uiBean.setSitencd("201");
        uiBean.setYokinkbn(C_YokinKbn.HUTUU);
        uiBean.setKouzano("110112340001");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
        uiBean.setKzmeiginmkn("サトウユキ１");

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1140)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_K4() {
        String mosNo = "861110286";
        uiBean.setMosno(mosNo);
        uiBean.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.TARGET200);
        uiBean.setSyksbyensitihsyutkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setJyudkaigomehrtkhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setNstkhkkbn(C_Tkhukaumu.NONE);
        uiBean.setNstksbnkkn(10);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        uiBean.setTeikisiharaitkykhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn.BLNK);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("1101");
        uiBean.setSitencd("201");
        uiBean.setYokinkbn(C_YokinKbn.HUTUU);
        uiBean.setKouzano("110112340001");
        uiBean.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
        uiBean.setKzmeiginmkn("サトウユキ１");

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 14, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110286", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "指定通貨建年金保険定期支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "付加する", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "支払金指定口座情報入力保留", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "保留", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "定期支払金支払通貨", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "円貨", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "支払金指定口座情報銀行コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "1102", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "1101", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "支払金指定口座情報支店コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "202", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "201", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "支払金指定口座情報預金種目", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "当座", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "普通", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "支払金指定口座情報口座番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "110112340002", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "110112340001", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "支払金指定口座情報口座名義人同一区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "指定", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "同一", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "支払金指定口座情報口座名義人", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "サトウユキ２", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "", "２次入力");
        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "目標額割合", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "１９０％", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "２００％", "２次入力");
        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "初期死亡時円換算支払額最低保証特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "付加しない", "２次入力");
        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "重度介護前払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "付加しない", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "付加する", "２次入力");
        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "年金支払特約", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "付加する", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "付加しない", "２次入力");
        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "年金支払特約期間", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "20", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "10", "２次入力");
    }

    @Test
    @TestOrder(710)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_G1() {
        String mosNo = "861110146";
        uiBean.setMosno(mosNo);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSiteidruktnmkn("ダイリニンシメイ");
        uiBean.setSiteidruktnmkj("代理人氏名");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);
        uiBean.setSyuhrkkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(720)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_G2() {
        String mosNo = "861110153";
        uiBean.setMosno(mosNo);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSiteidruktnmkn("ダイリニンシメイ");
        uiBean.setSiteidruktnmkj("代理人氏名");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 5, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110153", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "被保険者代理人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "死亡受取人と同じ", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "特定名義", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "被保険者代理人氏名（カナ）", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "ダイリニンシメイカナ", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "ダイリニンシメイ", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "被保険者代理人氏名（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "代理人氏名漢字", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "代理人氏名", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "被保険者代理人名漢字化不可区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "漢字化不可", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "親", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "配偶者", "２次入力");
    }

    @Test
    @TestOrder(730)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_G3() {
        String mosNo = "861110161";
        uiBean.setMosno(mosNo);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.HUKA);
        uiBean.setStdruktkbn(C_UktKbn.TOKUTEIMEIGI);
        uiBean.setSiteidruktnmkn("ダイリニンシメイ");
        uiBean.setSiteidruktnmkj("代理人氏名");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.ARI);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setTrkkzkseiymd1(BizDate.valueOf("19850420"));
        uiBean.setTrkkzksei1(C_Seibetu.FEMALE);
        uiBean.setTrkkzktdk1(C_Tdk.MAGO);
        uiBean.setStdrskseiymd(BizDate.valueOf(19900101));

        uiBean.setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn.YUUSOUKIBOU);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 21, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110161", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");

        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "ご家族登録サービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "申し込まない", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "申し込む", "２次入力");

        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "登録家族名（カナ）", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "トウロクカゾクカナ", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "登録家族名（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "登録家族名（漢字）", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "登録家族名漢字化不可", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "漢字化不可", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "登録家族生年月日", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "S63. 4.21", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "S60. 4.20", "２次入力");

        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "登録家族性別", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "男性", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "女性", "２次入力");

        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "登録家族続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "兄弟姉妹", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "孫", "２次入力");

        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "登録家族通信先同一指定区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "指定あり", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "登録家族郵便番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "9897654", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(9).getRenno3keta(), 10, "連番（３桁）");
        exStringEquals(nrkDifLst.get(9).getNrksouikm(), "登録家族住所１（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(9).getItijinyuuroku(), "登録家族住所１（漢字）", "１次入力");
        exStringEquals(nrkDifLst.get(9).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(10).getRenno3keta(), 11, "連番（３桁）");
        exStringEquals(nrkDifLst.get(10).getNrksouikm(), "登録家族住所２（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(10).getItijinyuuroku(), "登録家族住所２（漢字）", "１次入力");
        exStringEquals(nrkDifLst.get(10).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(11).getRenno3keta(), 12, "連番（３桁）");
        exStringEquals(nrkDifLst.get(11).getNrksouikm(), "登録家族住所３（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(11).getItijinyuuroku(), "登録家族住所３（漢字）", "１次入力");
        exStringEquals(nrkDifLst.get(11).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(12).getRenno3keta(), 13, "連番（３桁）");
        exStringEquals(nrkDifLst.get(12).getNrksouikm(), "登録家族電話番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(12).getItijinyuuroku(), "080-1234-5678", "１次入力");
        exStringEquals(nrkDifLst.get(12).getNijinyrk(), "", "２次入力");

        exNumericEquals(nrkDifLst.get(13).getRenno3keta(), 14, "連番（３桁）");
        exStringEquals(nrkDifLst.get(13).getNrksouikm(), "被保険者代理人区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(13).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(13).getNijinyrk(), "特定名義", "２次入力");

        exNumericEquals(nrkDifLst.get(14).getRenno3keta(), 15, "連番（３桁）");
        exStringEquals(nrkDifLst.get(14).getNrksouikm(), "被保険者代理人氏名（カナ）", "入力相違項目");
        exStringEquals(nrkDifLst.get(14).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(14).getNijinyrk(), "ダイリニンシメイ", "２次入力");
        exNumericEquals(nrkDifLst.get(15).getRenno3keta(), 16, "連番（３桁）");
        exStringEquals(nrkDifLst.get(15).getNrksouikm(), "被保険者代理人氏名（漢字）", "入力相違項目");
        exStringEquals(nrkDifLst.get(15).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(15).getNijinyrk(), "代理人氏名", "２次入力");
        exNumericEquals(nrkDifLst.get(16).getRenno3keta(), 17, "連番（３桁）");
        exStringEquals(nrkDifLst.get(16).getNrksouikm(), "被保険者代理人名漢字化不可区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(16).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(16).getNijinyrk(), "漢字化不可", "２次入力");

        exNumericEquals(nrkDifLst.get(17).getRenno3keta(), 18, "連番（３桁）");
        exStringEquals(nrkDifLst.get(17).getNrksouikm(), "被保険者代理人生年月日", "入力相違項目");
        exStringEquals(nrkDifLst.get(17).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(17).getNijinyrk(), "H 2. 1. 1", "２次入力");

        exNumericEquals(nrkDifLst.get(18).getRenno3keta(), 19, "連番（３桁）");
        exStringEquals(nrkDifLst.get(18).getNrksouikm(), "被保険者代理人続柄", "入力相違項目");
        exStringEquals(nrkDifLst.get(18).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(18).getNijinyrk(), "配偶者", "２次入力");

        exNumericEquals(nrkDifLst.get(19).getRenno3keta(), 20, "連番（３桁）");
        exStringEquals(nrkDifLst.get(19).getNrksouikm(), "ダイレクトサービス", "入力相違項目");
        exStringEquals(nrkDifLst.get(19).getItijinyuuroku(), "申し込む", "１次入力");
        exStringEquals(nrkDifLst.get(19).getNijinyrk(), "後続事務で確認", "２次入力");

        exNumericEquals(nrkDifLst.get(20).getRenno3keta(), 21, "連番（３桁）");
        exStringEquals(nrkDifLst.get(20).getNrksouikm(), "円貨払込額のご案内通知", "入力相違項目");
        exStringEquals(nrkDifLst.get(20).getItijinyuuroku(), "郵送を希望しない", "１次入力");
        exStringEquals(nrkDifLst.get(20).getNijinyrk(), "郵送を希望する", "２次入力");
    }

    @Test
    @TestOrder(740)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_G4() {
        String mosNo = "861110179";
        uiBean.setMosno(mosNo);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
        uiBean.setStdruktkbn(C_UktKbn.SBUK);
        uiBean.setSiteidruktnmkn("ダイリニンシメイ");
        uiBean.setSiteidruktnmkj("代理人氏名");
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.KJKHUKA);
        uiBean.setStdrsktdk(C_Tdk.HGU);
        uiBean.setSueokikknmosinput("0");
        uiBean.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setSyuhknkkn(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1240)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_S1() {
        String mosNo = "860000512";
        uiBean.setMosno(mosNo);
        uiBean.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKouhurikouzainfobankcd("3331");
        uiBean.setKouhurikouzainfositencd("751");
        uiBean.setKouhurikouzainfoyokinkbn(C_YokinKbn.BETUDAN);
        uiBean.setKouhurikouzainfokouzano("1234560");
        uiBean.setKouhurikouzainfokzdoukbn(C_KzkykdouKbn.DOUITU);
        uiBean.setKouhurikouzainfokzmeiginmkn("コウザカナ１");
        uiBean.setKouzakakuniniraikbn(C_YouhiblnkKbn.YOU);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        changeSystemDate(BizDate.valueOf(20180323));
        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1260)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_S2() {
        String mosNo = "860000520";
        uiBean.setMosno(mosNo);
        uiBean.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKouhurikouzainfobankcd("3331");
        uiBean.setKouhurikouzainfositencd("751");
        uiBean.setKouhurikouzainfoyokinkbn(C_YokinKbn.BETUDAN);
        uiBean.setKouhurikouzainfokouzano("1234560");
        uiBean.setKouhurikouzainfokzdoukbn(C_KzkykdouKbn.SITEI);
        uiBean.setKouhurikouzainfokzmeiginmkn("コウザカナ１");
        uiBean.setKouzakakuniniraikbn(C_YouhiblnkKbn.BLNK);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 8, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "口振口座情報入力保留", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "保留", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "口振口座情報銀行コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "3332", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "3331", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "口振口座情報支店コード", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "752", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "751", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "口振口座情報預金種目", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "普通・ゆうちょ", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "別段", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "口振口座情報口座番号", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "5584220", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "1234560", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "口振口座情報口座名義人同一区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "同一", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "指定", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "口振口座情報口座名義人", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "コウザカナ２", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "コウザカナ１", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "ＣＳＳ確認依頼区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "要", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "", "２次入力");
    }

    @Test
    @TestOrder(1280)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_S3() {
        String mosNo = "860000538";
        uiBean.setMosno(mosNo);
        uiBean.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.HORYUU);
        uiBean.setKouhurikouzainfobankcd("");
        uiBean.setKouhurikouzainfositencd("");
        uiBean.setKouhurikouzainfoyokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouhurikouzainfokouzano("");
        uiBean.setKouhurikouzainfokzdoukbn(C_KzkykdouKbn.BLNK);
        uiBean.setKouhurikouzainfokzmeiginmkn("");
        uiBean.setKouzakakuniniraikbn(C_YouhiblnkKbn.BLNK);
        uiBean.setSyuhknkkn(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "口振口座情報入力保留", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "保留", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(1310)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_M1() {
        String mosNo = "861110302";
        uiBean.setMosno(mosNo);
        uiBean.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.UNTEN);
        uiBean.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PASSPORT);
        uiBean.setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI);
        uiBean.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.ARI);
        uiBean.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 5, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110302", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "契約者", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "5:健康保険被保険者証", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "1:運転免許証・運転経歴証明書", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "親権者・後見人", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "6:船員保険被保険者証", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "2:パスポート", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "ご家族等への説明方法", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "ご家族等事前説明（対面）", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "ご家族等同席", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "面談回数（２回以上）", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "あり", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "取扱者以外の同席", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "あり", "２次入力");
    }

    @Test
    @TestOrder(1320)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_M2() {
        String mosNo = "861110310";
        uiBean.setMosno(mosNo);
        uiBean.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.UNTEN);
        uiBean.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PASSPORT);
        uiBean.setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI);
        uiBean.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.ARI);
        uiBean.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 5, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110310", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "契約者", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "15:健康保険被保険者証", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "11:運転免許証・運転経歴証明書", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "親権者・後見人", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "16:船員保険被保険者証", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "12:パスポート", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "ご家族等への説明方法", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "ご家族等事前説明（対面）", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "ご家族等同席", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "面談回数（２回以上）", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "あり", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "取扱者以外の同席", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "あり", "２次入力");
    }

    @Test
    @TestOrder(1330)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_M3() {
        String mosNo = "861110328";
        uiBean.setMosno(mosNo);
        uiBean.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.UNTEN);
        uiBean.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.PASSPORT);
        uiBean.setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn.KAZOKUDOUSEKI);
        uiBean.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.ARI);
        uiBean.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1410)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_N1() {
        String mosNo = "861110336";
        uiBean.setMosno(mosNo);
        uiBean.setDrtenjimcd1("1501");
        uiBean.setBosyuunintourokuno1("1001234501501");
        uiBean.setDairitenkinyuukikancd1("1521");
        uiBean.setDairitenkinyuukikansitencd1("301");
        uiBean.setDairitentoriatukaikouincd1("200000001501");
        uiBean.setInputbosyuucd1("1234566");
        uiBean.setGyousekikeijyousakisosikicd1("6001501");
        uiBean.setDairitenbuntanwariai1(BizNumber.valueOf(50));
        uiBean.setCifcd("130011234500001");
        uiBean.setSueokikknmosinput("0");
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setSyuhknkkn(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");

    }

    @Test
    @TestOrder(1420)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_N2() {
        String mosNo = "861110344";
        uiBean.setMosno(mosNo);
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
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 9, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110344", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "代理店事務所コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "1503", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "1501", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "代理店金融機関コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "1523", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "1521", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "代理店金融機関支店コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "303", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "301", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "代理店取扱行員コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "200000001503", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "200000001501", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "入力募集人コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "1234566", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "1234582", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "募集人登録番号1", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "1001234501503", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "1001234501501", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "業績計上先組織コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "6001503", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "6001501", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "代理店分担割合1", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "30", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "50", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "ＣＩＦコード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "130011234500002", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "130011234500003", "２次入力");
    }

    @Test
    @TestOrder(1430)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_N3() {
        String mosNo = "861110351";
        uiBean.setMosno(mosNo);
        uiBean.setDrtenjimcd1("1501");
        uiBean.setDairitenkinyuukikancd1("1521");
        uiBean.setDairitenkinyuukikansitencd1("301");
        uiBean.setDairitentoriatukaikouincd1("200000001501");
        uiBean.setInputbosyuucd1("4015001");
        uiBean.setGyousekikeijyousakisosikicd1("6001501");
        uiBean.setDairitenbuntanwariai1(BizNumber.valueOf(50));
        uiBean.setBosyuunintourokuno1("1001234501501");
        uiBean.setCifcd("130011234500003");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 9, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110351", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "代理店事務所コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "1501", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "代理店金融機関コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "1521", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "代理店金融機関支店コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "301", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "代理店取扱行員コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "200000001501", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "入力募集人コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "4015001", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "募集人登録番号1", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "1001234501501", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "業績計上先組織コード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "6001501", "２次入力");
        exNumericEquals(nrkDifLst.get(7).getRenno3keta(), 8, "連番（３桁）");
        exStringEquals(nrkDifLst.get(7).getNrksouikm(), "代理店分担割合1", "入力相違項目");
        exStringEquals(nrkDifLst.get(7).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(7).getNijinyrk(), "50", "２次入力");
        exNumericEquals(nrkDifLst.get(8).getRenno3keta(), 9, "連番（３桁）");
        exStringEquals(nrkDifLst.get(8).getNrksouikm(), "ＣＩＦコード1", "入力相違項目");
        exStringEquals(nrkDifLst.get(8).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(8).getNijinyrk(), "130011234500003", "２次入力");
    }

    @Test
    @TestOrder(1510)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_O1() {
        String mosNo = "861110369";
        uiBean.setMosno(mosNo);
        uiBean.setUktkid("14010000001");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1520)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_O2() {
        String mosNo = "861110377";
        uiBean.setMosno(mosNo);
        uiBean.setUktkid("14010000003");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhknkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));
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

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110377", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "受付管理ＩＤ", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "14010000002", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "14010000003", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }

    @Test
    @TestOrder(1610)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_P1() {
        String mosNo = "861110385";
        uiBean.setMosno(mosNo);
        uiBean.setDrtenjimcd2("1502");
        uiBean.setDairitenkinyuukikancd2("1522");
        uiBean.setDairitenkinyuukikansitencd2("302");
        uiBean.setDairitentoriatukaikouincd2("200000001502");
        uiBean.setInputbosyuucd2("1234566");
        uiBean.setBosyuunintourokuno2("1001234501502");
        uiBean.setGyousekikeijyousakisosikicd2("6001502");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setZnnkai(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1620)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_P2() {
        String mosNo = "861110393";
        uiBean.setMosno(mosNo);
        uiBean.setDrtenjimcd2("1502");
        uiBean.setDairitenkinyuukikancd2("1522");
        uiBean.setDairitenkinyuukikansitencd2("302");
        uiBean.setDairitentoriatukaikouincd2("200000001502");
        uiBean.setInputbosyuucd2("1234582");
        uiBean.setBosyuunintourokuno2("1001234501502");
        uiBean.setGyousekikeijyousakisosikicd2("6001502");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setSyuhknkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 7, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110393", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "代理店事務所コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "1504", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "1502", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "代理店金融機関コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "1524", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "1522", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "代理店金融機関支店コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "304", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "302", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "代理店取扱行員コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "200000001504", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "200000001502", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "入力募集人コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "1234566", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "1234582", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "募集人登録番号2", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "1001234501504", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "1001234501502", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "業績計上先組織コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "6001504", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "6001502", "２次入力");
    }

    @Test
    @TestOrder(1630)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_P3() {
        String mosNo = "861110401";
        uiBean.setMosno(mosNo);
        uiBean.setDrtenjimcd2("1506");
        uiBean.setDairitenkinyuukikancd2("1526");
        uiBean.setDairitenkinyuukikansitencd2("306");
        uiBean.setDairitentoriatukaikouincd2("200000001506");
        uiBean.setInputbosyuucd2("4015006");
        uiBean.setBosyuunintourokuno2("1001234501506");
        uiBean.setGyousekikeijyousakisosikicd2("6001506");
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setSyuhknkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 7, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110401", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "代理店事務所コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "1506", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "代理店金融機関コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "1526", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "代理店金融機関支店コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "306", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "代理店取扱行員コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "200000001506", "２次入力");
        exNumericEquals(nrkDifLst.get(4).getRenno3keta(), 5, "連番（３桁）");
        exStringEquals(nrkDifLst.get(4).getNrksouikm(), "入力募集人コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(4).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(4).getNijinyrk(), "4015006", "２次入力");
        exNumericEquals(nrkDifLst.get(5).getRenno3keta(), 6, "連番（３桁）");
        exStringEquals(nrkDifLst.get(5).getNrksouikm(), "募集人登録番号2", "入力相違項目");
        exStringEquals(nrkDifLst.get(5).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(5).getNijinyrk(), "1001234501506", "２次入力");
        exNumericEquals(nrkDifLst.get(6).getRenno3keta(), 7, "連番（３桁）");
        exStringEquals(nrkDifLst.get(6).getNrksouikm(), "業績計上先組織コード2", "入力相違項目");
        exStringEquals(nrkDifLst.get(6).getItijinyuuroku(), "", "１次入力");
        exStringEquals(nrkDifLst.get(6).getNijinyrk(), "6001506", "２次入力");
    }

    @Test
    @TestOrder(1710)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_Q1() {
        String mosNo = "861110427";
        uiBean.setMosno(mosNo);
        uiBean.setTsryhshrkykumukbn(C_UmuKbn.ARI);
        uiBean.setSyosisyatodokeumukbn(C_UmuKbn.ARI);
        uiBean.setKakukisyouryakukbumukbn(C_UmuKbn.ARI);
        uiBean.setSeiymdmosseitouumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setSyuhknkkn(0);
        uiBean.setZnnkai(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1720)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_Q2() {
        String mosNo = "861110435";
        uiBean.setMosno(mosNo);
        uiBean.setTsryhshrkykumukbn(C_UmuKbn.ARI);
        uiBean.setSyosisyatodokeumukbn(C_UmuKbn.ARI);
        uiBean.setKakukisyouryakukbumukbn(C_UmuKbn.ARI);
        uiBean.setSeiymdmosseitouumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        changeSystemDate(BizDate.valueOf(20180323));
        uiBean.setSyuhknkkn(0);

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 4, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110435", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "手数料不支払契約", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "なし", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "あり", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
        exNumericEquals(nrkDifLst.get(1).getRenno3keta(), 2, "連番（３桁）");
        exStringEquals(nrkDifLst.get(1).getNrksouikm(), "証券支社届", "入力相違項目");
        exStringEquals(nrkDifLst.get(1).getItijinyuuroku(), "なし", "１次入力");
        exStringEquals(nrkDifLst.get(1).getNijinyrk(), "あり", "２次入力");
        exNumericEquals(nrkDifLst.get(2).getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(nrkDifLst.get(2).getNrksouikm(), "カク基省略希望", "入力相違項目");
        exStringEquals(nrkDifLst.get(2).getItijinyuuroku(), "なし", "１次入力");
        exStringEquals(nrkDifLst.get(2).getNijinyrk(), "あり", "２次入力");
        exNumericEquals(nrkDifLst.get(3).getRenno3keta(), 4, "連番（３桁）");
        exStringEquals(nrkDifLst.get(3).getNrksouikm(), "生年月日申込書正当", "入力相違項目");
        exStringEquals(nrkDifLst.get(3).getItijinyuuroku(), "なし", "１次入力");
        exStringEquals(nrkDifLst.get(3).getNijinyrk(), "あり", "２次入力");
    }

    @Test
    @TestOrder(1810)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_R1() {
        String mosNo = "861110443";
        uiBean.setMosno(mosNo);
        uiBean.setTkhsyouryakuumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setSyuhknkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, 0, "差異有無");
        exNumericEquals(nrkDifLst.size(), 0, "入力差異テーブルエンティティリストのサイズ");
    }

    @Test
    @TestOrder(1820)
    @Transactional
    public void testRegisterSaiDataMousikomisyo_R2() {
        String mosNo = "861110450";
        uiBean.setMosno(mosNo);
        uiBean.setTkhsyouryakuumukbn(C_UmuKbn.ARI);
        uiBean.setSueokikknmosinput("0");
        uiBean.setSyuhrkkkn(0);
        uiBean.setZnnkai(0);
        uiBean.setSyuhknkkn(0);
        changeSystemDate(BizDate.valueOf(20180323));

        uiBean.setKzktourokuserviceTourokuKbn(C_KzktourokuserviceTourokuKbn.BLNK);
        uiBean.setTrkkzknmkjkhukakbn1(C_KjkhukaKbn.BLNK);
        uiBean.setTrkkzktsindousiteikbn1(C_TsindousiteiKbn.BLNK);
        uiBean.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
        uiBean.setStdruktkbn(C_UktKbn.BLNK);
        uiBean.setStdrsknmkjhukakbn(C_KjkhukaKbn.BLNK);
        uiBean.setStdrsktdk(C_Tdk.BLNK);

        BizPropertyInitializer.initialize(uiBean);

        int saiUmu = saiDataTouroku.registerSaiDataMousikomisyo(uiBean, SOUSASYACD, SYSDATE);

        List<HT_NrkDif> nrkDifLst = sinkeiyakuDomManager.getSyoriCTL(mosNo).
            getNrkDifsByVrfkinouid(ISkCommonKoumoku.VRFKINOUKBN_MOUSIKOMISYO);

        exNumericEquals(saiUmu, -1, "差異有無");
        exNumericEquals(nrkDifLst.size(), 1, "入力差異テーブルエンティティリストのサイズ");
        exStringEquals(nrkDifLst.get(0).getMosno(), "861110450", "申込番号");
        exStringEquals(nrkDifLst.get(0).getVrfkinouid(), "MOUSIKOMISYO", "ベリファイ機能ID");
        exNumericEquals(nrkDifLst.get(0).getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(nrkDifLst.get(0).getNrksouikm(), "通計保留省略有無区分", "入力相違項目");
        exStringEquals(nrkDifLst.get(0).getItijinyuuroku(), "なし", "１次入力");
        exStringEquals(nrkDifLst.get(0).getNijinyrk(), "あり", "２次入力");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinsyaId(), "sousasyatest", "業務用更新者ＩＤ");
        exStringEquals(nrkDifLst.get(0).getGyoumuKousinTime(), "20160420", "業務用更新時間");
    }
}
package yuyu.common.direct.dscommon;

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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForDirect;
import yuyu.def.classification.C_CheckKaiyakuUketukeKekkaKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約受付チェック{@link CheckKaiyakuUketuke#kaiyakusyokaiChk(String)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKaiyakuUketukeTest_kaiyakusyokaiChk extends AbstractTest{

    @Inject
    private CheckKaiyakuUketuke checkKaiyakuUketuke;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約受付チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HozenKeiyakuIdouJyoutaiSyutoku.class).to(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class);
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForDirect.class);
                bind(CheckDsKaiyaku.class).to(CheckDsKaiyakuMockForDirect.class);
                bind(CheckDsTorihikiService.class).to(CheckDsTorihikiServiceMockForDirect.class);
                bind(DsDataMaintenanceHantei.class).to(DsDataMaintenanceHanteiMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class;
        KeisanCommonKaiyakuMockForDirect.caller = CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class;
        CheckDsKaiyakuMockForDirect.caller = CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class;
        CheckDsTorihikiServiceMockForDirect.caller = CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class;
        DsDataMaintenanceHanteiMockForDirect.caller = CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class;

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.caller = null;
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = null;

        KeisanCommonKaiyakuMockForDirect.caller = null;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = null;

        CheckDsKaiyakuMockForDirect.caller = null;
        CheckDsKaiyakuMockForDirect.SYORIPTN = null;

        CheckDsTorihikiServiceMockForDirect.caller = null;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = null;

        DsDataMaintenanceHanteiMockForDirect.caller = null;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testTelkaiyakuKadoutimeChk_A1() throws Exception {

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("110000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("200000000");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testTelkaiyakuKadoutimeChk_A2() throws Exception {

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("200000000");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testTelkaiyakuKadoutimeChk_A3() throws Exception {

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("200000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("199999999");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testDskokyakujtChk_A1() throws Exception {

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("000000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("999999999");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111118");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "ＤＳに加入していない契約のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1033", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.DSMIKANYUUKEIYAKU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testDskokyakujtChk_A2() throws Exception {

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111129");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "ＤＳが一時停止中のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1041", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.DSITIZITEISITYUU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testDskokyakujtChk_A3() throws Exception {

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111130");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "ＤＳが一時停止中のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1041", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.DSITIZITEISITYUU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testDskokyakujtChk_A4() throws Exception {

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111163");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "ＤＳ顧客状態区分が不整合です。（ＤＳ顧客状態区分：3）", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1043", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), "3", "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(80)
    public void testDskokyakujtChk_A5() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN1;

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111141");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "異動中（住所変更、名義変更中）のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1042", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.DSIDOUTYUU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        MockObjectManager.assertArgumentPassed(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class, "hozenKeiyakuIdouJyoutaiSyutoku", 0, "11807111141");
    }

    @Test
    @TestOrder(90)
    public void testDskokyakujtChk_A6() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN2;

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111152");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "保全契約異動状態取得（証券番号：11807111152）処理中にエラーが発生しました。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EBF0129", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), "保全契約異動状態取得（証券番号：11807111152）", "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        MockObjectManager.assertArgumentPassed(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class, "hozenKeiyakuIdouJyoutaiSyutoku", 0, "11807111152");
    }

    @Test
    @TestOrder(100)
    public void testDskokyakujtChk_A7() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111174");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "特定取引用口座が未登録です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1031", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.TOKUTEIKOUZAMITOUROKU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        MockObjectManager.assertArgumentPassed(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class, "hozenKeiyakuIdouJyoutaiSyutoku", 0, "11807111174");
    }

    @Test
    @TestOrder(110)
    public void testTokuteitrhkkzYuukoujtChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111196");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "特定取引用口座、特定取引用暗証番号が利用できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1029", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.TOKUTEIKOUZAMUKOU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        MockObjectManager.assertArgumentPassed(HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.class, "hozenKeiyakuIdouJyoutaiSyutoku", 0, "11807111196");
    }

    @Test
    @TestOrder(120)
    public void testKawaserateExistChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111200");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "円貨支払為替レートが取得できないため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1040", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KAWASERATEMITOUTYAKU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        //        exDateEquals((BizDate) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 0),
        //            BizDate.getSysDate(), "為替レート基準日");
        //        exClassificationEquals((C_KawaserateSyuruiKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 1),
        //            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, "為替レート種類区分");
        //        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 2),
        //            C_Tuukasyu.USD, "元通貨");
        //        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 3),
        //            C_Tuukasyu.JPY, "換算通貨");
        //        exClassificationEquals((C_KawasetekiyoKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 4),
        //            C_KawasetekiyoKbn.TTM, "為替適用区分");
        //        exClassificationEquals((C_KawasetsryKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 5),
        //            C_KawasetsryKbn.SYUKKINRATE, "為替手数料区分");
        //        exClassificationEquals((C_EigyoubiHoseiKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 6),
        //            C_EigyoubiHoseiKbn.BLNK, "営業日補正区分");
        //        exClassificationEquals((C_YouhiKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 7),
        //            C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");

    }

    @Test
    @TestOrder(130)
    public void testKykymdMaeChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111211");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "手続日が契約日前のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EIA0070", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), "手続日", "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KEIYAKUYMDMAE, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        //        exDateEquals((BizDate) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 0),
        //            BizDate.getSysDate(), "為替レート基準日");
        //        exClassificationEquals((C_KawaserateSyuruiKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 1),
        //            C_KawaserateSyuruiKbn.KOUJIKAWASERATE, "為替レート種類区分");
        //        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 2),
        //            C_Tuukasyu.EUR, "元通貨");
        //        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 3),
        //            C_Tuukasyu.JPY, "換算通貨");
        //        exClassificationEquals((C_KawasetekiyoKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 4),
        //            C_KawasetekiyoKbn.TTM, "為替適用区分");
        //        exClassificationEquals((C_KawasetsryKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 5),
        //            C_KawasetsryKbn.SYUKKINRATE, "為替手数料区分");
        //        exClassificationEquals((C_EigyoubiHoseiKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 6),
        //            C_EigyoubiHoseiKbn.BLNK, "営業日補正区分");
        //        exClassificationEquals((C_YouhiKbn) MockObjectManager.getArgument(GetKawaseRateMock.class, "exec", 0, 7),
        //            C_YouhiKbn.HUYOU, "前営業日為替レート取得要否");

    }

    @Test
    @TestOrder(140)
    public void testTokuteitrhkkzMstExistChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111222");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "登録された銀行または支店が存在しません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1032", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.GINKOUMASTERSONZAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        //        exStringEquals((String) MockObjectManager.getArgument(BzGetBankDataMock.class, "exec", 0, 0),
        //            "9999", "銀行コード");
        //        exStringEquals((String) MockObjectManager.getArgument(BzGetBankDataMock.class, "exec", 0, 1),
        //            "111", "支店コード");
    }

    @Test
    @TestOrder(150)
    public void testDskaiyakuChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111233");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "解約共通計算（証券番号：11807111233、処理年月日：" + BizDate.getSysDate() + "）処理中にエラーが発生しました。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EBF0129", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), "解約共通計算（証券番号：11807111233、処理年月日：" + BizDate.getSysDate() + "）", "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        //exStringEquals((String) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 0),
        //  "11807111233", "証券番号");
        //exDateEquals((BizDate) MockObjectManager.getArgument(KeisanCommonKaiyakuMockForDirect.class, "keisanKaiyakuseisankin", 0, 1),
        //  BizDate.getSysDate(), "計算基準日");
    }

    @Test
    @TestOrder(170)
    public void testDskaiyakuChk_A3() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111255");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "契約のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EIA0035", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.HOZENYUUKOUJYOUTAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        exStringEquals((String) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 0),
            "11807111255", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 1),
            BizDate.getSysDate(), "解約受付日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 2),
            BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN), "解約返戻金（円貨）");
        exClassificationEquals((C_DsSyouhnbunruiKbn) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 3),
            C_DsSyouhnbunruiKbn.BLNK, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(180)
    public void testDskaiyakuChk_A4() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111266");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "手続注意[]が設定されている契約のため、処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EIA1006", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.TETUDUKITYUUI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        exStringEquals((String) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 0),
            "11807111266", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 1),
            BizDate.getSysDate(), "解約受付日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 2),
            BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN), "解約返戻金（円貨）");
        exClassificationEquals((C_DsSyouhnbunruiKbn) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 3),
            C_DsSyouhnbunruiKbn.BLNK, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(190)
    public void testDskaiyakuChk_A5() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN3;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111277");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "質権、差押え、破産、債権者解約申出が設定されている契約のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EIF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SITIKENSETTEI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        exStringEquals((String) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 0),
            "11807111277", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 1),
            BizDate.getSysDate(), "解約受付日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 2),
            BizCurrency.valueOf(new BigDecimal("1234546789012"), BizCurrencyTypes.YEN), "解約返戻金（円貨）");
        exClassificationEquals((C_DsSyouhnbunruiKbn) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakukytChk", 0, 3),
            C_DsSyouhnbunruiKbn.BLNK, "ＤＳ商品分類区分");
    }

    @Test
    @TestOrder(200)
    public void testDskaiyakuChk_A6() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN4;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111288");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "手続日以降に円建変更が行われています。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1034", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.YENDATEHENKOUMAE, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(210)
    public void testDskaiyakuChk_A7() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN5;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111299");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "先日付の変更があるため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EIA0106", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SAKIYMDHENKOU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(220)
    public void testDskaiyakuChk_A8() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN6;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111303");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "手続日が契約日前のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EIA0070", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), "手続日", "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KEIYAKUYMDMAE, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(230)
    public void testDskaiyakuChk_A9() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN7;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111314");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "支払額合計が上限金額（3,000万円）を超えています。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1035", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SOUKINJYOUGEN, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(240)
    public void testDskaiyakuChk_A10() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN8;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111325");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "ＤＳ解約共通チェック結果が想定外の値です。（ＤＳ解約共通チェック結果区分：0）", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1045", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), "0", "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(250)
    public void testTokuteitrhkkzChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN1;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111336");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "登録された銀行または支店が存在しません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1032", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.GINKOUMASTERSONZAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 0),
            C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 1),
            "6666", "銀行コード");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 2),
            "222", "支店コード");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 3),
            "KOKYAKU", "口座名義人名（カナ）");
        exClassificationEquals((C_Kzdou) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 4),
            C_Kzdou.SITEI, "ＤＳ商品分類区分");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 5),
            "契約者カナ", "契約者名（カナ）");

    }

    @Test
    @TestOrder(260)
    public void testTokuteitrhkkzChk_A2() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN2;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111347");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "登録された銀行または支店が有効ではありません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1036", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.GINKOUYUUKOUSEIHANTEI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 0),
            C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 1),
            "6666", "銀行コード");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 2),
            "222", "支店コード");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 3),
            null, "口座名義人名（カナ）");
        exClassificationEquals((C_Kzdou) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 4),
            null, "ＤＳ商品分類区分");
        exStringEquals((String) MockObjectManager.getArgument(CheckDsTorihikiServiceMockForDirect.class, "checkSoukinyoukz", 0, 5),
            null, "契約者名（カナ）");

    }

    @Test
    @TestOrder(270)
    public void testTokuteitrhkkzChk_A3() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN3;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111358");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "送金の取扱いがない支店です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EBC1009", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.YUUTYOGINKOUSOUKINKAHI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(280)
    public void testTokuteitrhkkzChk_A4() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN4;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111369");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "外貨送金の取扱いがない銀行または支店です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EBC1010", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.GAIKAKOUZASOUKINKAHI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(290)
    public void testTokuteitrhkkzChk_A5() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN5;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111370");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "口座名義人が正しくありません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1037", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KOUZAMEIGININMEI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(300)
    public void testTokuteitrhkkzChk_A6() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN6;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111381");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "送金用口座正当性チェック結果が想定外の値です。（送金用口座正当性チェック結果区分：0）", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1046", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), "0", "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.SYSTEMERROR, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

    }

    @Test
    @TestOrder(310)
    public void testDskaiyakuukeumuChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN10;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN7;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111392");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "既に解約受付済みの契約です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1038", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KAIYAKUUKETUKEZUMI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");

        exStringEquals((String) MockObjectManager.getArgument(CheckDsKaiyakuMockForDirect.class, "kaiyakuUkeUmuChk", 0, 0),
            "11807111392", "証券番号");
    }

    @Test
    @TestOrder(320)
    public void testDskaiyakuukeumuChk_A2() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN11;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN7;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("000000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("999999999");
        changeSystemDate(BizDate.valueOf("20190930"));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111406");

        exStringEquals(checkKaiyakuUketuke.getMessage(), null, "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), null, "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), null, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(330)
    public void testKaiyakusyokaiChk() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN11;
        CheckDsTorihikiServiceMockForDirect.SYORIPTN = CheckDsTorihikiServiceMockForDirect.TESTPATTERN7;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("000000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("999999999");
        changeSystemDate(BizDate.valueOf(20181002));

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("11807111185");

        exStringEquals(checkKaiyakuUketuke.getMessage(), null, "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), null, "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), null, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(340)
    public void testTelkaiyakuKadoutimeChk_A4() throws Exception {

        changeSystemDate(BizDate.valueOf(20181201));

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("110000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("200000000");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(350)
    public void testTelkaiyakuKadoutimeChk_A5() throws Exception {

        changeSystemDate(BizDate.valueOf(20181201));

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("110000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("200000000");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(360)
    public void testTelkaiyakuKadoutimeChk_A6() throws Exception {

        changeSystemDate(BizDate.valueOf(20181201));

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("110000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("200000000");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(370)
    public void testTelkaiyakuKadoutimeChk_A7() throws Exception {

        changeSystemDate(BizDate.valueOf(20181201));

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("200000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("200000000");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(380)
    public void testTelkaiyakuKadoutimeChk_A8() throws Exception {

        changeSystemDate(BizDate.valueOf(20181201));

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("200000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("199999999");

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "システム稼動時間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1027", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.KADOUZIKANGAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(390)
    public void testDskaiyakuChk_A11() throws Exception {

        changeSystemDate(BizDate.valueOf(20181203));

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN12;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        YuyuDswebConfig.getInstance().setKaiyakuServiceKadouKaisiTime("000000000");
        YuyuDswebConfig.getInstance().setDenwakaiyakuKadouSyuuryouTime("999999999");
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000024");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "配当整合チェックエラーです。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1047", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.MFHUSEIGOU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(400)
    public void testDskaiyakuChk_A12() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN13;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20181203));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000035");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "配当金が未反映のため、処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1048", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.MIHANEIHAITOUKIN, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(410)
    public void testDskaiyakuChk_A13() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN14;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20181203));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000046");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "手続日が配当金支払の処理日より前のため処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1049", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.HAITOUKINHANEIYMDSONZAI, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(420)
    public void testDskaiyakuChk_A14() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN15;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20181203));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000057");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "手続日が払込猶予期間外です。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1050", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.HARAIKOMIYUYOKIKAN, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(430)
    public void testDskaiyakuChk_A15() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN16;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20181203));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000068");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "配当支払チェックが実行できませんでした。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EIF1107", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.HAITOUKIN, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(440)
    public void testDskaiyakuChk_A16() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN17;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20181203));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000079");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "積立金が未反映のため、処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1051", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.MIHANEITUMITATEKIN, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(450)
    public void testDsDataMaintenanceChk_A1() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        C_ErrorKbn errorKbn = checkKaiyakuUketuke.dsDataMaintenanceChk("11807111406");

        exStringEquals(checkKaiyakuUketuke.getMessage(), null, "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), null, "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), null, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
    }

    @Test
    @TestOrder(460)
    public void testDsDataMaintenanceChk_A2() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN2;

        changeSystemDate(BizDate.valueOf(20181203));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000080");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "データメンテナンス中契約のため、処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1053", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.DSDATAMAINTENANCE, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }

    @Test
    @TestOrder(470)
    public void testDskaiyakuChk_A17() throws Exception {

        MockObjectManager.initialize();
        HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.SYORIPTN = HozenKeiyakuIdouJyoutaiSyutokuMockForDirect.TESTPATTERN3;
        KeisanCommonKaiyakuMockForDirect.SYORIPTN = KeisanCommonKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN18;
        DsDataMaintenanceHanteiMockForDirect.SYORIPTN = DsDataMaintenanceHanteiMockForDirect.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20181204));
        C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk("17806000091");

        exStringEquals(checkKaiyakuUketuke.getMessage(), "前納Ｐが充当されていないため、処理できません。", "メッセージ");
        exStringEquals(checkKaiyakuUketuke.getMessageId(), "EMF1052", "メッセージID");
        exStringEquals(checkKaiyakuUketuke.getMessageParam(), null, "メッセージパラメータ");
        exClassificationEquals(checkKaiyakuUketuke.getCheckKaiyakuUketukeKekkaKbn(), C_CheckKaiyakuUketukeKekkaKbn.ZENNOUMIJYUUTOU, "解約受付チェック結果区分");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
    }
}

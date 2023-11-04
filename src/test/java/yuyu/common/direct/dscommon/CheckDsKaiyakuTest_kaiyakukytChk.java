package yuyu.common.direct.dscommon;

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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuBean;
import yuyu.common.hozen.khcommon.CheckKaiyakuMockForDirect;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngaiMockForDirect;
import yuyu.def.classification.C_DsKaiyakuchkkekkaKbn;
import yuyu.def.classification.C_DsSyouhnbunruiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ解約共通チェックのメソッド{@link CheckDsKaiyaku#kaiyakukytChk(String, BizDate, BizCurrency, C_DsSyouhnbunruiKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDsKaiyakuTest_kaiyakukytChk {

    @Inject
    private CheckDsKaiyaku checkDsKaiyaku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ解約共通チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckKaiyaku.class).to(CheckKaiyakuMockForDirect.class);
                bind(CheckYuuyokkngai.class).to(CheckYuuyokkngaiMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        CheckKaiyakuMockForDirect.caller = CheckDsKaiyakuTest_kaiyakukytChk.class;
        CheckYuuyokkngaiMockForDirect.caller = CheckDsKaiyakuTest_kaiyakukytChk.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDsKaiyakuTest_kaiyakukytChk.class,
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
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @AfterClass
    public static void testClear() {

        CheckKaiyakuMockForDirect.caller = null;
        CheckKaiyakuMockForDirect.SYORIPTN =null;
        CheckYuuyokkngaiMockForDirect.caller =null;
        CheckYuuyokkngaiMockForDirect.SYORIPTN =null;

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("99806001010", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.HOZENJYOUTAI, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "前納", "メッセージパラメータ");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("99806001021", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.TETUDUKITYUUI, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "手続中応対注意", "メッセージパラメータ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000013", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.SITIKENSETTEI, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000024", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        String kinouBunrui = (String) MockObjectManager.getArgument(CheckKaiyakuMockForDirect.class, "exec", 0, 0);
        String gamenBunrui = (String) MockObjectManager.getArgument(CheckKaiyakuMockForDirect.class, "exec", 0, 1);
        CheckKaiyakuBean checkKaiyakuBean = (CheckKaiyakuBean) MockObjectManager.getArgument(CheckKaiyakuMockForDirect.class, "exec", 0, 2);
        exStringEquals(kinouBunrui, "drctservice", "機能分類");
        exStringEquals(gamenBunrui, "", "画面分類");
        exDateEquals(checkKaiyakuBean.getSyoruiukeYmd(), BizDate.valueOf("20180211"), "書類受付日");
        exDateEquals(checkKaiyakuBean.getSyukykYmd(), BizDate.valueOf("20180210"), "主契約契約日");
        exDateEquals(checkKaiyakuBean.getYendthnkYmd(), BizDate.valueOf("20180212"), "円建変更日");
        exStringEquals(checkKaiyakuBean.getKykKihon().getSyono(), "17806000024", "証券番号");

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.SAKIYMDHENKOU, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000035", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.KYKYMDMAE, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN3;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000046", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.YENDATEHENKOUMAE, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN4;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000057", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(30000001), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.SOUKINJYOUGEN, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN4;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000068", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(30000000), C_DsSyouhnbunruiKbn.BLNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.BLNK, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN4;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000079", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(29999999), C_DsSyouhnbunruiKbn.BLNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.BLNK, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN5;

        try {
            CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("17806000116", BizDate.valueOf("20180211"),
                BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。解約共通チェック結果が想定外の値です。", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN6;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111129", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.MFHUSEIGOU, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN7;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111130", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.MIHANEIHAITOUKIN, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN8;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111141", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(),
            C_DsKaiyakuchkkekkaKbn.HAITOUKINHANEIYMDSONZAI, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN4;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111152", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.BLNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.BLNK, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN4;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111163", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.BLNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.HARAIKOMIYUYOKIKAN, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN4;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111174", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.BLNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.BLNK, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN4;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN2;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111185", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.BLNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.HARAIKOMIYUYOKIKAN, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN9;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111129", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRSYSN);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.HAITOUKIN, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }
    @Test
    @TestOrder(190)
    public void testExec_A19() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN10;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111129", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.MIHANEITUMITATEKIN, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }
    @Test
    @TestOrder(200)
    public void testExec_A20() {

        MockObjectManager.initialize();
        CheckKaiyakuMockForDirect.SYORIPTN = CheckKaiyakuMockForDirect.TESTPATTERN11;
        CheckDsKaiyakuResultBean checkDsKaiyakuResultBean = checkDsKaiyaku.kaiyakukytChk("11807111129", BizDate.valueOf("20180211"),
            BizCurrency.valueOf(100), C_DsSyouhnbunruiKbn.YENDTITIJIBRNK);

        exClassificationEquals(checkDsKaiyakuResultBean.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(checkDsKaiyakuResultBean.getDsKaiyakuchkkekkaKbn(), C_DsKaiyakuchkkekkaKbn.ZENNOUMIJYUUTOU, "ＤＳ解約共通チェック結果区分");
        exStringEquals(checkDsKaiyakuResultBean.getMsgPam(), "", "メッセージパラメータ");
    }
}

package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KhCheckBankMaster;
import yuyu.common.hozen.khcommon.KhCheckBankMasterMockForDirect;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ取引サービス共通チェッククラスのメソッド {@link CheckDsTorihikiService#checkSoukinyoukz(C_Tuukasyu, String, String, String, C_Kzdou, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDsTorihikiServiceTest_checkSoukinyoukz {

    @Inject
    private CheckDsTorihikiService checkDsTorihikiService;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(KhCheckBankMaster.class).to(KhCheckBankMasterMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        KhCheckBankMasterMockForDirect.caller = CheckDsTorihikiServiceTest_checkSoukinyoukz.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.caller = null;
        KhCheckBankMasterMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(1010)
    public void testCheckSoukinyoukz_A1() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN1;

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
            "0001", "004", null, null, null);
        exClassificationEquals(checkSoukinyoukzResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn(),
            C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI, "送金用口座正当性チェック結果区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KhCheckBankMasterMockForDirect.class, "checkBankMaster", 0, 0), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals((String)MockObjectManager.getArgument(KhCheckBankMasterMockForDirect.class, "checkBankMaster", 0, 1), "0001", "銀行コード");
        exStringEquals((String)MockObjectManager.getArgument(KhCheckBankMasterMockForDirect.class, "checkBankMaster", 0, 2), "004", "支店コード");
    }

    @Test
    @TestOrder(1020)
    public void testCheckSoukinyoukz_A2() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN2;

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
            "0001", "005", null, null, null);
        exClassificationEquals(checkSoukinyoukzResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn(),
            C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI, "送金用口座正当性チェック結果区分");
    }

    @Test
    @TestOrder(1030)
    public void testCheckSoukinyoukz_A3() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN3;

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
            "0001", "009", null, null, null);
        exClassificationEquals(checkSoukinyoukzResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn(),
            C_SoukinyoukzchkkekkaKbn.YUUTYOGINKOUSOUKINKAHI, "送金用口座正当性チェック結果区分");
    }

    @Test
    @TestOrder(1040)
    public void testCheckSoukinyoukz_A4() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN4;

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
            "0001", "013", null, null, null);
        exClassificationEquals(checkSoukinyoukzResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn(),
            C_SoukinyoukzchkkekkaKbn.GAIKAKOUZASOUKINKAHI, "送金用口座正当性チェック結果区分");
    }

    @Test
    @TestOrder(1050)
    public void testCheckSoukinyoukz_A5() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN5;

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
            "0001", "015", "あいうえお", C_Kzdou.DOUITU, "かきくけこ");
        exClassificationEquals(checkSoukinyoukzResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn(),
            C_SoukinyoukzchkkekkaKbn.KOUZAMEIGININ, "送金用口座正当性チェック結果区分");
    }

    @Test
    @TestOrder(1060)
    public void testCheckSoukinyoukz_A6() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN5;

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
            "0001", "015", "あいうえお", C_Kzdou.SITEI, "かきくけこ");
        exClassificationEquals(checkSoukinyoukzResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn(),
            C_SoukinyoukzchkkekkaKbn.BLNK, "送金用口座正当性チェック結果区分");
    }

    @Test
    @TestOrder(1070)
    public void testCheckSoukinyoukz_A7() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN5;

        CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
            "0001", "015", "あいうえお", C_Kzdou.DOUITU, "あいうえお");
        exClassificationEquals(checkSoukinyoukzResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exClassificationEquals(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn(),
            C_SoukinyoukzchkkekkaKbn.BLNK, "送金用口座正当性チェック結果区分");
    }

    @Test
    @TestOrder(1080)
    public void testCheckSoukinyoukz_A8() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForDirect.SYORIPTN = KhCheckBankMasterMockForDirect.TESTPATTERN6;

        try{
            CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(C_Tuukasyu.JPY,
                "0001", "015", "あいうえお", C_Kzdou.DOUITU, "あいうえお");
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。銀行マスタチェック結果が想定外の値です。", "エラーメッセージ");
        }
    }
}
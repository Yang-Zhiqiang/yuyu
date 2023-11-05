package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 銀行名支店名取得クラスのメソッド {@link GetBankSitenNm#exec(String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetBankSitenNmTest_exec {

    @Inject
    private GetBankSitenNm getBankSitenNm;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_銀行名支店名取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetBankSitenNmTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getGinkou("9800","100"));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String pBankcd = "9900";
        String pSitencd = "110";

        getBankSitenNm.exec(pBankcd, pSitencd);

        exClassificationEquals(getBankSitenNm.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(getBankSitenNm.getBankNmKj(), "ゆうちょ銀行", "銀行名（漢字）");
        exStringEquals(getBankSitenNm.getSitenNmKj(), "１１１００", "支店名（漢字）");
        exStringEquals(getBankSitenNm.getBankNmKn(), "ユウチョギンコウ", "銀行名（全角カナ）");
        exStringEquals(getBankSitenNm.getSitenNmKn(), "１１１００", "支店名（全角カナ）");
        exStringEquals(getBankSitenNm.getBankNmHnkakuKn(), "ﾕｳﾁｮｷﾞﾝｺｳ", "銀行名（半角ｶﾅ）");
        exStringEquals(getBankSitenNm.getSitenNmHnkakuKn(), "11100", "支店名（半角ｶﾅ）");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String pBankcd = "9700";
        String pSitencd = "110";

        getBankSitenNm.exec(pBankcd, pSitencd);

        exClassificationEquals(getBankSitenNm.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(getBankSitenNm.getBankNmKj(), "", "銀行名（漢字）");
        exStringEquals(getBankSitenNm.getSitenNmKj(), "", "支店名（漢字）");
        exStringEquals(getBankSitenNm.getBankNmKn(), "", "銀行名（全角カナ）");
        exStringEquals(getBankSitenNm.getSitenNmKn(), "", "支店名（全角カナ）");
        exStringEquals(getBankSitenNm.getBankNmHnkakuKn(), "", "銀行名（半角ｶﾅ）");
        exStringEquals(getBankSitenNm.getSitenNmHnkakuKn(), "", "支店名（半角ｶﾅ）");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String pBankcd = "9800";
        String pSitencd = "100";

        getBankSitenNm.exec(pBankcd, pSitencd);

        exClassificationEquals(getBankSitenNm.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(getBankSitenNm.getBankNmKj(), "ゆうゆう生保銀行", "銀行名（漢字）");
        exStringEquals(getBankSitenNm.getSitenNmKj(), "支店銀行", "支店名（漢字）");
        exStringEquals(getBankSitenNm.getBankNmKn(), "ユウユウギンコウ", "銀行名（全角カナ）");
        exStringEquals(getBankSitenNm.getSitenNmKn(), "ギンコウ", "支店名（全角カナ）");
        exStringEquals(getBankSitenNm.getBankNmHnkakuKn(), "ﾕｳﾕｳｷﾞﾝｺｳ", "銀行名（半角ｶﾅ）");
        exStringEquals(getBankSitenNm.getSitenNmHnkakuKn(), "ｷﾞﾝｺｳ", "支店名（半角ｶﾅ）");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String pBankcd = "";
        String pSitencd = "";

        getBankSitenNm.exec(pBankcd, pSitencd);

        exClassificationEquals(getBankSitenNm.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(getBankSitenNm.getBankNmKj(), "", "銀行名（漢字）");
        exStringEquals(getBankSitenNm.getSitenNmKj(), "", "支店名（漢字）");
        exStringEquals(getBankSitenNm.getBankNmKn(), "", "銀行名（全角カナ）");
        exStringEquals(getBankSitenNm.getSitenNmKn(), "", "支店名（全角カナ）");
        exStringEquals(getBankSitenNm.getBankNmHnkakuKn(), "", "銀行名（半角ｶﾅ）");
        exStringEquals(getBankSitenNm.getSitenNmHnkakuKn(), "", "支店名（半角ｶﾅ）");
    }

}

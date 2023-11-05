package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.impl.BizDomManagerImpl;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当元利金計算クラスのメソッド {@link KeisanDGanrikin#exec(BizCurrency, BizDate, BizDate )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanDGanrikinTest_exec1 {

    C_ErrorKbn  errorKbn;

    @Inject
    KeisanDGanrikin keisanDGanrikin;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当元利金計算";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanDGanrikinTest_exec1.class, fileName, sheetName);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManagerImpl bizDomManagerImpl = SWAKInjector.getInstance(BizDomManagerImpl.class);
        bizDomManagerImpl.delete(bizDomManagerImpl.getAllHaitouRiritu());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizCurrency pRuigk = null;
        BizDate pCalckijyunfromymd = BizDate.valueOf("20181101");
        BizDate pCalckijyuntoymd = BizDate.valueOf("20181129");

        errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        BizDate pCalckijyunfromymd = null;
        BizDate pCalckijyuntoymd = BizDate.valueOf("20181129");

        errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        BizDate pCalckijyunfromymd = BizDate.valueOf("20181101");
        BizDate pCalckijyuntoymd = null;

        errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);
        List<HaitouErrorInfo> keisanDGanrikinErrorInfoLst = keisanDGanrikin.getErrorInfo();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getKinouId(), keisanDGanrikin.getClass().getSimpleName(), "機能ID");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(keisanDGanrikinErrorInfoLst.get(0).getErrorInfo2(),
            "必須の引数にnullが含まれます", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizCurrency pRuigk = BizCurrency.valueOf(-1000);
        BizDate pCalckijyunfromymd = BizDate.valueOf("20181101");
        BizDate pCalckijyuntoymd = BizDate.valueOf("20181129");

        errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(-1000), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(-1000), "累計額");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 1, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20181129"), "計算基準日至");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizCurrency pRuigk = BizCurrency.valueOf(0);
        BizDate pCalckijyunfromymd = BizDate.valueOf("20181101");
        BizDate pCalckijyuntoymd = BizDate.valueOf("20181129");


        errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A6() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        BizDate pCalckijyunfromymd = BizDate.valueOf("20181101");
        BizDate pCalckijyuntoymd = BizDate.valueOf("20181121");

        errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanDGanrikin.getDGanrikin(), BizCurrency.valueOf(1100), "配当元利金");
        exBizCalcbleEquals(keisanDGanrikin.getRuigk(), BizCurrency.valueOf(1000), "累計額");
        exNumericEquals(keisanDGanrikin.getHaitouRirituList().size(), 1, "配当利率リストのサイズ");
        exBizCalcbleEquals(keisanDGanrikin.getHaitouRirituList().get(0), BizNumber.valueOf(0.1), "配当利率");
        exDateEquals(keisanDGanrikin.getCalckijyunfromymd(), BizDate.valueOf("20181101"), "計算基準日自");
        exDateEquals(keisanDGanrikin.getCalckijyuntoymd(), BizDate.valueOf("20181121"), "計算基準日至");

    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A7_inData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A7() {

        BizCurrency pRuigk = BizCurrency.valueOf(1000);
        BizDate pCalckijyunfromymd = BizDate.valueOf("20181101");
        BizDate pCalckijyuntoymd = BizDate.valueOf("20181129");

        errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }
}

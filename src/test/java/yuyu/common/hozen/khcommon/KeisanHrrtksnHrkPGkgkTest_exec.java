package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 返戻率計算用払込保険料合計額計算クラスのメソッド {@link KeisanHrrtksnHrkPGkgk#exec()} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanHrrtksnHrkPGkgkTest_exec {

    @Inject
    private KeisanHrrtksnHrkPGkgk keisanHrrtksnHrkPGkgk;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_返戻率計算用払込保険料合計額計算";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanHrrtksnHrkPGkgkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }


    @BeforeClass
    public static void testInit() {

        KeisanIkkatuPGkMock.caller = KeisanHrrtksnHrkPGkgkTest_exec.class;
        KeisanKihrkPMock.caller = KeisanHrrtksnHrkPGkgkTest_exec.class;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @AfterClass
    public static void testClear() {

        KeisanIkkatuPGkMock.caller = null;
        KeisanIkkatuPGkMock.SYORIPTN = null ;

        KeisanKihrkPMock.caller = null;
        KeisanKihrkPMock.SYORIPTN = null ;

    }

    @Test
    @TestOrder(10)
    public void testInputChk_A1() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec(null);
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(20)
    public void testInputChk_A2() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(30)
    public void testKeisanKahiChk_B1() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000011");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(40)
    public void testKykInfoChk_B2() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000022");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(50)
    public void testKykInfoChk_B3() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000033");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");

    }

    @Test
    @TestOrder(60)
    public void testKykInfoChk_B4() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000044");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");

    }

    @Test
    @TestOrder(70)
    public void testKykInfoChk_B5() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000055");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");

    }

    @Test
    @TestOrder(80)
    public void testIkkatuPChk_B6() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000066");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(90)
    public void testKiharaiPChk_B7() {

        MockObjectManager.initialize();
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN2;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000206");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(100)
    public void testDaoChk_C1() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000077");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(3050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(3000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(110)
    public void testDaoChk_C2() {

        MockObjectManager.initialize();
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000088");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(1050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(1000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(120)
    public void testDaoChk_C3() {

        MockObjectManager.initialize();
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000099");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(1050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(1000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(130)
    public void testDaoChk_C4() {

        MockObjectManager.initialize();
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000103");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(1050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(1000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(140)
    public void testDaoChk_D1() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000114");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(3050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(3000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(150)
    public void testDaoChk_D2() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000125");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR ,"結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(160)
    public void testDaoChk_D3() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000136");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR ,"結果区分");
        exBooleanEquals(keisanKahi,false, "計算可否");
        exBizCalcbleEquals(kihrkmP, null,"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, null,"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(170)
    public void testExec_E1() {

        MockObjectManager.initialize();
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000147");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK ,"結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(1120000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(1000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(180)
    public void testExec_E2() {

        MockObjectManager.initialize();
        KeisanIkkatuPGkMock.SYORIPTN = KeisanIkkatuPGkMock.TESTPATTERN1;
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000158");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK ,"結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(1050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(1150000),"払込Ｐ総額（保険期間）");

        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock.class, "exec", 0);
        exStringEquals(pKeisanIkkatuPGkBean.getSyouhnCd(), "ﾕﾁ", "商品コード");
        exNumericEquals(pKeisanIkkatuPGkBean.getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(pKeisanIkkatuPGkBean.getRyouritusdNo(), "L", "料率世代番号");
        exBizCalcbleEquals(pKeisanIkkatuPGkBean.getHokenryou(), BizCurrency.valueOf(10000), "保険料");
        exNumericEquals(pKeisanIkkatuPGkBean.getKeikamon(), 12, "経過月数");
        exClassificationEquals(pKeisanIkkatuPGkBean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(pKeisanIkkatuPGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");

        exBooleanEquals((Boolean)MockObjectManager.getArgument(KeisanIkkatuPGkMock.class, "exec", 1), false, "一括割引不要フラグ");

    }

    @Test
    @TestOrder(190)
    public void testExec_E3() {

        MockObjectManager.initialize();
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000169");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK ,"結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(1000000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(1000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(200)
    public void testExec_E4() {

        MockObjectManager.initialize();
        KeisanIkkatuPGkMock.SYORIPTN = KeisanIkkatuPGkMock.TESTPATTERN1;
        KeisanKihrkPMock.SYORIPTN =KeisanKihrkPMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000170");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK ,"結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(1050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(1150000),"払込Ｐ総額（保険期間）");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKihrkPMock.class, "exec", 0, 0), "60806000170",   "証券番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanKihrkPMock.class, "exec", 0, 1),  C_Tuukasyu.USD, "契約通貨種類");

    }

    @Test
    @TestOrder(210)
    public void testExec_E5() {

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000181");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK ,"結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP, BizCurrency.valueOf(3050000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(3000000),"払込Ｐ総額（保険期間）");

    }

    @Test
    @TestOrder(220)
    public void testExec_E6() {

        MockObjectManager.initialize();
        KeisanIkkatuPGkMock.SYORIPTN = KeisanIkkatuPGkMock.TESTPATTERN1;

        C_ErrorKbn errorKbn = keisanHrrtksnHrkPGkgk.exec("60806000192");
        boolean keisanKahi = keisanHrrtksnHrkPGkgk.getKeisanKahi();
        BizCurrency kihrkmP =keisanHrrtksnHrkPGkgk.getKihrkmP();
        BizCurrency hrkmPSgkHknkkn =keisanHrrtksnHrkPGkgk.getHrkmPSgkHknkkn();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK ,"結果区分");
        exBooleanEquals(keisanKahi,true, "計算可否");
        exBizCalcbleEquals(kihrkmP,BizCurrency.valueOf(35000),"既払込Ｐ");
        exBizCalcbleEquals(hrkmPSgkHknkkn, BizCurrency.valueOf(175000),"払込Ｐ総額（保険期間）");

    }
}

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
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * KeisanIkkatuPGkクラスのメソッド {@link KeisanIkkatuPGk#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanIkkatuPGkTest_exec {

    @Inject
    private KeisanIkkatuPGk keisanIkkatuPGk;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_一括払Ｐ計算";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanIkkatuWaribikiP.class).to(KeisanIkkatuWaribikiPMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanIkkatuWaribikiPMockForKhansyuu.caller = KeisanIkkatuPGkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanIkkatuWaribikiPMockForKhansyuu.caller = null;
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuPGkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllIkkatuKeisuu());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕﾕ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(4000, BizCurrencyTypes.DOLLAR));

        pKeisanIkkatuPGkBean.setKeikamon(0);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);

        boolean pIktwaribikifuyouFlg = true;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括割引料");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        boolean pIktwaribikifuyouFlg = false;


        C_ErrorKbn errorKbn =  keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        String syouhnCd = (String)MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 0);
        exStringEquals(syouhnCd, "ﾕｹ", "商品コード");

        String ryouritusdNo = (String) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 1);
        exStringEquals(ryouritusdNo, "J", "料率世代番号");

        BizNumber yoteiRiritu = (BizNumber) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 2);
        exBizCalcbleEquals(yoteiRiritu, null, "予定利率");

        int keikamon = (int) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 3);
        exNumericEquals(keikamon, 2, "経過月数");

        BizCurrency hokenryou = (BizCurrency) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 4);
        exBizCalcbleEquals(hokenryou, BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "割引前保険料");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括割引料");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000));

        pKeisanIkkatuPGkBean.setKeikamon(13);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        boolean pIktwaribikifuyouFlg = true;


        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(0), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }
    @Test
    @TestOrder(40)
    public void testExec_A4() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR));

        pKeisanIkkatuPGkBean.setKeikamon(12);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        boolean pIktwaribikifuyouFlg = true;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(12000000, BizCurrencyTypes.DOLLAR), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括割引料");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕﾕ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(10000));

        pKeisanIkkatuPGkBean.setKeikamon(1);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(0), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕﾕ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(10000));

        pKeisanIkkatuPGkBean.setKeikamon(1);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(0), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN7;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(0), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ｹﾕ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(2000000), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ｹﾕ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        boolean pIktwaribikifuyouFlg = true;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(2000000), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(95)
    @Transactional
    public void insertTestData2() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuPGkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(10000));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn =  keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(20000), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(105)
    @Transactional
    public void insertTestData3() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuPGkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN11;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(2);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(10000));

        pKeisanIkkatuPGkBean.setKeikamon(12);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        boolean pIktwaribikifuyouFlg = false;


        C_ErrorKbn errorKbn =  keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(120000), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(400), "一括割引料");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN12;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕﾕ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(10000));

        pKeisanIkkatuPGkBean.setKeikamon(12);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        boolean pIktwaribikifuyouFlg = false;


        C_ErrorKbn errorKbn =  keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(119999), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(400), "一括割引料");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN13;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(10000));

        pKeisanIkkatuPGkBean.setKeikamon(12);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn =  keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(119999), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(400), "一括割引料");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN8;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(2);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(2000000), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN7;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.NEN);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(0), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN7;
        KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();

        pKeisanIkkatuPGkBean.setSyouhnCd("ﾕｹ");

        pKeisanIkkatuPGkBean.setSyouhnsdNo(1);

        pKeisanIkkatuPGkBean.setRyouritusdNo("J");

        pKeisanIkkatuPGkBean.setYoteiRiritu(BizNumber.valueOf(0.5));

        pKeisanIkkatuPGkBean.setHokenryou(BizCurrency.valueOf(1000000, BizCurrencyTypes.DOLLAR));

        pKeisanIkkatuPGkBean.setKeikamon(2);

        pKeisanIkkatuPGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);

        pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        pKeisanIkkatuPGkBean.setHhknnen(30);

        pKeisanIkkatuPGkBean.setHhknsei(C_Hhknsei.MALE);

        pKeisanIkkatuPGkBean.setHknkknsmnKbn(C_HknkknsmnKbn.NENMANKI);

        pKeisanIkkatuPGkBean.setHrkkkn(1);

        pKeisanIkkatuPGkBean.setHokenkngk(BizCurrency.valueOf(1000000));

        pKeisanIkkatuPGkBean.setKykTuukasyu(C_Tuukasyu.JPY);

        pKeisanIkkatuPGkBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);

        pKeisanIkkatuPGkBean.setDai1hknkkn(2);

        pKeisanIkkatuPGkBean.setHrkkeiro(C_Hrkkeiro.SYUUDAN);

        boolean pIktwaribikifuyouFlg = false;

        C_ErrorKbn errorKbn = keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean,pIktwaribikifuyouFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanIkkatuPGk.getIkkatuP(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括払保険料");
        exBizCalcbleEquals(keisanIkkatuPGk.getIktwaribikikgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "一括割引料");

        BizCurrency hknRyou = (BizCurrency)MockObjectManager.getArgument(KeisanSP.class, "exec", 0, 11);
        exBizCalcbleEquals(hknRyou, BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "【SP計算】の入力引数_保険料");
    }
}

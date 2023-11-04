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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 源泉徴収額計算クラスのメソッド {@link KeisanKhGensen#exec(String,C_Tuukasyu,C_UmuKbn,BizCurrency,BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanKhGensenTest_exec {

    @Inject
    private KeisanKhGensen keisanKhGensen;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_源泉徴収額計算";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanHtyKeihi.class).to(KeisanHtyKeihiMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanHtyKeihiMockForHozen.caller = KeisanKhGensenTest_exec.class;
        KeisanGaikakanzanMockForHozen.caller = KeisanKhGensenTest_exec.class;

        YuyuBizConfig.getInstance().setKztKeikanensuu(5);
        YuyuBizConfig.getInstance().setGsbunrikzZeirituNationaltax(BizNumber.valueOf(0.15315));
        YuyuBizConfig.getInstance().setGsbunrikzZeirituLocaltax(BizNumber.valueOf(0.05));
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        KeisanHtyKeihiMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanHtyKeihiMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanKhGensenTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;

        String syono = "17806000013";
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.ARI;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(2000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), null, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), null, "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), null, "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), null, "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), null, "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), null, "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), null, "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), null, "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), null, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), null, "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(2000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(2000.65), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(0), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(0), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(0), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(0), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(0), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(2000), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(0), "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(3000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(2000.65), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(999.35), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(202), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(202), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(153), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(49), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(3000), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(0), "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(2000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(2000.65), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(0), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(0), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(0), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(0), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(0), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(2000), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(0), "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;

        String syono = "17806000024";
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.ARI;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(2000.65);
        BizDate calckijyunymd = BizDate.valueOf("20130101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(0), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(0), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(0), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(0), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(0), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(0), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), null, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), null, "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(2000);
        BizDate calckijyunymd = BizDate.valueOf("20080101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(0), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(0), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(0), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(0), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(0), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.ERROR, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), null, "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(2000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(2000.65), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(0), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(0), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(0), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(0), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(2000.65), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), BizDate.valueOf("20111230"), "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(99), "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        String syono = "17806000046";
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(2000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(0), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(0), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(0), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(0), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(0), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(0), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), null, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), null, "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_UmuKbn yenshrtkumu = C_UmuKbn.ARI;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(3000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(2000.65), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(999.35), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(202), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(202), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(153), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(49), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(3000), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(0), "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(3000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(0);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(2000.65), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(999.35), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(2.03, BizCurrencyTypes.DOLLAR), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(202), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(153), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(49), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(3000), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), BizDate.valueOf("20111230"), "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(99), "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;

        String syono = "17806000035";
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency kaiyakuhr = BizCurrency.valueOf(3000);
        BizDate calckijyunymd = BizDate.valueOf("20120101");

        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(2999.99);

        C_ErrorKbn resultKbn = keisanKhGensen.exec(syono, tuukasyu, yenshrtkumu, kaiyakuhr, sonotashrkngkyen, calckijyunymd);

        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), C_UmuKbn.ARI, "源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(2000.65), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(3999.34), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(811), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(811), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(612), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(199), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(3000), "円換算解約返戻金");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(0), "税務用為替レート");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }
}

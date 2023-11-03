package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 源泉徴収額計算クラスのメソッド {@link KeisanKhGensen#execForDTuibarai(C_Tuukasyu,C_UmuKbn,BizCurrency,BizNumber)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanKhGensenTest1_exec {

    @Inject
    private KeisanKhGensen keisanKhGensen;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_源泉徴収額計算";

    private final static String sheetName = "INデータ";

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
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(120)
    public void testExec_B1() {

        keisanKhGensen = SWAKInjector.getInstance(KeisanKhGensen.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.ARI;
        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(999.99);
        BizNumber kawaserate = BizNumber.valueOf(19);

        C_ErrorKbn resultKbn = keisanKhGensen.execForDTuibarai(tuukasyu, yenshrtkumu, sonotashrkngkyen, kawaserate);

        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(999.99), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(202), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(202), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(153), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(49), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(0), "円換算解約返戻金");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), null, "税務用為替レート");
        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), null, "源泉分離課税対象フラグ");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), null, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_B2() {

        keisanKhGensen = SWAKInjector.getInstance(KeisanKhGensen.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_UmuKbn yenshrtkumu = C_UmuKbn.ARI;
        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(1999.99);
        BizNumber kawaserate = BizNumber.valueOf(26);

        C_ErrorKbn resultKbn = keisanKhGensen.execForDTuibarai(tuukasyu, yenshrtkumu, sonotashrkngkyen, kawaserate);

        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(1999.99), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(405), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(405), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(306), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(99), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(0), "円換算解約返戻金");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), null, "税務用為替レート");
        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), null, "源泉分離課税対象フラグ");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), null, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_B3() {

        keisanKhGensen = SWAKInjector.getInstance(KeisanKhGensen.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(2999.99);
        BizNumber kawaserate = BizNumber.valueOf(47);

        C_ErrorKbn resultKbn = keisanKhGensen.execForDTuibarai(tuukasyu, yenshrtkumu, sonotashrkngkyen, kawaserate);

        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(2999.99), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(608), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(608), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(459), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(149), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(0), "円換算解約返戻金");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), null, "税務用為替レート");
        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), null, "源泉分離課税対象フラグ");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), null, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_B4() {

        keisanKhGensen = SWAKInjector.getInstance(KeisanKhGensen.class);

        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        C_UmuKbn yenshrtkumu = C_UmuKbn.NONE;
        BizCurrency sonotashrkngkyen = BizCurrency.valueOf(3999.99);
        BizNumber kawaserate = BizNumber.valueOf(59);

        C_ErrorKbn resultKbn = keisanKhGensen.execForDTuibarai(tuukasyu, yenshrtkumu, sonotashrkngkyen, kawaserate);

        exBizCalcbleEquals(keisanKhGensen.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(keisanKhGensen.getYenKztGk(), BizCurrency.valueOf(3999.99), "円換算課税対象額");
        exBizCalcbleEquals(keisanKhGensen.getGensen(), BizCurrency.valueOf(13.74, BizCurrencyTypes.DOLLAR), "源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGensen(), BizCurrency.valueOf(811), "円換算源泉徴収額");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkKokuz(), BizCurrency.valueOf(612), "円換算源泉徴収額（国税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenGsTszeiGkTihouz(), BizCurrency.valueOf(199), "円換算源泉徴収額（地方税額）");
        exBizCalcbleEquals(keisanKhGensen.getYenW(), BizCurrency.valueOf(0), "円換算解約返戻金");
        exBizCalcbleEquals(keisanKhGensen.getKawaseRate(), BizNumber.valueOf(59), "税務用為替レート");
        exClassificationEquals(keisanKhGensen.getGsBunriTaisyou(), null, "源泉分離課税対象フラグ");
        exClassificationEquals(keisanKhGensen.getRateSyutokuKekkaKbn(), null, "税務用為替レート取得結果");
        exDateEquals(keisanKhGensen.getRatesyutokuYmd(), null, "税務用為替レート取得日");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
    }
}

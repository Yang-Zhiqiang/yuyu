package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

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
 * 前納入金額計算クラスのメソッド {@link KeisanZennouNyuukinGk#execKeisanZennouNyuukinGk(BizDate,BizCurrency,BizDate,
 * BizDateYM,Integer)}テスト用クラスです <br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouNyuukinGkTest_execKeisanZennouNyuukinGk {

    @Inject
    private KeisanZennouNyuukinGk keisanZennouNyuukinGk;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納入金額計算";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanZennouNyuukinGkTest_execKeisanZennouNyuukinGk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllZennouKeikaRiritu());
        bizDomManager.delete(bizDomManager.getAllZennouGenkaRitu());
    }

    @Test
    @TestOrder(10)
    public void testExecKeisanZennouNyuukinGk_A1() {

        BizDate kykYmd = BizDate.valueOf("20180611");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20181010");

        BizDateYM jyutouYm = BizDateYM.valueOf("201910");

        Integer jyutouNensuu = 1;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, null, "前納入金額");

        exBizCalcbleEquals(zennouGenka, null, "前納現価");
    }

    @Test
    @TestOrder(20)
    public void testExecKeisanZennouNyuukinGk_A2() {

        BizDate kykYmd = BizDate.valueOf("20180610");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20181010");

        BizDateYM jyutouYm = BizDateYM.valueOf("201910");

        Integer jyutouNensuu = 1;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, null, "前納入金額");

        exBizCalcbleEquals(zennouGenka, null, "前納現価");
    }

    @Test
    @TestOrder(30)
    public void testExecKeisanZennouNyuukinGk_A3() {

        BizDate kykYmd = BizDate.valueOf("20180609");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20181010");

        BizDateYM jyutouYm = BizDateYM.valueOf("201910");

        Integer jyutouNensuu = 1;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, null, "前納入金額");

        exBizCalcbleEquals(zennouGenka, null, "前納現価");
    }

    @Test
    @TestOrder(40)
    public void testExecKeisanZennouNyuukinGk_A4() {

        BizDate kykYmd = BizDate.valueOf("20180610");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20181226");

        BizDateYM jyutouYm = BizDateYM.valueOf("201901");

        Integer jyutouNensuu = 1;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, null, "前納入金額");

        exBizCalcbleEquals(zennouGenka, null, "前納現価");
    }

    @Test
    @TestOrder(50)
    public void testExecKeisanZennouNyuukinGk_A5() {

        BizDate kykYmd = BizDate.valueOf("20180610");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20181225");

        BizDateYM jyutouYm = BizDateYM.valueOf("201901");

        Integer jyutouNensuu = 1;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, null, "前納入金額");

        exBizCalcbleEquals(zennouGenka, null, "前納現価");
    }

    @Test
    @TestOrder(60)
    public void testExecKeisanZennouNyuukinGk_A6() {

        BizDate kykYmd = BizDate.valueOf("20180610");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20181124");

        BizDateYM jyutouYm = BizDateYM.valueOf("201901");

        Integer jyutouNensuu = 7;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(2787), "前納入金額");

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1778), "前納現価");
    }

    @Test
    @TestOrder(70)
    public void testExecKeisanZennouNyuukinGk_A7() {

        BizDate kykYmd = BizDate.valueOf("20180610");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20181020");

        BizDateYM jyutouYm = BizDateYM.valueOf("201901");

        Integer jyutouNensuu = 7;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(2985), "前納入金額");

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1778), "前納現価");
    }

    @Test
    @TestOrder(80)
    public void testExecKeisanZennouNyuukinGk_A8() {

        BizDate kykYmd = BizDate.valueOf("20180610");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20180920");

        BizDateYM jyutouYm = BizDateYM.valueOf("201901");

        Integer jyutouNensuu = 7;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(3180), "前納入金額");

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1778), "前納現価");
    }

    @Test
    @TestOrder(90)
    public void testExecKeisanZennouNyuukinGk_A9() {

        BizDate kykYmd = BizDate.valueOf("20180610");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        BizDate ryosyuYmd = BizDate.valueOf("20180820");

        BizDateYM jyutouYm = BizDateYM.valueOf("201901");

        Integer jyutouNensuu = 7;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanZennouNyuukinGk(kykYmd, zennouHrkp, ryosyuYmd, jyutouYm,
            jyutouNensuu);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(3360), "前納入金額");

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1778), "前納現価");
    }
}

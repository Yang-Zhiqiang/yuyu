package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
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
 * 前納入金額計算クラスのメソッド {@link KeisanZennouNyuukinGk#execKeisanSinkeiyakuDoujiZennouNyuukinGk(BizDate,BizCurrency,
 * Integer)}テスト用クラスです <br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouNyuukinGkTest_execKeisanSinkeiyakuDoujiZennouNyuukinGk {

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
            testDataAndTblMap = testDataMaker.getInData(
                KeisanZennouNyuukinGkTest_execKeisanSinkeiyakuDoujiZennouNyuukinGk.class,
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
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A1() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 1;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanSinkeiyakuDoujiZennouNyuukinGk(kijyunymd, zennouHrkp,
            zennouKikan);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, null, "前納入金額");

        exBizCalcbleEquals(zennouGenka, null, "前納現価");
    }

    @Test
    @TestOrder(20)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A2() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 3;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanSinkeiyakuDoujiZennouNyuukinGk(kijyunymd, zennouHrkp,
            zennouKikan);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1334), "前納現価");
    }

    @Test
    @TestOrder(30)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A3() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 4;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanSinkeiyakuDoujiZennouNyuukinGk(kijyunymd, zennouHrkp,
            zennouKikan);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1445), "前納現価");
    }

    @Test
    @TestOrder(40)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A4() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 5;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanSinkeiyakuDoujiZennouNyuukinGk(kijyunymd, zennouHrkp,
            zennouKikan);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1556), "前納現価");
    }

    @Test
    @TestOrder(50)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A5() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 6;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanSinkeiyakuDoujiZennouNyuukinGk(kijyunymd, zennouHrkp,
            zennouKikan);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1667), "前納現価");
    }

    @Test
    @TestOrder(60)
    public void testExecKeisanSinkeiyakuDoujiZennouNyuukinGk_A6() {

        BizDate kijyunymd = BizDate.valueOf("20181010");

        BizCurrency zennouHrkp = BizCurrency.valueOf(100);

        Integer zennouKikan = 7;

        C_ErrorKbn errorKbn = keisanZennouNyuukinGk.execKeisanSinkeiyakuDoujiZennouNyuukinGk(kijyunymd, zennouHrkp,
            zennouKikan);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        BizCurrency zennouNyuukin = keisanZennouNyuukinGk.getZennouNyuukinGk();

        BizCurrency zennouGenka = keisanZennouNyuukinGk.getZennouGenka();

        exBizCalcbleEquals(zennouNyuukin, BizCurrency.valueOf(1878), "前納入金額");

        exBizCalcbleEquals(zennouGenka, BizCurrency.valueOf(1778), "前納現価");
    }
}

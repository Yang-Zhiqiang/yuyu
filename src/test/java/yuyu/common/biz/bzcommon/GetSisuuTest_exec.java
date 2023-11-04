package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 指数取得クラスのメソッド {@link GetSisuu#exec(C_Sisuukbn, C_YouhiKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSisuuTest_exec extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_指数取得";
    private final static String sheetName = "INデータ";
    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(GetSisuuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector
            .getInstance(ExDBEntityManager.class);

        String jpql = "delete from " + "BM_Sisuu";
        em.createJPQL(jpql).executeUpdate();

        testDataAndTblMap = null;
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(null, BizDate.valueOf(2018102), C_YouhiKbn.YOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), null, "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(0), "メンバ変数．指数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(null, null, C_YouhiKbn.YOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), null, "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(0), "メンバ変数．指数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(C_Sisuukbn.BLCON2, null, C_YouhiKbn.YOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), null, "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(0), "メンバ変数．指数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(C_Sisuukbn.BLCON2, BizDate.valueOf(20180319), C_YouhiKbn.YOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), null, "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(0), "メンバ変数．指数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(C_Sisuukbn.BLCON2, BizDate.valueOf(20180322), C_YouhiKbn.YOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), BizDate.valueOf(20180322), "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(102.1234), "メンバ変数．指数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(C_Sisuukbn.BLCON1, BizDate.valueOf(20180328), C_YouhiKbn.HUYOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), null, "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(0), "メンバ変数．指数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(C_Sisuukbn.BLCON1, BizDate.valueOf(20180325), C_YouhiKbn.HUYOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), BizDate.valueOf(20180325), "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(12345.12345), "メンバ変数．指数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(C_Sisuukbn.BLCON2, BizDate.valueOf(20180321), C_YouhiKbn.HUYOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), BizDate.valueOf(20180321), "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(101.1234), "メンバ変数．指数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_ErrorKbn errorKbn = getSisuu.exec(C_Sisuukbn.BLCON2, BizDate.valueOf(20180327), C_YouhiKbn.YOU);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exDateEquals(getSisuu.getSisuushutokuymd(), BizDate.valueOf(20180324), "メンバ変数．指数取得日");
        exBizCalcbleEquals(getSisuu.getSisuu(), BizNumber.valueOf(123.4567), "メンバ変数．指数");
    }
}

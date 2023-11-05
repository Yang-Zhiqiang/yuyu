package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

/**
 * 前納精算額計算２クラスのメソッド {@link KeisanZennouSeisanGk2#exec(BizDate, BizDate, BizCurrency, BizDate, BizDate, BizCurrency)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGk2Test_exec {

    @Inject
    private KeisanZennouSeisanGk2 keisanZennouSeisanGk2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納精算額計算２";

    private final static String sheetName = "INデータ";

    @Before
    public void before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(GetZennouKikanRiritu2.class).to(GetZennouKikanRiritu2MockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        GetZennouKikanRiritu2MockForKhansyuu.caller = KeisanZennouSeisanGk2Test_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.caller = null;
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanZennouSeisanGk2Test_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllZennouRiritu2());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20190109);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20170203);
        BizDate ryosyuymd =  BizDate.valueOf(20170204);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201602"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 0, "件数");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20190109);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20170204);
        BizDate ryosyuymd =  BizDate.valueOf(20170204);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201602"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 0, "件数");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20170203);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        BizDate zennouStartYmd = BizDate.valueOf(20180203);
        BizDate ryosyuymd =  BizDate.valueOf(20170204);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 0, "件数");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(2000), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf("20170203"), "前納精算基準日");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20170201);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20180131);
        BizDate ryosyuymd =  BizDate.valueOf(20170201);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201701"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 0, "件数");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), null, "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), null, "前納精算基準日");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN1;

        BizDate zennouseisankijyunymd = BizDate.valueOf(20170205);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20180203);
        BizDate ryosyuymd =  BizDate.valueOf(20170204);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 0, "件数");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), null, "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), null, "前納精算基準日");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20190109);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20180302);
        BizDate ryosyuymd =  BizDate.valueOf(20170214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201703"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 0, "件数");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), null, "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), null, "前納精算基準日");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN2;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20190109);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20170329);
        BizDate ryosyuymd =  BizDate.valueOf(20170214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201703"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 1, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20200918), "前納積立率変更日[0]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 1, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20170301), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(4000), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(5000), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(2131), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(3131), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), null, "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), null, "前納精算基準日");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN4;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20190109);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20180129);
        BizDate ryosyuymd =  BizDate.valueOf(20170214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201804"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 2, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20200707), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20200101), "前納積立率変更日[1]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 1, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20180401), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(13446), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14446), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(13446), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14446), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(81909), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20190109), "前納精算基準日");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN3;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20190109);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20180228);
        BizDate ryosyuymd =  BizDate.valueOf(20170214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201804"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 2, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20201001), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20200101), "前納積立率変更日[1]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 1, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20180401), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(14578), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(15578), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(14578), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(15578), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(88805), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20190109), "前納精算基準日");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN14;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20190109);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20170228);
        BizDate ryosyuymd =  BizDate.valueOf(20170214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201804"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 2, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20201001), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20200101), "前納積立率変更日[1]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20170201), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(3800), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(4800), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(1000), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(2000), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20180401), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(8500), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(9500), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(6789), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(7789), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), null, "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), null, "前納精算基準日");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN17;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20180130);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20160129);
        BizDate ryosyuymd =  BizDate.valueOf(20150214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201704"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 3, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20200707), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20200101), "前納積立率変更日[1]");
        exDateEquals(bizDateList.get(2), BizDate.valueOf(20200505), "前納積立率変更日[2]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20160101), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(13446), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14446), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(13446), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14446), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20170401), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(103730), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(104730), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(103730), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(104730), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(690582), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20180130), "前納精算基準日");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 0, 1), BizDate.valueOf(20150214 ), "期間自");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 0, 2), BizDate.valueOf(20160129 ), "期間至");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 0, 3), BizDate.valueOf(20180401), "契約日");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 1, 1), BizDate.valueOf(20160101 ), "期間自");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 1, 2), BizDate.valueOf(20170101 ), "期間至");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 1, 3), BizDate.valueOf(20180401), "契約日");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 2, 1), BizDate.valueOf(20170401), "期間自");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 2, 2), BizDate.valueOf(20180130), "期間至");
        exDateEquals((BizDate)MockObjectManager.getArgument(GetZennouKikanRiritu2MockForKhansyuu.class, "exec", 2, 3), BizDate.valueOf(20180401), "契約日");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN18;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20140129);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20140129);
        BizDate ryosyuymd =  BizDate.valueOf(20130214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201304"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 2, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20200707), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20200101), "前納積立率変更日[1]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 1, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20130401), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(13446), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14446), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(13446), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14446), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(89516), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20140129), "前納精算基準日");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN19;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20180401);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20180129);
        BizDate ryosyuymd =  BizDate.valueOf(20170214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201804"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 1, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20200707), "前納積立率変更日[0]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 1, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20180401), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(13446), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14446), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(13446), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14446), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(13446), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20180401), "前納精算基準日");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN4;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20180104);
        BizDate pKykymd = BizDate.valueOf(20180401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf(20180105);
        BizDate ryosyuymd =  BizDate.valueOf(20170214);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201701"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 1, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20200707), "前納積立率変更日[0]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(14446), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20180104), "前納精算基準日");
    }

    @Test
    @TestOrder(300)
    public void testExec_B1() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN20;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20170324);
        BizDate pKykymd = BizDate.valueOf(20170401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(100);
        BizDate zennouStartYmd = BizDate.valueOf(20170401);
        BizDate ryosyuymd =  BizDate.valueOf(20160323);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2500);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "3", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 1, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20200707), "前納積立率変更日[0]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(2557), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20170324), "前納精算基準日");
    }

    @Test
    @TestOrder(310)
    public void testExec_B2() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN5;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20180109);
        BizDate pKykymd = BizDate.valueOf(20170410);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(200);
        BizDate zennouStartYmd = BizDate.valueOf(20180110);
        BizDate ryosyuymd =  BizDate.valueOf(20170126);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(1000000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201701"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 1, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(1026583), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20180109), "前納精算基準日");
    }

    @Test
    @TestOrder(320)
    public void testExec_B3() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN6;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20170317);
        BizDate pKykymd = BizDate.valueOf(20160401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(200);
        BizDate zennouStartYmd = BizDate.valueOf(20150901);
        BizDate ryosyuymd =  BizDate.valueOf(20150814);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(14000000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "3", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 3, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180102), "前納積立率変更日[1]");
        exDateEquals(bizDateList.get(2), BizDate.valueOf(20180103), "前納積立率変更日[2]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20150901), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(14013800), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14014000), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(14000966), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14001166), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20160401), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(14014766), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14014966), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(14014766), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14014966), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(14028780), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20170317), "前納精算基準日");
    }

    @Test
    @TestOrder(330)
    public void testExec_B4() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN7;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20180207);
        BizDate pKykymd = BizDate.valueOf(20170223);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(10003);
        BizDate zennouStartYmd = BizDate.valueOf(20171023);
        BizDate ryosyuymd =  BizDate.valueOf(20161109);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(100000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 2, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 1, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20170223), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(92197), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(102200), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(90638), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(100641), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(93633), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20180207), "前納精算基準日");
    }

    @Test
    @TestOrder(340)
    public void testExec_B5() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN8;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20171115);
        BizDate pKykymd = BizDate.valueOf(20131001);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1);
        BizDate zennouStartYmd = BizDate.valueOf(20140201);
        BizDate ryosyuymd =  BizDate.valueOf(20131201);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(5000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201710"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 5, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        exDateEquals(bizDateList.get(2), BizDate.valueOf(20180101), "前納積立率変更日[2]");
        exDateEquals(bizDateList.get(3), BizDate.valueOf(20180101), "前納積立率変更日[3]");
        exDateEquals(bizDateList.get(4), BizDate.valueOf(20180101), "前納積立率変更日[4]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 4, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20140201), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(5499), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(5500), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(5499), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(5500), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20150201), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(8797), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(8798), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(8797), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(8798), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(2).getKykOutoubi(), BizDate.valueOf(20160201), "契約応当日");
        exBizCalcbleEquals(beanList.get(2).getZennouZndk(), BizCurrency.valueOf(14074), "前納残高");
        exBizCalcbleEquals(beanList.get(2).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14075), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(2).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(14074), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(2).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14075), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(3).getKykOutoubi(), BizDate.valueOf(20171001), "契約応当日");
        exBizCalcbleEquals(beanList.get(3).getZennouZndk(), BizCurrency.valueOf(22531), "前納残高");
        exBizCalcbleEquals(beanList.get(3).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(22532), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(3).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(22517), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(3).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(22518), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(23642), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20171115), "前納精算基準日");
    }

    @Test
    @TestOrder(350)
    public void testExec_B6() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN9;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20180109);
        BizDate pKykymd = BizDate.valueOf(20170409);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(100);
        BizDate zennouStartYmd = BizDate.valueOf(20180109);
        BizDate ryosyuymd =  BizDate.valueOf(20170809);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(87293);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201704"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 2, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 1, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20170409), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(88211), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(88311), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(87193), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(87293), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(88343), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20180109), "前納精算基準日");
    }

    @Test
    @TestOrder(360)
    public void testExec_B7() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN10;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20180510);
        BizDate pKykymd = BizDate.valueOf(20160509);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(1);
        BizDate zennouStartYmd = BizDate.valueOf(20170509);
        BizDate ryosyuymd =  BizDate.valueOf(20170409);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(440);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201805"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 2, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20170509), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(440), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(441), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(439), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(440), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20180509), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(443), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(444), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(441), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(442), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(443), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20180510), "前納精算基準日");
    }

    @Test
    @TestOrder(370)
    public void testExec_B8() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN11;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20170510);
        BizDate pKykymd = BizDate.valueOf(20160309);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(10);
        BizDate zennouStartYmd = BizDate.valueOf(20160509);
        BizDate ryosyuymd =  BizDate.valueOf(20160505);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(-100);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201703"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "3", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 3, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        exDateEquals(bizDateList.get(2), BizDate.valueOf(20180101), "前納積立率変更日[2]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20160509), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(0), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(0), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(0), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(0), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20170309), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(0), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(0), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(0), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(0), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(0), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20170510), "前納精算基準日");
    }

    @Test
    @TestOrder(380)
    public void testExec_B9() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN12;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20171023);
        BizDate pKykymd = BizDate.valueOf(20170223);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(10003);
        BizDate zennouStartYmd = BizDate.valueOf(20180207);
        BizDate ryosyuymd =  BizDate.valueOf(20161109);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(100000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 1, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 0, "件数");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(102200), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20171023), "前納精算基準日");
    }

    @Test
    @TestOrder(390)
    public void testExec_B10() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN15;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20170317);
        BizDate pKykymd = BizDate.valueOf(20160401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(200);
        BizDate zennouStartYmd = BizDate.valueOf(20150901);
        BizDate ryosyuymd =  BizDate.valueOf(20150813);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(14000000);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 3, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        exDateEquals(bizDateList.get(2), BizDate.valueOf(20180101), "前納積立率変更日[2]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20150901), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(14233133), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14233333), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(14233133), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14233333), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20160401), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(17079559), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(17079759), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(17079559), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(17079759), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(20495470), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20170317), "前納精算基準日");
    }

    @Test
    @TestOrder(400)
    public void testExec_B11() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN13;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20170317);
        BizDate pKykymd = BizDate.valueOf(20160401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR);
        BizDate zennouStartYmd = BizDate.valueOf(20150901);
        BizDate ryosyuymd =  BizDate.valueOf(20150815);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 3, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        exDateEquals(bizDateList.get(2), BizDate.valueOf(20180101), "前納積立率変更日[2]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20150901), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(120, BizCurrencyTypes.DOLLAR), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20160401), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20170317), "前納精算基準日");
    }

    @Test
    @TestOrder(410)
    public void testExec_B12() {

        MockObjectManager.initialize();
        GetZennouKikanRiritu2MockForKhansyuu.SYORIPTN = GetZennouKikanRiritu2MockForKhansyuu.TESTPATTERN16;
        BizDate zennouseisankijyunymd = BizDate.valueOf(20201127);
        BizDate pKykymd = BizDate.valueOf(20160401);
        BizCurrency zennoujihrkp = BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR);
        BizDate zennouStartYmd = BizDate.valueOf(20191127);
        BizDate ryosyuymd =  BizDate.valueOf(20191026);
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(14000000, BizCurrencyTypes.DOLLAR);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, pKykymd, zennoujihrkp, zennouStartYmd, ryosyuymd, zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk2.getLastPJyuutouYm(), BizDateYM.valueOf("202004"), "最終Ｐ充当年月");
        exStringEquals(keisanZennouSeisanGk2.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        List<BizDate> bizDateList = keisanZennouSeisanGk2.getZennouTmttrituHnkbiList();
        exNumericEquals(bizDateList.size(), 3, "件数");
        exDateEquals(bizDateList.get(0), BizDate.valueOf(20180101), "前納積立率変更日[0]");
        exDateEquals(bizDateList.get(1), BizDate.valueOf(20180101), "前納積立率変更日[1]");
        exDateEquals(bizDateList.get(2), BizDate.valueOf(20180101), "前納積立率変更日[2]");
        List<KykOutoubiZennouZndkBean> beanList = keisanZennouSeisanGk2.getKykOutoubiZennouZndkList();
        exNumericEquals(beanList.size(), 2, "件数");
        exDateEquals(beanList.get(0).getKykOutoubi(), BizDate.valueOf(20191101), "契約応当日");
        exBizCalcbleEquals(beanList.get(0).getZennouZndk(), BizCurrency.valueOf(14013800, BizCurrencyTypes.DOLLAR), "前納残高");
        exBizCalcbleEquals(beanList.get(0).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14014000, BizCurrencyTypes.DOLLAR), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(14000966.66, BizCurrencyTypes.DOLLAR), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(0).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14001166.66, BizCurrencyTypes.DOLLAR), "前納利率適用充当前前納残高");
        exDateEquals(beanList.get(1).getKykOutoubi(), BizDate.valueOf(20200401), "契約応当日");
        exBizCalcbleEquals(beanList.get(1).getZennouZndk(), BizCurrency.valueOf(14014767.62, BizCurrencyTypes.DOLLAR), "前納残高");
        exBizCalcbleEquals(beanList.get(1).getJyuutoumaeZennouZndk(), BizCurrency.valueOf(14014967.62, BizCurrencyTypes.DOLLAR), "充当前前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyZnnuzndk(), BizCurrency.valueOf(14014767.62, BizCurrencyTypes.DOLLAR), "前納利率適用前納残高");
        exBizCalcbleEquals(beanList.get(1).getZnnurrttkyjytmaeZnnuzndk(), BizCurrency.valueOf(14014967.62, BizCurrencyTypes.DOLLAR), "前納利率適用充当前前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk2.getZennouSeisanGk(), BizCurrency.valueOf(14028782.38, BizCurrencyTypes.DOLLAR), "前納精算額");
        exDateEquals(keisanZennouSeisanGk2.getZennouSeisanKijyunYmd(), BizDate.valueOf(20201127), "前納精算基準日");
    }
}

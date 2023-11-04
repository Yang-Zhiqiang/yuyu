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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_ZennouSyoriKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 前納精算額計算クラスのメソッド {@link KeisanZennouSeisanGk#exec(BizDate, String, String, BizDate, BizCurrency, BizDateYM,
 * BizDate, BizCurrency, C_ZennouSyoriKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGkTest_exec {

    @Inject
    private KeisanZennouSeisanGk keisanZennouSeisanGk;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納精算額計算";
    private final static String sheetName = "INデータ_20170609";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetZennouKikanRiritu.class).to(GetZennouKikanRirituMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        GetZennouKikanRirituMockForKhansyuu.caller = KeisanZennouSeisanGkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        GetZennouKikanRirituMockForKhansyuu.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanZennouSeisanGkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllZennouRiritu());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate calckijyunymd = BizDate.valueOf("20190109");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20170203");
        BizDate ryosyuymd = BizDate.valueOf("20170204");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate calckijyunymd = BizDate.valueOf("20190109");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20170204");
        BizDate ryosyuymd = BizDate.valueOf("20170204");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate calckijyunymd = BizDate.valueOf("20160204");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20170205");
        BizDate ryosyuymd = BizDate.valueOf("20170204");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(2000), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20160204"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201602"), "最終Ｐ充当年月");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate calckijyunymd = BizDate.valueOf("20170203");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180203");
        BizDate ryosyuymd = BizDate.valueOf("20170204");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(2000), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20170203"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "9", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate calckijyunymd = BizDate.valueOf("20170201");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180131");
        BizDate ryosyuymd = BizDate.valueOf("20170201");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN1;
        BizDate calckijyunymd = BizDate.valueOf("20170205");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180203");
        BizDate ryosyuymd = BizDate.valueOf("20170204");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate calckijyunymd = BizDate.valueOf("20190109");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180302");
        BizDate ryosyuymd = BizDate.valueOf("20170214");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201703"), "最終Ｐ充当年月");
    }

    @Test
    @TestOrder(71)
    public void testExec_A8() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN2;
        BizDate calckijyunymd = BizDate.valueOf("20200109");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180129");
        BizDate ryosyuymd = BizDate.valueOf("20170214");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201801"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
    }

    @Test
    @TestOrder(72)
    public void testExec_A9() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN3;
        BizDate calckijyunymd = BizDate.valueOf("20200109");
        BizDate kykymd = BizDate.valueOf("20190401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180228");
        BizDate ryosyuymd = BizDate.valueOf("20170214");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        BizDate from = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 0, 0);
        exDateEquals(from, BizDate.valueOf(20170204), "期間自");
        BizDate to = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 0, 1);
        exDateEquals(to, BizDate.valueOf(20170205), "期間至");
        BizDate date = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 0, 2);
        exDateEquals(date, BizDate.valueOf(20180401), "契約日");
        BizDate from1 = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 1, 0);
        exDateEquals(from1, BizDate.valueOf(20170214), "期間自");
        BizDate to1 = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 1, 1);
        exDateEquals(to1, BizDate.valueOf(20180129), "期間至");
        BizDate date1 = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 1, 2);
        exDateEquals(date1, BizDate.valueOf(20180401), "契約日");
        BizDate from2 = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 2, 0);
        exDateEquals(from2, BizDate.valueOf(20180101), "期間自");
        BizDate to2 = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 2, 1);
        exDateEquals(to2, BizDate.valueOf(20190101), "期間至");
        BizDate date2 = (BizDate) MockObjectManager.getArgument(GetZennouKikanRirituMockForKhansyuu.class, "exec", 2, 2);
        exDateEquals(date2, BizDate.valueOf(20180401), "契約日");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201904"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
    }

    @Test
    @TestOrder(73)
    public void testExec_A10() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN4;

        BizDate calckijyunymd = BizDate.valueOf("20200130");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180129");
        BizDate ryosyuymd = BizDate.valueOf("20170214");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(8554), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20200130"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201904"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(2), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[2]");
    }

    @Test
    @TestOrder(74)
    public void testExec_A11() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN4;
        BizDate calckijyunymd = BizDate.valueOf("20211029");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20211029");
        BizDate ryosyuymd = BizDate.valueOf("20210214");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(1070), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20211029"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("202104"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
    }

    @Test
    @TestOrder(75)
    public void testExec_A12() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN5;
        BizDate calckijyunymd = BizDate.valueOf("20190128");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180129");
        BizDate ryosyuymd = BizDate.valueOf("20170214");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(5193), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20190128"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201804"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
    }

    @Test
    @TestOrder(76)
    public void testExec_A13() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN6;
        BizDate calckijyunymd = BizDate.valueOf("20180104");
        BizDate kykymd = BizDate.valueOf("20180401");
        BizCurrency hrkp = BizCurrency.valueOf(1000);
        BizDate zennouStartYmd = BizDate.valueOf("20180105");
        BizDate ryosyuymd = BizDate.valueOf("20170214");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(3833), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20180104"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201701"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
    }

    @Test
    @TestOrder(110)
    public void testExec_B1() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN6;
        BizDate calckijyunymd = BizDate.valueOf("20170324");
        BizDate kykymd = BizDate.valueOf("20170401");
        BizCurrency hrkp = BizCurrency.valueOf(100);
        BizDate zennouStartYmd = BizDate.valueOf("20170401");
        BizDate ryosyuymd = BizDate.valueOf("20160323");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(2500);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(2557), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20170324"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "3", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
    }

    @Test
    @TestOrder(120)
    public void testExec_B2() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN7;
        BizDate calckijyunymd = BizDate.valueOf("20180109");
        BizDate kykymd = BizDate.valueOf("20170410");
        BizCurrency hrkp = BizCurrency.valueOf(200);
        BizDate zennouStartYmd = BizDate.valueOf("20180110");
        BizDate ryosyuymd = BizDate.valueOf("20170126");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(1000000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(1026583), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20180109"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201701"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 0, "契約応当日前納残高リスト件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_B3() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN8;
        BizDate calckijyunymd = BizDate.valueOf("20170317");
        BizDate kykymd = BizDate.valueOf("20160401");
        BizCurrency hrkp = BizCurrency.valueOf(200);
        BizDate zennouStartYmd = BizDate.valueOf("20150901");
        BizDate ryosyuymd = BizDate.valueOf("20150814");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(14000000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(14028780), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20170317"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "3", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(2), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[2]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 2, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20150901"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(14013800),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(14014000),
            "契約応当日前納残高リスト[0].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getKykOutoubi(), BizDate.valueOf("20160401"),
            "契約応当日前納残高リスト[1].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),BizCurrency.valueOf(14014766),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(14014966),
            "契約応当日前納残高リスト[1].充当前前納残高");
    }

    @Test
    @TestOrder(140)
    public void testExec_B4() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN9;
        BizDate calckijyunymd = BizDate.valueOf("20180207");
        BizDate kykymd = BizDate.valueOf("20170223");
        BizCurrency hrkp = BizCurrency.valueOf(10003);
        BizDate zennouStartYmd = BizDate.valueOf("20171023");
        BizDate ryosyuymd = BizDate.valueOf("20161109");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(100000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(93633), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20180207"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 1, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20170223"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(92197),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(102200),
            "契約応当日前納残高リスト[0].充当前前納残高");
    }

    @Test
    @TestOrder(150)
    public void testExec_B5() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN10;
        BizDate calckijyunymd = BizDate.valueOf("20171115");
        BizDate kykymd = BizDate.valueOf("20131001");
        BizCurrency hrkp = BizCurrency.valueOf(1);
        BizDate zennouStartYmd = BizDate.valueOf("20140201");
        BizDate ryosyuymd = BizDate.valueOf("20131201");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(5000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(23642), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20171115"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201710"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(2), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[2]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(3), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[3]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(4), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[4]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 4, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20140201"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(5499),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(5500),
            "契約応当日前納残高リスト[0].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getKykOutoubi(), BizDate.valueOf("20150201"),
            "契約応当日前納残高リスト[1].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),BizCurrency.valueOf(8797),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(8798),
            "契約応当日前納残高リスト[1].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(2).getKykOutoubi(), BizDate.valueOf("20160201"),
            "契約応当日前納残高リスト[2].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(2).getZennouZndk(),BizCurrency.valueOf(14074),
            "契約応当日前納残高リスト[2].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(2).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(14075),
            "契約応当日前納残高リスト[2].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(3).getKykOutoubi(), BizDate.valueOf("20171001"),
            "契約応当日前納残高リスト[3].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(3).getZennouZndk(),BizCurrency.valueOf(22531),
            "契約応当日前納残高リスト[3].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(3).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(22532),
            "契約応当日前納残高リスト[3].充当前前納残高");
    }

    @Test
    @TestOrder(160)
    public void testExec_B6() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN11;
        BizDate calckijyunymd = BizDate.valueOf("20180109");
        BizDate kykymd = BizDate.valueOf("20170409");
        BizCurrency hrkp = BizCurrency.valueOf(100);
        BizDate zennouStartYmd = BizDate.valueOf("20180109");
        BizDate ryosyuymd = BizDate.valueOf("20170809");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(87293);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(88343), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20180109"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201704"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 1, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20170409"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(88211),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(88311),
            "契約応当日前納残高リスト[0].充当前前納残高");
    }

    @Test
    @TestOrder(170)
    public void testExec_B7() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN13;
        BizDate calckijyunymd = BizDate.valueOf("20180510");
        BizDate kykymd = BizDate.valueOf("20160509");
        BizCurrency hrkp = BizCurrency.valueOf(1);
        BizDate zennouStartYmd = BizDate.valueOf("20170509");
        BizDate ryosyuymd = BizDate.valueOf("20170409");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(440);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(443), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20180510"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201805"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 2, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20170509"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(440),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(441),
            "契約応当日前納残高リスト[0].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getKykOutoubi(), BizDate.valueOf("20180509"),
            "契約応当日前納残高リスト[1].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),BizCurrency.valueOf(443),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(444),
            "契約応当日前納残高リスト[1].充当前前納残高");
    }

    @Test
    @TestOrder(180)
    public void testExec_B8() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN14;
        BizDate calckijyunymd = BizDate.valueOf("20170510");
        BizDate kykymd = BizDate.valueOf("20160309");
        BizCurrency hrkp = BizCurrency.valueOf(10);
        BizDate zennouStartYmd = BizDate.valueOf("20170509");
        BizDate ryosyuymd = BizDate.valueOf("20170505");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(-100);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(0), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20170510"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "3", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201703"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 1, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20170309"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(0),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(0),
            "契約応当日前納残高リスト[0].充当前前納残高");
    }

    @Test
    @TestOrder(190)
    public void testExec_B9() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN15;
        BizDate calckijyunymd = BizDate.valueOf("20171023");
        BizDate kykymd = BizDate.valueOf("20170223");
        BizCurrency hrkp = BizCurrency.valueOf(10003);
        BizDate zennouStartYmd = BizDate.valueOf("20180207");
        BizDate ryosyuymd = BizDate.valueOf("20161109");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(100000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(102200), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20171023"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201702"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 0, "契約応当日前納残高リスト件数");
    }

    @Test
    @TestOrder(1100)
    public void testExec_B10() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN16;
        BizDate calckijyunymd = BizDate.valueOf("20170317");
        BizDate kykymd = BizDate.valueOf("20160401");
        BizCurrency hrkp = BizCurrency.valueOf(200);
        BizDate zennouStartYmd = BizDate.valueOf("20150901");
        BizDate ryosyuymd = BizDate.valueOf("20150813");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(14000000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(20495470), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20170317"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(2), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[2]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 2, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20150901"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(14233133),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(14233333),
            "契約応当日前納残高リスト[0].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getKykOutoubi(), BizDate.valueOf("20160401"),
            "契約応当日前納残高リスト[1].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),BizCurrency.valueOf(17079559),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(17079759),
            "契約応当日前納残高リスト[1].充当前前納残高");
    }

    @Test
    @TestOrder(1110)
    public void testExec_B11() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN17;
        BizDate calckijyunymd = BizDate.valueOf("20170317");
        BizDate kykymd = BizDate.valueOf("20160401");
        BizCurrency hrkp = BizCurrency.valueOf(200);
        BizDate zennouStartYmd = BizDate.valueOf("20150901");
        BizDate ryosyuymd = BizDate.valueOf("20150815");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(14000000);
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(20159520), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20170317"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "2", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("201604"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(2), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[2]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 2, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20150901"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(16799800),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(16800000),
            "契約応当日前納残高リスト[0].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getKykOutoubi(), BizDate.valueOf("20160401"),
            "契約応当日前納残高リスト[1].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),BizCurrency.valueOf(16799600),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(16799800),
            "契約応当日前納残高リスト[1].充当前前納残高");
    }

    @Test
    @TestOrder(1120)
    public void testExec_B12() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN14;
        BizDate calckijyunymd = BizDate.valueOf("20240501");
        BizDate kykymd = BizDate.valueOf("20190501");
        BizCurrency hrkp = BizCurrency.valueOf(11964000);
        BizDate zennouStartYmd = BizDate.valueOf("20200501");
        BizDate ryosyuymd = BizDate.valueOf("20190501");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(107352972);

        KeisanZennouSeisanGk kzsg1 = SWAKInjector.getInstance(KeisanZennouSeisanGk.class);
        kzsg1.exec(BizDate.valueOf("20200501"), kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        KeisanZennouSeisanGk kzsg2 = SWAKInjector.getInstance(KeisanZennouSeisanGk.class);
        kzsg2.exec(BizDate.valueOf("20210501"), kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        KeisanZennouSeisanGk kzsg3 = SWAKInjector.getInstance(KeisanZennouSeisanGk.class);
        kzsg3.exec(BizDate.valueOf("20220501"), kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);
        KeisanZennouSeisanGk kzsg4 = SWAKInjector.getInstance(KeisanZennouSeisanGk.class);
        kzsg4.exec(BizDate.valueOf("20230501"), kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(47783588), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20240501"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "1", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("202405"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(2), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[2]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(3), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[3]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(4), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[4]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 5, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20200501"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(95453383),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),kzsg1.getZennouSeisanGk(),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(107417383),
            "契約応当日前納残高リスト[0].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getKykOutoubi(), BizDate.valueOf("20210501"),
            "契約応当日前納残高リスト[1].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),BizCurrency.valueOf(83546655),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),kzsg2.getZennouSeisanGk(),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(95510655),
            "契約応当日前納残高リスト[1].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(2).getKykOutoubi(), BizDate.valueOf("20220501"),
            "契約応当日前納残高リスト[2].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(2).getZennouZndk(),BizCurrency.valueOf(71632782),
            "契約応当日前納残高リスト[2].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(2).getZennouZndk(),kzsg3.getZennouSeisanGk(),
            "契約応当日前納残高リスト[2].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(2).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(83596782),
            "契約応当日前納残高リスト[2].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(3).getKykOutoubi(), BizDate.valueOf("20230501"),
            "契約応当日前納残高リスト[3].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(3).getZennouZndk(),BizCurrency.valueOf(59711761),
            "契約応当日前納残高リスト[3].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(3).getZennouZndk(),kzsg4.getZennouSeisanGk(),
            "契約応当日前納残高リスト[3].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(3).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(71675761),
            "契約応当日前納残高リスト[3].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(4).getKykOutoubi(), BizDate.valueOf("20240501"),
            "契約応当日前納残高リスト[4].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(4).getZennouZndk(),keisanZennouSeisanGk.getZennouSeisanGk(),
            "契約応当日前納残高リスト[4].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(4).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(59747588),
            "契約応当日前納残高リスト[4].充当前前納残高");
    }

    @Test
    @TestOrder(1130)
    public void testExec_B13() {

        GetZennouKikanRirituMockForKhansyuu.index = 0;
        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN14;
        BizDate calckijyunymd = BizDate.valueOf("20210501");
        BizDate kykymd = BizDate.valueOf("20190501");
        BizCurrency hrkp = BizCurrency.valueOf(0);
        BizDate zennouStartYmd = BizDate.valueOf("20200501");
        BizDate ryosyuymd = BizDate.valueOf("20190501");
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(-1);

        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, kykymd, hrkp, zennouStartYmd, ryosyuymd,
            zennounyuukinkgk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanZennouSeisanGk.getZennouSeisanGk(), BizCurrency.valueOf(0), "前納精算額");
        exDateEquals(keisanZennouSeisanGk.getZennouSeisanKijyunYmd(), BizDate.valueOf("20210501"), "前納精算基準日");
        exStringEquals(keisanZennouSeisanGk.getTkyTmttZndkHikakuKbn(), "3", "適用積立残高区分");
        exDateYMEquals(keisanZennouSeisanGk.getLastPJyuutouYm(), BizDateYM.valueOf("202105"), "最終Ｐ充当年月");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(0), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[0]");
        exDateEquals(keisanZennouSeisanGk.getZennouTmttrituHnkbiList().get(1), BizDate.valueOf("20180101"),
            "前納積立率変更日リスト[1]");
        exNumericEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().size(), 2, "契約応当日前納残高リスト件数");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getKykOutoubi(), BizDate.valueOf("20200501"),
            "契約応当日前納残高リスト[0].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getZennouZndk(),BizCurrency.valueOf(0),
            "契約応当日前納残高リスト[0].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(0).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(0),
            "契約応当日前納残高リスト[0].充当前前納残高");
        exDateEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getKykOutoubi(), BizDate.valueOf("20210501"),
            "契約応当日前納残高リスト[1].契約応当日");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getZennouZndk(),BizCurrency.valueOf(0),
            "契約応当日前納残高リスト[1].前納残高");
        exBizCalcbleEquals(keisanZennouSeisanGk.getKykOutoubiZennouZndkList().get(1).getJyuutoumaeZennouZndk(),BizCurrency.valueOf(0),
            "契約応当日前納残高リスト[1].充当前前納残高");
    }
}

package yuyu.common.direct.dscommon;

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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknMockForDirect;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ定率積立金計算クラスのメソッド {@link DsTeirituTumitatekinKeisan#nkGnsGkKeisan((String pSyono, BizDate pCalckijyunYmd, IT_KykSyouhn pKykSyouhn,
        IT_KykSonotaTkyk pKykSonotaTkyk))}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class DsTeirituTumitatekinKeisanTest_exec extends AbstractTest {

    @Inject
    private DsTeirituTumitatekinKeisan dsTeirituTumitatekinKeisan;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_ＤＳ定率積立金計算";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanSisuuRendouNkTmttkn.class).to(KeisanSisuuRendouNkTmttknMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        KeisanSisuuRendouNkTmttknMockForDirect.caller = DsTeirituTumitatekinKeisanTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanSisuuRendouNkTmttknMockForDirect.caller = null;
        KeisanSisuuRendouNkTmttknMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsTeirituTumitatekinKeisanTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU));
        List<IT_KykKihon> kykKihonList = hozenDomManager.getAllKykKihon();
        for (IT_KykKihon kykKihon : kykKihonList) {
            hozenDomManager.delete(kykKihon.getKykSonotaTkyk());
        }
    }

    @Test
    @TestOrder(10)
    public void testNkGnsGkKeisan_A1() {

        MockObjectManager.initialize();
        KeisanSisuuRendouNkTmttknMockForDirect.SYORIPTN = KeisanSisuuRendouNkTmttknMockForDirect.TESTPATTERN2;

        String syono = "99806001010";

        BizDate calckijyunYmd = BizDate.valueOf(20200724);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhns().get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        C_ErrorKbn errorKbn = dsTeirituTumitatekinKeisan.keisanNkGnsGk(syono, calckijyunYmd, kykSyouhn, kykSonotaTkyk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(dsTeirituTumitatekinKeisan.getNkGnsGk(), BizCurrency.valueOf(2000), "年金原資額");

    }

    @Test
    @TestOrder(20)
    public void testNkGnsGkKeisan_A2() {

        MockObjectManager.initialize();
        KeisanSisuuRendouNkTmttknMockForDirect.SYORIPTN = KeisanSisuuRendouNkTmttknMockForDirect.TESTPATTERN1;

        String syono = "99806001021";

        BizDate calckijyunYmd = BizDate.valueOf(20200724);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhns().get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        C_ErrorKbn errorKbn = dsTeirituTumitatekinKeisan.keisanNkGnsGk(syono, calckijyunYmd, kykSyouhn, kykSonotaTkyk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(dsTeirituTumitatekinKeisan.getNkGnsGk(), null, "年金原資額");

    }

    @Test
    @TestOrder(30)
    public void testNkGnsGkKeisan_A3() {

        String syono = "99806001032";

        BizDate calckijyunYmd = BizDate.valueOf(20200724);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhns().get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        C_ErrorKbn errorKbn = dsTeirituTumitatekinKeisan.keisanNkGnsGk(syono, calckijyunYmd, kykSyouhn, kykSonotaTkyk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(dsTeirituTumitatekinKeisan.getNkGnsGk(), BizCurrency.valueOf(10000000), "年金原資額");

    }

    @Test
    @TestOrder(40)
    public void testNkGnsGkKeisan_A4() {

        String syono = "99806001043";

        BizDate calckijyunYmd = BizDate.valueOf(20200724);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhns().get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        C_ErrorKbn errorKbn = dsTeirituTumitatekinKeisan.keisanNkGnsGk(syono, calckijyunYmd, kykSyouhn, kykSonotaTkyk);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(dsTeirituTumitatekinKeisan.getNkGnsGk(), null, "年金原資額");

    }

    @Test
    @TestOrder(50)
    public void testNkGnsGkKeisan_A5() {

        changeSystemDate(BizDate.valueOf(20200801));

        MockObjectManager.initialize();
        KeisanSisuuRendouNkTmttknMockForDirect.SYORIPTN = KeisanSisuuRendouNkTmttknMockForDirect.TESTPATTERN3;

        String syono = "99806015154";

        BizDate calckijyunYmd = BizDate.valueOf(20200724);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhns().get(0);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        C_ErrorKbn errorKbn = dsTeirituTumitatekinKeisan.keisanNkGnsGk(syono, calckijyunYmd, kykSyouhn, kykSonotaTkyk);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(dsTeirituTumitatekinKeisan.getNkGnsGk(), BizCurrency.valueOf(30000000), "年金原資額");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 0), BizDate.valueOf(20170424), "契約日");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 1), 99, "保険期間");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 2), C_UmuKbn.ARI, "定期支払特約付加有無");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 3), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 4), BizDate.valueOf(20200801), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 5), BizDateYM.valueOf(202109), "計算基準年月");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 6), BizDateYM.valueOf(202009), "計算開始年月");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 7), BizNumber.valueOf(0.618), "積立利率");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 8), BizCurrency.valueOf(10477396), "定率積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 0, 9), BizCurrency.valueOf(0L), "指数連動積立金額");


        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 0), BizDate.valueOf(20170424), "契約日");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 1), 99, "保険期間");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 2), C_UmuKbn.ARI, "定期支払特約付加有無");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 3), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 4), BizDate.valueOf(20200801), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 5), BizDateYM.valueOf(202209), "計算基準年月");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 6), BizDateYM.valueOf(202109), "計算開始年月");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 7), BizNumber.valueOf(0.618), "積立利率");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 8), BizCurrency.valueOf(10000000), "定率積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 1, 9), BizCurrency.valueOf(0L), "指数連動積立金額");


        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 0), BizDate.valueOf(20170424), "契約日");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 1), 99, "保険期間");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 2), C_UmuKbn.ARI, "定期支払特約付加有無");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 3), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 4), BizDate.valueOf(20200801), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 5), BizDateYM.valueOf(202309), "計算基準年月");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 6), BizDateYM.valueOf(202209), "計算開始年月");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 7), BizNumber.valueOf(0.618), "積立利率");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 8), BizCurrency.valueOf(20000000), "定率積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanSisuuRendouNkTmttknMockForDirect.class, "exec", 2, 9), BizCurrency.valueOf(0L), "指数連動積立金額");

    }
}

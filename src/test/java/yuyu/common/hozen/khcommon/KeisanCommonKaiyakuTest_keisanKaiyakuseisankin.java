package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.HenkanTuukaMockForHozen;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.common.hozen.haitou.KeisanDCommonKaiyaku;
import yuyu.common.hozen.haitou.KeisanDCommonKaiyakuMockForHozen;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FiSiyouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_RatesyutokukekkaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約共通計算のメソッド {@link KeisanCommonKaiyaku#keisanKaiyakuseisankin(String, IT_KykKihon,
        BizDate, KeisanKaiyakuBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanCommonKaiyakuTest_keisanKaiyakuseisankin {

    @Inject
    private KeisanCommonKaiyaku keisanCommonKaiyaku;

    @Inject
    private HozenDomManager hozenDomManager;

    private C_ErrorKbn erroKbn;

    private final static String fileName = "UT-SP_単体テスト仕様書_解約共通計算";

    private final static String sheetName = "INデータ";

    private final static String syoNo1  = "17806000013";

    private final static String syoNo2  = "17806000024";

    private final static String syoNo3  = "17806000035";

    private final static String syoNo4  = "17806000046";

    private final static String syoNo5  = "17806000057";

    private final static String syoNo6  = "17806000068";

    private final static String syoNo7  = "17806000079";

    private final static String syoNo8  = "17806000080";

    private final static String syoNo9  = "17806000091";

    private final static String syoNo10  = "11807111130";

    private final static String syoNo11  = "11807111141";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HenkanTuuka.class).to(HenkanTuukaMockForHozen.class);
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
                bind(KeisanZennouSeisanGk2.class).to(KeisanZennouSeisanGk2MockForHozen.class);
                bind(KeisanMsyMkeiP.class).to(KeisanMsyMkeiPMockForHozen.class);
                bind(KeisanDCommonKaiyaku.class).to(KeisanDCommonKaiyakuMockForHozen.class);
                bind(KeisanKhGensen.class).to(KeisanKhGensenMockForHozen.class);
                bind(KeisanHtyKeihi.class).to(KeisanHtyKeihiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        HenkanTuukaMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanWExtMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanWMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanGaikakanzanMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanZennouSeisanGk2MockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanMsyMkeiPMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanDCommonKaiyakuMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanKhGensenMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;
        KeisanHtyKeihiMockForHozen.caller = KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class;

    }

    @AfterClass
    public static void testClear() {

        HenkanTuukaMockForHozen.caller = null;
        KeisanWExtMockForHozen.caller = null;
        KeisanWMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanZennouSeisanGk2MockForHozen.caller = null;
        KeisanMsyMkeiPMockForHozen.caller = null;
        KeisanDCommonKaiyakuMockForHozen.caller = null;
        KeisanKhGensenMockForHozen.caller = null;
        KeisanHtyKeihiMockForHozen.caller = null;

        MockObjectManager.initialize();
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class, fileName, sheetName);
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
    public void testKeisanKaiyakuseisankin_A1() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo1);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanCommonKaiyaku.getErrorMessage(), "解約返戻金計算拡張情報作成が実行できませんでした。", "エラーメッセージ");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo1, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

    }

    @Test
    @TestOrder(20)
    public void testKeisanKaiyakuseisankin_A2() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo1);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanCommonKaiyaku.getErrorMessage(), "解約返戻金計算が実行できませんでした。", "エラーメッセージ");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo1, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

    }

    @Test
    @TestOrder(30)
    public void testKeisanKaiyakuseisankin_A3() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo2);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181023");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanCommonKaiyaku.getErrorMessage(), "前納精算額計算が実行できませんでした。", "エラーメッセージ");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.USD, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo2, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201810), "解約返戻金計算基準年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1234), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2),  BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20181206"), "前納精算基準日");
        exStringEquals((String)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1),
            syoNo2, "証券番号");
    }

    @Test
    @TestOrder(40)
    public void testKeisanKaiyakuseisankin_A4() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo2);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181023");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanCommonKaiyaku.getErrorMessage(), "預り元利金計算が実行できませんでした。", "エラーメッセージ");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.USD, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo2, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201810), "解約返戻金計算基準年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1234), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20181206"), "前納精算基準日");
        exStringEquals((String)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1),
            syoNo2, "証券番号");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo2, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201912), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,
            "exec", 0, 3), BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

    }

    @Test
    @TestOrder(50)
    public void testKeisanKaiyakuseisankin_A5() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo3);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanCommonKaiyaku.getErrorMessage(), "配当共通計算（解約）が実行できませんでした。", "エラーメッセージ");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo3, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201811), "解約返戻金計算基準年月");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo3, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201811), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,
            "exec", 0, 3), BizCurrency.valueOf(1000), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo3, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1), BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201811"), "次回Ｐ充当年月");

    }

    @Test
    @TestOrder(60)
    public void testKeisanKaiyakuseisankin_A6() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo4);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanCommonKaiyaku.getErrorMessage(), "源泉徴収額計算が実行できませんでした。", "エラーメッセージ");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo4, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo4, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201812), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1000), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo4, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1), BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2),  BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201812"), "次回Ｐ充当年月");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 0), syoNo4, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 1),
            C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 2),
            C_UmuKbn.NONE, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 4),
            BizCurrency.valueOf(11004), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 5), BizDate.valueOf("20181206"), "計算基準日");

    }

    @Test
    @TestOrder(70)
    public void testKeisanKaiyakuseisankin_A7() {

        String pKinouBunrui = "batch";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo5);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.flag = 0;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);

        exClassificationEquals(erroKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanCommonKaiyaku.getErrorMessage(), "源泉徴収額計算が実行できませんでした。", "エラーメッセージ");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.USD, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo5, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201811), "解約返戻金計算基準年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1001), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo5, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1), BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201813"), "次回Ｐ充当年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(1001), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec" ,1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 0), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 1), BizCurrency.valueOf(1002), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 0), syoNo5, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 2),
            C_UmuKbn.NONE, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 4),
            BizCurrency.valueOf(1002), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 5), BizDate.valueOf("20181206"), "計算基準日");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 0), syoNo5, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 2),
            C_UmuKbn.ARI, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 4),
            BizCurrency.valueOf(1002), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 5), BizDate.valueOf("20181206"), "計算基準日");

    }

    @Test
    @TestOrder(80)
    public void testKeisanKaiyakuseisankin_A8() {

        String pKinouBunrui = "batch";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo6);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN3;
        KeisanKhGensenMockForHozen.flag = 0;
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = new EditDshrTukiDKoumokuBean();
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo6, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo6, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201814), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1000), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo6, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1), BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201814"), "次回Ｐ充当年月");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 0), syoNo6, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 1),
            C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 2),
            C_UmuKbn.NONE, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 4),
            BizCurrency.valueOf(11004), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 5), BizDate.valueOf("20181206"), "計算基準日");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 0), syoNo6, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 1),
            C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 2),
            C_UmuKbn.ARI, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 4),
            BizCurrency.valueOf(11004), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 5), BizDate.valueOf("20181206"), "計算基準日");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeigk(), BizCurrency.valueOf(-98), "支払額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeiYen(), BizCurrency.valueOf(-98), "支払額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkgk(), BizCurrency.valueOf(0), "その他支払金額（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkYen(), BizCurrency.valueOf(12104), "その他支払金額（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk(), BizCurrency.valueOf(1001), "解約返戻金額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen(), BizCurrency.valueOf(0), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHr(), BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHrYen(), BizCurrency.valueOf(1001), "解約返戻金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr(), BizCurrency.valueOf(1001), "円建変更後解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getPtumitatekin(), BizCurrency.valueOf(1001), "保険料積立金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk(), BizCurrency.valueOf(3001), "市場価格調整額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu(), BizNumber.valueOf(3001), "市場価格調整率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTeiriTutmttKngk(), BizCurrency.valueOf(1001), "定率積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl(), BizCurrency.valueOf(1001), "指数連動積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjgk(), BizCurrency.valueOf(3001), "解約控除額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu(), BizNumber.valueOf(3001), "解約控除率");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankGk(), BizCurrency.valueOf(0), "前納精算金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(0), "前納精算金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapGk(), BizCurrency.valueOf(0), "未経過保険料（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapYen(), BizCurrency.valueOf(10002), "未経過保険料（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm(), BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY(), 1, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM(), 9, "未経過Ｐ充当回数（月）");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMiKeikaP(),
            BizCurrency.valueOf(3041, BizCurrencyTypes.DOLLAR), "明細未経過Ｐ");
        exDateEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(),
            BizDate.valueOf("20180102"), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(),
            C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 2, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 9, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytYm(),
            BizDateYM.valueOf(201809), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikingk(), BizCurrency.valueOf(0), "預り元利金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKrkgkYen(), BizCurrency.valueOf(1100), "仮受金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHaitoukinYen(), BizCurrency.valueOf(1002), "配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYentkbthaitoukin(), BizCurrency.valueOf(0), "特別配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTmtthaitoukinYen(), BizCurrency.valueOf(100), "積立配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotahaitoukinYen(), BizCurrency.valueOf(1002), "その他配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotaseisan(), BizCurrency.valueOf(1000), "その他精算金");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdOne(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdTwo(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGstszeigk(), BizCurrency.valueOf(3001), "源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk(), BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGaikaGsBunriTaisyouFlag(),
            C_UmuKbn.ARI, "外貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi(), BizCurrency.valueOf(3001), "外貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn(),
            C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd(), BizDate.valueOf("20180601"), "税務用為替レート取得日");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZeimukwsrate(), BizNumber.valueOf(3001), "税務用為替レート");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGensengkYenkaiyakuhr(),
            BizCurrency.valueOf(3001), "（源泉徴収額計算）円換算解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpygstszeigk(), BizCurrency.valueOf(3101), "円貨源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getJpyGsBunriTaisyouFlag(),
            C_UmuKbn.NONE, "円貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi(),
            BizCurrency.valueOf(3101), "円貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGsbunritaisyouFlg(),
            C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getKhHaitouKanriNaiteiKakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "配当管理ＴＢＬ内定確定区分");

        editDshrTukiDKoumokuBean = keisanCommonKaiyakuOutBean.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrTukiDKoumokuBean.getCalckijyunYmd(), BizDate.valueOf("20180129"), "計算基準日");
        exBizCalcbleEquals(editDshrTukiDKoumokuBean.getDkeisanhaitouKin(), BizCurrency.valueOf(100), "配当金計算配当金");
        exClassificationEquals(editDshrTukiDKoumokuBean.getDkeisannaiteikakuteiKbn(),
            C_NaiteiKakuteiKbn.NAITEI, "配当金計算内定確定区分");
    }


    @Test
    @TestOrder(90)
    public void testKeisanKaiyakuseisankin_A9() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo7);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);
        pKeisanKaiyakuBean.setKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN3;
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanKhGensenMockForHozen.flag = 0;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.USD, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo7, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0),  BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1001), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo7, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201815), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo7, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1),  BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201815"), "次回Ｐ充当年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(1001), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec" ,1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 0), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 1), BizCurrency.valueOf(2202), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "execDivide", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 0), syoNo7, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 2),
            C_UmuKbn.NONE, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 4),
            BizCurrency.valueOf(2202), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 5), BizDate.valueOf("20181206"), "計算基準日");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 0), syoNo7, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 2),
            C_UmuKbn.ARI, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 4),
            BizCurrency.valueOf(2202), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 5), BizDate.valueOf("20181206"), "計算基準日");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeigk(), BizCurrency.valueOf(-999), "支払額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeiYen(), BizCurrency.valueOf(102), "支払額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkgk(), BizCurrency.valueOf(1001), "その他支払金額（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkYen(), BizCurrency.valueOf(2202), "その他支払金額（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk(), BizCurrency.valueOf(1001), "解約返戻金額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen(), BizCurrency.valueOf(1001), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHr(), BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHrYen(), BizCurrency.valueOf(1001), "解約返戻金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr(), BizCurrency.valueOf(0), "円建変更後解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getPtumitatekin(), BizCurrency.valueOf(1001), "保険料積立金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk(), BizCurrency.valueOf(3001), "市場価格調整額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu(), BizNumber.valueOf(3001), "市場価格調整率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTeiriTutmttKngk(), BizCurrency.valueOf(1001), "定率積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl(), BizCurrency.valueOf(1001), "指数連動積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjgk(), BizCurrency.valueOf(3001), "解約控除額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu(), BizNumber.valueOf(3001), "解約控除率");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankGk(), BizCurrency.valueOf(0), "前納精算金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(0), "前納精算金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapGk(), BizCurrency.valueOf(10002), "未経過保険料（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapYen(), BizCurrency.valueOf(0), "未経過保険料（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm(), BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY(), 1, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM(), 9, "未経過Ｐ充当回数（月）");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMiKeikaP(),
            BizCurrency.valueOf(3041, BizCurrencyTypes.DOLLAR), "明細未経過Ｐ");
        exDateEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(),
            BizDate.valueOf("20180102"), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(),
            C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 2, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 9, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytYm(),
            BizDateYM.valueOf(201809), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikingk(), BizCurrency.valueOf(0), "預り元利金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKrkgkYen(), BizCurrency.valueOf(1200), "仮受金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHaitoukinYen(), BizCurrency.valueOf(1002), "配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYentkbthaitoukin(), BizCurrency.valueOf(0), "特別配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTmtthaitoukinYen(), BizCurrency.valueOf(100), "積立配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotahaitoukinYen(), BizCurrency.valueOf(1002), "その他配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotaseisan(), BizCurrency.valueOf(0), "その他精算金");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdOne(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdTwo(), C_Segcd.BLNK, "セグメント２コード");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGstszeigk(), BizCurrency.valueOf(3001), "源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk(), BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGaikaGsBunriTaisyouFlag(),
            C_UmuKbn.ARI, "外貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi(), BizCurrency.valueOf(3001), "外貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn(),
            C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd(), BizDate.valueOf("20180601"), "税務用為替レート取得日");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZeimukwsrate(), BizNumber.valueOf(3001), "税務用為替レート");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGensengkYenkaiyakuhr(),
            BizCurrency.valueOf(3001), "（源泉徴収額計算）円換算解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpygstszeigk(), BizCurrency.valueOf(3101), "円貨源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getJpyGsBunriTaisyouFlag(),
            C_UmuKbn.NONE, "円貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi(),
            BizCurrency.valueOf(3101), "円貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGsbunritaisyouFlg(),
            C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getKhHaitouKanriNaiteiKakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "配当管理ＴＢＬ内定確定区分");

    }

    @Test
    @TestOrder(100)
    public void testKeisanKaiyakuseisankin_A10() {

        String pKinouBunrui = "batch";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo8);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.flag = 0;
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo8, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1), BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0), BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo8, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1), BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201816"), "次回Ｐ充当年月");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeigk(), BizCurrency.valueOf(2003), "支払額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeiYen(), BizCurrency.valueOf(2003), "支払額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkgk(), BizCurrency.valueOf(0), "その他支払金額（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkYen(), BizCurrency.valueOf(2302), "その他支払金額（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk(), BizCurrency.valueOf(1001), "解約返戻金額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen(), BizCurrency.valueOf(0), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHr(), BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHrYen(), BizCurrency.valueOf(1001), "解約返戻金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr(), BizCurrency.valueOf(1001), "円建変更後解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getPtumitatekin(), BizCurrency.valueOf(1001), "保険料積立金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk(), BizCurrency.valueOf(3001), "市場価格調整額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu(), BizNumber.valueOf(3001), "市場価格調整率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTeiriTutmttKngk(), BizCurrency.valueOf(1001), "定率積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl(), BizCurrency.valueOf(1001), "指数連動積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjgk(), BizCurrency.valueOf(3001), "解約控除額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu(), BizNumber.valueOf(3001), "解約控除率");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankGk(), BizCurrency.valueOf(0), "前納精算金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(0), "前納精算金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapGk(), BizCurrency.valueOf(0), "未経過保険料（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapYen(), BizCurrency.valueOf(0), "未経過保険料（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm(), null, "未経過Ｐ充当年月");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY(), 0, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM(), 0, "未経過Ｐ充当回数（月）");
        assertNull(keisanCommonKaiyakuOutBean.getMiKeikaPBeans());
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikingk(), BizCurrency.valueOf(0), "預り元利金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKrkgkYen(), BizCurrency.valueOf(1300), "仮受金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHaitoukinYen(), BizCurrency.valueOf(1002), "配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYentkbthaitoukin(), BizCurrency.valueOf(0), "特別配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTmtthaitoukinYen(), BizCurrency.valueOf(100), "積立配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotahaitoukinYen(), BizCurrency.valueOf(1002), "その他配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotaseisan(), BizCurrency.valueOf(0), "その他精算金");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdOne(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdTwo(), C_Segcd.BLNK, "セグメント２コード");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk(), BizCurrency.valueOf(0), "外貨支払時円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz(),
            BizCurrency.valueOf(0), "外貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz(),
            BizCurrency.valueOf(0), "外貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGaikaGsBunriTaisyouFlag(),
            C_UmuKbn.NONE, "外貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(0), "外貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi(), BizCurrency.valueOf(0), "外貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn(),
            C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd(), null, "税務用為替レート取得日");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGensengkYenkaiyakuhr(),
            BizCurrency.valueOf(0), "（源泉徴収額計算）円換算解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpygstszeigk(), BizCurrency.valueOf(0), "円貨源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz(),
            BizCurrency.valueOf(0), "円貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz(),
            BizCurrency.valueOf(0), "円貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getJpyGsBunriTaisyouFlag(),
            C_UmuKbn.NONE, "円貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(0), "円貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi(),
            BizCurrency.valueOf(0), "円貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGsbunritaisyouFlg(),
            C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getKhHaitouKanriNaiteiKakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "配当管理ＴＢＬ内定確定区分");

    }

    @Test
    @TestOrder(110)
    public void testKeisanKaiyakuseisankin_A11() {

        String pKinouBunrui = "drctservice";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo9);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN3;

        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanKhGensenMockForHozen.flag = 0;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.USD, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo9, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0),  BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1001), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20181206"), "前納精算基準日");
        exStringEquals((String)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1),
            syoNo9, "証券番号");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo9, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201912), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo9, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1),  BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201817"), "次回Ｐ充当年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(1001), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec" ,1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 0), syoNo9, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 2),
            C_UmuKbn.NONE, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 4),
            BizCurrency.valueOf(1002), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 5), BizDate.valueOf("20181206"), "計算基準日");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 0), syoNo9, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 2),
            C_UmuKbn.ARI, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 4),
            BizCurrency.valueOf(1002), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 5), BizDate.valueOf("20181206"), "計算基準日");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeigk(), BizCurrency.valueOf(-2000), "支払額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeiYen(), BizCurrency.valueOf(302), "支払額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkgk(), BizCurrency.valueOf(0), "その他支払金額（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkYen(), BizCurrency.valueOf(2402), "その他支払金額（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk(), BizCurrency.valueOf(1001), "解約返戻金額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen(), BizCurrency.valueOf(1001), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHr(), BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHrYen(), BizCurrency.valueOf(1001), "解約返戻金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr(), BizCurrency.valueOf(0), "円建変更後解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getPtumitatekin(), BizCurrency.valueOf(1001), "保険料積立金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk(), BizCurrency.valueOf(3001), "市場価格調整額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu(), BizNumber.valueOf(3001), "市場価格調整率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTeiriTutmttKngk(), BizCurrency.valueOf(1001), "定率積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl(), BizCurrency.valueOf(1001), "指数連動積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjgk(), BizCurrency.valueOf(3001), "解約控除額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu(), BizNumber.valueOf(3001), "解約控除率");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankGk(), BizCurrency.valueOf(1002), "前納精算金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(0), "前納精算金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapGk(), BizCurrency.valueOf(10002), "未経過保険料（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapYen(), BizCurrency.valueOf(0), "未経過保険料（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm(), BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY(), 1, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM(), 9, "未経過Ｐ充当回数（月）");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMiKeikaP(),
            BizCurrency.valueOf(3041, BizCurrencyTypes.DOLLAR), "明細未経過Ｐ");
        exDateEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(),
            BizDate.valueOf("20180102"), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(),
            C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 2, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 9, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytYm(),
            BizDateYM.valueOf(201809), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikingk(), BizCurrency.valueOf(0), "預り元利金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKrkgkYen(), BizCurrency.valueOf(1400), "仮受金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHaitoukinYen(), BizCurrency.valueOf(1002), "配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYentkbthaitoukin(), BizCurrency.valueOf(0), "特別配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTmtthaitoukinYen(), BizCurrency.valueOf(100), "積立配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotahaitoukinYen(), BizCurrency.valueOf(1002), "その他配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotaseisan(), BizCurrency.valueOf(0), "その他精算金");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdOne(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdTwo(), C_Segcd.BLNK, "セグメント２コード");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGstszeigk(), BizCurrency.valueOf(3001), "源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk(), BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGaikaGsBunriTaisyouFlag(),
            C_UmuKbn.ARI, "外貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi(), BizCurrency.valueOf(3001), "外貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn(),
            C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd(), BizDate.valueOf("20180601"), "税務用為替レート取得日");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZeimukwsrate(), BizNumber.valueOf(3001), "税務用為替レート");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGensengkYenkaiyakuhr(),
            BizCurrency.valueOf(3001), "（源泉徴収額計算）円換算解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpygstszeigk(), BizCurrency.valueOf(3101), "円貨源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getJpyGsBunriTaisyouFlag(),
            C_UmuKbn.NONE, "円貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi(),
            BizCurrency.valueOf(3101), "円貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGsbunritaisyouFlg(),
            C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getLastpjytoym(), BizDateYM.valueOf(201812), "最終Ｐ充当年月");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg(), C_UmuKbn.NONE, "前納未充当フラグ");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getKhHaitouKanriNaiteiKakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "配当管理ＴＢＬ内定確定区分");

    }

    @Test
    @TestOrder(120)
    public void testKeisanKaiyakuseisankin_A12() {

        String pKinouBunrui = "drctservice";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("11807111118");
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181024");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN3;

        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanKhGensenMockForHozen.flag = 0;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0), null,
            "前納精算基準日");
        exStringEquals((String) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1), null,
            "証券番号");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), "11807111118", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201810), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(0), "前納精算金（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getLastpjytoym(), null, "最終Ｐ充当年月");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg(), C_UmuKbn.ARI, "前納未充当フラグ");

    }

    @Test
    @TestOrder(120)
    public void testKeisanKaiyakuseisankin_A13() {

        String pKinouBunrui = "drctservice";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon("11807111129");
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181001");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN3;

        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanKhGensenMockForHozen.flag = 0;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0), null,
            "前納精算基準日");
        exStringEquals((String) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1), null,
            "証券番号");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), "11807111129", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201809), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(0), "前納精算金（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getLastpjytoym(), null, "最終Ｐ充当年月");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg(), C_UmuKbn.ARI, "前納未充当フラグ");

    }

    @Test
    @TestOrder(140)
    public void testKeisanKaiyakuseisankin_A14() {

        String pKinouBunrui = "drctservice";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo10);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN3;

        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanKhGensenMockForHozen.flag = 0;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.JPY, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo10, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0),  BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20181206"), "前納精算基準日");
        exStringEquals((String)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1),
            syoNo10, "証券番号");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo10, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201912), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo10, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1),  BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201817"), "次回Ｐ充当年月");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 0), syoNo10, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 1),
            C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 2),
            C_UmuKbn.NONE, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 4),
            BizCurrency.valueOf(1002), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 5), BizDate.valueOf("20181206"), "計算基準日");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 0), syoNo10, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 1),
            C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 2),
            C_UmuKbn.ARI, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 4),
            BizCurrency.valueOf(1002), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 5), BizDate.valueOf("20181206"), "計算基準日");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeigk(), BizCurrency.valueOf(-2000), "支払額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeiYen(), BizCurrency.valueOf(11306), "支払額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkgk(), BizCurrency.valueOf(0), "その他支払金額（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkYen(), BizCurrency.valueOf(2402), "その他支払金額（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk(), BizCurrency.valueOf(1001), "解約返戻金額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen(), BizCurrency.valueOf(12005), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHr(), BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHrYen(), BizCurrency.valueOf(1001), "解約返戻金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr(), BizCurrency.valueOf(1001), "円建変更後解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getPtumitatekin(), BizCurrency.valueOf(1001), "保険料積立金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk(), BizCurrency.valueOf(3001), "市場価格調整額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu(), BizNumber.valueOf(3001), "市場価格調整率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTeiriTutmttKngk(), BizCurrency.valueOf(1001), "定率積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl(), BizCurrency.valueOf(1001), "指数連動積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjgk(), BizCurrency.valueOf(3001), "解約控除額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu(), BizNumber.valueOf(3001), "解約控除率");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankGk(), BizCurrency.valueOf(0), "前納精算金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(1002), "前納精算金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapGk(), BizCurrency.valueOf(0), "未経過保険料（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapYen(), BizCurrency.valueOf(10002), "未経過保険料（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm(), BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY(), 1, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM(), 9, "未経過Ｐ充当回数（月）");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMiKeikaP(),
            BizCurrency.valueOf(3041, BizCurrencyTypes.DOLLAR), "明細未経過Ｐ");
        exDateEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(),
            BizDate.valueOf("20180102"), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(),
            C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 2, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 9, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytYm(),
            BizDateYM.valueOf(201809), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikingk(), BizCurrency.valueOf(0), "預り元利金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKrkgkYen(), BizCurrency.valueOf(1400), "仮受金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHaitoukinYen(), BizCurrency.valueOf(1002), "配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYentkbthaitoukin(), BizCurrency.valueOf(0), "特別配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTmtthaitoukinYen(), BizCurrency.valueOf(100), "積立配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotahaitoukinYen(), BizCurrency.valueOf(1002), "その他配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotaseisan(), BizCurrency.valueOf(0), "その他精算金");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdOne(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdTwo(), C_Segcd.BLNK, "セグメント２コード");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGstszeigk(), BizCurrency.valueOf(3001), "源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk(), BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGaikaGsBunriTaisyouFlag(),
            C_UmuKbn.ARI, "外貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi(), BizCurrency.valueOf(3001), "外貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn(),
            C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd(), BizDate.valueOf("20180601"), "税務用為替レート取得日");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZeimukwsrate(), BizNumber.valueOf(3001), "税務用為替レート");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGensengkYenkaiyakuhr(),
            BizCurrency.valueOf(3001), "（源泉徴収額計算）円換算解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpygstszeigk(), BizCurrency.valueOf(3101), "円貨源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getJpyGsBunriTaisyouFlag(),
            C_UmuKbn.NONE, "円貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi(),
            BizCurrency.valueOf(3101), "円貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGsbunritaisyouFlg(),
            C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getLastpjytoym(), BizDateYM.valueOf(201812), "最終Ｐ充当年月");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg(), C_UmuKbn.NONE, "前納未充当フラグ");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getKhHaitouKanriNaiteiKakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "配当管理ＴＢＬ内定確定区分");

    }

    @Test
    @TestOrder(150)
    public void testKeisanKaiyakuseisankin_A15() {

        String pKinouBunrui = "drctservice";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo11);
        BizDate pSyoriYmd = BizDate.valueOf("20181105");
        KeisanKaiyakuBean pKeisanKaiyakuBean = new KeisanKaiyakuBean();
        BizDate pSyoruiukeymd = BizDate.valueOf("20181212");
        pKeisanKaiyakuBean.setSyoruiukeymd(pSyoruiukeymd);
        BizDate pKaiykymd = BizDate.valueOf("20181206");
        pKeisanKaiyakuBean.setKaiykymd(pKaiykymd);
        BizNumber pYenshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setYenshrkwsrate(pYenshrkwsrate);
        BizNumber pGkshrkwsrate = BizNumber.valueOf(10);
        pKeisanKaiyakuBean.setGkshrkwsrate(pGkshrkwsrate);

        HenkanTuukaMockForHozen.SYORIPTN = HenkanTuukaMockForHozen.TESTPATTERN2;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanMsyMkeiPMockForHozen.SYORIPTN = KeisanMsyMkeiPMockForHozen.TESTPATTERN1;
        KeisanDCommonKaiyakuMockForHozen.SYORIPTN = KeisanDCommonKaiyakuMockForHozen.TESTPATTERN2;
        KeisanKhGensenMockForHozen.SYORIPTN = KeisanKhGensenMockForHozen.TESTPATTERN4;

        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanKhGensenMockForHozen.flag = 0;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(pKinouBunrui, pKykKihon, pSyoriYmd, pKeisanKaiyakuBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (HenkanTuukaMockForHozen.class, "henkanTuukaKbnToType", 0, 0), C_Tuukasyu.USD, "契約通貨種類");

        exStringEquals((String)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), syoNo11, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "解約日");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 0),  BizDate.valueOf("20181206"), "解約日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 0, 1),
            BizDateYM.valueOf(201812), "解約返戻金計算基準年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(1001, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0),
            BizDate.valueOf("20181206"), "前納精算基準日");
        exStringEquals((String)MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1),
            syoNo11, "証券番号");

        exStringEquals((String)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 0), syoNo11, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 1),  BizDate.valueOf("20181206"), "計算日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 2),
            BizDateYM.valueOf(201912), "次回Ｐ充当年月");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "払込保険料");
        exClassificationEquals((C_MisyuptsKbn)MockObjectManager.getArgument(KeisanMsyMkeiPMockForHozen.class, "exec", 0, 4),
            C_MisyuptsKbn.MITS, "未収Ｐ徴収区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 0), syoNo11, "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 1),  BizDate.valueOf("20181206"), "計算基準日");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 2), BizDate.valueOf("20181105"), "処理年月日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanDCommonKaiyakuMockForHozen.class, "calcDShrgk", 0, 3), BizDateYM.valueOf("201817"), "次回Ｐ充当年月");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 1), BizCurrency.valueOf(1001, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 2), BizNumber.valueOf(10), "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec" ,1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 0), syoNo11, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 2),
            C_UmuKbn.NONE, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 3),
            BizCurrency.valueOf(1001, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 0, 4),
            BizCurrency.valueOf(12006), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 0, 5), BizDate.valueOf("20181206"), "計算基準日");

        exStringEquals((String)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 0), syoNo11, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 1),
            C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals((C_UmuKbn)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 2),
            C_UmuKbn.ARI, "円支払特約有無");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 3),
            BizCurrency.valueOf(1001), "解約返戻金");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class,"exec", 1, 4),
            BizCurrency.valueOf(12006), "その他支払金額（円貨）");
        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanKhGensenMockForHozen.class, "exec", 1, 5), BizDate.valueOf("20181206"), "計算基準日");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeigk(), BizCurrency.valueOf(-2000, BizCurrencyTypes.DOLLAR), "支払額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getShrgkkeiYen(), BizCurrency.valueOf(11306), "支払額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他支払金額（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotashrgkYen(), BizCurrency.valueOf(13406), "その他支払金額（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk(), BizCurrency.valueOf(1001, BizCurrencyTypes.DOLLAR), "解約返戻金額合計（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen(), BizCurrency.valueOf(1001), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHr(), BizCurrency.valueOf(1001, BizCurrencyTypes.DOLLAR), "解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuHrYen(), BizCurrency.valueOf(1001), "解約返戻金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYendthnkkaiyakuhr(), BizCurrency.valueOf(0), "円建変更後解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getPtumitatekin(), BizCurrency.valueOf(1001), "保険料積立金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk(), BizCurrency.valueOf(3001), "市場価格調整額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu(), BizNumber.valueOf(3001), "市場価格調整率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTeiriTutmttKngk(), BizCurrency.valueOf(1001), "定率積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl(), BizCurrency.valueOf(1001), "指数連動積立金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjgk(), BizCurrency.valueOf(3001), "解約控除額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKaiyakuKjRitu(), BizNumber.valueOf(3001), "解約控除率");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getFiSiyouKbn(), C_FiSiyouKbn.TJTSI, "ファンドインデックス使用区分");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankGk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZennouseisankYen(), BizCurrency.valueOf(1002), "前納精算金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapGk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMikeikapYen(), BizCurrency.valueOf(10002), "未経過保険料（円貨）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm(), BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY(), 1, "未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM(), 9, "未経過Ｐ充当回数（月）");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMiKeikaP(),
            BizCurrency.valueOf(3041, BizCurrencyTypes.DOLLAR), "明細未経過Ｐ");
        exDateEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPNykDenYmd(),
            BizDate.valueOf("20180102"), "明細未経過Ｐ入金伝票日付");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPHrkKaisuu(),
            C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuY(), 2, "明細未経過Ｐ充当回数（年）");
        exNumericEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytKaisuuM(), 9, "明細未経過Ｐ充当回数（月）");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getMiKeikaPBeans()[0].getMkeiPJytYm(),
            BizDateYM.valueOf(201809), "明細未経過Ｐ充当年月");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り元利金（外貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getAzukariGanrikinYen(), BizCurrency.valueOf(0), "預り元利金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getKrkgkYen(), BizCurrency.valueOf(1400), "仮受金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHaitoukinYen(), BizCurrency.valueOf(1002), "配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYentkbthaitoukin(), BizCurrency.valueOf(0), "特別配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getTmtthaitoukinYen(), BizCurrency.valueOf(100), "積立配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotahaitoukinYen(), BizCurrency.valueOf(1002), "その他配当金（円貨）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSonotaseisan(), BizCurrency.valueOf(0), "その他精算金");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdOne(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getSegcdTwo(), C_Segcd.BLNK, "セグメント２コード");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGstszeigk(), BizCurrency.valueOf(3001, BizCurrencyTypes.DOLLAR), "源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk(), BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGaikaGsBunriTaisyouFlag(),
            C_UmuKbn.ARI, "外貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3001), "外貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi(), BizCurrency.valueOf(3001), "外貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokukekkaKbn(),
            C_RatesyutokukekkaKbn.SEIJYOU, "税務用為替レート取得結果");
        exDateEquals(keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd(), BizDate.valueOf("20180601"), "税務用為替レート取得日");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getZeimukwsrate(), BizNumber.valueOf(3001), "税務用為替レート");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getGensengkYenkaiyakuhr(),
            BizCurrency.valueOf(3001), "（源泉徴収額計算）円換算解約返戻金");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpygstszeigk(), BizCurrency.valueOf(3101), "円貨源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収税額（地方税）");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getJpyGsBunriTaisyouFlag(),
            C_UmuKbn.NONE, "円貨支払時源泉分離課税対象フラグ");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki(),
            BizCurrency.valueOf(3101), "円貨支払時円換算源泉徴収対象差益");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi(),
            BizCurrency.valueOf(3101), "円貨支払時円換算必要経費");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getGsbunritaisyouFlg(),
            C_UmuKbn.NONE, "源泉分離課税対象フラグ");
        exDateYMEquals(keisanCommonKaiyakuOutBean.getLastpjytoym(), BizDateYM.valueOf(201812), "最終Ｐ充当年月");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getZennoumijyuutouFlg(), C_UmuKbn.NONE, "前納未充当フラグ");
        exClassificationEquals(keisanCommonKaiyakuOutBean.getKhHaitouKanriNaiteiKakuteiKbn(), C_NaiteiKakuteiKbn.KAKUTEI, "配当管理ＴＢＬ内定確定区分");

    }

}

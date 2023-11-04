package yuyu.common.biz.kaikei;

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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 時効消滅後資金移動額計算クラスのメソッド {@link BzJkuSymtgoSknidougkKeisan#keisanJkuSymtgoSknidougk(BzJkuSymtgoSknidougkKeisanmtBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzJkuSymtgoSknidougkKeisanTest_keisanJkuSymtgoSknidougk {

    @Inject
    private BzJkuSymtgoSknidougkKeisan bzJkuSymtgoSknidougkKeisan;

    private BzJkuSymtgoSknidougkKeisanmtBean bzJkuSymtgoSknidougkKeisanmtBean;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_時効消滅後資金移動額計算";

    private final static String sheetName = "INデータ";

    private final static String syoNo1 = "17806000013";

    private final static String syoNo2 = "17806000024";

    private final static String syoNo3 = "17806000035";

    private final static String syoNo4 = "17806000046";

    private final static String syoNo5 = "16808000018";

    private final static String syoNo6 = "17806019956";

    private final static String syoNo7 = "17806020064";

    private final static String syoNo8 = "18806020364";

    private final static String syoNo9 = "18806020375";

    private final static String syoNo10 = "18806020423";

    private final static String syoNo11 = "18806020456";

    private final static String syoNo12 = "18806020696";

    private final static String syoNo13 = "18806020744";

    private final static String syoNo14 = "18806020847";

    private final static String syoNo15 = "18806021033";

    private final static String syoNo16 = "18806021697";

    private final static String syoNo17 = "18806021712";

    private final static String syoNo18 = "18806021723";

    private final static String syoNo19 = "18806022218";

    private final static String syoNo20 = "18806022229";

    private final static String syoNo21 = "18806022447";

    private final static String syoNo22 = "18806022458";

    private final static String syoNo23 = "18806022469";

    private final static String syoNo24 = "18806022492";

    private final static String syoNo25 = "18806022573";

    private final static String syoNo26 = "18806022584";

    private final static String syoNo27 = "60806000022";

    private final static String syoNo28 = "60806000033";

    private final static String syoNo29 = "60806000044";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzJkuSymtgoSknidougkKeisanTest_keisanJkuSymtgoSknidougk.class,
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
        bizDomManager.delete(bizDomManager.getAllHijynNykSikinIdouListSks());
    }

    @Before
    public void Before() {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzSegmentCdSyutoku.class).to(BzSegmentCdSyutokuMockForKeiri.class);
                bind(BzSikinIdouHanteiInfoSyutoku.class).to(BzSikinIdouHanteiInfoSyutokuMockForKeiri.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzSegmentCdSyutokuMockForKeiri.caller = BzJkuSymtgoSknidougkKeisanTest_keisanJkuSymtgoSknidougk.class;
        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = null;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.caller = BzJkuSymtgoSknidougkKeisanTest_keisanJkuSymtgoSknidougk.class;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {
        BzSegmentCdSyutokuMockForKeiri.caller = null;
        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = null;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.caller = null;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testKeisanJkuSymtgoSknidougk_A1() {

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo1);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ1");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.JPY);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(0));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(20)
    public void testKeisanJkuSymtgoSknidougk_A2() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN1;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo1);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ1");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(0));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgid(), "EBA1056", "エラーメッセージＩＤ");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgInfo(), "時効消滅後資金移動額計算", "エラーメッセージ補足情報");
    }

    @Test
    @TestOrder(30)
    public void testKeisanJkuSymtgoSknidougk_A3() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN1;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo1);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ2");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(0));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgid(), "EBA1056", "エラーメッセージＩＤ");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgInfo(), "時効消滅後資金移動額計算", "エラーメッセージ補足情報");
    }

    @Test
    @TestOrder(40)
    public void testKeisanJkuSymtgoSknidougk_A4() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN2;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo1);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ3");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(50)
    public void testKeisanJkuSymtgoSknidougk_A5() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN3;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo1);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ4");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202101));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210101));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20201111));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(1461, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(60)
    public void testKeisanJkuSymtgoSknidougk_A6() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN3;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo2);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ4");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202101));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210101));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20201111));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(2006, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(70)
    public void testKeisanJkuSymtgoSknidougk_A7() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN3;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo3);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ4");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(80)
    public void testKeisanJkuSymtgoSknidougk_A8() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN4;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo4);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ4");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(3460, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(90)
    public void testKeisanJkuSymtgoSknidougk_A9() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN5;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo4);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ4");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgid(), "EBA1056", "エラーメッセージＩＤ");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgInfo(), "時効消滅後資金移動額計算", "エラーメッセージ補足情報");
    }

    @Test
    @TestOrder(100)
    public void testKeisanJkuSymtgoSknidougk_A10() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN6;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo4);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ4");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgid(), "EBA1056", "エラーメッセージＩＤ");
        exStringEquals(bzJkuSymtgoSknidougkKeisan.getErrorMsgInfo(), "時効消滅後資金移動額計算", "エラーメッセージ補足情報");
    }

    @Test
    @TestOrder(110)
    public void testKeisanJkuSymtgoSknidougk_A11() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST1;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST1;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo5);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(200203.51, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(200203.51, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(120)
    public void testKeisanJkuSymtgoSknidougk_A12() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST2;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo6);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕｲ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(210214.65, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(210214.65, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(130)
    public void testKeisanJkuSymtgoSknidougk_A13() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST3;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST3;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo7);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕｹ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(230239.99, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(230239.99, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(140)
    public void testKeisanJkuSymtgoSknidougk_A14() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST4;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST4;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo8);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕｽ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(240240.12, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(240240.12, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(150)
    public void testKeisanJkuSymtgoSknidougk_A15() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST5;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST5;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo9);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾁ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(70072.29, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(2.00, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(33.00, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202102));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(70372.29, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(160)
    public void testKeisanJkuSymtgoSknidougk_A16() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST5;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST5;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo10);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾁ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(80086.67, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(220.00, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202102));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(80306.67, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(170)
    public void testKeisanJkuSymtgoSknidougk_A17() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST5;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST5;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo11);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾁ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(90092.80, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(9003.26, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210329));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(90212.80, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(180)
    public void testKeisanJkuSymtgoSknidougk_A18() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST5;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST5;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo12);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾂ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(100106.65, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(130.00, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(99976.65, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(190)
    public void testKeisanJkuSymtgoSknidougk_A19() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST5;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST5;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo13);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾃ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(110113.86, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(119.87, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(110233.73, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(200)
    public void testKeisanJkuSymtgoSknidougk_A20() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST5;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST5;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo14);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾄ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(120120.07, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(120120.07, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(210)
    public void testKeisanJkuSymtgoSknidougk_A21() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST6;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST6;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo15);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾅ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(130132.10, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(320.00, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(5280.00, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202102));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(130612.10, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(220)
    public void testKeisanJkuSymtgoSknidougk_A22() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST6;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST6;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo16);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾅ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(140143.69, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(340.00, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202102));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(140483.69, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(230)
    public void testKeisanJkuSymtgoSknidougk_A23() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST6;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST6;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo17);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾅ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(150152.58, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(15009.87, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210329));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(150332.58, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(240)
    public void testKeisanJkuSymtgoSknidougk_A24() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST6;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST6;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo18);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾆ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(160161.47, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(190.00, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(159971.47, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(250)
    public void testKeisanJkuSymtgoSknidougk_A25() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST6;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST6;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo19);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾇ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(170171.23, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(174.65, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(170345.88, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(260)
    public void testKeisanJkuSymtgoSknidougk_A26() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST6;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST6;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo20);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕﾈ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.AUD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(180184.56, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(180184.56, BizCurrencyTypes.AU_DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(270)
    public void testKeisanJkuSymtgoSknidougk_A27() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST7;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST7;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo21);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾆｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(10019.58, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(103.62, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(1003.48, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202102));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(11126.68, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(280)
    public void testKeisanJkuSymtgoSknidougk_A28() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST7;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST7;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo22);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾆｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(20028.54, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(3717.06, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(4054.95, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202105));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(19690.65, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(290)
    public void testKeisanJkuSymtgoSknidougk_A29() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST7;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST7;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo23);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾆｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(30039.01, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(305.41, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202102));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(30344.42, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(300)
    public void testKeisanJkuSymtgoSknidougk_A30() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST7;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST7;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo24);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾆｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(40040.09, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(4004.57, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210329));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(44044.66, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(310)
    public void testKeisanJkuSymtgoSknidougk_A31() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST7;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST7;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo25);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾆｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(50055.05, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(50.00, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(50005.05, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(320)
    public void testKeisanJkuSymtgoSknidougk_A32() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST7;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST7;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo26);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾆｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(60063.78, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(60063.78, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(330)
    public void testKeisanJkuSymtgoSknidougk_A33() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST8;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST8;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo27);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕA");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.JPY);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(22022229, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(340)
    public void testKeisanJkuSymtgoSknidougk_A34() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST9;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST9;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo28);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾕB");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.JPY);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(25025982, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210127));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "時効消滅後資金移動額");
    }

    @Test
    @TestOrder(350)
    public void testKeisanJkuSymtgoSknidougk_A35() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN_ST10;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN_ST10;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo29);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ﾆｱ");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.JPY);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(19019850, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210409));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(null);
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20200401));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "時効消滅後資金移動額");
    }
}
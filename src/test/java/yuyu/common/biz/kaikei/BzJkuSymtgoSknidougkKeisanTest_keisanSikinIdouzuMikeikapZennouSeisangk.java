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
 * 時効消滅後資金移動額計算クラスのメソッド {@link BzJkuSymtgoSknidougkKeisan#keisanSikinIdouzuMikeikapZennouSeisangk(String, <br />
 * BizCurrency, BizCurrency, BizCurrency, BizDateYM, BizDate, BizDate, BizCurrency, BizCurrency)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzJkuSymtgoSknidougkKeisanTest_keisanSikinIdouzuMikeikapZennouSeisangk {

    @Inject
    private BzJkuSymtgoSknidougkKeisan bzJkuSymtgoSknidougkKeisan;

    private BzJkuSymtgoSknidougkKeisanmtBean bzJkuSymtgoSknidougkKeisanmtBean;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_時効消滅後資金移動額計算";

    private final static String sheetName = "INデータ";

    private final static String syoNo5 = "17806000057";

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzJkuSymtgoSknidougkKeisanTest_keisanSikinIdouzuMikeikapZennouSeisangk.class, fileName, sheetName);
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
        BzSegmentCdSyutokuMockForKeiri.caller = BzJkuSymtgoSknidougkKeisanTest_keisanSikinIdouzuMikeikapZennouSeisangk.class;
        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = null;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.caller = BzJkuSymtgoSknidougkKeisanTest_keisanSikinIdouzuMikeikapZennouSeisangk.class;
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
    public void testKeisanSikinIdouzuMikeikapZennouSeisangk_A1() {

        BzSegmentCdSyutokuMockForKeiri.SYORIPTN = BzSegmentCdSyutokuMockForKeiri.TESTPATTERN2;
        BzSikinIdouHanteiInfoSyutokuMockForKeiri.SYORIPTN = BzSikinIdouHanteiInfoSyutokuMockForKeiri.TESTPATTERN3;

        bzJkuSymtgoSknidougkKeisanmtBean = new BzJkuSymtgoSknidougkKeisanmtBean();
        bzJkuSymtgoSknidougkKeisanmtBean.setSyono(syoNo5);
        bzJkuSymtgoSknidougkKeisanmtBean.setSyouhncd("ｱ4");
        bzJkuSymtgoSknidougkKeisanmtBean.setKyktuukasyu(C_Tuukasyu.USD);
        bzJkuSymtgoSknidougkKeisanmtBean.setHokenkngkgoukeiKyktuuka(BizCurrency.valueOf(1460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMisyuupKyktuuka(BizCurrency.valueOf(460, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankinKyktuuka(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapKyktuuka(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setMikeikapjyuutouym(BizDateYM.valueOf(202101));
        bzJkuSymtgoSknidougkKeisanmtBean.setZennouseisankijyunymd(BizDate.valueOf(20210101));
        bzJkuSymtgoSknidougkKeisanmtBean.setZitkazkrknstituka(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        bzJkuSymtgoSknidougkKeisanmtBean.setKykymd(BizDate.valueOf(20201111));

        C_ErrorKbn errorKbn = bzJkuSymtgoSknidougkKeisan.keisanJkuSymtgoSknidougk(bzJkuSymtgoSknidougkKeisanmtBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exBizCalcbleEquals(bzJkuSymtgoSknidougkKeisan.getJkuSymtgoShrjSknidougk(),
            BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR), "時効消滅後資金移動額");
    }

}
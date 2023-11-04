package yuyu.common.biz.bznayose;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.infrext.mq.MqApiCaller;
import yuyu.infrext.mq.MqApiCallerStubForSinkeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMqTest_exec2;

/**
 * PALあて契約内容反映（MQ）クラスのメソッド {@link BzKykNaiyouHaneiMq#exec(BzKykNaiyouHaneiYokenBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKykNaiyouHaneiMqTest_exec3 {

    @Inject
    BzKykNaiyouHaneiMqTest_exec1 test1;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_PALあて契約内容反映（MQ）";

    private final static String sheetName = "INデータ";

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
            }
        });
    }

    @AfterClass
    public static void testClear() {
        MqApiCallerStubForSinkeiyaku.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        MqApiCallerStubForSinkeiyaku.caller = BzKykNaiyouHaneiMqTest_exec2.class;

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzKykNaiyouHaneiMqTest_exec2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
        bizDomManager.delete(bizDomManager.getAllYoukyuuNoKanri());
    }

    @Test
    @TestOrder(010)
    public void testExec2_A15() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData4(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234567890.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(223456789000l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(3234567890.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(423456789000l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(523456789000l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(6234567890.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(723456789000l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(823456789000l, BizCurrencyTypes.YEN));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "09999999999", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "09999999999", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "09999999999", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "09999999999", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "09999999999", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "09999999999", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "09999999999", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "09999999999", "（新契約）通算用円入金額");

    }

    @Test
    @TestOrder(020)
    public void testExec2_A16() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData4(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(123456789.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(22345678900l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(323456789.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(42345678900l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(52345678900l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(623456789.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(72345678900l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(82345678900l, BizCurrencyTypes.YEN));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "09999999999", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "09999999999", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "09999999999", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "09999999999", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "09999999999", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "09999999999", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "09999999999", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "09999999999", "（新契約）通算用円入金額");

    }

    @Test
    @TestOrder(030)
    public void testExec2_A17() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData4(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(12345678.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(2234567800l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(32345678.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(4234567800l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(5234567800l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(62345678.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(7234567800l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(8234567800l, BizCurrencyTypes.YEN));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "01234567800", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "02234567800", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "03234567800", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "04234567800", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "05234567800", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "06234567800", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "07234567800", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "08234567800", "（新契約）通算用円入金額");

    }

    @Test
    @TestOrder(040)
    public void testExec2_A18() {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = MqApiCallerStubForSinkeiyaku.TESTPATTERN1;

        MockObjectManager.initialize();

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        test1.editYokenData4(bzKykNaiyouHaneiYokenBean);
        test1.editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        test1.editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        bzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234567.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(223456700l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(3234567.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(423456700l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(523456700l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(6234567.00, BizCurrencyTypes.DOLLAR));
        bzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(723456700l, BizCurrencyTypes.YEN));
        bzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(823456700l, BizCurrencyTypes.YEN));

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 0),
            "PAR2", "処理コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 2),
            "sscd001", "組織コード");
        exStringEquals((String) MockObjectManager.getArgument(MqApiCallerStubForSinkeiyaku.class, "call", 0, 3),
            "                    ", "半角スペース20桁");
        String bzKyknaiyouHanei = (String) MockObjectManager.getArgument(
            MqApiCallerStubForSinkeiyaku.class, "call", 0, 1);

        exStringEquals(bzKyknaiyouHanei.substring(44, 55), "00123456700", "（契約保全）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(55, 66), "00223456700", "（契約保全）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(66, 77), "00323456700", "（契約保全）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(102, 113), "00423456700", "（契約保全）通算用円入金額");
        exStringEquals(bzKyknaiyouHanei.substring(175, 186), "00523456700", "（新契約）通算用死亡Ｓ");
        exStringEquals(bzKyknaiyouHanei.substring(186, 197), "00623456700", "（新契約）通算用一時払Ｐ");
        exStringEquals(bzKyknaiyouHanei.substring(197, 208), "00723456700", "（新契約）通算用年金原資");
        exStringEquals(bzKyknaiyouHanei.substring(224, 235), "00823456700", "（新契約）通算用円入金額");

    }

}

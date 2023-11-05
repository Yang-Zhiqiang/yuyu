package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngaiMockForDirect;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ顧客有効契約判定のメソッド{@link DsKokyakuYuukouKeiyakuHantei#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsKokyakuYuukouKeiyakuHanteiTest_exec extends AbstractTest {

    @Inject
    private DsKokyakuYuukouKeiyakuHantei dsKokyakuYuukouKeiyakuHantei;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ顧客有効契約判定";

    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(CheckDsKaiyaku.class).to(CheckDsKaiyakuMockForDirect.class);
                bind(CheckYuuyokkngai.class).to(CheckYuuyokkngaiMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        CheckDsKaiyakuMockForDirect.caller = DsKokyakuYuukouKeiyakuHanteiTest_exec.class;
        CheckYuuyokkngaiMockForDirect.caller = DsKokyakuYuukouKeiyakuHanteiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        CheckDsKaiyakuMockForDirect.caller = null;
        CheckDsKaiyakuMockForDirect.SYORIPTN = null;
        CheckYuuyokkngaiMockForDirect.caller = null;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsKokyakuYuukouKeiyakuHanteiTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec(null);
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() throws Exception {

        MockObjectManager.initialize();

        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000017");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.ARI, "有効契約有無区分");
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakuUkeUmuChk", 0, "60806000103");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000018");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000020");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000033");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000046");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000059");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() throws Exception {

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000062");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.ARI, "有効契約有無区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() throws Exception {

        MockObjectManager.initialize();

        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN1;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000017");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakuUkeUmuChk", 0, "60806000103");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() throws Exception {

        MockObjectManager.initialize();

        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN1;
        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000075");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.ARI, "有効契約有無区分");
        MockObjectManager.assertArgumentPassed(CheckDsKaiyakuMockForDirect.class, "kaiyakuUkeUmuChk", 0, "60806000701");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() throws Exception {

        MockObjectManager.initialize();

        CheckDsKaiyakuMockForDirect.SYORIPTN = CheckDsKaiyakuMockForDirect.TESTPATTERN2;
        CheckYuuyokkngaiMockForDirect.SYORIPTN = CheckYuuyokkngaiMockForDirect.TESTPATTERN2;
        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = dsKokyakuYuukouKeiyakuHantei.exec("8000000017");
        exClassificationEquals(dsKokyakuYuukouKeiyakuHanteiBean.getYuukouKeiyakuUmuKbn(), C_UmuKbn.NONE, "有効契約有無区分");
    }
}
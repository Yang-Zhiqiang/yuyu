package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.CheckKinouModeKengen;
import yuyu.common.biz.bzcommon.CheckKinouModeKengenMockForSiharai;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.BzWorkflowInfoMockForSiharai;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険金給付金機能モード設定のメソッド{@link SiKinouModeSettei#exec()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiKinouModeSetteiTest_exec {

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private KinouMode kinouMode;

    @Inject
    AS_Kinou asKinou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金給付金機能モード設定";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzWorkflowInfo.class).to(BzWorkflowInfoMockForSiharai.class);
                bind(CheckKinouModeKengen.class).to(CheckKinouModeKengenMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzWorkflowInfoMockForSiharai.caller = SiKinouModeSetteiTest_exec.class;
        CheckKinouModeKengenMockForSiharai.caller = SiKinouModeSetteiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzWorkflowInfoMockForSiharai.caller = null;
        CheckKinouModeKengenMockForSiharai.caller = null;
        BzWorkflowInfoMockForSiharai.SYORIPTN = null;
        CheckKinouModeKengenMockForSiharai.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditRrkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager domManager = SWAKInjector.getInstance(BaseDomManager.class);
        domManager.delete(domManager.getUser("administrator1"));
        domManager.delete(domManager.getUser("administrator2"));
        domManager.delete(domManager.getUser("administrator3"));
        domManager.delete(domManager.getUser("administrator4"));
        domManager.delete(domManager.getUser("administrator5"));
        domManager.delete(domManager.getUser("administrator6"));
        domManager.delete(domManager.getUser("administrator7"));
        domManager.delete(domManager.getKinou("kinouId1"));
        domManager.delete(domManager.getKinou("kinouId2"));
        domManager.delete(domManager.getKinou("kinouId3"));
        domManager.delete(domManager.getKinou("kinouId4"));
        domManager.delete(domManager.getKinou("kinouId5"));
        domManager.delete(domManager.getKinou("kinouId6"));
        domManager.delete(domManager.getKinou("kinouId7"));
        domManager.delete(domManager.getRole("administrator1"));
        domManager.delete(domManager.getRole("administrator2"));
        domManager.delete(domManager.getRole("administrator3"));
        domManager.delete(domManager.getRole("administrator4"));
        domManager.delete(domManager.getRole("administrator5"));
        domManager.delete(domManager.getRole("administrator6"));
        domManager.delete(domManager.getRole("administrator7"));
        domManager.delete(domManager.getSubSystem("siharai"));
        domManager.delete(domManager.getCategory("sicommon"));
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzWorkflowInfoMockForSiharai.SYORIPTN = BzWorkflowInfoMockForSiharai.TESTPATTERN1;
        CheckKinouModeKengenMockForSiharai.SYORIPTN = CheckKinouModeKengenMockForSiharai.TESTPATTERN1;

        asKinou.setKinouId("kinouId1");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator1"));

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        exStringEquals(kinouMode.getKinouMode(), "kakuniniraityuu", "機能情報．機能モード");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        BzWorkflowInfoMockForSiharai.SYORIPTN = BzWorkflowInfoMockForSiharai.TESTPATTERN2;

        asKinou.setKinouId("kinouId2");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator2"));

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        exStringEquals(kinouMode.getKinouMode(), "input", "機能情報．機能モード");


    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        BzWorkflowInfoMockForSiharai.SYORIPTN = BzWorkflowInfoMockForSiharai.TESTPATTERN3;

        asKinou.setKinouId("kinouId3");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator3"));

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        exStringEquals(kinouMode.getKinouMode(), "hubitouroku", "機能情報．機能モード");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        BzWorkflowInfoMockForSiharai.SYORIPTN = BzWorkflowInfoMockForSiharai.TESTPATTERN4;

        asKinou.setKinouId("kinouId4");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator4"));

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        exStringEquals(kinouMode.getKinouMode(), "default", "機能情報．機能モード");
    }

    @Test(expected=BizAppException.class)
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        BzWorkflowInfoMockForSiharai.SYORIPTN = BzWorkflowInfoMockForSiharai.TESTPATTERN5;

        asKinou.setKinouId("kinouId5");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator5"));
        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);

        try {

            siKinouModeSettei.exec();

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "この機能を使用する権限がありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        BzWorkflowInfoMockForSiharai.SYORIPTN = BzWorkflowInfoMockForSiharai.TESTPATTERN6;

        asKinou.setKinouId("kinouId6");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator6"));

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        exStringEquals(kinouMode.getKinouMode(), "input", "機能情報．機能モード");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        BzWorkflowInfoMockForSiharai.SYORIPTN = BzWorkflowInfoMockForSiharai.TESTPATTERN7;

        asKinou.setKinouId("kinouId7");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator7"));

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        exStringEquals(kinouMode.getKinouMode(), "hubitouroku", "機能情報．機能モード");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B1() {

        asKinou.setKinouId("kinouId8");
        kinouMode.setKinouMode(null);
        changeCurrentUser(baseUserInfo, baseDomManager.getUser("administrator8"));

        SiKinouModeSettei siKinouModeSettei = SWAKInjector.getInstance(SiKinouModeSettei.class);
        siKinouModeSettei.exec();

        exStringEquals(kinouMode.getKinouMode(), "hubikaisyou", "機能情報．機能モード");
    }
}

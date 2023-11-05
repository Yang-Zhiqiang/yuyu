package yuyu.common.biz.bzcommon;

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
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.BzWorkflowInfoMockForBiz;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;
/**
 * 機能モード権限チェッククラスのメソッド {@link CheckKinouModeKengen#checkWorklistKinouModeKengen()} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckKinouModeKengenTest_checkWorklistKinouModeKengen {

    @Inject
    private KinouMode kinouMode;

    @Inject
    AS_Kinou asKinou;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private BaseUserInfo userInfo;

    @Inject
    private AS_Kinou as_kinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_機能モード権限チェック";

    private final static String sheetName = "テストデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckKinouModeKengenTest_checkWorklistKinouModeKengen.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector
            .getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllFileSyuruis());
        baseDomManager.delete(baseDomManager.getUser("usery"));
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzWorkflowInfo.class).to(BzWorkflowInfoMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzWorkflowInfoMockForBiz.caller = CheckKinouModeKengenTest_checkWorklistKinouModeKengen.class;
    }

    @AfterClass
    public static void testClear() {

        BzWorkflowInfoMockForBiz.caller = null;
        BzWorkflowInfoMockForBiz.SYORIPTN =null;
        MockObjectManager.initialize();

    }


    @Test
    @TestOrder(10)
    public void testCheckWorklistKinouModeKengen_A1() {

        MockObjectManager.initialize();
        kinouMode.setKinouMode("default");
        changeCurrentUser(userInfo, baseDomManager.getUser("usery"));
        as_kinou.setKinouId("skhubitouroku");
        BzWorkflowInfoMockForBiz.SYORIPTN = BzWorkflowInfoMockForBiz.TESTPATTERN1;

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        checkKinouModeKengen.checkWorklistKinouModeKengen();
        exStringEquals(kinouMode.getKinouMode(), "input", "機能モードID");

    }

}

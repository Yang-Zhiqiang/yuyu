package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.BzWorkflowInfoMockForBiz;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;
/**
 * 機能モード権限チェッククラスのメソッド {@link CheckKinouModeKengen#hanteiWorklistKinouModeId()} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckKinouModeKengenTest_hanteiWorklistKinouModeId {

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

        BzWorkflowInfoMockForBiz.caller = CheckKinouModeKengenTest_hanteiWorklistKinouModeId.class;

    }
    @AfterClass
    public static void testClear() {

        BzWorkflowInfoMockForBiz.caller = null;
        BzWorkflowInfoMockForBiz.SYORIPTN =null;
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testhanteiWorklistKinouModeId_A1() {

        MockObjectManager.initialize();
        BzWorkflowInfoMockForBiz.SYORIPTN = BzWorkflowInfoMockForBiz.TESTPATTERN1;

        CheckKinouModeKengen checkKinouModeKengen = SWAKInjector.getInstance(CheckKinouModeKengen.class);
        String string = checkKinouModeKengen.hanteiWorklistKinouModeId();
        exStringEquals(string, "input", "機能モードID");

    }

}

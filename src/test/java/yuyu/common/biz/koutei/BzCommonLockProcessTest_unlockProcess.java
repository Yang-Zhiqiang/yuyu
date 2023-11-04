package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 工程ロック共通処理クラスのメソッド {@link BzCommonLockProcess#unlockProcess()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzCommonLockProcessTest_unlockProcess {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzLockProcess.class).to(BzLockProcessMockForBiz.class);
                bind(BzUnlockProcess.class).to(BzUnlockProcessMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzLockProcessMockForBiz.caller = BzCommonLockProcessTest_unlockProcess.class;
        BzUnlockProcessMockForBiz.caller = BzCommonLockProcessTest_unlockProcess.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzLockProcessMockForBiz.caller = null;
        BzUnlockProcessMockForBiz.caller = null;
        BzLockProcessMockForBiz.SYORIPTN = null;
        BzUnlockProcessMockForBiz.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testUnlockProcess_A1(){
        MockObjectManager.initialize();
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;
        BzUnlockProcessMockForBiz.SYORIPTN = BzUnlockProcessMockForBiz.TESTPATTERN1;
        String pLockTsyuKouteiKanriId = "A001";
        String pLockTsyuJimuTetuzukiCd = "B001";
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(pLockTsyuKouteiKanriId, pLockTsyuJimuTetuzukiCd);
        bzCommonLockProcess.unlockProcess();
        BzCommonLockProcessBean bzCommonLockProcessBean = SWAKInjector.getInstance(BzCommonLockProcessBean.class);
        exStringEquals(bzCommonLockProcessBean.getKouteiLockKey(), "", "工程ロックキー ");
        MockObjectManager.assertArgumentPassed(BzUnlockProcessMockForBiz.class, "exec", 0, "A001");
        MockObjectManager.assertArgumentPassed(BzUnlockProcessMockForBiz.class, "exec", 1, "B001");
        MockObjectManager.assertArgumentPassed(BzUnlockProcessMockForBiz.class, "exec", 2, "kouteiLockKeyTest");
    }
}

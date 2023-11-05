package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.LockProcessException;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 工程ロック共通処理クラスのメソッド {@link BzCommonLockProcess#continueLockProcess()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzCommonLockProcessTest_continueLockProcess {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzLockProcess.class).to(BzLockProcessMockForBiz.class);
                bind(BzContinueLockProcess.class).to(BzContinueLockProcessMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzLockProcessMockForBiz.caller = BzCommonLockProcessTest_continueLockProcess.class;
        BzContinueLockProcessMockForBiz.caller = BzCommonLockProcessTest_continueLockProcess.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzLockProcessMockForBiz.caller = null;
        BzContinueLockProcessMockForBiz.caller = null;
        BzLockProcessMockForBiz.SYORIPTN = null;
        BzContinueLockProcessMockForBiz.SYORIPTN = null;
    }

    @Test(expected = LockProcessException.class)
    @TestOrder(10)
    public void testContinueLockProcess_A1() {
        MockObjectManager.initialize();
        BzContinueLockProcessMockForBiz.SYORIPTN = BzContinueLockProcessMockForBiz.TESTPATTERN2;
        try {
            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            bzCommonLockProcess.continueLockProcess();
        } catch (LockProcessException e){
            BzCommonLockProcessBean bzCommonLockProcessBean = SWAKInjector.getInstance(BzCommonLockProcessBean.class);
            exStringEquals(bzCommonLockProcessBean.getKouteiLockKey(), "", "工程ロックキー");
            exStringEquals(e.getMessage(), "工程ロックを継続することができませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testContinueLockProcess_A2() {
        MockObjectManager.initialize();
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;
        BzContinueLockProcessMockForBiz.SYORIPTN = BzContinueLockProcessMockForBiz.TESTPATTERN1;
        String pLockTsyuKouteiKanriId = "1001";
        String pLockTsyuJimuTetuzukiCd = "2001";
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(pLockTsyuKouteiKanriId, pLockTsyuJimuTetuzukiCd);
        bzCommonLockProcess.continueLockProcess();
        MockObjectManager.assertArgumentPassed(BzContinueLockProcessMockForBiz.class, "exec", 0, "1001");
        MockObjectManager.assertArgumentPassed(BzContinueLockProcessMockForBiz.class, "exec", 1, "2001");
        MockObjectManager.assertArgumentPassed(BzContinueLockProcessMockForBiz.class, "exec", 2, "testKouteiLockKey");
    }
}

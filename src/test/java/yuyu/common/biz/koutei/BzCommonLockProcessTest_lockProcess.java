package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
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
 * 工程ロック共通処理クラスのメソッド {@link BzCommonLockProcess#lockProcess(String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzCommonLockProcessTest_lockProcess {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzLockProcess.class).to(BzLockProcessMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzLockProcessMockForBiz.caller = BzCommonLockProcessTest_lockProcess.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        BzLockProcessMockForBiz.caller = null;
        BzLockProcessMockForBiz.SYORIPTN = null;
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(10)
    public void testLockProcess_A1()
    {
        MockObjectManager.initialize();
        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN1;
        String pLockTsyuKouteiKanriId = "1001";
        String pLockTsyuJimuTetuzukiCd = "2001";
        try{
            BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
            bzCommonLockProcess.lockProcess(pLockTsyuKouteiKanriId, pLockTsyuJimuTetuzukiCd);
        } catch (BizLogicException e){
            exStringEquals(e.getMessage(), "他ユーザが処理中のため処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testLockProcess_A2()
    {
        MockObjectManager.initialize();
        String pLockTsyuKouteiKanriId = "1001";
        String pLockTsyuJimuTetuzukiCd = "2001";

        BzLockProcessMockForBiz.SYORIPTN = BzLockProcessMockForBiz.TESTPATTERN2;
        BzCommonLockProcess bzCommonLockProcess = SWAKInjector.getInstance(BzCommonLockProcess.class);
        bzCommonLockProcess.lockProcess(pLockTsyuKouteiKanriId, pLockTsyuJimuTetuzukiCd);
        exStringEquals(bzCommonLockProcess.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
        MockObjectManager.assertArgumentPassed(BzCommonLockProcessBean.class, "setLockTsyuKouteiKanriId", 0, "1001");
        MockObjectManager.assertArgumentPassed(BzCommonLockProcessBean.class, "setLockTsyuJimuTetuzukiCd", 0, "2001");
    }
}

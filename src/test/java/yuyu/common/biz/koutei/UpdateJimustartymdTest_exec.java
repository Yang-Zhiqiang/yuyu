package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 事務開始日更新クラスのメソッド {@link UpdateJimustartymd#exec(String, String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class UpdateJimustartymdTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-01";
        String jimuTetuzukiCd = "001";
        String kouteiKanriId = "koutei";
        String kouteiLockKey = "10";
        String jimuStartYmd = "20150701";
        UpdateJimustartymd updateJimustartymd = SWAKInjector.getInstance(UpdateJimustartymd.class);
        updateJimustartymd.exec(jimuTetuzukiCd, kouteiKanriId, kouteiLockKey, jimuStartYmd);
        ProcessUpdateInBean processUpdateInBean = (ProcessUpdateInBean)MockObjectManager.getArgument(IwfKouteiClientMockForBiz.class, "execProcessUpdate", 0, 0);
        exStringEquals(processUpdateInBean.getGyoumukey(), "koutei", "業務キー");
        exStringEquals(processUpdateInBean.getFlowid(), "001", "業務キー");
        exStringEquals(processUpdateInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(processUpdateInBean.getLockkey(), "10", "ロックキ");
        exStringEquals(processUpdateInBean.getExtParam11().getValue(), "20150701", "追加パラメータ11");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        IwfKouteiClientMockForBiz.mode = "32-08";
        String jimuTetuzukiCd = "001";
        String kouteiKanriId = "koutei";
        String kouteiLockKey = "10";
        String jimuStartYmd = "20150701";

        try {
            UpdateJimustartymd updateJimustartymd = SWAKInjector.getInstance(UpdateJimustartymd.class);
            updateJimustartymd.exec(jimuTetuzukiCd, kouteiKanriId, kouteiLockKey, jimuStartYmd);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝事務開始日更新、API＝工程情報更新、エラーコード＝IWF0002", "エラーメッセージ");
            throw e;
        }
    }
}

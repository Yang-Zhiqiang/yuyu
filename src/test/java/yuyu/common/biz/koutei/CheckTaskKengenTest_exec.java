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
import yuyu.common.biz.workflow.io.koutei.GetExecutableTasksInBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通 工程 タスク権限チェック {@link CheckTaskKengen#exec(String, String, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTaskKengenTest_exec {

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
        IwfKouteiClientMockForBiz.caller2 = CheckTaskKengenTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller2 = null;
        IwfKouteiClientMockForBiz.mode = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1(){

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "3";

        String userId="JUnit";

        String jimuTetuzukiCd="987654321";

        String taskId="32342131";
        CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);
        boolean testBoolean=checkTaskKengen.exec(userId, jimuTetuzukiCd, taskId);

        exBooleanEquals(testBoolean,false,"権限あり）を返却する");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2(){

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "1";

        String userId="JUnit";

        String jimuTetuzukiCd="987654321";

        String taskId="32342131";

        try{
            CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);
            checkTaskKengen.exec(userId, jimuTetuzukiCd, taskId);
        }
        catch(BizAppException e){
            exStringEquals(e.getMessage(),
                "IWFエラーです。機能＝タスク権限チェック、API＝実行可能タスク情報取得、エラーコード＝IWF2070", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3(){

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "3";

        String userId="JUnit";

        String jimuTetuzukiCd="98765432";

        String taskId="3234213";

        CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);
        boolean testBoolean=checkTaskKengen.exec(userId, jimuTetuzukiCd, taskId);
        GetExecutableTasksInBean getExecutableTasksInBean = (GetExecutableTasksInBean) MockObjectManager
            .getArgument(IwfKouteiClientMockForBiz.class, "execGetExecutableTasks", 0, 0);
        exStringEquals(getExecutableTasksInBean.getAccountid(), "JUnit", "ユーザーID");

        exBooleanEquals(testBoolean,true,"権限あり）を返却する");
    }
}

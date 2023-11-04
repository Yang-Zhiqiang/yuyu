package yuyu.common.biz.syoruitoutyaku;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetExecutableTasksTest_exec;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通 書類到着 書類到着時管理情報取得呼出し処理 {@link ExecGetSyoruitoutyakuInfo#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ExecGetSyoruitoutyakuInfoTest_exec {

    @Inject
    private ExecGetSyoruitoutyakuInfo execGetSyoruitoutyakuInfo;

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
        IwfKouteiClientMockForBiz.caller2 = BzGetExecutableTasksTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller2 = null;
        IwfKouteiClientMockForBiz.mode = null;
    }

    @Test(expected= BizLogicException.class)
    @TestOrder(10)
    public void testExec_A1(){

        String toutyakuKey="MOS";

        try{
            execGetSyoruitoutyakuInfo.exec(toutyakuKey);
        }catch(BizLogicException e){
            exStringEquals(e.getMessage(),"文書IDが不正です。","文書ID");
            throw e;
        }
    }

    @Test(expected= BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2(){

        String toutyakuKey="MO-S";

        try{
            execGetSyoruitoutyakuInfo.exec(toutyakuKey);
        }catch(BizLogicException e){
            exStringEquals(e.getMessage(),"文書IDが不正です。","文書ID");
            throw e;
        }

    }

    @Test(expected = RuntimeException.class)
    @TestOrder(30)
    public void testExec_A3(){

        String toutyakuKey="MOS_1";

        try{
            execGetSyoruitoutyakuInfo.exec(toutyakuKey);
        }catch(RuntimeException e){
            exStringEquals(e.getMessage(),"文書IDが不正です。","文書ID");
            throw e;
        }

    }

}

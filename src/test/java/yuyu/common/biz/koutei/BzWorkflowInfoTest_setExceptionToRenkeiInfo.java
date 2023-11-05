package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.WorkflowRenkeiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務用ワークフロー情報クラスのメソッド{@link BzWorkflowInfoTest#setExceptionToRenkeiInfo(BizLogicException)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)

public class BzWorkflowInfoTest_setExceptionToRenkeiInfo {
    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private WorkflowRenkeiInfo workflowRenkeiInfo;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }
    @Test
    @TestOrder(10)
    public void testSetExceptionToRenkeiInfo_A1() {
        BizLogicException pBizLogicException=new  BizLogicException("This is test message");

        bzWorkflowInfo.setExceptionToRenkeiInfo(pBizLogicException);

        exStringEquals(workflowRenkeiInfo.getExceptionInstance().getMessage(), "This is test message", "例外インスタンスのメッセージ");
    }

}

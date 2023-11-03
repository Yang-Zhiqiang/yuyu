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

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.io.image.SetImageReleationInBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通イメージ関連設定のメソッド {@link BzSetImageRelation#exec(String, String[])} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzSetImageRelationTest_exec extends AbstractTest{

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfImageClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        IwfImageClientMockForBiz.caller = null;
        IwfImageClientMockForBiz.mode = null;
    }

    @Test()
    @TestOrder(10)
    public void testExec_A1() {
        IwfImageClientMockForBiz.mode = "dl01-01";
        MockObjectManager.initialize();
        String pImageId = "10000000001";
        String pSubSystemId[] = { "1" };

        BzSetImageRelation bzSetImageRelation = SWAKInjector.getInstance(BzSetImageRelation.class);
        bzSetImageRelation.exec(pImageId, pSubSystemId);
        SetImageReleationInBean continueLockProcessInBean = (SetImageReleationInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "setImageRelation", 0, 0);
        exStringEquals(continueLockProcessInBean.getImageid(), "10000000001", "イメージID");
        String[] temp = continueLockProcessInBean.getGyoumukeys();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i]);
        }
        exStringEquals(sb.toString(), "1", "業務キー配列");
        exNumericEquals(temp.length, 1, "業務キー配列");
        exStringEquals(continueLockProcessInBean.getSyorikbn(), "14", "処理区分");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        IwfImageClientMockForBiz.mode = "dl01-02";
        String pImageId = "10000000001";
        String pSubSystemId[] = { "2" };

        try {
            BzSetImageRelation bzSetImageRelation = SWAKInjector.getInstance(BzSetImageRelation.class);
            bzSetImageRelation.exec(pImageId, pSubSystemId);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "IWFエラーです。機能＝業務共通イメージ関連設定、API＝イメージ関連設定、エラーコード＝IWF0001",
                "エラーメッセージ");
            throw e;
        }
    }
}

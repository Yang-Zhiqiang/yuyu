package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.io.image.DropImageInBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通イメージ削除クラスのメソッド {@link BzDropImage#exec(BzDropImageInputBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzDropImageTest_exec {

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
        IwfImageClientMockForBiz.caller = null;
        IwfImageClientMockForBiz.mode = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "23-07";

        BzDropImageInputBean bzDropImageInputBean = SWAKInjector.getInstance(BzDropImageInputBean.class);
        bzDropImageInputBean.setImageId("wf001");
        bzDropImageInputBean.setUserId("9001");

        BzDropImage bzDropImage = SWAKInjector.getInstance(BzDropImage.class);
        BzDropImageOutputBean bzDropImageOutputBean = bzDropImage.exec(bzDropImageInputBean);

        exStringEquals(bzDropImageOutputBean.getKekkaStatus(), null, "処理結果ステータス");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsgCd(), "IWF0002", "詳細メッセージコード");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsg(), "必須入力チェックエラー１", "詳細メッセージ");

        DropImageInBean dropImageInBean = (DropImageInBean) MockObjectManager.getArgument(IwfImageClientMockForBiz.class,
            "execDropImage", 0, 0);
        exStringEquals(dropImageInBean.getImageids()[0], "wf001", "イメージＩＤ配列");
        exStringEquals(dropImageInBean.getAccountid(), "9001", "アカウントＩＤ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "23-08";

        BzDropImageInputBean bzDropImageInputBean = SWAKInjector.getInstance(BzDropImageInputBean.class);
        bzDropImageInputBean.setImageId("wf002");
        bzDropImageInputBean.setUserId("9002");

        BzDropImage bzDropImage = SWAKInjector.getInstance(BzDropImage.class);
        BzDropImageOutputBean bzDropImageOutputBean = bzDropImage.exec(bzDropImageInputBean);

        exStringEquals(bzDropImageOutputBean.getKekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsgCd(), "IWF0002", "詳細メッセージコード");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsg(), "必須入力チェックエラー２", "詳細メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "23-09";

        BzDropImageInputBean bzDropImageInputBean = SWAKInjector.getInstance(BzDropImageInputBean.class);
        bzDropImageInputBean.setImageId("wf001");
        bzDropImageInputBean.setUserId("9001");

        BzDropImage bzDropImage = SWAKInjector.getInstance(BzDropImage.class);
        BzDropImageOutputBean bzDropImageOutputBean = bzDropImage.exec(bzDropImageInputBean);

        exStringEquals(bzDropImageOutputBean.getKekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsgCd(), "IWF3073", "詳細メッセージコード");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsg(), "必須入力チェックエラー３", "詳細メッセージ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "23-10";

        BzDropImageInputBean bzDropImageInputBean = SWAKInjector.getInstance(BzDropImageInputBean.class);
        bzDropImageInputBean.setImageId("wf001");
        bzDropImageInputBean.setUserId("9001");

        BzDropImage bzDropImage = SWAKInjector.getInstance(BzDropImage.class);
        BzDropImageOutputBean bzDropImageOutputBean = bzDropImage.exec(bzDropImageInputBean);

        exStringEquals(bzDropImageOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsgCd(), "IWF3073", "詳細メッセージコード");
        exStringEquals(bzDropImageOutputBean.getSyousaiMsg(), "必須入力チェックエラー４", "詳細メッセージ");
    }
}

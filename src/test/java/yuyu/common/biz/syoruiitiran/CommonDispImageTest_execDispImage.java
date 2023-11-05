package yuyu.common.biz.syoruiitiran;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通 書類情報一覧 イメージ表示共通のメソッド {@link CommonDispImage#execDispImage(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CommonDispImageTest_execDispImage {

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
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

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExecDispImage_A1() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "dl01-01";
        String pImageid = "10010";

        baseUserInfo.getUser().setUserId("JUnit");

        try {

            commonDispImage.execDispImage(pImageid);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。イメージ表示処理が正常終了しませんでした。", "エラーメッセージ");

            GetImageInBean getImageInBean = (GetImageInBean)MockObjectManager.getArgument(IwfImageClientMockForBiz.class, "execGetImage", 0, 0);
            exNumericEquals(getImageInBean.getImageids().length, 1, "イメージＩＤ配列の件数");
            exStringEquals(getImageInBean.getImageids()[0], "10010", "イメージＩＤ配列");
            exStringEquals(getImageInBean.getAccountid(), "JUnit", "アカウントＩＤ");
            throw e;
        }

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExecDispImage_A2() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "dl01-02";
        String pImageid = "10010";

        try {

            commonDispImage.execDispImage(pImageid);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "対象の書類は既に削除されています。", "エラーメッセージ");
            throw e;
        }

    }


}

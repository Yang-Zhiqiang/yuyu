package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForBiz;
import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通イメージ登録クラスのメソッド {@link BzPutImage#exec(BzPutImageInputBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzPutImageTest_exec {

    @Inject
    private BzPutImage bzPutImage;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(IwfImageClient.class).to(IwfImageClientMockForBiz.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfImageClientMockForBiz.caller = "Test";
        BzGetProcessSummaryMockForBiz.caller = BzPutImageTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMockForBiz.caller = null;
        IwfImageClientMockForBiz.mode = null;
        BzGetProcessSummaryMockForBiz.caller = null;
        BzGetProcessSummaryMockForBiz.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "22-01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;

        BzPutImageInputBean pBzPutImageInputBean = SWAKInjector.getInstance(BzPutImageInputBean.class);
        pBzPutImageInputBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzPutImageInputBean.setUserId("");
        pBzPutImageInputBean.setImageDatas(new byte[] { 1 });
        pBzPutImageInputBean.setKouteiKanriId("9002");
        pBzPutImageInputBean.setSyoruiTtykYmdTime("20160711222299999");
        pBzPutImageInputBean.setTourokuYmdTime("20150711222299999");

        BzPutImageOutputBean bzPutImageOutputBean = bzPutImage.exec(pBzPutImageInputBean);

        exStringEquals(bzPutImageOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsgCd(), null, "詳細メッセージコード");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsg(), null, "詳細メッセージ");
        exStringEquals(bzPutImageOutputBean.getImageId(), "ImageId01", "イメージID");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForBiz.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "9002", "工程管理ID");

        PutImageInBean putImageInBean = (PutImageInBean) MockObjectManager.getArgument(IwfImageClientMockForBiz.class,
            "execPutImage", 0, 0);
        exStringEquals(putImageInBean.getSyoruicd(), "wf001", "書類コード");
        exStringEquals(putImageInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(putImageInBean.getFlowid(), "nknkshr", "フローID");
        exNumericEquals(putImageInBean.getImagedata().length, 1, "イメージデータのサイズ");
        exNumericEquals(putImageInBean.getImagedata()[0], 1, "イメージデータの要素１");
        exStringEquals(putImageInBean.getGyoumukey(), "9002", "業務キー");
        exStringEquals(putImageInBean.getSyoruitoutyakutime(), "20160711222299999", "書類到着日時");
        exStringEquals(putImageInBean.getTourokutime(), "20150711222299999", "登録日時");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "22-11";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;

        BzPutImageInputBean pBzPutImageInputBean = SWAKInjector.getInstance(BzPutImageInputBean.class);
        pBzPutImageInputBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzPutImageInputBean.setUserId(null);
        pBzPutImageInputBean.setImageDatas(new byte[] { 1 });
        pBzPutImageInputBean.setKouteiKanriId("9002");
        pBzPutImageInputBean.setSyoruiTtykYmdTime("20160811222299999");
        pBzPutImageInputBean.setTourokuYmdTime("20150811222299999");

        BzPutImageOutputBean bzPutImageOutputBean = bzPutImage.exec(pBzPutImageInputBean);

        exStringEquals(bzPutImageOutputBean.getKekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsgCd(), "IWF3092", "詳細メッセージコード");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsg(), "取込書類マスタのレコードが取得できませんでした。", "詳細メッセージ");
        exStringEquals(bzPutImageOutputBean.getImageId(), "", "イメージID");

        PutImageInBean putImageInBean = (PutImageInBean) MockObjectManager.getArgument(IwfImageClientMockForBiz.class,
            "execPutImage", 0, 0);
        exStringEquals(putImageInBean.getSyoruicd(), "wf001", "書類コード");
        exStringEquals(putImageInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(putImageInBean.getFlowid(), "nknkshr", "フローID");
        exNumericEquals(putImageInBean.getImagedata().length, 1, "イメージデータのサイズ");
        exNumericEquals(putImageInBean.getImagedata()[0], 1, "イメージデータの要素１");
        exStringEquals(putImageInBean.getGyoumukey(), "9002", "業務キー");
        exStringEquals(putImageInBean.getSyoruitoutyakutime(), "20160811222299999", "書類到着日時");
        exStringEquals(putImageInBean.getTourokutime(), "20150811222299999", "登録日時");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "22-01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN1;

        BzPutImageInputBean pBzPutImageInputBean = SWAKInjector.getInstance(BzPutImageInputBean.class);
        pBzPutImageInputBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzPutImageInputBean.setUserId("user01");
        pBzPutImageInputBean.setImageDatas(new byte[] { 1 });
        pBzPutImageInputBean.setKouteiKanriId("9002");
        pBzPutImageInputBean.setSyoruiTtykYmdTime("20160911222299999");
        pBzPutImageInputBean.setTourokuYmdTime("20150911222299999");

        BzPutImageOutputBean bzPutImageOutputBean = bzPutImage.exec(pBzPutImageInputBean);

        exStringEquals(bzPutImageOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsgCd(), null, "詳細メッセージコード");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsg(), null, "詳細メッセージ");
        exStringEquals(bzPutImageOutputBean.getImageId(), "ImageId01", "イメージID");

        PutImageInBean putImageInBean = (PutImageInBean) MockObjectManager.getArgument(IwfImageClientMockForBiz.class,
            "execPutImage", 0, 0);
        exStringEquals(putImageInBean.getSyoruicd(), "wf001", "書類コード");
        exStringEquals(putImageInBean.getAccountid(), "user01", "アカウントID");
        exStringEquals(putImageInBean.getFlowid(), "nknkshr", "フローID");
        exNumericEquals(putImageInBean.getImagedata().length, 1, "イメージデータのサイズ");
        exNumericEquals(putImageInBean.getImagedata()[0], 1, "イメージデータの要素１");
        exStringEquals(putImageInBean.getGyoumukey(), "9002", "業務キー");
        exStringEquals(putImageInBean.getSyoruitoutyakutime(), "20160911222299999", "書類到着日時");
        exStringEquals(putImageInBean.getTourokutime(), "20150911222299999", "登録日時");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "22-01";
        BzGetProcessSummaryMockForBiz.SYORIPTN = BzGetProcessSummaryMockForBiz.TESTPATTERN2;

        BzPutImageInputBean pBzPutImageInputBean = SWAKInjector.getInstance(BzPutImageInputBean.class);
        pBzPutImageInputBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzPutImageInputBean.setUserId("user01");
        pBzPutImageInputBean.setImageDatas(new byte[] { 1 });
        pBzPutImageInputBean.setKouteiKanriId("9006");
        pBzPutImageInputBean.setSyoruiTtykYmdTime("20161011222299999");
        pBzPutImageInputBean.setTourokuYmdTime("20151011222299999");

        BzPutImageOutputBean bzPutImageOutputBean = bzPutImage.exec(pBzPutImageInputBean);

        exStringEquals(bzPutImageOutputBean.getKekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsgCd(), null, "詳細メッセージコード");
        exStringEquals(bzPutImageOutputBean.getSyousaiMsg(), null, "詳細メッセージ");
        exStringEquals(bzPutImageOutputBean.getImageId(), null, "イメージID");
    }
}

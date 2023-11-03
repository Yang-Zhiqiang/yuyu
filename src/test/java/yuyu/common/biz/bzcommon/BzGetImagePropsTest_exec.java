package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfImageClient;
import yuyu.common.biz.workflow.IwfImageClientMockForBiz;
import yuyu.common.biz.workflow.io.image.GetImagePropsInBean;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通イメージプロパティ取得クラスのメソッド {@link BzGetImageProps#exec(BzGetImagePropsInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetImagePropsTest_exec {

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
        IwfImageClientMockForBiz.mode = null;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.caller =null;
        IwfImageClientMockForBiz.mode =null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-27";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd(null);
        pBzGetImagePropsInBean.setKouteiKanriId(null);
        pBzGetImagePropsInBean.setSyoruiCd(null);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom(null);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo(null);
        pBzGetImagePropsInBean.setKouteiKanriStatus(null);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0002", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "必須入力チェックエラー。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 0, "件数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), null, "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), null, "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), null, "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), null, "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), null, "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), null, "工程状況");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-28";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd("");
        pBzGetImagePropsInBean.setKouteiKanriId("");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo("");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.BLNK);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 0, "件数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), null, "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), null, "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "0", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), null, "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), null, "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "0", "工程状況");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-28";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd(" ");
        pBzGetImagePropsInBean.setKouteiKanriId(" ");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom(" ");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo(" ");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.BLNK);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 0, "件数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), null, "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), null, "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "0", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), null, "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), null, "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "0", "工程状況");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-28";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd("　");
        pBzGetImagePropsInBean.setKouteiKanriId("　");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("　");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo("　");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.BLNK);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 0, "件数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), null, "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), null, "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "0", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), null, "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), null, "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "0", "工程状況");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-24";
        BzGetImagePropsInBean pBzGetImagePropsInBean = new BzGetImagePropsInBean();
        pBzGetImagePropsInBean.setJimuTetuzukiCd("1000001");
        pBzGetImagePropsInBean.setKouteiKanriId("9001");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("20160111151630111");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo("");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 1, "件数");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getImageId(), "ImageId01", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriId(), "GyoumuKey01", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime(), "20160111151630111", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getPageCount(), "1", "取込PDFのページ数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), "1000001", "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), "9001", "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "wf001", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), "20160111151630111", "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), "99999999999999999", "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "10", "工程状況");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-24";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd("1000002");
        pBzGetImagePropsInBean.setKouteiKanriId("9002");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("20160111151630111");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo(" ");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 1, "件数");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getImageId(), "ImageId01", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriId(), "GyoumuKey01", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime(), "20160111151630111", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getPageCount(), "1", "取込PDFのページ数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), "1000002", "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), "9002", "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "wf001", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), "20160111151630111", "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), "99999999999999999", "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "10", "工程状況");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-24";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd("1000003");
        pBzGetImagePropsInBean.setKouteiKanriId("9003");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("20160111151630111");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo("　");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 1, "件数");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getImageId(), "ImageId01", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriId(), "GyoumuKey01", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime(), "20160111151630111", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getPageCount(), "1", "取込PDFのページ数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), "1000003", "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), "9003", "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "wf001", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), "20160111151630111", "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), "99999999999999999", "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "10", "工程状況");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-25";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd("1000004");
        pBzGetImagePropsInBean.setKouteiKanriId("9004");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("20160111151630111");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo("20160229102556222");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 2, "件数");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getImageId(), "ImageId01", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriId(), "GyoumuKey01", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime(), "20160112132005333", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getPageCount(), "1", "取込PDFのページ数");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getImageId(), "ImageId02", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getKouteiKanriId(), "GyoumuKey02", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(1).getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getSyoruiTtykYmdTime(), "20160113082650444", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(1).getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getPageCount(), "2", "取込PDFのページ数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID ");
        exStringEquals(getImagePropsInBean.getFlowid(), "1000004", "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), "9004", "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "wf001", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), "20160111151630111", "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), "20160229102556222", "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "10", "工程状況");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-26";
        BzGetImagePropsInBean pBzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        pBzGetImagePropsInBean.setJimuTetuzukiCd("1000005");
        pBzGetImagePropsInBean.setKouteiKanriId("9005");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo("20160229102556222");
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 3, "件数");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getImageId(), "ImageId01", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriId(), "GyoumuKey01", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime(), "20160227102556000", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getPageCount(), "1", "取込PDFのページ数");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getImageId(), "ImageId02", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getKouteiKanriId(), "GyoumuKey02", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(1).getSyoruiCd(), null, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getSyoruiTtykYmdTime(), "20160228102556111", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(1).getKouteiKanriStatus(), null, "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(1).getPageCount(), "2", "取込PDFのページ数");
        exStringEquals(bzGetImagePropsBeanLst.get(2).getImageId(), "ImageId03", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(2).getKouteiKanriId(), "GyoumuKey03", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(2).getSyoruiCd(), null, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(2).getSyoruiTtykYmdTime(), "20160229102556222", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(2).getKouteiKanriStatus(), null, "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(2).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(2).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(2).getPageCount(), "3", "取込PDFのページ数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID ");
        exStringEquals(getImagePropsInBean.getFlowid(), "1000005", "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), "9005", "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "wf001", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), "00000000000000000", "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), "20160229102556222", "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "10", "工程状況");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();
        IwfImageClientMockForBiz.mode = "20-24";
        BzGetImagePropsInBean pBzGetImagePropsInBean = new BzGetImagePropsInBean();
        pBzGetImagePropsInBean.setJimuTetuzukiCd("1000006");
        pBzGetImagePropsInBean.setKouteiKanriId("9006");
        pBzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom("20160111151630111");
        pBzGetImagePropsInBean.setSyoruiTtykYmdTimeTo(null);
        pBzGetImagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);
        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(pBzGetImagePropsInBean);
        exStringEquals(bzGetImagePropsOutBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetImagePropsOutBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();
        exNumericEquals(bzGetImagePropsBeanLst.size(), 1, "件数");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getImageId(), "ImageId01", "イメージＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriId(), "GyoumuKey01", "工程管理ID");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getSyoruiTtykYmdTime(), "20160111151630111", "書類到着日時");
        exClassificationEquals(bzGetImagePropsBeanLst.get(0).getKouteiKanriStatus(), C_Kouteikanristatus.SYORITYUU,
            "工程管理状況");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getTourokuAccountId(), "test", "登録アカウントＩＤ");
        exStringEquals(bzGetImagePropsBeanLst.get(0).getPageCount(), "1", "取込PDFのページ数");
        GetImagePropsInBean getImagePropsInBean = (GetImagePropsInBean) MockObjectManager.getArgument(
            IwfImageClientMockForBiz.class, "execGetImageProps", 0, 0);
        exStringEquals(getImagePropsInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(getImagePropsInBean.getFlowid(), "1000006", "フローID");
        exStringEquals(getImagePropsInBean.getGyoumukey(), "9006", "業務キー");
        exStringEquals(getImagePropsInBean.getTorikomisyoruicd(), "wf001", "取込書類コード");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdfrom(), "20160111151630111", "書類到着日時(自)");
        exStringEquals(getImagePropsInBean.getSyoruitoutyakuymdto(), "99999999999999999", "書類到着日時(至)");
        exStringEquals(getImagePropsInBean.getKouteijyoutai(), "10", "工程状況");
    }
}

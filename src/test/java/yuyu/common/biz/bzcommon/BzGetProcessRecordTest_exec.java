package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程履歴取得クラスのメソッド {@link BzGetProcessRecord#exec(BzGetProcessRecordInputBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetProcessRecordTest_exec {

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-01";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        assertNull(bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst());
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-02";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        exNumericEquals(bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().size(), 0, "業務共通工程履歴取得Beanリスト件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-03";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        BzGetProcessRecordBean bzGetProcessRecordBean = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(0);
        exStringEquals(bzGetProcessRecordBean.getSyoriTime(), "20160311", "処理日時");
        exStringEquals(bzGetProcessRecordBean.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean.getIwfSyoriKbn(), C_IwfSyoriKbn.NEW, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean.getRirekiKbn(), C_RirekiKbn.SYSTEM, "履歴区分");
        exStringEquals(bzGetProcessRecordBean.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-04";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        BzGetProcessRecordBean bzGetProcessRecordBean = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(0);
        exStringEquals(bzGetProcessRecordBean.getSyoriTime(), "20160311", "処理日時");
        exStringEquals(bzGetProcessRecordBean.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean.getIwfSyoriKbn(), C_IwfSyoriKbn.NEW, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean.getRirekiKbn(), C_RirekiKbn.SYSTEM, "履歴区分");
        exStringEquals(bzGetProcessRecordBean.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A5() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-05";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        BzGetProcessRecordBean bzGetProcessRecordBean1 = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(0);
        exStringEquals(bzGetProcessRecordBean1.getSyoriTime(), "20160311", "処理日時");
        exStringEquals(bzGetProcessRecordBean1.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean1.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean1.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean1.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean1.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean1.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean1.getIwfSyoriKbn(), C_IwfSyoriKbn.NEW, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean1.getRirekiKbn(), C_RirekiKbn.SYSTEM, "履歴区分");
        exStringEquals(bzGetProcessRecordBean1.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean1.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        BzGetProcessRecordBean bzGetProcessRecordBean2 = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(1);
        exStringEquals(bzGetProcessRecordBean2.getSyoriTime(), "20160312", "処理日時");
        exStringEquals(bzGetProcessRecordBean2.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean2.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean2.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean2.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean2.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean2.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean2.getIwfSyoriKbn(), C_IwfSyoriKbn.NEW, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean2.getRirekiKbn(), C_RirekiKbn.SYSTEM, "履歴区分");
        exStringEquals(bzGetProcessRecordBean2.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean2.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
        BzGetProcessRecordBean bzGetProcessRecordBean3 = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(2);
        exStringEquals(bzGetProcessRecordBean3.getSyoriTime(), "20160313", "処理日時");
        exStringEquals(bzGetProcessRecordBean3.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean3.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean3.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean3.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean3.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean3.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean3.getIwfSyoriKbn(), C_IwfSyoriKbn.NEW, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean3.getRirekiKbn(), C_RirekiKbn.SYSTEM, "履歴区分");
        exStringEquals(bzGetProcessRecordBean3.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean3.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU, "処理結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-06";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        BzGetProcessRecordBean bzGetProcessRecordBean = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(0);
        exStringEquals(bzGetProcessRecordBean.getSyoriTime(), "20160311", "処理日時");
        exStringEquals(bzGetProcessRecordBean.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean.getIwfSyoriKbn(), C_IwfSyoriKbn.NEW, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean.getRirekiKbn(), C_RirekiKbn.SYSTEM, "履歴区分");
        exStringEquals(bzGetProcessRecordBean.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A7() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-07";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        BzGetProcessRecordBean bzGetProcessRecordBean = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(0);
        exStringEquals(bzGetProcessRecordBean.getSyoriTime(), "20160311", "処理日時");
        exStringEquals(bzGetProcessRecordBean.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean.getIwfSyoriKbn(), null, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean.getRirekiKbn(), null, "履歴区分");
        exStringEquals(bzGetProcessRecordBean.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A8() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-08";
        String pJimuTetuzukiCd = "2001";
        String pKouteiKanriId = "1001";
        BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);
        bzGetProcessRecordInputBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzGetProcessRecordInputBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.SYSTEM);
        BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
        BzGetProcessRecordOutputBean bzGetProcessRecordOutputBean = bzGetProcessRecord.exec(bzGetProcessRecordInputBean);
        exStringEquals(bzGetProcessRecordOutputBean.getKekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsgCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(bzGetProcessRecordOutputBean.getSyousaiMsg(), "正常終了しました。", "詳細メッセージ");
        GetProcessRecordInBean getProcessRecordInBean = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(getProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(getProcessRecordInBean.getRirekikbn(), "0", "履歴区分");
        BzGetProcessRecordBean bzGetProcessRecordBean = bzGetProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst().get(0);
        exStringEquals(bzGetProcessRecordBean.getSyoriTime(), "20160311", "処理日時");
        exStringEquals(bzGetProcessRecordBean.getKouteiKanriId(), "01", "工程管理ID");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukicd(), "02", "事務手続コード");
        exStringEquals(bzGetProcessRecordBean.getJimutetuzukinm(), "fName", "事務手続名 ");
        exStringEquals(bzGetProcessRecordBean.getTasknmId(), "nName", "タスク名ID");
        exStringEquals(bzGetProcessRecordBean.getTasknm(), "nlName", "タスク名");
        exStringEquals(bzGetProcessRecordBean.getUserId(), "03", "ユーザーID");
        exClassificationEquals(bzGetProcessRecordBean.getIwfSyoriKbn(), null, "Iwf処理区分");
        exClassificationEquals(bzGetProcessRecordBean.getRirekiKbn(), null, "履歴区分");
        exStringEquals(bzGetProcessRecordBean.getRirekiMessage(), "rirekiMessage", "履歴メッセージ");
        exClassificationEquals(bzGetProcessRecordBean.getSyorikekkaKbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");
    }
}

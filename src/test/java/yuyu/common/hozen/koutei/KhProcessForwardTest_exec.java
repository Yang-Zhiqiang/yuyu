package yuyu.common.hozen.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryMock_KhProcessForward;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.BzProcessForwardMock_KhProcessForward;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMock_KhProcessForward;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約保全工程遷移クラスのメソッド {@link KhProcessForward#exec(String, String, String, String, KhRuleBean)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KhProcessForwardTest_exec {

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    BaseUserInfo baseUserInfo;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzProcessForward.class).to(BzProcessForwardMock_KhProcessForward.class);
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMock_KhProcessForward.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMock_KhProcessForward.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzProcessForwardMock_KhProcessForward.caller = KhProcessForwardTest_exec.class;
        BzGetProcessSummaryMock_KhProcessForward.caller = KhProcessForwardTest_exec.class;

        IwfKouteiClientMock_KhProcessForward.caller = "Test";
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        BzProcessForwardMock_KhProcessForward.caller = null;
        BzGetProcessSummaryMock_KhProcessForward.caller = null;

        IwfKouteiClientMock_KhProcessForward.caller = null;
        BzProcessForwardMock_KhProcessForward.SYORIPTN = null;
        BzGetProcessSummaryMock_KhProcessForward.SYORIPTN = null;
        IwfKouteiClientMock_KhProcessForward.mode = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzProcessForwardMock_KhProcessForward.SYORIPTN = BzProcessForwardMock_KhProcessForward.TESTPATTERN1;
        BzGetProcessSummaryMock_KhProcessForward.SYORIPTN = BzGetProcessSummaryMock_KhProcessForward.TESTPATTERN1;
        IwfKouteiClientMock_KhProcessForward.mode = "dl-01";

        String kouteiKanriId = "101";
        String jimuTetuzukiCd = "102";
        String kouteiLockKey = "103";
        String syoriComment = "コメント";

        KhRuleBean khRuleBean = new KhRuleBean();

        khRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HORYUU);
        khRuleBean.setSaiwariateUserId("UserId001");
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.NYUURYOKU);
        khRuleBean.setKyuukouzaAnnaiKbn(C_KyuukouzaAnnaiKbn.KYUUKOUZAANNAI);
        khRuleBean.setAuthorijkKbn(C_AuthorijkKbn.IRAIMATI);

        AM_User aMUser = new AM_User();

        aMUser.setUserId("administrator1");
        changeCurrentUser(baseUserInfo, aMUser);

        KhProcessForward forward = SWAKInjector.getInstance(KhProcessForward.class);
        forward.exec(kouteiKanriId, jimuTetuzukiCd, kouteiLockKey, syoriComment, khRuleBean);

        BzProcessForwardInBean bean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMock_KhProcessForward.class, "exec", 0, 0);
        exStringEquals(bean.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bean.getJimuTetuzukiCd(), "102", "事務手続コード");
        exStringEquals(bean.getKouteiLockKey(), "103", "工程ロックキー");
        exStringEquals(bean.getSyoriComment(), "コメント", "処理コメント");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSyoriKekkaKbnNaiyou(), "保留", "処理結果区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSasimodosisakiKbnNaiyou(), "入力", "差戻し先区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getKyuukouzaAnnaiKbnNaiyou(), "旧口座案内", "旧口座案内区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getAuthorijkKbnNaiyou(), "オーソリ依頼待ち", "オーソリ状況区分内容");
        exClassificationEquals(bean.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exStringEquals(bean.getSaiwariateUserId(), "administrator1", "再割当ユーザーID");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzProcessForwardMock_KhProcessForward.SYORIPTN = BzProcessForwardMock_KhProcessForward.TESTPATTERN1;
        BzGetProcessSummaryMock_KhProcessForward.SYORIPTN = BzGetProcessSummaryMock_KhProcessForward.TESTPATTERN1;
        IwfKouteiClientMock_KhProcessForward.mode = "dl-01";

        String kouteiKanriId = "101";
        String jimuTetuzukiCd = "102";
        String kouteiLockKey = "103";
        String syoriComment = "コメント";

        KhRuleBean khRuleBean = new KhRuleBean();

        khRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.TENSOU);
        khRuleBean.setSaiwariateUserId("UserId002");
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.TENKEN);
        khRuleBean.setKyuukouzaAnnaiKbn(C_KyuukouzaAnnaiKbn.BLNK);
        khRuleBean.setAuthorijkKbn(C_AuthorijkKbn.HUYOU);

        KhProcessForward forward = SWAKInjector.getInstance(KhProcessForward.class);
        forward.exec(kouteiKanriId, jimuTetuzukiCd, kouteiLockKey, syoriComment, khRuleBean);

        BzProcessForwardInBean bean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMock_KhProcessForward.class, "exec", 0, 0);
        exStringEquals(bean.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bean.getJimuTetuzukiCd(), "102", "事務手続コード");
        exStringEquals(bean.getKouteiLockKey(), "103", "工程ロックキー");
        exStringEquals(bean.getSyoriComment(), "コメント", "処理コメント");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSyoriKekkaKbnNaiyou(), "転送", "処理結果区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSasimodosisakiKbnNaiyou(), "点検", "差戻し先区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getKyuukouzaAnnaiKbnNaiyou(), "旧口座案内なし", "旧口座案内区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getAuthorijkKbnNaiyou(), "オーソリ不要", "オーソリ状況区分内容");
        exClassificationEquals(bean.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU, "処理結果区分");
        exStringEquals(bean.getSaiwariateUserId(), "UserId002", "再割当ユーザーID");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzProcessForwardMock_KhProcessForward.SYORIPTN = BzProcessForwardMock_KhProcessForward.TESTPATTERN1;
        BzGetProcessSummaryMock_KhProcessForward.SYORIPTN = BzGetProcessSummaryMock_KhProcessForward.TESTPATTERN1;
        IwfKouteiClientMock_KhProcessForward.mode = "dl-01";

        String kouteiKanriId = "101";
        String jimuTetuzukiCd = "102";
        String kouteiLockKey = "103";
        String syoriComment = "コメント";

        KhRuleBean khRuleBean = new KhRuleBean();

        khRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUBI);
        khRuleBean.setSaiwariateUserId("UserId003");
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.BLNK);
        khRuleBean.setKyuukouzaAnnaiKbn(C_KyuukouzaAnnaiKbn.BLNK);
        khRuleBean.setAuthorijkKbn(C_AuthorijkKbn.HUYOU);

        KhProcessForward forward = SWAKInjector.getInstance(KhProcessForward.class);
        forward.exec(kouteiKanriId, jimuTetuzukiCd, kouteiLockKey, syoriComment, khRuleBean);

        BzProcessForwardInBean bean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMock_KhProcessForward.class, "exec", 0, 0);
        exStringEquals(bean.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bean.getJimuTetuzukiCd(), "102", "事務手続コード");
        exStringEquals(bean.getKouteiLockKey(), "103", "工程ロックキー");
        exStringEquals(bean.getSyoriComment(), "コメント", "処理コメント");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSyoriKekkaKbnNaiyou(), "不備", "処理結果区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSasimodosisakiKbnNaiyou(), "", "差戻し先区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getKyuukouzaAnnaiKbnNaiyou(), "旧口座案内なし", "旧口座案内区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getAuthorijkKbnNaiyou(), "オーソリ不要", "オーソリ状況区分内容");
        exClassificationEquals(bean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUBI, "処理結果区分");
        exStringEquals(bean.getSaiwariateUserId(), "", "再割当ユーザーID");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzProcessForwardMock_KhProcessForward.SYORIPTN = BzProcessForwardMock_KhProcessForward.TESTPATTERN1;
        BzGetProcessSummaryMock_KhProcessForward.SYORIPTN = BzGetProcessSummaryMock_KhProcessForward.TESTPATTERN1;
        IwfKouteiClientMock_KhProcessForward.mode = "dl-01";

        String kouteiKanriId = "101";
        String jimuTetuzukiCd = "102";
        String kouteiLockKey = "103";
        String syoriComment = "コメント";

        KhRuleBean khRuleBean = new KhRuleBean();

        khRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HORYUU);
        khRuleBean.setSaiwariateUserId("UserId004");
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.BLNK);
        khRuleBean.setKyuukouzaAnnaiKbn(C_KyuukouzaAnnaiKbn.BLNK);
        khRuleBean.setAuthorijkKbn(C_AuthorijkKbn.HUYOU);

        AM_User aMUser = new AM_User();

        aMUser.setUserId("administrator4");
        changeCurrentUser(baseUserInfo, aMUser);

        KhProcessForward forward = SWAKInjector.getInstance(KhProcessForward.class);
        forward.exec(kouteiKanriId, jimuTetuzukiCd, kouteiLockKey, syoriComment, khRuleBean);

        BzProcessForwardInBean bean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMock_KhProcessForward.class, "exec", 0, 0);
        exStringEquals(bean.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bean.getJimuTetuzukiCd(), "102", "事務手続コード");
        exStringEquals(bean.getKouteiLockKey(), "103", "工程ロックキー");
        exStringEquals(bean.getSyoriComment(), "コメント", "処理コメント");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSyoriKekkaKbnNaiyou(), "保留", "処理結果区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSasimodosisakiKbnNaiyou(), "", "差戻し先区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getKyuukouzaAnnaiKbnNaiyou(), "旧口座案内なし", "旧口座案内区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getAuthorijkKbnNaiyou(), "オーソリ不要", "オーソリ状況区分内容");
        exClassificationEquals(bean.getSyorikekkaKbn(), C_SyorikekkaKbn.HORYUU, "処理結果区分");
        exStringEquals(bean.getSaiwariateUserId(), "administrator4", "再割当ユーザーID");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzProcessForwardMock_KhProcessForward.SYORIPTN = BzProcessForwardMock_KhProcessForward.TESTPATTERN1;
        BzGetProcessSummaryMock_KhProcessForward.SYORIPTN = BzGetProcessSummaryMock_KhProcessForward.TESTPATTERN1;
        IwfKouteiClientMock_KhProcessForward.mode = "dl-01";

        String kouteiKanriId = "101";
        String jimuTetuzukiCd = "102";
        String kouteiLockKey = "103";
        String syoriComment = "コメント";

        KhRuleBean khRuleBean = new KhRuleBean();

        khRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.TENSOU);
        khRuleBean.setSaiwariateUserId("UserId005");
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.BLNK);
        khRuleBean.setKyuukouzaAnnaiKbn(C_KyuukouzaAnnaiKbn.BLNK);
        khRuleBean.setAuthorijkKbn(C_AuthorijkKbn.HUYOU);

        KhProcessForward forward = SWAKInjector.getInstance(KhProcessForward.class);
        forward.exec(kouteiKanriId, jimuTetuzukiCd, kouteiLockKey, syoriComment, khRuleBean);

        BzProcessForwardInBean bean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMock_KhProcessForward.class, "exec", 0, 0);
        exStringEquals(bean.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bean.getJimuTetuzukiCd(), "102", "事務手続コード");
        exStringEquals(bean.getKouteiLockKey(), "103", "工程ロックキー");
        exStringEquals(bean.getSyoriComment(), "コメント", "処理コメント");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSyoriKekkaKbnNaiyou(), "転送", "処理結果区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSasimodosisakiKbnNaiyou(), "", "差戻し先区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getKyuukouzaAnnaiKbnNaiyou(), "旧口座案内なし", "旧口座案内区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getAuthorijkKbnNaiyou(), "オーソリ不要", "オーソリ状況区分内容");
        exClassificationEquals(bean.getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU, "処理結果区分");
        exStringEquals(bean.getSaiwariateUserId(), "UserId005", "再割当ユーザーID");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        BzProcessForwardMock_KhProcessForward.SYORIPTN = BzProcessForwardMock_KhProcessForward.TESTPATTERN1;
        BzGetProcessSummaryMock_KhProcessForward.SYORIPTN = BzGetProcessSummaryMock_KhProcessForward.TESTPATTERN1;
        IwfKouteiClientMock_KhProcessForward.mode = "dl-01";

        String kouteiKanriId = "101";
        String jimuTetuzukiCd = "102";
        String kouteiLockKey = "103";
        String syoriComment = "コメント";

        KhRuleBean khRuleBean = new KhRuleBean();

        khRuleBean.setSyoriKekkaKbn(C_SyorikekkaKbn.HUSYOUNIN);
        khRuleBean.setSaiwariateUserId("UserId006");
        khRuleBean.setSasimodosisakiKbn(C_SasimodosisakiKbn.BLNK);
        khRuleBean.setKyuukouzaAnnaiKbn(C_KyuukouzaAnnaiKbn.BLNK);
        khRuleBean.setAuthorijkKbn(C_AuthorijkKbn.HUYOU);

        KhProcessForward forward = SWAKInjector.getInstance(KhProcessForward.class);
        forward.exec(kouteiKanriId, jimuTetuzukiCd, kouteiLockKey, syoriComment, khRuleBean);

        BzProcessForwardInBean bean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForwardMock_KhProcessForward.class, "exec", 0, 0);
        exStringEquals(bean.getKouteiKanriId(), "101", "工程管理ID");
        exStringEquals(bean.getJimuTetuzukiCd(), "102", "事務手続コード");
        exStringEquals(bean.getKouteiLockKey(), "103", "工程ロックキー");
        exStringEquals(bean.getSyoriComment(), "コメント", "処理コメント");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSyoriKekkaKbnNaiyou(), "不承認", "処理結果区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getSasimodosisakiKbnNaiyou(), "", "差戻し先区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getKyuukouzaAnnaiKbnNaiyou(), "旧口座案内なし", "旧口座案内区分内容");
        exStringEquals(((KhIwfApiRuleBean)bean.getIwfApiRuleBean()).getAuthorijkKbnNaiyou(), "オーソリ不要", "オーソリ状況区分内容");
        exClassificationEquals(bean.getSyorikekkaKbn(), C_SyorikekkaKbn.HUSYOUNIN, "処理結果区分");
        exStringEquals(bean.getSaiwariateUserId(), "", "再割当ユーザーID");
    }
}

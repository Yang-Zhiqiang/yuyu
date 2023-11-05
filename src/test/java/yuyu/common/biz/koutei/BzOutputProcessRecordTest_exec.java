package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程履歴出力クラスのメソッド {@link BzOutputProcessRecord#exec(String, String, String, String,C_SyorikekkaKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzOutputProcessRecordTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT_SP_単体テスト仕様書_業務共通工程履歴出力";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzOutputProcessRecordTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllCategories());
        baseDomManager.delete(baseDomManager.getAllSubSystems());
    }

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
    public static void testInit() {
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "dl-01";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pSyoriComment = "3001";
        String pTaskName = "4001";
        C_SyorikekkaKbn pSyorikekkaKbn = C_SyorikekkaKbn.BLNK;

        AM_User aMUser = new AM_User();
        aMUser.setUserId("JUnit");
        changeCurrentUser(baseUserInfo, aMUser);

        BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
        bzOutputProcessRecord.exec(pKouteiKanriId, pJimuTetuzukiCd, pSyoriComment, pTaskName, pSyorikekkaKbn);
        CreateProcessRecordInBean createProcessRecordInBean = (CreateProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClient.class, "execCcreateProcessRecord", 0, 0);
        exStringEquals(createProcessRecordInBean.getGyoumukey(), "1001", "業務キー");
        exStringEquals(createProcessRecordInBean.getFlowid(), "2001", "フローID");
        exStringEquals(createProcessRecordInBean.getAccountid(), "JUnit", "アカウントID");
        exStringEquals(createProcessRecordInBean.getRirekimsg(), "3001", "履歴メッセージ");
        exStringEquals(createProcessRecordInBean.getTaskname(), "4001", "タスク名");
        exStringEquals(
            createProcessRecordInBean.getExtInfo().get(0).get(BzIwfUtilConstants.API_EXTINFO_KEY_SYORIKEKKAKBN),
            String.valueOf(C_SyorikekkaKbn.BLNK), "付加情報");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        IwfKouteiClientMockForBiz.mode = "16-12";
        String pKouteiKanriId = "1001";
        String pJimuTetuzukiCd = "2001";
        String pSyoriComment = "3001";
        String pTaskName = "4001";
        C_SyorikekkaKbn pSyorikekkaKbn = C_SyorikekkaKbn.BLNK;

        try {
            BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
            bzOutputProcessRecord.exec(pKouteiKanriId, pJimuTetuzukiCd, pSyoriComment, pTaskName, pSyorikekkaKbn);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程履歴出力、API＝工程履歴作成、エラーコード＝IWF0000", "エラーメッセージ");
            throw e;
        }
    }
}

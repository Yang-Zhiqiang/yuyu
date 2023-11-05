package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfoMock;
import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(事務用コード登録)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest32 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【32_事務用コード登録】_000_01";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest32.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Before
    public  void caseInit() {
        IwfKouteiClientMock.caller = "Test";
        GetSyoriKokouteiInfoMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfKouteiClientMock.caller = null;
        GetSyoriKokouteiInfoMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("hijklmn1"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("hijklmn2"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("hijklmn3"));
        bizDomManager.delete(bizDomManager.getGyoumuKouteiInfo("hijklmn4"));
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testPutJimuyouCd_Case01(){

        IwfKouteiClientMock.mode = "32-01";

        List<PutJimuyouCdBean> putJimuyouCdBeanLst = new ArrayList<>();

        PutJimuyouCdBean putJimuyouCdBean1 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean1.setKouteiKnrId("hijklmn1");
        putJimuyouCdBean1.setJimuyouCd("123");

        PutJimuyouCdBean putJimuyouCdBean2 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean2.setKouteiKnrId("hijklmn2");
        putJimuyouCdBean2.setJimuyouCd("456");

        putJimuyouCdBeanLst.add(putJimuyouCdBean1);
        putJimuyouCdBeanLst.add(putJimuyouCdBean2);

        PutJimuyouCdResultBean ret = WorkFlowUtility.putJimuyouCd(
            "0001",
            "UserId01" ,
            putJimuyouCdBeanLst);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました。", "詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "GetProcessSummary", "エラー発生API名");
    }

    @Test
    @TestOrder(20)
    public void testPutJimuyouCd_Case02(){

        IwfKouteiClientMock.mode = "32-02";

        List<PutJimuyouCdBean> putJimuyouCdBeanLst = new ArrayList<>();

        PutJimuyouCdBean putJimuyouCdBean1 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean1.setKouteiKnrId("hijklmn1");
        putJimuyouCdBean1.setJimuyouCd("123");

        PutJimuyouCdBean putJimuyouCdBean2 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean2.setKouteiKnrId("hijklmn2");
        putJimuyouCdBean2.setJimuyouCd("456");

        putJimuyouCdBeanLst.add(putJimuyouCdBean1);
        putJimuyouCdBeanLst.add(putJimuyouCdBean2);

        PutJimuyouCdResultBean ret = WorkFlowUtility.putJimuyouCd(
            "0001",
            "UserId01" ,
            putJimuyouCdBeanLst);

        exStringEquals(ret.getSyorikekkaStatus(), "-9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF2091", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "必須入力チェックエラー。", "詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "LockProcess", "エラー発生API名");
        exStringEquals(ret.getLockGyoumuKeyBean().getMosNo(), "12345678901", "ロック中業務キー項目Bean.申込番号");
        exStringEquals(ret.getLockGyoumuKeyBean().getSyoNo(), "SyoNo01", "ロック中業務キー項目Bean.証券番号");
        exStringEquals(ret.getLockGyoumuKeyBean().getNkSysyNo(), "NkSysyNo01", "ロック中業務キー項目Bean.年金証書番号");
    }

    @Test
    @TestOrder(30)
    public void testPutJimuyouCd_Case03(){

        IwfKouteiClientMock.mode = "32-03";

        List<PutJimuyouCdBean> putJimuyouCdBeanLst = new ArrayList<>();

        PutJimuyouCdBean putJimuyouCdBean1 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean1.setKouteiKnrId("hijklmn1");
        putJimuyouCdBean1.setJimuyouCd("123");

        PutJimuyouCdBean putJimuyouCdBean2 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean2.setKouteiKnrId("hijklmn2");
        putJimuyouCdBean2.setJimuyouCd("456");

        putJimuyouCdBeanLst.add(putJimuyouCdBean1);
        putJimuyouCdBeanLst.add(putJimuyouCdBean2);

        PutJimuyouCdResultBean ret = WorkFlowUtility.putJimuyouCd(
            "0001",
            "UserId01" ,
            putJimuyouCdBeanLst);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "異常終了しました。", "詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "LockProcess", "エラー発生API名");
    }

    @Test
    @TestOrder(40)
    public void testPutJimuyouCd_Case04(){

        IwfKouteiClientMock.mode = "32-04";

        List<PutJimuyouCdBean> putJimuyouCdBeanLst = new ArrayList<>();

        PutJimuyouCdBean putJimuyouCdBean1 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean1.setKouteiKnrId("hijklmn1");
        putJimuyouCdBean1.setJimuyouCd("123");

        PutJimuyouCdBean putJimuyouCdBean2 = SWAKInjector.getInstance(PutJimuyouCdBean.class);
        putJimuyouCdBean2.setKouteiKnrId("hijklmn2");
        putJimuyouCdBean2.setJimuyouCd("456");

        putJimuyouCdBeanLst.add(putJimuyouCdBean1);
        putJimuyouCdBeanLst.add(putJimuyouCdBean2);

        PutJimuyouCdResultBean ret = WorkFlowUtility.putJimuyouCd(
            "0001",
            "UserId01" ,
            putJimuyouCdBeanLst);

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "必須入力チェックエラー。", "詳細メッセージ");
        exStringEquals(ret.getErrorApiName(), "ProcessUpdate", "エラー発生API名");
    }
}
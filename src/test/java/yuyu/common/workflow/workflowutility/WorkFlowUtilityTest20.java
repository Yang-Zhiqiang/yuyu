package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティ(イメージプロパティ取得)単体テストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class WorkFlowUtilityTest20 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【20_イメージ一覧取得】_000_01";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest20.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Before
    public  void caseInit() {
        IwfImageClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfImageClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "common");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0002", "common");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0003", "common");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0004", "common");

        workflowDomManager.delete(data);

        AM_User user1 = baseDomManager.getUser("UserId01");

        baseDomManager.delete(user1);

        AM_User user2 = baseDomManager.getUser("UserId02");

        baseDomManager.delete(user2);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_HYOUSI);

        bizDomManager.delete(torikomiSyoruiHukaInfo);

        torikomiSyoruiHukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_QRSEAL);

        bizDomManager.delete(torikomiSyoruiHukaInfo);
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetImageProps_Case1(){

        IwfImageClientMock.mode = "20-01";

        GetImagePropsListResultBean ret = WorkFlowUtility.getImagePropsList(
            "common",
            null,
            null ,
            "860000017",
            "17806000013",
            "17807000016",
            "wf001",
            "20150101020304005",
            null,
            "10");

        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0002", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "必須入力チェックエラー", "詳細メッセージ");
    }

    @Test
    @TestOrder(20)
    public void testGetImageProps_Case2(){

        IwfImageClientMock.mode = "20-02";

        GetImagePropsListResultBean ret = WorkFlowUtility.getImagePropsList(
            "common",
            null,
            new String[] {"0005", "0006", "0007"} ,
            null,
            null,
            null,
            null,
            null,
            null,
            null);

        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(30)
    public void testGetImageProps_Case3(){

        IwfImageClientMock.mode = "20-03";

        GetImagePropsListResultBean ret = WorkFlowUtility.getImagePropsList(
            "common",
            "test",
            new String[] {"0001", "0002", "0003"} ,
            "860000017",
            "17806000013",
            "17807000016",
            "wf001",
            null,
            "20150101020304005",
            "10");

        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        exStringEquals(ret.getImagePropsBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(ret.getImagePropsBeanList().get(0).getJimutetuzukiNm(), "事務１", "事務手続名");
        exStringEquals(ret.getImagePropsBeanList().get(0).getImageId(), "Imageid01", "イメージID");
        exStringEquals(ret.getImagePropsBeanList().get(0).getMosNo(), "860000017", "申込番号");
        exStringEquals(ret.getImagePropsBeanList().get(0).getSyoNo(), "17806000013", "証券番号");
        exStringEquals(ret.getImagePropsBeanList().get(0).getNkSysyNo(), "17807000016", "年金証書番号");
        exStringEquals(ret.getImagePropsBeanList().get(0).getTorikomiSyoruiCd(), "wf001", "取込書類コード");
        exStringEquals(ret.getImagePropsBeanList().get(0).getDispTorikomiSyoruiNm(), "取込用表紙０１", "(表示用)取込書類名");
        exStringEquals(ret.getImagePropsBeanList().get(0).getSyoruiTtykYmdTime(), "20160715120103", "書類到着日時");
        exStringEquals(ret.getImagePropsBeanList().get(0).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(0).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(0).getKengenUmu(), "1", "権限有無");
        exStringEquals(ret.getImagePropsBeanList().get(0).getTourokuUserNm(), "ユーザー名０１", "登録者");
        exStringEquals(ret.getImagePropsBeanList().get(0).getSyoruiTorikomiHouKbn(), "5", "書類取込方法区分");

        exStringEquals(ret.getImagePropsBeanList().get(1).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(ret.getImagePropsBeanList().get(1).getJimutetuzukiNm(), "事務２", "事務手続名");
        exStringEquals(ret.getImagePropsBeanList().get(1).getImageId(), "Imageid02", "イメージID");
        exStringEquals(ret.getImagePropsBeanList().get(1).getMosNo(), "860000016", "申込番号");
        exStringEquals(ret.getImagePropsBeanList().get(1).getSyoNo(), "17806000012", "証券番号");
        exStringEquals(ret.getImagePropsBeanList().get(1).getNkSysyNo(), "17807000017", "年金証書番号");
        exStringEquals(ret.getImagePropsBeanList().get(1).getTorikomiSyoruiCd(), "wf002", "取込書類コード");
        exStringEquals(ret.getImagePropsBeanList().get(1).getDispTorikomiSyoruiNm(), "取込用表紙０２", "(表示用)取込書類名");
        exStringEquals(ret.getImagePropsBeanList().get(1).getSyoruiTtykYmdTime(), "20160716120103", "書類到着日時");
        exStringEquals(ret.getImagePropsBeanList().get(1).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(1).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(1).getKengenUmu(), "1", "権限有無");
        exStringEquals(ret.getImagePropsBeanList().get(1).getTourokuUserNm(), "ユーザー名０２", "登録者");
        exStringEquals(ret.getImagePropsBeanList().get(1).getSyoruiTorikomiHouKbn(), "6", "書類取込方法区分");

        exStringEquals(ret.getImagePropsBeanList().get(2).getJimutetuzukiCd(), "0004", "事務手続コード");
        exStringEquals(ret.getImagePropsBeanList().get(2).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getImagePropsBeanList().get(2).getImageId(), "Imageid04", "イメージID");
        exStringEquals(ret.getImagePropsBeanList().get(2).getMosNo(), "860000019", "申込番号");
        exStringEquals(ret.getImagePropsBeanList().get(2).getSyoNo(), "17806000015", "証券番号");
        exStringEquals(ret.getImagePropsBeanList().get(2).getNkSysyNo(), "17807000018", "年金証書番号");
        exStringEquals(ret.getImagePropsBeanList().get(2).getTorikomiSyoruiCd(), "Ba001", "取込書類コード");
        exStringEquals(ret.getImagePropsBeanList().get(2).getDispTorikomiSyoruiNm(), null, "(表示用)取込書類名");
        exStringEquals(ret.getImagePropsBeanList().get(2).getSyoruiTtykYmdTime(), "20160714120103", "書類到着日時");
        exStringEquals(ret.getImagePropsBeanList().get(2).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(2).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(2).getKengenUmu(), "1", "権限有無");
        exStringEquals(ret.getImagePropsBeanList().get(2).getTourokuUserNm(), null, "登録者");
        exStringEquals(ret.getImagePropsBeanList().get(2).getSyoruiTorikomiHouKbn(), null, "書類取込方法区分");

        exStringEquals(ret.getImagePropsBeanList().get(3).getJimutetuzukiCd(), "0005", "事務手続コード");
        exStringEquals(ret.getImagePropsBeanList().get(3).getJimutetuzukiNm(), null, "事務手続名");
        exStringEquals(ret.getImagePropsBeanList().get(3).getImageId(), "Imageid05", "イメージID");
        exStringEquals(ret.getImagePropsBeanList().get(3).getMosNo(), "860000019", "申込番号");
        exStringEquals(ret.getImagePropsBeanList().get(3).getSyoNo(), "17806000015", "証券番号");
        exStringEquals(ret.getImagePropsBeanList().get(3).getNkSysyNo(), "17807000018", "年金証書番号");
        exStringEquals(ret.getImagePropsBeanList().get(3).getTorikomiSyoruiCd(), "Bb003", "取込書類コード");
        exStringEquals(ret.getImagePropsBeanList().get(3).getDispTorikomiSyoruiNm(), null, "(表示用)取込書類名");
        exStringEquals(ret.getImagePropsBeanList().get(3).getSyoruiTtykYmdTime(), "20160714120103", "書類到着日時");
        exStringEquals(ret.getImagePropsBeanList().get(3).getKouteiStatus(), "10", "工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(3).getDispKouteiStatus(), "処理中", "(表示用)工程状態");
        exStringEquals(ret.getImagePropsBeanList().get(3).getKengenUmu(), "1", "権限有無");
        exStringEquals(ret.getImagePropsBeanList().get(3).getTourokuUserNm(), null, "登録者");
        exStringEquals(ret.getImagePropsBeanList().get(3).getSyoruiTorikomiHouKbn(), null, "書類取込方法区分");
    }
}
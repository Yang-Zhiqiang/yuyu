package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.workflow.IwfAccountClientMock;
import yuyu.common.biz.workflow.IwfImageClientMock;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.workflow.configuration.YuyuWorkflowConfig;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;


/**
 * ワークフロー呼出ユーティリティ(取込書類マスタ取得(権限情報付加))単体テストクラスです。
 */
public class WorkFlowUtilityTest33 extends AbstractTest {

    private final static String fileName = "UT_SP_単体テスト仕様書_【33_取込書類マスタ取得(権限情報付加)】_000_01";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WorkFlowUtilityTest33.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @Before
    public  void caseInit() {
        IwfAccountClientMock.caller = "Test";
        IwfImageClientMock.caller = "Test";
        YuyuWorkflowConfig config = YuyuWorkflowConfig.getInstance();
        config.setWorkflowStubMode(false);
    }

    @AfterClass
    public static void testClear() {
        IwfAccountClientMock.caller = null;
        IwfImageClientMock.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        DM_Jimutetuzuki data = workflowDomManager.getJimutetuzuki("0001", "hozen");

        workflowDomManager.delete(data);

        data = workflowDomManager.getJimutetuzuki("0002", "hozen");

        workflowDomManager.delete(data);

        BM_TorikomiSyoruiHukaInfo fukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_HYOUSI);
        bizDomManager.delete(fukaInfo);

        fukaInfo = bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_QRSEAL);
        bizDomManager.delete(fukaInfo);

        AM_User user1 = baseDomManager.getUser("UserId01");

        baseDomManager.delete(user1);

        AM_User user2 = baseDomManager.getUser("UserId02");

        baseDomManager.delete(user2);

        AM_Role role1 = baseDomManager.getRole("001");
        baseDomManager.delete(role1);

        AM_Role role2 = baseDomManager.getRole("002");
        baseDomManager.delete(role2);

        AM_Role role3 = baseDomManager.getRole("003");
        baseDomManager.delete(role3);
    }

    @After
    public  void caseTerminat() {
    }

    @Test
    @TestOrder(10)
    public void testGetTorikomiSyoruiMstAndKengen_Case01() {

        IwfAccountClientMock.mode = "33-01";
        IwfImageClientMock.mode = "33-01";

        GetTorikomiSyoruiMstAndKengenResultBean result =
            WorkFlowUtility.getTorikomiSyoruiMstAndKengen(new String[] {"0001","0002","0003"}, "UserId01");

        exStringEquals(result.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(result.getSyousaiMessageCd(), "IWF9004", "詳細メッセージコード");
        exStringEquals(result.getSyousaiMessage(), "データ整合性エラー。", "詳細メッセージ");
    }

    @Test
    @TestOrder(20)
    public void testGetTorikomiSyoruiMstAndKengen_Case02() {

        IwfAccountClientMock.mode = "33-02";
        IwfImageClientMock.mode = "33-02";

        GetTorikomiSyoruiMstAndKengenResultBean result =
            WorkFlowUtility.getTorikomiSyoruiMstAndKengen(new String[] {"0001","0002","0003"}, "UserId01");

        exStringEquals(result.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(result.getSyousaiMessageCd(), "IWF0003", "詳細メッセージコード");
        exStringEquals(result.getSyousaiMessage(), "稼働時間外エラーか、認証エラーが発生しました。", "詳細メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testGetTorikomiSyoruiMstAndKengen_Case03() {

        IwfAccountClientMock.mode = "33-03";
        IwfImageClientMock.mode = "33-03";

        GetTorikomiSyoruiMstAndKengenResultBean result =
            WorkFlowUtility.getTorikomiSyoruiMstAndKengen(new String[] {"0001","0002","0003"}, "UserId01");

        exStringEquals(result.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }

    @Test
    @TestOrder(40)
    public void testGetTorikomiSyoruiMstAndKengen_Case04() {

        IwfAccountClientMock.mode = "33-04";
        IwfImageClientMock.mode = "33-04";

        GetTorikomiSyoruiMstAndKengenResultBean result =
            WorkFlowUtility.getTorikomiSyoruiMstAndKengen(new String[] {"0001","0002"}, "UserId01");

        exStringEquals(result.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(result.getSyousaiMessageCd(), "IWF0000", "詳細メッセージコード");
        exStringEquals(result.getSyousaiMessage(), "正常終了しました。", "詳細メッセージ");

        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getSyoruiCd(), "wf001", "取込書類コード");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getSyoruiNm(), "取込用表紙", "取込書類名");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getSyoruiRyakuNm(), "取込表紙", "取込書類略称");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getSyzkSyouBunruiId(), "syobun01", "所属小分類ID");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getSyzkDaiBunruiId(), "daibun01", "所属大分類ID");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getJimutetuzukiCd(), "0001", "事務手続コード");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getZipHozonKbn(), "z01", "ZIP保存区分");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getKouteiSeigyoUmuKbn(), "k01", "工程制御有無区分");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getTaskNm(), "住所変更請求書作成", "タスク名");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(0).getKengenUmu(), "1", "権限有無");

        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getSyoruiCd(), "hz002", "取込書類コード");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getSyoruiNm(), "取込用表紙", "取込書類名");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getSyoruiRyakuNm(), "取込表紙", "取込書類略称");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getSyzkSyouBunruiId(), "syobun01", "所属小分類ID");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getSyzkDaiBunruiId(), "daibun01", "所属大分類ID");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getJimutetuzukiCd(), "0002", "事務手続コード");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getZipHozonKbn(), "z01", "ZIP保存区分");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getKouteiSeigyoUmuKbn(), "k01", "工程制御有無区分");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getTaskNm(), "名義変更請求書作成", "タスク名");
        exStringEquals(result.getTorikomiSyoruiMstAndKengenBeanList().get(1).getKengenUmu(), "0", "権限有無");
    }

    @Test
    @TestOrder(50)
    public void testGetTorikomiSyoruiMstAndKengen_Case05() {

        IwfAccountClientMock.mode = "33-05";

        GetTorikomiSyoruiMstAndKengenResultBean result =
            WorkFlowUtility.getTorikomiSyoruiMstAndKengen(null, "UserId02");

        exStringEquals(result.getSyorikekkaStatus(), "-1", "処理結果ステータス");
    }
}

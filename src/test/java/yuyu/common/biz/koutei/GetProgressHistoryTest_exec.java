package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.GetProcessRecordInBean;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 進捗履歴情報取得クラスのメソッド {@link GetProgressHistory#exec(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetProgressHistoryTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_進捗履歴情報取得";

    private final static String sheetName = "INデータ";

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
    public static void testInit(){
        IwfKouteiClientMockForBiz.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller = null;
        IwfKouteiClientMockForBiz.mode = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetProgressHistoryTest_exec.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        baseDomManager.delete(baseDomManager.getAllUsers());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        GetProgressHistory getProgressHistory= SWAKInjector.getInstance(GetProgressHistory.class);

        String kouteiKanriId = "ktkrId1001";

        List<GetProgressHistoryOutBean> getProgressHistoryOutBean = getProgressHistory.exec(kouteiKanriId);

        exNumericEquals(getProgressHistoryOutBean.size(), 0, "進捗履歴情報取得出力Beanリストの件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        MockObjectManager.initialize();

        IwfKouteiClientMockForBiz.mode = "17-13";

        GetProgressHistory getProgressHistory= SWAKInjector.getInstance(GetProgressHistory.class);

        String kouteiKanriId = "ktkrId1002";

        List<GetProgressHistoryOutBean> getProgressHistoryOutBean = getProgressHistory.exec(kouteiKanriId);

        GetProcessRecordInBean getProcessRecordInBean1 = (GetProcessRecordInBean) MockObjectManager
            .getArgument(IwfKouteiClientMockForBiz.class, "execGetProcessRecord", 0, 0);
        exStringEquals(getProcessRecordInBean1.getGyoumukey(), "ktkrId1008", "業務キー");
        exStringEquals(getProcessRecordInBean1.getRirekikbn(), "1", "履歴区分");

        exNumericEquals(getProgressHistoryOutBean.size(), 1, "進捗履歴情報取得出力Beanリストの件数");
        exStringEquals(getProgressHistoryOutBean.get(0).getSyoriTime(), "20150101", "（進捗履歴情報表示）処理日");
        exStringEquals(getProgressHistoryOutBean.get(0).getTaskName(), "TASK1", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(getProgressHistoryOutBean.get(0).getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU,
            "（進捗履歴情報表示）処理結果区分");
        exStringEquals(getProgressHistoryOutBean.get(0).getTantousyaName(), "Ｕｓｅｒ１", "（進捗履歴情報表示）操作者名");
        exStringEquals(getProgressHistoryOutBean.get(0).getComment(), "コメント１", "（進捗履歴情報表示）コメント");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        IwfKouteiClientMockForBiz.mode = "17-14";

        GetProgressHistory getProgressHistory= SWAKInjector.getInstance(GetProgressHistory.class);

        String kouteiKanriId = "ktkrId1002";

        try {
            getProgressHistory.exec(kouteiKanriId);
        }
        catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "IWFエラーです。機能＝業務共通進捗履歴情報取得、API＝工程履歴取得、エラーコード＝EBS0008",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        IwfKouteiClientMockForBiz.mode = "17-15";
        GetProgressHistory getProgressHistory= SWAKInjector.getInstance(GetProgressHistory.class);

        String kouteiKanriId = "ktkrId1003";

        List<GetProgressHistoryOutBean> getProgressHistoryOutBean = getProgressHistory.exec(kouteiKanriId);

        exNumericEquals(getProgressHistoryOutBean.size(), 4, "進捗履歴情報取得出力Beanリストの件数");
        exStringEquals(getProgressHistoryOutBean.get(0).getSyoriTime(), "20151201", "（進捗履歴情報表示）処理日");
        exStringEquals(getProgressHistoryOutBean.get(0).getTaskName(), "TASK1", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(getProgressHistoryOutBean.get(0).getSyorikekkaKbn(), null, "（進捗履歴情報表示）処理結果区分");
        exStringEquals(getProgressHistoryOutBean.get(0).getTantousyaName(), "Ｕｓｅｒ１", "（進捗履歴情報表示）操作者名");
        exStringEquals(getProgressHistoryOutBean.get(0).getComment(), "コメント１", "（進捗履歴情報表示）コメント");
        exStringEquals(getProgressHistoryOutBean.get(1).getSyoriTime(), "20151101", "（進捗履歴情報表示）処理日");
        exStringEquals(getProgressHistoryOutBean.get(1).getTaskName(), "TASK2", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(getProgressHistoryOutBean.get(1).getSyorikekkaKbn(), null, "（進捗履歴情報表示）処理結果区分");
        exStringEquals(getProgressHistoryOutBean.get(1).getTantousyaName(), "Ｕｓｅｒ２", "（進捗履歴情報表示）操作者名");
        exStringEquals(getProgressHistoryOutBean.get(1).getComment(), "コメント２", "（進捗履歴情報表示）コメント");
        exStringEquals(getProgressHistoryOutBean.get(2).getSyoriTime(), "20151001", "（進捗履歴情報表示）処理日");
        exStringEquals(getProgressHistoryOutBean.get(2).getTaskName(), "TASK3", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(getProgressHistoryOutBean.get(2).getSyorikekkaKbn(), C_SyorikekkaKbn.TENSOU,
            "（進捗履歴情報表示）処理結果区分");
        exStringEquals(getProgressHistoryOutBean.get(2).getTantousyaName(), "Ｕｓｅｒ３", "（進捗履歴情報表示）操作者名");
        exStringEquals(getProgressHistoryOutBean.get(2).getComment(), "コメント３", "（進捗履歴情報表示）コメント");
        exStringEquals(getProgressHistoryOutBean.get(3).getSyoriTime(), "20150901", "（進捗履歴情報表示）処理日");
        exStringEquals(getProgressHistoryOutBean.get(3).getTaskName(), "TASK4", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(getProgressHistoryOutBean.get(3).getSyorikekkaKbn(), C_SyorikekkaKbn.SASIMODOSI,
            "（進捗履歴情報表示）処理結果区分");
        exStringEquals(getProgressHistoryOutBean.get(3).getTantousyaName(), "Ｕｓｅｒ４", "（進捗履歴情報表示）操作者名");
        exStringEquals(getProgressHistoryOutBean.get(3).getComment(), "コメント４", "（進捗履歴情報表示）コメント");
    }
}

package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 進捗履歴情報設定クラスのメソッド {@link SetProgressHistory#exec(SetProgressHistoryExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetProgressHistoryTest_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetProgressHistory.class).to(GetProgressHistoryMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        GetProgressHistoryMockForBiz.caller = SetProgressHistoryTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        GetProgressHistoryMockForBiz.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        SetProgressHistoryExecUiBeanParamImpl uiBean = SWAKInjector.getInstance(SetProgressHistoryExecUiBeanParamImpl.class);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId("");
        uiBean.getBzWorkflowInfo().setKouteiKanriId("ProgressId");

        setProgressHistory.exec(uiBean);

        exNumericEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().size(), 0, "進捗履歴情報データソース情報リストの件数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        SetProgressHistoryExecUiBeanParamImpl uiBean = SWAKInjector.getInstance(SetProgressHistoryExecUiBeanParamImpl.class);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId("ParProgressId");
        uiBean.getBzWorkflowInfo().setKouteiKanriId("ProgressId");

        setProgressHistory.exec(uiBean);

        exNumericEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().size(), 1, "進捗履歴情報データソース情報リストの件数");
        exDateEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispsyoriymd(), BizDate.valueOf(20160201), "（進捗履歴情報表示）処理日");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdisptasknm(), "TASK名0", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispsyorikekkakbn(), C_SyorikekkaKbn.TENSOU, "（進捗履歴情報表示）処理結果区分");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispsousasyanm(), "User0", "（進捗履歴情報表示）操作者名");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispcomment(), "コメント０", "（進捗履歴情報表示）コメント");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
        SetProgressHistoryExecUiBeanParamImpl uiBean = SWAKInjector.getInstance(SetProgressHistoryExecUiBeanParamImpl.class);

        uiBean.getBzWorkflowInfo().setOyaKouteiKanriId("ParProgressId2");
        uiBean.getBzWorkflowInfo().setKouteiKanriId("ProgressId");

        setProgressHistory.exec(uiBean);

        exNumericEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().size(), 3, "進捗履歴情報データソース情報リストの件数");
        exDateEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispsyoriymd(), BizDate.valueOf(20160203), "（進捗履歴情報表示）処理日");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdisptasknm(), "TASK名0", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispsyorikekkakbn(), C_SyorikekkaKbn.TENSOU, "（進捗履歴情報表示）処理結果区分");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispsousasyanm(), "User0", "（進捗履歴情報表示）操作者名");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(0).getVprghsdispcomment(), "コメント０", "（進捗履歴情報表示）コメント");
        exDateEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(1).getVprghsdispsyoriymd(), BizDate.valueOf(20160202), "（進捗履歴情報表示）処理日");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(1).getVprghsdisptasknm(), "TASK名1", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(1).getVprghsdispsyorikekkakbn(), C_SyorikekkaKbn.HORYUU, "（進捗履歴情報表示）処理結果区分");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(1).getVprghsdispsousasyanm(), "User1", "（進捗履歴情報表示）操作者名");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(1).getVprghsdispcomment(), "コメント１", "（進捗履歴情報表示）コメント");
        exDateEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(2).getVprghsdispsyoriymd(), BizDate.valueOf(20160201), "（進捗履歴情報表示）処理日");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(2).getVprghsdisptasknm(), "TASK名2", "（進捗履歴情報表示）タスク名");
        exClassificationEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(2).getVprghsdispsyorikekkakbn(), C_SyorikekkaKbn.SASIMODOSI, "（進捗履歴情報表示）処理結果区分");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(2).getVprghsdispsousasyanm(), "User2", "（進捗履歴情報表示）操作者名");
        exStringEquals(uiBean.getProgressHistoryDataSourceBeanCommonParamLst().get(2).getVprghsdispcomment(), "コメント２", "（進捗履歴情報表示）コメント");
    }
}

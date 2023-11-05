package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.CreateTaskSummaryInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCancelOutBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateOutBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskOutBean;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_TaskSummary;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummary;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryRequest;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary.WSCreateTaskSummaryResponse;
import yuyu.testinfr.TestOrder;

/**
 * タスク件数サマリ作成Webサービスの {@link WSCreateTaskSummary#executeBizMain(WSCreateTaskSummaryRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CreateTaskSummaryWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    IwfCoreDomManager iwfCoreDomManager;

    @Test
    @TestOrder(1)
    public void testValidationNG01() {
        try {
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(null);

        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                assertTrue(true);
            } else {
                e.printStackTrace();
                assertTrue(false);
            }
        }
    }

    @Test
    @TestOrder(2)
    public void testValidationOK01() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);
            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setGyoumukey("業務キー1_2");
            befProcessCreateInBean.setFlowid("09");
            befProcessCreateInBean.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            StartTaskInBean befStartTaskInBean = new StartTaskInBean();
            befStartTaskInBean.setGyoumukey("業務キー1_2");
            befStartTaskInBean.setFlowid("09");
            befStartTaskInBean.setAccountid("Tt");
            befStartTaskInBean.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
                throw new Exception("前処理：タスク開始実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            createTaskSummaryInBean.setSFlowids(null);
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            boolean result = true;
            result = result && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF0000".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setGyoumukey("業務キー1_2");
            aftProcessCancelInBean.setFlowid("09");
            aftProcessCancelInBean.setAccountid("Tt");
            aftProcessCancelInBean.setLockkey("ロックキー1_2");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(3)
    public void testValidationOK02() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);
            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setGyoumukey("業務キー1_3");
            befProcessCreateInBean.setFlowid("09");
            befProcessCreateInBean.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            StartTaskInBean befStartTaskInBean = new StartTaskInBean();
            befStartTaskInBean.setGyoumukey("業務キー1_3");
            befStartTaskInBean.setFlowid("09");
            befStartTaskInBean.setAccountid("Tt");
            befStartTaskInBean.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
                throw new Exception("前処理：タスク開始実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            createTaskSummaryInBean.setSFlowids(new String[0]);
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            boolean result = true;
            result = result && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF0000".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setGyoumukey("業務キー1_3");
            aftProcessCancelInBean.setFlowid("09");
            aftProcessCancelInBean.setAccountid("Tt");
            aftProcessCancelInBean.setLockkey("ロックキー1_3");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(4)
    public void testInfoExistNG01() {
        try {
            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            createTaskSummaryInBean.setSFlowids(new String[] {"09"});
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            boolean result = true;
            result = result && C_ResultCdKbn.WARN.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF4010".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成件数が0件です。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(5)
    public void testInfoExistNG02() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);
            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setGyoumukey("業務キー2_2");
            befProcessCreateInBean.setFlowid("09");
            befProcessCreateInBean.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            StartTaskInBean befStartTaskInBean = new StartTaskInBean();
            befStartTaskInBean.setGyoumukey("業務キー2_2");
            befStartTaskInBean.setFlowid("09");
            befStartTaskInBean.setAccountid("Tt");
            befStartTaskInBean.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
                throw new Exception("前処理：タスク開始実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            createTaskSummaryInBean.setSFlowids(new String[] {"無効なフローＩＤ"});
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            boolean result = true;
            result = result && C_ResultCdKbn.WARN.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF4010".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成件数が0件です。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setGyoumukey("業務キー2_2");
            aftProcessCancelInBean.setFlowid("09");
            aftProcessCancelInBean.setAccountid("Tt");
            aftProcessCancelInBean.setLockkey("ロックキー2_2");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(6)
    public void testSyoriLogicOK01() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);
            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setGyoumukey("業務キー3_1");
            befProcessCreateInBean.setFlowid("09");
            befProcessCreateInBean.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            StartTaskInBean befStartTaskInBean = new StartTaskInBean();
            befStartTaskInBean.setGyoumukey("業務キー3_1");
            befStartTaskInBean.setFlowid("09");
            befStartTaskInBean.setAccountid("Tt");
            befStartTaskInBean.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
                throw new Exception("前処理：タスク開始実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            createTaskSummaryInBean.setSFlowids(new String[0]);
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            boolean result = true;
            result = result && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF0000".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setGyoumukey("業務キー3_1");
            aftProcessCancelInBean.setFlowid("09");
            aftProcessCancelInBean.setAccountid("Tt");
            aftProcessCancelInBean.setLockkey("ロックキー3_1");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(7)
    public void testSyoriLogicOK02() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);
            ProcessCreateInBean befProcessCreateInBean = new ProcessCreateInBean();
            befProcessCreateInBean.setGyoumukey("業務キー3_2");
            befProcessCreateInBean.setFlowid("09");
            befProcessCreateInBean.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean = iwfKouteiClient.execProcessCreate(befProcessCreateInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean.getKekkastatus())) {
                throw new Exception("前処理：工程作成実行失敗！");
            }

            StartTaskInBean befStartTaskInBean = new StartTaskInBean();
            befStartTaskInBean.setGyoumukey("業務キー3_2");
            befStartTaskInBean.setFlowid("09");
            befStartTaskInBean.setAccountid("Tt");
            befStartTaskInBean.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean = iwfKouteiClient.execStartTask(befStartTaskInBean);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean.getKekkastatus())) {
                throw new Exception("前処理：タスク開始実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            createTaskSummaryInBean.setSFlowids(new String[] {"09"});
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            boolean result = true;
            result = result && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF0000".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            ProcessCancelInBean aftProcessCancelInBean = new ProcessCancelInBean();
            aftProcessCancelInBean.setGyoumukey("業務キー3_2");
            aftProcessCancelInBean.setFlowid("09");
            aftProcessCancelInBean.setAccountid("Tt");
            aftProcessCancelInBean.setLockkey("ロックキー3_2");
            ProcessCancelOutBean aftProcessCancelOutBean = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean.getKekkastatus())) {
                throw new Exception("後処理：工程取消実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(8)
    public void testSyoriLogicOK03() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);
            ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
            befProcessCreateInBean1.setGyoumukey("業務キー3_3_1");
            befProcessCreateInBean1.setFlowid("09");
            befProcessCreateInBean1.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
                throw new Exception("前処理：工程作成１実行失敗！");
            }

            StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
            befStartTaskInBean1.setGyoumukey("業務キー3_3_1");
            befStartTaskInBean1.setFlowid("09");
            befStartTaskInBean1.setAccountid("Tt");
            befStartTaskInBean1.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
                throw new Exception("前処理：タスク開始１実行失敗！");
            }

            ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
            befProcessCreateInBean2.setGyoumukey("業務キー3_3_2");
            befProcessCreateInBean2.setFlowid("フローＩＤ0001");
            befProcessCreateInBean2.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
                throw new Exception("前処理：工程作成２実行失敗！");
            }

            StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
            befStartTaskInBean2.setGyoumukey("業務キー3_3_2");
            befStartTaskInBean2.setFlowid("フローＩＤ0001");
            befStartTaskInBean2.setAccountid("Tt");
            befStartTaskInBean2.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
                throw new Exception("前処理：タスク開始２実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            createTaskSummaryInBean.setSFlowids(new String[] {"09", "フローＩＤ0001"});
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            boolean result = true;
            result = result && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF0000".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
            aftProcessCancelInBean1.setGyoumukey("業務キー3_3_1");
            aftProcessCancelInBean1.setFlowid("09");
            aftProcessCancelInBean1.setAccountid("Tt");
            aftProcessCancelInBean1.setLockkey("ロックキー3_3_1");
            ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
                throw new Exception("後処理：工程取消１実行失敗！");
            }

            ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
            aftProcessCancelInBean2.setGyoumukey("業務キー3_3_2");
            aftProcessCancelInBean2.setFlowid("フローＩＤ0001");
            aftProcessCancelInBean2.setAccountid("Tt");
            aftProcessCancelInBean2.setLockkey("ロックキー3_3_2");
            ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
                throw new Exception("後処理：工程取消２実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void testSyoriLogicOK04() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);

            String finished_gyoumukey = IwfDateUtils.getSysDate();
            String unfinished_gyoumukey = IwfDateUtils.getSysDate();

            ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
            befProcessCreateInBean1.setGyoumukey(finished_gyoumukey);
            befProcessCreateInBean1.setFlowid("09");
            befProcessCreateInBean1.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
                throw new Exception("前処理：工程作成１実行失敗！");
            }

            StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
            befStartTaskInBean1.setGyoumukey(finished_gyoumukey);
            befStartTaskInBean1.setFlowid("09");
            befStartTaskInBean1.setAccountid("Tt");
            befStartTaskInBean1.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
                throw new Exception("前処理：タスク開始１実行失敗！");
            }

            ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
            aftProcessCancelInBean1.setGyoumukey(finished_gyoumukey);
            aftProcessCancelInBean1.setFlowid("09");
            aftProcessCancelInBean1.setAccountid("Tt");
            aftProcessCancelInBean1.setLockkey("ロックキー3_3_1");
            ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
                throw new Exception("後処理：工程取消１実行失敗！");
            }

            ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
            befProcessCreateInBean2.setGyoumukey(unfinished_gyoumukey);
            befProcessCreateInBean2.setFlowid("フローＩＤ0001");
            befProcessCreateInBean2.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
                throw new Exception("前処理：工程作成２実行失敗！");
            }

            StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
            befStartTaskInBean2.setGyoumukey(unfinished_gyoumukey);
            befStartTaskInBean2.setFlowid("フローＩＤ0001");
            befStartTaskInBean2.setAccountid("Tt");
            befStartTaskInBean2.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
                throw new Exception("前処理：タスク開始２実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            List<WT_TaskSummary> taskSummaryList = iwfCoreDomManager.getAllTaskSummary();

            boolean result = true;
            result = result && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF0000".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());
            result = result && 1 == taskSummaryList.size();

            ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
            aftProcessCancelInBean2.setGyoumukey(unfinished_gyoumukey);
            aftProcessCancelInBean2.setFlowid("フローＩＤ0001");
            aftProcessCancelInBean2.setAccountid("Tt");
            aftProcessCancelInBean2.setLockkey("ロックキー3_3_2");
            ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
                throw new Exception("後処理：工程取消２実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void testSyoriLogicOK05() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);

            String finished_gyoumukey = IwfDateUtils.getSysDate();
            String unfinished_gyoumukey = IwfDateUtils.getSysDate();

            ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
            befProcessCreateInBean1.setGyoumukey(finished_gyoumukey);
            befProcessCreateInBean1.setFlowid("09");
            befProcessCreateInBean1.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
                throw new Exception("前処理：工程作成１実行失敗！");
            }

            StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
            befStartTaskInBean1.setGyoumukey(finished_gyoumukey);
            befStartTaskInBean1.setFlowid("09");
            befStartTaskInBean1.setAccountid("Tt");
            befStartTaskInBean1.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
                throw new Exception("前処理：タスク開始１実行失敗！");
            }

            ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
            aftProcessCancelInBean1.setGyoumukey(finished_gyoumukey);
            aftProcessCancelInBean1.setFlowid("09");
            aftProcessCancelInBean1.setAccountid("Tt");
            aftProcessCancelInBean1.setLockkey("ロックキー3_3_1");
            ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
                throw new Exception("後処理：工程取消１実行失敗！");
            }

            ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
            befProcessCreateInBean2.setGyoumukey(unfinished_gyoumukey);
            befProcessCreateInBean2.setFlowid("フローＩＤ0001");
            befProcessCreateInBean2.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
                throw new Exception("前処理：工程作成２実行失敗！");
            }

            StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
            befStartTaskInBean2.setGyoumukey(unfinished_gyoumukey);
            befStartTaskInBean2.setFlowid("フローＩＤ0001");
            befStartTaskInBean2.setAccountid("Tt");
            befStartTaskInBean2.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
                throw new Exception("前処理：タスク開始２実行失敗！");
            }

            ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
            aftProcessCancelInBean2.setGyoumukey(unfinished_gyoumukey);
            aftProcessCancelInBean2.setFlowid("フローＩＤ0001");
            aftProcessCancelInBean2.setAccountid("Tt");
            aftProcessCancelInBean2.setLockkey("ロックキー3_3_2");
            ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
                throw new Exception("後処理：工程取消２実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            List<WT_TaskSummary> taskSummaryList = iwfCoreDomManager.getAllTaskSummary();

            boolean result = true;
            result = result && C_ResultCdKbn.WARN.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF4010".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成件数が0件です。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }

    @Test
    public void testSyoriLogicOK06() {
        try {
            IwfCoreConfig config = SWAKInjector.getInstance(IwfCoreConfig.class);
            config.setLockYouhi(false);

            String flow09_1 = IwfDateUtils.getSysDate();
            String flow09_2 = IwfDateUtils.getSysDate() + "A";
            String flow0001_1 = IwfDateUtils.getSysDate() + "B";

            ProcessCreateInBean befProcessCreateInBean1 = new ProcessCreateInBean();
            befProcessCreateInBean1.setGyoumukey(flow09_1);
            befProcessCreateInBean1.setFlowid("09");
            befProcessCreateInBean1.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean1 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean1.getKekkastatus())) {
                throw new Exception("前処理：工程作成１実行失敗！");
            }

            StartTaskInBean befStartTaskInBean1 = new StartTaskInBean();
            befStartTaskInBean1.setGyoumukey(flow09_1);
            befStartTaskInBean1.setFlowid("09");
            befStartTaskInBean1.setAccountid("Tt");
            befStartTaskInBean1.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean1 = iwfKouteiClient.execStartTask(befStartTaskInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean1.getKekkastatus())) {
                throw new Exception("前処理：タスク開始１実行失敗！");
            }

            ProcessCreateInBean befProcessCreateInBean2 = new ProcessCreateInBean();
            befProcessCreateInBean2.setGyoumukey(flow09_2);
            befProcessCreateInBean2.setFlowid("09");
            befProcessCreateInBean2.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean2 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
                throw new Exception("前処理：工程作成２実行失敗！");
            }

            StartTaskInBean befStartTaskInBean2 = new StartTaskInBean();
            befStartTaskInBean2.setGyoumukey(flow09_2);
            befStartTaskInBean2.setFlowid("09");
            befStartTaskInBean2.setAccountid("Tt");
            befStartTaskInBean2.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean2 = iwfKouteiClient.execStartTask(befStartTaskInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean2.getKekkastatus())) {
                throw new Exception("前処理：タスク開始２実行失敗！");
            }

            ProcessCreateInBean befProcessCreateInBean3 = new ProcessCreateInBean();
            befProcessCreateInBean3.setGyoumukey(flow0001_1);
            befProcessCreateInBean3.setFlowid("フローＩＤ0001");
            befProcessCreateInBean3.setAccountid("Tt");
            ProcessCreateOutBean befProcessCreateOutBean3 = iwfKouteiClient.execProcessCreate(befProcessCreateInBean3);
            if (!C_ResultCdKbn.OK.toString().equals(befProcessCreateOutBean2.getKekkastatus())) {
                throw new Exception("前処理：工程作成３実行失敗！");
            }

            StartTaskInBean befStartTaskInBean3 = new StartTaskInBean();
            befStartTaskInBean3.setGyoumukey(flow0001_1);
            befStartTaskInBean3.setFlowid("フローＩＤ0001");
            befStartTaskInBean3.setAccountid("Tt");
            befStartTaskInBean3.setTaskname("torikesi-check1");
            StartTaskOutBean befStartTaskOutBean3 = iwfKouteiClient.execStartTask(befStartTaskInBean3);
            if (!C_ResultCdKbn.OK.toString().equals(befStartTaskOutBean3.getKekkastatus())) {
                throw new Exception("前処理：タスク開始３実行失敗！");
            }

            CreateTaskSummaryInBean createTaskSummaryInBean = new CreateTaskSummaryInBean();
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean);

            List<WT_TaskSummary> taskSummaryList = iwfCoreDomManager.getAllTaskSummary();
            boolean result = true;
            result = result && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse.getKekkastatus());
            result = result && "IWF0000".equals(wSCreateTaskSummaryResponse.getSyousaimsgcd());
            result = result && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse.getSyousaimsg());
            result = result && 3 == taskSummaryList.size();

            ProcessCancelInBean aftProcessCancelInBean1 = new ProcessCancelInBean();
            aftProcessCancelInBean1.setGyoumukey(flow09_1);
            aftProcessCancelInBean1.setFlowid("09");
            aftProcessCancelInBean1.setAccountid("Tt");
            aftProcessCancelInBean1.setLockkey("ロックキー3_3_1");
            ProcessCancelOutBean aftProcessCancelOutBean1 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean1);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean1.getKekkastatus())) {
                throw new Exception("後処理：工程取消１実行失敗！");
            }

            ProcessCancelInBean aftProcessCancelInBean3 = new ProcessCancelInBean();
            aftProcessCancelInBean3.setGyoumukey(flow0001_1);
            aftProcessCancelInBean3.setFlowid("フローＩＤ0001");
            aftProcessCancelInBean3.setAccountid("Tt");
            aftProcessCancelInBean3.setLockkey("ロックキー3_3_2");
            ProcessCancelOutBean aftProcessCancelOutBean3 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean3);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean3.getKekkastatus())) {
                throw new Exception("後処理：工程取消３実行失敗！");
            }

            iwfCoreDomManager.clear();
            CreateTaskSummaryInBean createTaskSummaryInBean2 = new CreateTaskSummaryInBean();
            createTaskSummaryInBean2.setSFlowids(new String[]{"09"});
            WSCreateTaskSummaryResponse wSCreateTaskSummaryResponse2 = iwfKouteiClient.execCreateTaskSummary(createTaskSummaryInBean2);

            List<WT_TaskSummary> taskSummaryList2 = iwfCoreDomManager.getAllTaskSummary();
            boolean result2 = true;
            result = result2 && C_ResultCdKbn.OK.toString().equals(wSCreateTaskSummaryResponse2.getKekkastatus());
            result = result2 && "IWF0000".equals(wSCreateTaskSummaryResponse2.getSyousaimsgcd());
            result = result2 && "件数サマリ作成正常終了しました。".equals(wSCreateTaskSummaryResponse2.getSyousaimsg());
            result = result2 && 2 == taskSummaryList2.size();

            ProcessCancelInBean aftProcessCancelInBean2 = new ProcessCancelInBean();
            aftProcessCancelInBean2.setGyoumukey(flow09_2);
            aftProcessCancelInBean2.setFlowid("09");
            aftProcessCancelInBean2.setAccountid("Tt");
            aftProcessCancelInBean2.setLockkey("ロックキー3_3_2");
            ProcessCancelOutBean aftProcessCancelOutBean2 = iwfKouteiClient.execProcessCancel(aftProcessCancelInBean2);
            if (!C_ResultCdKbn.OK.toString().equals(aftProcessCancelOutBean2.getKekkastatus())) {
                throw new Exception("後処理：工程取消２実行失敗！");
            }

            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}

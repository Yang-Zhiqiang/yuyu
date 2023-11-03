package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.workflow.io.data.DeleteProcessAndJBPMRecordInBean;
import yuyu.common.biz.workflow.io.image.DropImageInBean;
import yuyu.common.biz.workflow.io.image.GetImageInBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsInBean;
import yuyu.common.biz.workflow.io.image.GetKouteiSiteiImagePropsOutBean;
import yuyu.common.biz.workflow.io.image.PutImageInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordInBean;
import yuyu.common.biz.workflow.io.koutei.CreateProcessRecordOutBean;
import yuyu.common.biz.workflow.io.koutei.ForceProcessForwardInBean;
import yuyu.common.biz.workflow.io.koutei.LockProcessInBean;
import yuyu.common.biz.workflow.io.koutei.ProcessCreateInBean;
import yuyu.common.biz.workflow.io.koutei.StartTaskInBean;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.DeleteProcessAndJBPMRecordBean;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.WSDeleteProcessAndJBPMRecordResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageById;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdRequest;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.dropimagebyid.WSDropImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.getimagebyid.WSGetImageByIdResponse;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.putimage.WSPutImageResponse;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * イメージ削除Webサービス {@link WSDropImageById#executeBizMain(WSDropImageByIdRequest)} テスト用クラスです。<br/>
 */
@RunWith(SWAKTestRunner.class)
public class DeleteProcessAndJBPMRecordTest {
    @Inject
    IwfDataClient iwfDataClient;

    @Inject
    IwfKouteiClient iwfKouteiClient;

    @Inject
    IwfImageClient iwfImageClient;

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    static final String accountId = "sin";
    static final String syoruiCd = "kk162";

    @Test
    public void test01() {
        Calendar calendar = Calendar.getInstance();
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String second = String.valueOf(calendar.get(Calendar.SECOND));

        String gyomuKey = "gyomu_test_" + hour + minute + second;
        String flowId = "khcoolingoff";

        createData(gyomuKey, flowId);

        WSDeleteProcessAndJBPMRecordResponse response = iwfDataClient.execDeleteProcessAndJBPMRecord(createBean(gyomuKey, flowId));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴・JBPMデータ削除正常終了しました。", response.getSyousaimsg());

        List<WT_KouteiRireki> kouteiRirekis =
            iwfCoreDomManager.getKouteiRirekis(gyomuKey, flowId, C_RirekiKbn.SYSTEM);
        assertEquals(0, kouteiRirekis.size());

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();
        oWfContext.open();
        IWorkflowToken token = Tokens.getToken(iwfCoreDomManager, oWfContext, gyomuKey, flowId);
        assertNull(token);
        oWfContext.close();
    }

    @Test
    public void test02() {
        Calendar calendar = Calendar.getInstance();
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String second = String.valueOf(calendar.get(Calendar.SECOND));

        String gyomuKey = "gyomu_test_" + hour + minute + second;
        String flowId = "khcoolingoff";

        createData(gyomuKey, flowId);

        PutImageInBean putImageInBean1 = new PutImageInBean();
        putImageInBean1.setAccountid(accountId);
        putImageInBean1.setSyoruicd(syoruiCd);
        putImageInBean1.setGyoumukey(gyomuKey);
        putImageInBean1.setFlowid(flowId);
        try {
            putImageInBean1.setImagedata(readTestFile("reports/Test.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WSPutImageResponse putImageResponse1 = iwfImageClient.execPutImage(putImageInBean1);
        String imageIdBeforeDeletion = putImageResponse1.getImgid();

        iwfDataClient.execDeleteProcessAndJBPMRecord(createBean(gyomuKey, flowId));

        GetImageInBean getImageInBean1 = new GetImageInBean();
        getImageInBean1.setAccountid(accountId);
        getImageInBean1.setImageids(new String[] {imageIdBeforeDeletion});
        WSGetImageByIdResponse getImageResponse1 = iwfImageClient.execGetImage(getImageInBean1);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImageResponse1.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImageResponse1.getSyousaimsgcd());

        DropImageInBean dropImageInBean1 = new DropImageInBean();
        dropImageInBean1.setAccountid(accountId);
        dropImageInBean1.setImageids(new String[] {imageIdBeforeDeletion});
        List<Map<String, String>> extinfoMapList1 = new ArrayList<>();
        Map<String, String> extinfoMap1 = new HashMap<>();
        extinfoMap1.put("extinfo", "付加情報");
        extinfoMapList1.add(extinfoMap1);
        dropImageInBean1.setExtInfo(extinfoMapList1);
        WSDropImageByIdResponse wSDropImageByIdResponse1 = iwfImageClient.execDropImage(dropImageInBean1);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSDropImageByIdResponse1.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSDropImageByIdResponse1.getSyousaimsgcd());

        PutImageInBean putImageInBean2 = new PutImageInBean();
        putImageInBean2.setAccountid(accountId);
        putImageInBean2.setSyoruicd(syoruiCd);
        putImageInBean2.setGyoumukey(gyomuKey);
        putImageInBean2.setFlowid(flowId);
        try {
            putImageInBean2.setImagedata(readTestFile("reports/Test.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WSPutImageResponse putImageResponse2 = iwfImageClient.execPutImage(putImageInBean2);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), putImageResponse2.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", putImageResponse2.getSyousaimsgcd());

        GetImageInBean getImageInBean2 = new GetImageInBean();
        getImageInBean2.setAccountid(accountId);
        getImageInBean2.setImageids(new String[] {putImageResponse2.getImgid()});
        WSGetImageByIdResponse getImageResponse2 = iwfImageClient.execGetImage(getImageInBean2);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getImageResponse2.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getImageResponse2.getSyousaimsgcd());

        DropImageInBean dropImageInBean2 = new DropImageInBean();
        dropImageInBean2.setAccountid(accountId);
        dropImageInBean2.setImageids(new String[] {putImageResponse2.getImgid()});
        List<Map<String, String>> extinfoMapList2 = new ArrayList<>();
        Map<String, String> extinfoMap2 = new HashMap<>();
        extinfoMap2.put("extinfo", "付加情報");
        extinfoMapList2.add(extinfoMap2);
        dropImageInBean2.setExtInfo(extinfoMapList2);
        WSDropImageByIdResponse wSDropImageByIdResponse2 = iwfImageClient.execDropImage(dropImageInBean2);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), wSDropImageByIdResponse2.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", wSDropImageByIdResponse2.getSyousaimsgcd());
    }


    @Test
    public void test03() {
        WSDeleteProcessAndJBPMRecordResponse response1 =
            iwfDataClient.execDeleteProcessAndJBPMRecord(createBean(null, "flowid"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response1.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response1.getSyousaimsgcd());

        WSDeleteProcessAndJBPMRecordResponse response2 =
            iwfDataClient.execDeleteProcessAndJBPMRecord(createBean("gyoumukey", null));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response2.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0002", response2.getSyousaimsgcd());

        WSDeleteProcessAndJBPMRecordResponse response3 =
            iwfDataClient.execDeleteProcessAndJBPMRecord(createBean("123456789012345678901", "1234567890"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response3.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response3.getSyousaimsgcd());

        WSDeleteProcessAndJBPMRecordResponse response4 =
            iwfDataClient.execDeleteProcessAndJBPMRecord(createBean("1234567890", "12345678901234567890"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.NG.toString(), response4.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0008", response4.getSyousaimsgcd());

        WSDeleteProcessAndJBPMRecordResponse response5 =
            iwfDataClient.execDeleteProcessAndJBPMRecord(createBean("12345678901234567890", "1234567890123456789"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response5.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response5.getSyousaimsgcd());
    }

    @Test
    public void test04() {
        String flowId = "khcoolingoff";

        List<DeleteProcessAndJBPMRecordBean> list = new ArrayList<DeleteProcessAndJBPMRecordBean>();

        for (int i = 0; i < 10; i++) {
            Calendar calendar = Calendar.getInstance();
            String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
            String minute = String.valueOf(calendar.get(Calendar.MINUTE));
            String second = String.valueOf(calendar.get(Calendar.SECOND));
            String gyomuKey = "gyomu_test_" + hour + minute + second + i;

            createData(gyomuKey, flowId);

            DeleteProcessAndJBPMRecordBean bean = new DeleteProcessAndJBPMRecordBean();
            bean.setGyoumukey(gyomuKey);
            bean.setFlowid(flowId);
            list.add(bean);
        }

        DeleteProcessAndJBPMRecordInBean deleteProcessAndJBPMRecordInBean = new DeleteProcessAndJBPMRecordInBean();
        deleteProcessAndJBPMRecordInBean.setDeleteProcessAndJBPMRecordBeanList(list);

        WSDeleteProcessAndJBPMRecordResponse response =
            iwfDataClient.execDeleteProcessAndJBPMRecord(deleteProcessAndJBPMRecordInBean);
        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程履歴・JBPMデータ削除正常終了しました。", response.getSyousaimsg());

        for (DeleteProcessAndJBPMRecordBean bean : list) {
            List<WT_KouteiRireki> kouteiRirekis =
                iwfCoreDomManager.getKouteiRirekis(bean.getGyoumukey(), bean.getFlowid(), C_RirekiKbn.SYSTEM);
            assertEquals(0, kouteiRirekis.size());

            IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();
            oWfContext.open();
            IWorkflowToken token = Tokens.getToken(iwfCoreDomManager, oWfContext, bean.getGyoumukey(), bean.getFlowid());
            assertNull(token);
            oWfContext.close();
        }
    }


    @Test
    public void test05() {
        Calendar calendar = Calendar.getInstance();
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String second = String.valueOf(calendar.get(Calendar.SECOND));

        String gyomuKey = "gyomu_test_" + hour + minute + second;
        String flowId = "khcoolingoff";

        createData(gyomuKey, flowId);

        DeleteProcessAndJBPMRecordInBean deleteProcessAndJBPMRecordInBean = createBean(gyomuKey, flowId);

        WSDeleteProcessAndJBPMRecordResponse response1 =
            iwfDataClient.execDeleteProcessAndJBPMRecord(createBean(gyomuKey, flowId));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response1.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response1.getSyousaimsgcd());

        WSDeleteProcessAndJBPMRecordResponse response2 =
            iwfDataClient.execDeleteProcessAndJBPMRecord(createBean("aaa", "ccc"));
        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), response2.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", response2.getSyousaimsgcd());
    }

    @Test
    public void test06() {
        Calendar calendar = Calendar.getInstance();
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String second = String.valueOf(calendar.get(Calendar.SECOND));

        String gyomuKey = "gyomu_test_" + hour + minute + second;
        String flowId = "khcoolingoff";

        String rirekiMsg = "履歴メッセージ";
        String taskName = "hubikaitoumati";
        String lockKey = BizDate.getSysDateTimeMilli();
        String extInfo = "付加情報";

        createData(gyomuKey, flowId);

        iwfDataClient.execDeleteProcessAndJBPMRecord(createBean(gyomuKey, flowId));

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(gyomuKey);
        createProcessRecordInBean.setFlowid(flowId);
        createProcessRecordInBean.setAccountid(accountId);
        createProcessRecordInBean.setRirekimsg(rirekiMsg);
        createProcessRecordInBean.setTaskname(taskName);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", extInfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        CreateProcessRecordOutBean createProcessRecordOutBean =iwfKouteiClient.execCcreateProcessRecord(createProcessRecordInBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), createProcessRecordOutBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", createProcessRecordOutBean.getSyousaimsgcd());
    }

    @Test
    public void test07() {
        Calendar calendar = Calendar.getInstance();
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String second = String.valueOf(calendar.get(Calendar.SECOND));

        String gyomuKey = "gyomu_test_" + hour + minute + second;
        String flowId = "khcoolingoff";

        String rirekiMsg = "履歴メッセージ";
        String taskName = "hubikaitoumati";
        String lockKey = BizDate.getSysDateTimeMilli();
        String extInfo = "付加情報";

        createData(gyomuKey, flowId);

        PutImageInBean putImageInBean1 = new PutImageInBean();
        putImageInBean1.setAccountid(accountId);
        putImageInBean1.setSyoruicd(syoruiCd);
        putImageInBean1.setGyoumukey(gyomuKey);
        putImageInBean1.setFlowid(flowId);
        try {
            putImageInBean1.setImagedata(readTestFile("reports/Test.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WSPutImageResponse putImageResponse1 = iwfImageClient.execPutImage(putImageInBean1);

        GetKouteiSiteiImagePropsInBean getKouteiSiteiImagePropsInBean1 = new GetKouteiSiteiImagePropsInBean();
        getKouteiSiteiImagePropsInBean1.setAccountid(accountId);
        GetKouteiSiteiImagePropsOutBean getKouteiSiteiImagePropsOutBean1 = iwfImageClient.GetKouteiSiteiImageProps(getKouteiSiteiImagePropsInBean1);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getKouteiSiteiImagePropsOutBean1.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getKouteiSiteiImagePropsOutBean1.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", getKouteiSiteiImagePropsOutBean1.getSyousaimsg());

        iwfDataClient.execDeleteProcessAndJBPMRecord(createBean(gyomuKey, flowId));

        PutImageInBean putImageInBean2 = new PutImageInBean();
        putImageInBean2.setAccountid(accountId);
        putImageInBean2.setSyoruicd(syoruiCd);
        putImageInBean2.setGyoumukey(gyomuKey);
        putImageInBean2.setFlowid(flowId);
        try {
            putImageInBean2.setImagedata(readTestFile("reports/Test.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        WSPutImageResponse putImageResponse2 = iwfImageClient.execPutImage(putImageInBean2);

        GetKouteiSiteiImagePropsInBean getKouteiSiteiImagePropsInBean2 = new GetKouteiSiteiImagePropsInBean();
        getKouteiSiteiImagePropsInBean2.setAccountid(accountId);
        GetKouteiSiteiImagePropsOutBean getKouteiSiteiImagePropsOutBean2 = iwfImageClient.GetKouteiSiteiImageProps(getKouteiSiteiImagePropsInBean2);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), getKouteiSiteiImagePropsOutBean2.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", getKouteiSiteiImagePropsOutBean2.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程情報指定イメージプロパティ取得正常終了しました。", getKouteiSiteiImagePropsOutBean2.getSyousaimsg());

        assertEquals("イメージプロパティ件数：", getKouteiSiteiImagePropsOutBean1.getImagepropslist().size() + 1, getKouteiSiteiImagePropsOutBean2.getImagepropslist().size());
    }

    private byte[] readTestFile(String pdfName) throws Exception {
        File oFile = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath() + pdfName);

        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(oFile));
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) oFile.length());) {

            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }

            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void createData(String pGyomuKey, String pFlowId ) {
        String rirekiMsg = "履歴メッセージ";
        String taskName = "hubikaitoumati";
        String lockKey = BizDate.getSysDateTimeMilli();
        String extInfo = "付加情報";

        ProcessCreateInBean processCreateInBean = new ProcessCreateInBean();
        processCreateInBean.setGyoumukey(pGyomuKey);
        processCreateInBean.setFlowid(pFlowId);
        processCreateInBean.setAccountid(accountId);
        iwfKouteiClient.execProcessCreate(processCreateInBean);

        CreateProcessRecordInBean createProcessRecordInBean = new CreateProcessRecordInBean();
        createProcessRecordInBean.setGyoumukey(pGyomuKey);
        createProcessRecordInBean.setFlowid(pFlowId);
        createProcessRecordInBean.setAccountid(accountId);
        createProcessRecordInBean.setRirekimsg(rirekiMsg);
        createProcessRecordInBean.setTaskname(taskName);
        List<Map<String, String>> extinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> extinfoMap = new HashMap<String, String>();
        extinfoMap.put("extinfo", extInfo);
        extinfoMapList.add(extinfoMap);
        createProcessRecordInBean.setExtInfo(extinfoMapList);
        iwfKouteiClient.execCcreateProcessRecord(createProcessRecordInBean);

        LockProcessInBean lockProcessBean = new LockProcessInBean();
        lockProcessBean.setGyoumukey(pGyomuKey);
        lockProcessBean.setFlowid(pFlowId);
        lockProcessBean.setLockkey(lockKey);
        iwfKouteiClient.execLockProcess(lockProcessBean);

        ForceProcessForwardInBean inBean1 = new ForceProcessForwardInBean();
        inBean1.setGyoumukey(pGyomuKey);
        inBean1.setFlowid(pFlowId);
        inBean1.setAccountid(accountId);
        inBean1.setSrcnodename("state-syoruitoutyaku");
        inBean1.setDestnodename("hubikaitoumati");
        inBean1.setLockkey(lockKey);
        iwfKouteiClient.execForceProcessForward(inBean1);

        boolean lockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        int lockValidTime = IwfCoreConfig.getInstance().getLockValidTime();
        IwfCoreConfig.getInstance().setLockYouhi(true);
        IwfCoreConfig.getInstance().setLockValidTime(1000);
        LockProcessInBean befLockProcessInBean = new LockProcessInBean();
        befLockProcessInBean.setGyoumukey(pGyomuKey);
        befLockProcessInBean.setFlowid(pFlowId);
        befLockProcessInBean.setLockkey(lockKey);
        iwfKouteiClient.execLockProcess(befLockProcessInBean);
        List<Map<String, String>> poExtinfoMapList = new ArrayList<Map<String, String>>();
        Map<String, String> poExtinfoMap = new HashMap<String, String>();
        poExtinfoMap.put("extinfo", extInfo);
        poExtinfoMapList.add(poExtinfoMap);
        StartTaskInBean startTaskInBean = new StartTaskInBean();
        startTaskInBean.setGyoumukey(pGyomuKey);
        startTaskInBean.setFlowid(pFlowId);
        startTaskInBean.setAccountid(accountId);
        startTaskInBean.setTaskname (taskName);
        startTaskInBean.setLockkey(lockKey);
        startTaskInBean.setExtInfo(poExtinfoMapList);
        iwfKouteiClient.execStartTask(startTaskInBean);
        IwfCoreConfig.getInstance().setLockYouhi(lockYouhi);
        IwfCoreConfig.getInstance().setLockValidTime(lockValidTime);
    }

    private DeleteProcessAndJBPMRecordInBean createBean(String gyoumukey, String flowId) {
        DeleteProcessAndJBPMRecordBean bean = new DeleteProcessAndJBPMRecordBean();
        bean.setGyoumukey(gyoumukey);
        bean.setFlowid(flowId);

        List<DeleteProcessAndJBPMRecordBean> list = new ArrayList<DeleteProcessAndJBPMRecordBean>();
        list.add(bean);

        DeleteProcessAndJBPMRecordInBean deleteProcessAndJBPMRecordInBean = new DeleteProcessAndJBPMRecordInBean();
        deleteProcessAndJBPMRecordInBean.setDeleteProcessAndJBPMRecordBeanList(list);

        return deleteProcessAndJBPMRecordInBean;
    }
}

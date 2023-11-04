package yuyu.common.biz.workflow;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.apache.commons.lang.time.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.io.koutei.GetLockInfoInBean;
import yuyu.common.biz.workflow.io.koutei.GetLockInfoOutBean;
import yuyu.common.biz.workflow.io.koutei.sub.LockInfoBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfo;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.WSGetLockInfoRequest;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.dao.WT_KouteiLockDao;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 工程ロック情報取得Webサービス {@link WSGetLockInfo#executeBizMain(WSGetLockInfoRequest)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class GetLockInfoWebServiceTest {

    @Inject
    IwfKouteiClient iwfKouteiClient;
    private static String lockTime = BizDate.getSysDateTimeMilli();
    private static final String gyoumuKey01 = "gyoumuKey01";
    private static final String gyoumuKey02 = "gyoumuKey02";
    private static final String gyoumuKey03 = "gyoumuKey03";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        IwfCoreDomManager manager = SWAKInjector.getInstance(IwfCoreDomManager.class);
        WT_KouteiLockDao dao = SWAKInjector.getInstance(WT_KouteiLockDao.class);
        WT_KouteiLock lockList1 = dao.getKouteiLock("flow01", gyoumuKey01);
        WT_KouteiLock lockList2 = dao.getKouteiLock("flow02", gyoumuKey02);
        WT_KouteiLock lockList3 = dao.getKouteiLock("flow03", gyoumuKey03);

        if (lockList1 != null) {
            lockList1.setLockTime(lockTime);
            manager.update(lockList1);
        } else {
            WT_KouteiLock lock = new WT_KouteiLock();
            lock.setFlowId("flow01");
            lock.setGyoumuKey(gyoumuKey01);
            lock.setLockKey(gyoumuKey01);
            lock.setLockTime(lockTime);
            lock.setNodeNm("input");
            lock.setUserId("JUnit01");
            lock.setKousinKinou("JUnit");
            manager.insert(lock);
        }

        if (lockList2 != null) {
            lockList2.setLockTime(lockTime);
            manager.update(lockList2);
        } else {
            WT_KouteiLock lock = new WT_KouteiLock();
            lock.setFlowId("flow02");
            lock.setGyoumuKey(gyoumuKey02);
            lock.setLockKey(gyoumuKey02);
            lock.setLockTime(lockTime);
            lock.setNodeNm("check");
            lock.setUserId("JUnit02");
            manager.insert(lock);
        }

        if (lockList3 != null) {
            lockList3.setLockTime(getLockMukouTime(lockTime));
            manager.update(lockList3);
        } else {
            WT_KouteiLock lock = new WT_KouteiLock();
            lock.setFlowId("flow03");
            lock.setGyoumuKey(gyoumuKey03);
            lock.setLockKey(gyoumuKey03);
            lock.setLockTime(getLockMukouTime(lockTime));
            lock.setNodeNm("comfirm");
            lock.setUserId("JUnit03");
            manager.insert(lock);
        }
    }

    @Test(expected = RuntimeException.class)
    @TestOrder(110)
    public void test_GetLockInfo1_1() {
        iwfKouteiClient.getLockInfo(null);
    }

    @Test
    @TestOrder(120)
    public void test_GetLockInfo1_2() {
        String[] psFlowid = { "flow01", "flow03" };

        GetLockInfoInBean inBean = new GetLockInfoInBean();
        inBean.setFlowid(psFlowid);

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        System.out.println("処理結果ステータス:" + outBean.getKekkastatus());
        System.out.println("詳細メッセージコード:" + outBean.getSyousaimsgcd());
        System.out.println("詳細メッセージ:" + outBean.getSyousaimsg());

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程ロック情報取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue("検索件数:", outBean.getLockInfoBeanList().size() >= 1);
    }

    @Test
    @TestOrder(130)
    public void test_GetLockInfo1_3() {
        String[] psGyoumukey = { gyoumuKey01, gyoumuKey03 };

        GetLockInfoInBean inBean = new GetLockInfoInBean();
        inBean.setGyoumukey(psGyoumukey);

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程ロック情報取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue("検索件数:", outBean.getLockInfoBeanList().size() >= 1);
    }

    @Test
    @TestOrder(140)
    public void test_GetLockInfo1_4() {
        GetLockInfoInBean inBean = new GetLockInfoInBean();

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程ロック情報取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue("検索件数:", outBean.getLockInfoBeanList().size() >= 1);
    }

    @Test
    @TestOrder(210)
    public void test_GetLockInfo2_1() {
        String[] psGyoumukey = { gyoumuKey01, gyoumuKey03 };
        String[] psFlowid = { "flow01", "flow03" };

        GetLockInfoInBean inBean = new GetLockInfoInBean();
        inBean.setFlowid(psFlowid);
        inBean.setGyoumukey(psGyoumukey);

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程ロック情報取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue("検索件数:", outBean.getLockInfoBeanList().size() >= 1);

        for (LockInfoBean bean : outBean.getLockInfoBeanList()) {
            boolean result = true;
            if (bean.getGyoumukey().equals(gyoumuKey01)) {
                assertEquals("フローID:", "flow01", bean.getFlowId());
                assertEquals("ノード名:", "input", bean.getNodeName());
                assertEquals("アカウントID:", "JUnit01", bean.getAccountId());
                assertEquals("ロックキー:", gyoumuKey01, bean.getLockKey());
                assertEquals("ロック開始時間:", lockTime, bean.getLockTime());
            } else {
                result = false;
            }
            assertTrue(result);
        }
    }

    @Test
    @TestOrder(220)
    public void test_GetLockInfo2_2() {
        String[] psGyoumukey = { "de-tainai" };

        GetLockInfoInBean inBean = new GetLockInfoInBean();

        inBean.setGyoumukey(psGyoumukey);

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.WARN.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4030", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定された工程ロック情報は存在しません。", outBean.getSyousaimsg());

    }

    @Test
    @TestOrder(230)
    public void test_GetLockInfo2_3() {
        String[] psFlowid = { "de-tainai" };
        GetLockInfoInBean inBean = new GetLockInfoInBean();

        inBean.setFlowid(psFlowid);

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.WARN.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4030", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定された工程ロック情報は存在しません。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(310)
    public void test_GetLockInfo3_1() {
        String[] psGyoumukey = { gyoumuKey03 };
        String[] psFlowid = { "flow03" };

        GetLockInfoInBean inBean = new GetLockInfoInBean();
        inBean.setGyoumukey(psGyoumukey);
        inBean.setFlowid(psFlowid);

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.WARN.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF4030", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "指定された工程ロック情報は存在しません。", outBean.getSyousaimsg());
    }

    @Test
    @TestOrder(320)
    public void test_GetLockInfo3_2() {
        String[] psFlowid = { "flow01", "flow02" };

        GetLockInfoInBean inBean = new GetLockInfoInBean();
        inBean.setFlowid(psFlowid);

        GetLockInfoOutBean outBean = iwfKouteiClient.getLockInfo(inBean);

        assertEquals("処理結果ステータス:", C_ResultCdKbn.OK.toString(), outBean.getKekkastatus());
        assertEquals("詳細メッセージコード:", "IWF0000", outBean.getSyousaimsgcd());
        assertEquals("詳細メッセージ:", "工程ロック情報取得正常終了しました。", outBean.getSyousaimsg());
        assertTrue("検索件数:", outBean.getLockInfoBeanList().size() >= 2);
    }

    private static String getLockMukouTime(String systime) {
        try {
            Date oSysDate = null;
            oSysDate = IwfDateUtils.getDateObject(systime);
            int lckValidTime =  IwfCoreConfig.getInstance().getLockValidTime() * -2;

            Date oLockDate = DateUtils.addMinutes(oSysDate, lckValidTime);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMssSSS");
            return sdf.format(oLockDate);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}

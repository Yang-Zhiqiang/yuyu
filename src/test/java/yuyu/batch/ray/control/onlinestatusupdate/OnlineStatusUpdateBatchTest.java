package yuyu.batch.ray.control.onlinestatusupdate;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.batch.ray.control.onlinestatusupdatebatch.OnlineStatusUpdateBatch;
import yuyu.batch.ray.control.onlinestatusupdatebatch.OnlineStatusUpdateBatchParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_MqEmgcyStopStatusKbn;
import yuyu.def.classification.C_OnlineStatusKbn;
import yuyu.def.db.dao.AT_SystemControlInfoDao;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.testinfr.TestOrder;

/**
 * オンライン情報更新バッチの単体テストプログラム
 */
@RunWith(SWAKTestRunner.class)
public class OnlineStatusUpdateBatchTest {

    @Inject
    private static Logger logger;
    @Inject
    private AT_SystemControlInfoDao dao;
    private static final String SYSTEM_CTRLINFO_KEY = "ctrlInfo";
    private static int count = 0;
    private static final C_OnlineStatusKbn[] jizenDatas = new C_OnlineStatusKbn[] {
        C_OnlineStatusKbn.ONLINE_HUKA,
        null,

        C_OnlineStatusKbn.ONLINE_HUKA,
        C_OnlineStatusKbn.ONLINE_HUKA,
        C_OnlineStatusKbn.ONLINE_KA,
        C_OnlineStatusKbn.ONLINE_KA,
        C_OnlineStatusKbn.ONLINE_HUKA,
        C_OnlineStatusKbn.ONLINE_KA,
        C_OnlineStatusKbn.ONLINE_KA_SOSIKI,
        C_OnlineStatusKbn.ONLINE_KA_SOSIKI,
        C_OnlineStatusKbn.ONLINE_KA_SOSIKI,

        C_OnlineStatusKbn.ONLINE_KA

    };

    @Before
    @Transactional
    public void beforeTest() throws IOException {
        updateOnlineStatus(jizenDatas[count++]);
    }

    @Test
    @TestOrder(10010)
    @Transactional
    public void test10010() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);
        boolean result = false;

        param.setOnlineStatus(null);

        try {
            batch.execute();
        } catch (BizAppException ex) {
            result = compareMessage(ex.getMessage(), MessageId.EAF1009, MessageUtil.getMessage(MessageId.IAW1009));
        }
        assertTrue(result);
    }

    @Test
    @TestOrder(10020)
    @Transactional
    public void test10020() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);
        boolean result = false;

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_KA);

        try {
            batch.execute();
        } catch (Exception ex) {
            result = true;
            logger.debug("出力メッセージ：" + ex.getMessage());
        }
        assertTrue(result);
    }

    @Test
    @TestOrder(10030)
    @Transactional
    public void test10030() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_HUKA);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_HUKA));
    }

    @Test
    @TestOrder(10040)
    @Transactional
    public void test10040() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_KA);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_KA));
    }

    @Test
    @TestOrder(10050)
    @Transactional
    public void test10050() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_HUKA);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_HUKA));
    }

    @Test
    @TestOrder(10060)
    @Transactional
    public void test10060() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_KA);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_KA));
    }

    @Test
    @TestOrder(10070)
    @Transactional
    public void test10070() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_KA_SOSIKI);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_KA_SOSIKI));
    }

    @Test
    @TestOrder(10080)
    @Transactional
    public void test10080() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_KA_SOSIKI);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_KA_SOSIKI));
    }

    @Test
    @TestOrder(10090)
    @Transactional
    public void test10090() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_HUKA);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_HUKA));
    }

    @Test
    @TestOrder(10100)
    @Transactional
    public void test10100() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_KA);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_KA));
    }

    @Test
    @TestOrder(10110)
    @Transactional
    public void test10110() {
        OnlineStatusUpdateBatchParam param = SWAKInjector.getInstance(OnlineStatusUpdateBatchParam.class);
        OnlineStatusUpdateBatch batch = SWAKInjector.getInstance(OnlineStatusUpdateBatch.class);

        param.setOnlineStatus(C_OnlineStatusKbn.ONLINE_KA_SOSIKI);

        batch.execute();
        assertTrue(compareResult(C_OnlineStatusKbn.ONLINE_KA_SOSIKI));

    }

    @Test
    @TestOrder(19990)
    @Transactional
    public void test19990() {
        updateOnlineStatus(jizenDatas[jizenDatas.length - 1]);
    }

    private boolean compareMessage(String compareMessage, String id, String... args) {
        boolean result = false;
        String message = MessageUtil.getMessage(id, args);
        logger.debug("出力メッセージ：" + message);
        if (compareMessage.equals(message)) {
            result = true;
        }
        return result;
    }

    private boolean compareResult(C_OnlineStatusKbn onlineStatus) {
        AT_SystemControlInfo systemControlInfo = dao.getSystemControlInfo(SYSTEM_CTRLINFO_KEY);
        C_OnlineStatusKbn result = C_OnlineStatusKbn.valueOf(systemControlInfo.getOnlineStatus());
        return result.eq(onlineStatus);
    }

    @Transactional
    private void updateOnlineStatus(C_OnlineStatusKbn onlineStatus) {
        AT_SystemControlInfo systemControlInfo = dao.getSystemControlInfo(SYSTEM_CTRLINFO_KEY);
        if (onlineStatus == null) {
            dao.delete(systemControlInfo);
        } else if (systemControlInfo != null){
            systemControlInfo.setOnlineStatus(onlineStatus.toString());
            dao.update(systemControlInfo);
        } else {
            systemControlInfo = new AT_SystemControlInfo();
            systemControlInfo.setSystemCtrlInfo(SYSTEM_CTRLINFO_KEY);
            systemControlInfo.setMqEmgcyStopStatus(C_MqEmgcyStopStatusKbn.MQEMGCYSTOP_START);
            systemControlInfo.setOnlineStatus(onlineStatus.toString());
            dao.insert(systemControlInfo);
        }
    }
}

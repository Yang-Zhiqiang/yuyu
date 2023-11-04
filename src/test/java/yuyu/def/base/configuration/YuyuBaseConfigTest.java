package yuyu.def.base.configuration;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * {@link YuyuBaseConfig} のテストケースです。<br />
 * conf / yuyu-base-config.xml の設定が {@link YuyuBaseConfig} に正しく読み込まれていることを確認します。
 */
@RunWith(SWAKTestRunner.class)
public class YuyuBaseConfigTest {

    //    @Inject
    //    private static Logger logger;

    @Inject
    private YuyuBaseConfig baseConfig;

    @Test
    public void testApplicationName() {
        String applicationName = baseConfig.getApplicationName();
        assertEquals("SWAK2.1 ベースパッケージ", applicationName);
    }

    @Test
    public void testValidationGroupsPackage() {
        String validationGroupsPackage = baseConfig.getValidationGroupsPackage();
        assertEquals("yuyu.infr.validation.groups", validationGroupsPackage);
    }

    @Test
    public void testLoginPageURI() {
        String loginPageURI = baseConfig.getLoginPageURI();
        assertEquals("/base/menu/login/login.do", loginPageURI);
    }

    @Test
    public void testLoginFailedErrorCd() {
        String loginFailedErrorCd = baseConfig.getLoginFailedErrorCd();
        assertEquals("EAF0001", loginFailedErrorCd);
    }

    @Test
    public void testLoggedInErrorCd() {
        String loggedInErrorCd = baseConfig.getLoggedInErrorCd();
        assertEquals("EAC0024", loggedInErrorCd);
    }

    @Test
    public void testIdentifierRefreshInterval() {
        int identifierRefreshInterval = baseConfig.getIdentifierRefreshInterval();
        assertEquals(1, identifierRefreshInterval);
    }

    @Test
    public void testIdentifierLength() {
        int identifierLength = baseConfig.getIdentifierLength();
        assertEquals(3, identifierLength);
    }

    @Test
    public void testBatchRetryWaitTime() {
        int batchRetryWaitTime = baseConfig.getBatchRetryWaitTime();
        assertEquals(30000, batchRetryWaitTime);
    }

    @Test
    public void testBatchRetryCount() {
        int batchRetryCount = baseConfig.getBatchRetryCount();
        assertEquals(2, batchRetryCount);
    }

    @Test
    public void testBatchLogBeginMessage() {
        BatchLogMessageCode batchLogMessageBean = baseConfig.getBatchLogMessageCode();
        assertEquals("IAC0017", batchLogMessageBean.getBeginMessage());
        assertEquals("IAC0018", batchLogMessageBean.getEndMessage());
    }

    @Test
    public void testMessageIconEntry() {
        Map<String, String> messageIconResouces = baseConfig.getMessageIconResources();
        assertEquals(4,messageIconResouces.size());
        assertEquals("/img/message/Message_Error.png", messageIconResouces.get("E"));
        assertEquals("/img/message/Message_Warning.png", messageIconResouces.get("W"));
        assertEquals("/img/message/Message_Information.png", messageIconResouces.get("I"));
        assertEquals("/img/message/Message_Inquiry.png", messageIconResouces.get("Q"));

    }

    @Test
    public void testTokusyuKinou() {
        List<TokusyuKinou> tokusyukinou = baseConfig.getTokusyuKinouList();

        assertEquals(null,tokusyukinou.get(0).getActionClassName());
        assertEquals(null,tokusyukinou.get(0).getInitMethod());
        assertEquals(null,tokusyukinou.get(0).getKinouId());
    }

    @Test
    public void testBatchHost() {
        String batchHost = baseConfig.getBatchHost();
        assertEquals("localhost", batchHost);
    }

    @Test
    public void testBatchPort() {
        int batchPort = baseConfig.getBatchPort();
        assertEquals(8099, batchPort);
    }

    @Test
    public void testBatchParamBeant() {
        String batchParamBean = baseConfig.getBatchParamBean();
        assertEquals("yuyu.infr.batch.BatchParam", batchParamBean);
    }

    @Test
    public void testBatchOutputDir() {
        String batchOutputDir = baseConfig.getBatchOutputDir();
        String rootPath = SWAK.getApplicationRootPath();
        int index = rootPath.indexOf("\\src\\main\\webapp");
        rootPath = rootPath.substring(0,index);
        assertEquals(rootPath+"/work/batch_out",batchOutputDir);
    }

    @Test
    public void testBatchInputDir() {
        String batchInputDir = baseConfig.getBatchInputDir();
        String rootPath = SWAK.getApplicationRootPath();
        int index = rootPath.indexOf("\\src\\main\\webapp");
        rootPath = rootPath.substring(0,index);
        assertEquals(rootPath+"/work/batch_in",batchInputDir);
    }

    @Test
    public void testObjStorageDir() {
        String objStorageDir = baseConfig.getObjStorageDir();
        String rootPath=SWAK.getApplicationRootPath();
        int index = rootPath.indexOf("\\src\\main\\webapp");
        rootPath = rootPath.substring(0,index);
        assertEquals(rootPath+"/work/obj-storage-repository",objStorageDir);
    }

    @Test
    public void testMaxShutokuKensu() {
        int maxShutokuKensu = baseConfig.getMaxShutokuKensu();
        assertEquals(5000, maxShutokuKensu);
    }

    @Test
    public void testSubSystemEnableFlg() {
        boolean subSystemEnableFlg = baseConfig.isSubSystemEnableFlg();
        assertEquals(true, subSystemEnableFlg);
    }

    @Test
    public void testDebugMode() {
        boolean debugMode = baseConfig.isDebugMode();
        assertEquals(true, debugMode);
    }

    @Test
    public void testDateTimeNotShowSubSystemGroup() {
        String dateTimeNotShowSubSystemGroup = baseConfig.getDateTimeNotShowSubSystemGroup();
        assertEquals(null, dateTimeNotShowSubSystemGroup);
    }

    @Test
    public void testAddressMasterCsvFileName() {
        String addressMasterCsvFileName = baseConfig.getAddressMasterCsvFileName();
        assertEquals("KEN_ALL.CSV", addressMasterCsvFileName);
    }

    @Test
    public void testExceptionMessage() {
        List<ExceptionMessage> exceptionMessages = baseConfig.getExceptionMessageList();

        assertEquals("javax.persistence.OptimisticLockException", exceptionMessages.get(0).getException());
        assertEquals("IAS0003",exceptionMessages.get(0).getTitleId());
        assertEquals("EAS0030",exceptionMessages.get(0).getMessageId());

        assertEquals("jp.co.slcs.swak.db.exception.DuplicatedKeyException",exceptionMessages.get(1).getException());
        assertEquals("IAS0003",exceptionMessages.get(1).getTitleId());
        assertEquals("EAS0030",exceptionMessages.get(1).getMessageId());

        assertEquals("jp.co.slcs.swak.web.conversation.exception.ConversationTokenException",exceptionMessages.get(2).getException());
        assertEquals("IAS0004",exceptionMessages.get(2).getTitleId());
        assertEquals("EAS0031",exceptionMessages.get(2).getMessageId());

        assertEquals("jp.co.slcs.swak.web.conversation.exception.ConversationMulitPostException",exceptionMessages.get(3).getException());
        assertEquals("IAS0004",exceptionMessages.get(3).getTitleId());
        assertEquals("EAS0031",exceptionMessages.get(3).getMessageId());

        assertEquals("jp.co.slcs.swak.web.auth.logout.LogoutException",exceptionMessages.get(4).getException());
        assertEquals("IAS0005",exceptionMessages.get(4).getTitleId());
        assertEquals("EAS0032",exceptionMessages.get(4).getMessageId());

        assertEquals("yuyu.infr.exception.OutOfSystemUpTimeException",exceptionMessages.get(5).getException());
        assertEquals("IAS0006",exceptionMessages.get(5).getTitleId());
        assertEquals("EAS0033",exceptionMessages.get(5).getMessageId());

        assertEquals("jp.co.slcs.swak.auth.AuthorizationException",exceptionMessages.get(6).getException());
        assertEquals("IAS0007",exceptionMessages.get(6).getTitleId());
        assertEquals("EAS0034",exceptionMessages.get(6).getMessageId());

        assertEquals("jp.co.slcs.swak.web.conversation.exception.ConversationTimeoutException",exceptionMessages.get(7).getException());
        assertEquals("IAS0008",exceptionMessages.get(7).getTitleId());
        assertEquals("EAS0050",exceptionMessages.get(7).getMessageId());

        assertEquals("jp.co.slcs.swak.web.auth.DiscardedUserSessionException",exceptionMessages.get(8).getException());
        assertEquals("IAS0009",exceptionMessages.get(8).getTitleId());
        assertEquals("EAS0036",exceptionMessages.get(8).getMessageId());

        assertEquals("jp.co.slcs.swak.bizinfr.exception.BizAppException",exceptionMessages.get(9).getException());
        assertEquals("IAS0011",exceptionMessages.get(9).getTitleId());
        assertEquals(null,exceptionMessages.get(9).getMessageId());

        assertEquals("otherException",exceptionMessages.get(10).getException());
        assertEquals("IAS0010",exceptionMessages.get(10).getTitleId());
        assertEquals("EAS0037",exceptionMessages.get(10).getMessageId());
    }

    @Test
    public void testMaxSize() {
        int maxSize = baseConfig.getMaxSize();
        assertEquals(20000, maxSize);
    }
}

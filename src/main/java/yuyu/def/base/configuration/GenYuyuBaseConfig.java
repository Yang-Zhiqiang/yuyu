package yuyu.def.base.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.classification.C_BatchDousaModeKbn;

/**
 * baseパッケージ用 システム情報格納部品です。<br />
 * このソースはツールにより自動生成されたものです。業務静的定義に変更があると上書きされてしまいます。
 */
public class GenYuyuBaseConfig {

    public GenYuyuBaseConfig() {
    }

    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String pApplicationName) {
        applicationName = pApplicationName;
    }

    private String validationGroupsPackage;

    public String getValidationGroupsPackage() {
        return validationGroupsPackage;
    }

    public void setValidationGroupsPackage(String pValidationGroupsPackage) {
        validationGroupsPackage = pValidationGroupsPackage;
    }

    private String loginPageURI;

    public String getLoginPageURI() {
        return loginPageURI;
    }

    public void setLoginPageURI(String pLoginPageURI) {
        loginPageURI = pLoginPageURI;
    }

    private String sessionTimeoutPageURI;

    public String getSessionTimeoutPageURI() {
        return sessionTimeoutPageURI;
    }

    public void setSessionTimeoutPageURI(String pSessionTimeoutPageURI) {
        sessionTimeoutPageURI = pSessionTimeoutPageURI;
    }

    private String loginFailedErrorCd;

    public String getLoginFailedErrorCd() {
        return loginFailedErrorCd;
    }

    public void setLoginFailedErrorCd(String pLoginFailedErrorCd) {
        loginFailedErrorCd = pLoginFailedErrorCd;
    }

    private String loggedInErrorCd;

    public String getLoggedInErrorCd() {
        return loggedInErrorCd;
    }

    public void setLoggedInErrorCd(String pLoggedInErrorCd) {
        loggedInErrorCd = pLoggedInErrorCd;
    }

    private Integer identifierRefreshInterval;

    public Integer getIdentifierRefreshInterval() {
        return identifierRefreshInterval;
    }

    public void setIdentifierRefreshInterval(Integer pIdentifierRefreshInterval) {
        identifierRefreshInterval = pIdentifierRefreshInterval;
    }

    private Integer identifierLength;

    public Integer getIdentifierLength() {
        return identifierLength;
    }

    public void setIdentifierLength(Integer pIdentifierLength) {
        identifierLength = pIdentifierLength;
    }

    private C_BatchDousaModeKbn batchDousaModeKbn;

    public C_BatchDousaModeKbn getBatchDousaModeKbn() {
        return batchDousaModeKbn;
    }

    public void setBatchDousaModeKbn(C_BatchDousaModeKbn pBatchDousaModeKbn) {
        batchDousaModeKbn = pBatchDousaModeKbn;
    }

    private Integer batchRetryWaitTime;

    public Integer getBatchRetryWaitTime() {
        return batchRetryWaitTime;
    }

    public void setBatchRetryWaitTime(Integer pBatchRetryWaitTime) {
        batchRetryWaitTime = pBatchRetryWaitTime;
    }

    private Integer batchRetryCount;

    public Integer getBatchRetryCount() {
        return batchRetryCount;
    }

    public void setBatchRetryCount(Integer pBatchRetryCount) {
        batchRetryCount = pBatchRetryCount;
    }

    private String batchLogBeginMessage;

    public String getBatchLogBeginMessage() {
        return batchLogBeginMessage;
    }

    public void setBatchLogBeginMessage(String pBatchLogBeginMessage) {
        batchLogBeginMessage = pBatchLogBeginMessage;
    }

    private String batchLogEndMessage;

    public String getBatchLogEndMessage() {
        return batchLogEndMessage;
    }

    public void setBatchLogEndMessage(String pBatchLogEndMessage) {
        batchLogEndMessage = pBatchLogEndMessage;
    }

    private List<MessageIconEntry> messageIconEntryList = new ArrayList<>();

    public List<MessageIconEntry> getMessageIconEntryList() {
        return Collections.unmodifiableList(messageIconEntryList);
    }

    public void addMessageIconEntry(MessageIconEntry pMessageIconEntry) {
        messageIconEntryList.add(pMessageIconEntry);
    }

    private List<TokusyuKinou> tokusyuKinouList = new ArrayList<>();

    public List<TokusyuKinou> getTokusyuKinouList() {
        return Collections.unmodifiableList(tokusyuKinouList);
    }

    public void addTokusyuKinou(TokusyuKinou pTokusyuKinou) {
        tokusyuKinouList.add(pTokusyuKinou);
    }

    private String batchHost;

    public String getBatchHost() {
        return batchHost;
    }

    public void setBatchHost(String pBatchHost) {
        batchHost = pBatchHost;
    }

    private Integer batchPort;

    public Integer getBatchPort() {
        return batchPort;
    }

    public void setBatchPort(Integer pBatchPort) {
        batchPort = pBatchPort;
    }

    private String batchParamBean;

    public String getBatchParamBean() {
        return batchParamBean;
    }

    public void setBatchParamBean(String pBatchParamBean) {
        batchParamBean = pBatchParamBean;
    }

    private String batchOutputDir;

    public String getBatchOutputDir() {
        return batchOutputDir;
    }

    public void setBatchOutputDir(String pBatchOutputDir) {
        batchOutputDir = pBatchOutputDir;
    }

    private String batchInputDir;

    public String getBatchInputDir() {
        return batchInputDir;
    }

    public void setBatchInputDir(String pBatchInputDir) {
        batchInputDir = pBatchInputDir;
    }

    private String objStorageDir;

    public String getObjStorageDir() {
        return objStorageDir;
    }

    public void setObjStorageDir(String pObjStorageDir) {
        objStorageDir = pObjStorageDir;
    }

    private Integer maxShutokuKensu;

    public Integer getMaxShutokuKensu() {
        return maxShutokuKensu;
    }

    public void setMaxShutokuKensu(Integer pMaxShutokuKensu) {
        maxShutokuKensu = pMaxShutokuKensu;
    }

    private boolean subSystemEnableFlg;

    public boolean isSubSystemEnableFlg() {
        return subSystemEnableFlg;
    }

    public void setSubSystemEnableFlg(boolean pSubSystemEnableFlg) {
        subSystemEnableFlg = pSubSystemEnableFlg;
    }

    private boolean debugMode;

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean pDebugMode) {
        debugMode = pDebugMode;
    }

    private String dateTimeNotShowSubSystemGroup;

    public String getDateTimeNotShowSubSystemGroup() {
        return dateTimeNotShowSubSystemGroup;
    }

    public void setDateTimeNotShowSubSystemGroup(String pDateTimeNotShowSubSystemGroup) {
        dateTimeNotShowSubSystemGroup = pDateTimeNotShowSubSystemGroup;
    }

    private String addressMasterCsvFileName;

    public String getAddressMasterCsvFileName() {
        return addressMasterCsvFileName;
    }

    public void setAddressMasterCsvFileName(String pAddressMasterCsvFileName) {
        addressMasterCsvFileName = pAddressMasterCsvFileName;
    }

    private List<ExceptionMessage> exceptionMessageList = new ArrayList<>();

    public List<ExceptionMessage> getExceptionMessageList() {
        return Collections.unmodifiableList(exceptionMessageList);
    }

    public void addExceptionMessage(ExceptionMessage pExceptionMessage) {
        exceptionMessageList.add(pExceptionMessage);
    }

    private Integer maxSize;

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer pMaxSize) {
        maxSize = pMaxSize;
    }
}

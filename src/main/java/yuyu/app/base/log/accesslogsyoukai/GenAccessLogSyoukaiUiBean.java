package yuyu.app.base.log.accesslogsyoukai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.TimeHM;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_AccessLog;

/**
 * アクセスログ照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenAccessLogSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private AM_User user;

    public AM_User getUser() {
        return user;
    }

    public void setUser(AM_User pUser) {
        user = pUser;
    }

    @Inject
    private AS_Kinou kinou;

    public AS_Kinou getKinou() {
        return kinou;
    }

    public void setKinou(AS_Kinou pKinou) {
        kinou = pKinou;
    }

    @Inject
    private AT_AccessLog accessLog;

    public AT_AccessLog getAccessLog() {
        return accessLog;
    }

    public void setAccessLog(AT_AccessLog pAccessLog) {
        accessLog = pAccessLog;
    }

    private DataSource<AccessLogInfoListDataSourceBean> accessLogInfoListDataSource = new DataSource<>();
    public DataSource<AccessLogInfoListDataSourceBean> getAccessLogInfoListDataSource() {
        return accessLogInfoListDataSource;
    }

    @Deprecated
    public List<AccessLogInfoListDataSourceBean> getAccessLogInfoList() {
        return accessLogInfoListDataSource.getDatas();
    }

    public void setAccessLogInfoList(List<AccessLogInfoListDataSourceBean> pAccessLogInfoList) {
        accessLogInfoListDataSource.setDatas(pAccessLogInfoList, 10);
    }

    private DataSource<AccessDetailLogInfoDataSourceBean> accessDetailLogInfoDataSource = new DataSource<>();
    public DataSource<AccessDetailLogInfoDataSourceBean> getAccessDetailLogInfoDataSource() {
        return accessDetailLogInfoDataSource;
    }

    @Deprecated
    public List<AccessDetailLogInfoDataSourceBean> getAccessDetailLogInfo() {
        return accessDetailLogInfoDataSource.getDatas();
    }

    public void setAccessDetailLogInfo(List<AccessDetailLogInfoDataSourceBean> pAccessDetailLogInfo) {
        accessDetailLogInfoDataSource.setDatas(pAccessDetailLogInfo, 10);
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCategoryId(String pCategoryId) {
        categoryId = pCategoryId;
    }

    private C_KinouKbn kinouKbn;

    public C_KinouKbn getKinouKbn() {
        return kinouKbn;
    }

    public void setKinouKbn(C_KinouKbn pKinouKbn) {
        kinouKbn = pKinouKbn;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    @MaxLength(max=30)
    @AlphaDigit
    private String userId;

    public String getUserId() {
        return userId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    private String ipAddress;

    public String getIpAddress() {
        return ipAddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIpAddress(String pIpAddress) {
        ipAddress = pIpAddress;
    }

    @ValidDate
    private BizDate syoriYmdFrom;

    public BizDate getSyoriYmdFrom() {
        return syoriYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdFrom(BizDate pSyoriYmdFrom) {
        syoriYmdFrom = pSyoriYmdFrom;
    }

    @TimeHM
    private String syoriTimeFrom;

    public String getSyoriTimeFrom() {
        return syoriTimeFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTimeFrom(String pSyoriTimeFrom) {
        syoriTimeFrom = pSyoriTimeFrom;
    }

    @ValidDate
    private BizDate syoriYmdTo;

    public BizDate getSyoriYmdTo() {
        return syoriYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmdTo(BizDate pSyoriYmdTo) {
        syoriYmdTo = pSyoriYmdTo;
    }

    @TimeHM
    private String syoriTimeTo;

    public String getSyoriTimeTo() {
        return syoriTimeTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTimeTo(String pSyoriTimeTo) {
        syoriTimeTo = pSyoriTimeTo;
    }

    private C_AccessLogSyubetuKbn logKindCd;

    public C_AccessLogSyubetuKbn getLogKindCd() {
        return logKindCd;
    }

    public void setLogKindCd(C_AccessLogSyubetuKbn pLogKindCd) {
        logKindCd = pLogKindCd;
    }

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSessionId(String pSessionId) {
        sessionId = pSessionId;
    }

    private String syoriTime;

    public String getSyoriTime() {
        return syoriTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriTime(String pSyoriTime) {
        syoriTime = pSyoriTime;
    }

    private LoopChain<UserDefsList> subSystemIdOptionBeanList = new LoopChain<>();
    public UserDefsList getSubSystemIdOptionBeanList() {
        return subSystemIdOptionBeanList.get();
    }

    public void setSubSystemIdOptionBeanList(UserDefsList pSubSystemIdOptionBeanList) {
        clearSubSystemIdOptionBeanList();
        subSystemIdOptionBeanList.add(pSubSystemIdOptionBeanList);
    }

    public void clearSubSystemIdOptionBeanList() {
        subSystemIdOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> categoryIdOptionBeanList = new LoopChain<>();
    public UserDefsList getCategoryIdOptionBeanList() {
        return categoryIdOptionBeanList.get();
    }

    public void setCategoryIdOptionBeanList(UserDefsList pCategoryIdOptionBeanList) {
        clearCategoryIdOptionBeanList();
        categoryIdOptionBeanList.add(pCategoryIdOptionBeanList);
    }

    public void clearCategoryIdOptionBeanList() {
        categoryIdOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> kinouIdOptionBeanList = new LoopChain<>();
    public UserDefsList getKinouIdOptionBeanList() {
        return kinouIdOptionBeanList.get();
    }

    public void setKinouIdOptionBeanList(UserDefsList pKinouIdOptionBeanList) {
        clearKinouIdOptionBeanList();
        kinouIdOptionBeanList.add(pKinouIdOptionBeanList);
    }

    public void clearKinouIdOptionBeanList() {
        kinouIdOptionBeanList.clear();
    }
}

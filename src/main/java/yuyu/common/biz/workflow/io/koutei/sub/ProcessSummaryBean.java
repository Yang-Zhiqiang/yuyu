package yuyu.common.biz.workflow.io.koutei.sub;

import java.io.Serializable;

/**
 * 工程サマリ情報のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class ProcessSummaryBean implements Serializable {


    private String flowId_;

    private String gyoumukey_;

    private String jimukaisiYmd_;

    private String kouteiKaisiYmd_;

    private String kouteikanryouYmd_;

    private String processstatus_;

    private String updateTime_;

    private String firstAccountId_;

    private String previousAccountId_;

    private String previousNodeName_;

    private String previousNodeLocalname_;

    private String currentAccountId_;

    private String currentNodeName_;

    private String currentNodeLocalname_;

    private String groupId_;

    private ExtParamBean extparamBean_;


    public String getFlowId() {
        return flowId_;
    }

    public void setFlowId(String pFlowId) {
        this.flowId_ = pFlowId;
    }

    public String getJimukaisiYmd() {
        return jimukaisiYmd_;
    }

    public void setJimukaisiYmd(String pJimukaisiYmd) {
        this.jimukaisiYmd_ = pJimukaisiYmd;
    }

    public String getKouteiKaisiYmd() {
        return kouteiKaisiYmd_;
    }

    public void setKouteiKaisiYmd(String pKouteiKaisiYmd) {
        kouteiKaisiYmd_ = pKouteiKaisiYmd;
    }

    public String getKouteikanryouYmd() {
        return kouteikanryouYmd_;
    }
    public void setKouteikanryouYmd(String pKouteikanryouYmd) {
        kouteikanryouYmd_ = pKouteikanryouYmd;
    }

    public String getProcessstatus() {
        return processstatus_;
    }

    public void setProcessstatus(String pProcessstatus) {
        processstatus_ = pProcessstatus;
    }

    public String getUpdateTime() {
        return updateTime_;
    }

    public void setUpdateTime(String pUpdateTime) {
        updateTime_ = pUpdateTime;
    }

    public String getFirstAccountId() {
        return firstAccountId_;
    }

    public void setFirstAccountId(String pFirstAccountId) {
        firstAccountId_ = pFirstAccountId;
    }

    public String getPreviousAccountId() {
        return previousAccountId_;
    }

    public void setPreviousAccountId(String pPreviousAccountId) {
        previousAccountId_ = pPreviousAccountId;
    }

    public String getPreviousNodeName() {
        return previousNodeName_;
    }

    public void setPreviousNodeName(String pPreviousNodeName) {
        previousNodeName_ = pPreviousNodeName;
    }

    public String getPreviousNodeLocalname() {
        return previousNodeLocalname_;
    }

    public void setPreviousNodeLocalname(String pPreviousNodeLocalname) {
        previousNodeLocalname_ = pPreviousNodeLocalname;
    }

    public String getCurrentAccountId() {
        return currentAccountId_;
    }

    public void setCurrentAccountId(String pCurrentAccountId) {
        this.currentAccountId_ = pCurrentAccountId;
    }

    public String getCurrentNodeName() {
        return currentNodeName_;
    }

    public void setCurrentNodeName(String pCurrentNodeName) {
        currentNodeName_ = pCurrentNodeName;
    }

    public String getCurrentNodeLocalname() {
        return currentNodeLocalname_;
    }

    public void setCurrentNodeLocalname(String pCurrentNodeLocalname) {
        currentNodeLocalname_ = pCurrentNodeLocalname;
    }

    public String getGyoumukey() {
        return gyoumukey_;
    }

    public void setGyoumukey(String pGyoumukey) {
        gyoumukey_ = pGyoumukey;
    }

    public String getGroupId() {
        return groupId_;
    }

    public void setGroupId(String pGroupId) {
        groupId_ = pGroupId;
    }

    public ExtParamBean getExtparamBean() {
        return extparamBean_;
    }

    public void setExtparamBean(ExtParamBean pExtparamBean) {
        extparamBean_ = pExtparamBean;
    }
}

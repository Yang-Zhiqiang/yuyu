package yuyu.common.biz.workflow.io.koutei.sub;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 工程履歴情報のBeanです。<br/>
 */
@SuppressWarnings("serial")
public class ProcessRecordBean implements Serializable {



    private String gyoumukey_;

    private String flowId_;

    private String flowName_;

    private String nodeName_;

    private String nodeLocalName_;

    private String accountId_;

    private String syoriKbn_;

    private String rirekiKbn_;

    private String rirekiMessage_;

    private List<Map<String, String>> extinfos_;

    private String syoriTime_;


    public String getSyoriTime() {
        return syoriTime_;
    }

    public void setSyoriTime(String pSyoriTime) {
        syoriTime_ = pSyoriTime;
    }

    public String getGyoumukey() {
        return gyoumukey_;
    }

    public void setGyoumukey(String pGyoumukey) {
        gyoumukey_ = pGyoumukey;
    }

    public String getFlowId() {
        return flowId_;
    }

    public void setFlowId(String pFlowId) {
        flowId_ = pFlowId;
    }

    public String getFlowName() {
        return flowName_;
    }

    public void setFlowName(String pFlowName) {
        flowName_ = pFlowName;
    }

    public String getNodeName() {
        return nodeName_;
    }

    public void setNodeName(String pNodeName) {
        nodeName_ = pNodeName;
    }
    public String getNodeLocalName() {
        return nodeLocalName_;
    }

    public void setNodeLocalName(String pNodeLocalName) {
        nodeLocalName_ = pNodeLocalName;
    }

    public String getAccountId() {
        return accountId_;
    }

    public void setAccountId(String pAccountId) {
        accountId_ = pAccountId;
    }

    public String getSyoriKbn() {
        return syoriKbn_;
    }
    public void setSyoriKbn(String pSyoriKbn) {
        syoriKbn_ = pSyoriKbn;
    }

    public String getRirekiKbn() {
        return rirekiKbn_;
    }

    public void setRirekiKbn(String pRirekiKbn) {
        rirekiKbn_ = pRirekiKbn;
    }

    public String getRirekiMessage() {
        return rirekiMessage_;
    }

    public void setRirekiMessage(String pRirekiMessage) {
        rirekiMessage_ = pRirekiMessage;
    }

    public List<Map<String, String>> getExtinfo() {
        return extinfos_;
    }

    public void setExtinfo(List<Map<String, String>> pExtinfo) {
        extinfos_ = pExtinfo;
    }
}

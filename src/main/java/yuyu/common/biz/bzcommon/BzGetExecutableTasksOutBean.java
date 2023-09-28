package yuyu.common.biz.bzcommon;

import java.io.Serializable;
import java.util.List;

/**
 * 業務共通 共通 業務共通実行可能タスク情報取得出力Beanクラス
 */
public class BzGetExecutableTasksOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriKekkaStatus;

    private String syousaiMessageCd;

    private String syousaiMessage;

    private List<BzGetExecutableTasksBean> bzGetExecutableTasksBeanList;

    public String getSyoriKekkaStatus() {
        return syoriKekkaStatus;
    }

    public void setSyoriKekkaStatus(String pSyoriKekkaStatus) {
        this.syoriKekkaStatus = pSyoriKekkaStatus;
    }

    public String getSyousaiMessageCd() {
        return syousaiMessageCd;
    }

    public void setSyousaiMessageCd(String pSyousaiMessageCd) {
        this.syousaiMessageCd = pSyousaiMessageCd;
    }

    public String getSyousaiMessage() {
        return syousaiMessage;
    }

    public void setSyousaiMessage(String pSyousaiMessage) {
        this.syousaiMessage = pSyousaiMessage;
    }

    public List<BzGetExecutableTasksBean> getBzGetExecutableTasksBeanList() {
        return bzGetExecutableTasksBeanList;
    }

    public void setBzGetExecutableTasksBeanList(List<BzGetExecutableTasksBean> pBzGetExecutableTasksBeanList) {
        this.bzGetExecutableTasksBeanList = pBzGetExecutableTasksBeanList;
    }
}
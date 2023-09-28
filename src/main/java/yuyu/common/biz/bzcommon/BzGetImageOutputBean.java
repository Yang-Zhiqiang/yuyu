package yuyu.common.biz.bzcommon;

import java.io.Serializable;
import java.util.List;

/**
 * 業務共通 共通 業務共通イメージ取得出力Beanクラス
 */
public class BzGetImageOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriKekkaStatus;

    private String syousaiMessageCd;

    private String syousaiMessage;

    private List<BzImageInfoBean> bzImageInfoBeanList;

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

    public List<BzImageInfoBean> getBzImageInfoBeanList() {
        return bzImageInfoBeanList;
    }

    public void setBzImageInfoBeanList(List<BzImageInfoBean> pBzImageInfoBeanList) {
        this.bzImageInfoBeanList = pBzImageInfoBeanList;
    }
}
package yuyu.common.biz.bzcommon;

/**
 * 業務共通 共通 業務共通イメージ削除出力Bean
 */
public class BzDropImageOutputBean {

    private String kekkaStatus;

    private String syousaiMsgCd;

    private String syousaiMsg;

    public String getKekkaStatus() {
        return kekkaStatus;
    }

    public void setKekkaStatus(String pKekkaStatus) {
        kekkaStatus = pKekkaStatus;
    }

    public String getSyousaiMsgCd() {
        return syousaiMsgCd;
    }

    public void setSyousaiMsgCd(String pSyousaiMsgCd) {
        syousaiMsgCd = pSyousaiMsgCd;
    }

    public String getSyousaiMsg() {
        return syousaiMsg;
    }

    public void setSyousaiMsg(String pSyousaiMsg) {
        syousaiMsg = pSyousaiMsg;
    }

}

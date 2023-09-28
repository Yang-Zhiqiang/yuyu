package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * 業務共通 共通 業務共通イメージ登録出力Bean
 */
public class BzPutImageOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kekkaStatus;

    private String syousaiMsgCd;

    private String syousaiMsg;

    private String imageId;

    public String getKekkaStatus() {
        return kekkaStatus;
    }

    public void setKekkaStatus(String pKekkaStatus) {
        this.kekkaStatus = pKekkaStatus;
    }

    public String getSyousaiMsgCd() {
        return syousaiMsgCd;
    }

    public void setSyousaiMsgCd(String pSyousaiMsgCd) {
        this.syousaiMsgCd = pSyousaiMsgCd;
    }

    public String getSyousaiMsg() {
        return syousaiMsg;
    }

    public void setSyousaiMsg(String pSyousaiMsg) {
        this.syousaiMsg = pSyousaiMsg;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String pImageId) {
        this.imageId = pImageId;
    }
}

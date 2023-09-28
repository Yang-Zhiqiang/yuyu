package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * 業務共通 工程 業務共通工程情報更新（バッチ用）出力Beanクラス
 */
public class BzProcessUpdateForBatchOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kekkaStatus;

    private String syousaiMsgCd;

    private String syousaiMsg;

    private String errKouteiKanriId;

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

    public String getErrKouteiKanriId() {
        return errKouteiKanriId;
    }

    public void setErrKouteiKanriId(String pErrKouteiKanriId) {
        this.errKouteiKanriId = pErrKouteiKanriId;
    }
}

package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;
import java.util.List;

import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;

/**
 * 新契約 新契約共通 新契約当日異動内容取消結果Bean
 */

public class SkIdounaiyouTorikesiKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mosNo;

    private String youkyuuNo;

    private C_KyknaiyouhaneiErrKbn kyknaiyouhaneiErrKbn;

    private List<String> ErrorMsgLst;

    public String getMosNo() {
        return mosNo;
    }

    public void setMosNo(String pMosNo) {
        this.mosNo = pMosNo;
    }

    public String getYoukyuuNo() {
        return youkyuuNo;
    }

    public void setYoukyuuNo(String pYoukyuuNo) {
        this.youkyuuNo = pYoukyuuNo;
    }

    public C_KyknaiyouhaneiErrKbn getKyknaiyouhaneiErrKbn() {
        return kyknaiyouhaneiErrKbn;
    }

    public void setKyknaiyouhaneiErrKbn(C_KyknaiyouhaneiErrKbn pKyknaiyouhaneiErrKbn) {
        this.kyknaiyouhaneiErrKbn = pKyknaiyouhaneiErrKbn;
    }

    public List<String> getErrorMsgLst() {
        return ErrorMsgLst;
    }

    public void setErrorMsgLst(List<String> pErrorMsgLst) {
        ErrorMsgLst = pErrorMsgLst;
    }
}
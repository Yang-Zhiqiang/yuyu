package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;
import java.util.List;

import yuyu.def.classification.C_ErrorKbn;

/**
 * 新契約 新契約共通 新契約当日異動内容実行結果Bean
 */

public class SkIdounaiyouKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private List<String> errorMsgLst;

    private String youkyuuno;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKbn) {
        this.errorKbn = pErrorKbn;
    }

    public List<String> getErrorMsgLst() {
        return errorMsgLst;
    }

    public void setErrorMsgLst(List<String> pErrorMsgLst) {
        errorMsgLst = pErrorMsgLst;
    }

    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }
}
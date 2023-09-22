package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_VrfjkKbn;

/**
 * 新契約 工程 申込書入力分岐条件Bean
 */
public class SkInputMosRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skkouteikanryouKbn;

    private String mosuketukeKbn;

    private String mosnrkvrfjkKbn;

    public SkInputMosRuleBean() {
        super();

        skkouteikanryouKbn = C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.BLNK)
            );
        mosuketukeKbn = C_MosUketukeKbn.getContentByValue(
            C_MosUketukeKbn.PATTERN_DEFAULT,
            String.valueOf(C_MosUketukeKbn.BLNK)
            );
        mosnrkvrfjkKbn = C_VrfjkKbn.getContentByValue(
            C_VrfjkKbn.PATTERN_DEFAULT,
            String.valueOf(C_VrfjkKbn.TSHN_MIJISSI)
            );
    }

    public String getSkkouteikanryouKbn() {
        return skkouteikanryouKbn;
    }

    public void setSkkouteikanryouKbn(String pSkkouteikanryouKbn) {
        skkouteikanryouKbn = pSkkouteikanryouKbn;
    }

    public String getMosuketukeKbn() {
        return mosuketukeKbn;
    }

    public void setMosuketukeKbn(String pMosuketukeKbn) {
        mosuketukeKbn = pMosuketukeKbn;
    }

    public String getMosnrkvrfjkKbn() {
        return mosnrkvrfjkKbn;
    }

    public void setMosnrkvrfjkKbn(String pMosnrkvrfjkKbn) {
        mosnrkvrfjkKbn = pMosnrkvrfjkKbn;
    }

}

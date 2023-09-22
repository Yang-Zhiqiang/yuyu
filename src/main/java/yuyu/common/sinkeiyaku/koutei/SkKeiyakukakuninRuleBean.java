package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;

/**
 * 新契約 工程 契約確認分岐条件Bean
 */
public class SkKeiyakukakuninRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skkouteikanryouKbn;

    private String seirituKbn;

    private String ketteiKbn;

    private String kykkakjkKbn;

    public SkKeiyakukakuninRuleBean() {
        super();

        skkouteikanryouKbn = C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.BLNK)
            );
        seirituKbn = C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(C_SeirituKbn.BLNK)
            );
        ketteiKbn = C_KetteiKbn.getContentByValue(
            C_KetteiKbn.PATTERN_DEFAULT,
            String.valueOf(C_KetteiKbn.BLNK)
            );
        kykkakjkKbn = C_KykkakjkKbn.getContentByValue(
            C_KykkakjkKbn.PATTERN_DEFAULT,
            String.valueOf(C_KykkakjkKbn.NONE)
            );
    }

    public String getSkkouteikanryouKbn() {
        return skkouteikanryouKbn;
    }

    public void setSkkouteikanryouKbn(String pSkkouteikanryouKbn) {
        skkouteikanryouKbn = pSkkouteikanryouKbn;
    }

    public String getSeirituKbn() {
        return seirituKbn;
    }

    public void setSeirituKbn(String pSeirituKbn) {
        seirituKbn = pSeirituKbn;
    }

    public String getKetteiKbn() {
        return ketteiKbn;
    }

    public void setKetteiKbn(String pKetteiKbn) {
        ketteiKbn = pKetteiKbn;
    }

    public String getKykkakjkKbn() {
        return kykkakjkKbn;
    }

    public void setKykkakjkKbn(String pKykkakjkKbn) {
        kykkakjkKbn = pKykkakjkKbn;
    }

}

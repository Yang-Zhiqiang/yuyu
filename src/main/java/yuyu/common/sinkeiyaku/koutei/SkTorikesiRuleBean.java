package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 工程 申込取消分岐条件Bean
 */
public class SkTorikesiRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skkouteikanryouKbn;

    private String seirituKbn;

    private String mosnrkUmu;

    public SkTorikesiRuleBean() {
        super();

        skkouteikanryouKbn = C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.BLNK)
            );
        seirituKbn = C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(C_SeirituKbn.BLNK)
            );
        mosnrkUmu = C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(C_UmuKbn.NONE)
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

    public String getMosnrkUmu() {
        return mosnrkUmu;
    }

    public void setMosnrkUmu(String pMosnrkUmu) {
        mosnrkUmu = pMosnrkUmu;
    }
}

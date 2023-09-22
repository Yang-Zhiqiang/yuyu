package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_HubikaisyoujoutaiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;

/**
 * 新契約 工程 新契約不備解消分岐条件Bean
 */
public class SkHubiKaisyouRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skkouteikanryouKbn;

    private String seirituKbn;

    private String hubikaisyoujoutaiKbn;

    public SkHubiKaisyouRuleBean() {
        super();

        skkouteikanryouKbn = C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.BLNK)
            );
        seirituKbn = C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(C_SeirituKbn.BLNK)
            );
        hubikaisyoujoutaiKbn = C_HubikaisyoujoutaiKbn.getContentByValue(
            C_HubikaisyoujoutaiKbn.PATTERN_DEFAULT,
            String.valueOf(C_HubikaisyoujoutaiKbn.BLNK)
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

    public String getHubikaisyoujoutaiKbn() {
        return hubikaisyoujoutaiKbn;
    }

    public void setHubikaisyoujoutaiKbn(String pHubikaisyoujoutaiKbn) {
        hubikaisyoujoutaiKbn = pHubikaisyoujoutaiKbn;
    }

}

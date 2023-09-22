package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_VrfjkKbn;

/**
 * 新契約 工程 申込点検分岐条件Bean
 */
public class SkTenkenRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skkouteikanryouKbn;

    private String seirituKbn;

    private String mosnrkUmu;

    private String sntkhouKbn;

    private String kktnrkUmu;

    private String kktnrkvrfjkKbn;

    private String mostenkenjouKbn;

    public SkTenkenRuleBean() {
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
        sntkhouKbn = C_SntkhouKbn.getContentByValue(
            C_SntkhouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SntkhouKbn.BLNK)
            );
        kktnrkUmu = C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(C_UmuKbn.NONE)
            );
        kktnrkvrfjkKbn = C_VrfjkKbn.getContentByValue(
            C_VrfjkKbn.PATTERN_DEFAULT,
            String.valueOf(C_VrfjkKbn.TSHN_MIJISSI)
            );
        mostenkenjouKbn = C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(C_MostenkenjyouKbn.NONE)
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

    public String getSntkhouKbn() {
        return sntkhouKbn;
    }

    public void setSntkhouKbn(String pSntkhouKbn) {
        sntkhouKbn = pSntkhouKbn;
    }

    public String getKktnrkUmu() {
        return kktnrkUmu;
    }

    public void setKktnrkUmu(String pKktnrkUmu) {
        kktnrkUmu = pKktnrkUmu;
    }

    public String getKktnrkvrfjkKbn() {
        return kktnrkvrfjkKbn;
    }

    public void setKktnrkvrfjkKbn(String pKktnrkvrfjkKbn) {
        kktnrkvrfjkKbn = pKktnrkvrfjkKbn;
    }

    public String getMostenkenjouKbn() {
        return mostenkenjouKbn;
    }

    public void setMostenkenjouKbn(String pMostenkenjouKbn) {
        mostenkenjouKbn = pMostenkenjouKbn;
    }

}

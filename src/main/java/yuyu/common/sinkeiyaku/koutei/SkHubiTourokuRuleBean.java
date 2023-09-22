package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_HubihassintnsKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 工程 新契約不備登録分岐条件Bean
 */
public class SkHubiTourokuRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skkouteikanryouKbn;

    private String seirituKbn;

    private String mostenkenyhKbn;

    private String mostenkenjouKbn;

    private String mihassinhubiUmu;

    private String hubihassintnsUmu;

    private String hubitourokuUmu;

    private String kthhbKbn;

    public SkHubiTourokuRuleBean() {
        super();

        skkouteikanryouKbn = C_SkkouteikanryouKbn.getContentByValue(
            C_SkkouteikanryouKbn.PATTERN_DEFAULT,
            String.valueOf(C_SkkouteikanryouKbn.BLNK)
            );
        seirituKbn = C_SeirituKbn.getContentByValue(
            C_SeirituKbn.PATTERN_DEFAULT,
            String.valueOf(C_SeirituKbn.BLNK)
            );
        mostenkenyhKbn = C_MostenkenyhKbn.getContentByValue(
            C_MostenkenyhKbn.PATTERN_DEFAULT,
            String.valueOf(C_MostenkenyhKbn.NONE)
            );
        mostenkenjouKbn = C_MostenkenjyouKbn.getContentByValue(
            C_MostenkenjyouKbn.PATTERN_DEFAULT,
            String.valueOf(C_MostenkenjyouKbn.NONE)
            );
        mihassinhubiUmu = C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(C_UmuKbn.NONE)
            );
        hubihassintnsUmu = C_HubihassintnsKbn.getContentByValue(
            C_HubihassintnsKbn.PATTERN_DEFAULT,
            String.valueOf(C_HubihassintnsKbn.BLNK)
            );
        hubitourokuUmu = C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(C_UmuKbn.NONE)
            );
        kthhbKbn = C_UmuKbn.getContentByValue(
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

    public String getMostenkenyhKbn() {
        return mostenkenyhKbn;
    }

    public void setMostenkenyhKbn(String pMostenkenyhKbn) {
        mostenkenyhKbn = pMostenkenyhKbn;
    }

    public String getMostenkenjouKbn() {
        return mostenkenjouKbn;
    }

    public void setMostenkenjouKbn(String pMostenkenjouKbn) {
        mostenkenjouKbn = pMostenkenjouKbn;
    }

    public String getMihassinhubiUmu() {
        return mihassinhubiUmu;
    }

    public void setMihassinhubiUmu(String pMihassinhubiUmu) {
        mihassinhubiUmu = pMihassinhubiUmu;
    }

    public String getHubihassintnsUmu() {
        return hubihassintnsUmu;
    }

    public void setHubihassintnsUmu(String pHubihassintnsUmu) {
        hubihassintnsUmu = pHubihassintnsUmu;
    }

    public String getHubitourokuUmu() {
        return hubitourokuUmu;
    }

    public void setHubitourokuUmu(String pHubitourokuUmu) {
        hubitourokuUmu = pHubitourokuUmu;
    }

    public String getKthhbKbn() {
        return kthhbKbn;
    }

    public void setKthhbKbn(String pKthhbKbn) {
        kthhbKbn = pKthhbKbn;
    }

}

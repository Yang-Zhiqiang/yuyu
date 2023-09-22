package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_MostenkenjyouKbn;
import yuyu.def.classification.C_MostenkenyhKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkkouteikanryouKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 工程 医務査定分岐条件Bean
 */
public class SkImuRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String skkouteikanryouKbn;

    private String seirituKbn;

    private String mostenkenyhKbn;

    private String mostenkenjouKbn;

    private String imusateijyouKbn;

    private String kthhbKbn;

    public SkImuRuleBean() {
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
        imusateijyouKbn = C_ImusateijyouKbn.getContentByValue(
            C_ImusateijyouKbn.PATTERN_DEFAULT,
            String.valueOf(C_ImusateijyouKbn.NONE)
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

    public String getImusateijyouKbn() {
        return imusateijyouKbn;
    }

    public void setImusateijyouKbn(String pImusateijyouKbn) {
        imusateijyouKbn = pImusateijyouKbn;
    }

    public String getKthhbKbn() {
        return kthhbKbn;
    }

    public void setKthhbKbn(String pKthhbKbn) {
        kthhbKbn = pKthhbKbn;
    }

}

package yuyu.common.sinkeiyaku.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 工程 新契約返金分岐条件Bean
 */
public class SkHenkinRuleBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nyknnrkUmu;

    private String pkakinUmu;

    public SkHenkinRuleBean() {
        super();

        nyknnrkUmu = C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(C_UmuKbn.NONE)
            );
        pkakinUmu = C_UmuKbn.getContentByValue(
            C_UmuKbn.PATTERN_DEFAULT,
            String.valueOf(C_UmuKbn.NONE)
            );
    }

    public String getNyknnrkUmu() {
        return nyknnrkUmu;
    }

    public void setNyknnrkUmu(String pNyknnrkUmu) {
        nyknnrkUmu = pNyknnrkUmu;
    }

    public String getPkakinUmu() {
        return pkakinUmu;
    }

    public void setPkakinUmu(String pPkakinUmu) {
        pkakinUmu = pPkakinUmu;
    }

}

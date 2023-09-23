package yuyu.common.hozen.khcommon;

import java.io.Serializable;

/**
 * 契約保全 契約保全共通 通知区分Bean
 */
public class TuutiKbnBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String omttutKbn;

    private String urtutKbn;

    public TuutiKbnBean() {
        super();
    }

    public String getOmttutKbn() {
        return omttutKbn;
    }

    public void setOmttutKbn(String pOmttutKbn) {
        omttutKbn = pOmttutKbn;
    }

    public String getUrtutKbn() {
        return urtutKbn;
    }

    public void setUrtutKbn(String pUrtutKbn) {
        urtutKbn = pUrtutKbn;
    }
}

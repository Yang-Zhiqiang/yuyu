package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_NayoseJissiKekkaKbn;

/**
 * ダイレクト ダイレクト共通 ＤＳ名寄せBean
 */
public class DsNayoseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_NayoseJissiKekkaKbn nayoseJissiKekkaKbn;

    private String kokno;

    public DsNayoseBean() {
        super();
        this.kokno = "";
    }

    public C_NayoseJissiKekkaKbn getNayoseJissiKekkaKbn() {
        return this.nayoseJissiKekkaKbn;
    }

    public void setNayoseJissiKekkaKbn(C_NayoseJissiKekkaKbn pNayoseJissiKekkaKbn) {
        this.nayoseJissiKekkaKbn = pNayoseJissiKekkaKbn;
    }

    public String getKokno() {
        return this.kokno;
    }

    public void setKokno(String pKokno) {
        this.kokno = pKokno;
    }
}

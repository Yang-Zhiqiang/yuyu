package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 受取口座情報Bean<br/>
 */
public class UketoriKouzaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_UktsyuKbn uktsyuKbn;

    private C_KouzasyuruiKbn kzsyuruiKbn;

    private String bankCd;

    private String sitenCd;

    private String bankNmkj;

    private String sitenNmkj;

    private C_YokinKbn yokinKbn;

    private String kouzaNo;

    private String kzmeigiNmkn;

    public C_UktsyuKbn getUktsyuKbn() {
        return uktsyuKbn;
    }

    public void setUktsyuKbn(C_UktsyuKbn pUktsyuKbn) {
        this.uktsyuKbn = pUktsyuKbn;
    }

    public C_KouzasyuruiKbn getKzsyuruiKbn() {
        return kzsyuruiKbn;
    }

    public void setKzsyuruiKbn(C_KouzasyuruiKbn pKzsyuruiKbn) {
        this.kzsyuruiKbn = pKzsyuruiKbn;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String pBankCd) {
        this.bankCd = pBankCd;
    }

    public String getSitenCd() {
        return sitenCd;
    }

    public void setSitenCd(String pSitenCd) {
        this.sitenCd = pSitenCd;
    }

    public String getBankNmkj() {
        return bankNmkj;
    }

    public void setBankNmkj(String pBankNmkj) {
        this.bankNmkj = pBankNmkj;
    }

    public String getSitenNmkj() {
        return sitenNmkj;
    }

    public void setSitenNmkj(String pSitenNmkj) {
        this.sitenNmkj = pSitenNmkj;
    }

    public C_YokinKbn getYokinKbn() {
        return yokinKbn;
    }

    public void setYokinKbn(C_YokinKbn pYokinKbn) {
        this.yokinKbn = pYokinKbn;
    }

    public String getKouzaNo() {
        return kouzaNo;
    }

    public void setKouzaNo(String pKouzaNo) {
        this.kouzaNo = pKouzaNo;
    }

    public String getKzmeigiNmkn() {
        return kzmeigiNmkn;
    }

    public void setKzmeigiNmkn(String pKzmeigiNmkn) {
        this.kzmeigiNmkn = pKzmeigiNmkn;
    }
}

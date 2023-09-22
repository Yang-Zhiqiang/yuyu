package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;

/**
 * 新契約 新契約共通 契約者情報Bean
 */
public class KeiyakusyaInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kyknmkn;

    private String kyknmkj;

    private C_KjkhukaKbn kyknmkjkhukakbn;

    private C_Kyksei kyksei;

    private BizDate kykseiymd;

    private Integer kyknen;

    private String kykkinmusakinm;

    public String getKyknmkn() {
        return kyknmkn;
    }

    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    public String getKyknmkj() {
        return kyknmkj;
    }

    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
    }

    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    public String getKykkinmusakinm() {
        return kykkinmusakinm;
    }

    public void setKykkinmusakinm(String pKykkinmusakinm) {
        kykkinmusakinm = pKykkinmusakinm;
    }
}

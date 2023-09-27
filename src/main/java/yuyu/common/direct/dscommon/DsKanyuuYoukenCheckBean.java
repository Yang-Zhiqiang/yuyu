package yuyu.common.direct.dscommon;

import java.io.Serializable;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ加入要件チェックBean<br />
 */
public class DsKanyuuYoukenCheckBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn dsKanyuuYoukenCheckKbn;

    private C_UmuKbn kyksyaYisiNouryoukuNasiUmuKbn;

    private C_UmuKbn kyksyaYukueFumeiUmuKbn;

    public C_ErrorKbn getDsKanyuuYoukenCheckKbn() {
        return dsKanyuuYoukenCheckKbn;
    }

    public void setDsKanyuuYoukenCheckKbn(C_ErrorKbn pDsKanyuuYoukenCheckKbn) {
        this.dsKanyuuYoukenCheckKbn = pDsKanyuuYoukenCheckKbn;
    }

    public C_UmuKbn getKyksyaYisiNouryoukuNasiUmuKbn() {
        return kyksyaYisiNouryoukuNasiUmuKbn;
    }

    public void setKyksyaYisiNouryoukuNasiUmuKbn(C_UmuKbn pKyksyaYisiNouryoukuNasiUmuKbn) {
        this.kyksyaYisiNouryoukuNasiUmuKbn = pKyksyaYisiNouryoukuNasiUmuKbn;
    }

    public C_UmuKbn getKyksyaYukueFumeiUmuKbn() {
        return kyksyaYukueFumeiUmuKbn;
    }

    public void setKyksyaYukueFumeiUmuKbn(C_UmuKbn pKyksyaYukueFumeiUmuKbn) {
        this.kyksyaYukueFumeiUmuKbn = pKyksyaYukueFumeiUmuKbn;
    }

}

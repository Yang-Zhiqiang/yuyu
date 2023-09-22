package yuyu.common.sinkeiyaku.skcommon;

import java.io.Serializable;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 新契約 新契約共通 代理店個別情報取得Bean
 */
public class GetDairitenKobetuJyouhouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_ErrorKbn errorKbn;

    private C_YouhiKbn cifCdCheckYouhi;

    private Integer cifCdSiteiKetasuu;

    private C_YouhiblnkKbn cifCdMaezeroumeYouhi;

    public C_ErrorKbn getErrorKbn() {
        return errorKbn;
    }

    public void setErrorKbn(C_ErrorKbn pErrorKb) {
        errorKbn = pErrorKb;
    }

    public C_YouhiKbn getCifCdCheckYouhi() {
        return cifCdCheckYouhi;
    }

    public void setCifCdCheckYouhi(C_YouhiKbn pCifCdCheckYouh) {
        cifCdCheckYouhi = pCifCdCheckYouh;
    }

    public Integer getCifCdSiteiKetasuu() {
        return cifCdSiteiKetasuu;
    }

    public void setCifCdSiteiKetasuu(Integer pCifCdSiteiKetasu) {
        cifCdSiteiKetasuu = pCifCdSiteiKetasu;
    }

    public C_YouhiblnkKbn getCifCdMaezeroumeYouhi() {
        return cifCdMaezeroumeYouhi;
    }

    public void setCifCdMaezeroumeYouhi(C_YouhiblnkKbn pCifCdMaezeroumeYouhi) {
        cifCdMaezeroumeYouhi = pCifCdMaezeroumeYouhi;
    }

}

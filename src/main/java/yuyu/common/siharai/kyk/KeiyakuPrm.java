package yuyu.common.siharai.kyk;

import yuyu.def.classification.C_NayoseYouhi;

/**
 * 保険金給付金支払 契約情報取得 契約情報取得パラメータ
 */
public class KeiyakuPrm {

    private String syono = null;

    private C_NayoseYouhi nayoseYh = C_NayoseYouhi.HUYOU;

    public KeiyakuPrm() {
        super();
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public void setINayoseyh(C_NayoseYouhi pNayoseYh) {
        nayoseYh = pNayoseYh;
    }

    public String getSyono() {
        return syono;
    }

    public boolean isNayose() {
        return C_NayoseYouhi.YOU.eq(nayoseYh);
    }
}

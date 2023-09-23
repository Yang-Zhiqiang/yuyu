package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報(診断書料支払)Paramインターフェース実装クラス
 */
public class SiSeikyuusyaSindansyoParamImpl implements SiSeikyuusyaSindansyoParam {

    private C_SeikyuusyaKbn seikyuusyakbn;

    private String seikyuusyanmkj;

    private String seikyuusyanmkn;

    @Override
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    @Override
    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    @Override
    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Override
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

    @Override
    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Override
    public void setSeikyuusyanmkn(String seikyuusyanmkn) {
        this.seikyuusyanmkn = seikyuusyanmkn;
    }
}

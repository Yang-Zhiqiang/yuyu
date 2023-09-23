package yuyu.common.siharai.siview;

import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報設定(診断書料支払)UiBeanパラメータインタフェース実装クラス
 */
public class ViewSkjyouhouSindansyoUiBeanParamImpl implements ViewSkjyouhouSindansyoUiBeanParam {

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
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

}

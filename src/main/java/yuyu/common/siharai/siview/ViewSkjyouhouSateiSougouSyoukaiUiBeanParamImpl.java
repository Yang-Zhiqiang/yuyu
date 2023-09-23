package yuyu.common.siharai.siview;

import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報設定(査定総合照会)パラメータインタフェース実装クラス
 */
public class ViewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl implements ViewSkjyouhouSateiSougouSyoukaiUiBeanParam {

    private C_SeikyuusyaKbn seikyuusyakbn;

    private String seikyuusyanmkn;

    private String seikyuusyanmkj;

    @Override
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    @Override
    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    @Override
    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Override
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    @Override
    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Override
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

}

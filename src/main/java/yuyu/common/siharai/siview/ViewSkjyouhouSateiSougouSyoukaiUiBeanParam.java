package yuyu.common.siharai.siview;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報設定(査定総合照会)パラメータインタフェース
 */
public interface ViewSkjyouhouSateiSougouSyoukaiUiBeanParam extends CommonViewUiBeanParam {

    public C_SeikyuusyaKbn getSeikyuusyakbn();

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn);

    public String getSeikyuusyanmkn();

    public void setSeikyuusyanmkn(String pSeikyuusyanmkn);

    public String getSeikyuusyanmkj();

    public void setSeikyuusyanmkj(String pSeikyuusyanmkj);

}

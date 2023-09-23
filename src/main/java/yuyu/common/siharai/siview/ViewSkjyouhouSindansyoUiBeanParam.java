package yuyu.common.siharai.siview;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報設定(診断書料支払)UiBeanパラメータインタフェース
 */
public interface ViewSkjyouhouSindansyoUiBeanParam extends CommonViewUiBeanParam {

    public C_SeikyuusyaKbn getSeikyuusyakbn();

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn);

    public String getSeikyuusyanmkj();

    public void setSeikyuusyanmkj(String pSeikyuusyanmkj);

    public String getSeikyuusyanmkn();

    public void setSeikyuusyanmkn(String pSeikyuusyanmkn);

}

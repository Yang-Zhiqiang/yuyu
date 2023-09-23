package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報(診断書料支払)Paramインターフェース
 */
public interface SiSeikyuusyaSindansyoParam {

    public C_SeikyuusyaKbn getSeikyuusyakbn();

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn);

    public String getSeikyuusyanmkj();

    public void setSeikyuusyanmkj(String pSeikyuusyanmkj);

    public String getSeikyuusyanmkn();

    public void setSeikyuusyanmkn(String pSeikyuusyanmkn);

}

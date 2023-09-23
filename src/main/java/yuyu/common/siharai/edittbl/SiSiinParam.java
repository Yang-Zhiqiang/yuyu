package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SiinKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 死因情報Paramインターフェース
 */
public interface SiSiinParam {

    public C_SiinKbn getSiinkbn();

    public void setSiinkbn(C_SiinKbn pSiinkbn);
}

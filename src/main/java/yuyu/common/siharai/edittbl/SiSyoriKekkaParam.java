package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SyorikekkaKbn;


/**
 * 保険金給付金支払 保険金給付金支払共通 処理結果Paramインターフェースクラス
 */
public interface SiSyoriKekkaParam {

    C_SyorikekkaKbn getSyorikekkakbn();

    void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn);

    String getTennousakisousasyacd();

    void setTennousakisousasyacd(String pTennousakisousasyacd);

}

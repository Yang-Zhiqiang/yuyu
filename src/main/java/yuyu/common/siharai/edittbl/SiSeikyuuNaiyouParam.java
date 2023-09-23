package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求内容Paramインターフェース
 */
public interface SiSeikyuuNaiyouParam {

    public C_SUketoriHouhouKbn getSuketorihouhoukbn();

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn);

    public C_SiharaiTuukaKbn getSiharaituukakbn();

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukaKbn);

}

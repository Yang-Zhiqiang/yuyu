package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 取扱不良・不祥事件等Paramインターフェース
 */
public interface SiToriatukaifuryouParam {

    public C_NoinitUmuKbn getTratkihuryouumukbn();

    public void setTratkihuryouumukbn(C_NoinitUmuKbn pTratkihuryouumukbn);

    public C_NoinitYouhiKbn getGyousinkaisouyouhikbn();

    public void setGyousinkaisouyouhikbn(C_NoinitYouhiKbn pGyousinkaisouyouhikbn);

    public C_NoinitSyorizumiKbn getAireqdaityoukisaikbn();

    public void setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn pAireqdaityoukisaikbn);

    public String getTratkihuryoucomment();

    public void setTratkihuryoucomment(String pTratkihuryoucomment);

}

package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 名義変更査定Paramインターフェース
 */
public interface SiMeigihenkouSateiParam {

    public C_MeihenYuukouMukouKbn getMeihenyuukoumukoukbn();

    public void setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn pMeihenyuukoumukoukbn);

    public C_MeihenUktKbn getMeihenuktkbn();

    public void setMeihenuktkbn(C_MeihenUktKbn pMeihenuktkbn);

    public String getMeihenuktnm();

    public void setMeihenuktnm(String pMeihenuktnm);

}

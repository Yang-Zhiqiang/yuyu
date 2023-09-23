package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_NoinitUmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 別口チェック項目（死亡）Paramインターフェース
 */
public interface SiBetukutiSateiSbParam {

    public C_NoinitUmuKbn getBetusibouumukbn();

    public void setBetusibouumukbn(C_NoinitUmuKbn pBetusibouumukbn);

    public String getBetusiboucomment();

    public void setBetusiboucomment(String pBetusiboucomment);

    public C_NoinitUmuKbn getBetusoukiumukbn();

    public void setBetusoukiumukbn(C_NoinitUmuKbn pBetusoukiumukbn);

    public String getBetusoukicomment();

    public void setBetusoukicomment(String pBetusoukicomment);

}

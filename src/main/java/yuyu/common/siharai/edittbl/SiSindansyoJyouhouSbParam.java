package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 診断書情報（死亡）Paramインターフェース
 */
public interface SiSindansyoJyouhouSbParam {

    public C_GeninKbn getGeninkbn();

    public void setGeninkbn(C_GeninKbn pGeninkbn);

    public BizDate getSibouymd();

    public void setSibouymd(BizDate pSibouymd);

    public C_SibouBasyoKbn getSiboubasyokbn();

    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn);

    public String getSiboubasyo();

    public void setSiboubasyo(String pSiboubasyo);

}

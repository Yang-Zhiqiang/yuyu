package yuyu.common.siharai.edittbl;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報Paramインターフェース
 */
public interface SiSeikyuusyaParam {

    public C_SeikyuusyaKbn getSeikyuusyakbn();

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn);

    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn();

    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn);

    public BizDate getSeikyuusyaseiymd();

    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd);

    public C_Seibetu getSeikyuusyasei();

    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei);

    public String getSeikyuusyanmkn();

    public void setSeikyuusyanmkn(String pSeikyuusyanmkn);

    public String getSeikyuusyanmkj();

    public void setSeikyuusyanmkj(String pSeikyuusyanmkj);
}

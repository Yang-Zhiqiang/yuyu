package yuyu.common.siharai.siview;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払査定設定(支払履歴照会)パラメータインタフェース
 */
public interface ViewSiharaiSateiShrRirekiUiBeanParam extends CommonViewUiBeanParam {

    public C_SyorikekkaKbn getSyorikekkakbn();

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn);

    public C_HushrGeninKbn getHushrgeninkbn();

    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn);

    public C_YouhiblnkKbn getSessyouyhkbn();

    public void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn);

    public String getSessyousisyacd();

    public void setSessyousisyacd(String pSessyousisyacd);

    public String getSisyanm();

    public void setSisyanm(String pSisyanm);

    public C_SinsaGendoKknKbn getSinsagendokknkbn();

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn);

    public Integer getRikoukityuutuudannissuu();

    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu);

    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn();

    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn);

    public BizDate getKaiketuymd();

    public void setKaiketuymd(BizDate pKaiketuymd);

    public C_BlnktkumuKbn getSaigaimousideumukbn();

    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn);

}

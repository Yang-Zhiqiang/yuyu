package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払査定Paramインターフェース
 */
public interface SiSiharaiSateiParam {

    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn();

    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn);

    public C_SinsaGendoKknKbn getSinsagendokknkbn();

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn);

    public Integer getRikoukityuutuudannissuu();

    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu);

    public C_BlnktkumuKbn getSaigaimousideumukbn();

    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn);

}

package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSiharaiSateiParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払査定Paramインターフェース実装クラス（テスト用）
 */
public class SiSiharaiSateiParamImplTest implements SiSiharaiSateiParam ,EditSkTblParam {

    private C_SindansyoRyouShrYouhiKbn sindansyoryoushryouhikbn;

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    private Integer rikoukityuutuudannissuu;

    @Override
    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn() {
        return sindansyoryoushryouhikbn;
    }

    @Override
    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {
        sindansyoryoushryouhikbn = pSindansyoryoushryouhikbn;
    }

    @Override
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    @Override
    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        sinsagendokknkbn = pSinsagendokknkbn;
    }

    @Override
    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    @Override
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    @Override
    public C_BlnktkumuKbn getSaigaimousideumukbn() {
        return null;
    }

    @Override
    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn) {

    }
}

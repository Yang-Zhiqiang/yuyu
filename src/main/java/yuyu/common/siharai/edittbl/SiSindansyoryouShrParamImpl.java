package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 診断書料支払Paramインターフェース実装クラス
 */
public class SiSindansyoryouShrParamImpl implements SiSindansyoryouShrParam {

    private Integer sindansyomaisuu;

    private C_SindansyoRyouShrYouhiKbn sindansyoryoushryouhikbn;

    @Override
    public Integer getSindansyomaisuu() {
        return sindansyomaisuu;
    }

    @Override
    public void setSindansyomaisuu(Integer pSindansyomaisuu) {
        sindansyomaisuu = pSindansyomaisuu;
    }

    @Override
    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn() {
        return sindansyoryoushryouhikbn;
    }

    @Override
    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {
        sindansyoryoushryouhikbn = pSindansyoryoushryouhikbn;
    }
}

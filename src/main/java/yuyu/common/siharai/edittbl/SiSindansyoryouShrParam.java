package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 診断書料支払Paramインターフェース
 */
public interface SiSindansyoryouShrParam {

    public Integer getSindansyomaisuu();

    public void setSindansyomaisuu(Integer pSindansyomaisuu);

    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn();

    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn);

}

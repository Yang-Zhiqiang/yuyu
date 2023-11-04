package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSindansyoryouShrParam;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;


/**
 * 保険金給付金支払 保険金給付金支払共通 診断書料支払Paramインターフェース実装クラス（テスト用）
 */
public class SiSindansyoryouShrParamImplTest implements SiSindansyoryouShrParam, EditSkTblParam {

    private Integer sindansyomaisuu;

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
        return null;
    }

    @Override
    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {

    }
}

package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSiinParam;
import yuyu.def.classification.C_SiinKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 死因情報Paramインターフェース実装クラス（テスト用）
 */
public class SiSiinParamImplTest implements SiSiinParam ,EditSkTblParam {

    private C_SiinKbn siinkbn;

    @Override
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    @Override
    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }
}

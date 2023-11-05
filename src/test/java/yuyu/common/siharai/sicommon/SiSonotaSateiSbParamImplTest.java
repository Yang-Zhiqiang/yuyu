package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSonotaSateiSbParam;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 その他チェック項目（死亡）Paramインターフェース実装クラス（テスト用）
 */
public class SiSonotaSateiSbParamImplTest implements SiSonotaSateiSbParam ,EditSkTblParam {

    private C_NoinitUmuKbn bengosikenkaiumukbn;

    private C_NoinitUmuKbn kujyouumukbn;

    private C_NoinitUmuKbn jimumissumukbn;

    private C_NoinitYouhiKbn kyhgksitukaisouyouhikbn;

    @Override
    public C_NoinitUmuKbn getBengosikenkaiumukbn() {
        return bengosikenkaiumukbn;
    }

    @Override
    public void setBengosikenkaiumukbn(C_NoinitUmuKbn pBengosikenkaiumukbn) {
        bengosikenkaiumukbn = pBengosikenkaiumukbn;
    }

    @Override
    public C_NoinitUmuKbn getKujyouumukbn() {
        return kujyouumukbn;
    }

    @Override
    public void setKujyouumukbn(C_NoinitUmuKbn pKujyouumukbn) {
        kujyouumukbn = pKujyouumukbn;
    }

    @Override
    public C_NoinitUmuKbn getJimumissumukbn() {
        return jimumissumukbn;
    }

    @Override
    public void setJimumissumukbn(C_NoinitUmuKbn pJimumissumukbn) {
        jimumissumukbn = pJimumissumukbn;
    }

    @Override
    public C_NoinitYouhiKbn getKyhgksitukaisouyouhikbn() {
        return kyhgksitukaisouyouhikbn;
    }

    @Override
    public void setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn pKyhgksitukaisouyouhikbn) {
        kyhgksitukaisouyouhikbn = pKyhgksitukaisouyouhikbn;
    }

    public boolean isAllBlnk() {

        if (C_NoinitUmuKbn.BLNK.eq(bengosikenkaiumukbn) &&
            C_NoinitUmuKbn.BLNK.eq(kujyouumukbn) &&
            C_NoinitUmuKbn.BLNK.eq(jimumissumukbn) &&
            C_NoinitYouhiKbn.BLNK.eq(kyhgksitukaisouyouhikbn)) {
            return true;
        }
        return false;
    }

}

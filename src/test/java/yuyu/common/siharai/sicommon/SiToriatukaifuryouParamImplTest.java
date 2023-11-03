package yuyu.common.siharai.sicommon;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiToriatukaifuryouParam;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 取扱不良・不祥事件等Paramインターフェース実装クラス（テスト用）
 */
public class SiToriatukaifuryouParamImplTest implements SiToriatukaifuryouParam ,EditSkTblParam {

    private C_NoinitUmuKbn tratkihuryouumukbn;

    private C_NoinitYouhiKbn gyousinkaisouyouhikbn;

    private C_NoinitSyorizumiKbn aireqdaityoukisaikbn;

    private String tratkihuryoucomment;

    @Override
    public C_NoinitUmuKbn getTratkihuryouumukbn() {
        return tratkihuryouumukbn;
    }

    @Override
    public void setTratkihuryouumukbn(C_NoinitUmuKbn pTratkihuryouumukbn) {
        tratkihuryouumukbn = pTratkihuryouumukbn;
    }

    @Override
    public C_NoinitYouhiKbn getGyousinkaisouyouhikbn() {
        return gyousinkaisouyouhikbn;
    }

    @Override
    public void setGyousinkaisouyouhikbn(C_NoinitYouhiKbn pGyousinkaisouyouhikbn) {
        gyousinkaisouyouhikbn = pGyousinkaisouyouhikbn;
    }

    @Override
    public C_NoinitSyorizumiKbn getAireqdaityoukisaikbn() {
        return aireqdaityoukisaikbn;
    }

    @Override
    public void setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn pAireqdaityoukisaikbn) {
        aireqdaityoukisaikbn = pAireqdaityoukisaikbn;
    }

    @Override
    public String getTratkihuryoucomment() {
        return tratkihuryoucomment;
    }

    @Override
    public void setTratkihuryoucomment(String pTratkihuryoucomment) {
        tratkihuryoucomment = pTratkihuryoucomment;
    }

    public boolean isAllBlnk() {

        if (C_NoinitUmuKbn.BLNK.eq(tratkihuryouumukbn) &&
            C_NoinitYouhiKbn.BLNK.eq(gyousinkaisouyouhikbn) &&
            C_NoinitSyorizumiKbn.BLNK.eq(aireqdaityoukisaikbn) &&
            BizUtil.isBlank(tratkihuryoucomment)) {
            return true;
        }
        return false;
    }

}

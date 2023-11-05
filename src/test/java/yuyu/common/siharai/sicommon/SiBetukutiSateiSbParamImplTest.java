package yuyu.common.siharai.sicommon;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiBetukutiSateiSbParam;
import yuyu.def.classification.C_NoinitUmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 別口チェック項目（死亡）Paramインターフェーステスト用クラス
 */
public class SiBetukutiSateiSbParamImplTest implements SiBetukutiSateiSbParam ,EditSkTblParam {

    private C_NoinitUmuKbn betusibouumukbn;

    private String betusiboucomment;

    private C_NoinitUmuKbn betusoukiumukbn;

    private String betusoukicomment;

    @Override
    public C_NoinitUmuKbn getBetusibouumukbn() {
        return betusibouumukbn;
    }

    @Override
    public void setBetusibouumukbn(C_NoinitUmuKbn pBetusibouumukbn) {
        betusibouumukbn = pBetusibouumukbn;
    }

    @Override
    public String getBetusiboucomment() {
        return betusiboucomment;
    }

    @Override
    public void setBetusiboucomment(String pBetusiboucomment) {
        betusiboucomment = pBetusiboucomment;
    }

    @Override
    public C_NoinitUmuKbn getBetusoukiumukbn() {
        return betusoukiumukbn;
    }

    @Override
    public void setBetusoukiumukbn(C_NoinitUmuKbn pBetusoukiumukbn) {
        betusoukiumukbn = pBetusoukiumukbn;
    }

    @Override
    public String getBetusoukicomment() {
        return betusoukicomment;
    }

    @Override
    public void setBetusoukicomment(String pBetusoukicomment) {
        betusoukicomment = pBetusoukicomment;
    }

    public boolean isAllBlnk() {

        if (C_NoinitUmuKbn.BLNK.eq(betusibouumukbn) && BizUtil.isBlank(betusiboucomment) &&
            C_NoinitUmuKbn.BLNK.eq(betusoukiumukbn) && BizUtil.isBlank(betusoukicomment)) {
            return true;
        }
        return false;
    }

}

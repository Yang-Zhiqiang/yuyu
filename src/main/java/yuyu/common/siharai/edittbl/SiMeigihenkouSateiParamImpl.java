package yuyu.common.siharai.edittbl;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 名義変更査定Paramインターフェース実装クラス
 */
public class SiMeigihenkouSateiParamImpl implements SiMeigihenkouSateiParam {

    private C_MeihenYuukouMukouKbn meihenyuukoumukoukbn;

    private C_MeihenUktKbn meihenuktkbn;

    private String meihenuktnm;

    @Override
    public C_MeihenYuukouMukouKbn getMeihenyuukoumukoukbn() {
        return meihenyuukoumukoukbn;
    }

    @Override
    public void setMeihenyuukoumukoukbn(C_MeihenYuukouMukouKbn pMeihenyuukoumukoukbn) {
        meihenyuukoumukoukbn = pMeihenyuukoumukoukbn;
    }

    @Override
    public C_MeihenUktKbn getMeihenuktkbn() {
        return meihenuktkbn;
    }

    @Override
    public void setMeihenuktkbn(C_MeihenUktKbn pMeihenuktkbn) {
        meihenuktkbn = pMeihenuktkbn;
    }

    @Override
    public String getMeihenuktnm() {
        return meihenuktnm;
    }

    @Override
    public void setMeihenuktnm(String pMeihenuktnm) {
        meihenuktnm = pMeihenuktnm;
    }

    public boolean isAllBlnk() {

        if (C_MeihenYuukouMukouKbn.BLNK.eq(meihenyuukoumukoukbn) &&
                C_MeihenUktKbn.BLNK.eq(meihenuktkbn) &&
                BizUtil.isBlank(meihenuktnm)) {
            return true;
        }
        return false;
    }

}

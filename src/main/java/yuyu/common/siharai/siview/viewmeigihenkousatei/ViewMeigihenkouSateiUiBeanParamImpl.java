package yuyu.common.siharai.siview.viewmeigihenkousatei;

import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;

/**
 * 保険金給付金支払 支払画面部品 名義変更査定クラス <br />
 */
public class ViewMeigihenkouSateiUiBeanParamImpl implements ViewMeigihenkouSateiUiBeanParam{

    private C_MeihenYuukouMukouKbn meihenyuukoumukoukbn;

    private C_MeihenUktKbn meihenuktkbn;

    private String meihenuktnm;

    private boolean viewMeigihenkouSateiFlg;

    private boolean viewMeigihenkouSateiSeigyo;

    private boolean viewMeigihenkouSateiDispFlg;

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

    @Override
    public boolean isViewMeigihenkouSateiFlg() {
        return viewMeigihenkouSateiFlg;
    }

    @Override
    public boolean isViewMeigihenkouSateiSeigyo() {
        return viewMeigihenkouSateiSeigyo;
    }

    @Override
    public boolean isViewMeigihenkouSateiDispFlg() {
        return viewMeigihenkouSateiDispFlg;
    }

}

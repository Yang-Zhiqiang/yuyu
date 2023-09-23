package yuyu.common.siharai.siview.viewsknaiyou;

import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;

/**
 * 保険金給付金支払 支払画面部品 請求内容表示クラス <br />
 */
public class ViewSknaiyouUiBeanParamImpl implements ViewSknaiyouUiBeanParam{

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    private C_SiharaiTuukaKbn siharaituukakbn;

    private boolean viewSknaiyouSeigyo;

    private boolean viewSknaiyouDispFlg;

    @Override
    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    @Override
    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    @Override
    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    @Override
    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    @Override
    public boolean isViewSknaiyouSeigyo() {
        return viewSknaiyouSeigyo;
    }

    @Override
    public boolean isViewSknaiyouDispFlg() {
        return viewSknaiyouDispFlg;
    }
}

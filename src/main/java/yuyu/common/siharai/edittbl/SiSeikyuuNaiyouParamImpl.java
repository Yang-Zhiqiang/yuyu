package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求内容Paramインターフェース実装クラス
 */
public class SiSeikyuuNaiyouParamImpl implements SiSeikyuuNaiyouParam {

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    private C_SiharaiTuukaKbn siharaituukakbn;

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

}

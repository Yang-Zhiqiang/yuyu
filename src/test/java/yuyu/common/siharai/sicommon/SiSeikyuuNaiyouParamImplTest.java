package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSeikyuuNaiyouParam;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_Tkhukaumu;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求内容Paramインターフェース実装クラス（テスト用）
 */
public class SiSeikyuuNaiyouParamImplTest implements SiSeikyuuNaiyouParam, EditSkTblParam {

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    private C_Tkhukaumu yenshrtkhukaumukbn;

    @Override
    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    @Override
    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }
    //
    //    @Override
    //    public C_Tkhukaumu getYenshrtkhukaumukbn() {
    //        return yenshrtkhukaumukbn;
    //    }
    //
    //    @Override
    //    public void setYenshrtkhukaumukbn(C_Tkhukaumu pYenshrtkhukaumukbn) {
    //        yenshrtkhukaumukbn = pYenshrtkhukaumukbn;
    //    }

    @Override
    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return null;
    }

    @Override
    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukaKbn) {

    }

}

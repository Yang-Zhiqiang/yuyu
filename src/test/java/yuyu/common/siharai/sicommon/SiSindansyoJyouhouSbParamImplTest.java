package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSindansyoJyouhouSbParam;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 診断書情報（死亡）Paramインターフェース実装クラス（テスト用）
 */
public class SiSindansyoJyouhouSbParamImplTest implements SiSindansyoJyouhouSbParam ,EditSkTblParam {

    private C_GeninKbn geninkbn;

    private BizDate sibouymd;

    private C_SibouBasyoKbn siboubasyokbn;

    private String siboubasyo;

    @Override
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    @Override
    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    @Override
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Override
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    @Override
    public C_SibouBasyoKbn getSiboubasyokbn() {
        return siboubasyokbn;
    }

    @Override
    public void setSiboubasyokbn(C_SibouBasyoKbn pSiboubasyokbn) {
        siboubasyokbn = pSiboubasyokbn;
    }

    @Override
    public String getSiboubasyo() {
        return siboubasyo;
    }

    @Override
    public void setSiboubasyo(String pSiboubasyo) {
        siboubasyo = pSiboubasyo;
    }
}

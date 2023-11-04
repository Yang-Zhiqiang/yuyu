package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiSeikyuusyaSindansyoParam;
import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 請求者情報(診断書料支払)Paramインターフェース実装クラス（テスト用）
 */
public class SiSeikyuusyaSindansyoParamImplTest implements SiSeikyuusyaSindansyoParam, EditSkTblParam {

    private C_SeikyuusyaKbn seikyuusyakbn;

    private String seikyuusyanmkj;

    @Override
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    @Override
    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    @Override
    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Override
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

    @Override
    public String getSeikyuusyanmkn() {
        return null;
    }

    @Override
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {

    }

}

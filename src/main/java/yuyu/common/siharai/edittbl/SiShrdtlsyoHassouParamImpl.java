package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細書作成区分Paramインターフェース実装クラス
 */
public class SiShrdtlsyoHassouParamImpl implements SiShrdtlsyoHassouParam {

    private C_KanryotuutioutKbn shrdtlsyooutkbn;

    private C_HassouKbn hassoukbn;

    @Override
    public C_KanryotuutioutKbn getShrdtlsyooutkbn() {
        return shrdtlsyooutkbn;
    }

    @Override
    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn) {
        shrdtlsyooutkbn = pShrdtlsyooutkbn;
    }

    @Override
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    @Override
    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }
}

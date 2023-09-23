package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細書作成区分Paramインターフェース
 */
public interface SiShrdtlsyoHassouParam {

    public C_KanryotuutioutKbn getShrdtlsyooutkbn();

    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn);

    public C_HassouKbn getHassoukbn();

    public void setHassoukbn(C_HassouKbn pHassoukbn);
}

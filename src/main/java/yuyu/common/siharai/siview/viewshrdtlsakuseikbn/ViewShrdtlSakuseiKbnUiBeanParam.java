package yuyu.common.siharai.siview.viewshrdtlsakuseikbn;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;

/**
 * 保険金給付金支払 支払画面部品 支払明細書作成区分 <br />
 */
public interface ViewShrdtlSakuseiKbnUiBeanParam extends CommonViewUiBeanParam {

    public C_KanryotuutioutKbn getShrdtlsyooutkbn();

    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn);

    public C_HassouKbn getHassoukbn();

    public void setHassoukbn(C_HassouKbn pHassoukbn);

    public boolean isViewShrdtlSakuseiKbnInputDispFlg();

    public boolean isViewShrdtlSakuseiKbnSeigyo();

    public boolean isViewShrdtlSakuseiKbnDispFlg();

    public boolean isViewShrdtlSakuseiKbnFlg();
}

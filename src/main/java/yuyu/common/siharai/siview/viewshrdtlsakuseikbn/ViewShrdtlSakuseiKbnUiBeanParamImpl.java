package yuyu.common.siharai.siview.viewshrdtlsakuseikbn;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;

/**
 * 保険金給付金支払 支払画面部品 支払明細書作成区分クラス <br />
 */
public class ViewShrdtlSakuseiKbnUiBeanParamImpl implements ViewShrdtlSakuseiKbnUiBeanParam{

    private C_KanryotuutioutKbn shrdtlsyooutkbn;

    private C_HassouKbn hassoukbn;

    private boolean viewShrdtlSakuseiKbnInputDispFlg;

    private boolean viewShrdtlSakuseiKbnSeigyo;

    private boolean viewShrdtlSakuseiKbnDispFlg;

    private boolean viewShrdtlSakuseiKbnFlg;

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

    @Override
    public boolean isViewShrdtlSakuseiKbnInputDispFlg() {
        return viewShrdtlSakuseiKbnInputDispFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnSeigyo() {
        return viewShrdtlSakuseiKbnSeigyo;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnDispFlg() {
        return viewShrdtlSakuseiKbnDispFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnFlg() {
        return viewShrdtlSakuseiKbnFlg;
    }

}

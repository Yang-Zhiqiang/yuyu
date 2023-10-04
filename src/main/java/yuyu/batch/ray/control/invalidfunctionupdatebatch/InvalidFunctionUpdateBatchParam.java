package yuyu.batch.ray.control.invalidfunctionupdatebatch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.def.classification.C_KinouIdKinouModeIdKbn;
import yuyu.def.classification.C_YuukouKbn;
import yuyu.infr.batch.BatchParam;

/**
 * 有効区分更新バッチのバッチパラメータクラスです。
 */
@BatchScoped
public class InvalidFunctionUpdateBatchParam extends BatchParam {

    private static final long serialVersionUID = -1L;

    private C_YuukouKbn yuukouKbn = null;

    private C_KinouIdKinouModeIdKbn kinouIdKinouModeIdKbn = null;

    private String kousinData = null;

    public C_YuukouKbn getYuukouKbn() {
        return yuukouKbn;
    }

    public C_KinouIdKinouModeIdKbn getKinouIdKinouModeIdKbn() {
        return kinouIdKinouModeIdKbn;
    }

    public String getKousinData() {
        return kousinData;
    }

    public void setYuukouKbn(C_YuukouKbn yuukouKbn) {
        this.yuukouKbn = yuukouKbn;
    }

    public void setKinouIdKinouModeIdKbn(C_KinouIdKinouModeIdKbn kinouIdKinouModeIdKbn) {
        this.kinouIdKinouModeIdKbn = kinouIdKinouModeIdKbn;
    }

    public void setKousinData(String kousinData) {
        this.kousinData = kousinData;
    }

}

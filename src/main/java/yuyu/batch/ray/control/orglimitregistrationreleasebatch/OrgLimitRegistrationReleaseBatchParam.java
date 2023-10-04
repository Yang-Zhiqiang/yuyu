package yuyu.batch.ray.control.orglimitregistrationreleasebatch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.def.classification.C_SosikiCdTourokuKaijoKbn;
import yuyu.infr.batch.BatchParam;

/**
 * 組織限定登録解除バッチのバッチパラメータクラスです。
 */
@BatchScoped
public class OrgLimitRegistrationReleaseBatchParam extends BatchParam {

    private static final long serialVersionUID = -1L;

    private C_SosikiCdTourokuKaijoKbn tourokuKaijoKbn = null;

    private String sosikiCd = null;

    public C_SosikiCdTourokuKaijoKbn getTourokuKaijoKbn() {
        return tourokuKaijoKbn;
    }

    public String getSosikiCd() {
        return sosikiCd;
    }

    public void setTourokuKaijoKbn(C_SosikiCdTourokuKaijoKbn tourokuKaijoKbn) {
        this.tourokuKaijoKbn = tourokuKaijoKbn;
    }

    public void setSosikiCd(String sosikiCd) {
        this.sosikiCd = sosikiCd;
    }

}

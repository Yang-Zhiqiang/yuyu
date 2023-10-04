package yuyu.batch.sinkeiyaku.sksonota.skyuukoukikankeikahantei;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_KeikaKbn;

/**
 * 新契約 有効期間経過契約判定処理 有効期間経過契約判定バッチパラメータ
 */
@BatchScoped
public class SkYuukoukikanKeikaHanteiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private C_KeikaKbn keikakbn;

    public C_KeikaKbn getKeikakbn() {
        return keikakbn;
    }

    public void setKeikakbn(C_KeikaKbn keikakbn) {
        this.keikakbn = keikakbn;
    }
}

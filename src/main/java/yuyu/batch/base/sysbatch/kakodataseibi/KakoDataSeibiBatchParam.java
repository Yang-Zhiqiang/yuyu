package yuyu.batch.base.sysbatch.kakodataseibi;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.batch.BatchParam;

/**
 * {@link KakoDataSeibiBatch 過去データ整備バッチ処理} のパラメータBeanクラスです。
 */
@BatchScoped
public class KakoDataSeibiBatchParam extends BatchParam {

    private static final long serialVersionUID = 1L;

    private C_UmuKbn tyouhyouDataTaihiKbn = C_UmuKbn.NONE;

    public C_UmuKbn getTyouhyouDataTaihiKbn() {
        return tyouhyouDataTaihiKbn;
    }

    public void setTyouhyouDataTaihiKbn(C_UmuKbn pTyouhyouDataTaihiKbn) {
        this.tyouhyouDataTaihiKbn = pTyouhyouDataTaihiKbn;
    }

}

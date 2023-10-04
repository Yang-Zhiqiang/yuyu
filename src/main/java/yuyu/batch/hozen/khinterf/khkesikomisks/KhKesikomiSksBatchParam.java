package yuyu.batch.hozen.khinterf.khkesikomisks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_Nykkeiro;

/**
 * 契約保全 インターフェイス 消込送信Ｆ作成バッチパラメータ
 */
@BatchScoped
public class KhKesikomiSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private C_Nykkeiro nykkeiro;

    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }
}

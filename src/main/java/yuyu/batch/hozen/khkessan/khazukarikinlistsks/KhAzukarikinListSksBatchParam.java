package yuyu.batch.hozen.khkessan.khazukarikinlistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 決算 預り金リスト作成バッチパラメータクラス
 */
@BatchScoped
public class KhAzukarikinListSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private BizDate kessanYmd;

    public BizDate getKessanYmd() {
        return kessanYmd;
    }

    public void setKessanYmd(BizDate pKessanYmd) {
        this.kessanYmd = pKessanYmd;
    }


}
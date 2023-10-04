package yuyu.batch.hozen.khkessan.khbikinjikoulistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 契約保全 決算 契約保全備金時効リスト作成（解約）パラメータ
 */
@BatchScoped
public class KhBikinJikouListSksBatchParam extends BzBatchParam {


    private static final long serialVersionUID = 1L;

    private BizDate kessanYmd;

    public BizDate getKessanYmd() {
        return kessanYmd;
    }

    public void setKessanYmd(BizDate pKessanYmd) {
        kessanYmd = pKessanYmd;
    }

}
package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisailistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 仮割当配当金明細リスト作成パラメータクラス
 */
@BatchScoped
public class SrKariwariateDMeisaiListSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKPM002 = "RGKPM002";

    public static final String RGKPM004 = "RGKPM004";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

}

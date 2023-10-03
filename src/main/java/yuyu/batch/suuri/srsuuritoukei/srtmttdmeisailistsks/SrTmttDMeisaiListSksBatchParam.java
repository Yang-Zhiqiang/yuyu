package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisailistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理統計 数理統計 積立配当金明細リスト作成パラメータクラス
 */
@BatchScoped
public class SrTmttDMeisaiListSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKMM002 = "RGKMM002";

    public static final String RGKMM004 = "RGKMM004";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }
}

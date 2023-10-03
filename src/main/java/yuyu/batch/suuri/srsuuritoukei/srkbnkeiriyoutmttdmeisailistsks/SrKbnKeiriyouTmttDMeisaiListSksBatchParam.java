package yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoutmttdmeisailistsks;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;

/**
 * 数理 数理統計 区分経理用積立配当金明細リスト作成パラメータクラス
 */
@BatchScoped
public class SrKbnKeiriyouTmttDMeisaiListSksBatchParam extends BzBatchParam{

    private static final long serialVersionUID = 1L;

    public static final String RGKNM002 = "RGKNM002";

    public static final String RGKNM004 = "RGKNM004";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }
}

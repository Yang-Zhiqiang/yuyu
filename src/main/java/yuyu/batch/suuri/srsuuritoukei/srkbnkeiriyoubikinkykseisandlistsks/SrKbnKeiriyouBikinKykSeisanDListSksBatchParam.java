package yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoubikinkykseisandlistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;
/**
 * 数理 数理統計 区分経理用備金契約精算Ｄ集計リスト作成バッチパラメータクラス
 */
@BatchScoped
public class SrKbnKeiriyouBikinKykSeisanDListSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKTM002 = "RGKTM002";

    public static final String RGKTM004 = "RGKTM004";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }
}

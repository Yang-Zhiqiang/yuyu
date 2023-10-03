package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisandlistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;
/**
 * 数理 数理統計 備金契約精算Ｄ集計リスト作成バッチパラメータクラス
 */
@BatchScoped
public class SrBikinKykSeisanDListSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKSM002 = "RGKSM002";

    public static final String RGKSM004 = "RGKSM004";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }
}

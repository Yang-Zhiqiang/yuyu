package yuyu.batch.suuri.srsuuritoukei.srbikinkykkariwariatedlistsks;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;
/**
 * 数理 数理統計 備金契約仮割当Ｄ集計リスト作成バッチパラメータクラス
 */
@BatchScoped
public class SrBikinKykKariwariateDListSksBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKUM002 = "RGKUM002";

    public static final String RGKUM004 = "RGKUM004";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }
}

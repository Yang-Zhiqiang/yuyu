package yuyu.batch.suuri.srsuuritoukei.srdshrtoukeiloading;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * Ｄ支払統計ローディング情報作成パラメータクラス
 */
@BatchScoped
public class SrDshrToukeiLoadingBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGLCM000 = "RGLCM000";

    public static final String RGLCM004 = "RGLCM004";

    private BizDate kijyunymd;

    private int syoriKensuu;

    public SrDshrToukeiLoadingBatchParam() {

        setSyoriKensuu(0);
    }

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public int getSyoriKensuu() {
        return syoriKensuu;
    }

    public void setSyoriKensuu(int pSyoriKensuu) {
        this.syoriKensuu = pSyoriKensuu;
    }
}

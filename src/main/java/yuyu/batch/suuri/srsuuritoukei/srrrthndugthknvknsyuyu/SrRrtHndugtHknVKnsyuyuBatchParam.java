package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknvknsyuyu;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;

/**
 * 利率変動型保険Ｖ検証用情報作成パラメータクラス
 */
@BatchScoped
public class SrRrtHndugtHknVKnsyuyuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public SrRrtHndugtHknVKnsyuyuBatchParam() {

    }

    public static final String RGKBM001 = "RGKBM001";

    public static final String RGKBM002 = "RGKBM002";

    public static final String RGKBM003 = "RGKBM003";

    public static final String RGKBM004 = "RGKBM004";

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    private int syoriKns;

    public int getSyoriKns() {
        return syoriKns;
    }

    public void setSyoriKns(int pSyoriKns) {
        this.syoriKns = pSyoriKns;
    }

    private int zokkouErrorSyoriKns;

    public int getZokkouErrorSyoriKns() {
        return zokkouErrorSyoriKns;
    }

    public void setZokkouErrorSyoriKns(int pZokkouErrorSyoriKns) {
        zokkouErrorSyoriKns = pZokkouErrorSyoriKns;
    }
}

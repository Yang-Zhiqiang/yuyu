package yuyu.batch.suuri.srsuuritoukei.srrayjigyohi;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理 数理統計 ＲＡＹ事業費情報作成バッチパラメータクラス
 */
@BatchScoped
public class SrRayJigyohiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGJQM000 = "RGJQM000";

    public static final String RGJQM001 = "RGJQM001";

    public static final String RGJQM002 = "RGJQM002";

    public static final String RGJQM003 = "RGJQM003";

    public static final String RGJQM004 = "RGJQM004";

    private BizDate kijyunymd;

    private int reigetuSyoriCount;

    private int kessanSyoriCount;

    private int zokkouErrorSyoriCount;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public int getReigetuSyoriCount() {
        return reigetuSyoriCount;
    }

    public void setReigetuSyoriCount(int pReigetuSyoriCount) {
        this.reigetuSyoriCount = pReigetuSyoriCount;
    }

    public int getKessanSyoriCount() {
        return kessanSyoriCount;
    }

    public void setKessanSyoriCount(int pKessanSyoriCount) {
        this.kessanSyoriCount = pKessanSyoriCount;
    }

    public int getZokkouErrorSyoriCount() {
        return zokkouErrorSyoriCount;
    }

    public void setZokkouErrorSyoriCount(int pZokkouErrorSyoriCount) {
        zokkouErrorSyoriCount = pZokkouErrorSyoriCount;
    }
}

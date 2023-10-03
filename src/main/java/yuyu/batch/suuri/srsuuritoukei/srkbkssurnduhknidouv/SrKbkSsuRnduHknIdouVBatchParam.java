package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknidouv;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理 数理統計 株価指数連動保険異動Ｖ情報作成バッチパラメータクラス
 */
@BatchScoped
public class SrKbkSsuRnduHknIdouVBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGJNM000 = "RGJNM000";

    public static final String RGJNM001 = "RGJNM001";

    public static final String RGJNM002 = "RGJNM002";

    public static final String RGJNM003 = "RGJNM003";

    public static final String RGJNM004 = "RGJNM004";

    private BizDate kijyunymd;

    private int syoriCount;

    private int zokkouErrorSyoriCount;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public int getSyoriCount() {
        return syoriCount;
    }

    public void setSyoriCount(int pSyoriCount) {
        this.syoriCount = pSyoriCount;
    }

    public int getZokkouErrorSyoriCount() {
        return zokkouErrorSyoriCount;
    }

    public void setZokkouErrorSyoriCount(int pZokkouErrorSyoriCount) {
        zokkouErrorSyoriCount = pZokkouErrorSyoriCount;
    }
}

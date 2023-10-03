package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisai;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;

/**
 * 数理統計 数理統計 積立配当金明細情報作成パラメータクラス
 */
@BatchScoped
public class SrTmttDMeisaiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKLM002 = "RGKLM002";

    public static final String RGKLM004 = "RGKLM004";

    private BizDate kijyunymd;

    private int syorikensuu;

    public SrTmttDMeisaiBatchParam() {

        setSyorikensuu(0);
    }

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public int getSyorikensuu() {
        return syorikensuu;
    }

    public void setSyorikensuu(int pSyorikensuu) {
        this.syorikensuu = pSyorikensuu;
    }
}

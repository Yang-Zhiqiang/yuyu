package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisai;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理統計 数理統計 仮割当配当金明細情報作成バッチパラメータクラス
 */
@BatchScoped
public class SrKariwariateDMeisaiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKOM002 = "RGKOM002";

    public static final String RGKOM004 = "RGKOM004";

    private BizDate kijyunymd;

    private int syorikensuu;

    public SrKariwariateDMeisaiBatchParam() {

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

package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisand;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;

/**
 * 備金契約精算Ｄ情報作成パラメータクラス
 */
@BatchScoped
public class SrBikinKykSeisanDBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKRM002 = "RGKRM002";

    public static final String RGKRM004 = "RGKRM004";

    private BizDate kijyunymd;

    private int syorikensuu;

    public SrBikinKykSeisanDBatchParam() {

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

package yuyu.batch.suuri.srsuuritoukei.srbikinkykhaitoujynbknsel;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理 数理統計 備金契約配当準備金データ抽出バッチパラメータクラス
 */
@BatchScoped
public class SrBikinKykHaitoujynbknSelBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKQM002 = "RGKQM002";

    public static final String RGKQM004 = "RGKQM004";

    private BizDate kijyunymd;

    private int errorSyoriKensuu;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public int getErrorSyoriKensuu() {
        return errorSyoriKensuu;
    }

    public void setErrorSyoriKensuu(int pErrorSyoriKensuu) {
        errorSyoriKensuu = pErrorSyoriKensuu;
    }

}

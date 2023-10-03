package yuyu.batch.suuri.srsuuritoukei.sryuukoukykhaitoujynbknsel;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;


/**
 * 数理 数理統計 有効契約配当準備金データ抽出バッチパラメータクラス
 */
@BatchScoped
public class SrYuukouKykHaitoujynbknSelBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGKKM002 = "RGKKM002";

    public static final String RGKKM004 = "RGKKM004";

    private BizDate kijyunymd;

    private int errorSyoriKensuu;

    private String heisoukbn;

    public SrYuukouKykHaitoujynbknSelBatchParam() {

        setErrorSyoriKensuu(0);
    }

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

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }
}

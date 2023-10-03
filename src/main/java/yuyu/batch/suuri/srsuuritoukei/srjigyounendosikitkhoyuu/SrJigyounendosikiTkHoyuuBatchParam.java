package yuyu.batch.suuri.srsuuritoukei.srjigyounendosikitkhoyuu;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理 数理統計 事業年度式特約保有情報作成バッチパラメータ<br />
 */
@BatchScoped
public class SrJigyounendosikiTkHoyuuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String KAKUTYOUJOBCD = "RGIVM000";

    public SrJigyounendosikiTkHoyuuBatchParam() {
    }

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    private int syoriKensuu;

    public int getSyoriKensuu() {
        return syoriKensuu;
    }

    public void setSyoriKensuu(int pSyoriKensuu) {
        syoriKensuu = pSyoriKensuu;
    }

    private int errorSyoriKensuu;

    public int getErrorSyoriKensuu() {
        return errorSyoriKensuu;
    }

    public void setErrorSyoriKensuu(int pErrorSyoriKensuu) {
        errorSyoriKensuu = pErrorSyoriKensuu;
    }

    private BizDate hoyuuHanteiymd;

    public BizDate getHoyuuHanteiymd() {
        return hoyuuHanteiymd;
    }

    public void setHoyuuHanteiymd(BizDate pHoyuuHanteiymd) {
        hoyuuHanteiymd = pHoyuuHanteiymd;
    }

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }

}

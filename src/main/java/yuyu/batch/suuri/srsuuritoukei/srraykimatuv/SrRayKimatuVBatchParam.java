package yuyu.batch.suuri.srsuuritoukei.srraykimatuv;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理統計 数理統計 ＲＡＹ期末Ｖ情報作成バッチパラメータクラス
 */
@BatchScoped
public class SrRayKimatuVBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGJMM000 = "RGJMM000";

    public static final String RGJMM001 = "RGJMM001";

    public static final String RGJMM002 = "RGJMM002";

    public static final String RGJMM003 = "RGJMM003";

    public static final String RGJMM004 = "RGJMM004";

    private BizDate kijyunymd;

    private int syoriKensuu;

    private int errorSyoriKensuu;

    public SrRayKimatuVBatchParam() {
    }

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKijyunymd(BizDate pKijyunymd) {
        kijyunymd = pKijyunymd;
    }

    public int getSyoriKensuu() {
        return syoriKensuu;
    }

    public void setSyoriKensuu(int pSyoriKensuu) {
        syoriKensuu = pSyoriKensuu;
    }

    public int getErrorSyoriKensuu() {
        return errorSyoriKensuu;
    }

    public void setErrorSyoriKensuu(int pErrorSyoriKensuu) {
        errorSyoriKensuu = pErrorSyoriKensuu;
    }
}

package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknvknsyuyu;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理 数理統計 株価指数連動保険Ｖ検証用情報作成パラメータクラス
 */
@BatchScoped
public class SrKbkSsuRnduHknVKnsyuyuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGJPM001 = "RGJPM001";

    public static final String RGJPM002 = "RGJPM002";

    public static final String RGJPM003 = "RGJPM003";

    public static final String RGJPM004 = "RGJPM004";

    public SrKbkSsuRnduHknVKnsyuyuBatchParam() {
    }

    private BizDate kijyunymd;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
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

}

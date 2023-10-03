package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 数理統計 数理統計 保有明細情報作成
 */
@BatchScoped
public class SrHoyuuMeisaiBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGHAM000 = "RGHAM000";

    public static final String RGHAM001 = "RGHAM001";

    public static final String RGHAM002 = "RGHAM002";

    public static final String RGHAM003 = "RGHAM003";

    public static final String RGHAM004 = "RGHAM004";

    public SrHoyuuMeisaiBatchParam() {

        setErrorsyorikensuu(0);
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

    private Integer errorsyorikensuu;

    public Integer getErrorsyorikensuu() {
        return errorsyorikensuu;
    }

    public void setErrorsyorikensuu(Integer pErrorsyorikensuu) {
        errorsyorikensuu = pErrorsyorikensuu;
    }

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        heisoukbn = pHeisoukbn;
    }

}

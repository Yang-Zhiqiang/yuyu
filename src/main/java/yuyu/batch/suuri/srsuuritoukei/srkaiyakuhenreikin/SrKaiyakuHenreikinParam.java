package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

import yuyu.common.biz.bzcommon.BzBatchParam;
import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;

/**
 * 解約返戻金相当額情報作成パラメータクラス
 */
@BatchScoped
public class SrKaiyakuHenreikinParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public static final String RGHDM000 = "RGHDM000";

    public static final String RGHDM001 = "RGHDM001";

    public SrKaiyakuHenreikinParam() {

        setSyorikensuu(0);

        setErrorSyoriKensuu(0);
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

    private Integer syorikensuu;

    public Integer getSyorikensuu() {
        return syorikensuu;
    }

    public void setSyorikensuu(Integer pSyorikensuu) {
        syorikensuu = pSyorikensuu;
    }

    private Integer errorsyorikensuu;

    public Integer getErrorSyoriKensuu() {
        return errorsyorikensuu;
    }

    public void setErrorSyoriKensuu(Integer pErrorSyoriKensuu) {
        errorsyorikensuu = pErrorSyoriKensuu;
    }

    private String heisoukbn;

    public String getHeisoukbn() {
        return heisoukbn;
    }

    public void setHeisoukbn(String pHeisoukbn) {
        this.heisoukbn = pHeisoukbn;
    }
}

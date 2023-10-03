package yuyu.batch.suuri.srkessan.srskoikmtyouseidenpyotyusyutu;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.SetDenSimebi;
/**
 * 新契約追込調整伝票データバッチパラメータクラス
 */
@BatchScoped
public class SrSkOikmTyouseiDenpyoTyusyutuBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    private BizDate ksnbiymd;

    public BizDate getKsnbiymd() {
        return ksnbiymd;
    }

    public void setKsnbiymd(BizDate pKsnbiymd) {
        ksnbiymd = pKsnbiymd;
    }

    private BizDate ksnyokugetufirstdayymd;

    public BizDate getKsnyokugetufirstdayymd() {
        return ksnyokugetufirstdayymd;
    }

    public void setKsnyokugetufirstdayymd(BizDate pKsnyokugetufirstdayymd) {
        ksnyokugetufirstdayymd = pKsnyokugetufirstdayymd;
    }

    private BizDate ksndensimeymd;

    public BizDate getKsndensimeymd() {
        return ksndensimeymd;
    }

    public void setksndensimeymd(BizDate pKsndensimeymd) {
        ksndensimeymd = pKsndensimeymd;
    }

    private Integer syorikensuu;

    public Integer getSyorikensuu() {
        return syorikensuu;
    }

    public void setSyorikensuu(Integer pSyorikensuu) {
        syorikensuu = pSyorikensuu;
    }

    public void setParam() {

        ksnyokugetufirstdayymd = ksnbiymd.getBizDateYM().addMonths(1).
            getFirstDay().getBusinessDay(CHolidayAdjustingMode.NEXT);

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        ksndensimeymd = setDenSimebi.exec(ksnyokugetufirstdayymd);

        syorikensuu = 0;
    }
}

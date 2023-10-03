package yuyu.batch.suuri.srkessan.srskoikomipdenpyoudata;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.SetDenSimebi;
/**
 * 新契約追込保険料伝票データバッチパラメータクラス
 */
@BatchScoped
public class SrSkOikomiPDenpyouDataBatchParam extends BzBatchParam {

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


    public void setParam() {

        ksnyokugetufirstdayymd = ksnbiymd.getBizDateYM().addMonths(1).getFirstDay();

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        ksndensimeymd = setDenSimebi.exec(ksnyokugetufirstdayymd);

    }
}

package yuyu.batch.suuri.srkessan.srskkessanoikmdata;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * （数理）新契約決算用追込データバッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrSkKessanOikmDataBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public SrSkKessanOikmDataBatchParam() {
    }

    private int ibSyorikensuu;

    public int getIbSyorikensuu() {
        return ibSyorikensuu;
    }

    public void setIbSyorikensuu(int pIbSyorikensuu) {
        ibSyorikensuu = pIbSyorikensuu;
    }

    private BizDate ibKsnbiymd;

    public BizDate getIbKsnbiymd() {
        return ibKsnbiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsnbiymd(BizDate pIbKsnbiymd) {
        ibKsnbiymd = pIbKsnbiymd;
    }

    private BizDate ibKsnyokugetu1steigyoubiymd;

    public BizDate getIbKsnyokugetu1steigyoubiymd() {
        return ibKsnyokugetu1steigyoubiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsnyokugetu1steigyoubiymd(BizDate pIbKsnyokugetu1steigyoubiymd) {
        ibKsnyokugetu1steigyoubiymd = pIbKsnyokugetu1steigyoubiymd;
    }

    private BizDate ibKsnsaisyueigyoubiymd;

    public BizDate getIbKsnsaisyueigyoubiymd() {
        return ibKsnsaisyueigyoubiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIbKsnsaisyueigyoubiymd(BizDate pIbKsnsaisyueigyoubiymd) {
        ibKsnsaisyueigyoubiymd = pIbKsnsaisyueigyoubiymd;
    }

    public void setParam() {

        setIbSyorikensuu(0);

        setIbKsnyokugetu1steigyoubiymd(
            getIbKsnbiymd().getBizDateYM().addMonths(1).
            getFirstDay().getBusinessDay(CHolidayAdjustingMode.NEXT));

        boolean result = getIbKsnbiymd().isBusinessDay();

        if (result) {

            setIbKsnsaisyueigyoubiymd(getIbKsnbiymd());

        }
        else {

            setIbKsnsaisyueigyoubiymd(getIbKsnbiymd().getBusinessDay(CHolidayAdjustingMode.PREVIOUS));

        }
    }
}

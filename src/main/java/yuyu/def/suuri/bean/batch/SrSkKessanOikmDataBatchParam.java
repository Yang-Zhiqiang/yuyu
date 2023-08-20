package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
/**
 * （数理）新契約決算用追込データバッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrSkKessanOikmDataBatchParam extends GenSrSkKessanOikmDataBatchParam {

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

    public void setParam() {

        setIbSyorikensuu(0);

        super.setIbKsnyokugetu1steigyoubiymd(
            super.getIbKsnbiymd().getBizDateYM().addMonths(1).
            getFirstDay().getBusinessDay(CHolidayAdjustingMode.NEXT));

        boolean result = super.getIbKsnbiymd().isBusinessDay();

        if (result) {

            super.setIbKsnsaisyueigyoubiymd(super.getIbKsnbiymd());

        }
        else {

            super.setIbKsnsaisyueigyoubiymd(super.getIbKsnbiymd().getBusinessDay(CHolidayAdjustingMode.PREVIOUS));

        }
    }
}

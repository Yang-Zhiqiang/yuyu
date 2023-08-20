package yuyu.def.suuri.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * （数理）新契約追込調整伝票DSBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class SrSkOikomiTyouseiDenpyouDataSourceBean extends GenSrSkOikomiTyouseiDenpyouDataSourceBean {

    private static final long serialVersionUID = 1L;

    public SrSkOikomiTyouseiDenpyouDataSourceBean() {

        super.setIrKarikatagk(BizCurrency.valueOf(0));
        super.setIrKasikatagk(BizCurrency.valueOf(0));
        super.setIrGoukeikensuukarikata(BizNumber.valueOf(0));
        super.setIrGoukeikensuukasikata(BizNumber.valueOf(0));
    }

}

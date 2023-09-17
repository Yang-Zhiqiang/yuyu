package yuyu.def.biz.bean.report;

import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;

/**
 * （共通）資金移動リスト（円建変更分）帳票DSBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class BzSikinIdouListYendthnkbunDataSourceBean extends GenBzSikinIdouListYendthnkbunDataSourceBean {

    private static final long serialVersionUID = 1L;

    public BzSikinIdouListYendthnkbunDataSourceBean() {
    }

    @Setter @Getter
    private BizCurrency siteituukagoukeigk;

    @Setter @Getter
    private BizCurrency trhktuukagoukeigk;
}

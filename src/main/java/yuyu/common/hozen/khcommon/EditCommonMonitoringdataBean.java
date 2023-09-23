package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 契約保全モニタリングデータ共通項目編集Bean
 */
public class EditCommonMonitoringdataBean implements Serializable {

    private static final long serialVersionUID = 1L;
    public EditCommonMonitoringdataBean() {
        super();
    }

    @Setter @Getter
    private String syono;

    @Setter @Getter
    private String okyksmno;

    @Setter @Getter
    private String kyknmkn;

    @Setter @Getter
    private String kyknmkj;

    @Setter @Getter
    private BizDate seiymd;

    @Setter @Getter
    private String kihontikucd;

    @Setter @Getter
    private BizDate kykymd;

    @Setter @Getter
    private BizDate zougakukeii;

    @Setter @Getter
    private BizCurrency zougakukingaku;

    @Setter @Getter
    private BizDate meighnkkeii;

    @Setter @Getter
    private String hrkkeirokbn;

    @Setter @Getter
    private String syuunoukeirokbn;

    @Setter @Getter
    private C_KzkykdouKbn kzkykdoukbn;

    @Setter @Getter
    private String atukaisisyacd;

    @Setter @Getter
    private String atukaisibucd;

    @Setter @Getter
    private String atukaikojincd;

    @Setter @Getter
    private C_UmuKbn mrkykhyj;

    @Setter @Getter
    private C_UmuKbn naibukykhyj;

    @Setter @Getter
    private C_UmuKbn jikokykhyj;

    @Setter @Getter
    private C_UmuKbn hjnkykhyj;

    @Setter @Getter
    private String syouhnbunruikbn;

    @Setter @Getter
    private String syouhnnmkbn;

    @Setter @Getter
    private C_UmuKbn houteityotkhknhyj;

    @Setter @Getter
    private C_UmuKbn tyotkhknhyj;

    @Setter @Getter
    private String highcverrorkbn;

    @Setter @Getter
    private C_UmuKbn highriskflg;
}

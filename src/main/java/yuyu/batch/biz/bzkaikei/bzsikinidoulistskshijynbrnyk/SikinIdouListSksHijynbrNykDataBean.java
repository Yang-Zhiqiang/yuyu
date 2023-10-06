package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 平準払入金用資金移動データBEANです。<br />
 */
public class SikinIdouListSksHijynbrNykDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateYM sikinidoupjytym;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private C_Tuukasyu siteituuka;

    @Getter @Setter
    private BizCurrency siteituukagk;

    @Getter @Setter
    private C_Tuukasyu trhktuuka;

    @Getter @Setter
    private BizCurrency trhktuukagk;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private C_SikinidougroupKbn sikinidougroupkbn;

    @Getter @Setter
    private C_SikinidoumeisaiKbn sikinidoumeisaikbn;

    @Getter @Setter
    private C_SikinidouJtKbn sikinidoujtkbn;

    @Getter @Setter
    private BizNumber sikinidoukawaserate;

    @Getter @Setter
    private C_SikinidouPKbn sikinidoupkbn;

    @Getter @Setter
    private String sikinidoukbnnm;
}

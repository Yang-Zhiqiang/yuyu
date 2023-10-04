package yuyu.batch.hozen.khozen.khdseisan;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全 精算Ｄ追払対象データBeanクラス
 */
public class SeisanDTuiHrtaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String ifcYno;

    @Getter @Setter
    private String ifcKyksyamei;

    @Getter @Setter
    private String ifcSyono;

    @Getter @Setter
    private String ifcSyoumetujiyuu;

    @Getter @Setter
    private String ifcTtdktyuuinaiyou;

    @Getter @Setter
    private String ifcShrhou;

    @Getter @Setter
    private String ifcTuukasyu;

    @Getter @Setter
    private BizCurrency ifcShrgkgoukeibizc;

    @Getter @Setter
    private BizCurrency ifcYenkahaitoukingkbizc;

    @Getter @Setter
    private BizCurrency ifcYenkahaitoukinbizc;

    @Getter @Setter
    private BizCurrency ifcYenkasonotahaitoukinbizc;

    @Getter @Setter
    private BizCurrency ifcYenkagstszeigkbizc;

    @Getter @Setter
    private BizCurrency ifcYenkashrtienrskbizc;

    @Getter @Setter
    private BizCurrency ifcGaikahaitoukingkbizc;

    @Getter @Setter
    private BizCurrency ifcGaikagstszeigkbizc;

    @Getter @Setter
    private BizCurrency ifcGaikashrtienrskbizc;

    @Getter @Setter
    private BizNumber ifcGaikashrkwsrate;

    @Getter @Setter
    private BizNumber ifcZeimukwsrate;

    @Getter @Setter
    private BizCurrency ifcSynykngkbizc;

    @Getter @Setter
    private BizCurrency ifcHtykeihibizc;

    @Getter @Setter
    private BizCurrency ifcGenkykhtykeihibizc;

    @Getter @Setter
    private Integer ifcKykhnkkaisuu;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

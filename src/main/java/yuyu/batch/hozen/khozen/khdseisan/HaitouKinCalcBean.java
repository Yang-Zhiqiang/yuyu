package yuyu.batch.hozen.khozen.khdseisan;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;

/**
 * 契約保全 契約保全 配当金額計算Beanクラス
 */
public class HaitouKinCalcBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public HaitouKinCalcBean() {
        siharaiGk = BizCurrency.valueOf(0);
    }

    @Getter @Setter
    private BizCurrency haitoukin;

    @Getter @Setter
    private BizCurrency kariwariatedGanrikin;

    @Getter @Setter
    private BizCurrency seisand;

    @Getter @Setter
    private BizCurrency seisandShrTuukasyu;

    @Getter @Setter
    private BizCurrency seisandKykTuukasyu;

    @Getter @Setter
    private BizCurrency seisandShrTuukasyuGensenTusshkg;

    @Getter @Setter
    private BizCurrency siharaiGk;

    @Getter @Setter
    private BizDate siharaiYmd;

    @Getter @Setter
    private KeisanGensenBean keisanGensenBean;

    @Getter @Setter
    private KeisanTienrisokuBean keisanTienrisokuBean;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

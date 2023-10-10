package yuyu.app.hozen.khansyuu.khharaikatahenkou.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全 仮受金情報の領収日の最小値・最大値、仮受金額の合計Beanクラス
 */
public class KariukekinMinRyosyuymdSumKrkgkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter@Setter
    private BizDate minRyosyuymd;

    @Getter@Setter
    private BizDate maxRyosyuymd;

    @Getter@Setter
    private BizCurrency sumKrkgk;

    @Getter@Setter
    private BizDate maxHasseidenymd;

    public KariukekinMinRyosyuymdSumKrkgkBean(BizDate pRyosyuymd, BizDate pRyosyuymdMax, String sumKrkgkType,
        BigDecimal sumKrkgkValue, BizDate pHasseidenymd){
        this.minRyosyuymd = pRyosyuymd;
        this.maxRyosyuymd = pRyosyuymdMax;
        sumKrkgk = new BizCurrencySum(sumKrkgkType, sumKrkgkValue).toBizCurrency();
        this.maxHasseidenymd = pHasseidenymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

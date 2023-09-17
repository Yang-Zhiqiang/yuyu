package yuyu.def.biz.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * 前月分伝票データ集計情報Beanクラスです。<br />
 */
public class ZengetubunDenpyouDatasByDenymdFromDenymdToBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public ZengetubunDenpyouDatasByDenymdFromDenymdToBean(String _hjybtantositucd,
        String _syorisosikicd,
        C_Kanjyoukmkcd _kanjyoukmkcd,
        BizDate _denymd,
        String _syoricd,
        String _huridenatesakicd,
        String _busitucd,
        String _type,
        BigDecimal _value,
        String _type2,
        BigDecimal _value2){
        hjybtantositucd = _hjybtantositucd;
        syorisosikicd = _syorisosikicd;
        kanjyoukmkcd = _kanjyoukmkcd;
        denymd = _denymd;
        syoricd = _syoricd;
        huridenatesakicd = _huridenatesakicd;
        busitucd = _busitucd;
        karikatagk = new BizCurrencySum(_type, _value).toBizCurrency();
        kasikatagk = new BizCurrencySum(_type2, _value2).toBizCurrency();
    }

    @Getter @Setter
    private String hjybtantositucd;

    @Getter @Setter
    private String syorisosikicd;

    @Getter @Setter
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Getter @Setter
    private BizDate denymd;

    @Getter @Setter
    private String syoricd;

    @Getter @Setter
    private String huridenatesakicd;

    @Getter @Setter
    private String busitucd;

    @Getter @Setter
    private BizCurrency karikatagk;

    @Getter @Setter
    private BizCurrency kasikatagk;

}

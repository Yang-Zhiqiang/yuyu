package yuyu.def.hozen.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全共通 指数連動積増型年金積立金情報Bean
 */
public class SisurendoTmttknInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDateYM tmttknTaisyouYM;

    @Getter @Setter
    private BizCurrency teirituTmttknGK;

    @Getter @Setter
    private BizCurrency sisuuRendouTmttknGK;

    @Getter @Setter
    private BizNumber tmttknhaneisisuu;

    public SisurendoTmttknInfoBean(BizDateYM pTmttkntaisyouym,
        String pTeiritutmttkngkType,
        BigDecimal pTeiritutmttkngkValue,
        String pSisuurendoutmttkngkType,
        BigDecimal pSisuurendoutmttkngkValue,
        BizNumber pTmttknhaneisisuu
        ) {

        tmttknTaisyouYM = pTmttkntaisyouym;
        teirituTmttknGK = new BizCurrencySum(pTeiritutmttkngkType, pTeiritutmttkngkValue).toBizCurrency();
        sisuuRendouTmttknGK = new BizCurrencySum(pSisuurendoutmttkngkType, pSisuurendoutmttkngkValue).toBizCurrency();
        tmttknhaneisisuu = pTmttknhaneisisuu;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

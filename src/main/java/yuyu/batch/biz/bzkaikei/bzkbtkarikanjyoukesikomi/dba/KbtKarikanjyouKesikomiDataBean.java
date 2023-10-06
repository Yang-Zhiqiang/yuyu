package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoukesikomi.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * 業務共通 経理・会計 個別仮勘定消込Bean
 */
public class KbtKarikanjyouKesikomiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizNumber kbtkarikanjyouskbtkey;

    @Getter
    @Setter
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Getter
    @Setter
    private String keirisyono;

    @Getter
    @Setter
    private BizCurrency denyenkagk;

    public KbtKarikanjyouKesikomiDataBean(BizNumber pKbtkarikanjyouskbtkey,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        String pKeirisyono,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue) {
        kbtkarikanjyouskbtkey = pKbtkarikanjyouskbtkey;
        kanjyoukmkcd = pKanjyoukmkcd;
        keirisyono = pKeirisyono;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}

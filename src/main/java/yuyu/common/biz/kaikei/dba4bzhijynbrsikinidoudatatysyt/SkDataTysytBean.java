package yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理・会計 請求テーブルデータ抽出の処理対象を保持するBeanクラス
 */
public class SkDataTysytBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizDateYM mikeikapjyuutouym;

    @Getter
    @Setter
    private BizCurrency zitkazukarikingksiteituuka;

    @Getter
    @Setter
    private BizCurrency misyuup;

    public SkDataTysytBean(BizDateYM pMikeikapjyuutouym,
        String pZitkazukarikingksiteituukaType,
        BigDecimal pZitkazukarikingksiteituukaValue,
        String pMisyuupType,
        BigDecimal pMisyuupValue) {

        mikeikapjyuutouym = pMikeikapjyuutouym;
        zitkazukarikingksiteituuka = new BizCurrencySum(pZitkazukarikingksiteituukaType,
            pZitkazukarikingksiteituukaValue).toBizCurrency();
        misyuup = new BizCurrencySum(pMisyuupType, pMisyuupValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

package yuyu.batch.hozen.khinterf.khyendthnkkykfilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Tuukasyu;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス 契約商品変更前内容Beanクラス
 */
public class KykSyouhnHnkmaeBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizCurrency hokenryou;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private Integer targettkmokuhyouti;

    @Getter @Setter
    private BizCurrency targettkykkijyungk;

    public KykSyouhnHnkmaeBean(String pHokenryouType,
        BigDecimal pHokenryouValue,
        C_Tuukasyu pkyktuukasy,
        Integer pTargettkmokuhyouti,
        String pTargettkykkijyungkType,
        BigDecimal pTargettkykkijyungkValue) {

        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
        kyktuukasyu = pkyktuukasy;
        targettkmokuhyouti= pTargettkmokuhyouti;
        targettkykkijyungk = new BizCurrencySum(pTargettkykkijyungkType, pTargettkykkijyungkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}

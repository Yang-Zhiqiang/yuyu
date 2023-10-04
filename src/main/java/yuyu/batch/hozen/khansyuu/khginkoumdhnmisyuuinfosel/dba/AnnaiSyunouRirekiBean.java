package yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;

/**
 * 契約保全 案内収納 案内収納履歴情報を保持するBeanクラス
 */
@AllArgsConstructor
public class AnnaiSyunouRirekiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private Integer jyutoukaisuuy;

    @Getter @Setter
    private Integer jyutoukaisuum;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private C_HurihunoKbn hurihunokbn;

    @Getter @Setter
    private BizCurrency rsgaku;

    public AnnaiSyunouRirekiBean(BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        C_Hrkkaisuu pHrkkaisuu,
        C_HurihunoKbn pHurihunokbn,
        String pRsgakuType,
        BigDecimal pRsgakuValue) {

        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        hrkkaisuu = pHrkkaisuu;
        hurihunokbn = pHurihunokbn;
        rsgaku = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}

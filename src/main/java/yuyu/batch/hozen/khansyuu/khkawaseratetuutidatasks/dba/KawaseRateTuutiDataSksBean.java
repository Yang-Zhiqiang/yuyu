package yuyu.batch.hozen.khansyuu.khkawaseratetuutidatasks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;

/**
 * 為替レート通知データ作成Beanクラスです。<br />
 */
public class KawaseRateTuutiDataSksBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private C_AisyoumeiKbn aisyoumeikbn;

    @Getter @Setter
    private C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizDateYM jkipjytym;

    public KawaseRateTuutiDataSksBean() {
    }

    public KawaseRateTuutiDataSksBean(String pKbnkey,
        String pSyono,
        C_Hrkkaisuu pHrkkaisuu,
        String pHrkpType,
        BigDecimal pHrkpValue,
        C_AisyoumeiKbn pAisyoumeikbn,
        C_YnkHrkmgkAnniTuutiKbn pYnkhrkmgkannituutikbn,
        BizDate pKykymd,
        C_Tuukasyu pKyktuukasyu,
        BizDateYM pJkipjytym) {
        this.kbnkey = pKbnkey;
        this.syono = pSyono;
        this.hrkkaisuu = pHrkkaisuu;
        this.hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        this.aisyoumeikbn = pAisyoumeikbn;
        this.ynkhrkmgkannituutikbn = pYnkhrkmgkannituutikbn;
        this.kykymd = pKykymd;
        this.kyktuukasyu = pKyktuukasyu;
        this.jkipjytym = pJkipjytym;
    }

    @Override
    public String toString(){
        return BeanUtil.toString(this);
    }
}

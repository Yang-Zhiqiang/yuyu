package yuyu.batch.direct.dsmailhaisinkanri.dsjkihknryouosirsmailsakusei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 為替レート通知データBeanリストクラス<br />
 */
public class DsKawaseRateTuutiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate kwsratekjymd;

    @Getter @Setter
    private BizNumber kawaserate;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private String bosyuujiaatukaidrtenkj;

    @Getter @Setter
    private C_AisyoumeiKbn aisyoumeikbn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private BizCurrency siteituukap;

    public DsKawaseRateTuutiDataBean(String pKbnkey,
        String pSyono,
        BizDate pKwsratekjymd,
        BizNumber pKawaserate,
        C_Tuukasyu pKyktuukasyu,
        String pBosyuujiaatukaidrtenkj,
        C_AisyoumeiKbn pAisyoumeikbn,
        BizDate pKykymd,
        String pHrkpType,
        BigDecimal pHrkpValue,
        String pSiteituukapType,
        BigDecimal pSiteituukapValue
        ) {

        kbnkey = pKbnkey;
        syono = pSyono;
        kwsratekjymd = pKwsratekjymd;
        kawaserate = pKawaserate;
        kyktuukasyu = pKyktuukasyu;
        bosyuujiaatukaidrtenkj = pBosyuujiaatukaidrtenkj;
        aisyoumeikbn = pAisyoumeikbn;
        kykymd = pKykymd;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        siteituukap = new BizCurrencySum(pSiteituukapType, pSiteituukapValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

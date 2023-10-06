package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 平準払入金データBeanクラス
 */
public class HijynbrNykDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateYM jyutouendym;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private Integer jyutoukaisuuy;

    @Getter @Setter
    private Integer jyutoukaisuum;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private C_Tuukasyu rstuukasyu;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private BizDate fstpnyknymd;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizCurrency hokenryou;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private C_Segcd segcd;

    public HijynbrNykDataBean(
        String pSyono,
        BizDateYM pJyutouendym,
        Integer pRenno,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_Tuukasyu pRstuukasyu,
        String pHrkpType,
        BigDecimal pHrkpValue,
        BizDate pFstpnyknymd,
        BizDateYM pJkipjytym,
        C_Tuukasyu pKyktuukasyu,
        String pHokenryouType,
        BigDecimal pHokenryouValue,
        BizDate pKykymd,
        C_Segcd pSegcd) {

        syono = pSyono;
        jyutouendym = pJyutouendym;
        renno = pRenno;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        nyknaiyoukbn = pNyknaiyoukbn;
        rstuukasyu = pRstuukasyu;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        fstpnyknymd = pFstpnyknymd;
        jkipjytym = pJkipjytym;
        kyktuukasyu = pKyktuukasyu;
        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
        kykymd = pKykymd;
        segcd = pSegcd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

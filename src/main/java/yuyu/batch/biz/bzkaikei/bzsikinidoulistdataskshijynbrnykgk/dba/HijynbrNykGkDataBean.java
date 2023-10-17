package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnykgk.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 業務共通 経理・会計 平準払入金外貨データBeanクラス
 */
public class HijynbrNykGkDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate nyksyoriymd;

    @Getter @Setter
    private BizDate nyktrksymd;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private C_Tuukasyu rstuukasyu;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizNumber ryosyukwsrate;

    @Getter @Setter
    private Integer ikkatuyoupkaisuu;

    @Getter @Setter
    private C_Segcd segcd;

    public HijynbrNykGkDataBean(
        String pSyono,
        BizDate pNyksyoriymd,
        BizDate pNyktrksymd,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyoukbn,
        BigDecimal pHrkpValue,
        String pHrkpType,
        C_Tuukasyu pRstuukasyu,
        BigDecimal pRsgakuValue,
        String pRsgakuType,
        BizNumber pRyosyukwsrate,
        Integer pIkkatuyoupkaisuu,
        C_Segcd pSegcd) {

        syono = pSyono;
        nyksyoriymd = pNyksyoriymd;
        nyktrksymd = pNyktrksymd;
        nykkeiro = pNykkeiro;
        nyknaiyoukbn = pNyknaiyoukbn;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        rstuukasyu = pRstuukasyu;
        rsgaku = new BizCurrencySum(pRsgakuType,pRsgakuValue).toBizCurrency();
        ryosyukwsrate = pRyosyukwsrate;
        ikkatuyoupkaisuu = pIkkatuyoupkaisuu;
        segcd = pSegcd;

    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

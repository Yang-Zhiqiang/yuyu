package yuyu.def.sinkeiyaku.result.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 一時払入金情報Beanクラスです。<br />
 */
public class ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean() {
    }

    public ItijibaraiNkInfosByKakutyoujobcdStartymdFromSyoriYmdBean (BizDate pInputymd, String pMosno, BizDate pMosnrkymd,
        BizDate pNyksyoriymd, C_Tuukasyu pRstuukasyu, String pRsgakuType, BigDecimal pRsgakuValue,
        String pDenyenkagkType, BigDecimal pDenyenkagkValue, C_Segcd pSeg1cd, BizNumber pDenkawaserate) {

        inputymd = pInputymd;
        mosno = pMosno;
        mosnrkymd = pMosnrkymd;
        nyksyoriymd = pNyksyoriymd;
        rstuukasyu = pRstuukasyu;
        rsgaku = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        seg1cd = pSeg1cd;
        denkawaserate = pDenkawaserate;

    }

    @Getter @Setter
    private BizDate inputymd;

    @Getter @Setter
    private String mosno;

    @Getter @Setter
    private BizDate mosnrkymd;

    @Getter @Setter
    private BizDate nyksyoriymd;

    @Getter @Setter
    private C_Tuukasyu rstuukasyu;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizCurrency denyenkagk;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private BizNumber denkawaserate;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

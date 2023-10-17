package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyoudatasks.dba;

import java.io.Serializable;
import java.math.BigDecimal;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;

/**
 * 業務共通 経理・会計 個別仮勘定経理伝票データBean
 */
public class KbtKarikanjyouKrDenpyoDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private C_DensysKbn densyskbn;

    @Getter
    @Setter
    private String denrenno;

    @Getter
    @Setter
    private Integer edano;

    @Getter
    @Setter
    private String keirisyono;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private BizDate denymd;

    @Getter
    @Setter
    private String huridenatesakicd;

    @Getter
    @Setter
    private C_TaisyakuKbn taisyakukbn;

    @Getter
    @Setter
    private BizCurrency denyenkagk;

    @Getter
    @Setter
    private String syoricd;

    @Getter
    @Setter
    private String syorisosikicd;

    @Getter
    @Setter
    private C_Segcd seg1cd;

    @Getter
    @Setter
    private String nyuukinkakusyouno;

    @Getter
    @Setter
    private String denkanjokamokucd;

    public KbtKarikanjyouKrDenpyoDataBean(C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano,
        String pKeirisyono,
        BizDate pSyoriYmd,
        BizDate pDenymd,
        String pHuridenatesakicd,
        C_TaisyakuKbn pTaisyakukbn,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue,
        String pSyoricd,
        String pSyorisosikicd,
        C_Segcd pSeg1cd,
        String pNyuukinkakusyouno,
        String pDenkanjokamokucd) {
        densyskbn = pDensyskbn;
        denrenno = pDenrenno;
        edano = pEdano;
        keirisyono = pKeirisyono;
        nyuukinkakusyouno = pNyuukinkakusyouno;
        syoriYmd = pSyoriYmd;
        denymd = pDenymd;
        huridenatesakicd = pHuridenatesakicd;
        taisyakukbn = pTaisyakukbn;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        syoricd = pSyoricd;
        syorisosikicd = pSyorisosikicd;
        seg1cd = pSeg1cd;
        denkanjokamokucd = pDenkanjokamokucd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
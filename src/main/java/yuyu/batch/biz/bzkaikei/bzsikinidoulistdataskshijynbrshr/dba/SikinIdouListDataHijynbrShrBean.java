package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 資金移動リストデータ平準払支払用BEANです。<br />
 */
public class SikinIdouListDataHijynbrShrBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_DensysKbn densyskbn;

    @Getter @Setter
    private String denrenno;

    @Getter @Setter
    private Integer edano;

    @Getter @Setter
    private BizDate denymd;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizCurrency hijynbrsikinidougk;

    @Getter @Setter
    private String syusyouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private String syoricd;

    @Getter @Setter
    private C_Tuukasyu tuukasyu;

    @Getter @Setter
    private BizCurrency denyenkagk;

    @Getter @Setter
    private BizCurrency dengaikagk;

    @Getter @Setter
    private String syono;


    public SikinIdouListDataHijynbrShrBean(
        C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano,
        BizDate pDenymd,
        C_Tuukasyu pKyktuukasyu,
        String pHijynbrsikinidougkType,
        BigDecimal pHijynbrsikinidougkValue,
        String pSyusyouhncd,
        Integer pSyouhnsdno,
        String pSyoricd,
        C_Tuukasyu pTuukasyu,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue,
        String pDengaikagkType,
        BigDecimal pDengaikagkValue,
        String pSyono) {
        densyskbn = pDensyskbn;
        denrenno = pDenrenno;
        edano = pEdano;
        denymd = pDenymd;
        kyktuukasyu = pKyktuukasyu;
        hijynbrsikinidougk = new BizCurrencySum(pHijynbrsikinidougkType, pHijynbrsikinidougkValue).toBizCurrency();
        syusyouhncd = pSyusyouhncd;
        syouhnsdno = pSyouhnsdno;
        syoricd = pSyoricd;
        tuukasyu = pTuukasyu;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        dengaikagk = new BizCurrencySum(pDengaikagkType, pDengaikagkValue).toBizCurrency();
        syono = pSyono;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

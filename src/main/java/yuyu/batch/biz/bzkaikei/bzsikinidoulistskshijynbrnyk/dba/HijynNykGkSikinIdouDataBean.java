package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 平準払入金外貨資金移動データBEANです。<br />
 */
public class HijynNykGkSikinIdouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private C_SikinidouPKbn sikinidoupkbn;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private Integer renno;

    @Getter @Setter
    private C_Tuukasyu siteituuka;

    @Getter @Setter
    private BizCurrency siteituukagk;

    @Getter @Setter
    private C_Tuukasyu trhktuuka;

    @Getter @Setter
    private BizCurrency trhktuukagk;

    @Getter @Setter
    private C_Segcd seg1cd;

    @Getter @Setter
    private C_SikinidougroupKbn sikinidougroupkbn;

    @Getter @Setter
    private C_SikinidoumeisaiKbn sikinidoumeisaikbn;

    @Getter @Setter
    private C_SikinidouJtKbn sikinidoujtkbn;

    @Getter @Setter
    private BizNumber sikinidoukawaserate;

    @Getter @Setter
    private String sikinidoukbnnm;

    public HijynNykGkSikinIdouDataBean(
        BizDate pSyoriYmd,
        C_SikinidouPKbn pSikinidoupkbn,
        String pSyono,
        Integer pRenno,
        C_Tuukasyu pSiteituuka,
        String pSiteituukagkType,
        BigDecimal pSiteituukagkValue,
        C_Tuukasyu pTrhktuuka,
        String pTrhktuukagkType,
        BigDecimal pTrhktuukagkValue,
        C_Segcd pSeg1cd,
        C_SikinidougroupKbn pSikinidougroupkbn,
        C_SikinidoumeisaiKbn pSikinidoumeisaikbn,
        C_SikinidouJtKbn pSikinidoujtkbn,
        BizNumber pSikinidoukawaserate
        ) {
        syoriYmd = pSyoriYmd;
        sikinidoupkbn = pSikinidoupkbn;
        syono = pSyono;
        renno = pRenno;
        siteituuka = pSiteituuka;
        siteituukagk = new BizCurrencySum(pSiteituukagkType, pSiteituukagkValue).toBizCurrency();
        trhktuuka = pTrhktuuka;
        trhktuukagk = new BizCurrencySum(pTrhktuukagkType, pTrhktuukagkValue).toBizCurrency();
        seg1cd = pSeg1cd;
        sikinidougroupkbn = pSikinidougroupkbn;
        sikinidoumeisaikbn = pSikinidoumeisaikbn;
        sikinidoujtkbn = pSikinidoujtkbn;
        sikinidoukawaserate = pSikinidoukawaserate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

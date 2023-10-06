package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 平準払入金用資金移動データBEANです。<br />
 */
public class HijynNykSikinIdouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateYM sikinidoupjytym;

    @Getter @Setter
    private BizDate syoriYmd;

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
    private C_SikinidouPKbn sikinidoupkbn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private BizDate fstpnyknymd;

    @Getter @Setter
    private BizDate syoumetuymd;

    @Getter @Setter
    private String sikinidoukbnnm;

    public HijynNykSikinIdouDataBean(
        String pSyono,
        BizDateYM pSikinidoupjytym,
        BizDate pSyoriYmd,
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
        BizNumber pSikinidoukawaserate,
        C_SikinidouPKbn pSikinidoupkbn,
        BizDate pKykymd,
        BizDate pFstpnyknymd,
        BizDate pSyoumetuymd
        ) {

        syono = pSyono;
        sikinidoupjytym = pSikinidoupjytym;
        syoriYmd = pSyoriYmd;
        siteituuka = pSiteituuka;
        siteituukagk = new BizCurrencySum(pSiteituukagkType, pSiteituukagkValue).toBizCurrency();
        trhktuuka = pTrhktuuka;
        trhktuukagk = new BizCurrencySum(pTrhktuukagkType, pTrhktuukagkValue).toBizCurrency();
        seg1cd = pSeg1cd;
        sikinidougroupkbn = pSikinidougroupkbn;
        sikinidoumeisaikbn = pSikinidoumeisaikbn;
        sikinidoujtkbn = pSikinidoujtkbn;
        sikinidoukawaserate = pSikinidoukawaserate;
        sikinidoupkbn = pSikinidoupkbn;
        kykymd = pKykymd;
        fstpnyknymd = pFstpnyknymd;
        syoumetuymd = pSyoumetuymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

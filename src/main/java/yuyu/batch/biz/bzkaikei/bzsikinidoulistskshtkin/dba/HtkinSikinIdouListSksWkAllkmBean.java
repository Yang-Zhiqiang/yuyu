package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshtkin.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 配当金資金移動リスト作成用ワークテーブル（全項目）Beanクラスです。<br />
 */
public class HtkinSikinIdouListSksWkAllkmBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate kijyunymd;

    @Getter @Setter
    private BizDateY haitounendo;

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
    private BizNumber sikinidoukawaserate;

    public HtkinSikinIdouListSksWkAllkmBean(
        String pSyono,
        BizDate pKijyunymd,
        BizDateY pHaitounendo,
        C_Tuukasyu pSiteituuka,
        String pSiteituukagkType,
        BigDecimal pSiteituukagkValue,
        C_Tuukasyu pTrhktuuka,
        String pTrhktuukagkType,
        BigDecimal pTrhktuukagkValue,
        C_Segcd pSeg1cd,
        C_SikinidougroupKbn pSikinidougroupkbn,
        BizNumber pSikinidoukawaserate) {

        syono = pSyono;
        kijyunymd = pKijyunymd;
        haitounendo = pHaitounendo;
        siteituuka = pSiteituuka;
        siteituukagk = new BizCurrencySum(pSiteituukagkType, pSiteituukagkValue).toBizCurrency();
        trhktuuka = pTrhktuuka;
        trhktuukagk = new BizCurrencySum(pTrhktuukagkType, pTrhktuukagkValue).toBizCurrency();
        seg1cd = pSeg1cd;
        sikinidougroupkbn = pSikinidougroupkbn;
        sikinidoukawaserate = pSikinidoukawaserate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

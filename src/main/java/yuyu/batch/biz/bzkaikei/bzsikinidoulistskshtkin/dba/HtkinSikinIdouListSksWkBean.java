package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshtkin.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 配当金資金移動リスト作成用ワークテーブルBeanクラスです。<br />
 */
public class HtkinSikinIdouListSksWkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_SikinidougroupKbn sikinidougroupkbn;

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

    public HtkinSikinIdouListSksWkBean(
        C_SikinidougroupKbn pSikinidougroupkbn,
        C_Tuukasyu pSiteituuka,
        String pSiteituukagkType,
        BigDecimal pSiteituukagkValue,
        C_Tuukasyu pTrhktuuka,
        String pTrhktuukagkType,
        BigDecimal pTrhktuukagkValue,
        C_Segcd pSeg1cd) {

        sikinidougroupkbn = pSikinidougroupkbn;
        siteituuka = pSiteituuka;
        siteituukagk = new BizCurrencySum(pSiteituukagkType, pSiteituukagkValue).toBizCurrency();
        trhktuuka = pTrhktuuka;
        trhktuukagk = new BizCurrencySum(pTrhktuukagkType, pTrhktuukagkValue).toBizCurrency();
        seg1cd = pSeg1cd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

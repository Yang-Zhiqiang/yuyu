package yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全 契約保全簡易契約内容訂正Beanクラスです。
 */
public class YendthnkSikinIdouDataKingakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    C_Tuukasyu siteituuka;

    @Getter
    @Setter
    BizCurrency siteituukagk;

    @Getter
    @Setter
    C_Tuukasyu trhktuuka;

    @Getter
    @Setter
    BizCurrency trhktuukagk;

    public YendthnkSikinIdouDataKingakuBean (
        C_Tuukasyu pSiteituuka,
        String pSiteituukagkType,
        BigDecimal pSiteituukagkValue,
        C_Tuukasyu pTrhktuuka,
        String pTrhktuukagkType,
        BigDecimal pTrhktuukagkValue) {
        siteituuka = pSiteituuka;
        siteituukagk = new BizCurrencySum(pSiteituukagkType, pSiteituukagkValue).toBizCurrency();
        trhktuuka = pTrhktuuka;
        trhktuukagk = new BizCurrencySum(pTrhktuukagkType, pTrhktuukagkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

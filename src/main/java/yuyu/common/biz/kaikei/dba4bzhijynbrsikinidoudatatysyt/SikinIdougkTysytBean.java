package yuyu.common.biz.kaikei.dba4bzhijynbrsikinidoudatatysyt;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 経理・会計 資金移動金額抽出の処理対象を保持するBeanクラス
 */
public class SikinIdougkTysytBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizDateYM sikinidoupjytym;

    @Getter
    @Setter
    private BizCurrency siteituukagk;

    @Getter
    @Setter
    private BizCurrency trhktuukagk;

    @Getter
    @Setter
    private BizNumber sikinidoukawaserate;

    public SikinIdougkTysytBean(BizDateYM pSikinidoupjytym,
        String pSiteituukagkType,
        BigDecimal pSiteituukagkValue,
        String pTrhktuukagkType,
        BigDecimal pTrhktuukagkValue,
        BizNumber pSikinidoukawaserate) {

        sikinidoupjytym = pSikinidoupjytym;
        siteituukagk = new BizCurrencySum(pSiteituukagkType, pSiteituukagkValue).toBizCurrency();
        trhktuukagk = new BizCurrencySum(pTrhktuukagkType, pTrhktuukagkValue).toBizCurrency();
        sikinidoukawaserate = pSikinidoukawaserate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

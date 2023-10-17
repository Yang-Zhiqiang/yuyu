package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba;

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
 * 業務共通 経理･会計 資金移動金額抽出BEAN
 */
public class SikinIdougkTysytBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private BizDateYM sikinidouPJytYm;

    @Getter
    @Setter
    private BizCurrency siteituukaGk;

    @Getter
    @Setter
    private BizCurrency trhktuukaGk;

    @Getter
    @Setter
    private BizNumber sikinidouKawaserate;

    public SikinIdougkTysytBean(BizDateYM pSikinidouPJytYm,
        String pSiteituukaGkType,
        BigDecimal pSiteituukaGkValue,
        String pTrhktuukaGkType,
        BigDecimal pTrhktuukaGkValue,
        BizNumber pSikinidouKawaserate) {

        sikinidouPJytYm = pSikinidouPJytYm;
        siteituukaGk = new BizCurrencySum(pSiteituukaGkType, pSiteituukaGkValue).toBizCurrency();
        trhktuukaGk = new BizCurrencySum(pTrhktuukaGkType, pTrhktuukaGkValue).toBizCurrency();
        sikinidouKawaserate = pSikinidouKawaserate;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

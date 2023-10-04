package yuyu.batch.hozen.khozen.khdhanei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;

/**
 * 契約保全 契約保全 配当管理情報取得Bean
 */
public class KhHaitouKanriBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDateY haitouNendo;

    @Getter
    @Setter
    private Integer renno;

    @Getter
    @Setter
    private C_HaitoukinsksKbn haitoukinSksKbn;

    @Getter
    @Setter
    private C_HaitoumeisaiKbn haitouMeisaiKbn;

    @Getter
    @Setter
    private BizDateY fstKariwariateDNendo;

    @Getter
    @Setter
    private BizCurrency kariwariateDRuigk;

    public KhHaitouKanriBean(String pSyono,
        BizDateY pHaitouNendo,
        Integer pRenno,
        C_HaitoukinsksKbn pHaitoukinSksKbn,
        C_HaitoumeisaiKbn pHaitouMeisaiKbn,
        BizDateY pFstKariwariateDNendo,
        String pKariwariateDRuigkType,
        BigDecimal pKariwariateDRuigkValue) {

        syono = pSyono;
        haitouNendo = pHaitouNendo;
        renno = pRenno;
        haitoukinSksKbn = pHaitoukinSksKbn;
        haitouMeisaiKbn = pHaitouMeisaiKbn;
        fstKariwariateDNendo = pFstKariwariateDNendo;
        kariwariateDRuigk = new BizCurrencySum(pKariwariateDRuigkType, pKariwariateDRuigkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

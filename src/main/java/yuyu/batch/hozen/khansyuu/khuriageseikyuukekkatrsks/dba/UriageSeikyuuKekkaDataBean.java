package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;

/**
 * 契約保全 案内収納 売上結果データBeanクラス<br />
 */
public class UriageSeikyuuKekkaDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String creditkessaiyouno;

    @Getter
    @Setter
    private String recordno;

    @Getter
    @Setter
    private BizDate syoriymd;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDate uriagenengappi;

    @Getter
    @Setter
    private BizCurrency credituriagegk;

    @Getter
    @Setter
    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    @Getter
    @Setter
    private C_AuthoriKbn authorikbn;

    @Getter
    @Setter
    private Integer uriageseikyuukekkadatarenno3keta;

    @Getter
    @Setter
    private Integer uriageseikyuudatarenno3keta;

    @Getter
    @Setter
    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn;

    @Getter
    @Setter
    private BizDate credituriagekekkahaneiymd;

    public UriageSeikyuuKekkaDataBean(String pCreditkessaiyouNo,
        String pRecordNo,
        BizDate pSyoriYmd,
        String pSyono,
        BizDate pUriageNengappi,
        String pCredituriagegkType,
        BigDecimal pCredituriagegkValue,
        C_CreditUriageNgJiyuuKbn pCredituriageNgJiyuu,
        BizDateYM pJyuutouYm,
        C_AuthoriKbn pAuthorikbn,
        Integer pUriageseikyuuKekkaDataRenno3keta,
        Integer pUriageseikyuuDataRenno3keta,
        C_CreditUriageSeikyuuKbn pCreditUriageSeikyuuKbn,
        BizDate pCreditUriageKekkaHaneiYmd) {

        creditkessaiyouno = pCreditkessaiyouNo;
        recordno = pRecordNo;
        syoriymd = pSyoriYmd;
        syono = pSyono;
        uriagenengappi = pUriageNengappi;
        credituriagegk = new BizCurrencySum(pCredituriagegkType, pCredituriagegkValue).toBizCurrency();
        credituriagengjiyuu = pCredituriageNgJiyuu;
        jyuutouym = pJyuutouYm;
        authorikbn = pAuthorikbn;
        uriageseikyuukekkadatarenno3keta = pUriageseikyuuKekkaDataRenno3keta;
        uriageseikyuudatarenno3keta = pUriageseikyuuDataRenno3keta;
        credituriageseikyuukbn = pCreditUriageSeikyuuKbn;
        credituriagekekkahaneiymd = pCreditUriageKekkaHaneiYmd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

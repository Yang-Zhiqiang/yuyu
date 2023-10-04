package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks.dba;

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
 * 売上請求結果エラーリスト作成対象Beanクラスです。<br />
 */
public class UriageSeikyuuKekkaErrorListSksTaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String creditkessaiyouno;

    @Getter
    @Setter
    private BizDate uriagenengappi;

    @Getter
    @Setter
    private Integer renno3keta;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private BizCurrency credituriagegk;

    @Getter
    @Setter
    private String uriageseikyuuerrorcd;

    @Getter
    @Setter
    private C_CreditUriageNgJiyuuKbn credituriagengjiyuu;

    @Getter
    @Setter
    private C_AuthoriKbn authorikbn;

    @Getter
    @Setter
    private String kinouId;

    @Getter
    @Setter
    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn;

    public UriageSeikyuuKekkaErrorListSksTaisyouBean(String pSyono, String pCreditkessaiyouno,
        BizDate pUriagenengappi, Integer pRenno3keta, BizDateYM pJyuutouym, BizDate pSyoriYmd, String pTypefieldname,
        BigDecimal pValuefieldname, String pUriageseikyuuErrorcd, C_CreditUriageNgJiyuuKbn pCredituriagengjiyuu,
        C_AuthoriKbn pAuthorikbn, String pKinouId, C_CreditUriageSeikyuuKbn pCredituriageseikyuukbn) {
        syono = pSyono;
        creditkessaiyouno = pCreditkessaiyouno;
        uriagenengappi = pUriagenengappi;
        renno3keta = pRenno3keta;
        jyuutouym = pJyuutouym;
        syoriYmd = pSyoriYmd;
        credituriagegk = new BizCurrencySum(pTypefieldname, pValuefieldname).toBizCurrency();
        uriageseikyuuerrorcd = pUriageseikyuuErrorcd;
        credituriagengjiyuu = pCredituriagengjiyuu;
        authorikbn = pAuthorikbn;
        kinouId = pKinouId;
        credituriageseikyuukbn = pCredituriageseikyuukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

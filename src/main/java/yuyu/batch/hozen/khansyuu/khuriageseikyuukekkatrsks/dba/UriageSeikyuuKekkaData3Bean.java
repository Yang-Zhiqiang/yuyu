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
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * 契約保全 案内収納 売上結果データ3Beanクラス<br />
 */
public class UriageSeikyuuKekkaData3Bean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String creditkessaiyouno;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDate uriagenengappi;

    @Getter
    @Setter
    private Integer renno3keta;

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
    private BizDateYM jyuutouym;

    @Getter
    @Setter
    private C_AuthoriKbn authorikbn;

    @Getter
    @Setter
    private Integer jyutoukaisuum;

    @Getter
    @Setter
    private Integer jyutoukaisuuy;

    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter
    @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter
    @Setter
    private String gyoumukousinkinou;

    @Getter
    @Setter
    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn;

    @Getter
    @Setter
    private C_Nykkeiro nykkeiro;

    public UriageSeikyuuKekkaData3Bean(String pCreditkessaiyouNo,
        String pSyono,
        BizDate pUriageNengappi,
        Integer pRenno3keta,
        String pCredituriagegkType,
        BigDecimal pCredituriagegkValue,
        String pUriageseikyuuErrorCd,
        C_CreditUriageNgJiyuuKbn pCredituriageNgJiyuu,
        BizDateYM pJyuutouYm,
        C_AuthoriKbn pAuthorikbn,
        Integer pJyutouKaisuuy,
        Integer pJyutouKaisuum,
        C_NyknaiyouKbn pNyknaiyouKbn,
        C_Hrkkaisuu pHrkkaisuu,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruiKbn,
        String pGyoumuKousinKinou,
        C_CreditUriageSeikyuuKbn pCreditUriageSeikyuuKbn,
        C_Nykkeiro pNykkeiro) {

        creditkessaiyouno = pCreditkessaiyouNo;
        syono = pSyono;
        uriagenengappi = pUriageNengappi;
        renno3keta = pRenno3keta;
        credituriagegk = new BizCurrencySum(pCredituriagegkType, pCredituriagegkValue).toBizCurrency();
        uriageseikyuuerrorcd = pUriageseikyuuErrorCd;
        credituriagengjiyuu = pCredituriageNgJiyuu;
        jyuutouym = pJyuutouYm;
        authorikbn = pAuthorikbn;
        jyutoukaisuuy = pJyutouKaisuuy;
        jyutoukaisuum = pJyutouKaisuum;
        nyknaiyoukbn = pNyknaiyouKbn;
        hrkkaisuu = pHrkkaisuu;
        tikiktbrisyuruikbn = pTikiktbrisyuruiKbn;
        gyoumukousinkinou = pGyoumuKousinKinou;
        credituriageseikyuukbn = pCreditUriageSeikyuuKbn;
        nykkeiro = pNykkeiro;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

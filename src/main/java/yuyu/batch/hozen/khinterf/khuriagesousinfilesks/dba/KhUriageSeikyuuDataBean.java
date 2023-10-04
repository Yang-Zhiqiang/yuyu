package yuyu.batch.hozen.khinterf.khuriagesousinfilesks.dba;

import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;

/**
 * 契約保全 インターフェイス 売上送信Ｆ作成Beanクラス<br />
 */
public class KhUriageSeikyuuDataBean {

    @Getter
    @Setter
    private String kbnkey;

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
    private String recordno;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn;

    @Getter
    @Setter
    private C_AuthoriKbn authorikbn;

    @Getter
    @Setter
    private BizCurrency credituriagegk;

    @Getter
    @Setter
    private String fukusuukameitennokey;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    public KhUriageSeikyuuDataBean(String pKbnkey,
        String pSyono,
        String pCreditkessaiyouNo,
        BizDate pUriAgenengappi,
        String pRecordNo,
        BizDate pSyoriYmd,
        C_CreditUriageSeikyuuKbn pCredituriageseikyuuKbn,
        C_AuthoriKbn pAuthoriKbn,
        String pCredituriagegkType,
        BigDecimal pCredituriagegkValue,
        String pFukusuukameitennokey,
        BizDateYM pJyuutouYm
        ){
        kbnkey = pKbnkey;
        syono = pSyono;
        creditkessaiyouno = pCreditkessaiyouNo;
        uriagenengappi = pUriAgenengappi;
        recordno = pRecordNo;
        syoriYmd = pSyoriYmd;
        credituriageseikyuukbn = pCredituriageseikyuuKbn;
        authorikbn = pAuthoriKbn;
        credituriagegk = new BizCurrencySum(pCredituriagegkType, pCredituriagegkValue).toBizCurrency();
        fukusuukameitennokey = pFukusuukameitennokey;
        jyuutouym = pJyuutouYm;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

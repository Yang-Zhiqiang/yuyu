package yuyu.batch.hozen.khinterf.khcredithnkntuutifilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 インターフェイス クレカ返金通知データBean
 */
public class KhCredithnknTuutiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate tyouhyouymd;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private C_HassouKbn hassoukbn;

    @Getter @Setter
    private String shskyno;

    @Getter @Setter
    private String shsadr1kj;

    @Getter @Setter
    private String shsadr2kj;

    @Getter @Setter
    private String shsadr3kj;

    @Getter @Setter
    private String shsnmkj;

    @Getter @Setter
    private String toiawasesosikinmkj;

    @Getter @Setter
    private String toiawaseyno;

    @Getter @Setter
    private String toiawaseadr1kj;

    @Getter @Setter
    private String toiawaseadr2kj;

    @Getter @Setter
    private String toiawaseadr3kj;

    @Getter @Setter
    private String toiawasetelno;

    @Getter @Setter
    private String toiawaseteluktkkanou1;

    @Getter @Setter
    private String toiawaseteluktkkanou2;

    @Getter @Setter
    private String toiawasesosikinmkj2;

    @Getter @Setter
    private String toiawasetelno2;

    @Getter @Setter
    private C_ShrriyuuKbn shrriyuukbn;

    @Getter @Setter
    private BizDate uriageseikyuuymd;

    @Getter @Setter
    private BizCurrency hnkngk;

    @Getter @Setter
    private C_KrkriyuuKbn krkriyuukbn;

    @Getter @Setter
    private BizDate uriageymd;

    @Getter @Setter
    private BizCurrency uriagegk;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private Integer jyutoukaisuum;

    @Getter @Setter
    private C_UmuKbn hnkntaisyouinjiflg;

    @Getter @Setter
    private String kbnkey;

    public KhCredithnknTuutiDataBean(String pSyono,
        BizDate pTyouhyouymd,
        String pHenkousikibetukey,
        C_HassouKbn pHassoukbn,
        String pShskyno,
        String pShsadr1kj,
        String pShsadr2kj,
        String pShsadr3kj,
        String pShsnmkj,
        String pToiawasesosikinmkj,
        String pToiawaseyno,
        String pToiawaseadr1kj,
        String pToiawaseadr2kj,
        String pToiawaseadr3kj,
        String pToiawasetelno,
        String pToiawaseteluktkkanou1,
        String pToiawaseteluktkkanou2,
        String pToiawasesosikinmkj2,
        String pToiawasetelno2,
        C_ShrriyuuKbn pShrriyuukbn,
        BizDate pUriageseikyuuymd,
        String pHnkngkType,
        BigDecimal pHnkngkValue,
        C_KrkriyuuKbn pKrkriyuukbn,
        BizDate pUriageymd,
        String pUriagegkType,
        BigDecimal pUriagegkValue,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuum,
        C_UmuKbn pHnkntaisyouinjiflg,
        String pHbnkey) {

        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
        henkousikibetukey = pHenkousikibetukey;
        hassoukbn = pHassoukbn;
        shskyno = pShskyno;
        shsadr1kj = pShsadr1kj;
        shsadr2kj = pShsadr2kj;
        shsadr3kj = pShsadr3kj;
        shsnmkj = pShsnmkj;
        toiawasesosikinmkj = pToiawasesosikinmkj;
        toiawaseyno = pToiawaseyno;
        toiawaseadr1kj = pToiawaseadr1kj;
        toiawaseadr2kj = pToiawaseadr2kj;
        toiawaseadr3kj = pToiawaseadr3kj;
        toiawasetelno = pToiawasetelno;
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
        toiawasesosikinmkj2 = pToiawasesosikinmkj2;
        toiawasetelno2 = pToiawasetelno2;
        shrriyuukbn = pShrriyuukbn;
        uriageseikyuuymd = pUriageseikyuuymd;
        hnkngk = new BizCurrencySum(pHnkngkType, pHnkngkValue).toBizCurrency();
        krkriyuukbn = pKrkriyuukbn;
        uriageymd = pUriageymd;
        uriagegk = new BizCurrencySum(pUriagegkType, pUriagegkValue).toBizCurrency();
        jyuutouym = pJyuutouym;
        jyutoukaisuum = pJyutoukaisuum;
        hnkntaisyouinjiflg = pHnkntaisyouinjiflg;
        kbnkey = pHbnkey;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}

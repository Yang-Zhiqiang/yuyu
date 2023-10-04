package yuyu.batch.hozen.khinterf.khkzhnkntuutifilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 インターフェイス 口座返金通知データBeanクラス
 */
public class KhKzhnknTuutiDataBean implements Serializable {

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
    private BizDate hurikomiymd;

    @Getter @Setter
    private BizCurrency shrgk;

    @Getter @Setter
    private C_KrkriyuuKbn krkriyuukbn;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private C_YokinKbn yokinkbn;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private String kzmeiginmkn;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private Integer jyutoukaisuuy;

    @Getter @Setter
    private Integer jyutoukaisuum;

    @Getter @Setter
    private String kbnkey;

    public KhKzhnknTuutiDataBean(String pSyono,
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
        BizDate pHurikomiymd,
        String pShrgkType,
        BigDecimal pShrgkValue,
        C_KrkriyuuKbn pKrkriyuukbn,
        String pBankcd,
        String pSitencd,
        C_YokinKbn pYokinkbn,
        String pKouzano,
        String pKzmeiginmkn,
        BizDate pKykYmd,
        String pRsgakuType,
        BigDecimal pRsgakuValue,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        String pKbnkey) {
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
        hurikomiymd = pHurikomiymd;
        shrgk = new BizCurrencySum(pShrgkType, pShrgkValue).toBizCurrency();
        krkriyuukbn = pKrkriyuukbn;
        bankcd = pBankcd;
        sitencd = pSitencd;
        yokinkbn = pYokinkbn;
        kouzano = pKouzano;
        kzmeiginmkn = pKzmeiginmkn;
        ryosyuymd = pKykYmd;
        rsgaku = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        kbnkey = pKbnkey;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

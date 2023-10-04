package yuyu.batch.hozen.khinterf.khtyouhyoukoujyosyoumei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SaihkHyjKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import lombok.Getter;
import lombok.Setter;

/**
 * 控除証明書テーブルデータBeanクラス<br />
 */
public class KoujyoSymDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String nendo;

    @Getter
    @Setter
    private BizDate tyouhyouymd;

    @Getter
    @Setter
    private Integer renno;

    @Getter
    @Setter
    private C_KoujyosyoumeisakuseisyoriKbn kjsmsakuseisyorikbn;

    @Getter
    @Setter
    private C_TekiyouseidoKbn tekiyouseidokbn;

    @Getter
    @Setter
    private String syoumeiymd;

    @Getter
    @Setter
    private BizDateYM syoumeistartym;

    @Getter
    @Setter
    private BizDateYM syoumeiendym;

    @Getter
    @Setter
    private Integer syoumeikkntukisuu;

    @Getter
    @Setter
    private Integer syoumeikknnensuu;

    @Getter
    @Setter
    private String kyknmkj;

    @Getter
    @Setter
    private String uktnmkjaddsama;

    @Getter
    @Setter
    private BizDate nenkinuktseiymd;

    @Getter
    @Setter
    private String hknsyuruinmrykkj;

    @Getter
    @Setter
    private BizDate kykymd;

    @Getter
    @Setter
    private C_HknkknsmnKbn hknkknsmnkbnsyu;

    @Getter
    @Setter
    private BizNumber hknkknsyu;

    @Getter
    @Setter
    private Integer nenkanhrkkaisuu;

    @Getter
    @Setter
    private Integer phrkkkn;

    @Getter
    @Setter
    private BizDate nkshrstartymd;

    @Getter
    @Setter
    private String nknshry;

    @Getter
    @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter
    @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Getter
    @Setter
    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Getter
    @Setter
    private BizCurrency oldippanjissekip;

    @Getter
    @Setter
    private BizCurrency oldippannenkanp;

    @Getter
    @Setter
    private BizCurrency oldippanjissekihaitoukin;

    @Getter
    @Setter
    private BizCurrency oldippannenkanhaitoukin;

    @Getter
    @Setter
    private BizCurrency oldippanjissekisyoumeigk;

    @Getter
    @Setter
    private BizCurrency oldippannenkansyoumeigk;

    @Getter
    @Setter
    private BizCurrency newippanjissekip;

    @Getter
    @Setter
    private BizCurrency newippannenkanp;

    @Getter
    @Setter
    private BizCurrency newippanjissekihaitoukin;

    @Getter
    @Setter
    private BizCurrency newippannenkanhaitoukin;

    @Getter
    @Setter
    private BizCurrency newippanjissekisyoumeigk;

    @Getter
    @Setter
    private BizCurrency newippannenkansyoumeigk;

    @Getter
    @Setter
    private BizCurrency newiryoujissekip;

    @Getter
    @Setter
    private BizCurrency newiryounenkanp;

    @Getter
    @Setter
    private BizCurrency newiryoujissekihaitoukin;

    @Getter
    @Setter
    private BizCurrency newiryounenkanhaitoukin;

    @Getter
    @Setter
    private BizCurrency newiryoujissekisyoumeigk;

    @Getter
    @Setter
    private BizCurrency newiryounenkansyoumeigk;

    @Getter
    @Setter
    private BizCurrency newnkjissekip;

    @Getter
    @Setter
    private BizCurrency newnknenkanp;

    @Getter
    @Setter
    private BizCurrency newnkjissekihaitoukin;

    @Getter
    @Setter
    private BizCurrency newnknenkanhaitoukin;

    @Getter
    @Setter
    private BizCurrency newnkjissekisyoumeigk;

    @Getter
    @Setter
    private BizCurrency newnknenkansyoumeigk;

    @Getter
    @Setter
    private C_UmuKbn kjnnkkoujyum;

    @Getter
    @Setter
    private String tsinyno;

    @Getter
    @Setter
    private String tsinadr1kj;

    @Getter
    @Setter
    private String tsinadr2kj;

    @Getter
    @Setter
    private String tsinadr3kj;

    @Getter
    @Setter
    private String toiawasesosikinmkj;

    @Getter
    @Setter
    private String toiawaseyno;

    @Getter
    @Setter
    private String toiawaseadr1kj;

    @Getter
    @Setter
    private String toiawaseadr2kj;

    @Getter
    @Setter
    private String toiawaseadr3kj;

    @Getter
    @Setter
    private String toiawasetelno;

    @Getter
    @Setter
    private String toiawaseteluktkkanou1;

    @Getter
    @Setter
    private String toiawaseteluktkkanou2;

    @Getter
    @Setter
    private String toiawasesosikinmkj2;

    @Getter
    @Setter
    private String toiawasetelno2;

    @Getter
    @Setter
    private C_HassouKbn hassoukbn;

    @Getter
    @Setter
    private String drtencd;

    @Getter
    @Setter
    private String drtennmkj;

    @Getter
    @Setter
    private C_UmuKbn hengakuumu;

    @Getter
    @Setter
    private C_UmuKbn newsyoumeigkumukbn;

    @Getter
    @Setter
    private String gyoumuKousinKinou;

    @Getter
    @Setter
    private String gyoumuKousinsyaId;

    @Getter
    @Setter
    private String gyoumuKousinTime;

    @Getter
    @Setter
    private C_KoujyosyoumeisentakuKbn koujyosyoumeisentakukbn;

    @Getter
    @Setter
    private String kyknmkn;

    @Getter
    @Setter
    private String uktnmkn;

    @Getter
    @Setter
    private C_SaihkHyjKbn saihkhyjkbn;

    @Getter
    @Setter
    private C_KoujyosyoumeimsgKbn koujyosyoumeimsgkbn;

    public KoujyoSymDataBean(
        String pKbnkey,
        String pSyono,
        String pNendo,
        BizDate pTyouhyouymd,
        Integer pRenno,
        C_KoujyosyoumeisakuseisyoriKbn pKjsmsakuseisyorikbn,
        C_TekiyouseidoKbn pTekiyouseidokbn,
        String pSyoumeiymd,
        BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym,
        Integer pSyoumeikkntukisuu,
        Integer pSyoumeikknnensuu,
        String pKyknmkj,
        String pUktnmkjaddsama,
        BizDate pNenkinuktseiymd,
        String pHknsyuruinmrykkj,
        BizDate pKykymd,
        C_HknkknsmnKbn pHknkknsmnkbnsyu,
        BizNumber pHknkknsyu,
        Integer pNenkanhrkkaisuu,
        Integer pPhrkkkn,
        BizDate pNkshrstartymd,
        String pNknshry,
        C_Kykjyoutai pKykjyoutai,
        C_YuukousyoumetuKbn pYuukousyoumetukbn,
        C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn,
        String pOldippanjissekipType,
        BigDecimal pOldippanjissekipValue,
        String pOldippannenkanpType,
        BigDecimal pOldippannenkanpValue,
        String pOldippanjissekihaitoukinType,
        BigDecimal pOldippanjissekihaitoukinValue,
        String pOldippannenkanhaitoukinType,
        BigDecimal pOldippannenkanhaitoukinValue,
        String pOldippanjissekisyoumeigkType,
        BigDecimal pOldippanjissekisyoumeigkValue,
        String pOldippannenkansyoumeigkType,
        BigDecimal pOldippannenkansyoumeigkValue,
        String pNewippanjissekipType,
        BigDecimal pNewippanjissekipValue,
        String pNewippannenkanpType,
        BigDecimal pNewippannenkanpValue,
        String pNewippanjissekihaitoukinType,
        BigDecimal pNewippanjissekihaitoukinValue,
        String pNewippannenkanhaitoukinType,
        BigDecimal pNewippannenkanhaitoukinValue,
        String pNewippanjissekisyoumeigkType,
        BigDecimal pNewippanjissekisyoumeigkValue,
        String pNewippannenkansyoumeigkType,
        BigDecimal pNewippannenkansyoumeigkValue,
        String pNewiryoujissekipType,
        BigDecimal pNewiryoujissekipValue,
        String pNewiryounenkanpType,
        BigDecimal pNewiryounenkanpValue,
        String pNewiryoujissekihaitoukinType,
        BigDecimal pNewiryoujissekihaitoukinValue,
        String pNewiryounenkanhaitoukinType,
        BigDecimal pNewiryounenkanhaitoukinValue,
        String pNewiryoujissekisyoumeigkType,
        BigDecimal pNewiryoujissekisyoumeigkValue,
        String pNewiryounenkansyoumeigkType,
        BigDecimal pNewiryounenkansyoumeigkValue,
        String pNewnkjissekipType,
        BigDecimal pNewnkjissekipValue,
        String pNewnknenkanpType,
        BigDecimal pNewnknenkanpValue,
        String pNewnkjissekihaitoukinType,
        BigDecimal pNewnkjissekihaitoukinValue,
        String pNewnknenkanhaitoukinType,
        BigDecimal pNewnknenkanhaitoukinValue,
        String pNewnkjissekisyoumeigkType,
        BigDecimal pNewnkjissekisyoumeigkValue,
        String pNewnknenkansyoumeigkType,
        BigDecimal pNewnknenkansyoumeigkValue,
        C_UmuKbn pKjnnkkoujyum,
        String pTsinyno,
        String pTsinadr1kj,
        String pTsinadr2kj,
        String pTsinadr3kj,
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
        C_HassouKbn pHassoukbn,
        String pDrtencd,
        String pDrtennmkj,
        C_UmuKbn pHengakuumu,
        C_UmuKbn pNewsyoumeigkumukbn,
        String pGyoumuKousinKinou,
        String pGyoumuKousinsyaId,
        String pGyoumuKousinTime,
        C_KoujyosyoumeisentakuKbn pKoujyosyoumeisentakukbn,
        String pKyknmkn,
        String pUktnmkn,
        C_SaihkHyjKbn pSaihkhyjkbn,
        C_KoujyosyoumeimsgKbn pKoujyosyoumeimsgkbn) {
        kbnkey = pKbnkey;
        syono = pSyono;
        nendo = pNendo;
        tyouhyouymd = pTyouhyouymd;
        renno = pRenno;
        kjsmsakuseisyorikbn = pKjsmsakuseisyorikbn;
        tekiyouseidokbn = pTekiyouseidokbn;
        syoumeiymd = pSyoumeiymd;
        syoumeistartym = pSyoumeistartym;
        syoumeiendym = pSyoumeiendym;
        syoumeikkntukisuu = pSyoumeikkntukisuu;
        syoumeikknnensuu = pSyoumeikknnensuu;
        kyknmkj = pKyknmkj;
        uktnmkjaddsama = pUktnmkjaddsama;
        nenkinuktseiymd = pNenkinuktseiymd;
        hknsyuruinmrykkj = pHknsyuruinmrykkj;
        kykymd = pKykymd;
        hknkknsmnkbnsyu = pHknkknsmnkbnsyu;
        hknkknsyu = pHknkknsyu;
        nenkanhrkkaisuu = pNenkanhrkkaisuu;
        phrkkkn = pPhrkkkn;
        nkshrstartymd = pNkshrstartymd;
        nknshry = pNknshry;
        kykjyoutai = pKykjyoutai;
        yuukousyoumetukbn = pYuukousyoumetukbn;
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
        oldippanjissekip = new BizCurrencySum(pOldippanjissekipType, pOldippanjissekipValue).toBizCurrency();
        oldippannenkanp = new BizCurrencySum(pOldippannenkanpType, pOldippannenkanpValue).toBizCurrency();
        oldippanjissekihaitoukin = new BizCurrencySum(pOldippanjissekihaitoukinType, pOldippanjissekihaitoukinValue).toBizCurrency();
        oldippannenkanhaitoukin = new BizCurrencySum(pOldippannenkanhaitoukinType, pOldippannenkanhaitoukinValue).toBizCurrency();
        oldippanjissekisyoumeigk = new BizCurrencySum(pOldippanjissekisyoumeigkType, pOldippanjissekisyoumeigkValue).toBizCurrency();
        oldippannenkansyoumeigk = new BizCurrencySum(pOldippannenkansyoumeigkType, pOldippannenkansyoumeigkValue).toBizCurrency();
        newippanjissekip = new BizCurrencySum(pNewippanjissekipType, pNewippanjissekipValue).toBizCurrency();
        newippannenkanp = new BizCurrencySum(pNewippannenkanpType, pNewippannenkanpValue).toBizCurrency();
        newippanjissekihaitoukin = new BizCurrencySum(pNewippanjissekihaitoukinType, pNewippanjissekihaitoukinValue).toBizCurrency();
        newippannenkanhaitoukin = new BizCurrencySum(pNewippannenkanhaitoukinType, pNewippannenkanhaitoukinValue).toBizCurrency();
        newippanjissekisyoumeigk = new BizCurrencySum(pNewippanjissekisyoumeigkType, pNewippanjissekisyoumeigkValue).toBizCurrency();
        newippannenkansyoumeigk = new BizCurrencySum(pNewippannenkansyoumeigkType, pNewippannenkansyoumeigkValue).toBizCurrency();
        newiryoujissekip = new BizCurrencySum(pNewiryoujissekipType, pNewiryoujissekipValue).toBizCurrency();
        newiryounenkanp = new BizCurrencySum(pNewiryounenkanpType, pNewiryounenkanpValue).toBizCurrency();
        newiryoujissekihaitoukin = new BizCurrencySum(pNewiryoujissekihaitoukinType, pNewiryoujissekihaitoukinValue).toBizCurrency();
        newiryounenkanhaitoukin = new BizCurrencySum(pNewiryounenkanhaitoukinType, pNewiryounenkanhaitoukinValue).toBizCurrency();
        newiryoujissekisyoumeigk = new BizCurrencySum(pNewiryoujissekisyoumeigkType, pNewiryoujissekisyoumeigkValue).toBizCurrency();
        newiryounenkansyoumeigk = new BizCurrencySum(pNewiryounenkansyoumeigkType, pNewiryounenkansyoumeigkValue).toBizCurrency();
        newnkjissekip = new BizCurrencySum(pNewnkjissekipType, pNewnkjissekipValue).toBizCurrency();
        newnknenkanp = new BizCurrencySum(pNewnknenkanpType, pNewnknenkanpValue).toBizCurrency();
        newnkjissekihaitoukin = new BizCurrencySum(pNewnkjissekihaitoukinType, pNewnkjissekihaitoukinValue).toBizCurrency();
        newnknenkanhaitoukin = new BizCurrencySum(pNewnknenkanhaitoukinType, pNewnknenkanhaitoukinValue).toBizCurrency();
        newnkjissekisyoumeigk = new BizCurrencySum(pNewnkjissekisyoumeigkType, pNewnkjissekisyoumeigkValue).toBizCurrency();
        newnknenkansyoumeigk = new BizCurrencySum(pNewnknenkansyoumeigkType, pNewnknenkansyoumeigkValue).toBizCurrency();
        kjnnkkoujyum = pKjnnkkoujyum;
        tsinyno = pTsinyno;
        tsinadr1kj = pTsinadr1kj;
        tsinadr2kj = pTsinadr2kj;
        tsinadr3kj = pTsinadr3kj;
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
        hassoukbn = pHassoukbn;
        drtencd = pDrtencd;
        drtennmkj = pDrtennmkj;
        hengakuumu = pHengakuumu;
        newsyoumeigkumukbn = pNewsyoumeigkumukbn;
        gyoumuKousinKinou = pGyoumuKousinKinou;
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
        gyoumuKousinTime = pGyoumuKousinTime;
        koujyosyoumeisentakukbn = pKoujyosyoumeisentakukbn;
        kyknmkn = pKyknmkn;
        uktnmkn = pUktnmkn;
        saihkhyjkbn = pSaihkhyjkbn;
        koujyosyoumeimsgkbn = pKoujyosyoumeimsgkbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

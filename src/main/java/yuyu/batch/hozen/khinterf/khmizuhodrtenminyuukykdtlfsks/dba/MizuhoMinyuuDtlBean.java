package yuyu.batch.hozen.khinterf.khmizuhodrtenminyuukykdtlfsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 契約保全 インターフェイス みずほ用未入明細Beanクラス<br />
 */
public class MizuhoMinyuuDtlBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private BizDate keiyakuymd;

    @Getter
    @Setter
    private String bankcd;

    @Getter
    @Setter
    private String sitencd;

    @Getter
    @Setter
    private String kouzano;

    @Getter
    @Setter
    private String kzmeiginmkn;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter
    @Setter
    private String drtencd;

    @Getter
    @Setter
    private String kyknm35keta;

    @Getter
    @Setter
    private String hhknnmkj;

    @Getter
    @Setter
    private String kykjyutikbn;

    @Getter
    @Setter
    private String tsinkihontikucd;

    @Getter
    @Setter
    private String kanjitsinkaiadr;

    @Getter
    @Setter
    private String tsintelno;

    @Getter
    @Setter
    private String dai2tsintelno;

    @Getter
    @Setter
    private C_YokinKbn yokinkbn;

    @Getter
    @Setter
    private BizCurrency hrkp;

    @Getter
    @Setter
    private BizCurrency jkiannaikg;

    @Getter
    @Setter
    private BizDate yykknmnryymd;

    @Getter
    @Setter
    private BizDate skymd;

    @Getter
    @Setter
    private String jhurikstkkahikbn;

    @Getter
    @Setter
    private String hukkatumoskahikbn;

    @Getter
    @Setter
    private BizDate ttdkkigenymd;

    @Getter
    @Setter
    private BizDate hukkatukanoukknmnryymd;

    @Getter
    @Setter
    private Integer keikamon3keta;

    @Getter
    @Setter
    private BizDateYM misyuuhasseiym;

    @Getter
    @Setter
    private String misyuujiyuu;

    @Getter
    @Setter
    private BizDate minyusyoriymd;

    @Getter
    @Setter
    private BizDate nexthurikaeymd;

    @Getter
    @Setter
    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Getter
    @Setter
    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    public MizuhoMinyuuDtlBean(
        String pKbnkey,
        String pSyono,
        BizDate pKeiyakuymd,
        String pBankcd,
        String pSitencd,
        String pKouzano,
        String pKzmeiginmkn,
        C_Hrkkaisuu pHrkkaisuu,
        String pDrtencd,
        String pKyknm35keta,
        String pHhknnmkj,
        String pKykjyutikbn,
        String pTsinkihontikucd,
        String pKanjitsinkaiadr,
        String pTsintelno,
        String pDai2tsintelno,
        C_YokinKbn pYokinkbn,
        String pHrkpType,
        BigDecimal pHrkpValue,
        String pJkiannaikgType,
        BigDecimal pJkiannaikgValue,
        BizDate pYykknmnryymd,
        BizDate pSkymd,
        String pJhurikstkkahikbn,
        String pHukkatumoskahikbn,
        BizDate pTtdkkigenymd,
        BizDate pHukkatukanoukknmnryymd,
        Integer pKeikamon3keta,
        BizDateYM pMisyuuhasseiym,
        String pMisyuujiyuu,
        BizDate pMinyusyoriymd,
        BizDate pNexthurikaeymd,
        C_IkkatubaraiKbn pIkkatubaraikbn,
        C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {

        kbnkey = pKbnkey;
        syono = pSyono;
        keiyakuymd = pKeiyakuymd;
        bankcd = pBankcd;
        sitencd = pSitencd;
        kouzano = pKouzano;
        kzmeiginmkn = pKzmeiginmkn;
        hrkkaisuu = pHrkkaisuu;
        drtencd = pDrtencd;
        kyknm35keta = pKyknm35keta;
        hhknnmkj = pHhknnmkj;
        kykjyutikbn = pKykjyutikbn;
        tsinkihontikucd = pTsinkihontikucd;
        kanjitsinkaiadr = pKanjitsinkaiadr;
        tsintelno = pTsintelno;
        dai2tsintelno = pDai2tsintelno;
        yokinkbn = pYokinkbn;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        jkiannaikg = new BizCurrencySum(pJkiannaikgType, pJkiannaikgValue).toBizCurrency();
        yykknmnryymd = pYykknmnryymd;
        skymd = pSkymd;
        jhurikstkkahikbn = pJhurikstkkahikbn;
        hukkatumoskahikbn = pHukkatumoskahikbn;
        ttdkkigenymd = pTtdkkigenymd;
        hukkatukanoukknmnryymd = pHukkatukanoukknmnryymd;
        keikamon3keta = pKeikamon3keta;
        misyuuhasseiym = pMisyuuhasseiym;
        misyuujiyuu = pMisyuujiyuu;
        minyusyoriymd = pMinyusyoriymd;
        nexthurikaeymd = pNexthurikaeymd;
        ikkatubaraikbn = pIkkatubaraikbn;
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

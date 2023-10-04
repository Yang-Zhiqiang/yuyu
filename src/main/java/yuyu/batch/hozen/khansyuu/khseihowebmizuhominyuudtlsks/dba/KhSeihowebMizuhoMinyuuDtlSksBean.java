package yuyu.batch.hozen.khansyuu.khseihowebmizuhominyuudtlsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 生保Ｗｅｂ・みずほ用未入明細を保持するBeanクラス <br />
 */
public class KhSeihowebMizuhoMinyuuDtlSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private BizDate minyusyoriymd;

    @Getter @Setter
    private BizDateYM bosyuuym;

    @Getter @Setter
    private String kydatkikbnkj;

    @Getter @Setter
    private String kyknm35keta;

    @Getter @Setter
    private String cifcd;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private BizDate keiyakuymd;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private String tsintelno;

    @Getter @Setter
    private String dai2tsintelno;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private C_YokinKbn yokinkbn;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter @Setter
    private String tsinkihontikucd;

    @Getter @Setter
    private String kanjitsinkaiadr;

    @Getter @Setter
    private String kzmeiginmkn;

    @Getter @Setter
    private BizCurrency jkiannaikg;

    @Getter @Setter
    private BizDate yykknmnryymd;

    @Getter @Setter
    private C_HurihunoKbn hurihunokbn;

    @Getter @Setter
    private BizDate nexthurikaeymd;

    @Getter @Setter
    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Getter @Setter
    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Getter @Setter
    private String dairitencd1;

    @Getter @Setter
    private String bosyuucd1;

    @Getter @Setter
    private String drtenkanrisosikicd1;

    @Getter @Setter
    private C_DrtenChannelSyurui drtenchannelsyuruikbn1;

    @Getter @Setter
    private String dairitencd2;

    @Getter @Setter
    private String bosyuucd2;

    @Getter @Setter
    private String drtenkanrisosikicd2;

    @Getter @Setter
    private C_DrtenChannelSyurui drtenchannelsyuruikbn2;

    public KhSeihowebMizuhoMinyuuDtlSksBean(String pKbnkey,
        String pSyono,
        BizDate pMinyusyoriymd,
        BizDateYM pBosyuuym,
        String pKydatkikbnkj,
        String pKyknm35keta,
        String pCifcd,
        BizDateYM pJyuutouym,
        String pHrkpType,
        BigDecimal pHrkpValue,
        BizDate pKeiyakuymd,
        String pHhknnmkj,
        String pTsintelno,
        String pDai2tsintelno,
        String pBankcd,
        String pSitencd,
        C_YokinKbn pYokinkbn,
        String pKouzano,
        C_Hrkkaisuu pHrkkaisuu,
        C_Hrkkeiro pHrkkeiro,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        String pTsinkihontikucd,
        String pKanjitsinkaiadr,
        String pKzmeiginmkn,
        String pJkiannaikgType,
        BigDecimal pJkiannaikgValue,
        BizDate pYykknmnryymd,
        C_HurihunoKbn pHurihunokbn,
        BizDate pNexthurikaeymd,
        C_IkkatubaraiKbn pIkkatubaraikbn,
        C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu,
        String pDairitencd1,
        String pBosyuucd1,
        String pDrtenkanrisosikicd1,
        C_DrtenChannelSyurui pDrtenchannelsyuruikbn1,
        String pDairitencd2,
        String pBosyuucd2,
        String pDrtenkanrisosikicd2,
        C_DrtenChannelSyurui pDrtenchannelsyuruikbn2) {

        kbnkey = pKbnkey;
        syono = pSyono;
        minyusyoriymd = pMinyusyoriymd;
        bosyuuym = pBosyuuym;
        kydatkikbnkj = pKydatkikbnkj;
        kyknm35keta = pKyknm35keta;
        cifcd = pCifcd;
        jyuutouym = pJyuutouym;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        keiyakuymd = pKeiyakuymd;
        hhknnmkj = pHhknnmkj;
        tsintelno = pTsintelno;
        dai2tsintelno = pDai2tsintelno;
        bankcd = pBankcd;
        sitencd = pSitencd;
        yokinkbn = pYokinkbn;
        kouzano = pKouzano;
        hrkkaisuu = pHrkkaisuu;
        hrkkeiro = pHrkkeiro;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        tsinkihontikucd = pTsinkihontikucd;
        kanjitsinkaiadr = pKanjitsinkaiadr;
        kzmeiginmkn = pKzmeiginmkn;
        jkiannaikg = new BizCurrencySum(pJkiannaikgType, pJkiannaikgValue).toBizCurrency();
        yykknmnryymd = pYykknmnryymd;
        hurihunokbn = pHurihunokbn;
        nexthurikaeymd = pNexthurikaeymd;
        ikkatubaraikbn = pIkkatubaraikbn;
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
        dairitencd1 = pDairitencd1;
        bosyuucd1 = pBosyuucd1;
        drtenkanrisosikicd1 = pDrtenkanrisosikicd1;
        drtenchannelsyuruikbn1 = pDrtenchannelsyuruikbn1;
        dairitencd2 = pDairitencd2;
        bosyuucd2 = pBosyuucd2;
        drtenkanrisosikicd2 = pDrtenkanrisosikicd2;
        drtenchannelsyuruikbn2 = pDrtenchannelsyuruikbn2;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}

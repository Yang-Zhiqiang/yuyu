package yuyu.batch.hozen.khozen.khmkhgktttyendthnk.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktkSyoriKbn;

/**
 * 契約保全 契約保全 円建変更対象Beanクラス
 */
public class KhMkhgkTttYendtHnkBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate kouryokuhasseiymd;

    @Getter @Setter
    private Integer hozenhenkouuktkrenno;

    @Getter @Setter
    private C_TourokuRouteKbn tourokuroutekbn;

    @Getter @Setter
    private C_UktkSyoriKbn uktkSyoriKbn;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer dai1hknkkn;

    @Getter @Setter
    private C_TargetTkKbn targettkkbn;

    @Getter @Setter
    private Integer targettkmokuhyouti;

    @Getter @Setter
    private BizCurrency targettkykkijyungk;

    @Getter @Setter
    private String newsyouhncd;

    @Getter @Setter
    private Integer newsyouhnsdno;

    @Getter @Setter
    private BizDate yendthnkymd;

    @Getter @Setter
    private BizCurrency newkihons;

    @Getter @Setter
    private BizCurrency newhokenryou;

    @Getter @Setter
    private C_Tuukasyu newkyktuukasyu;

    @Getter @Setter
    private String newryouritusdno;

    @Getter @Setter
    private BizCurrency newkaiyakuhr;

    @Getter @Setter
    private BizCurrency yendthnkhr;

    @Getter @Setter
    private BizCurrency yendthnkkaiyakuhrgaika;

    @Getter @Setter
    private BizCurrency yendthnkkaiyakuhryen;

    @Getter @Setter
    private C_HassouKbn nyuuryokuhassoukbn;

    @Getter @Setter
    private C_HnskariyuuKbn hnskariyuu1;

    @Getter @Setter
    private C_HnskariyuuKbn hnskariyuu2;

    @Getter @Setter
    private BizDate mkhgktttymd;

    @Getter @Setter
    private BizCurrency mkhgktttkaiyakuhr;

    @Getter @Setter
    private BizNumber yendthnkjikwsrate;

    @Getter @Setter
    private BizDate syoruiukeymd;

    @Getter @Setter
    private BizNumber newtumitateriritu;

    @Getter @Setter
    private BizNumber newyoteiriritu;

    @Getter @Setter
    private C_Tdk  kkkyktdk;

    @Getter @Setter
    private String  kyknmkn;

    @Getter @Setter
    private String  kyknmkj;

    @Getter @Setter
    private String  tsinyno;

    @Getter @Setter
    private String  tsinadr1kj;

    @Getter @Setter
    private String  tsinadr2kj;

    @Getter @Setter
    private String  tsinadr3kj;

    @Getter @Setter
    private C_MousideIkouKbn mousideikoukbn;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private BizDateY haitounendo;

    public KhMkhgkTttYendtHnkBean(String pKbnkey,
        String pSyono,
        BizDate pKouryokuHasseiYmd,
        Integer pHozenHenkouUktkRenno,
        C_TourokuRouteKbn pTourokuroutekbn,
        C_UktkSyoriKbn pUktkSyoriKbn,
        C_Tuukasyu pKykTuukaSyu,
        BizDate pKykymd,
        String pSyouhncd,
        Integer pDai1HknKkn,
        C_TargetTkKbn pTargetTkKbn,
        Integer pTargetTkMokuhyouti,
        String pTargetTkykKijyunGkType,
        BigDecimal pTargetTkykKijyunGk,
        String pNewSyouhnCd,
        Integer pNewSyouhnSdNo,
        BizDate pYendtHnkYmd,
        String pNewkihonsType,
        BigDecimal pNewkihons,
        String pNewHokenRyouType,
        BigDecimal pNewHokenRyou,
        C_Tuukasyu pNewKykTuukaSyu,
        String pNewRyouRituSdNo,
        String pNewKaiyakuHrType,
        BigDecimal pNewKaiyakuHr,
        String pYendtHnkHrType,
        BigDecimal pYendtHnkHr,
        String pYendtHnkKaiyakuHrGaikaType,
        BigDecimal pYendtHnkKaiyakuHrGaika,
        String pYendtHnkKaiyakuHrYenType,
        BigDecimal pYendtHnkKaiyakuHrYen,
        C_HassouKbn pNyuuryokuHassouKbn,
        C_HnskariyuuKbn pHnskaRiyuu1,
        C_HnskariyuuKbn pHnskaRiyuu2,
        BizDate pMkhGkTttYmd,
        String pMkhGkTttKaiyakuHrType,
        BigDecimal pMkhGkTttKaiyakuHr,
        BizNumber pYendtHnkjiKwsRate,
        BizDate pSyoruiukeymd,
        BizNumber pNewtumitateriritu,
        BizNumber pNewyoteiriritu,
        C_Tdk pKkkyktdk,
        String pKykNmKn,
        String pKykNmKj,
        String pTsinYNo,
        String pTsinAdr1Kj,
        String pTsinAdr2Kj,
        String pTsinAdr3Kj,
        C_MousideIkouKbn pMousideikoukbn,
        String pHrkpType,
        BigDecimal pHrkp,
        BizDateY pHaitounendo) {

        kbnkey = pKbnkey;
        syono = pSyono;
        kouryokuhasseiymd = pKouryokuHasseiYmd;
        hozenhenkouuktkrenno = pHozenHenkouUktkRenno;
        tourokuroutekbn = pTourokuroutekbn;
        uktkSyoriKbn = pUktkSyoriKbn;
        kyktuukasyu = pKykTuukaSyu;
        kykymd = pKykymd;
        syouhncd = pSyouhncd;
        dai1hknkkn = pDai1HknKkn;
        targettkkbn = pTargetTkKbn;
        targettkmokuhyouti = pTargetTkMokuhyouti;
        targettkykkijyungk = new BizCurrencySum(pTargetTkykKijyunGkType, pTargetTkykKijyunGk).toBizCurrency();
        newsyouhncd = pNewSyouhnCd;
        newsyouhnsdno = pNewSyouhnSdNo;
        yendthnkymd = pYendtHnkYmd;
        newkihons = new BizCurrencySum(pNewkihonsType, pNewkihons).toBizCurrency();
        newhokenryou = new BizCurrencySum(pNewHokenRyouType, pNewHokenRyou).toBizCurrency();
        newkyktuukasyu = pNewKykTuukaSyu;
        newryouritusdno = pNewRyouRituSdNo;
        newkaiyakuhr = new BizCurrencySum(pNewKaiyakuHrType, pNewKaiyakuHr).toBizCurrency();
        yendthnkhr = new BizCurrencySum(pYendtHnkHrType, pYendtHnkHr).toBizCurrency();
        yendthnkkaiyakuhrgaika = new BizCurrencySum(pYendtHnkKaiyakuHrGaikaType, pYendtHnkKaiyakuHrGaika).toBizCurrency();
        yendthnkkaiyakuhryen = new BizCurrencySum(pYendtHnkKaiyakuHrYenType, pYendtHnkKaiyakuHrYen).toBizCurrency();
        nyuuryokuhassoukbn = pNyuuryokuHassouKbn;
        hnskariyuu1 = pHnskaRiyuu1;
        hnskariyuu2 = pHnskaRiyuu2;
        mkhgktttymd = pMkhGkTttYmd;
        mkhgktttkaiyakuhr = new BizCurrencySum(pMkhGkTttKaiyakuHrType, pMkhGkTttKaiyakuHr).toBizCurrency();
        yendthnkjikwsrate = pYendtHnkjiKwsRate;
        syoruiukeymd = pSyoruiukeymd;
        newtumitateriritu = pNewtumitateriritu;
        newyoteiriritu = pNewyoteiriritu;
        kkkyktdk = pKkkyktdk;
        kyknmkn = pKykNmKn;
        kyknmkj = pKykNmKj;
        tsinyno = pTsinYNo;
        tsinadr1kj = pTsinAdr1Kj;
        tsinadr2kj = pTsinAdr2Kj;
        tsinadr3kj = pTsinAdr3Kj;
        mousideikoukbn = pMousideikoukbn;
        hrkp = new BizCurrencySum(pHrkpType, pHrkp).toBizCurrency();
        haitounendo = pHaitounendo;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

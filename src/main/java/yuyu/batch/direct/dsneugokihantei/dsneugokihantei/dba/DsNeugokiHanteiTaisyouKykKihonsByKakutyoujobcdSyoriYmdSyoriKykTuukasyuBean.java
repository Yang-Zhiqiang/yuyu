package yuyu.batch.direct.dsneugokihantei.dsneugokihantei.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * ＤＳ値動き判定対象契約基本情報Beanクラス<br />
 */
public class DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private C_AisyoumeiKbn aisyoumeikbn;

    @Getter @Setter
    private String kyknmkn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private String ryouritusdno;

    @Getter @Setter
    private BizNumber yoteiriritu;

    @Getter @Setter
    private C_HknkknsmnKbn hknkknsmnkbn;

    @Getter @Setter
    private Integer hknkkn;

    @Getter @Setter
    private Integer hrkkkn;

    @Getter @Setter
    private Integer hhknnen;

    @Getter @Setter
    private C_Hhknsei hhknsei;

    @Getter @Setter
    private BizCurrency kihons;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizNumber kyksjkkktyouseiriritu;

    @Getter @Setter
    private BizCurrency gengakugoyenitijibrpstgk;

    @Getter @Setter
    private BizDate yendthnkymd;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private String bosyuujiaatukaidrtencd;

    @Getter @Setter
    private String bosyuujibatukaidrtencd;

    @Getter @Setter
    private BizCurrency rsgaku;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private BizDate ryosyuymd;

    @Getter @Setter
    private C_UmuKbn yennykntkhkumu;

    public DsNeugokiHanteiTaisyouKykKihonsByKakutyoujobcdSyoriYmdSyoriKykTuukasyuBean(String pKbnkey,
        String pSyono,
        C_Hrkkaisuu pHrkkaisuu,
        C_AisyoumeiKbn pAisyoumeikbn,
        String pKyknmkn,
        BizDate pKykymd,
        String pSyouhncd,
        Integer pSyouhnsdno,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
        C_HknkknsmnKbn pHknkknsmnkbn,
        Integer pHknkkn,
        Integer pHrkkkn,
        Integer pHhknnen,
        C_Hhknsei pHhknsei,
        String pKihonsType,
        BigDecimal pKihonsValue,
        C_Tuukasyu pKyktuukasyu,
        BizNumber pKyksjkkktyouseiriritu,
        String pGengakugoyenitijibrpstgkType,
        BigDecimal pGengakugoyenitijibrpstgkValue,
        BizDate pYendthnkymd,
        C_Kykjyoutai pKykjyoutai,
        String pBosyuujiaatukaidrtencd,
        String pBosyuujibatukaidrtencd,
        String pRsgakuType,
        BigDecimal pRsgakuValue,
        String pHrkpType,
        BigDecimal pHrkpValue,
        BizDate pRyosyuymd,
        C_UmuKbn pYennykntkhkumu
        ) {

        kbnkey = pKbnkey;
        syono = pSyono;
        hrkkaisuu = pHrkkaisuu;
        aisyoumeikbn = pAisyoumeikbn;
        kyknmkn = pKyknmkn;
        kykymd = pKykymd;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        ryouritusdno = pRyouritusdno;
        yoteiriritu = pYoteiriritu;
        hknkknsmnkbn = pHknkknsmnkbn;
        hknkkn = pHknkkn;
        hrkkkn = pHrkkkn;
        hhknnen = pHhknnen;
        hhknsei = pHhknsei;
        kihons = new BizCurrencySum(pKihonsType, pKihonsValue).toBizCurrency();
        kyktuukasyu = pKyktuukasyu;
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
        gengakugoyenitijibrpstgk = new BizCurrencySum(pGengakugoyenitijibrpstgkType,
            pGengakugoyenitijibrpstgkValue).toBizCurrency();
        yendthnkymd = pYendthnkymd;
        kykjyoutai=pKykjyoutai;
        bosyuujiaatukaidrtencd = pBosyuujiaatukaidrtencd;
        bosyuujibatukaidrtencd = pBosyuujibatukaidrtencd;
        rsgaku = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        ryosyuymd = pRyosyuymd;
        yennykntkhkumu = pYennykntkhkumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}

package yuyu.batch.hozen.khozen.khmkhgktttyendthnksel.dba;

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
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;

/**
 * 契約保全 契約保全 到達判定対象契約Beanクラス
 */
public class KhTttHntiKykBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private BizDateY haitounendo;

    @Getter @Setter
    private C_Sdpd sdpdkbn;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

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
    private BizCurrency hokenryou;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private BizNumber kyksjkkktyouseiriritu;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    @Getter @Setter
    private BizCurrency gengakugoyenitijibrpstgk;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private Integer dai1hknkkn;

    @Getter @Setter
    private C_UmuKbn kwsttkhukaumu;

    @Getter @Setter
    private BizCurrency targettkykkijyungk;

    @Getter @Setter
    private Integer targettkmokuhyouti;

    @Getter @Setter
    private Integer mvatekikkn;

    @Getter @Setter
    private String yendthnksyouhncd;

    @Getter @Setter
    private C_UmuKbn kaiyakukoujyoritutekiumu;

    public KhTttHntiKykBean(String pKbnkey,
        String pSyono,
        C_Hrkkaisuu pHrkkaisuu,
        BizDateY pHaitounendo,
        C_Sdpd pSdpdkbn,
        C_Hrkkeiro pHrkkeiro,
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
        BigDecimal pKihons,
        String pHokenryouType,
        BigDecimal pHokenryou,
        BizDate pKykymd,
        BizNumber pKyksjkkktyouseiriritu,
        C_Tuukasyu pKyktuukasyu,
        C_YuukousyoumetuKbn pYuukousyoumetukbn,
        String pGengakugoyenitijibrpstgkType,
        BigDecimal pGengakugoyenitijibrpstgk,
        C_Kykjyoutai pKykjyoutai,
        Integer pDai1hknkkn,
        C_UmuKbn pKwsttkhukaumu,
        String pTargettkykkijyungkType,
        BigDecimal pTargettkykkijyungk,
        Integer pTargettkmokuhyouti,
        Integer pMvatekikkn,
        String pYendthnksyouhncd,
        C_UmuKbn pKaiyakukoujyoritutekiumu) {

        kbnkey = pKbnkey;
        syono = pSyono;
        hrkkaisuu = pHrkkaisuu;
        haitounendo = pHaitounendo;
        sdpdkbn = pSdpdkbn;
        hrkkeiro = pHrkkeiro;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        ryouritusdno = pRyouritusdno;
        yoteiriritu = pYoteiriritu;
        hknkknsmnkbn = pHknkknsmnkbn;
        hknkkn = pHknkkn;
        hrkkkn = pHrkkkn;
        hhknnen = pHhknnen;
        hhknsei = pHhknsei;
        kihons = new BizCurrencySum(pKihonsType, pKihons).toBizCurrency();
        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryou).toBizCurrency();
        kykymd = pKykymd;
        kyksjkkktyouseiriritu = pKyksjkkktyouseiriritu;
        kyktuukasyu = pKyktuukasyu;
        yuukousyoumetukbn = pYuukousyoumetukbn;
        gengakugoyenitijibrpstgk = new BizCurrencySum(pGengakugoyenitijibrpstgkType, pGengakugoyenitijibrpstgk).toBizCurrency();
        kwsttkhukaumu = pKwsttkhukaumu;
        kykjyoutai = pKykjyoutai;
        dai1hknkkn = pDai1hknkkn;
        targettkykkijyungk = new BizCurrencySum(pTargettkykkijyungkType, pTargettkykkijyungk).toBizCurrency();
        targettkmokuhyouti = pTargettkmokuhyouti;
        mvatekikkn = pMvatekikkn;
        yendthnksyouhncd = pYendthnksyouhncd;
        kaiyakukoujyoritutekiumu = pKaiyakukoujyoritutekiumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

package yuyu.batch.hozen.khozen.khdseisan.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全 精算ＤBeanクラス
 */
public class KhDSeisanBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private C_StknsetKbn stknsetkbn;

    @Getter @Setter
    private BizDateY haitounendo;

    @Getter @Setter
    private String tsinyno;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private String henkousikibetukey;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private String ryouritusdno;

    @Getter @Setter
    private BizNumber yoteiriritu;

    @Getter @Setter
    private C_Hhknsei hhknsei;

    @Getter @Setter
    private Integer hhknnen;

    @Getter @Setter
    private C_HknkknsmnKbn hknkknsmnkbn;

    @Getter @Setter
    private Integer hknkkn;

    @Getter @Setter
    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Getter @Setter
    private Integer hrkkkn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private BizDate yendthnkymd;

    @Getter @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter @Setter
    private BizCurrency kihons;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private BizDate syoumetuymd;

    @Getter @Setter
    private C_Syoumetujiyuu syoumetujiyuu;

    @Getter @Setter
    private Integer dai1hknkkn;

    @Getter @Setter
    private BizDateYM jkipjytym;

    public KhDSeisanBean(String pKbnkey,
        String pSyono,
        C_Hrkkaisuu pHrkkaisuu,
        C_StknsetKbn pStknsetkbn,
        BizDateY pHaitounendo,
        String pTsinyno,
        String pKyknmkj,
        String pHenkousikibetukey,
        String pSyouhncd,
        Integer pSyouhnsdno,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
        C_Hhknsei pHhknsei,
        Integer pHhknnen,
        C_HknkknsmnKbn pHknkknsmnkbn,
        Integer pHknkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        Integer pHrkkkn,
        BizDate pKykymd,
        BizDate pYendthnkymd,
        C_Tuukasyu pKyktuukasyu,
        String pKihonsType,
        BigDecimal pKihonsValue,
        C_Kykjyoutai pKykjyoutai,
        BizDate pSyoumetuymd,
        C_Syoumetujiyuu pSyoumetujiyuu,
        Integer pDai1hknkkn,
        BizDateYM pJkipjytym) {

        kbnkey = pKbnkey;
        syono = pSyono;
        hrkkaisuu = pHrkkaisuu;
        stknsetkbn = pStknsetkbn;
        haitounendo = pHaitounendo;
        tsinyno = pTsinyno;
        kyknmkj = pKyknmkj;
        henkousikibetukey = pHenkousikibetukey;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        ryouritusdno = pRyouritusdno;
        yoteiriritu = pYoteiriritu;
        hhknsei = pHhknsei;
        hhknnen =pHhknnen;
        hknkknsmnkbn = pHknkknsmnkbn;
        hknkkn = pHknkkn;
        hrkkknsmnkbn = pHrkkknsmnkbn;
        hrkkkn = pHrkkkn;
        kykymd = pKykymd;
        yendthnkymd = pYendthnkymd;
        kyktuukasyu = pKyktuukasyu;
        kihons = new BizCurrencySum(pKihonsType, pKihonsValue).toBizCurrency();
        kykjyoutai = pKykjyoutai;
        syoumetuymd = pSyoumetuymd;
        syoumetujiyuu = pSyoumetujiyuu;
        dai1hknkkn = pDai1hknkkn;
        jkipjytym = pJkipjytym;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

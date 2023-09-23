package yuyu.common.hozen.khcommon.dba4keisanwext;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 共通 解約返戻金計算用契約情報Bean
 */
public class KeisanWKykInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syouhnCd;

    @Getter @Setter
    private Integer syouhnSdNo;

    @Getter @Setter
    private String ryourituSdNo;

    @Getter @Setter
    private BizNumber yoteiRiritu;

    @Getter @Setter
    private C_Hrkkaisuu hrkKaisuu;

    @Getter @Setter
    private BizDate fstPNyknYmd;

    @Getter @Setter
    private C_HknkknsmnKbn hknkknsmnkbn;

    @Getter @Setter
    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Getter @Setter
    private Integer hrkKkn;

    @Getter @Setter
    private Integer hknKkn;

    @Getter @Setter
    private Integer hhkNnen;

    @Getter @Setter
    private C_Hhknsei hhknSei;

    @Getter @Setter
    private BizCurrency kihonS;

    @Getter @Setter
    private BizCurrency hokenRyou;

    @Getter @Setter
    private BizDate kykYmd;

    @Getter @Setter
    private C_Tuukasyu kykTuukasyu;

    @Getter @Setter
    private BizNumber kyksjkKkTyouseiRiritu;

    @Getter @Setter
    private BizNumber tumitateRiritu;

    @Getter @Setter
    private BizNumber yoteirrtHendoHosyuRrt;

    @Getter @Setter
    private BizDate yendthnkYmd;

    @Getter @Setter
    private int dai1hknkkn;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private C_UmuKbn mvaTekiumu;

    @Getter @Setter
    private BizDateYM jkipjytYm;

    @Getter @Setter
    private C_UmuKbn teikishrtkykhukaumu;

    public KeisanWKykInfoBean() {
    }


    public KeisanWKykInfoBean(String pSyouhncd,
        Integer pSyouhnsdno,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
        C_Hrkkaisuu pHrkkaisuu,
        BizDate pFstPNyknYmd,
        C_HknkknsmnKbn pHknkknsmnkbn,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        Integer pHrkkkn,
        Integer pHknkkn,
        Integer pHhknnen,
        C_Hhknsei pHhknsei,
        String pKihonsType,
        BigDecimal pKihonsValue,
        String pHokenryouType,
        BigDecimal pHokenryouValue,
        BizDate pKykymd,
        C_Tuukasyu pKyktuukasyu,
        BizNumber pKyksjkkktyouseiriritu,
        BizNumber pTumitateriritu,
        BizNumber pYoteirrtHendoHosyuRrt,
        BizDate pYendthnkYmd,
        int pDai1hknkkn,
        C_Kykjyoutai pKykjyoutai,
        C_UmuKbn pMvatekiumu,
        BizDateYM pJkipjytYm,
        C_UmuKbn pTeikishrtkykhukaumu) {

        syouhnCd = pSyouhncd;
        syouhnSdNo = pSyouhnsdno;
        ryourituSdNo = pRyouritusdno;
        yoteiRiritu = pYoteiriritu;
        hrkKaisuu = pHrkkaisuu;
        fstPNyknYmd = pFstPNyknYmd;
        hknkknsmnkbn = pHknkknsmnkbn;
        hrkkknsmnkbn = pHrkkknsmnkbn;
        hrkKkn = pHrkkkn;
        hknKkn = pHknkkn;
        hhkNnen = pHhknnen;
        hhknSei = pHhknsei;
        kihonS = new BizCurrencySum(pKihonsType, pKihonsValue).toBizCurrency();
        hokenRyou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
        kykYmd = pKykymd;
        kykTuukasyu = pKyktuukasyu;
        kyksjkKkTyouseiRiritu = pKyksjkkktyouseiriritu;
        tumitateRiritu = pTumitateriritu;
        yoteirrtHendoHosyuRrt = pYoteirrtHendoHosyuRrt;
        yendthnkYmd = pYendthnkYmd;
        dai1hknkkn = pDai1hknkkn;
        kykjyoutai = pKykjyoutai;
        mvaTekiumu = pMvatekiumu;
        jkipjytYm = pJkipjytYm;
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

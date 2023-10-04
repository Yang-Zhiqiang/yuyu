package yuyu.batch.hozen.khozen.khdhaneisel.dba;

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
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全 配当金反映対象Beanクラス
 */
public class HaitoukinHanneiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private C_HaitoukinuketorihouKbn haitoukinUketorihouKbn;

    @Getter @Setter
    private C_Hrkkaisuu hrkKaisuu;

    @Getter @Setter
    private BizDateY haitouNendo;

    @Getter @Setter
    private BizCurrency kihonS;

    @Getter @Setter
    private String syouhnCd;

    @Getter @Setter
    private String ryourituSdNo;

    @Getter @Setter
    private BizNumber yoteiRiritu;

    @Getter @Setter
    private C_Hhknsei hhknSei;

    @Getter @Setter
    private Integer hhknNen;

    @Getter @Setter
    private C_HknkknsmnKbn hknkknSmnKbn;

    @Getter @Setter
    private Integer hknKkn;

    @Getter @Setter
    private Integer hrkKkn;

    @Getter @Setter
    private BizDate kykYmd;

    @Getter @Setter
    private C_Tuukasyu tuukaSyu;

    @Getter @Setter
    private BizDate yendthnkYmd;

    @Getter @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter @Setter
    private C_HrkkknsmnKbn hrkkknsmnkbn;

    @Getter @Setter
    private Integer dai1hknkkn;

    @Getter @Setter
    private C_HaitouKbn haitouKbn;

    public HaitoukinHanneiBean(String pKbnkey,
        String pSyono,
        C_HaitoukinuketorihouKbn pHaitoukinUketorihouKbn,
        C_Hrkkaisuu pHrkKaisuu,
        BizDateY pHaitouNendo,
        String pKihonSType,
        BigDecimal pKihonSValue,
        String pSyouhnCd,
        String pRyourituSdNo,
        BizNumber pYoteiRiritu,
        C_Hhknsei pHhknSei,
        Integer pHhknNen,
        C_HknkknsmnKbn pHknkknSmnKbn,
        Integer pHknKkn,
        Integer pHrkKkn,
        BizDate pKykYmd,
        C_Tuukasyu pTuukaSyu,
        BizDate pYendthnkYmd,
        C_Kykjyoutai pKykjyoutai,
        C_HrkkknsmnKbn pHrkkknsmnkbn,
        Integer pDai1hknkkn,
        C_HaitouKbn pHaitouKbn) {

        kbnkey = pKbnkey;
        syono = pSyono;
        haitoukinUketorihouKbn = pHaitoukinUketorihouKbn;
        hrkKaisuu = pHrkKaisuu;
        haitouNendo = pHaitouNendo;
        kihonS = new BizCurrencySum(pKihonSType, pKihonSValue).toBizCurrency();
        syouhnCd = pSyouhnCd;
        ryourituSdNo = pRyourituSdNo;
        yoteiRiritu = pYoteiRiritu;
        hhknSei = pHhknSei;
        hhknNen = pHhknNen;
        hknkknSmnKbn = pHknkknSmnKbn;
        hknKkn =pHknKkn;
        hrkKkn = pHrkKkn;
        kykYmd = pKykYmd;
        tuukaSyu = pTuukaSyu;
        yendthnkYmd = pYendthnkYmd;
        kykjyoutai = pKykjyoutai;
        hrkkknsmnkbn = pHrkkknsmnkbn;
        dai1hknkkn = pDai1hknkkn;
        haitouKbn = pHaitouKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

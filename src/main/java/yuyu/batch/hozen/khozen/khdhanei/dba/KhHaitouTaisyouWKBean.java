package yuyu.batch.hozen.khozen.khdhanei.dba;

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
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全 配当金算出対象抽出ワークBean
 */
public class KhHaitouTaisyouWKBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private C_HaitoumeisaiKbn haitouMeisaiKbn;

    @Getter
    @Setter
    private C_HaitoujyoutaiHanteiKbn haitouJyoutaiHanteiKbn;

    @Getter
    @Setter
    private BizDate haitoushrKijyunYmd;

    @Getter
    @Setter
    private C_HaitouKbn haitouKbn;

    @Getter
    @Setter
    private BizCurrency kihonS;

    @Getter
    @Setter
    private Integer haitouKaisuu;

    @Getter
    @Setter
    private String syouhnCd;

    @Getter
    @Setter
    private String ryourituSdno;

    @Getter
    @Setter
    private BizNumber yoteiRiritu;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkKaisuu;

    @Getter
    @Setter
    private C_Hhknsei hhknSei;

    @Getter
    @Setter
    private Integer hhknNen;

    @Getter
    @Setter
    private C_HknkknsmnKbn hknKknSmnKbn;

    @Getter
    @Setter
    private Integer hknKkn;

    @Getter
    @Setter
    private Integer hrkKkn;

    @Getter
    @Setter
    private BizDateY dRateNendo;

    @Getter
    @Setter
    private BizDateY keisanDNendo;

    @Getter
    @Setter
    private C_Tuukasyu tuukasyu;

    @Getter
    @Setter
    private BizDate kykymd;

    @Getter
    @Setter
    private C_Kykjyoutai kykjyoutai;

    @Getter
    @Setter
    private Integer dai1hknkkn;

    @Getter
    @Setter
    private C_HrkkknsmnKbn hrkkknsmnkbn;

    public KhHaitouTaisyouWKBean(String pKbnkey,
        String pSyono,
        C_HaitoumeisaiKbn pHaitouMeisaiKbn,
        C_HaitoujyoutaiHanteiKbn pHaitouJyoutaiHanteiKbn,
        BizDate pHaitoushrKijyunYmd,
        C_HaitouKbn pHaitouKbn,
        String pKihonSType,
        BigDecimal pKihonS,
        Integer pHaitouKaisuu,
        String pSyouhnCd,
        String pRyourituSdno,
        BizNumber pYoteiRiritu,
        C_Hrkkaisuu pHrkKaisuu,
        C_Hhknsei pHhknSei,
        Integer pHhknNen,
        C_HknkknsmnKbn pHknKknSmnKbn,
        Integer pHknKkn,
        Integer pHrkKkn,
        BizDateY pDRateNendo,
        BizDateY pKeisanDNendo,
        C_Tuukasyu pTuukasyu,
        BizDate pKykymd,
        C_Kykjyoutai pKykjyoutai,
        Integer pDai1hknkkn,
        C_HrkkknsmnKbn pHrkkknsmnkbn) {

        kbnkey = pKbnkey;
        syono = pSyono;
        haitouMeisaiKbn = pHaitouMeisaiKbn;
        haitouJyoutaiHanteiKbn = pHaitouJyoutaiHanteiKbn;
        haitoushrKijyunYmd = pHaitoushrKijyunYmd;
        haitouKbn = pHaitouKbn;
        kihonS = new BizCurrencySum(pKihonSType, pKihonS).toBizCurrency();
        haitouKaisuu = pHaitouKaisuu;
        syouhnCd = pSyouhnCd;
        ryourituSdno = pRyourituSdno;
        yoteiRiritu = pYoteiRiritu;
        hrkKaisuu = pHrkKaisuu;
        hhknSei = pHhknSei;
        hhknNen = pHhknNen;
        hknKknSmnKbn = pHknKknSmnKbn;
        hknKkn = pHknKkn;
        hrkKkn = pHrkKkn;
        dRateNendo = pDRateNendo;
        keisanDNendo = pKeisanDNendo;
        tuukasyu = pTuukasyu;
        kykymd = pKykymd;
        kykjyoutai = pKykjyoutai;
        dai1hknkkn = pDai1hknkkn;
        hrkkknsmnkbn = pHrkkknsmnkbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}

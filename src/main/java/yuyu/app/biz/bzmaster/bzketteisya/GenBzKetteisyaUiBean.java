package yuyu.app.biz.bzmaster.bzketteisya;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 決定者登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzKetteisyaUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=15)
    @AlphaDigit
    private String ketsyacd;

    public String getKetsyacd() {
        return ketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetsyacd(String pKetsyacd) {
        ketsyacd = pKetsyacd;
    }

    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    private String palketsyacd;

    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String ketsyanm;

    public String getKetsyanm() {
        return ketsyanm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKetsyanm(String pKetsyanm) {
        ketsyanm = pKetsyanm;
    }

    private C_MostenkenRankKbn mostenkenrankkbn;

    public C_MostenkenRankKbn getMostenkenrankkbn() {
        return mostenkenrankkbn;
    }

    public void setMostenkenrankkbn(C_MostenkenRankKbn pMostenkenrankkbn) {
        mostenkenrankkbn = pMostenkenrankkbn;
    }

    private C_KnksateirankKbn knksateirankkbn;

    public C_KnksateirankKbn getKnksateirankkbn() {
        return knksateirankkbn;
    }

    public void setKnksateirankkbn(C_KnksateirankKbn pKnksateirankkbn) {
        knksateirankkbn = pKnksateirankkbn;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency knksateijygns;

    public BizCurrency getKnksateijygns() {
        return knksateijygns;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKnksateijygns(BizCurrency pKnksateijygns) {
        knksateijygns = pKnksateijygns;
    }

    private C_ImusateirankKbn imusateirankkbn;

    public C_ImusateirankKbn getImusateirankkbn() {
        return imusateirankkbn;
    }

    public void setImusateirankkbn(C_ImusateirankKbn pImusateirankkbn) {
        imusateirankkbn = pImusateirankkbn;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency imusateijygns;

    public BizCurrency getImusateijygns() {
        return imusateijygns;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setImusateijygns(BizCurrency pImusateijygns) {
        imusateijygns = pImusateijygns;
    }
}
